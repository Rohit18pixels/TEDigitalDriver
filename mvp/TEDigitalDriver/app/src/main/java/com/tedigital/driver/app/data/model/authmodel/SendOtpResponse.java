package com.tedigital.driver.app.data.model.authmodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Kamlesh Yadav on 13-07-2020.
 * Eighteen Pixels India Private Limited Lucknow U.P
 * kamlesh@18pixels.com
 */
public class SendOtpResponse {
    @SerializedName("userId")
    @Expose
    private String userId;
    @SerializedName("userFriendlyId")
    @Expose
    private String userFriendlyId;
    @SerializedName("profile")
    @Expose
    private Object profile;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserFriendlyId() {
        return userFriendlyId;
    }

    public void setUserFriendlyId(String userFriendlyId) {
        this.userFriendlyId = userFriendlyId;
    }

    public Object getProfile() {
        return profile;
    }

    public void setProfile(Object profile) {
        this.profile = profile;
    }

}
