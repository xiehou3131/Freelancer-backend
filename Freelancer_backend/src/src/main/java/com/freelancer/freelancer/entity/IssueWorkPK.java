package com.freelancer.freelancer.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

@Data
public class IssueWorkPK implements Serializable {
    private Integer uId;
    private Integer wId;

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        IssueWorkPK pk = (IssueWorkPK) o;
        return Objects.equals(uId, pk.uId) && Objects.equals(wId, pk.wId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uId, wId);
    }
}