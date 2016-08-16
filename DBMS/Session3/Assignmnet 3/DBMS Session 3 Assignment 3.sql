USE LIBRARY;

CREATE VIEW VIEW_book_sub_title AS (
SELECT 
	titles.title_id, 
	subjects.subject_id, 
	subjects.subject_nm 
FROM 
	titles 
LEFT JOIN 
	subjects ON titles.subject_id = subjects.subject_id
);


SELECT 
	VIEW_book_sub_title.subject_id, 
	VIEW_book_sub_title.subject_nm, 
	COUNT(VIEW_book_sub_title.subject_nm) AS noOfbooksPurchasedSoFar
FROM 
	VIEW_book_sub_title 
RIGHT JOIN 
	books ON VIEW_book_sub_title.title_id = books.title_id 
GROUP BY VIEW_book_sub_title.subject_nm
ORDER BY VIEW_book_sub_title.subject_nm;


INSERT INTO book_issue(issue_dt,accession_no,member_id,due_dt) VALUES ('2014/08/21',2,2,'2014/011/29');

SELECT * 
FROM 
	book_issue 
WHERE 
	DATEDIFF(due_dt,issue_dt) > 60;

CREATE VIEW title_view AS (
SELECT 
	titles.title_nm, 
	books.price 
FROM 
	books LEFT JOIN titles ON books.title_id = titles.title_id);

SELECT * 
FROM 
	title_view 
WHERE 
	title_view.price > ( SELECT MIN(price) FROM books);