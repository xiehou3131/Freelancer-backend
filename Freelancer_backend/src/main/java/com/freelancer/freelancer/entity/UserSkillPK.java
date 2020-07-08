package com.freelancer.freelancer.entity;

import lombok.Data;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Objects;

@Embeddable
public class UserSkillPK implements Serializable {
    private Integer uId;
    private Integer sId;

    @Column(name = "u_id")
    public Integer getuId() { return uId; }

    public void setuId(Integer uId) { this.uId = uId; }

    @Column(name = "s_id")
    public Integer getsId() { return sId; }

    public void setsId(Integer sId) { this.sId = sId; }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        UserSkillPK pk = (UserSkillPK) o;
        return Objects.equals(uId, pk.uId) && Objects.equals(sId, pk.sId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uId, sId);
    }
}