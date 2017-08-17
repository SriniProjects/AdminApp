package com.adminapp.optimustechproject.adminapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.adminapp.optimustechproject.adminapp.app.DbHandler;
import com.google.gson.Gson;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by satyam on 13/8/17.
 */

public class adapter_notification extends RecyclerView.Adapter<adapter_notification.view_holder> {


    Context context;
    Gson gson=new Gson();
    public List<NotificationsPOJO> data=new ArrayList<NotificationsPOJO>();

    public adapter_notification(Context context, List<NotificationsPOJO> data) {
        this.context=context;
        this.data=data;
    }

    public class view_holder extends RecyclerView.ViewHolder {
        TextView title, message;
        ImageView close;

        public view_holder(View itemView) {
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.title);
            message = (TextView) itemView.findViewById(R.id.message);
            close = (ImageView) itemView.findViewById(R.id.close);

        }
    }

    @Override
    public view_holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_notification, parent, false);
        return new view_holder(view);
    }

    @Override
    public void onBindViewHolder(view_holder holder, final int position) {
        holder.title.setText(data.get(position).getTitle());
        holder.message.setText(data.get(position).getMessage());
        holder.close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data.remove(position);
                DbHandler.putString(context, "notificationList", gson.toJson(data));
                Toast.makeText(context,"Notification removed",Toast.LENGTH_LONG).show();
                context.startActivity(new Intent(context,NotificationActivity.class));
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}

