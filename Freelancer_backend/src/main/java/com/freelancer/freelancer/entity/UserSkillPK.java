package com.freelancer.freelancer.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

@Data
public class UserSkillPK implements Serializable {
    private Integer uId;
    private Integer sId;

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