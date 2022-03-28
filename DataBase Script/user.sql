Begin
   execute immediate 'Drop table "user"';
EXCEPTION
   WHEN OTHERS THEN NULL;
END;

create table "user"(
    userid varchar2(50) not null,
    address varchar2(100),
    email varchar2(50),
    first varchar2(25),
    last varchar2(25),
    password varchar2(100),
    phone number(15),
    primary key (userid)
);



INSERT INTO "user"(userid,first,last,email,phone,password,address)
VALUES('Admin','Bittu','Indian','bittu@gmail.com',08789560932,'U2FsdGVkX19YMY/oV/oGutuTdURsyqIC7eCZyw6buUQ=','abc');

INSERT INTO "user"(userid,first,last,email,phone,password,address)
VALUES('ib123','bittu','kumar','jackbabu661@gmail.com',08789560932,'U2FsdGVkX1+bwU2hP2fUVdJ2B1rr+hBYkfxfBkQTqxE=','abc');

COMMIT;

