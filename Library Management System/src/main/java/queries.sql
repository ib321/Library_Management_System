drop table if exists Book;
create table Book(id NUMBER(4),name VARCHAR(20),author varchar(20),category varchar(20),returnDate DATE,primary key(id));
insert into Book VALUES(2,'wonder','ib','scifi',"2020-01-01");