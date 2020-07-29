package com.freelancer.freelancer.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "user")
@JsonIgnoreProperties(value = { "handler", "hibernateLazyInitializer", "fieldHandler" })
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "u_id")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int u_id;
    private String name;
    private String password;
    private String phone;
    private String e_mail;
    private String true_name;
    private String credit_card;
    private int type;
    private int is_banned;

    @Transient
    private String avatar;
    public String getAvatar() { return avatar; }

    public void setAvatar(String avatar) { this.avatar = avatar; }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }
    public void setPassword(String str){
        password = str;
    }

    public int getU_id() {
        return u_id;
    }

    public int getType() {
        return type;
    }

    public int getIs_banned() {
        return is_banned;
    }
}
