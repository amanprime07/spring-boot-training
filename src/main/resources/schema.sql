create table customer (
    customer_id integer not null,
    name varchar(255) not null,
    date_of_birth date,
    nationality varchar(255),
    email_address varchar(255),
    address varchar(255),
    kyc_verified bool
)