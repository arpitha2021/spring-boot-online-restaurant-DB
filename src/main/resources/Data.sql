insert into ITEMS values(1,'IDLI',30);
insert into ITEMS values(2,'Poori',30);
insert into ITEMS values(3,'Dosa',60);
insert into ITEMS values(4,'MasalaDosa',90);
insert into ITEMS values(5,'Noodles',110);

Insert into  Online_User values ('abhi','abhi');
Insert into  Online_User values ('anu','anu');
Insert into  Online_User values ('appu','appu');
Insert into Online_User values ('ammu','ammu');
Insert into Online_User values ('arpitha1','arpitha1');

insert into Orders values (100,'1,2|2,3');
insert into Orders values (101,'2,2|3,3');
insert into Orders values (102,'1,2|2,2');
insert into Orders values (103,'3,1|2,3');
insert into Orders values (104,'1,2|4,3');

insert into ORDER_DETAILS values('IDLI',100,30,2,30*2);
insert into ORDER_DETAILS values('Poori',100,30,3,30*3);

insert into ORDER_DETAILS values('IDLI',102,30,2,30*2);
insert into ORDER_DETAILS values('Poori',102,30,2,30*2);

insert into ORDER_DETAILS values('IDLI',104,30,1,30*1);
insert into ORDER_DETAILS values('MASALADOSA',104,90,3,90*3);

insert into Bills values (12,sysdate(),100,(select sum(TOTAL_price_oN_qTY) from Order_details where ORDER_ID=100));
insert into Bills values (24,sysdate(),102,(select sum(TOTAL_price_oN_qTY) from Order_details where ORDER_ID=102));
insert into Bills values (34,sysdate(),104,(select sum(TOTAL_price_oN_qTY) from Order_details where ORDER_ID=104));
