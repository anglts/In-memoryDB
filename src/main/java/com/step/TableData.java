package com.step;

import lombok.Data;

@Data
public class TableData {
    private Object[][] data;
    private int maxSize;
    private int currentIndex;

    public TableData(int maxSize) {
        this.maxSize = maxSize;
    }

    public void addData(Object[] row) {
        if (data == null) {
            data = new Object[this.maxSize][row.length];
        }
        if (currentIndex == data.length - 1) {
            System.out.println("Table data has reach out the maximum number of rows.");
        }
        data[currentIndex++] = row;
    }

}
