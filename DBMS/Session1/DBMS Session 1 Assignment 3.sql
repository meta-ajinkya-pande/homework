USE library;

/* insert data into members */

insert into members values('mem_101','member1','sita','pura','F');
insert into members values('mem_102','member2','sita','pura','M');
insert into members values('mem_103','member3','sita','pura','F');
insert into members values('mem_104','member4','sita','pura','M');
insert into members values('mem_105','member5','sita','pura','M');
insert into members values('mem_106','member6','sita','pura','F');
insert into members values('mem_107','member7','sita','pura','M');
insert into members values('mem_108','member8','sita','pura','F');
insert into members values('mem_109','member9','sita','pura','F');


/* insert data into author */

insert into authors values('auth_101','author1');
insert into authors values('auth_102','author2');
insert into authors values('auth_103','author3');
insert into authors values('auth_104','author4');
insert into authors values('auth_105','author5');
insert into authors values('auth_106','author6');
insert into authors values('auth_107','author7');
insert into authors values('auth_108','author8');

/* insert data into subjects*/

insert into subjects values('sub_1','subject1');
insert into subjects values('sub_2','subject2');
insert into subjects values('sub_3','subject3');
insert into subjects values('sub_4','subject4');
insert into subjects values('sub_5','subject5');
insert into subjects values('sub_6','subject6');
insert into subjects values('sub_7','subject7');
insert into subjects values('sub_8','subject8');
insert into subjects values('sub_9','subject9');

/* insert data into publishers*/

insert into publishers values('pub_1','publish1');
insert into publishers values('pub_2','publish2');
insert into publishers values('pub_3','publish3');
insert into publishers values('pub_4','publish4');
insert into publishers values('pub_5','publish5');
insert into publishers values('pub_6','publish6');
insert into publishers values('pub_7','publish7');
insert into publishers values('pub_8','publish8');
insert into publishers values('pub_9','publish9');

/* insert data into titles*/

insert into title values('tit_101','titlename1','sub_1','pub_1');
insert into title values('tit_102','titlename2','sub_2','pub_2');
insert into title values('tit_103','titlename3','sub_3','pub_3');
insert into title values('tit_104','titlename4','sub_4','pub_4');
insert into title values('tit_105','titlename5','sub_5','pub_5');
insert into title values('tit_106','titlename6','sub_6','pub_6');
insert into title values('tit_107','titlename7','sub_7','pub_7');
insert into title values('tit_108','titlename8','sub_8','pub_8');
insert into title values('tit_109','titlename9','sub_9','pub_9');

/*insert data to title_author*/

insert into title_author values('tit_101','auth_101');
insert into title_author values('tit_102','auth_102');
insert into title_author values('tit_103','auth_103');
insert into title_author values('tit_104','auth_104');
insert into title_author values('tit_105','auth_105');
insert into title_author values('tit_106','auth_106');
insert into title_author values('tit_107','auth_107');
insert into title_author values('tit_108','auth_108');

/* insert into Book*/

insert into Book values('acc_no_101','tit_101','200','1');
insert into Book values('acc_no_102','tit_102','210','1');
insert into Book values('acc_no_103','tit_103','220','0');
insert into Book values('acc_no_104','tit_104','230','1');
insert into Book values('acc_no_105','tit_105','240','1');
insert into Book values('acc_no_106','tit_106','250','0');
insert into Book values('acc_no_107','tit_107','260','1');
insert into Book values('acc_no_108','tit_108','270','0');

/* insert data into book_issue */

insert into book_issue values('1990/11/21','acc_no_101','mem_101','1990/12/1');
insert into book_issue values('1991/01/21','acc_no_102','mem_102','1991/01/1');
insert into book_issue values('1992/11/21','acc_no_103','mem_103','1993/12/1');
insert into book_issue values('1993/02/21','acc_no_104','mem_104','1993/02/21');

/* insert data into book return*/

insert into book_return values('1990/12/1','acc_no_101','mem_101','1990/11/21');
insert into book_return values('1991/01/1','acc_no_103','mem_101','1991/01/21');
insert into book_return values('1993/12/1','acc_no_102','mem_102','1992/11/21');
insert into book_return values('1993/02/21','acc_no_101','mem_103','1993/02/21');

/* Change values of addressline2 in members table to 'Jaipur' */

UPDATE members SET addressline2 = 'Jaipur';

/* Change values of addressline1 in members table to 'EPIP, Sitapura' */

UPDATE members SET addressline1 = 'EPIP, Sitapura' WHERE category = 'F';

/* Deleting all rows from publisher table */

ALTER TABLE title DROP FOREIGN KEY fk_publisher_id;

DELETE FROM publishers;

/* Inserting the data back to the publisher table using substitution variables */

SET @id = 'pub_1';
SET @name = 'publish1';
INSERT INTO publishers VALUES ( @id, @name );

SET @id = 'pub_2';
SET @name = 'publish2';
INSERT INTO publishers VALUES ( @id, @name );

SET @id = 'pub_3';
SET @name = 'publish3';
INSERT INTO publishers VALUES ( @id, @name );

SET @id = 'pub_4';
SET @name = 'publish4';
INSERT INTO publishers VALUES ( @id, @name );

SET @id = 'pub_5';
SET @name = 'publish5';
INSERT INTO publishers VALUES ( @id, @name );

SET @id = 'pub_6';
SET @name = 'publish6';
INSERT INTO publishers VALUES ( @id, @name );

SET @id = 'pub_7';
SET @name = 'publish7';
INSERT INTO publishers VALUES ( @id, @name );

SET @id = 'pub_8';
SET @name = 'publish8';
INSERT INTO publishers VALUES ( @id, @name );

SET @id = 'pub_9';
SET @name = 'publish9';
INSERT INTO publishers VALUES ( @id, @name );

ALTER TABLE title ADD CONSTRAINT fk_publisher_id FOREIGN KEY (publisher_id) REFERENCES publishers(publisher_id);

/* Deleting rows of title table with publisher id = 1 */

DELETE FROM title WHERE publisher_id = 'pub_101';