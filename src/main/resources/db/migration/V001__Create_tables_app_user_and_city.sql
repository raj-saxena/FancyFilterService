drop table if exists city CASCADE;

create table city (
    id                  uuid not null,
    city_name           text not null,
    coordinates         point not null,
    primary key(id)
);

drop table if exists app_user;

create table app_user (
    id                  uuid not null,
    display_name        text,
    age                 smallint,
    job_title           text,
    height_in_cm        smallint,
    city_id             uuid references city(id),
    main_photo          text,
    compatibility_score decimal(4, 3),
    contacts_exchanged  smallint,
    favorite            boolean,
    religion            text,
    primary key(id)
);
