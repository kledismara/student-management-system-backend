CREATE TABLE students
(
    id           int auto_increment primary key,
    first_name   varchar(100),
    last_name    varchar(100),
    gender       varchar(1),
    birthday     date,
    email        varchar(255),
    mobile_phone varchar(100),
    is_active    boolean,
    created_at   datetime
)