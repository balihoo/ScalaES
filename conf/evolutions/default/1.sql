# --- Created by Slick DDL
# To stop Slick DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table "BRAND" ("ID" OTHER NOT NULL PRIMARY KEY,"KEY" VARCHAR NOT NULL);
create unique index "ux_key" on "BRAND" ("KEY");

# --- !Downs

drop table "BRAND";

