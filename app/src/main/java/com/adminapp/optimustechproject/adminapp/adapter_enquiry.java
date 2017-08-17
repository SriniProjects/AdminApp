package com.adminapp.optimustechproject.adminapp;

import android.app.FragmentManager;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by satyam on 5/8/17.
 */


public class adapter_enquiry extends RecyclerView.Adapter<adapter_enquiry.view_holder>{

    Context context;
    public List<LoginDataumPOJO> data=new ArrayList<LoginDataumPOJO>();
    FragmentManager fragmentManager;

    public adapter_enquiry(Context context, List<LoginDataumPOJO> data,FragmentManager fragmentManager) {
        this.context=context;
        this.data=data;
        this.fragmentManager=fragmentManager;
    }



    public class view_holder extends RecyclerView.ViewHolder{
        TextView title,date,view_details;
        public view_holder(View itemView) {
            super(itemView);

            title=(TextView)itemView.findViewById(R.id.title);
            date=(TextView)itemView.findViewById(R.id.date);
            view_details=(TextView)itemView.findViewById(R.id.view_details);

        }
    }
    @Override
    public view_holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_enquiry,parent,false);
        return new view_holder(view);
    }

    @Override
    public void onBindViewHolder(adapter_enquiry.view_holder holder,final int position) {
        holder.title.setText(data.get(position).getTrainingTitle());
        holder.date.setText(data.get(position).getSendDateTime());
        holder.view_details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog_enquiry_details dialog= dialog_enquiry_details.instance(data.get(position).getTrainerName(),data.get(position).getTrainerMobile(),data.get(position).getTrainerEmail(),data.get(position).getUserName(),data.get(position).getUserMobile(),data.get(position).getUserEmail(),data.get(position).getSendDateTime(),data.get(position).getTrainingTitle());
                dialog.show(fragmentManager,"Enquiry");
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

}