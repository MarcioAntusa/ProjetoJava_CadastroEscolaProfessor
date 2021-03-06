PGDMP     #                    z            faculdade_BD    14.2    14.2     	           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            
           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    16738    faculdade_BD    DATABASE     n   CREATE DATABASE "faculdade_BD" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Portuguese_Brazil.1252';
    DROP DATABASE "faculdade_BD";
                postgres    false            ?            1259    16740    escola    TABLE       CREATE TABLE public.escola (
    nome_escola character varying(50) NOT NULL,
    telefone_escola character varying(20) NOT NULL,
    email_escola character varying(50) NOT NULL,
    endereco_escola character varying(50) NOT NULL,
    id_escola integer NOT NULL
);
    DROP TABLE public.escola;
       public         heap    postgres    false            ?            1259    16739    escola_id_escola_seq    SEQUENCE     ?   CREATE SEQUENCE public.escola_id_escola_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.escola_id_escola_seq;
       public          postgres    false    210                       0    0    escola_id_escola_seq    SEQUENCE OWNED BY     M   ALTER SEQUENCE public.escola_id_escola_seq OWNED BY public.escola.id_escola;
          public          postgres    false    209            ?            1259    16755 	   professor    TABLE     s  CREATE TABLE public.professor (
    id_prof integer NOT NULL,
    mat_prof integer NOT NULL,
    nome_prof character varying(50) NOT NULL,
    telefone_prof character varying(20) NOT NULL,
    email_prof character varying(50) NOT NULL,
    endereco_prof character varying(50) NOT NULL,
    titulacao_prof character varying(20) NOT NULL,
    id_escola integer NOT NULL
);
    DROP TABLE public.professor;
       public         heap    postgres    false            ?            1259    16754    professor_id_prof_seq    SEQUENCE     ?   CREATE SEQUENCE public.professor_id_prof_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ,   DROP SEQUENCE public.professor_id_prof_seq;
       public          postgres    false    212                       0    0    professor_id_prof_seq    SEQUENCE OWNED BY     O   ALTER SEQUENCE public.professor_id_prof_seq OWNED BY public.professor.id_prof;
          public          postgres    false    211            a           2604    16743    escola id_escola    DEFAULT     t   ALTER TABLE ONLY public.escola ALTER COLUMN id_escola SET DEFAULT nextval('public.escola_id_escola_seq'::regclass);
 ?   ALTER TABLE public.escola ALTER COLUMN id_escola DROP DEFAULT;
       public          postgres    false    210    209    210            b           2604    16758    professor id_prof    DEFAULT     v   ALTER TABLE ONLY public.professor ALTER COLUMN id_prof SET DEFAULT nextval('public.professor_id_prof_seq'::regclass);
 @   ALTER TABLE public.professor ALTER COLUMN id_prof DROP DEFAULT;
       public          postgres    false    211    212    212                      0    16740    escola 
   TABLE DATA           h   COPY public.escola (nome_escola, telefone_escola, email_escola, endereco_escola, id_escola) FROM stdin;
    public          postgres    false    210   ?                  0    16755 	   professor 
   TABLE DATA           ?   COPY public.professor (id_prof, mat_prof, nome_prof, telefone_prof, email_prof, endereco_prof, titulacao_prof, id_escola) FROM stdin;
    public          postgres    false    212   ?                   0    0    escola_id_escola_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.escola_id_escola_seq', 1, false);
          public          postgres    false    209                       0    0    professor_id_prof_seq    SEQUENCE SET     D   SELECT pg_catalog.setval('public.professor_id_prof_seq', 1, false);
          public          postgres    false    211            d           2606    16751    escola escola_email_escola_key 
   CONSTRAINT     a   ALTER TABLE ONLY public.escola
    ADD CONSTRAINT escola_email_escola_key UNIQUE (email_escola);
 H   ALTER TABLE ONLY public.escola DROP CONSTRAINT escola_email_escola_key;
       public            postgres    false    210            f           2606    16753 !   escola escola_endereco_escola_key 
   CONSTRAINT     g   ALTER TABLE ONLY public.escola
    ADD CONSTRAINT escola_endereco_escola_key UNIQUE (endereco_escola);
 K   ALTER TABLE ONLY public.escola DROP CONSTRAINT escola_endereco_escola_key;
       public            postgres    false    210            h           2606    16747    escola escola_nome_escola_key 
   CONSTRAINT     _   ALTER TABLE ONLY public.escola
    ADD CONSTRAINT escola_nome_escola_key UNIQUE (nome_escola);
 G   ALTER TABLE ONLY public.escola DROP CONSTRAINT escola_nome_escola_key;
       public            postgres    false    210            j           2606    16745    escola escola_pkey 
   CONSTRAINT     W   ALTER TABLE ONLY public.escola
    ADD CONSTRAINT escola_pkey PRIMARY KEY (id_escola);
 <   ALTER TABLE ONLY public.escola DROP CONSTRAINT escola_pkey;
       public            postgres    false    210            l           2606    16749 !   escola escola_telefone_escola_key 
   CONSTRAINT     g   ALTER TABLE ONLY public.escola
    ADD CONSTRAINT escola_telefone_escola_key UNIQUE (telefone_escola);
 K   ALTER TABLE ONLY public.escola DROP CONSTRAINT escola_telefone_escola_key;
       public            postgres    false    210            n           2606    16766 "   professor professor_email_prof_key 
   CONSTRAINT     c   ALTER TABLE ONLY public.professor
    ADD CONSTRAINT professor_email_prof_key UNIQUE (email_prof);
 L   ALTER TABLE ONLY public.professor DROP CONSTRAINT professor_email_prof_key;
       public            postgres    false    212            p           2606    16768 %   professor professor_endereco_prof_key 
   CONSTRAINT     i   ALTER TABLE ONLY public.professor
    ADD CONSTRAINT professor_endereco_prof_key UNIQUE (endereco_prof);
 O   ALTER TABLE ONLY public.professor DROP CONSTRAINT professor_endereco_prof_key;
       public            postgres    false    212            r           2606    16762     professor professor_mat_prof_key 
   CONSTRAINT     _   ALTER TABLE ONLY public.professor
    ADD CONSTRAINT professor_mat_prof_key UNIQUE (mat_prof);
 J   ALTER TABLE ONLY public.professor DROP CONSTRAINT professor_mat_prof_key;
       public            postgres    false    212            t           2606    16760    professor professor_pkey 
   CONSTRAINT     [   ALTER TABLE ONLY public.professor
    ADD CONSTRAINT professor_pkey PRIMARY KEY (id_prof);
 B   ALTER TABLE ONLY public.professor DROP CONSTRAINT professor_pkey;
       public            postgres    false    212            v           2606    16764 %   professor professor_telefone_prof_key 
   CONSTRAINT     i   ALTER TABLE ONLY public.professor
    ADD CONSTRAINT professor_telefone_prof_key UNIQUE (telefone_prof);
 O   ALTER TABLE ONLY public.professor DROP CONSTRAINT professor_telefone_prof_key;
       public            postgres    false    212            w           2606    16769 "   professor professor_id_escola_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.professor
    ADD CONSTRAINT professor_id_escola_fkey FOREIGN KEY (id_escola) REFERENCES public.escola(id_escola);
 L   ALTER TABLE ONLY public.professor DROP CONSTRAINT professor_id_escola_fkey;
       public          postgres    false    212    210    3178                  x?????? ? ?            x?????? ? ?     