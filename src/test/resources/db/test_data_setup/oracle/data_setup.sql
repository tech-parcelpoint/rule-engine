
create table customer(
	id NUMBER(5) PRIMARY KEY NOT NULL,
	first_name varchar2(30) NOT NULL,
	last_name varchar2(30) NOT NULL,
	age INTEGER
);

create table system_order(
	id NUMBER(5) PRIMARY KEY NOT NULL,
	order_type varchar2(20) NOT NULL,
	order_status varchar2(20) NOT NULL,
	customer_id NUMBER(5) NOT NULL
);

alter table syste_order add constraint fk_sys_ord_01 customer_id REFERENCES customer(id);


insert into customer(id, first_name, last_name, age)
values
(1, "John", "Doe", "51"),
 (2, "Jane", "Doe", "33"),
 (3, "Robert", "Patrick", "21");

insert into system_order(order_type, order_status, customer_id)
 values
 (1, "PREMIUM", "BOOKED", 1),
 (2, "PREMIUM", "COMPLETE", 2),
 (3, "STANDARD", "CANCELLED", 3),
 (4, "STANDARD", "COMPLETE", 1),
 (5, "PREMIUM", "COMPLETE", 3);