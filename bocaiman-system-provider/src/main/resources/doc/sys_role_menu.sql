-- 角色菜单表
drop table if exists sys_role_menu;
create table sys_role_menu(
    roleId varchar(100) not null comment '角色主键',
    menuId varchar(100) not null comment '菜单主键'
)Engine=InnoDB charset='utf8mb4' comment='角色菜单表';