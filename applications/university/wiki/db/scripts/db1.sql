create database mjmayor;
use mjmayor;

create table alumno(
	id int primary key,
	dni varchar(9) unique not null,
	nombre varchar(20) not null,
	apellidos varchar(30) not null,
	fechaNacimiento date not null,
	email varchar(30)
);

create table profesor(
	id int primary key,
	dni varchar(9) unique not null,
	nombre varchar(20) not null,
	apellidos varchar(30) not null
);


create table asignatura(
	id int primary key,
	codigo varchar(10) unique not null,
	nombre varchar(30) not null,
	curso int not null,
	creditos double(2,1) not null
);



insert into alumno values (1, "11111111H", "pepe", "perez", "1980-01-01", "a@a.com");
insert into alumno values (2, "22222222J", "manuel", "rodriguez", "1980-01-02", "b@b.com");
insert into alumno values (3, "33333333P", "pedro", "garcia", "1980-01-03", "c@c.com");

insert into profesor values (1, "44444444A", "juan", "lopez");
insert into profesor values (2, "55555555K", "antonio", "sanchez");
insert into profesor values (3, "66666666Q", "luis", "vazquez");

insert into asignatura values (1, "cod1", "asignatura 1", 1, 9);
insert into asignatura values (2, "cod2", "asignatura 2", 3, 7.5);
insert into asignatura values (3, "cod3", "asignatura 3", 5, 6);
