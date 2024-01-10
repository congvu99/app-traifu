package org.jsoup.nodes;

import com.facebook.internal.ServerProtocol;
import org.jsoup.nodes.Document;

public class XmlDeclaration extends Node {
    static final String DECL_KEY = "declaration";
    private final boolean isProcessingInstruction;

    public String nodeName() {
        return "#declaration";
    }

    /* access modifiers changed from: package-private */
    public void outerHtmlTail(StringBuilder sb, int i, Document.OutputSettings outputSettings) {
    }

    public XmlDeclaration(String str, String str2, boolean z) {
        super(str2);
        this.attributes.put(DECL_KEY, str);
        this.isProcessingInstruction = z;
    }

    public String getWholeDeclaration() {
        String str = this.attributes.get(DECL_KEY);
        if (!str.equals("xml") || this.attributes.size() <= 1) {
            return this.attributes.get(DECL_KEY);
        }
        StringBuilder sb = new StringBuilder(str);
        String str2 = this.attributes.get(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION);
        if (str2 != null) {
            sb.append(" version=\"");
            sb.append(str2);
            sb.append("\"");
        }
        String str3 = this.attributes.get("encoding");
        if (str3 != null) {
            sb.append(" encoding=\"");
            sb.append(str3);
            sb.append("\"");
        }
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public void outerHtmlHead(StringBuilder sb, int i, Document.OutputSettings outputSettings) {
        sb.append("<");
        sb.append(this.isProcessingInstruction ? "!" : "?");
        sb.append(getWholeDeclaration());
        sb.append(">");
    }

    public String toString() {
        return outerHtml();
    }
}
