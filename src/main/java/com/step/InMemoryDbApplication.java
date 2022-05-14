package com.step;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InMemoryDbApplication {

	private Database db;

	public static void main(String[] args) {
		// Create Database.
		var test = new InMemoryDbApplication();
		test.createDatabase("InventoryDB");

		// Create Product table and add its columns.
		var productTable = test.createTable("Product");
		productTable.addField(new TableField("code", "int"));
		productTable.addField(new TableField("Name", "varchar"));

		// Create Category table and add its columns.
		var categoryTable = test.createTable("Category");
		categoryTable.addField(new TableField("id", "int"));
		categoryTable.addField(new TableField("Name", "varchar"));
		categoryTable.addField(new TableField("Group", "varchar"));

		// Print out DB and tables structure.
		System.out.println("1. Print out DB and tables structure.");
		System.out.println("-------------------------------------");
		test.printDBStructure();

		// Add data to Product table.
		productTable.addRow(new Object[]{1, "Shoes"});
		productTable.addRow(new Object[]{2, "T-shirt"});
		productTable.addRow(new Object[]{3, "Pants"});

		// Add data to Product table and print it out.
		System.out.println("2. Add data to Product table and print it out.");
		System.out.println("----------------------------------------------");
		productTable.printRows();

		// Update product row and print out it again.
		System.out.println("3. Update product row and print out it again.");
		System.out.println("---------------------------------------------");
		productTable.updateRow(new Object[]{2, "Jacket"});
		productTable.printRows();

		// Delete product row and print it out again.
		System.out.println("4. Delete product row and print it out again.");
		System.out.println("----------------------------------------------");
		productTable.deleteRow(2);
		productTable.printRows();

		// Add data to Product table and print it out again.
		System.out.println("5. Add data to Product table and print it out again.");
		System.out.println("-----------------------------------------------------");
		productTable.addRow(new Object[]{2, "T-shirt"});
		productTable.printRows();
	}

	private void printDBStructure() {
		System.out.println(db.toString());
	}

	private void createDatabase(String databaseName) {
		if (db == null) {
			db = new Database();
			db.setDatabaseName(databaseName);
		}
	}

	private Table createTable(String name) {
		var table = new Table();
		table.setTableName(name);
		db.addTable(table);
		return table;
	}

}
