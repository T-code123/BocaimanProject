-- 系统管理员信息表
drop table if exists sys_admin;
create table sys_admin(
    id varchar(100) not null comment '主键',
    name varchar(255) not null comment '姓名',
    cellphone varchar(100) not null comment '手机号码',
    password varchar(500) not null comment '登录密码',
    roleCode varchar(100) not null comment '角色编码',
    idCard varchar(100) not null comment '身份证号码',
    email varchar(500) not null comment '电子邮件',
    avatar varchar(500) comment '头像',
    status int(2) not null default 1 comment '系统状态：0-禁用，1-启用',
    createAdmin varchar(100) comment '创建人',
    createTime timestamp not null default CURRENT_TIMESTAMP comment '创建时间',
    updateAdmin varchar(100) comment '修改人',
    updateTime timestamp not null default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP comment '修改时间',
    primary key(id)
)Engine=InnoDB charset='utf8mb4' comment='系统管理员信息表';
