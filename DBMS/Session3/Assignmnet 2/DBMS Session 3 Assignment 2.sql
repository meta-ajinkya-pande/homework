USE LIBRARY;

SELECT 
	GROUP_CONCAT( distinct m.category),
	GROUP_CONCAT(m.membercount) 
FROM 
	(SELECT 
		category,
		count(category) as membercount 
	FROM 
		members GROUP BY category
	) as m;


CREATE VIEW view_issue_count 
AS
(SELECT 
	accession_no,
	COUNT(*) AS counter 
FROM 
	book_issue 
GROUP BY 
	accession_no 
HAVING counter > 2); 

CREATE VIEW book_title_view 
AS 
(SELECT 
	books.accession_no, 
	titles.title_nm 
FROM 
	books 
LEFT JOIN titles ON books.title_id = titles.title_id);

SELECT 
	book_title_view.title_nm 
FROM book_title_view 
INNER JOIN view_issue_count ON book_title_view.accession_no = view_issue_count.accession_no;


CREATE VIEW members_book_view AS
(SELECT book_issue.accession_no, book_issue.issue_dt,book_issue.due_dt, members.category FROM book_issue 
LEFT JOIN members
ON book_issue.member_id=members.member_id);

SELECT * FROM members_book_view
WHERE category NOT IN ('Faculty');


CREATE VIEW title_author_view 
AS (SELECT title_author.title_id, authors.author_nm 
FROM title_author
LEFT JOIN authors
ON title_author.author_id=authors.author_id);

SELECT DISTINCT title_author_view.author_nm FROM title_author_view
RIGHT JOIN books ON 
title_author_view.title_id=books.title_id;