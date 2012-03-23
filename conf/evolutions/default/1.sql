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

create table class (
  id                        varchar(255) not null,
  course_id                 varchar(255),
  semester                  integer not null,
  constraint pk_class primary key (id))
;

create table course (
  id                        varchar(255) not null,
  name                      varchar(255) not null,
  type                      varchar(255) not null,
  duration                  integer not null,
  institute_id              varchar(255),
  constraint pk_course primary key (id))
;

create table exam (
  id                        varchar(255) not null,
  paper_id                  varchar(255),
  e_type                    integer not null,
  c_id                      varchar(255),
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
  c_id                      varchar(255),
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
  in_class_id               varchar(255),
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

create table time_slot (
  id                        bigint auto_increment not null,
  c_id                      varchar(255),
  day                       integer not null,
  paper_id                  varchar(255),
  start                     integer not null,
  end                       integer not null,
  room_id                   bigint,
  constraint ck_time_slot_day check (day in (0,1,2,3,4,5,6)),
  constraint ck_time_slot_start check (start in (0,1,2,3,4,5,6,7,8)),
  constraint ck_time_slot_end check (end in (0,1,2,3,4,5,6,7,8)),
  constraint pk_time_slot primary key (id))
;

create table user (
  id                        varchar(255) not null,
  password                  varchar(255) not null,
  role                      integer not null,
  constraint ck_user_role check (role in (0,1,2)),
  constraint pk_user primary key (id))
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
alter table class add constraint fk_class_course_3 foreign key (course_id) references course (id) on delete restrict on update restrict;
create index ix_class_course_3 on class (course_id);
alter table course add constraint fk_course_institute_4 foreign key (institute_id) references institute (id) on delete restrict on update restrict;
create index ix_course_institute_4 on course (institute_id);
alter table exam add constraint fk_exam_paper_5 foreign key (paper_id) references paper (id) on delete restrict on update restrict;
create index ix_exam_paper_5 on exam (paper_id);
alter table exam add constraint fk_exam_c_6 foreign key (c_id) references class (id) on delete restrict on update restrict;
create index ix_exam_c_6 on exam (c_id);
alter table marks add constraint fk_marks_exam_7 foreign key (exam_id) references exam (id) on delete restrict on update restrict;
create index ix_marks_exam_7 on marks (exam_id);
alter table marks add constraint fk_marks_student_8 foreign key (student_id) references student (id) on delete restrict on update restrict;
create index ix_marks_student_8 on marks (student_id);
alter table paper add constraint fk_paper_subject_9 foreign key (subject_id) references subject (id) on delete restrict on update restrict;
create index ix_paper_subject_9 on paper (subject_id);
alter table paper add constraint fk_paper_c_10 foreign key (c_id) references class (id) on delete restrict on update restrict;
create index ix_paper_c_10 on paper (c_id);
alter table student add constraint fk_student_institute_11 foreign key (institute_id) references institute (id) on delete restrict on update restrict;
create index ix_student_institute_11 on student (institute_id);
alter table student add constraint fk_student_inClass_12 foreign key (in_class_id) references class (id) on delete restrict on update restrict;
create index ix_student_inClass_12 on student (in_class_id);
alter table student add constraint fk_student_user_13 foreign key (user_id) references user (id) on delete restrict on update restrict;
create index ix_student_user_13 on student (user_id);
alter table teacher add constraint fk_teacher_institute_14 foreign key (institute_id) references institute (id) on delete restrict on update restrict;
create index ix_teacher_institute_14 on teacher (institute_id);
alter table teacher add constraint fk_teacher_user_15 foreign key (user_id) references user (id) on delete restrict on update restrict;
create index ix_teacher_user_15 on teacher (user_id);
alter table time_slot add constraint fk_time_slot_c_16 foreign key (c_id) references class (id) on delete restrict on update restrict;
create index ix_time_slot_c_16 on time_slot (c_id);
alter table time_slot add constraint fk_time_slot_paper_17 foreign key (paper_id) references paper (id) on delete restrict on update restrict;
create index ix_time_slot_paper_17 on time_slot (paper_id);
alter table time_slot add constraint fk_time_slot_room_18 foreign key (room_id) references room (id) on delete restrict on update restrict;
create index ix_time_slot_room_18 on time_slot (room_id);



alter table teacher_subject add constraint fk_teacher_subject_teacher_01 foreign key (teacher_id) references teacher (id) on delete restrict on update restrict;

alter table teacher_subject add constraint fk_teacher_subject_subject_02 foreign key (subject_id) references subject (id) on delete restrict on update restrict;

# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table attendance;

drop table class;

drop table course;

drop table exam;

drop table institute;

drop table marks;

drop table paper;

drop table room;

drop table student;

drop table subject;

drop table teacher;

drop table teacher_subject;

drop table time_slot;

drop table user;

SET FOREIGN_KEY_CHECKS=1;

