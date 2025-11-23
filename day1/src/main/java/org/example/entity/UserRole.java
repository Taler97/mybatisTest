package org.example.entity;

import lombok.Data;
import lombok.Getter;

@Data
public class UserRole {
    private Integer uid;

    private Integer rid;

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }
}