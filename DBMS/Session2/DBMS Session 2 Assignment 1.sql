use library;

/* write the display command to diplay all information of members */
SELECT * FROM members;

/*to display the member_name member_id and category */
SELECT 
    member_name, member_id, category
FROM
    members;

/*write the  command to display the member_id, member_name and category where category is F */
SELECT 
    member_name, member_id, category
FROM
    members
WHERE
    category = 'F';

/*write the command to display category from members */

SELECT DISTINCT category
FROM members;


/*write a command to diplay the member_name and category from members in descending order */
SELECT 
    member_name, category
FROM
    members
ORDER BY member_name DESC;

/*write a command to diplay the title_name, subject_name and publisher_name */
SELECT 
    t.title_nm AS TITLE,
    s.subject_nm AS Subject_Name,
    p.publisher_nm AS Publisher
FROM
    title t
INNER JOIN
    publishers p ON t.publisher_id = p.publisher_id
INNER JOIN
    subjects s ON t.subject_id = s.subject_id;

/*write the command to diplay the category and the count of that category*/
SELECT 
    category, COUNT(category)
From
    members
GROUP BY category;

/*Write the command to display the member name where category is same as the keshav verma*/
SELECT 
    s.member_name
FROM
    members s
INNER JOIN
    members s1 ON s.category IN 
    (SELECT s1.category FROM members WHERE member_name = 'keshav verma');
    
/*Write a command to diplay the issue date,accession no, member id and return date */
SELECT 
    bi.issue_dt AS 'ISSUE DATE',bi.accession_no AS 'ACCESSION NO',bi.member_id AS 'MEMBER ID',br.return_dt AS 'RETURN DATE'
FROM 
    book_issue bi
INNER JOIN 
    book_return br ON bi.member_id = br.member_id AND bi.accession_no = bi.accession_no;
    
SELECT * from book_return;
SELECT * FROM book_issue;

/*write the command to display the information of all book issued if book is not return then column book return should be diplayed blank*/
SELECT bi.issue_dt , bi.accession_no , bi.member_id ,
IFNULL(return_dt,'') as Return_Date  
FROM book_issue bi
LEFT JOIN 
    book_return br ON bi.accession_no = br.accession_no;