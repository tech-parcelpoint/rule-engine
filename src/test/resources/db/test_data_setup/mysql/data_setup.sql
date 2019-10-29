drop table if exists system_order;

drop table if exists customer;

create table customer(
	id bigint(20) primary key not null,
	first_name varchar(30) not null,
	last_name varchar(30) not null,
	age integer not null
);

create table system_order(
	id bigint(20) primary key not null auto_increment,
	order_type varchar(20) not null,
	order_status varchar(20) not null,
	customer_id bigint(20) not null
);

ALTER TABLE system_order ADD CONSTRAINT fk_sys_ord_01 FOREIGN KEY(customer_id)REFERENCES customer(id);

insert into customer(id, first_name, last_name, age)
values
(1, "John", "Doe", "51"),
 (2, "Jane", "Doe", "33"),
 (3, "Robert", "Patrick", "21");

insert into system_order(order_type, order_status, customer_id)
 values
 ("PREMIUM", "BOOKED", 1),
 ("PREMIUM", "COMPLETE", 2),
 ("STANDARD", "CANCELLED", 3),
 ("STANDARD", "COMPLETE", 1),
 ("PREMIUM", "COMPLETE", 3);
