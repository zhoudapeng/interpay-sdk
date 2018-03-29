package com.ipaynow.sdk.entity;

import com.ipaynow.sdk.enumeration.Profile;

public class IpaynowConfig {
    private String appId;
    private String appKey;
    private Profile profile;

    public IpaynowConfig() {
    }

    public IpaynowConfig(String appId, String appKey, Profile profile) {
        this.appId = appId;
        this.appKey = appKey;
        this.profile = profile;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
}
