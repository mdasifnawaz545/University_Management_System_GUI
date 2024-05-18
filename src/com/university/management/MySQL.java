package com.university.management;

public class MySQL {
/*

show databases;
use university;
create table student(roll int primary key,assigned_mentor_id int ,name varchar(30),fathers_name varchar(30
),address varchar(255),dob date ,phone int ,email_id varchar(30),class_X int ,class_XII int ,aadhaar_no int ,course varchar(30),branch varchar(30),image longblob,attendance int);

create table faculty(faculty_id int primary key,name varchar(30),fathers_name varchar(30
),address varchar(255),dob date ,phone int ,email_id varchar(30),gradutaion int ,post_graduation int ,
aadhaar_no int ,specialisation varchar(30),department varchar(30),image longblob,attendance int);

desc student;
truncate table faculty;
update faculty set faculty_id=190001 where faculty_id=1914634;
select * from faculty;

update faculty set faculty_id=1 where faculty_id=1903451;

alter table faculty
modify aadhaar_no varchar(30);

delete from faculty where faculty_id=1;


alter table student
add foreign key(assigned_mentor_id)references faculty(faculty_id);

show tables;

desc login_details;

select * from login_details;

alter table login_details
add foreign key(roll) references student(roll);

alter table student add column roll_no

alter table login_details
add column roll int ;

select * from faculty;

desc student;

truncate table login_details;

insert into login_details values("22052736@kiit.ac.in","KIIT@123",22052736,"Md Asif Nawaz");
truncate table login_details;
alter table login_details add name varchar(30);
alter table faculty modify dob varchar(30);

alter table faculty rename column gradutaion to graduation ;
desc login_details;
alter table faculty
modify post_graduation decimal(5,2);

select * from login_details;

truncate table student;
delete from student where roll=22052736;
update student set roll=22052736 where roll=220514;

desc student;

create table fees(transaction_id int primary key,roll int ,total_fees int,paid_fees int,due_fees int);

alter table fees
add foreign key(roll) references student(roll);

insert into fees values(13453,22052736,2100000,0,2100000);

create table student_leave(roll int ,leave_date varchar(30) primary key,leave_type varchar(30));

alter table student_leave add foreign key(roll) references student(roll);

drop table student_leave;

create table grade_report(roll int ,semester varchar(30),sub1 varchar(30),sub2 varchar(30),sub3 varchar(30),sub4 varchar(30),sub5 varchar(30),
mark1 int,mark2 int,mark3 int,mark4 int,mark5 int);

alter table grade_report add foreign key (roll) references student(roll);

select name from fees
left join student
on fees.roll=student.roll
where student.roll=22052736
;

select * from fees;

alter table fees modify column transaction_id int auto_increment;

UPDATE fees SET due_fees=2100000 WHERE roll=22052736;

desc grade_report;

select * from student_leave;

select * from grade_report;

select * from fees;

INSERT INTO fees (roll,total_fees,paid_fees,due_fees) VALUES (22056753,2100000,0,2100000);

select * from student;
desc fees;

insert into fees(roll,total_fees,paid_fees,due_fees) values (22052736,2100000,0,2100000);

delete from fees where transaction_id=13454;

 */
}