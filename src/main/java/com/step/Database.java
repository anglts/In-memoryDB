package com.step;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Database {
    private String databaseName;
    private List<Table> tables;

    public void addTable(Table table) {
        if (tables == null) {
            tables = new ArrayList<>();
        }
        this.tables.add(table);
    }

    @Override
    public String toString() {
        return "Database{" +
                "\ndatabaseName='" + databaseName + '\'' +
                ", \ntables=" + tables + "\n" +
                '}';
    }
}
