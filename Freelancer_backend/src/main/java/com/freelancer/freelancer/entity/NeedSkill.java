package com.freelancer.freelancer.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@IdClass(NeedSkillPK.class)
@Table(name = "needSkill")
@JsonIgnoreProperties(value = {"handler","hibernateLazyInitializer","fieldHandler"})
public class NeedSkill {

    @Id
    private int w_id;

    @Id
    private int s_id;

    private int type;

}