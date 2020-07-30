package com.freelancer.freelancer.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

@Data
public class ProposeWorkPK implements Serializable {
    private Integer u_id;
    private Integer w_id;

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        ProposeWorkPK pk = (ProposeWorkPK) o;
        return Objects.equals(u_id, pk.u_id) && Objects.equals(w_id, pk.w_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(u_id, w_id);
    }
}