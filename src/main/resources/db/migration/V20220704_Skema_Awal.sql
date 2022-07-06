create TABLE users(
    id character varying(36) NOT NULL,
    created_at timestamp without time zone,
    updated_at timestamp without time zone,
    password character varying(100),
    username character varying(50)
);

alter table ONLY users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);

create TABLE password_manager(
    id character varying(36) NOT NULL,
    created_at timestamp without time zone,
    updated_at timestamp without time zone,
    saved_password character varying(100),
    saved_username character varying(50),
    saved_website character varying(50),
    user_id character varying(36)
);

alter table ONLY password_manager
    ADD CONSTRAINT password_manager_pkey PRIMARY KEY (id);

alter table ONLY password_manager
    ADD CONSTRAINT fkid5uabbhb1vv6rx03o959oku FOREIGN KEY (user_id) REFERENCES users(id);

create TABLE personal_info(
    id character varying(36) NOT NULL,
    created_at timestamp without time zone,
    updated_at timestamp without time zone,
    pi_address character varying(255),
    pi_company character varying(50),
    pi_email character varying(100),
    pi_phone_number character varying(50),
    pi_website character varying(50),
    user_id character varying(36)
);

alter table ONLY personal_info
    ADD CONSTRAINT personal_info_pkey PRIMARY KEY (id);

alter table ONLY personal_info
    ADD CONSTRAINT fk2ooyctbfk03w21tuk720ixnqh FOREIGN KEY (user_id) REFERENCES users(id);

create TABLE note(
    id character varying(36) NOT NULL,
    created_at timestamp without time zone,
    updated_at timestamp without time zone,
    note_description character varying(255),
    note_title character varying(100),
    user_id character varying(36)
);

alter table ONLY note
    ADD CONSTRAINT note_pkey PRIMARY KEY (id);

alter table ONLY note
    ADD CONSTRAINT fkechaouoa6kus6k1dpix1u91c FOREIGN KEY (user_id) REFERENCES users(id);