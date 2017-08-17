package com.adminapp.optimustechproject.adminapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.adminapp.optimustechproject.adminapp.app.DbHandler;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EnquiryActivity extends AppCompatActivity {

    RecyclerView mrecyclerView;
    LinearLayoutManager mlinearLayoutManager;
    adapter_enquiry mAdapter;
    Gson gson=new Gson();
    //ImageView sort;
    Toolbar toolbar;
    int flg=0;
    List<LoginDataumPOJO> data=new ArrayList<LoginDataumPOJO>();
    ImageView notification;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enquiry);

        toolbar=(Toolbar)findViewById(R.id.toolbar);
        toolbar.setTitle("Enquiries");
        setSupportActionBar(toolbar);

        //sort=(ImageView)findViewById(R.id.sort);

        notification=(ImageView)findViewById(R.id.notifications);

        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EnquiryActivity.this,NotificationActivity.class));

            }
        });

        Type type = new TypeToken<List<LoginDataumPOJO>>() {}.getType();

        data=gson.fromJson(DbHandler.getString(this,"enquiries","{}"),type);

//        Log.e("data2354",String.valueOf(data.get(0).getSendDateTime())+String.valueOf(data.get(1).getSendDateTime()));

        mrecyclerView = (RecyclerView) findViewById(R.id.recycler);
        mlinearLayoutManager = new LinearLayoutManager(getApplicationContext());
        mrecyclerView.setLayoutManager(mlinearLayoutManager);
        mAdapter = new adapter_enquiry(this, data,getFragmentManager());
        mrecyclerView.setAdapter(mAdapter);

    }
}
