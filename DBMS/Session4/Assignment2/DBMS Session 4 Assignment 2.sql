USE LIS;

/*
 Create a View which can be used to display member name and
all issue details of the member using a simple SELECT command.
*/

CREATE VIEW issuedBookDetails AS
(
SELECT m.member_nm,bi.accession_no,b.title_id,t.title_nm 
FROM members m,book_issue bi,books b,titles t
WHERE m.member_id=bi.member_id && bi.accession_no=b.accession_no && b.title_id=t.title_id
);


/*
Create a View which contains three columns, member name,
member id and full description of category, i.e., Faculty, Students
and Others instead of F,S and O
*/
CREATE VIEW membersView AS
(
SELECT member_id,member_nm,CASE 
WHEN category="F" THEN 'Faculty'
WHEN category="S" THEN 'Student'
ELSE "Others" END AS Full_Description FROM members
);


/*
Create a View which contains the information – subject name,
title, member name, category, issue date, due date and return
date. If the books have not been returned, NULL should be
displayed instead of return date.
*/

CREATE VIEW BooksIssueDetails AS (
SELECT s.subject_nm AS Subject,t.title_nm AS Title,m.member_nm AS Member_name,m.category AS Category,bi.issue_dt AS Issue_Date,bi.due_dt AS Due_Dt 
FROM members m,book_issue bi,books b,titles t,subjects s
WHERE m.member_id=bi.member_id && bi.accession_no=b.accession_no && b.title_id=t.title_id && t.subject_id=s.subject_id
);