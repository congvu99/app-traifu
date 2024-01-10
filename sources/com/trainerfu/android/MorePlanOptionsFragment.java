package com.trainerfu.android;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

public class MorePlanOptionsFragment extends Fragment {
    private int currentPlanIndex;
    /* access modifiers changed from: private */
    public boolean forClientPlan = false;
    private boolean showCurrentAndUpcoming = true;

    public interface EventListener {
        void addUpcomingPlanClicked();

        void copyFromPlanTemplateClicked();

        void copyTemplateToClientsClicked();

        void copyTemplateToGroupsClicked();

        void togglePlansClicked();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        View inflate = layoutInflater.inflate(R.layout.more_plan_options_view, viewGroup, false);
        Bundle arguments = getArguments();
        this.showCurrentAndUpcoming = arguments.getBoolean("show_current_and_upcoming");
        this.forClientPlan = arguments.getBoolean("for_client_plan");
        this.currentPlanIndex = arguments.getInt("current_plan_index");
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.add_upcoming_plan);
        TextView textView = (TextView) inflate.findViewById(R.id.add_text);
        LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(R.id.copy_from_plan_template);
        TextView textView2 = (TextView) inflate.findViewById(R.id.copy_text);
        LinearLayout linearLayout3 = (LinearLayout) inflate.findViewById(R.id.copy_template_to_groups);
        TextView textView3 = (TextView) inflate.findViewById(R.id.copy_template_text);
        LinearLayout linearLayout4 = (LinearLayout) inflate.findViewById(R.id.toggle_plans_view);
        TextView textView4 = (TextView) inflate.findViewById(R.id.toggle_plan);
        if (this.showCurrentAndUpcoming) {
            textView4.setText(R.string.seePastPlans);
        } else {
            linearLayout.setVisibility(8);
            linearLayout2.setVisibility(8);
            textView4.setText(R.string.seeCurrentAndUpcoming);
        }
        if (!this.forClientPlan) {
            textView.setText(R.string.addNextWeeksPlan);
            textView2.setText(R.string.copyTemplateToClients);
            linearLayout3.setVisibility(0);
            linearLayout4.setVisibility(8);
            textView3.setText(R.string.copyTemplateToGroups);
        } else {
            textView.setText(R.string.addUpcomingPlan);
            textView2.setText(R.string.copyFromPlanTemplate);
            linearLayout3.setVisibility(8);
            linearLayout4.setVisibility(0);
        }
        if (this.currentPlanIndex > 0) {
            linearLayout4.setVisibility(0);
        } else {
            linearLayout4.setVisibility(8);
        }
        linearLayout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ((EventListener) MorePlanOptionsFragment.this.getParentFragment()).addUpcomingPlanClicked();
            }
        });
        linearLayout2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (MorePlanOptionsFragment.this.forClientPlan) {
                    ((EventListener) MorePlanOptionsFragment.this.getParentFragment()).copyFromPlanTemplateClicked();
                } else {
                    ((EventListener) MorePlanOptionsFragment.this.getParentFragment()).copyTemplateToClientsClicked();
                }
            }
        });
        linearLayout4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ((EventListener) MorePlanOptionsFragment.this.getParentFragment()).togglePlansClicked();
            }
        });
        linearLayout3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ((EventListener) MorePlanOptionsFragment.this.getParentFragment()).copyTemplateToGroupsClicked();
            }
        });
        return inflate;
    }
}
