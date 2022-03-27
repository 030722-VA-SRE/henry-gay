create table categories
(
	id serial primary key,
	category_name varchar(20) not null,
	description varchar(255) not null,
	image_url varchar(255) not null
);