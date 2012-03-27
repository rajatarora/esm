# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table attendance (
  id                        bigint auto_increment not null,
  date                      datetime not null,
  student_id                varchar(255),
  time_slot_id              bigint,
  present                   tinyint(1) default 0 not null,
  constraint pk_attendance primary key (id))
;

create table course (
  id                        varchar(255) not null,
  name                      varchar(255) not null,
  type                      varchar(255) not null,
  duration                  integer not null,
  institute_id              varchar(255),
  constraint pk_course primary key (id))
;

create table eclass (
  id                        varchar(255) not null,
  course_id                 varchar(255),
  semester                  integer not null,
  year                      integer not null,
  constraint pk_eclass primary key (id))
;

create table exam (
  id                        varchar(255) not null,
  paper_id                  varchar(255),
  e_type                    integer not null,
  c                         varchar(255) not null,
  constraint ck_exam_e_type check (e_type in (0,1,2,3)),
  constraint pk_exam primary key (id))
;

create table institute (
  id                        varchar(255) not null,
  name                      varchar(255) not null,
  constraint pk_institute primary key (id))
;

create table marks (
  id                        bigint auto_increment not null,
  exam_id                   varchar(255),
  student_id                varchar(255),
  marks                     integer not null,
  constraint pk_marks primary key (id))
;

create table paper (
  id                        varchar(255) not null,
  subject_id                varchar(255),
  c                         varchar(255) not null,
  constraint pk_paper primary key (id))
;

create table room (
  id                        bigint auto_increment not null,
  name                      varchar(255) not null,
  constraint pk_room primary key (id))
;

create table student (
  id                        varchar(255) not null,
  name                      varchar(255) not null,
  date_of_birth             datetime not null,
  course_id                 varchar(255) not null,
  phone_no                  varchar(255),
  address                   varchar(255) not null,
  email                     varchar(255),
  library_no                varchar(255) not null,
  institute_id              varchar(255),
  year                      integer not null,
  user_id                   varchar(255),
  constraint pk_student primary key (id))
;

create table subject (
  id                        varchar(255) not null,
  name                      varchar(255) not null,
  constraint pk_subject primary key (id))
;

create table teacher (
  id                        varchar(255) not null,
  name                      varchar(255) not null,
  date_of_birth             datetime not null,
  year_of_joining           integer not null,
  t_grade                   integer not null,
  room_no                   varchar(255),
  phone_no                  varchar(255) not null,
  email                     varchar(255) not null,
  institute_id              varchar(255),
  user_id                   varchar(255),
  constraint ck_teacher_t_grade check (t_grade in (0,1,2)),
  constraint pk_teacher primary key (id))
;

create table teacher_assignment (
  id                        varchar(255) not null,
  ec_id                     varchar(255),
  paper_id                  varchar(255),
  teacher_id                varchar(255),
  constraint pk_teacher_assignment primary key (id))
;

create table time_slot (
  id                        bigint auto_increment not null,
  c_id                      varchar(255),
  day                       integer not null,
  paper_id                  varchar(255),
  start                     integer not null,
  end                       integer not null,
  room_id                   bigint,
  constraint pk_time_slot primary key (id))
;

create table user (
  id                        varchar(255) not null,
  password                  varchar(255) not null,
  role                      integer not null,
  constraint ck_user_role check (role in (0,1,2)),
  constraint pk_user primary key (id))
;


create table student_eclass (
  student_id                     varchar(255) not null,
  eclass_id                      varchar(255) not null,
  constraint pk_student_eclass primary key (student_id, eclass_id))
;

create table teacher_subject (
  teacher_id                     varchar(255) not null,
  subject_id                     varchar(255) not null,
  constraint pk_teacher_subject primary key (teacher_id, subject_id))
;
alter table attendance add constraint fk_attendance_student_1 foreign key (student_id) references student (id) on delete restrict on update restrict;
create index ix_attendance_student_1 on attendance (student_id);
alter table attendance add constraint fk_attendance_timeSlot_2 foreign key (time_slot_id) references time_slot (id) on delete restrict on update restrict;
create index ix_attendance_timeSlot_2 on attendance (time_slot_id);
alter table course add constraint fk_course_institute_3 foreign key (institute_id) references institute (id) on delete restrict on update restrict;
create index ix_course_institute_3 on course (institute_id);
alter table eclass add constraint fk_eclass_course_4 foreign key (course_id) references course (id) on delete restrict on update restrict;
create index ix_eclass_course_4 on eclass (course_id);
alter table exam add constraint fk_exam_paper_5 foreign key (paper_id) references paper (id) on delete restrict on update restrict;
create index ix_exam_paper_5 on exam (paper_id);
alter table marks add constraint fk_marks_exam_6 foreign key (exam_id) references exam (id) on delete restrict on update restrict;
create index ix_marks_exam_6 on marks (exam_id);
alter table marks add constraint fk_marks_student_7 foreign key (student_id) references student (id) on delete restrict on update restrict;
create index ix_marks_student_7 on marks (student_id);
alter table paper add constraint fk_paper_subject_8 foreign key (subject_id) references subject (id) on delete restrict on update restrict;
create index ix_paper_subject_8 on paper (subject_id);
alter table student add constraint fk_student_institute_9 foreign key (institute_id) references institute (id) on delete restrict on update restrict;
create index ix_student_institute_9 on student (institute_id);
alter table student add constraint fk_student_user_10 foreign key (user_id) references user (id) on delete restrict on update restrict;
create index ix_student_user_10 on student (user_id);
alter table teacher add constraint fk_teacher_institute_11 foreign key (institute_id) references institute (id) on delete restrict on update restrict;
create index ix_teacher_institute_11 on teacher (institute_id);
alter table teacher add constraint fk_teacher_user_12 foreign key (user_id) references user (id) on delete restrict on update restrict;
create index ix_teacher_user_12 on teacher (user_id);
alter table teacher_assignment add constraint fk_teacher_assignment_ec_13 foreign key (ec_id) references eclass (id) on delete restrict on update restrict;
create index ix_teacher_assignment_ec_13 on teacher_assignment (ec_id);
alter table teacher_assignment add constraint fk_teacher_assignment_paper_14 foreign key (paper_id) references paper (id) on delete restrict on update restrict;
create index ix_teacher_assignment_paper_14 on teacher_assignment (paper_id);
alter table teacher_assignment add constraint fk_teacher_assignment_teacher_15 foreign key (teacher_id) references teacher (id) on delete restrict on update restrict;
create index ix_teacher_assignment_teacher_15 on teacher_assignment (teacher_id);
alter table time_slot add constraint fk_time_slot_c_16 foreign key (c_id) references eclass (id) on delete restrict on update restrict;
create index ix_time_slot_c_16 on time_slot (c_id);
alter table time_slot add constraint fk_time_slot_paper_17 foreign key (paper_id) references paper (id) on delete restrict on update restrict;
create index ix_time_slot_paper_17 on time_slot (paper_id);
alter table time_slot add constraint fk_time_slot_room_18 foreign key (room_id) references room (id) on delete restrict on update restrict;
create index ix_time_slot_room_18 on time_slot (room_id);



alter table student_eclass add constraint fk_student_eclass_student_01 foreign key (student_id) references student (id) on delete restrict on update restrict;

alter table student_eclass add constraint fk_student_eclass_eclass_02 foreign key (eclass_id) references eclass (id) on delete restrict on update restrict;

alter table teacher_subject add constraint fk_teacher_subject_teacher_01 foreign key (teacher_id) references teacher (id) on delete restrict on update restrict;

alter table teacher_subject add constraint fk_teacher_subject_subject_02 foreign key (subject_id) references subject (id) on delete restrict on update restrict;

# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table attendance;

drop table course;

drop table eclass;

drop table exam;

drop table institute;

drop table marks;

drop table paper;

drop table room;

drop table student;

drop table student_eclass;

drop table subject;

drop table teacher;

drop table teacher_subject;

drop table teacher_assignment;

drop table time_slot;

drop table user;

SET FOREIGN_KEY_CHECKS=1;

