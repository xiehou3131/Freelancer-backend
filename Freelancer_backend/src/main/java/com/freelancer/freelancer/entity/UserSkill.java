package com.freelancer.freelancer.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "userSkill")
@JsonIgnoreProperties(value = {"handler","hibernateLazyInitializer","fieldHandler"})
public class UserSkill {

    private UserSkillPK userSkillPK;

    @EmbeddedId
    public UserSkillPK getUserSkillPk() { return this.userSkillPK; }

    public void setUserSkillPk(UserSkillPK userSkillPk) { this.userSkillPK = userSkillPk; }

}