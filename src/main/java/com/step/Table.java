package com.step;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Table {

    private String tableName;
    private List<TableField> fields;
    private TableData tableData;

    //Determine field position in the table
    private int fieldPosition = 1;

    public Table() {
        tableData = new TableData(DatabaseParams.MAX_TABLE_SIZE);
    }

    public void addField(TableField field) {
        if (fields == null) {
            fields = new ArrayList<>();
        }
        switch (field.getType()) {
            case "int":
            case "varchar":
                break;
            default:
                System.out.println("Invalid type ${field.getType()}");
                return;
        }
        field.setPosition(fieldPosition++);
        this.fields.add(field);
    }

    public void addRow(Object[] row) {
        if (row == null) {
            System.out.println("Empty row was provided.");
        }
        if (row.length != fields.size()) {
            System.out.println("Number of provided values do not match with number of fields.");
        }
        this.tableData.addData(row);
    }

    public void updateRow(Object[] row) {
        var numberOfRegisteredRows = this.getTableData().getCurrentIndex();
        if (numberOfRegisteredRows == 0) {
            System.out.println("There is no data to update.");
        }
        //Let's assume first field is the ID.
        var id = row[0];
        for (int i = 0; i < numberOfRegisteredRows; i++) {
            if (id == this.getTableData().getData()[i][0]) {
                for (int j = 1; j < row.length; j++) {
                    this.getTableData().getData()[i][j] = row[j];
                }
            }
        }
    }

    public void deleteRow(int id) {
        var numberOfRegisteredRows = this.getTableData().getCurrentIndex();
        var deleteFlag = false;
        for (int i = 0; i < numberOfRegisteredRows; i++) {
            if (id == (int) this.getTableData().getData()[i][0]) {
                for (int j = i; j < numberOfRegisteredRows; j++) {
                    this.getTableData().getData()[j] = this.getTableData().getData()[j + 1];
                }
                deleteFlag = true;
                break;
            }
        }
        if (deleteFlag) {
            this.getTableData().setCurrentIndex(numberOfRegisteredRows - 1);
        }
    }

    public void printRows() {
        var data = this.getTableData().getData();
        var numberOfRegisteredRows = this.getTableData().getCurrentIndex();

        System.out.println(this.tableName + "Data=[");
        for (int i = 0; i < numberOfRegisteredRows; i++) {
            var rowData = "{";
            for (int j = 0; j < fields.size(); j++) {
                if (j < fields.size() - 1) {
                    rowData += data[i][j] + ", ";
                } else {
                    rowData += data[i][j];
                }
            }
            if (i < numberOfRegisteredRows - 1) {
                rowData += "},";
            } else {
                rowData += "}";
            }
            System.out.println(rowData);
        }
        System.out.println("]");
    }

    @Override
    public String toString() {
        return "\n{" +
                "tableName='" + tableName + '\'' +
                ", fields=" + fields +
                '}';
    }
}
