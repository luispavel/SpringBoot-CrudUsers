CREATE TABLE IF NOT EXISTS public.usuarios
(
    id_usuario integer NOT NULL DEFAULT nextval('usuarios_id_usuario_seq'::regclass),
    nombre character varying(100) COLLATE pg_catalog."default",
    apellidos character varying(100) COLLATE pg_catalog."default",
    direccion character varying(100) COLLATE pg_catalog."default",
    correo_electronico character varying(80) COLLATE pg_catalog."default",
    telefono_celular numeric,
    CONSTRAINT usuarios_pkey PRIMARY KEY (id_usuario)
    )
    WITH (
        OIDS = FALSE
        )
    TABLESPACE pg_default;
