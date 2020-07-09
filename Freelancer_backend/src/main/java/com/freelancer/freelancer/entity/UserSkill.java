package com.freelancer.freelancer.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "userSkill")
@IdClass(UserSkillPK.class)
@JsonIgnoreProperties(value = {"handler","hibernateLazyInitializer","fieldHandler"})
public class UserSkill implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @JoinColumn(name="u_id")
    private Integer uId;

    @Id
    @JoinColumn(name="s_id")
    private Integer sId;

}