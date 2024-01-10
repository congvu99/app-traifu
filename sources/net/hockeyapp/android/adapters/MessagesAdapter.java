package net.hockeyapp.android.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import net.hockeyapp.android.objects.FeedbackMessage;
import net.hockeyapp.android.views.FeedbackMessageView;

public class MessagesAdapter extends BaseAdapter {
    private TextView authorTextView;
    private Context context;
    private Date date;
    private TextView dateTextView;
    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
    private SimpleDateFormat formatNew = new SimpleDateFormat("d MMM h:mm a");
    private TextView messageTextView;
    private ArrayList<FeedbackMessage> messagesList;

    public long getItemId(int i) {
        return (long) i;
    }

    public MessagesAdapter(Context context2, ArrayList<FeedbackMessage> arrayList) {
        this.context = context2;
        this.messagesList = arrayList;
    }

    public int getCount() {
        return this.messagesList.size();
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        FeedbackMessageView feedbackMessageView;
        FeedbackMessage feedbackMessage = this.messagesList.get(i);
        if (view == null) {
            feedbackMessageView = new FeedbackMessageView(this.context);
        } else {
            feedbackMessageView = (FeedbackMessageView) view;
        }
        if (feedbackMessage != null) {
            this.authorTextView = (TextView) feedbackMessageView.findViewById(FeedbackMessageView.AUTHOR_TEXT_VIEW_ID);
            this.dateTextView = (TextView) feedbackMessageView.findViewById(FeedbackMessageView.DATE_TEXT_VIEW_ID);
            this.messageTextView = (TextView) feedbackMessageView.findViewById(FeedbackMessageView.MESSAGE_TEXT_VIEW_ID);
            try {
                Date parse = this.format.parse(feedbackMessage.getCreatedAt());
                this.date = parse;
                this.dateTextView.setText(this.formatNew.format(parse));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            this.authorTextView.setText(feedbackMessage.getName());
            this.messageTextView.setText(feedbackMessage.getText());
        }
        feedbackMessageView.setFeedbackMessageViewBgAndTextColor(i % 2 == 0 ? 0 : 1);
        return feedbackMessageView;
    }

    public Object getItem(int i) {
        return this.messagesList.get(i);
    }

    public void clear() {
        ArrayList<FeedbackMessage> arrayList = this.messagesList;
        if (arrayList != null) {
            arrayList.clear();
        }
    }

    public void add(FeedbackMessage feedbackMessage) {
        ArrayList<FeedbackMessage> arrayList;
        if (feedbackMessage != null && (arrayList = this.messagesList) != null) {
            arrayList.add(feedbackMessage);
        }
    }
}
