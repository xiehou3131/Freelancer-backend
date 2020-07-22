package com.freelancer.freelancer.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

@Data
public class NeedSkillPK implements Serializable {
    private Integer w_id;
    private Integer s_id;

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        NeedSkillPK pk = (NeedSkillPK) o;
        return Objects.equals(w_id, pk.w_id) && Objects.equals(s_id, pk.s_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(w_id, s_id);
    }
}