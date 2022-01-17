CREATE SEQUENCE todo_item_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE todo_item
(
    id bigint NOT NULL DEFAULT nextval('todo_item_seq'::regclass),
    category character varying(255) COLLATE pg_catalog."default",
    name character varying(255) COLLATE pg_catalog."default",
	completed boolean DEFAULT false,
    CONSTRAINT todo_item_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

CREATE SEQUENCE user_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE user
(
    id bigint NOT NULL DEFAULT nextval('user_seq'::regclass),
    name character varying(255) COLLATE pg_catalog."default",
    email character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT user_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;
