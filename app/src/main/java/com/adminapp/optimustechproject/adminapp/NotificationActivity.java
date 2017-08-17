package com.adminapp.optimustechproject.adminapp;

import android.support.constraint.solver.SolverVariable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.adminapp.optimustechproject.adminapp.app.DbHandler;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class NotificationActivity extends AppCompatActivity {
    RecyclerView mrecyclerView;
    LinearLayoutManager linearLayoutManager;
    adapter_notification mAdapter;
    List<NotificationsPOJO> data=new ArrayList<NotificationsPOJO>();
    Gson gson=new Gson();
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        toolbar=(Toolbar)findViewById(R.id.toolbar);
        toolbar.setTitle("Notification");
        setSupportActionBar(toolbar);

        Type type = new TypeToken<List<NotificationsPOJO>>() {}.getType();

        if(DbHandler.contains(this,"notificationList")) {
            data = gson.fromJson(DbHandler.getString(this, "notificationList", ""), type);
            mrecyclerView = (RecyclerView) findViewById(R.id.recycler);
            // mrecyclerView.addItemDecoration(new SpacesItemDecoration(spacingInPixels));
            if (!data.toString().equals("")) {
                assert mrecyclerView != null;
                mrecyclerView.setHasFixedSize(true);
                linearLayoutManager = new LinearLayoutManager(this);
                mrecyclerView.setLayoutManager(linearLayoutManager);
                mAdapter = new adapter_notification(this, data);
                mrecyclerView.setAdapter(mAdapter);
            }
        }
    }

}