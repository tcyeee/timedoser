-- auto-generated definition
create table time_doser_user.acl_user
(
    id                     varchar(100) charset utf8mb4        not null primary key,
    username               varchar(100) charset utf8mb4        null comment '昵称',
    mobilephone            varchar(11) charset utf8mb4         null comment '手机号',
    password               varchar(40) charset utf8mb4         null comment '密码',
    gender                 int                                 null comment '性别',
    email                  varchar(30) charset utf8mb4         null comment '邮箱',
    avatar_url             varchar(255) charset utf8mb4        null comment '头像地址',
    enable                 int(4)    default 1                 not null comment '账户状态 1：可用 3：注销',
    account_type           int(4)    default 1                 not null comment '用户类型 1：小程序注册用户 2：手机号注册 3：作者 4：管理员',
    openid                 varchar(40) charset utf8mb4         null comment '[小程序]唯一id',
    country                varchar(10) charset utf8mb4         null comment '国家',
    province               varchar(10) charset utf8mb4         null comment '省',
    city                   varchar(10) charset utf8mb4         null comment '市',
    createdate             timestamp default CURRENT_TIMESTAMP null comment '创建时间',
    last_password_reset    timestamp default CURRENT_TIMESTAMP null comment '用户上次登录时间',
    personalized_signature varchar(100) charset utf8mb4        null comment '个性签名'
)
    comment '基础用户表' charset = utf8;
create index acl_user_mobilephone_index on time_doser_user.acl_user (mobilephone);

-- auto-generated definition
create table time_doser_user.acl_auth
(
    id          int(20) auto_increment primary key,
    code        int(20)                             not null comment '权限编码',
    name        varchar(20) charset utf8mb4         null comment '权限名称',
    remark      varchar(50) charset utf8mb4         null comment '权限备注',
    create_time timestamp default CURRENT_TIMESTAMP not null comment '创建时间',
    constraint acl_auth_code_uindex
        unique (code)
)
    comment '权限表' charset = utf8;

-- auto-generated definition
create table time_doser_user.acl_role
(
    id          int auto_increment primary key,
    name        varchar(20) charset utf8mb4         null comment '角色名称',
    remark      varchar(50) charset utf8mb4         null comment '角色备注',
    create_time timestamp default CURRENT_TIMESTAMP not null comment '创建时间',
    constraint acl_role_name_uindex unique (name)
)
    comment '角色表' charset = utf8;

-- auto-generated definition
create table time_doser_user.acl_role_auth
(
    id          int(20) auto_increment primary key,
    role_id     int(20)                             not null comment '角色ID',
    auth_id     int(20)                             not null comment '权限ID',
    create_time timestamp default CURRENT_TIMESTAMP not null comment '创建时间',
    constraint acl_role_auth_acl_auth_id_fk foreign key (auth_id) references time_doser_user.acl_auth (id),
    constraint acl_role_auth_acl_role_id_fk foreign key (role_id) references time_doser_user.acl_role (id)
)
    comment '角色-权限表' charset = utf8;

-- auto-generated definition
create table time_doser_user.acl_user_role
(
    id          int(20) auto_increment primary key,
    user_id     varchar(100) charset utf8mb4        not null comment '用户ID',
    role_id     int(20)                             not null comment '角色ID',
    create_time timestamp default CURRENT_TIMESTAMP not null comment '创建时间',
    constraint acl_user_role_acl_role_id_fk foreign key (role_id) references time_doser_user.acl_role (id),
    constraint acl_user_role_acl_user_id_fk foreign key (user_id) references time_doser_user.acl_user (id)
)
    comment '用户-角色表' charset = utf8;

