desc emaillist;

select * from guestbook;
select no, name, password, message, reg_date from guestbook;
Insert into guestbook values(null,'둘','리', '둘', STR_TO_DATE('110412','%d/%m/%Y %H:%i:%s'));
desc guestbook;
select no, name, message, date_format(reg_date, '%Y-%m-%d %h:%i:%s') from guestbook order by reg_date desc;
desc user;
insert into user values(null,'하성호','skyg547',password(1234),'male',now());
select no,name from user where email='skyg547' and password = password('1234');
drop table user;