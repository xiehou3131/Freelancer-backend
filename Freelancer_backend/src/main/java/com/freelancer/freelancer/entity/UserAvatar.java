package com.freelancer.freelancer.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "useravatar")
public class UserAvatar {

    @Id
    private int u_id;
    private String avator;

    public UserAvatar(int u_id, String avator) {
        this.u_id = u_id;
        this.avator = avator;
    }

    public String getAvator() {
        return avator;
    }

    public void setAvator(String avator) {
        this.avator = avator;
    }

}