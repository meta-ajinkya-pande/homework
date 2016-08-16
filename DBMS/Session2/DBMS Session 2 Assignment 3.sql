/* CREATE DATABASE */
CREATE DATABASE IF NOT EXISTS ECOMMERCE;

/* SELECT DATABSE TO USE */
USE ECOMMERCE;

/* CREATE TABLE categories*/
CREATE TABLE IF NOT EXISTS categories (
category_id int PRIMARY KEY AUTO_INCREMENT,
category_nm VARCHAR(50),
parent_id int
);

/* INSERT VALUES INTO TABLE */

INSERT into categories (category_nm) VALUES ("Mobile And Tablets");
INSERT into categories (category_nm) VALUES ("Home Appliances ");
INSERT into categories (category_nm) VALUES ("Computers");

INSERT into categories (category_nm,parent_id) VALUES ("Mobile",1);
INSERT into categories (category_nm,parent_id) VALUES ("Tablets",1);
INSERT into categories (category_nm,parent_id) VALUES ("Accessories",1);
INSERT into categories (category_nm,parent_id) VALUES ("Cases And Covers",1);

INSERT into categories (category_nm,parent_id) VALUES ("Smart Phones",4);
INSERT into categories (category_nm,parent_id) VALUES ("Featured Phones",4);

INSERT into categories (category_nm,parent_id) VALUES ("2G",5);
INSERT into categories (category_nm,parent_id) VALUES ("3G",5);

INSERT into categories (category_nm,parent_id) VALUES ("TV",2);
INSERT into categories (category_nm,parent_id) VALUES ("Air Conditioner",2);
INSERT into categories (category_nm,parent_id) VALUES ("Washing Machine",2);

INSERT into categories (category_nm,parent_id) VALUES ("Full Automatic",14);
INSERT into categories (category_nm,parent_id) VALUES ("Semi Automatic",14);

INSERT into categories (category_nm,parent_id) VALUES ("Top Load",15);
INSERT into categories (category_nm,parent_id) VALUES ("Front Load",15);

INSERT into categories (category_nm,parent_id) VALUES ("LED",12);
INSERT into categories (category_nm,parent_id) VALUES ("LCD",12);
INSERT into categories (category_nm,parent_id) VALUES ("Plasma",12);

INSERT into categories (category_nm,parent_id) VALUES ("Desktop",3);
INSERT into categories (category_nm,parent_id) VALUES ("Laptop",3);
INSERT into categories (category_nm,parent_id) VALUES ("Laptop Accesories",3);
INSERT into categories (category_nm,parent_id) VALUES ("Printer",3);

INSERT into categories (category_nm,parent_id) VALUES ("Keyboard",24);
INSERT into categories (category_nm,parent_id) VALUES ("Mouse",24);
INSERT into categories (category_nm,parent_id) VALUES ("HeadPhones",24);

INSERT into categories (category_nm,parent_id) VALUES ("InkJet",25);
INSERT into categories (category_nm,parent_id) VALUES ("Laser",25);

/*SQL query to display all the categories along with its Parent category */
SELECT 
	c1.category_id,
	c1.category_nm,
	IFNULL(c2.category_nm,'Top Category') AS Parent_Category 
FROM 
	categories c1 
LEFT JOIN categories c2 ON c1.parent_id=c2.category_id;

/*SQL query to display all the categories along with its Parent category in which Result should be sorted on Parent Category */
SELECT 
	c1.category_id,
	c1.category_nm,
	IFNULL(c2.category_nm,'Top Category') AS Parent_Category 
FROM 
	categories c1 
LEFT JOIN 
	categories c2 ON c1.parent_id=c2.category_id 
	ORDER BY c1.category_nm;

/* display only Top Categories */
CREATE VIEW 
	myVIEW AS 
		(SELECT 
			c1.category_id,
			c1.category_nm,
			IFNULL(c2.category_nm,'Top Category') AS Parent_Category 
			FROM categories c1 
			LEFT JOIN 
			categories c2 ON c1.parent_id=c2.category_id
		);

SELECT 
	v.category_id,
	v.category_nm,
	v.Parent_Category 
FROM 
	myView v 
WHERE 
	v.Parent_Category="Top Category";