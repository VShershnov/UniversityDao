--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.2
-- Dumped by pg_dump version 9.6.3

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: Courses; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE "Courses" (
    id bigint NOT NULL,
    name text,
    duration integer
);


ALTER TABLE "Courses" OWNER TO postgres;

--
-- Name: COURSES_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE "COURSES_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE "COURSES_id_seq" OWNER TO postgres;

--
-- Name: COURSES_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE "COURSES_id_seq" OWNED BY "Courses".id;


--
-- Name: Groups; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE "Groups" (
    id bigint NOT NULL,
    name text
);


ALTER TABLE "Groups" OWNER TO postgres;

--
-- Name: GROUPS_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE "GROUPS_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE "GROUPS_id_seq" OWNER TO postgres;

--
-- Name: GROUPS_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE "GROUPS_id_seq" OWNED BY "Groups".id;


--
-- Name: Professors; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE "Professors" (
    id bigint NOT NULL,
    fullname text
);


ALTER TABLE "Professors" OWNER TO postgres;

--
-- Name: Rooms; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE "Rooms" (
    id bigint NOT NULL,
    capacity integer,
    address text
);


ALTER TABLE "Rooms" OWNER TO postgres;

--
-- Name: ROOMS_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE "ROOMS_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE "ROOMS_id_seq" OWNER TO postgres;

--
-- Name: ROOMS_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE "ROOMS_id_seq" OWNED BY "Rooms".id;


--
-- Name: Students; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE "Students" (
    id bigint NOT NULL,
    fullname text NOT NULL,
    group_id integer
);


ALTER TABLE "Students" OWNER TO postgres;

--
-- Name: STUDENTS_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE "STUDENTS_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE "STUDENTS_id_seq" OWNER TO postgres;

--
-- Name: STUDENTS_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE "STUDENTS_id_seq" OWNED BY "Students".id;


--
-- Name: ScheduleSlots; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE "ScheduleSlots" (
    id bigint NOT NULL,
    room_id integer,
    course_id integer,
    professor_id integer,
    group_id integer,
    timeunit_id integer
);


ALTER TABLE "ScheduleSlots" OWNER TO postgres;

--
-- Name: ScheduleSlots_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE "ScheduleSlots_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE "ScheduleSlots_id_seq" OWNER TO postgres;

--
-- Name: ScheduleSlots_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE "ScheduleSlots_id_seq" OWNED BY "ScheduleSlots".id;


--
-- Name: TimeUnit; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE "TimeUnit" (
    id bigint NOT NULL,
    month integer NOT NULL,
    day integer NOT NULL,
    "time" integer NOT NULL
);


ALTER TABLE "TimeUnit" OWNER TO postgres;

--
-- Name: TimeUnit_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE "TimeUnit_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE "TimeUnit_id_seq" OWNER TO postgres;

--
-- Name: TimeUnit_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE "TimeUnit_id_seq" OWNED BY "TimeUnit".id;


--
-- Name: groups_courses; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE groups_courses (
    group_id integer,
    course_id integer
);


ALTER TABLE groups_courses OWNER TO postgres;

--
-- Name: groups_students; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE groups_students (
    student_id integer,
    group_id integer
);


ALTER TABLE groups_students OWNER TO postgres;

--
-- Name: professors_courses; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE professors_courses (
    professor_id integer,
    course_id integer
);


ALTER TABLE professors_courses OWNER TO postgres;

--
-- Name: professors_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE professors_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE professors_id_seq OWNER TO postgres;

--
-- Name: professors_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE professors_id_seq OWNED BY "Professors".id;


--
-- Name: Courses id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Courses" ALTER COLUMN id SET DEFAULT nextval('"COURSES_id_seq"'::regclass);


--
-- Name: Groups id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Groups" ALTER COLUMN id SET DEFAULT nextval('"GROUPS_id_seq"'::regclass);


--
-- Name: Professors id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Professors" ALTER COLUMN id SET DEFAULT nextval('professors_id_seq'::regclass);


--
-- Name: Rooms id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Rooms" ALTER COLUMN id SET DEFAULT nextval('"ROOMS_id_seq"'::regclass);


--
-- Name: ScheduleSlots id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "ScheduleSlots" ALTER COLUMN id SET DEFAULT nextval('"ScheduleSlots_id_seq"'::regclass);


--
-- Name: Students id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Students" ALTER COLUMN id SET DEFAULT nextval('"STUDENTS_id_seq"'::regclass);


--
-- Name: TimeUnit id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "TimeUnit" ALTER COLUMN id SET DEFAULT nextval('"TimeUnit_id_seq"'::regclass);


--
-- Name: Courses COURSES_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Courses"
    ADD CONSTRAINT "COURSES_pkey" PRIMARY KEY (id);


--
-- Name: Groups GROUPS_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Groups"
    ADD CONSTRAINT "GROUPS_pkey" PRIMARY KEY (id);


--
-- Name: Rooms ROOMS_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Rooms"
    ADD CONSTRAINT "ROOMS_pkey" PRIMARY KEY (id);


--
-- Name: Students STUDENTS_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Students"
    ADD CONSTRAINT "STUDENTS_pkey" PRIMARY KEY (id);


--
-- Name: ScheduleSlots ScheduleSlots_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "ScheduleSlots"
    ADD CONSTRAINT "ScheduleSlots_pkey" PRIMARY KEY (id);


--
-- Name: ScheduleSlots ScheduleSlots_room_id_timeUnit_id_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "ScheduleSlots"
    ADD CONSTRAINT "ScheduleSlots_room_id_timeUnit_id_key" UNIQUE (room_id, timeunit_id);


--
-- Name: TimeUnit TimeUnit_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "TimeUnit"
    ADD CONSTRAINT "TimeUnit_pkey" PRIMARY KEY (id);


--
-- Name: groups_courses groups_courses_group_id_course_id_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY groups_courses
    ADD CONSTRAINT groups_courses_group_id_course_id_key UNIQUE (group_id, course_id);


--
-- Name: professors_courses professors_courses_professor_id_course_id_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY professors_courses
    ADD CONSTRAINT professors_courses_professor_id_course_id_key UNIQUE (professor_id, course_id);


--
-- Name: Professors professors_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Professors"
    ADD CONSTRAINT professors_pkey PRIMARY KEY (id);


--
-- Name: groups_students GROUPS_STUDENTS_group_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY groups_students
    ADD CONSTRAINT "GROUPS_STUDENTS_group_id_fkey" FOREIGN KEY (group_id) REFERENCES "Groups"(id);


--
-- Name: groups_students GROUPS_STUDENTS_student_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY groups_students
    ADD CONSTRAINT "GROUPS_STUDENTS_student_id_fkey" FOREIGN KEY (student_id) REFERENCES "Students"(id);


--
-- Name: ScheduleSlots ScheduleSlots_course_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "ScheduleSlots"
    ADD CONSTRAINT "ScheduleSlots_course_id_fkey" FOREIGN KEY (course_id) REFERENCES "Courses"(id);


--
-- Name: ScheduleSlots ScheduleSlots_group_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "ScheduleSlots"
    ADD CONSTRAINT "ScheduleSlots_group_id_fkey" FOREIGN KEY (group_id) REFERENCES "Groups"(id);


--
-- Name: ScheduleSlots ScheduleSlots_professor_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "ScheduleSlots"
    ADD CONSTRAINT "ScheduleSlots_professor_id_fkey" FOREIGN KEY (professor_id) REFERENCES "Professors"(id);


--
-- Name: ScheduleSlots ScheduleSlots_room_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "ScheduleSlots"
    ADD CONSTRAINT "ScheduleSlots_room_id_fkey" FOREIGN KEY (room_id) REFERENCES "Rooms"(id);


--
-- Name: ScheduleSlots ScheduleSlots_timeUnit_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "ScheduleSlots"
    ADD CONSTRAINT "ScheduleSlots_timeUnit_id_fkey" FOREIGN KEY (timeunit_id) REFERENCES "TimeUnit"(id);


--
-- Name: Students Students_group_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Students"
    ADD CONSTRAINT "Students_group_id_fkey" FOREIGN KEY (group_id) REFERENCES "Groups"(id);


--
-- Name: groups_courses groups_courses_course_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY groups_courses
    ADD CONSTRAINT groups_courses_course_id_fkey FOREIGN KEY (course_id) REFERENCES "Courses"(id);


--
-- Name: groups_courses groups_courses_group_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY groups_courses
    ADD CONSTRAINT groups_courses_group_id_fkey FOREIGN KEY (group_id) REFERENCES "Groups"(id);


--
-- Name: professors_courses professors_courses_course_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY professors_courses
    ADD CONSTRAINT professors_courses_course_id_fkey FOREIGN KEY (course_id) REFERENCES "Courses"(id);


--
-- Name: professors_courses professors_courses_professor_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY professors_courses
    ADD CONSTRAINT professors_courses_professor_id_fkey FOREIGN KEY (professor_id) REFERENCES "Professors"(id);


--
-- PostgreSQL database dump complete
--

