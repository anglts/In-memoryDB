# In-memoryDB
This java application allows to create and handle an In-memory database.

  The application should be able to:
  
    create database and tables.
    Show DB and table structures.
    Add columns/fields to table.
    Add rows to table.
    Update and delete rows.
  

## How to run?
  Run the InMemoryDbApplication.java class and verify the following points.

#1. Print out DB and tables structure.

    Database{
    databaseName='InventoryDB',
    tables=[
    {tableName='Product', fields=[{fieldName='code', type='int'}, {fieldName='Name', type='varchar'}]}, 
    {tableName='Category', fields=[{fieldName='id', type='int'}, {fieldName='Name', type='varchar'}, {fieldName='Group', type='varchar'}]}]
    }

#2. Add data to Product table and print it out.

    ProductData=[
    {1, Shoes},
    {2, T-shirt},
    {3, Pants}
    ]

#3. Update product row and print out it again.

    ProductData=[
    {1, Shoes},
    {2, Jacket},
    {3, Pants}
    ]

#4. Delete product row and print it out again.

    ProductData=[
    {1, Shoes},
    {3, Pants}
    ]

#5. Add data to Product table and print it out again.

    ProductData=[
    {1, Shoes},
    {3, Pants},
    {2, T-shirt}
    ]
