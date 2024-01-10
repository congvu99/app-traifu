package org.jsoup.parser;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.appevents.UserDataStore;
import com.facebook.appevents.integrity.IntegrityManager;
import com.facebook.common.callercontext.ContextChain;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.share.internal.ShareConstants;
import com.github.scribejava.core.model.OAuthConstants;
import com.google.firebase.messaging.Constants;
import io.intercom.android.sdk.metrics.MetricTracker;
import java.util.ArrayList;
import java.util.Iterator;
import org.jsoup.helper.StringUtil;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.DocumentType;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.FormElement;
import org.jsoup.nodes.Node;
import org.jsoup.parser.Token;

enum HtmlTreeBuilderState {
    Initial {
        /* access modifiers changed from: package-private */
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (HtmlTreeBuilderState.isWhitespace(token)) {
                return true;
            }
            if (token.isComment()) {
                htmlTreeBuilder.insert(token.asComment());
            } else if (token.isDoctype()) {
                Token.Doctype asDoctype = token.asDoctype();
                htmlTreeBuilder.getDocument().appendChild(new DocumentType(asDoctype.getName(), asDoctype.getPublicIdentifier(), asDoctype.getSystemIdentifier(), htmlTreeBuilder.getBaseUri()));
                if (asDoctype.isForceQuirks()) {
                    htmlTreeBuilder.getDocument().quirksMode(Document.QuirksMode.quirks);
                }
                htmlTreeBuilder.transition(BeforeHtml);
            } else {
                htmlTreeBuilder.transition(BeforeHtml);
                return htmlTreeBuilder.process(token);
            }
            return true;
        }
    },
    BeforeHtml {
        /* access modifiers changed from: package-private */
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.isDoctype()) {
                htmlTreeBuilder.error(this);
                return false;
            }
            if (token.isComment()) {
                htmlTreeBuilder.insert(token.asComment());
            } else if (HtmlTreeBuilderState.isWhitespace(token)) {
                return true;
            } else {
                if (token.isStartTag() && token.asStartTag().name().equals("html")) {
                    htmlTreeBuilder.insert(token.asStartTag());
                    htmlTreeBuilder.transition(BeforeHead);
                } else if (token.isEndTag() && StringUtil.in(token.asEndTag().name(), "head", SDKConstants.PARAM_A2U_BODY, "html", "br")) {
                    return anythingElse(token, htmlTreeBuilder);
                } else {
                    if (!token.isEndTag()) {
                        return anythingElse(token, htmlTreeBuilder);
                    }
                    htmlTreeBuilder.error(this);
                    return false;
                }
            }
            return true;
        }

        private boolean anythingElse(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            htmlTreeBuilder.insertStartTag("html");
            htmlTreeBuilder.transition(BeforeHead);
            return htmlTreeBuilder.process(token);
        }
    },
    BeforeHead {
        /* access modifiers changed from: package-private */
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (HtmlTreeBuilderState.isWhitespace(token)) {
                return true;
            }
            if (token.isComment()) {
                htmlTreeBuilder.insert(token.asComment());
            } else if (token.isDoctype()) {
                htmlTreeBuilder.error(this);
                return false;
            } else if (token.isStartTag() && token.asStartTag().name().equals("html")) {
                return InBody.process(token, htmlTreeBuilder);
            } else {
                if (token.isStartTag() && token.asStartTag().name().equals("head")) {
                    htmlTreeBuilder.setHeadElement(htmlTreeBuilder.insert(token.asStartTag()));
                    htmlTreeBuilder.transition(InHead);
                } else if (token.isEndTag() && StringUtil.in(token.asEndTag().name(), "head", SDKConstants.PARAM_A2U_BODY, "html", "br")) {
                    htmlTreeBuilder.processStartTag("head");
                    return htmlTreeBuilder.process(token);
                } else if (token.isEndTag()) {
                    htmlTreeBuilder.error(this);
                    return false;
                } else {
                    htmlTreeBuilder.processStartTag("head");
                    return htmlTreeBuilder.process(token);
                }
            }
            return true;
        }
    },
    InHead {
        /* access modifiers changed from: package-private */
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (HtmlTreeBuilderState.isWhitespace(token)) {
                htmlTreeBuilder.insert(token.asCharacter());
                return true;
            }
            int i = AnonymousClass24.$SwitchMap$org$jsoup$parser$Token$TokenType[token.type.ordinal()];
            if (i == 1) {
                htmlTreeBuilder.insert(token.asComment());
            } else if (i == 2) {
                htmlTreeBuilder.error(this);
                return false;
            } else if (i == 3) {
                Token.StartTag asStartTag = token.asStartTag();
                String name = asStartTag.name();
                if (name.equals("html")) {
                    return InBody.process(token, htmlTreeBuilder);
                }
                if (StringUtil.in(name, "base", "basefont", "bgsound", "command", "link")) {
                    Element insertEmpty = htmlTreeBuilder.insertEmpty(asStartTag);
                    if (name.equals("base") && insertEmpty.hasAttr(ShareConstants.WEB_DIALOG_PARAM_HREF)) {
                        htmlTreeBuilder.maybeSetBaseUri(insertEmpty);
                    }
                } else if (name.equals("meta")) {
                    htmlTreeBuilder.insertEmpty(asStartTag);
                } else if (name.equals("title")) {
                    HtmlTreeBuilderState.handleRcData(asStartTag, htmlTreeBuilder);
                } else if (StringUtil.in(name, "noframes", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE)) {
                    HtmlTreeBuilderState.handleRawtext(asStartTag, htmlTreeBuilder);
                } else if (name.equals("noscript")) {
                    htmlTreeBuilder.insert(asStartTag);
                    htmlTreeBuilder.transition(InHeadNoscript);
                } else if (name.equals("script")) {
                    htmlTreeBuilder.tokeniser.transition(TokeniserState.ScriptData);
                    htmlTreeBuilder.markInsertionMode();
                    htmlTreeBuilder.transition(Text);
                    htmlTreeBuilder.insert(asStartTag);
                } else if (!name.equals("head")) {
                    return anythingElse(token, htmlTreeBuilder);
                } else {
                    htmlTreeBuilder.error(this);
                    return false;
                }
            } else if (i != 4) {
                return anythingElse(token, htmlTreeBuilder);
            } else {
                String name2 = token.asEndTag().name();
                if (name2.equals("head")) {
                    htmlTreeBuilder.pop();
                    htmlTreeBuilder.transition(AfterHead);
                } else if (StringUtil.in(name2, SDKConstants.PARAM_A2U_BODY, "html", "br")) {
                    return anythingElse(token, htmlTreeBuilder);
                } else {
                    htmlTreeBuilder.error(this);
                    return false;
                }
            }
            return true;
        }

        private boolean anythingElse(Token token, TreeBuilder treeBuilder) {
            treeBuilder.processEndTag("head");
            return treeBuilder.process(token);
        }
    },
    InHeadNoscript {
        /* access modifiers changed from: package-private */
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.isDoctype()) {
                htmlTreeBuilder.error(this);
                return true;
            } else if (token.isStartTag() && token.asStartTag().name().equals("html")) {
                return htmlTreeBuilder.process(token, InBody);
            } else {
                if (token.isEndTag() && token.asEndTag().name().equals("noscript")) {
                    htmlTreeBuilder.pop();
                    htmlTreeBuilder.transition(InHead);
                    return true;
                } else if (HtmlTreeBuilderState.isWhitespace(token) || token.isComment() || (token.isStartTag() && StringUtil.in(token.asStartTag().name(), "basefont", "bgsound", "link", "meta", "noframes", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE))) {
                    return htmlTreeBuilder.process(token, InHead);
                } else {
                    if (token.isEndTag() && token.asEndTag().name().equals("br")) {
                        return anythingElse(token, htmlTreeBuilder);
                    }
                    if ((!token.isStartTag() || !StringUtil.in(token.asStartTag().name(), "head", "noscript")) && !token.isEndTag()) {
                        return anythingElse(token, htmlTreeBuilder);
                    }
                    htmlTreeBuilder.error(this);
                    return false;
                }
            }
        }

        private boolean anythingElse(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            htmlTreeBuilder.error(this);
            htmlTreeBuilder.insert(new Token.Character().data(token.toString()));
            return true;
        }
    },
    AfterHead {
        /* access modifiers changed from: package-private */
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            Token token2 = token;
            HtmlTreeBuilder htmlTreeBuilder2 = htmlTreeBuilder;
            if (HtmlTreeBuilderState.isWhitespace(token)) {
                htmlTreeBuilder2.insert(token.asCharacter());
                return true;
            } else if (token.isComment()) {
                htmlTreeBuilder2.insert(token.asComment());
                return true;
            } else if (token.isDoctype()) {
                htmlTreeBuilder2.error(this);
                return true;
            } else if (token.isStartTag()) {
                Token.StartTag asStartTag = token.asStartTag();
                String name = asStartTag.name();
                if (name.equals("html")) {
                    return htmlTreeBuilder2.process(token2, InBody);
                }
                if (name.equals(SDKConstants.PARAM_A2U_BODY)) {
                    htmlTreeBuilder2.insert(asStartTag);
                    htmlTreeBuilder2.framesetOk(false);
                    htmlTreeBuilder2.transition(InBody);
                    return true;
                } else if (name.equals("frameset")) {
                    htmlTreeBuilder2.insert(asStartTag);
                    htmlTreeBuilder2.transition(InFrameset);
                    return true;
                } else if (StringUtil.in(name, "base", "basefont", "bgsound", "link", "meta", "noframes", "script", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "title")) {
                    htmlTreeBuilder2.error(this);
                    Element headElement = htmlTreeBuilder.getHeadElement();
                    htmlTreeBuilder2.push(headElement);
                    htmlTreeBuilder2.process(token2, InHead);
                    htmlTreeBuilder2.removeFromStack(headElement);
                    return true;
                } else if (name.equals("head")) {
                    htmlTreeBuilder2.error(this);
                    return false;
                } else {
                    anythingElse(token, htmlTreeBuilder);
                    return true;
                }
            } else if (!token.isEndTag()) {
                anythingElse(token, htmlTreeBuilder);
                return true;
            } else if (StringUtil.in(token.asEndTag().name(), SDKConstants.PARAM_A2U_BODY, "html")) {
                anythingElse(token, htmlTreeBuilder);
                return true;
            } else {
                htmlTreeBuilder2.error(this);
                return false;
            }
        }

        private boolean anythingElse(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            htmlTreeBuilder.processStartTag(SDKConstants.PARAM_A2U_BODY);
            htmlTreeBuilder.framesetOk(true);
            return htmlTreeBuilder.process(token);
        }
    },
    InBody {
        /* access modifiers changed from: package-private */
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            Element element;
            Token token2 = token;
            HtmlTreeBuilder htmlTreeBuilder2 = htmlTreeBuilder;
            int i = AnonymousClass24.$SwitchMap$org$jsoup$parser$Token$TokenType[token2.type.ordinal()];
            boolean z = true;
            if (i == 1) {
                htmlTreeBuilder2.insert(token.asComment());
            } else if (i == 2) {
                htmlTreeBuilder2.error(this);
                return false;
            } else if (i == 3) {
                Token.StartTag asStartTag = token.asStartTag();
                String name = asStartTag.name();
                if (name.equals("a")) {
                    if (htmlTreeBuilder2.getActiveFormattingElement("a") != null) {
                        htmlTreeBuilder2.error(this);
                        htmlTreeBuilder2.processEndTag("a");
                        Element fromStack = htmlTreeBuilder2.getFromStack("a");
                        if (fromStack != null) {
                            htmlTreeBuilder2.removeFromActiveFormattingElements(fromStack);
                            htmlTreeBuilder2.removeFromStack(fromStack);
                        }
                    }
                    htmlTreeBuilder.reconstructFormattingElements();
                    htmlTreeBuilder2.pushActiveFormattingElements(htmlTreeBuilder2.insert(asStartTag));
                } else if (StringUtil.inSorted(name, Constants.InBodyStartEmptyFormatters)) {
                    htmlTreeBuilder.reconstructFormattingElements();
                    htmlTreeBuilder2.insertEmpty(asStartTag);
                    htmlTreeBuilder2.framesetOk(false);
                } else if (StringUtil.inSorted(name, Constants.InBodyStartPClosers)) {
                    if (htmlTreeBuilder2.inButtonScope(ContextChain.TAG_PRODUCT)) {
                        htmlTreeBuilder2.processEndTag(ContextChain.TAG_PRODUCT);
                    }
                    htmlTreeBuilder2.insert(asStartTag);
                } else if (name.equals("span")) {
                    htmlTreeBuilder.reconstructFormattingElements();
                    htmlTreeBuilder2.insert(asStartTag);
                } else if (name.equals("li")) {
                    htmlTreeBuilder2.framesetOk(false);
                    ArrayList<Element> stack = htmlTreeBuilder.getStack();
                    int size = stack.size() - 1;
                    while (true) {
                        if (size <= 0) {
                            break;
                        }
                        Element element2 = stack.get(size);
                        if (!element2.nodeName().equals("li")) {
                            if (htmlTreeBuilder2.isSpecial(element2) && !StringUtil.inSorted(element2.nodeName(), Constants.InBodyStartLiBreakers)) {
                                break;
                            }
                            size--;
                        } else {
                            htmlTreeBuilder2.processEndTag("li");
                            break;
                        }
                    }
                    if (htmlTreeBuilder2.inButtonScope(ContextChain.TAG_PRODUCT)) {
                        htmlTreeBuilder2.processEndTag(ContextChain.TAG_PRODUCT);
                    }
                    htmlTreeBuilder2.insert(asStartTag);
                } else if (name.equals("html")) {
                    htmlTreeBuilder2.error(this);
                    Element element3 = htmlTreeBuilder.getStack().get(0);
                    Iterator<Attribute> it = asStartTag.getAttributes().iterator();
                    while (it.hasNext()) {
                        Attribute next = it.next();
                        if (!element3.hasAttr(next.getKey())) {
                            element3.attributes().put(next);
                        }
                    }
                } else if (StringUtil.inSorted(name, Constants.InBodyStartToHead)) {
                    return htmlTreeBuilder2.process(token2, InHead);
                } else {
                    if (name.equals(SDKConstants.PARAM_A2U_BODY)) {
                        htmlTreeBuilder2.error(this);
                        ArrayList<Element> stack2 = htmlTreeBuilder.getStack();
                        if (stack2.size() == 1 || (stack2.size() > 2 && !stack2.get(1).nodeName().equals(SDKConstants.PARAM_A2U_BODY))) {
                            return false;
                        }
                        htmlTreeBuilder2.framesetOk(false);
                        Element element4 = stack2.get(1);
                        Iterator<Attribute> it2 = asStartTag.getAttributes().iterator();
                        while (it2.hasNext()) {
                            Attribute next2 = it2.next();
                            if (!element4.hasAttr(next2.getKey())) {
                                element4.attributes().put(next2);
                            }
                        }
                    } else if (name.equals("frameset")) {
                        htmlTreeBuilder2.error(this);
                        ArrayList<Element> stack3 = htmlTreeBuilder.getStack();
                        if (stack3.size() == 1 || ((stack3.size() > 2 && !stack3.get(1).nodeName().equals(SDKConstants.PARAM_A2U_BODY)) || !htmlTreeBuilder.framesetOk())) {
                            return false;
                        }
                        Element element5 = stack3.get(1);
                        if (element5.parent() != null) {
                            element5.remove();
                        }
                        for (int i2 = 1; stack3.size() > i2; i2 = 1) {
                            stack3.remove(stack3.size() - i2);
                        }
                        htmlTreeBuilder2.insert(asStartTag);
                        htmlTreeBuilder2.transition(InFrameset);
                    } else if (StringUtil.inSorted(name, Constants.Headings)) {
                        if (htmlTreeBuilder2.inButtonScope(ContextChain.TAG_PRODUCT)) {
                            htmlTreeBuilder2.processEndTag(ContextChain.TAG_PRODUCT);
                        }
                        if (StringUtil.inSorted(htmlTreeBuilder.currentElement().nodeName(), Constants.Headings)) {
                            htmlTreeBuilder2.error(this);
                            htmlTreeBuilder.pop();
                        }
                        htmlTreeBuilder2.insert(asStartTag);
                    } else if (StringUtil.inSorted(name, Constants.InBodyStartPreListing)) {
                        if (htmlTreeBuilder2.inButtonScope(ContextChain.TAG_PRODUCT)) {
                            htmlTreeBuilder2.processEndTag(ContextChain.TAG_PRODUCT);
                        }
                        htmlTreeBuilder2.insert(asStartTag);
                        htmlTreeBuilder2.framesetOk(false);
                    } else if (name.equals("form")) {
                        if (htmlTreeBuilder.getFormElement() != null) {
                            htmlTreeBuilder2.error(this);
                            return false;
                        }
                        if (htmlTreeBuilder2.inButtonScope(ContextChain.TAG_PRODUCT)) {
                            htmlTreeBuilder2.processEndTag(ContextChain.TAG_PRODUCT);
                        }
                        htmlTreeBuilder2.insertForm(asStartTag, true);
                        return true;
                    } else if (StringUtil.inSorted(name, Constants.DdDt)) {
                        htmlTreeBuilder2.framesetOk(false);
                        ArrayList<Element> stack4 = htmlTreeBuilder.getStack();
                        int size2 = stack4.size() - 1;
                        while (true) {
                            if (size2 <= 0) {
                                break;
                            }
                            Element element6 = stack4.get(size2);
                            if (!StringUtil.inSorted(element6.nodeName(), Constants.DdDt)) {
                                if (htmlTreeBuilder2.isSpecial(element6) && !StringUtil.inSorted(element6.nodeName(), Constants.InBodyStartLiBreakers)) {
                                    break;
                                }
                                size2--;
                            } else {
                                htmlTreeBuilder2.processEndTag(element6.nodeName());
                                break;
                            }
                        }
                        if (htmlTreeBuilder2.inButtonScope(ContextChain.TAG_PRODUCT)) {
                            htmlTreeBuilder2.processEndTag(ContextChain.TAG_PRODUCT);
                        }
                        htmlTreeBuilder2.insert(asStartTag);
                    } else if (name.equals("plaintext")) {
                        if (htmlTreeBuilder2.inButtonScope(ContextChain.TAG_PRODUCT)) {
                            htmlTreeBuilder2.processEndTag(ContextChain.TAG_PRODUCT);
                        }
                        htmlTreeBuilder2.insert(asStartTag);
                        htmlTreeBuilder2.tokeniser.transition(TokeniserState.PLAINTEXT);
                    } else if (name.equals("button")) {
                        if (htmlTreeBuilder2.inButtonScope("button")) {
                            htmlTreeBuilder2.error(this);
                            htmlTreeBuilder2.processEndTag("button");
                            htmlTreeBuilder2.process(asStartTag);
                        } else {
                            htmlTreeBuilder.reconstructFormattingElements();
                            htmlTreeBuilder2.insert(asStartTag);
                            htmlTreeBuilder2.framesetOk(false);
                        }
                    } else if (StringUtil.inSorted(name, Constants.Formatters)) {
                        htmlTreeBuilder.reconstructFormattingElements();
                        htmlTreeBuilder2.pushActiveFormattingElements(htmlTreeBuilder2.insert(asStartTag));
                    } else if (name.equals("nobr")) {
                        htmlTreeBuilder.reconstructFormattingElements();
                        if (htmlTreeBuilder2.inScope("nobr")) {
                            htmlTreeBuilder2.error(this);
                            htmlTreeBuilder2.processEndTag("nobr");
                            htmlTreeBuilder.reconstructFormattingElements();
                        }
                        htmlTreeBuilder2.pushActiveFormattingElements(htmlTreeBuilder2.insert(asStartTag));
                    } else if (StringUtil.inSorted(name, Constants.InBodyStartApplets)) {
                        htmlTreeBuilder.reconstructFormattingElements();
                        htmlTreeBuilder2.insert(asStartTag);
                        htmlTreeBuilder.insertMarkerToFormattingElements();
                        htmlTreeBuilder2.framesetOk(false);
                    } else if (name.equals("table")) {
                        if (htmlTreeBuilder.getDocument().quirksMode() != Document.QuirksMode.quirks && htmlTreeBuilder2.inButtonScope(ContextChain.TAG_PRODUCT)) {
                            htmlTreeBuilder2.processEndTag(ContextChain.TAG_PRODUCT);
                        }
                        htmlTreeBuilder2.insert(asStartTag);
                        htmlTreeBuilder2.framesetOk(false);
                        htmlTreeBuilder2.transition(InTable);
                    } else if (name.equals(MetricTracker.Object.INPUT)) {
                        htmlTreeBuilder.reconstructFormattingElements();
                        if (!htmlTreeBuilder2.insertEmpty(asStartTag).attr("type").equalsIgnoreCase(ViewProps.HIDDEN)) {
                            htmlTreeBuilder2.framesetOk(false);
                        }
                    } else if (StringUtil.inSorted(name, Constants.InBodyStartMedia)) {
                        htmlTreeBuilder2.insertEmpty(asStartTag);
                    } else if (name.equals("hr")) {
                        if (htmlTreeBuilder2.inButtonScope(ContextChain.TAG_PRODUCT)) {
                            htmlTreeBuilder2.processEndTag(ContextChain.TAG_PRODUCT);
                        }
                        htmlTreeBuilder2.insertEmpty(asStartTag);
                        htmlTreeBuilder2.framesetOk(false);
                    } else if (name.equals("image")) {
                        if (htmlTreeBuilder2.getFromStack("svg") == null) {
                            return htmlTreeBuilder2.process(asStartTag.name("img"));
                        }
                        htmlTreeBuilder2.insert(asStartTag);
                    } else if (name.equals("isindex")) {
                        htmlTreeBuilder2.error(this);
                        if (htmlTreeBuilder.getFormElement() != null) {
                            return false;
                        }
                        htmlTreeBuilder2.tokeniser.acknowledgeSelfClosingFlag();
                        htmlTreeBuilder2.processStartTag("form");
                        if (asStartTag.attributes.hasKey("action")) {
                            htmlTreeBuilder.getFormElement().attr("action", asStartTag.attributes.get("action"));
                        }
                        htmlTreeBuilder2.processStartTag("hr");
                        htmlTreeBuilder2.processStartTag(Constants.ScionAnalytics.PARAM_LABEL);
                        htmlTreeBuilder2.process(new Token.Character().data(asStartTag.attributes.hasKey("prompt") ? asStartTag.attributes.get("prompt") : "This is a searchable index. Enter search keywords: "));
                        Attributes attributes = new Attributes();
                        Iterator<Attribute> it3 = asStartTag.attributes.iterator();
                        while (it3.hasNext()) {
                            Attribute next3 = it3.next();
                            if (!StringUtil.inSorted(next3.getKey(), Constants.InBodyStartInputAttribs)) {
                                attributes.put(next3);
                            }
                        }
                        attributes.put("name", "isindex");
                        htmlTreeBuilder2.processStartTag(MetricTracker.Object.INPUT, attributes);
                        htmlTreeBuilder2.processEndTag(Constants.ScionAnalytics.PARAM_LABEL);
                        htmlTreeBuilder2.processStartTag("hr");
                        htmlTreeBuilder2.processEndTag("form");
                    } else if (name.equals("textarea")) {
                        htmlTreeBuilder2.insert(asStartTag);
                        htmlTreeBuilder2.tokeniser.transition(TokeniserState.Rcdata);
                        htmlTreeBuilder.markInsertionMode();
                        htmlTreeBuilder2.framesetOk(false);
                        htmlTreeBuilder2.transition(Text);
                    } else if (name.equals("xmp")) {
                        if (htmlTreeBuilder2.inButtonScope(ContextChain.TAG_PRODUCT)) {
                            htmlTreeBuilder2.processEndTag(ContextChain.TAG_PRODUCT);
                        }
                        htmlTreeBuilder.reconstructFormattingElements();
                        htmlTreeBuilder2.framesetOk(false);
                        HtmlTreeBuilderState.handleRawtext(asStartTag, htmlTreeBuilder2);
                    } else if (name.equals("iframe")) {
                        htmlTreeBuilder2.framesetOk(false);
                        HtmlTreeBuilderState.handleRawtext(asStartTag, htmlTreeBuilder2);
                    } else if (name.equals("noembed")) {
                        HtmlTreeBuilderState.handleRawtext(asStartTag, htmlTreeBuilder2);
                    } else if (name.equals("select")) {
                        htmlTreeBuilder.reconstructFormattingElements();
                        htmlTreeBuilder2.insert(asStartTag);
                        htmlTreeBuilder2.framesetOk(false);
                        HtmlTreeBuilderState state = htmlTreeBuilder.state();
                        if (state.equals(InTable) || state.equals(InCaption) || state.equals(InTableBody) || state.equals(InRow) || state.equals(InCell)) {
                            htmlTreeBuilder2.transition(InSelectInTable);
                        } else {
                            htmlTreeBuilder2.transition(InSelect);
                        }
                    } else if (StringUtil.inSorted(name, Constants.InBodyStartOptions)) {
                        if (htmlTreeBuilder.currentElement().nodeName().equals("option")) {
                            htmlTreeBuilder2.processEndTag("option");
                        }
                        htmlTreeBuilder.reconstructFormattingElements();
                        htmlTreeBuilder2.insert(asStartTag);
                    } else if (StringUtil.inSorted(name, Constants.InBodyStartRuby)) {
                        if (htmlTreeBuilder2.inScope("ruby")) {
                            htmlTreeBuilder.generateImpliedEndTags();
                            if (!htmlTreeBuilder.currentElement().nodeName().equals("ruby")) {
                                htmlTreeBuilder2.error(this);
                                htmlTreeBuilder2.popStackToBefore("ruby");
                            }
                            htmlTreeBuilder2.insert(asStartTag);
                        }
                    } else if (name.equals("math")) {
                        htmlTreeBuilder.reconstructFormattingElements();
                        htmlTreeBuilder2.insert(asStartTag);
                        htmlTreeBuilder2.tokeniser.acknowledgeSelfClosingFlag();
                    } else if (name.equals("svg")) {
                        htmlTreeBuilder.reconstructFormattingElements();
                        htmlTreeBuilder2.insert(asStartTag);
                        htmlTreeBuilder2.tokeniser.acknowledgeSelfClosingFlag();
                    } else if (StringUtil.inSorted(name, Constants.InBodyStartDrop)) {
                        htmlTreeBuilder2.error(this);
                        return false;
                    } else {
                        htmlTreeBuilder.reconstructFormattingElements();
                        htmlTreeBuilder2.insert(asStartTag);
                    }
                }
            } else if (i == 4) {
                Token.EndTag asEndTag = token.asEndTag();
                String name2 = asEndTag.name();
                if (StringUtil.inSorted(name2, Constants.InBodyEndAdoptionFormatters)) {
                    int i3 = 0;
                    while (i3 < 8) {
                        Element activeFormattingElement = htmlTreeBuilder2.getActiveFormattingElement(name2);
                        if (activeFormattingElement == null) {
                            return anyOtherEndTag(token, htmlTreeBuilder);
                        }
                        if (!htmlTreeBuilder2.onStack(activeFormattingElement)) {
                            htmlTreeBuilder2.error(this);
                            htmlTreeBuilder2.removeFromActiveFormattingElements(activeFormattingElement);
                            return z;
                        } else if (!htmlTreeBuilder2.inScope(activeFormattingElement.nodeName())) {
                            htmlTreeBuilder2.error(this);
                            return false;
                        } else {
                            if (htmlTreeBuilder.currentElement() != activeFormattingElement) {
                                htmlTreeBuilder2.error(this);
                            }
                            ArrayList<Element> stack5 = htmlTreeBuilder.getStack();
                            int size3 = stack5.size();
                            Element element7 = null;
                            int i4 = 0;
                            boolean z2 = false;
                            while (true) {
                                if (i4 >= size3 || i4 >= 64) {
                                    element = null;
                                } else {
                                    element = stack5.get(i4);
                                    if (element != activeFormattingElement) {
                                        if (z2 && htmlTreeBuilder2.isSpecial(element)) {
                                            break;
                                        }
                                    } else {
                                        element7 = stack5.get(i4 - 1);
                                        z2 = true;
                                    }
                                    i4++;
                                }
                            }
                            element = null;
                            if (element == null) {
                                htmlTreeBuilder2.popStackToClose(activeFormattingElement.nodeName());
                                htmlTreeBuilder2.removeFromActiveFormattingElements(activeFormattingElement);
                                return z;
                            }
                            Element element8 = element;
                            Element element9 = element8;
                            for (int i5 = 0; i5 < 3; i5++) {
                                if (htmlTreeBuilder2.onStack(element8)) {
                                    element8 = htmlTreeBuilder2.aboveOnStack(element8);
                                }
                                if (!htmlTreeBuilder2.isInActiveFormattingElements(element8)) {
                                    htmlTreeBuilder2.removeFromStack(element8);
                                } else if (element8 == activeFormattingElement) {
                                    break;
                                } else {
                                    Element element10 = new Element(Tag.valueOf(element8.nodeName()), htmlTreeBuilder.getBaseUri());
                                    htmlTreeBuilder2.replaceActiveFormattingElement(element8, element10);
                                    htmlTreeBuilder2.replaceOnStack(element8, element10);
                                    if (element9.parent() != null) {
                                        element9.remove();
                                    }
                                    element10.appendChild(element9);
                                    element8 = element10;
                                    element9 = element8;
                                }
                            }
                            if (StringUtil.inSorted(element7.nodeName(), Constants.InBodyEndTableFosters)) {
                                if (element9.parent() != null) {
                                    element9.remove();
                                }
                                htmlTreeBuilder2.insertInFosterParent(element9);
                            } else {
                                if (element9.parent() != null) {
                                    element9.remove();
                                }
                                element7.appendChild(element9);
                            }
                            Element element11 = new Element(activeFormattingElement.tag(), htmlTreeBuilder.getBaseUri());
                            element11.attributes().addAll(activeFormattingElement.attributes());
                            for (Node appendChild : (Node[]) element.childNodes().toArray(new Node[element.childNodeSize()])) {
                                element11.appendChild(appendChild);
                            }
                            element.appendChild(element11);
                            htmlTreeBuilder2.removeFromActiveFormattingElements(activeFormattingElement);
                            htmlTreeBuilder2.removeFromStack(activeFormattingElement);
                            htmlTreeBuilder2.insertOnStackAfter(element, element11);
                            i3++;
                            z = true;
                        }
                    }
                } else if (StringUtil.inSorted(name2, Constants.InBodyEndClosers)) {
                    if (!htmlTreeBuilder2.inScope(name2)) {
                        htmlTreeBuilder2.error(this);
                        return false;
                    }
                    htmlTreeBuilder.generateImpliedEndTags();
                    if (!htmlTreeBuilder.currentElement().nodeName().equals(name2)) {
                        htmlTreeBuilder2.error(this);
                    }
                    htmlTreeBuilder2.popStackToClose(name2);
                } else if (name2.equals("span")) {
                    return anyOtherEndTag(token, htmlTreeBuilder);
                } else {
                    if (name2.equals("li")) {
                        if (!htmlTreeBuilder2.inListItemScope(name2)) {
                            htmlTreeBuilder2.error(this);
                            return false;
                        }
                        htmlTreeBuilder2.generateImpliedEndTags(name2);
                        if (!htmlTreeBuilder.currentElement().nodeName().equals(name2)) {
                            htmlTreeBuilder2.error(this);
                        }
                        htmlTreeBuilder2.popStackToClose(name2);
                    } else if (name2.equals(SDKConstants.PARAM_A2U_BODY)) {
                        if (!htmlTreeBuilder2.inScope(SDKConstants.PARAM_A2U_BODY)) {
                            htmlTreeBuilder2.error(this);
                            return false;
                        }
                        htmlTreeBuilder2.transition(AfterBody);
                    } else if (name2.equals("html")) {
                        if (htmlTreeBuilder2.processEndTag(SDKConstants.PARAM_A2U_BODY)) {
                            return htmlTreeBuilder2.process(asEndTag);
                        }
                    } else if (name2.equals("form")) {
                        FormElement formElement = htmlTreeBuilder.getFormElement();
                        htmlTreeBuilder2.setFormElement((FormElement) null);
                        if (formElement == null || !htmlTreeBuilder2.inScope(name2)) {
                            htmlTreeBuilder2.error(this);
                            return false;
                        }
                        htmlTreeBuilder.generateImpliedEndTags();
                        if (!htmlTreeBuilder.currentElement().nodeName().equals(name2)) {
                            htmlTreeBuilder2.error(this);
                        }
                        htmlTreeBuilder2.removeFromStack(formElement);
                    } else if (name2.equals(ContextChain.TAG_PRODUCT)) {
                        if (!htmlTreeBuilder2.inButtonScope(name2)) {
                            htmlTreeBuilder2.error(this);
                            htmlTreeBuilder2.processStartTag(name2);
                            return htmlTreeBuilder2.process(asEndTag);
                        }
                        htmlTreeBuilder2.generateImpliedEndTags(name2);
                        if (!htmlTreeBuilder.currentElement().nodeName().equals(name2)) {
                            htmlTreeBuilder2.error(this);
                        }
                        htmlTreeBuilder2.popStackToClose(name2);
                    } else if (StringUtil.inSorted(name2, Constants.DdDt)) {
                        if (!htmlTreeBuilder2.inScope(name2)) {
                            htmlTreeBuilder2.error(this);
                            return false;
                        }
                        htmlTreeBuilder2.generateImpliedEndTags(name2);
                        if (!htmlTreeBuilder.currentElement().nodeName().equals(name2)) {
                            htmlTreeBuilder2.error(this);
                        }
                        htmlTreeBuilder2.popStackToClose(name2);
                    } else if (StringUtil.inSorted(name2, Constants.Headings)) {
                        if (!htmlTreeBuilder2.inScope(Constants.Headings)) {
                            htmlTreeBuilder2.error(this);
                            return false;
                        }
                        htmlTreeBuilder2.generateImpliedEndTags(name2);
                        if (!htmlTreeBuilder.currentElement().nodeName().equals(name2)) {
                            htmlTreeBuilder2.error(this);
                        }
                        htmlTreeBuilder2.popStackToClose(Constants.Headings);
                    } else if (name2.equals("sarcasm")) {
                        return anyOtherEndTag(token, htmlTreeBuilder);
                    } else {
                        if (StringUtil.inSorted(name2, Constants.InBodyStartApplets)) {
                            if (!htmlTreeBuilder2.inScope("name")) {
                                if (!htmlTreeBuilder2.inScope(name2)) {
                                    htmlTreeBuilder2.error(this);
                                    return false;
                                }
                                htmlTreeBuilder.generateImpliedEndTags();
                                if (!htmlTreeBuilder.currentElement().nodeName().equals(name2)) {
                                    htmlTreeBuilder2.error(this);
                                }
                                htmlTreeBuilder2.popStackToClose(name2);
                                htmlTreeBuilder.clearFormattingElementsToLastMarker();
                            }
                        } else if (!name2.equals("br")) {
                            return anyOtherEndTag(token, htmlTreeBuilder);
                        } else {
                            htmlTreeBuilder2.error(this);
                            htmlTreeBuilder2.processStartTag("br");
                            return false;
                        }
                    }
                }
            } else if (i == 5) {
                Token.Character asCharacter = token.asCharacter();
                if (asCharacter.getData().equals(HtmlTreeBuilderState.nullString)) {
                    htmlTreeBuilder2.error(this);
                    return false;
                } else if (!htmlTreeBuilder.framesetOk() || !HtmlTreeBuilderState.isWhitespace((Token) asCharacter)) {
                    htmlTreeBuilder.reconstructFormattingElements();
                    htmlTreeBuilder2.insert(asCharacter);
                    htmlTreeBuilder2.framesetOk(false);
                } else {
                    htmlTreeBuilder.reconstructFormattingElements();
                    htmlTreeBuilder2.insert(asCharacter);
                }
            }
            return true;
        }

        /* access modifiers changed from: package-private */
        public boolean anyOtherEndTag(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            String name = token.asEndTag().name();
            ArrayList<Element> stack = htmlTreeBuilder.getStack();
            int size = stack.size() - 1;
            while (true) {
                if (size < 0) {
                    break;
                }
                Element element = stack.get(size);
                if (element.nodeName().equals(name)) {
                    htmlTreeBuilder.generateImpliedEndTags(name);
                    if (!name.equals(htmlTreeBuilder.currentElement().nodeName())) {
                        htmlTreeBuilder.error(this);
                    }
                    htmlTreeBuilder.popStackToClose(name);
                } else if (htmlTreeBuilder.isSpecial(element)) {
                    htmlTreeBuilder.error(this);
                    return false;
                } else {
                    size--;
                }
            }
            return true;
        }
    },
    Text {
        /* access modifiers changed from: package-private */
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.isCharacter()) {
                htmlTreeBuilder.insert(token.asCharacter());
                return true;
            } else if (token.isEOF()) {
                htmlTreeBuilder.error(this);
                htmlTreeBuilder.pop();
                htmlTreeBuilder.transition(htmlTreeBuilder.originalState());
                return htmlTreeBuilder.process(token);
            } else if (!token.isEndTag()) {
                return true;
            } else {
                htmlTreeBuilder.pop();
                htmlTreeBuilder.transition(htmlTreeBuilder.originalState());
                return true;
            }
        }
    },
    InTable {
        /* access modifiers changed from: package-private */
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            Token token2 = token;
            HtmlTreeBuilder htmlTreeBuilder2 = htmlTreeBuilder;
            if (token.isCharacter()) {
                htmlTreeBuilder.newPendingTableCharacters();
                htmlTreeBuilder.markInsertionMode();
                htmlTreeBuilder2.transition(InTableText);
                return htmlTreeBuilder2.process(token2);
            } else if (token.isComment()) {
                htmlTreeBuilder2.insert(token.asComment());
                return true;
            } else if (token.isDoctype()) {
                htmlTreeBuilder2.error(this);
                return false;
            } else if (token.isStartTag()) {
                Token.StartTag asStartTag = token.asStartTag();
                String name = asStartTag.name();
                if (name.equals(ShareConstants.FEED_CAPTION_PARAM)) {
                    htmlTreeBuilder.clearStackToTableContext();
                    htmlTreeBuilder.insertMarkerToFormattingElements();
                    htmlTreeBuilder2.insert(asStartTag);
                    htmlTreeBuilder2.transition(InCaption);
                } else if (name.equals("colgroup")) {
                    htmlTreeBuilder.clearStackToTableContext();
                    htmlTreeBuilder2.insert(asStartTag);
                    htmlTreeBuilder2.transition(InColumnGroup);
                } else if (name.equals("col")) {
                    htmlTreeBuilder2.processStartTag("colgroup");
                    return htmlTreeBuilder2.process(token2);
                } else if (StringUtil.in(name, "tbody", "tfoot", "thead")) {
                    htmlTreeBuilder.clearStackToTableContext();
                    htmlTreeBuilder2.insert(asStartTag);
                    htmlTreeBuilder2.transition(InTableBody);
                } else if (StringUtil.in(name, "td", "th", "tr")) {
                    htmlTreeBuilder2.processStartTag("tbody");
                    return htmlTreeBuilder2.process(token2);
                } else if (name.equals("table")) {
                    htmlTreeBuilder2.error(this);
                    if (htmlTreeBuilder2.processEndTag("table")) {
                        return htmlTreeBuilder2.process(token2);
                    }
                } else if (StringUtil.in(name, AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "script")) {
                    return htmlTreeBuilder2.process(token2, InHead);
                } else {
                    if (name.equals(MetricTracker.Object.INPUT)) {
                        if (!asStartTag.attributes.get("type").equalsIgnoreCase(ViewProps.HIDDEN)) {
                            return anythingElse(token, htmlTreeBuilder);
                        }
                        htmlTreeBuilder2.insertEmpty(asStartTag);
                    } else if (!name.equals("form")) {
                        return anythingElse(token, htmlTreeBuilder);
                    } else {
                        htmlTreeBuilder2.error(this);
                        if (htmlTreeBuilder.getFormElement() != null) {
                            return false;
                        }
                        htmlTreeBuilder2.insertForm(asStartTag, false);
                    }
                }
                return true;
            } else if (token.isEndTag()) {
                String name2 = token.asEndTag().name();
                if (name2.equals("table")) {
                    if (!htmlTreeBuilder2.inTableScope(name2)) {
                        htmlTreeBuilder2.error(this);
                        return false;
                    }
                    htmlTreeBuilder2.popStackToClose("table");
                    htmlTreeBuilder.resetInsertionMode();
                    return true;
                } else if (!StringUtil.in(name2, SDKConstants.PARAM_A2U_BODY, ShareConstants.FEED_CAPTION_PARAM, "col", "colgroup", "html", "tbody", "td", "tfoot", "th", "thead", "tr")) {
                    return anythingElse(token, htmlTreeBuilder);
                } else {
                    htmlTreeBuilder2.error(this);
                    return false;
                }
            } else if (!token.isEOF()) {
                return anythingElse(token, htmlTreeBuilder);
            } else {
                if (htmlTreeBuilder.currentElement().nodeName().equals("html")) {
                    htmlTreeBuilder2.error(this);
                }
                return true;
            }
        }

        /* access modifiers changed from: package-private */
        public boolean anythingElse(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            htmlTreeBuilder.error(this);
            if (!StringUtil.in(htmlTreeBuilder.currentElement().nodeName(), "table", "tbody", "tfoot", "thead", "tr")) {
                return htmlTreeBuilder.process(token, InBody);
            }
            htmlTreeBuilder.setFosterInserts(true);
            boolean process = htmlTreeBuilder.process(token, InBody);
            htmlTreeBuilder.setFosterInserts(false);
            return process;
        }
    },
    InTableText {
        /* access modifiers changed from: package-private */
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (AnonymousClass24.$SwitchMap$org$jsoup$parser$Token$TokenType[token.type.ordinal()] != 5) {
                if (htmlTreeBuilder.getPendingTableCharacters().size() > 0) {
                    for (String next : htmlTreeBuilder.getPendingTableCharacters()) {
                        if (!HtmlTreeBuilderState.isWhitespace(next)) {
                            htmlTreeBuilder.error(this);
                            if (StringUtil.in(htmlTreeBuilder.currentElement().nodeName(), "table", "tbody", "tfoot", "thead", "tr")) {
                                htmlTreeBuilder.setFosterInserts(true);
                                htmlTreeBuilder.process(new Token.Character().data(next), InBody);
                                htmlTreeBuilder.setFosterInserts(false);
                            } else {
                                htmlTreeBuilder.process(new Token.Character().data(next), InBody);
                            }
                        } else {
                            htmlTreeBuilder.insert(new Token.Character().data(next));
                        }
                    }
                    htmlTreeBuilder.newPendingTableCharacters();
                }
                htmlTreeBuilder.transition(htmlTreeBuilder.originalState());
                return htmlTreeBuilder.process(token);
            }
            Token.Character asCharacter = token.asCharacter();
            if (asCharacter.getData().equals(HtmlTreeBuilderState.nullString)) {
                htmlTreeBuilder.error(this);
                return false;
            }
            htmlTreeBuilder.getPendingTableCharacters().add(asCharacter.getData());
            return true;
        }
    },
    InCaption {
        /* access modifiers changed from: package-private */
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (!token.isEndTag() || !token.asEndTag().name().equals(ShareConstants.FEED_CAPTION_PARAM)) {
                if ((token.isStartTag() && StringUtil.in(token.asStartTag().name(), ShareConstants.FEED_CAPTION_PARAM, "col", "colgroup", "tbody", "td", "tfoot", "th", "thead", "tr")) || (token.isEndTag() && token.asEndTag().name().equals("table"))) {
                    htmlTreeBuilder.error(this);
                    if (htmlTreeBuilder.processEndTag(ShareConstants.FEED_CAPTION_PARAM)) {
                        return htmlTreeBuilder.process(token);
                    }
                    return true;
                } else if (!token.isEndTag() || !StringUtil.in(token.asEndTag().name(), SDKConstants.PARAM_A2U_BODY, "col", "colgroup", "html", "tbody", "td", "tfoot", "th", "thead", "tr")) {
                    return htmlTreeBuilder.process(token, InBody);
                } else {
                    htmlTreeBuilder.error(this);
                    return false;
                }
            } else if (!htmlTreeBuilder.inTableScope(token.asEndTag().name())) {
                htmlTreeBuilder.error(this);
                return false;
            } else {
                htmlTreeBuilder.generateImpliedEndTags();
                if (!htmlTreeBuilder.currentElement().nodeName().equals(ShareConstants.FEED_CAPTION_PARAM)) {
                    htmlTreeBuilder.error(this);
                }
                htmlTreeBuilder.popStackToClose(ShareConstants.FEED_CAPTION_PARAM);
                htmlTreeBuilder.clearFormattingElementsToLastMarker();
                htmlTreeBuilder.transition(InTable);
                return true;
            }
        }
    },
    InColumnGroup {
        /* access modifiers changed from: package-private */
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (HtmlTreeBuilderState.isWhitespace(token)) {
                htmlTreeBuilder.insert(token.asCharacter());
                return true;
            }
            int i = AnonymousClass24.$SwitchMap$org$jsoup$parser$Token$TokenType[token.type.ordinal()];
            if (i == 1) {
                htmlTreeBuilder.insert(token.asComment());
            } else if (i == 2) {
                htmlTreeBuilder.error(this);
            } else if (i == 3) {
                Token.StartTag asStartTag = token.asStartTag();
                String name = asStartTag.name();
                if (name.equals("html")) {
                    return htmlTreeBuilder.process(token, InBody);
                }
                if (!name.equals("col")) {
                    return anythingElse(token, htmlTreeBuilder);
                }
                htmlTreeBuilder.insertEmpty(asStartTag);
            } else if (i != 4) {
                if (i != 6) {
                    return anythingElse(token, htmlTreeBuilder);
                }
                if (htmlTreeBuilder.currentElement().nodeName().equals("html")) {
                    return true;
                }
                return anythingElse(token, htmlTreeBuilder);
            } else if (!token.asEndTag().name().equals("colgroup")) {
                return anythingElse(token, htmlTreeBuilder);
            } else {
                if (htmlTreeBuilder.currentElement().nodeName().equals("html")) {
                    htmlTreeBuilder.error(this);
                    return false;
                }
                htmlTreeBuilder.pop();
                htmlTreeBuilder.transition(InTable);
            }
            return true;
        }

        private boolean anythingElse(Token token, TreeBuilder treeBuilder) {
            if (treeBuilder.processEndTag("colgroup")) {
                return treeBuilder.process(token);
            }
            return true;
        }
    },
    InTableBody {
        /* access modifiers changed from: package-private */
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            int i = AnonymousClass24.$SwitchMap$org$jsoup$parser$Token$TokenType[token.type.ordinal()];
            if (i == 3) {
                Token.StartTag asStartTag = token.asStartTag();
                String name = asStartTag.name();
                if (name.equals("tr")) {
                    htmlTreeBuilder.clearStackToTableBodyContext();
                    htmlTreeBuilder.insert(asStartTag);
                    htmlTreeBuilder.transition(InRow);
                    return true;
                } else if (StringUtil.in(name, "th", "td")) {
                    htmlTreeBuilder.error(this);
                    htmlTreeBuilder.processStartTag("tr");
                    return htmlTreeBuilder.process(asStartTag);
                } else if (StringUtil.in(name, ShareConstants.FEED_CAPTION_PARAM, "col", "colgroup", "tbody", "tfoot", "thead")) {
                    return exitTableBody(token, htmlTreeBuilder);
                } else {
                    return anythingElse(token, htmlTreeBuilder);
                }
            } else if (i != 4) {
                return anythingElse(token, htmlTreeBuilder);
            } else {
                String name2 = token.asEndTag().name();
                if (StringUtil.in(name2, "tbody", "tfoot", "thead")) {
                    if (!htmlTreeBuilder.inTableScope(name2)) {
                        htmlTreeBuilder.error(this);
                        return false;
                    }
                    htmlTreeBuilder.clearStackToTableBodyContext();
                    htmlTreeBuilder.pop();
                    htmlTreeBuilder.transition(InTable);
                    return true;
                } else if (name2.equals("table")) {
                    return exitTableBody(token, htmlTreeBuilder);
                } else {
                    if (!StringUtil.in(name2, SDKConstants.PARAM_A2U_BODY, ShareConstants.FEED_CAPTION_PARAM, "col", "colgroup", "html", "td", "th", "tr")) {
                        return anythingElse(token, htmlTreeBuilder);
                    }
                    htmlTreeBuilder.error(this);
                    return false;
                }
            }
        }

        private boolean exitTableBody(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (htmlTreeBuilder.inTableScope("tbody") || htmlTreeBuilder.inTableScope("thead") || htmlTreeBuilder.inScope("tfoot")) {
                htmlTreeBuilder.clearStackToTableBodyContext();
                htmlTreeBuilder.processEndTag(htmlTreeBuilder.currentElement().nodeName());
                return htmlTreeBuilder.process(token);
            }
            htmlTreeBuilder.error(this);
            return false;
        }

        private boolean anythingElse(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            return htmlTreeBuilder.process(token, InTable);
        }
    },
    InRow {
        /* access modifiers changed from: package-private */
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.isStartTag()) {
                Token.StartTag asStartTag = token.asStartTag();
                String name = asStartTag.name();
                if (StringUtil.in(name, "th", "td")) {
                    htmlTreeBuilder.clearStackToTableRowContext();
                    htmlTreeBuilder.insert(asStartTag);
                    htmlTreeBuilder.transition(InCell);
                    htmlTreeBuilder.insertMarkerToFormattingElements();
                    return true;
                } else if (StringUtil.in(name, ShareConstants.FEED_CAPTION_PARAM, "col", "colgroup", "tbody", "tfoot", "thead", "tr")) {
                    return handleMissingTr(token, htmlTreeBuilder);
                } else {
                    return anythingElse(token, htmlTreeBuilder);
                }
            } else if (!token.isEndTag()) {
                return anythingElse(token, htmlTreeBuilder);
            } else {
                String name2 = token.asEndTag().name();
                if (name2.equals("tr")) {
                    if (!htmlTreeBuilder.inTableScope(name2)) {
                        htmlTreeBuilder.error(this);
                        return false;
                    }
                    htmlTreeBuilder.clearStackToTableRowContext();
                    htmlTreeBuilder.pop();
                    htmlTreeBuilder.transition(InTableBody);
                    return true;
                } else if (name2.equals("table")) {
                    return handleMissingTr(token, htmlTreeBuilder);
                } else {
                    if (StringUtil.in(name2, "tbody", "tfoot", "thead")) {
                        if (!htmlTreeBuilder.inTableScope(name2)) {
                            htmlTreeBuilder.error(this);
                            return false;
                        }
                        htmlTreeBuilder.processEndTag("tr");
                        return htmlTreeBuilder.process(token);
                    } else if (!StringUtil.in(name2, SDKConstants.PARAM_A2U_BODY, ShareConstants.FEED_CAPTION_PARAM, "col", "colgroup", "html", "td", "th")) {
                        return anythingElse(token, htmlTreeBuilder);
                    } else {
                        htmlTreeBuilder.error(this);
                        return false;
                    }
                }
            }
        }

        private boolean anythingElse(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            return htmlTreeBuilder.process(token, InTable);
        }

        private boolean handleMissingTr(Token token, TreeBuilder treeBuilder) {
            if (treeBuilder.processEndTag("tr")) {
                return treeBuilder.process(token);
            }
            return false;
        }
    },
    InCell {
        /* access modifiers changed from: package-private */
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.isEndTag()) {
                String name = token.asEndTag().name();
                if (StringUtil.in(name, "td", "th")) {
                    if (!htmlTreeBuilder.inTableScope(name)) {
                        htmlTreeBuilder.error(this);
                        htmlTreeBuilder.transition(InRow);
                        return false;
                    }
                    htmlTreeBuilder.generateImpliedEndTags();
                    if (!htmlTreeBuilder.currentElement().nodeName().equals(name)) {
                        htmlTreeBuilder.error(this);
                    }
                    htmlTreeBuilder.popStackToClose(name);
                    htmlTreeBuilder.clearFormattingElementsToLastMarker();
                    htmlTreeBuilder.transition(InRow);
                    return true;
                } else if (StringUtil.in(name, SDKConstants.PARAM_A2U_BODY, ShareConstants.FEED_CAPTION_PARAM, "col", "colgroup", "html")) {
                    htmlTreeBuilder.error(this);
                    return false;
                } else if (!StringUtil.in(name, "table", "tbody", "tfoot", "thead", "tr")) {
                    return anythingElse(token, htmlTreeBuilder);
                } else {
                    if (!htmlTreeBuilder.inTableScope(name)) {
                        htmlTreeBuilder.error(this);
                        return false;
                    }
                    closeCell(htmlTreeBuilder);
                    return htmlTreeBuilder.process(token);
                }
            } else if (!token.isStartTag() || !StringUtil.in(token.asStartTag().name(), ShareConstants.FEED_CAPTION_PARAM, "col", "colgroup", "tbody", "td", "tfoot", "th", "thead", "tr")) {
                return anythingElse(token, htmlTreeBuilder);
            } else {
                if (htmlTreeBuilder.inTableScope("td") || htmlTreeBuilder.inTableScope("th")) {
                    closeCell(htmlTreeBuilder);
                    return htmlTreeBuilder.process(token);
                }
                htmlTreeBuilder.error(this);
                return false;
            }
        }

        private boolean anythingElse(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            return htmlTreeBuilder.process(token, InBody);
        }

        private void closeCell(HtmlTreeBuilder htmlTreeBuilder) {
            if (htmlTreeBuilder.inTableScope("td")) {
                htmlTreeBuilder.processEndTag("td");
            } else {
                htmlTreeBuilder.processEndTag("th");
            }
        }
    },
    InSelect {
        /* access modifiers changed from: package-private */
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            switch (AnonymousClass24.$SwitchMap$org$jsoup$parser$Token$TokenType[token.type.ordinal()]) {
                case 1:
                    htmlTreeBuilder.insert(token.asComment());
                    return true;
                case 2:
                    htmlTreeBuilder.error(this);
                    return false;
                case 3:
                    Token.StartTag asStartTag = token.asStartTag();
                    String name = asStartTag.name();
                    if (name.equals("html")) {
                        return htmlTreeBuilder.process(asStartTag, InBody);
                    }
                    if (name.equals("option")) {
                        htmlTreeBuilder.processEndTag("option");
                        htmlTreeBuilder.insert(asStartTag);
                        return true;
                    } else if (name.equals("optgroup")) {
                        if (htmlTreeBuilder.currentElement().nodeName().equals("option")) {
                            htmlTreeBuilder.processEndTag("option");
                        } else if (htmlTreeBuilder.currentElement().nodeName().equals("optgroup")) {
                            htmlTreeBuilder.processEndTag("optgroup");
                        }
                        htmlTreeBuilder.insert(asStartTag);
                        return true;
                    } else if (name.equals("select")) {
                        htmlTreeBuilder.error(this);
                        return htmlTreeBuilder.processEndTag("select");
                    } else if (StringUtil.in(name, MetricTracker.Object.INPUT, "keygen", "textarea")) {
                        htmlTreeBuilder.error(this);
                        if (!htmlTreeBuilder.inSelectScope("select")) {
                            return false;
                        }
                        htmlTreeBuilder.processEndTag("select");
                        return htmlTreeBuilder.process(asStartTag);
                    } else if (name.equals("script")) {
                        return htmlTreeBuilder.process(token, InHead);
                    } else {
                        return anythingElse(token, htmlTreeBuilder);
                    }
                case 4:
                    String name2 = token.asEndTag().name();
                    if (name2.equals("optgroup")) {
                        if (htmlTreeBuilder.currentElement().nodeName().equals("option") && htmlTreeBuilder.aboveOnStack(htmlTreeBuilder.currentElement()) != null && htmlTreeBuilder.aboveOnStack(htmlTreeBuilder.currentElement()).nodeName().equals("optgroup")) {
                            htmlTreeBuilder.processEndTag("option");
                        }
                        if (htmlTreeBuilder.currentElement().nodeName().equals("optgroup")) {
                            htmlTreeBuilder.pop();
                            return true;
                        }
                        htmlTreeBuilder.error(this);
                        return true;
                    } else if (name2.equals("option")) {
                        if (htmlTreeBuilder.currentElement().nodeName().equals("option")) {
                            htmlTreeBuilder.pop();
                            return true;
                        }
                        htmlTreeBuilder.error(this);
                        return true;
                    } else if (!name2.equals("select")) {
                        return anythingElse(token, htmlTreeBuilder);
                    } else {
                        if (!htmlTreeBuilder.inSelectScope(name2)) {
                            htmlTreeBuilder.error(this);
                            return false;
                        }
                        htmlTreeBuilder.popStackToClose(name2);
                        htmlTreeBuilder.resetInsertionMode();
                        return true;
                    }
                case 5:
                    Token.Character asCharacter = token.asCharacter();
                    if (asCharacter.getData().equals(HtmlTreeBuilderState.nullString)) {
                        htmlTreeBuilder.error(this);
                        return false;
                    }
                    htmlTreeBuilder.insert(asCharacter);
                    return true;
                case 6:
                    if (htmlTreeBuilder.currentElement().nodeName().equals("html")) {
                        return true;
                    }
                    htmlTreeBuilder.error(this);
                    return true;
                default:
                    return anythingElse(token, htmlTreeBuilder);
            }
        }

        private boolean anythingElse(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            htmlTreeBuilder.error(this);
            return false;
        }
    },
    InSelectInTable {
        /* access modifiers changed from: package-private */
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.isStartTag() && StringUtil.in(token.asStartTag().name(), ShareConstants.FEED_CAPTION_PARAM, "table", "tbody", "tfoot", "thead", "tr", "td", "th")) {
                htmlTreeBuilder.error(this);
                htmlTreeBuilder.processEndTag("select");
                return htmlTreeBuilder.process(token);
            } else if (!token.isEndTag() || !StringUtil.in(token.asEndTag().name(), ShareConstants.FEED_CAPTION_PARAM, "table", "tbody", "tfoot", "thead", "tr", "td", "th")) {
                return htmlTreeBuilder.process(token, InSelect);
            } else {
                htmlTreeBuilder.error(this);
                if (!htmlTreeBuilder.inTableScope(token.asEndTag().name())) {
                    return false;
                }
                htmlTreeBuilder.processEndTag("select");
                return htmlTreeBuilder.process(token);
            }
        }
    },
    AfterBody {
        /* access modifiers changed from: package-private */
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (HtmlTreeBuilderState.isWhitespace(token)) {
                return htmlTreeBuilder.process(token, InBody);
            }
            if (token.isComment()) {
                htmlTreeBuilder.insert(token.asComment());
                return true;
            } else if (token.isDoctype()) {
                htmlTreeBuilder.error(this);
                return false;
            } else if (token.isStartTag() && token.asStartTag().name().equals("html")) {
                return htmlTreeBuilder.process(token, InBody);
            } else {
                if (!token.isEndTag() || !token.asEndTag().name().equals("html")) {
                    if (token.isEOF()) {
                        return true;
                    }
                    htmlTreeBuilder.error(this);
                    htmlTreeBuilder.transition(InBody);
                    return htmlTreeBuilder.process(token);
                } else if (htmlTreeBuilder.isFragmentParsing()) {
                    htmlTreeBuilder.error(this);
                    return false;
                } else {
                    htmlTreeBuilder.transition(AfterAfterBody);
                    return true;
                }
            }
        }
    },
    InFrameset {
        /* access modifiers changed from: package-private */
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (HtmlTreeBuilderState.isWhitespace(token)) {
                htmlTreeBuilder.insert(token.asCharacter());
            } else if (token.isComment()) {
                htmlTreeBuilder.insert(token.asComment());
            } else if (token.isDoctype()) {
                htmlTreeBuilder.error(this);
                return false;
            } else if (token.isStartTag()) {
                Token.StartTag asStartTag = token.asStartTag();
                String name = asStartTag.name();
                if (name.equals("html")) {
                    return htmlTreeBuilder.process(asStartTag, InBody);
                }
                if (name.equals("frameset")) {
                    htmlTreeBuilder.insert(asStartTag);
                } else if (name.equals(TypedValues.AttributesType.S_FRAME)) {
                    htmlTreeBuilder.insertEmpty(asStartTag);
                } else if (name.equals("noframes")) {
                    return htmlTreeBuilder.process(asStartTag, InHead);
                } else {
                    htmlTreeBuilder.error(this);
                    return false;
                }
            } else if (!token.isEndTag() || !token.asEndTag().name().equals("frameset")) {
                if (!token.isEOF()) {
                    htmlTreeBuilder.error(this);
                    return false;
                } else if (!htmlTreeBuilder.currentElement().nodeName().equals("html")) {
                    htmlTreeBuilder.error(this);
                }
            } else if (htmlTreeBuilder.currentElement().nodeName().equals("html")) {
                htmlTreeBuilder.error(this);
                return false;
            } else {
                htmlTreeBuilder.pop();
                if (!htmlTreeBuilder.isFragmentParsing() && !htmlTreeBuilder.currentElement().nodeName().equals("frameset")) {
                    htmlTreeBuilder.transition(AfterFrameset);
                }
            }
            return true;
        }
    },
    AfterFrameset {
        /* access modifiers changed from: package-private */
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (HtmlTreeBuilderState.isWhitespace(token)) {
                htmlTreeBuilder.insert(token.asCharacter());
                return true;
            } else if (token.isComment()) {
                htmlTreeBuilder.insert(token.asComment());
                return true;
            } else if (token.isDoctype()) {
                htmlTreeBuilder.error(this);
                return false;
            } else if (token.isStartTag() && token.asStartTag().name().equals("html")) {
                return htmlTreeBuilder.process(token, InBody);
            } else {
                if (token.isEndTag() && token.asEndTag().name().equals("html")) {
                    htmlTreeBuilder.transition(AfterAfterFrameset);
                    return true;
                } else if (token.isStartTag() && token.asStartTag().name().equals("noframes")) {
                    return htmlTreeBuilder.process(token, InHead);
                } else {
                    if (token.isEOF()) {
                        return true;
                    }
                    htmlTreeBuilder.error(this);
                    return false;
                }
            }
        }
    },
    AfterAfterBody {
        /* access modifiers changed from: package-private */
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.isComment()) {
                htmlTreeBuilder.insert(token.asComment());
                return true;
            } else if (token.isDoctype() || HtmlTreeBuilderState.isWhitespace(token) || (token.isStartTag() && token.asStartTag().name().equals("html"))) {
                return htmlTreeBuilder.process(token, InBody);
            } else {
                if (token.isEOF()) {
                    return true;
                }
                htmlTreeBuilder.error(this);
                htmlTreeBuilder.transition(InBody);
                return htmlTreeBuilder.process(token);
            }
        }
    },
    AfterAfterFrameset {
        /* access modifiers changed from: package-private */
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.isComment()) {
                htmlTreeBuilder.insert(token.asComment());
                return true;
            } else if (token.isDoctype() || HtmlTreeBuilderState.isWhitespace(token) || (token.isStartTag() && token.asStartTag().name().equals("html"))) {
                return htmlTreeBuilder.process(token, InBody);
            } else {
                if (token.isEOF()) {
                    return true;
                }
                if (token.isStartTag() && token.asStartTag().name().equals("noframes")) {
                    return htmlTreeBuilder.process(token, InHead);
                }
                htmlTreeBuilder.error(this);
                return false;
            }
        }
    },
    ForeignContent {
        /* access modifiers changed from: package-private */
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            return true;
        }
    };
    
    /* access modifiers changed from: private */
    public static String nullString;

    /* access modifiers changed from: package-private */
    public abstract boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder);

    static {
        nullString = String.valueOf(0);
    }

    /* renamed from: org.jsoup.parser.HtmlTreeBuilderState$24  reason: invalid class name */
    static /* synthetic */ class AnonymousClass24 {
        static final /* synthetic */ int[] $SwitchMap$org$jsoup$parser$Token$TokenType = null;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                org.jsoup.parser.Token$TokenType[] r0 = org.jsoup.parser.Token.TokenType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$org$jsoup$parser$Token$TokenType = r0
                org.jsoup.parser.Token$TokenType r1 = org.jsoup.parser.Token.TokenType.Comment     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$org$jsoup$parser$Token$TokenType     // Catch:{ NoSuchFieldError -> 0x001d }
                org.jsoup.parser.Token$TokenType r1 = org.jsoup.parser.Token.TokenType.Doctype     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$org$jsoup$parser$Token$TokenType     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.jsoup.parser.Token$TokenType r1 = org.jsoup.parser.Token.TokenType.StartTag     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$org$jsoup$parser$Token$TokenType     // Catch:{ NoSuchFieldError -> 0x0033 }
                org.jsoup.parser.Token$TokenType r1 = org.jsoup.parser.Token.TokenType.EndTag     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$org$jsoup$parser$Token$TokenType     // Catch:{ NoSuchFieldError -> 0x003e }
                org.jsoup.parser.Token$TokenType r1 = org.jsoup.parser.Token.TokenType.Character     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$org$jsoup$parser$Token$TokenType     // Catch:{ NoSuchFieldError -> 0x0049 }
                org.jsoup.parser.Token$TokenType r1 = org.jsoup.parser.Token.TokenType.EOF     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jsoup.parser.HtmlTreeBuilderState.AnonymousClass24.<clinit>():void");
        }
    }

    /* access modifiers changed from: private */
    public static boolean isWhitespace(Token token) {
        if (token.isCharacter()) {
            return isWhitespace(token.asCharacter().getData());
        }
        return false;
    }

    /* access modifiers changed from: private */
    public static boolean isWhitespace(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!StringUtil.isWhitespace(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: private */
    public static void handleRcData(Token.StartTag startTag, HtmlTreeBuilder htmlTreeBuilder) {
        htmlTreeBuilder.insert(startTag);
        htmlTreeBuilder.tokeniser.transition(TokeniserState.Rcdata);
        htmlTreeBuilder.markInsertionMode();
        htmlTreeBuilder.transition(Text);
    }

    /* access modifiers changed from: private */
    public static void handleRawtext(Token.StartTag startTag, HtmlTreeBuilder htmlTreeBuilder) {
        htmlTreeBuilder.insert(startTag);
        htmlTreeBuilder.tokeniser.transition(TokeniserState.Rawtext);
        htmlTreeBuilder.markInsertionMode();
        htmlTreeBuilder.transition(Text);
    }

    private static final class Constants {
        /* access modifiers changed from: private */
        public static final String[] DdDt = null;
        /* access modifiers changed from: private */
        public static final String[] Formatters = null;
        /* access modifiers changed from: private */
        public static final String[] Headings = null;
        /* access modifiers changed from: private */
        public static final String[] InBodyEndAdoptionFormatters = null;
        /* access modifiers changed from: private */
        public static final String[] InBodyEndClosers = null;
        /* access modifiers changed from: private */
        public static final String[] InBodyEndTableFosters = null;
        /* access modifiers changed from: private */
        public static final String[] InBodyStartApplets = null;
        /* access modifiers changed from: private */
        public static final String[] InBodyStartDrop = null;
        /* access modifiers changed from: private */
        public static final String[] InBodyStartEmptyFormatters = null;
        /* access modifiers changed from: private */
        public static final String[] InBodyStartInputAttribs = null;
        /* access modifiers changed from: private */
        public static final String[] InBodyStartLiBreakers = null;
        /* access modifiers changed from: private */
        public static final String[] InBodyStartMedia = null;
        /* access modifiers changed from: private */
        public static final String[] InBodyStartOptions = null;
        /* access modifiers changed from: private */
        public static final String[] InBodyStartPClosers = null;
        /* access modifiers changed from: private */
        public static final String[] InBodyStartPreListing = null;
        /* access modifiers changed from: private */
        public static final String[] InBodyStartRuby = null;
        /* access modifiers changed from: private */
        public static final String[] InBodyStartToHead = null;

        private Constants() {
        }

        static {
            InBodyStartToHead = new String[]{"base", "basefont", "bgsound", "command", "link", "meta", "noframes", "script", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "title"};
            InBodyStartPClosers = new String[]{IntegrityManager.INTEGRITY_TYPE_ADDRESS, "article", "aside", "blockquote", "center", "details", "dir", "div", "dl", "fieldset", "figcaption", "figure", "footer", "header", "hgroup", "menu", "nav", "ol", ContextChain.TAG_PRODUCT, "section", "summary", "ul"};
            Headings = new String[]{"h1", "h2", "h3", "h4", "h5", "h6"};
            InBodyStartPreListing = new String[]{"pre", "listing"};
            InBodyStartLiBreakers = new String[]{IntegrityManager.INTEGRITY_TYPE_ADDRESS, "div", ContextChain.TAG_PRODUCT};
            DdDt = new String[]{"dd", "dt"};
            Formatters = new String[]{"b", "big", OAuthConstants.CODE, UserDataStore.EMAIL, "font", ContextChain.TAG_INFRA, "s", "small", "strike", "strong", "tt", "u"};
            InBodyStartApplets = new String[]{"applet", "marquee", "object"};
            InBodyStartEmptyFormatters = new String[]{"area", "br", "embed", "img", "keygen", "wbr"};
            InBodyStartMedia = new String[]{"param", "source", "track"};
            InBodyStartInputAttribs = new String[]{"name", "action", "prompt"};
            InBodyStartOptions = new String[]{"optgroup", "option"};
            InBodyStartRuby = new String[]{"rp", "rt"};
            InBodyStartDrop = new String[]{ShareConstants.FEED_CAPTION_PARAM, "col", "colgroup", TypedValues.AttributesType.S_FRAME, "head", "tbody", "td", "tfoot", "th", "thead", "tr"};
            InBodyEndClosers = new String[]{IntegrityManager.INTEGRITY_TYPE_ADDRESS, "article", "aside", "blockquote", "button", "center", "details", "dir", "div", "dl", "fieldset", "figcaption", "figure", "footer", "header", "hgroup", "listing", "menu", "nav", "ol", "pre", "section", "summary", "ul"};
            InBodyEndAdoptionFormatters = new String[]{"a", "b", "big", OAuthConstants.CODE, UserDataStore.EMAIL, "font", ContextChain.TAG_INFRA, "nobr", "s", "small", "strike", "strong", "tt", "u"};
            InBodyEndTableFosters = new String[]{"table", "tbody", "tfoot", "thead", "tr"};
        }
    }
}
