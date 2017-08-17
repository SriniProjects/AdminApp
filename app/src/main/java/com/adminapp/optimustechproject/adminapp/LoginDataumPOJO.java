package com.adminapp.optimustechproject.adminapp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by satyam on 5/8/17.
 */

public class LoginDataumPOJO {

    @SerializedName("enq_id")
    @Expose
    private String enqId;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("send_date_time")
    @Expose
    private String sendDateTime;
    @SerializedName("user_name")
    @Expose
    private String userName;
    @SerializedName("user_email")
    @Expose
    private String userEmail;
    @SerializedName("user_mobile")
    @Expose
    private String userMobile;
    @SerializedName("training_title")
    @Expose
    private String trainingTitle;
    @SerializedName("trainer_id")
    @Expose
    private String trainerId;
    @SerializedName("trainer_name")
    @Expose
    private String trainerName;
    @SerializedName("trainer_email")
    @Expose
    private String trainerEmail;
    @SerializedName("trainer_mobile")
    @Expose
    private String trainerMobile;

    public String getEnqId() {
        return enqId;
    }

    public void setEnqId(String enqId) {
        this.enqId = enqId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSendDateTime() {
        return sendDateTime;
    }

    public void setSendDateTime(String sendDateTime) {
        this.sendDateTime = sendDateTime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    public String getTrainingTitle() {
        return trainingTitle;
    }

    public void setTrainingTitle(String trainingTitle) {
        this.trainingTitle = trainingTitle;
    }

    public String getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(String trainerId) {
        this.trainerId = trainerId;
    }

    public String getTrainerName() {
        return trainerName;
    }

    public void setTrainerName(String trainerName) {
        this.trainerName = trainerName;
    }

    public String getTrainerEmail() {
        return trainerEmail;
    }

    public void setTrainerEmail(String trainerEmail) {
        this.trainerEmail = trainerEmail;
    }

    public String getTrainerMobile() {
        return trainerMobile;
    }

    public void setTrainerMobile(String trainerMobile) {
        this.trainerMobile = trainerMobile;
    }

}
