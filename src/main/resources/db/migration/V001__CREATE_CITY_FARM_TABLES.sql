create table city (
	id bigint not null auto_increment,
	name varchar(80) not null,
	state varchar(80) not null,
	primary key (id)
) engine=InnoDB default charset=utf8;

create table farm (
	id bigint not null auto_increment,
	name varchar(80) not null,
	type varchar(60) not null,
	animal_capacity bigint not null,
	animal_amount bigint not null,
	update_date datetime not null,
	insert_date datetime not null,

    address_city_id bigint not null,
    address_road varchar(100),
	address_zip_code varchar(20) not null,
	address_number varchar(20) not null,
	address_complement varchar(40),
	primary key (id)
) engine=InnoDB default charset=utf8;


alter table farm add constraint fk_farm_city
foreign key (address_city_id) references city (id);