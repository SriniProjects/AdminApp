package com.adminapp.optimustechproject.adminapp;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.adminapp.optimustechproject.adminapp.app.ColoredSnackbar;
import com.adminapp.optimustechproject.adminapp.app.DbHandler;
import com.adminapp.optimustechproject.adminapp.app.NetworkCheck;
import com.adminapp.optimustechproject.adminapp.app.ServiceGenerator;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    EditText username;
    EditText password;
    Button login;
    Toolbar toolbar;

    ProgressDialog progressDialog;
    private boolean doubleBackToExitPressedOnce = false;
    private ColoredSnackbar coloredSnackBar;

    Gson gson=new Gson();

    private View.OnClickListener snackBarListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            login();
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        toolbar=(Toolbar)findViewById(R.id.toolbar);
        toolbar.setTitle("Login");
        setSupportActionBar(toolbar);

        username=(EditText)findViewById(R.id.username);
        password=(EditText)findViewById(R.id.password);

        login=(Button)findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(username.getText().toString().equals("")){
                    username.setError("Username required");
                }
                if(password.getText().toString().equals("")){
                    password.setError("Password required");
                }

                if(!username.getText().toString().equals("") && !password.getText().toString().equals("")) {
                    login();
                }


            }
        });

    }

    public void login(){

        if(NetworkCheck.isNetworkAvailable(LoginActivity.this)){

            progressDialog=new ProgressDialog(LoginActivity.this);
            progressDialog.setCancelable(false);
            progressDialog.setMessage("Authenticating");
            progressDialog.show();

            LoginRequest loginRequest= ServiceGenerator.createService(LoginRequest.class,username.getText().toString(),password.getText().toString());
            Call<LoginPOJO> call=loginRequest.requestResponse(FirebaseInstanceId.getInstance().getToken());
            call.enqueue(new Callback<LoginPOJO>() {
                @Override
                public void onResponse(Call<LoginPOJO> call, Response<LoginPOJO> response) {
                    if(response.code()==200){
                        progressDialog.dismiss();
                        Log.e("login",String.valueOf(response.body().getError()));
                        List<LoginDataumPOJO> data=new ArrayList<LoginDataumPOJO>();
                        data=response.body().getData();
                        if(!response.body().getError()){
                            Toast.makeText(LoginActivity.this,response.body().getMessage(),Toast.LENGTH_LONG).show();
                            //DbHandler.setSession(LoginActivity.this,gson.toJson(data),data.getToken());
                            DbHandler.putString(LoginActivity.this,"enquiries",gson.toJson(data));
                            Intent intent = new Intent(LoginActivity.this, EnquiryActivity.class);
                            startActivity(intent);
                            finish();
                        }
                        else{
                            new AlertDialog.Builder(LoginActivity.this)
                                    .setMessage(response.body().getMessage())
                                    .setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            // onBackPressed();
                                        }
                                    }).show();

                        }
                    }
                    else{
                        progressDialog.dismiss();
                        Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), "Error connecting to server", Snackbar.LENGTH_SHORT);
                        coloredSnackBar.warning(snackbar).show();
                    }
                }

                @Override
                public void onFailure(Call<LoginPOJO> call, Throwable t) {
                    progressDialog.dismiss();
                    Log.e("loginerror",String.valueOf(t));
                    Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), "Error connecting to server", Snackbar.LENGTH_SHORT);
                    coloredSnackBar.warning(snackbar).show();
                }
            });


        }

        else{
            Snackbar snackbar=Snackbar.make(findViewById(android.R.id.content),"No internet connection", Snackbar.LENGTH_LONG).setAction("Retry", snackBarListener);
            coloredSnackBar.alert(snackbar).show();
        }
    }

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            this.finishAffinity();
            return;
        }

        this.doubleBackToExitPressedOnce = true;

        Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), "Press back again to exit", Snackbar.LENGTH_SHORT);
        coloredSnackBar.warning(snackbar).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);
    }

}
