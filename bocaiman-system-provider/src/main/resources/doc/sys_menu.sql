-- 菜单信息表
drop table if exists sys_menu;
create table sys_menu(
    id varchar(100) not null comment '主键',
    parent varchar(100) comment '上级菜单',
    text varchar(255) not null comment '文本',
    url varchar(255) not null comment '链接地址',
    icon varchar(255) comment '图标',
    status int(2) not null default 1 commnet '状态：0-禁用，1-启用',
    createAdmin varchar(100) comment '创建人',
    createTime timestamp not null default CURRENT_TIMESTAMP comment '创建时间',
    updateAdmin varchar(100) comment '修改人',
    updateTime timestamp not null default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP comment '修改时间',
    primary key(id)
)Engine=InnoDB charset='utf8mb4' comment='菜单信息表';