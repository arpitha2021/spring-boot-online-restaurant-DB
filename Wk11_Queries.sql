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

insert into Orders values (100,'Bangalore','1,2|2,3');
insert into Orders values (101,'Bangalore','2,2|3,3');
insert into Orders values (102,'Tumkur','1,2|2,2');
insert into Orders values (103,'Hoskote','3,1|2,3');
insert into Orders values (104,'Ballary','1,2|4,3');
insert into Orders values (208,'Bangalore','1,2|4,3');
insert into Orders values (108,'Bangalore','1,2|4,3');

insert into ORDER_DETAILS values('IDLI',108,30,2,30*2);
insert into ORDER_DETAILS values('Poori',108,30,3,30*3);

insert into ORDER_DETAILS values('IDLI',208,30,2,30*2);
insert into ORDER_DETAILS values('Poori',208,30,3,30*3);

insert into ORDER_DETAILS values('IDLI',100,30,2,30*2);
insert into ORDER_DETAILS values('Poori',100,30,3,30*3);

insert into ORDER_DETAILS values('IDLI',102,30,2,30*2);
insert into ORDER_DETAILS values('Poori',102,30,2,30*2);

insert into ORDER_DETAILS values('IDLI',104,30,1,30*1);
insert into ORDER_DETAILS values('MASALADOSA',104,90,3,90*3);

insert into Bills values (12,sysdate(),100,(select place from ORDERS where ORDER_ID=100),(select sum(TOTAL_price_oN_qTY) from Order_details where ORDER_ID=100));
insert into Bills values (24,sysdate()+2,102,(select place from ORDERS where ORDER_ID=102),(select sum(TOTAL_price_oN_qTY) from Order_details where ORDER_ID=102));
insert into Bills values (34,sysdate(),104,(select place from ORDERS where ORDER_ID=104),(select sum(TOTAL_price_oN_qTY) from Order_details where ORDER_ID=104));
insert into Bills values (28,sysdate(),108,(select place from ORDERS where ORDER_ID=108),(select sum(TOTAL_price_oN_qTY) from Order_details where ORDER_ID=108));
insert into Bills values (38,sysdate()+1,208,(select place from ORDERS where ORDER_ID=208),(select sum(TOTAL_price_oN_qTY) from Order_details where ORDER_ID=208));

Create view VIEW_ALL_ORDERS as (
select ord.ORDER_ID as orderId, ord.SELECTED_ITEMS_WITH_QTY as List_Of_Items,bill.BILL_SEQ as billId,bill.DATE as date ,bill.TOTAL_BILL as Total from 
ORDERS ord, Bills bill
where ord.order_id=bill.order_id
order by ord.order_id desc);

Create view VIEW_ORDER_BY_DATE as (
select bill.DATE as date,ord.ORDER_ID asorderId , ord.SELECTED_ITEMS_WITH_QTY as List_Of_Items, bill.BILL_SEQ as billId,bill.TOTAL_BILL as Total  from 
ORDERS ord, Bills bill
where ord.order_id=bill.order_id and bill.date in (select date from bills group by date )
order by ord.order_id desc);

Create view VIEW_ORDERS_BY_PRICE as (
select bill.DATE as date ,bill.TOTAL_BILL as bill_amount ,ord.ORDER_ID as orderId, ord.SELECTED_ITEMS_WITH_QTY as List_Of_Items, bill.BILL_SEQ as bill_id
from ORDERS ord, Bills bill
where ord.order_id=bill.order_id and bill.total_bill = (select max(total_bill) from bills)
order by bill.total_bill desc);

Create view VIEW_ORDERS_BY_PLACE as (
select bill.place as place ,Sum(bill.TOTAL_BILL) as total ,count(*) as NO_OF_ORDERS
from  Bills bill
where bill.place in (select distinct place from ORDERS)
group by bill.place
order by bill.total_bill desc);

Create view VIEW_MAX_ORDERS_IN_A_MONTH as (
select Sum(bill.TOTAL_BILL)as total,extract(month from date)  as MONTH ,count(*) as NO_OF_ORDERS
from  Bills bill
where extract(month from date) 
group by extract(month from date) );

Create view VIEW_MAX_SALE_IN_A_YEAR as (
select MAX(TOTAL_BILL) as maximum_bill,extract(year from date) as YEAR
from  Bills 
group by extract(year from date)
);
