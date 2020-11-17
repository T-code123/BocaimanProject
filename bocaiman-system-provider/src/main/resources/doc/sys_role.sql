-- 角色信息表
drop table if exists sys_role;
create table sys_role(
    id varchar(100) not null comment '主键',
    name varchar(255) not null comment '角色名称',
    code varchar(100) not null comment '角色编码',
    status int(2) not null default 1 commnet '状态：0-禁用，1-启用',
    createAdmin varchar(100) comment '创建人',
    createTime timestamp not null default CURRENT_TIMESTAMP comment '创建时间',
    updateAdmin varchar(100) comment '修改人',
    updateTime timestamp not null default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP comment '修改时间',
    primary key(id)
)Engine=InnoDB charset='utf8mb4' comment='角色信息表';

insert into sys_role(id,name,code,status) values('A8D143C85CE3B0D9E943794C0B270146','菠菜侠','SUPER',1);