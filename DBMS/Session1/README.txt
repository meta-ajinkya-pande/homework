Assignment 1:
Install and connect to MYSQL
Analysis of Normalization techniques (along with an example) as discussed during Session.
Draw ER Diagram for Library Information System discussed during Session.

Assignment 2:
Write SQL scripts for the following:
Create all tables of Library as described and mentioned in Slides. (Write all CREATE commands in a SQL file and run that SQL File).
Write a command to display all the table names present in LIS.
Alter definitions of following LIS tables to provide the default constraints:

Table		Column		Default value
Book_Issue	Issue_dt	Current date
Book_Issue	Due_dt		Current date + 15 days

Write a command to remove Members table of the LIS database.
Create the members table again.


Assignment 3:
Write scripts for the following:
Insert sample data in LIS tables by using SQL files.
Change value of addressLine2 column of Members table with “Jaipur”.
Change value of addressLine1 column of Members table with value “EPIP, Sitapura” for the members belonging to category “F”.
Delete all the rows from Publishers table.
Insert the sample data back in Publishers table using substitution variables.
Delete those rows of Titles table belonging to Publisher with publisher_id = 1