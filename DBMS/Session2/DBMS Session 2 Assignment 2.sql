USE LIS;

/* Modify the SELECT command written for Question 9 to display 
results in ascending order of issue date and within issue date in ascending order of member's name */
SELECT 
	book_issue.issue_dt AS ISSUE_DATE, 
	book_issue.accession_no AS ACCESSION_NUMBER, 
	members.member_nm AS MEMBER_NAME,
	IFNULL(book_return.return_dt,"") AS RETURN_DATE 
FROM 
	book_issue 
LEFT JOIN 
	book_return ON book_issue.accession_no = book_return.accession_no 
				AND book_issue.member_id = book_return.member_id
				AND book_issue.issue_dt = book_return.issue_dt 
LEFT JOIN 
	members ON book_issue.member_id = members.member_id
ORDER BY 
	ISSUE_DATE, MEMBER_NAME;