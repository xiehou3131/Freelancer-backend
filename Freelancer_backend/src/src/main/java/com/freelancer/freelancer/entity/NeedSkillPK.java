package com.freelancer.freelancer.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

@Data
public class NeedSkillPK implements Serializable {
    private Integer wId;
    private Integer sId;

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        NeedSkillPK pk = (NeedSkillPK) o;
        return Objects.equals(wId, pk.wId) && Objects.equals(sId, pk.sId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(wId, sId);
    }
}