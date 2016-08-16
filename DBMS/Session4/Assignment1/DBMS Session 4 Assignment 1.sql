USE LIS;

/*
1. Write a SELECT command to display name of those members
who belong to the category as to which member
“Jon Snow” belongs.
Note: Solve the problem using subquery.
*/

SELECT member_nm FROM members WHERE category IN ( SELECT DISTINCT category FROM members WHERE member_nm="Jon Snow");

/*
Write a SELECT command to display information on the books
that have not been returned till date. The information should
include book issue date, title, member name and due date.
Note: Use Correlated Subquery.
*/

SELECT t.title_nm AS Title, m.member_nm AS Member,bi.issue_dt AS Issue_Date,bi.due_dt AS Due_Date FROM book_issue bi
INNER JOIN members m ON bi.member_id = m.member_id
INNER JOIN books b ON bi.accession_no = b.accession_no
INNER JOIN titles t ON b.title_id = t.title_id
WHERE (
bi.issue_dt, bi.accession_no, bi.member_id) NOT IN
(
SELECT br.issue_dt, br.accession_no, br.member_id FROM book_return br
);


/*
Write a SELECT command to display information on the books
that have been returned after their due dates. The information
should include book issue date, title, member name and due
date.
Note: Use Correlated Subquery.
*/

SELECT bi.issue_dt AS Issue_Date, t.title_nm AS Title,
m.member_nm AS Member, bi.due_dt AS Due_Date FROM book_issue bi
INNER JOIN members m ON bi.member_id = m.member_id
INNER JOIN books b ON bi.accession_no = b.accession_no
INNER JOIN titles t ON b.title_id = t.title_id
WHERE (bi.issue_dt, bi.accession_no, bi.member_id) IN
(SELECT br.issue_dt, br.accession_no, br.member_id FROM book_return br
WHERE TIMESTAMPDIFF(DAY, bi.due_dt, br.return_dt) > 0);


/*
Write a SELECT command to display information of those books
whose price is equal to the most expensive book purchase so far.
*/
SELECT title_nm FROM titles WHERE title_id
IN (SELECT title_id FROM books WHERE price=
(SELECT max(price) FROM books)
);

/*
Write a SELECT command to display the second maximum price
of a book.
*/

SELECT MAX(price) FROM books WHERE price NOT IN (SELECT MAX(price) FROM books);