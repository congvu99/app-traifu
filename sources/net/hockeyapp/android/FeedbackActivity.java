package net.hockeyapp.android;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import net.hockeyapp.android.adapters.MessagesAdapter;
import net.hockeyapp.android.objects.ErrorObject;
import net.hockeyapp.android.objects.FeedbackMessage;
import net.hockeyapp.android.objects.FeedbackResponse;
import net.hockeyapp.android.tasks.ParseFeedbackTask;
import net.hockeyapp.android.tasks.SendFeedbackTask;
import net.hockeyapp.android.utils.PrefsUtil;
import net.hockeyapp.android.views.FeedbackView;

public class FeedbackActivity extends Activity implements FeedbackActivityInterface, View.OnClickListener {
    private final int DIALOG_ERROR_ID = 0;
    private Button addResponseButton;
    /* access modifiers changed from: private */
    public Context context;
    private EditText emailInput;
    /* access modifiers changed from: private */
    public ErrorObject error;
    private Handler feedbackHandler;
    /* access modifiers changed from: private */
    public ArrayList<FeedbackMessage> feedbackMessages;
    private ScrollView feedbackScrollView;
    /* access modifiers changed from: private */
    public boolean inSendFeedback;
    /* access modifiers changed from: private */
    public TextView lastUpdatedTextView;
    /* access modifiers changed from: private */
    public MessagesAdapter messagesAdapter;
    /* access modifiers changed from: private */
    public ListView messagesListView;
    private EditText nameInput;
    private Handler parseFeedbackHandler;
    private ParseFeedbackTask parseFeedbackTask;
    private Button refreshButton;
    private Button sendFeedbackButton;
    private SendFeedbackTask sendFeedbackTask;
    private EditText subjectInput;
    private EditText textInput;
    private String token;
    private String url;
    private LinearLayout wrapperLayoutFeedbackAndMessages;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(getLayoutView());
        setTitle("Feedback");
        this.context = this;
        this.inSendFeedback = false;
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.url = extras.getString("url");
        }
        initFeedbackHandler();
        initParseFeedbackHandler();
        configureAppropriateView();
    }

    private void configureAppropriateView() {
        String feedbackTokenFromPrefs = PrefsUtil.getInstance().getFeedbackTokenFromPrefs(this);
        this.token = feedbackTokenFromPrefs;
        if (feedbackTokenFromPrefs == null) {
            configureFeedbackView(false);
            return;
        }
        configureFeedbackView(true);
        sendFetchFeedback(this.url, (String) null, (String) null, (String) null, (String) null, this.token, this.feedbackHandler, true);
    }

    /* access modifiers changed from: private */
    public void resetFeedbackView() {
        runOnUiThread(new Runnable() {
            public void run() {
                PrefsUtil.getInstance().saveFeedbackTokenToPrefs(FeedbackActivity.this, (String) null);
                FeedbackActivity.this.configureFeedbackView(false);
            }
        });
    }

    private void initFeedbackHandler() {
        this.feedbackHandler = new Handler() {
            public void handleMessage(Message message) {
                ErrorObject unused = FeedbackActivity.this.error = new ErrorObject();
                boolean z = false;
                if (message == null || message.getData() == null) {
                    FeedbackActivity.this.error.setMessage("Message couldn't be posted. Please check your input values and try again.");
                } else {
                    Bundle data = message.getData();
                    String string = data.getString("feedback_response");
                    String string2 = data.getString("feedback_status");
                    String string3 = data.getString("request_type");
                    if (!string3.equals("send") || (string != null && Integer.parseInt(string2) == 201)) {
                        if (!string3.equals("fetch") || !(Integer.parseInt(string2) == 404 || Integer.parseInt(string2) == 422)) {
                            FeedbackActivity.this.startParseFeedbackTask(string);
                        } else {
                            FeedbackActivity.this.resetFeedbackView();
                        }
                        z = true;
                    } else {
                        FeedbackActivity.this.error.setMessage("Message couldn't be posted. Please check your input values and try again.");
                    }
                }
                if (!z) {
                    FeedbackActivity.this.runOnUiThread(new Runnable() {
                        public void run() {
                            FeedbackActivity.this.enableDisableSendFeedbackButton(true);
                            FeedbackActivity.this.showDialog(0);
                        }
                    });
                }
            }
        };
    }

    private void initParseFeedbackHandler() {
        this.parseFeedbackHandler = new Handler() {
            public void handleMessage(Message message) {
                FeedbackResponse feedbackResponse;
                ErrorObject unused = FeedbackActivity.this.error = new ErrorObject();
                boolean z = false;
                if (!(message == null || message.getData() == null || (feedbackResponse = (FeedbackResponse) message.getData().getSerializable("parse_feedback_response")) == null || !feedbackResponse.getStatus().equalsIgnoreCase("success"))) {
                    if (feedbackResponse.getToken() != null) {
                        PrefsUtil.getInstance().saveFeedbackTokenToPrefs(FeedbackActivity.this.context, feedbackResponse.getToken());
                        FeedbackActivity.this.loadFeedbackMessages(feedbackResponse);
                        boolean unused2 = FeedbackActivity.this.inSendFeedback = false;
                    }
                    z = true;
                }
                if (!z) {
                    FeedbackActivity.this.runOnUiThread(new Runnable() {
                        public void run() {
                            FeedbackActivity.this.showDialog(0);
                        }
                    });
                }
                FeedbackActivity.this.enableDisableSendFeedbackButton(true);
            }
        };
    }

    /* access modifiers changed from: protected */
    public void configureFeedbackView(boolean z) {
        this.feedbackScrollView = (ScrollView) findViewById(FeedbackView.FEEDBACK_SCROLLVIEW_ID);
        this.wrapperLayoutFeedbackAndMessages = (LinearLayout) findViewById(FeedbackView.WRAPPER_LAYOUT_FEEDBACK_AND_MESSAGES_ID);
        this.messagesListView = (ListView) findViewById(FeedbackView.MESSAGES_LISTVIEW_ID);
        if (z) {
            this.wrapperLayoutFeedbackAndMessages.setVisibility(0);
            this.feedbackScrollView.setVisibility(8);
            this.lastUpdatedTextView = (TextView) findViewById(8192);
            Button button = (Button) findViewById(FeedbackView.ADD_RESPONSE_BUTTON_ID);
            this.addResponseButton = button;
            button.setOnClickListener(this);
            Button button2 = (Button) findViewById(FeedbackView.REFRESH_BUTTON_ID);
            this.refreshButton = button2;
            button2.setOnClickListener(this);
            return;
        }
        this.wrapperLayoutFeedbackAndMessages.setVisibility(8);
        this.feedbackScrollView.setVisibility(0);
        this.nameInput = (EditText) findViewById(8194);
        this.emailInput = (EditText) findViewById(FeedbackView.EMAIL_EDIT_TEXT_ID);
        this.subjectInput = (EditText) findViewById(FeedbackView.SUBJECT_EDIT_TEXT_ID);
        this.textInput = (EditText) findViewById(FeedbackView.TEXT_EDIT_TEXT_ID);
        String nameEmailFromPrefs = PrefsUtil.getInstance().getNameEmailFromPrefs(this.context);
        if (nameEmailFromPrefs != null) {
            String[] split = nameEmailFromPrefs.split("\\|");
            if (split != null && split.length == 3) {
                this.nameInput.setText(split[0]);
                this.emailInput.setText(split[1]);
                this.subjectInput.setText(split[2]);
            }
        } else {
            this.nameInput.setText("");
            this.emailInput.setText("");
            this.subjectInput.setText("");
        }
        this.textInput.setText("");
        if (PrefsUtil.getInstance().getFeedbackTokenFromPrefs(this.context) != null) {
            this.subjectInput.setVisibility(8);
        } else {
            this.subjectInput.setVisibility(0);
        }
        Button button3 = (Button) findViewById(FeedbackView.SEND_FEEDBACK_BUTTON_ID);
        this.sendFeedbackButton = button3;
        button3.setOnClickListener(this);
    }

    public ViewGroup getLayoutView() {
        return new FeedbackView(this);
    }

    /* access modifiers changed from: private */
    public void loadFeedbackMessages(final FeedbackResponse feedbackResponse) {
        runOnUiThread(new Runnable() {
            public void run() {
                FeedbackActivity.this.configureFeedbackView(true);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
                SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("d MMM h:mm a");
                FeedbackResponse feedbackResponse = feedbackResponse;
                if (feedbackResponse != null && feedbackResponse.getFeedback() != null && feedbackResponse.getFeedback().getMessages() != null && feedbackResponse.getFeedback().getMessages().size() > 0) {
                    ArrayList unused = FeedbackActivity.this.feedbackMessages = feedbackResponse.getFeedback().getMessages();
                    Collections.reverse(FeedbackActivity.this.feedbackMessages);
                    try {
                        Date parse = simpleDateFormat.parse(((FeedbackMessage) FeedbackActivity.this.feedbackMessages.get(0)).getCreatedAt());
                        FeedbackActivity.this.lastUpdatedTextView.setText(String.format("Last Updated: %s", new Object[]{simpleDateFormat2.format(parse)}));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    if (FeedbackActivity.this.messagesAdapter == null) {
                        MessagesAdapter unused2 = FeedbackActivity.this.messagesAdapter = new MessagesAdapter(FeedbackActivity.this.context, FeedbackActivity.this.feedbackMessages);
                    } else {
                        FeedbackActivity.this.messagesAdapter.clear();
                        Iterator it = FeedbackActivity.this.feedbackMessages.iterator();
                        while (it.hasNext()) {
                            FeedbackActivity.this.messagesAdapter.add((FeedbackMessage) it.next());
                        }
                        FeedbackActivity.this.messagesAdapter.notifyDataSetChanged();
                    }
                    FeedbackActivity.this.messagesListView.setAdapter(FeedbackActivity.this.messagesAdapter);
                }
            }
        });
    }

    private void sendFeedback() {
        enableDisableSendFeedbackButton(false);
        if (this.nameInput.getText().toString().trim().length() <= 0 || this.emailInput.getText().toString().trim().length() <= 0 || this.subjectInput.getText().toString().trim().length() <= 0 || this.textInput.getText().toString().trim().length() <= 0) {
            ErrorObject errorObject = new ErrorObject();
            this.error = errorObject;
            errorObject.setMessage("Please provide all details");
            showDialog(0);
            enableDisableSendFeedbackButton(true);
            return;
        }
        PrefsUtil.getInstance().saveNameEmailSubjectToPrefs(this.context, this.nameInput.getText().toString(), this.emailInput.getText().toString(), this.subjectInput.getText().toString());
        sendFetchFeedback(this.url, this.nameInput.getText().toString(), this.emailInput.getText().toString(), this.subjectInput.getText().toString(), this.textInput.getText().toString(), PrefsUtil.getInstance().getFeedbackTokenFromPrefs(this.context), this.feedbackHandler, false);
    }

    private void sendFetchFeedback(String str, String str2, String str3, String str4, String str5, String str6, Handler handler, boolean z) {
        SendFeedbackTask sendFeedbackTask2 = new SendFeedbackTask(this.context, str, str2, str3, str4, str5, str6, handler, z);
        this.sendFeedbackTask = sendFeedbackTask2;
        sendFeedbackTask2.execute(new Void[0]);
    }

    /* access modifiers changed from: private */
    public void startParseFeedbackTask(String str) {
        createParseFeedbackTask(str);
        this.parseFeedbackTask.execute(new Void[0]);
    }

    private void createParseFeedbackTask(String str) {
        this.parseFeedbackTask = new ParseFeedbackTask(this, str, this.parseFeedbackHandler);
    }

    public void enableDisableSendFeedbackButton(boolean z) {
        Button button = this.sendFeedbackButton;
        if (button != null) {
            button.setEnabled(z);
        }
    }

    public Object onRetainNonConfigurationInstance() {
        SendFeedbackTask sendFeedbackTask2 = this.sendFeedbackTask;
        if (sendFeedbackTask2 != null) {
            sendFeedbackTask2.detach();
        }
        return this.sendFeedbackTask;
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id != 8201) {
            switch (id) {
                case FeedbackView.ADD_RESPONSE_BUTTON_ID /*131088*/:
                    configureFeedbackView(false);
                    this.inSendFeedback = true;
                    return;
                case FeedbackView.REFRESH_BUTTON_ID /*131089*/:
                    sendFetchFeedback(this.url, (String) null, (String) null, (String) null, (String) null, PrefsUtil.getInstance().getFeedbackTokenFromPrefs(this.context), this.feedbackHandler, true);
                    return;
                default:
                    return;
            }
        } else {
            sendFeedback();
        }
    }

    /* access modifiers changed from: protected */
    public Dialog onCreateDialog(int i) {
        if (i != 0) {
            return null;
        }
        return new AlertDialog.Builder(this).setMessage("An error has occured").setCancelable(false).setTitle("Error").setIcon(17301543).setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                ErrorObject unused = FeedbackActivity.this.error = null;
                dialogInterface.cancel();
            }
        }).create();
    }

    /* access modifiers changed from: protected */
    public void onPrepareDialog(int i, Dialog dialog) {
        if (i == 0) {
            AlertDialog alertDialog = (AlertDialog) dialog;
            ErrorObject errorObject = this.error;
            if (errorObject != null) {
                alertDialog.setMessage(errorObject.getMessage());
            } else {
                alertDialog.setMessage("An error has occured");
            }
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        if (this.inSendFeedback) {
            this.inSendFeedback = false;
            configureAppropriateView();
            return true;
        }
        finish();
        return true;
    }
}
