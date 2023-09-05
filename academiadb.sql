create database dbacademia;
show databases;
use dbacademia;
create table agendamento(
idagendamento int primary key auto_increment,
idmorador int ,
data date not null,
hora time(0) not null
);
show tables;
