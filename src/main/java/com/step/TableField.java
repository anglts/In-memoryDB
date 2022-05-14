package com.step;

import lombok.Data;

@Data
public class TableField {

    private String fieldName;
    private String type;
    private int position;

    public TableField(String fieldName, String type) {
        this.fieldName = fieldName;
        this.type = type;
    }

    @Override
    public String toString() {
        return "{" +
                "fieldName='" + fieldName + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
