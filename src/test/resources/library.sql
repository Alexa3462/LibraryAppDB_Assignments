-- US 01
select count(id) from users;
-- 1856

select count(distinct id) from users;

-- 1856


-- Result Manually passed

-- US 02
select * from users;

-- rsmd.getColumnName in a loop
-- Or use DBUtil getColumnName


select * from book_borrow;
 -- select count(*) from book_borrow
--  where is_returned = '0' === > 474

-- Us 3
select name from book_categories;
select b.name as bookName, author, bc.name as bookCategoryName from books b inner join

                                                                    book_categories bc on b.book_category_id = bc.id
where b.name = 'Lord of the Files';

-- remove 'all' from UI with list.remove(0)

-- Us 4
-- clean code your name


-- navigate book module


select * from user_groups;
select * from users;

select * from book_borrow;

select name from books
where isbn = 12112021;

select * from books
where name = 'Clean Code AG';


-- US 5
SELECT bc.name, COUNT(*)
FROM book_borrow bb
         INNER JOIN books b ON bb.book_id = b.id
         INNER JOIN book_categories bc ON b.book_category_id = bc.id
GROUP BY bc.name
ORDER BY count(*) DESC;

select bc.name,count(*) from book_borrow bb
                                 inner join books b on bb.book_id = b.id
                                 inner join book_categories bc on b.book_category_id=bc.id
group by name
order by 2 desc;





