package com.freelancer.freelancer.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "workenclosure")
public class WorkEnclosure {

    @Id
    private int w_id;
    private String description;

    public WorkEnclosure(int w_id, String description) {
        this.w_id = w_id;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}