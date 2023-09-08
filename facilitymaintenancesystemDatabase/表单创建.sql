/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2023/7/1 13:33:40                            */
/*==============================================================*/


 /*==============================================================*/
/* Table:用户                                                    */
/*==============================================================*/
create table user
(
   id int(11) NOT NULL AUTO_INCREMENT,		#用户ID
   username varchar(50) not NULL,#用户名
   password varchar(50) not NULL,#用户密码
   nickname varchar(50) NULL DEFAULT NULL,#用户昵称
   email varchar(50)  NULL DEFAULT NULL ,#用户邮箱
   phone varchar(20)  NULL DEFAULT NULL,#用户电话
   address varchar(255) NULL DEFAULT NULL,#用户地址
   createTime timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0),#用户创建时间
	 role  enum('学生','维修员','管理员')not NULL,#用户角色
  PRIMARY KEY (id)
);

drop table user;

/*==============================================================*/
/* Table:楼栋                                                    */
/*==============================================================*/
create table building
(
		name	varchar(50) not null,			#楼栋名称
		address		varchar(100) not null,#楼栋地址
		createTime 	date null,					#楼栋投入使用时间
		PRIMARY KEY(name)
);

drop table building;

/*==============================================================*/
/* Table:宿舍                                                    */
/*==============================================================*/
create table dormitory
(
		number	varchar(50) not null,			#宿舍编号
		building		varchar(100) not null,#所属楼栋
		unit		varchar(50) not null,			#单元
		createTime 	date null,						#宿舍投入使用时间
		PRIMARY KEY(number)
);

drop table dormitory;

/*==============================================================*/
/* Table:维修人员                                                    */
/*==============================================================*/
create table staff
(
		number	varchar(30) not null,			#人员编号
		name	varchar(30) not null,				#人员姓名
		telephone		varchar(20) not null,	#人员电话
		email		varchar(50) null,					#人员邮箱
		createTime	date null,						#入职时间
		PRIMARY KEY(number)
);

drop table staff;

/*==============================================================*/
/* Table:学生                                                    */
/*==============================================================*/
create table student
(
		id		varchar(20) not null,				#学号
		name	varchar(30) not null,				#姓名
		sex		varchar(10) not null,				#性别
		building	varchar(100) null,			#所属楼栋
		unit		varchar(50)    null,			#单元
		number	varchar(50)    null,			#宿舍编号
		cardID	varchar(50) not null,			#身份证号
		telephone		varchar(30) not null, #电话
		email		varchar(50) null,					#邮箱
		PRIMARY KEY(id)
);

drop table student;

/*==============================================================*/
/* Table:报修                                                    */
/*==============================================================*/
create table repair
(
		number	int(11) not null AUTO_INCREMENT,   #报修编号
		topic 	enum('建筑维修','电器设备维修','水电管道维修','绿化景观维护','家具设备维修','IT设备维修','安全设施维护')not NULL,	#报修主题
		person	varchar(30)	not null,		#报修人
		contactNumber		varchar(30) not null,		#联系电话
		content	text null,							#具体描述
		state		enum('待派单','维修中','已完成') NULL DEFAULT('待派单'),	#状态
		staffNo		varchar(20) null ,				#维修人员工号
		staffNumber	varchar(30) null DEFAULT('62752114'),		#维修电话
		createTime	date null DEFAULT(NOW()),					#提交时间
		flag 	varchar(30) not null,					#标志域
		PRIMARY KEY(number)
);

drop table repair;

/*==============================================================*/
/* Table:反馈                                                    */
/*==============================================================*/
create table feedback
(
		number	int(11) not null AUTO_INCREMENT,		#反馈编号
		type		enum('投诉单','建议单')not NULL,#反馈类型
		topic		varchar(50) not null,		#反馈主题
		content	varchar(100) not null,	#反馈内容
		person	varchar(30) not null,		#反馈人
		telephone	varchar(30) not null,	#反馈人电话
		createTime	date null DEFAULT(NOW()),					#发布时间
		flag 	varchar(30) not null,					#标志域
		PRIMARY KEY(number)
);

drop table feedback;

/*==============================================================*/
/* Table:系统公告                                                 */
/*==============================================================*/
create table notification
(
		number	int(11) not null AUTO_INCREMENT,		#公告编号
		topic		text not null,					#主题
		publisher	varchar(30) null DEFAULT('管理员'),	#发布人
		createTime	date null DEFAULT(NOW()),					#发布时间
		PRIMARY KEY(number)	
);

drop table notification;