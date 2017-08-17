package com.adminapp.optimustechproject.adminapp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by satyam on 5/8/17.
 */

public class LoginPOJO {

    @SerializedName("error")
    @Expose
    private Boolean error;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private List<LoginDataumPOJO> data = null;

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<LoginDataumPOJO> getData() {
        return data;
    }

    public void setData(List<LoginDataumPOJO> data) {
        this.data = data;
    }

}
