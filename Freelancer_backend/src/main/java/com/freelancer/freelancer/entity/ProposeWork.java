package com.freelancer.freelancer.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@IdClass(ProposeWorkPK.class)
@Table(name = "proposeWork")
@JsonIgnoreProperties(value = {"handler","hibernateLazyInitializer","fieldHandler"})
public class ProposeWork {

    @Id
    private int u_id;

    @Id
    private int w_id;

    private Double expectPayment;
    private String remark;

}