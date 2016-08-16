USE library;

SELECT 
    m.member_name AS NAME,
    m.member_id AS ID,
    t.title_nm AS TITLE,
    bi.accession_no AS ACCESSION_NO,
    bi.issue_dt AS `ISSUE DATE`,
    TIMESTAMPDIFF(MONTH,br.issue_dt,IFNULL(br.return_dt,CURRENT_TIMESTAMP)) AS MONTH
FROM
    book_issue bi
INNER JOIN 
    members m ON bi.member_id = m.member_id
INNER JOIN 
    book b ON b.accession_no = bi.accession_no
INNER JOIN 
    title t ON t.title_id = b.title_id
LEFT JOIN
    book_return br ON br.accession_no = bi.accession_no AND br.member_id = bi.member_id AND br.issue_dt = bi.issue_dt
WHERE 
    TIMESTAMPDIFF(MONTH,br.issue_dt,IFNULL(br.return_dt,CURRENT_TIMESTAMP))>2;
    
SELECT 
    member_name AS NAME,
    length(member_name) AS LENGTH
FROM
    members
WHERE 
    length(member_name) >= (SELECT max(length(member_name)) from members);
    
SELECT 
    count(*) AS `NO OF BOOK ISSUED`
FROM
    book_issue;