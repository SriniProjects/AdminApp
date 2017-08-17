package com.adminapp.optimustechproject.adminapp;

import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by satyam on 7/8/17.
 */

public class dialog_enquiry_details extends DialogFragment {

    View view;
    TextView tName,tMob,tEmail,lName,lMob,lEmail,date,training;
    Button close;

    public static dialog_enquiry_details instance(String trainer_name,String trainer_mobile,String trainer_email,String user_name,String user_mobile,String user_email,String date,String title){

        dialog_enquiry_details dialog_enquiry=new dialog_enquiry_details();
        Bundle b=new Bundle();
        b.putString("trainer_name",trainer_name);
        b.putString("trainer_mobile",trainer_mobile);
        b.putString("trainer_email",trainer_email);
        b.putString("user_name",user_name);
        b.putString("user_mobile",user_mobile);
        b.putString("user_email",user_email);
        b.putString("date",date);
        b.putString("title",title);
        dialog_enquiry.setArguments(b);
        return dialog_enquiry;
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        final LayoutInflater inflater = getActivity().getLayoutInflater();
        view = inflater.inflate(R.layout.dialog_enquiry_details, null);
        builder.setView(view);

        tName=(TextView)view.findViewById(R.id.tName);
        tMob=(TextView)view.findViewById(R.id.tMobile);
        tEmail=(TextView)view.findViewById(R.id.tEmail);

        lName=(TextView)view.findViewById(R.id.lName);
        lMob=(TextView)view.findViewById(R.id.lMobile);
        lEmail=(TextView)view.findViewById(R.id.lEmail);

        date=(TextView)view.findViewById(R.id.date);
        training=(TextView)view.findViewById(R.id.training);

        close=(Button) view.findViewById(R.id.close);

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        date.setHint(getArguments().getString("date"));
        training.setText(getArguments().getString("title"));

        tName.setText(getArguments().getString("trainer_name"));
        tMob.setText(getArguments().getString("trainer_mobile"));
        tEmail.setText(getArguments().getString("trainer_email"));
        lName.setText(getArguments().getString("user_name"));
        lMob.setText(getArguments().getString("user_mobile"));
        lEmail.setText(getArguments().getString("user_email"));

        return builder.create();

    }
}
