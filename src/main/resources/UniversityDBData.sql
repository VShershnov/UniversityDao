--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.2
-- Dumped by pg_dump version 9.6.3

-- Started on 2017-10-25 18:57:52

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

SET search_path = public, pg_catalog;

--
-- TOC entry 2231 (class 0 OID 0)
-- Dependencies: 186
-- Name: COURSES_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('"COURSES_id_seq"', 145, true);


--
-- TOC entry 2210 (class 0 OID 16394)
-- Dependencies: 185
-- Data for Name: Courses; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO "Courses" VALUES (1, 'JavaEE', 10);
INSERT INTO "Courses" VALUES (5, 'JavaEE', 10);
INSERT INTO "Courses" VALUES (8, 'JavaEE', 10);
INSERT INTO "Courses" VALUES (11, 'JavaEE', 10);
INSERT INTO "Courses" VALUES (14, 'JavaEE', 10);
INSERT INTO "Courses" VALUES (15, 'JavaEE', 10);
INSERT INTO "Courses" VALUES (18, 'JavaEE', 10);
INSERT INTO "Courses" VALUES (59, 'JavaFX', 10);
INSERT INTO "Courses" VALUES (60, 'Java', 40);
INSERT INTO "Courses" VALUES (63, 'JavaFX', 10);
INSERT INTO "Courses" VALUES (64, 'Java', 40);
INSERT INTO "Courses" VALUES (135, 'JavaFX', 10);
INSERT INTO "Courses" VALUES (67, 'JavaFX', 10);
INSERT INTO "Courses" VALUES (68, 'Java', 40);
INSERT INTO "Courses" VALUES (136, 'Java', 40);
INSERT INTO "Courses" VALUES (71, 'JavaFX', 10);
INSERT INTO "Courses" VALUES (72, 'Java', 40);
INSERT INTO "Courses" VALUES (75, 'JavaFX', 10);
INSERT INTO "Courses" VALUES (76, 'Java', 40);
INSERT INTO "Courses" VALUES (79, 'JavaFX', 10);
INSERT INTO "Courses" VALUES (80, 'Java', 40);
INSERT INTO "Courses" VALUES (138, 'JavaEE', 10);
INSERT INTO "Courses" VALUES (83, 'JavaFX', 10);
INSERT INTO "Courses" VALUES (84, 'Java', 40);
INSERT INTO "Courses" VALUES (139, 'JavaFX', 10);
INSERT INTO "Courses" VALUES (87, 'JavaFX', 10);
INSERT INTO "Courses" VALUES (88, 'Java', 40);
INSERT INTO "Courses" VALUES (140, 'Java', 40);
INSERT INTO "Courses" VALUES (91, 'JavaFX', 10);
INSERT INTO "Courses" VALUES (92, 'Java', 40);
INSERT INTO "Courses" VALUES (95, 'JavaFX', 10);
INSERT INTO "Courses" VALUES (96, 'Java', 40);
INSERT INTO "Courses" VALUES (99, 'JavaFX', 10);
INSERT INTO "Courses" VALUES (100, 'Java', 40);
INSERT INTO "Courses" VALUES (101, 'JavaEE', 10);
INSERT INTO "Courses" VALUES (103, 'JavaFX', 10);
INSERT INTO "Courses" VALUES (104, 'Java', 40);
INSERT INTO "Courses" VALUES (143, 'JavaFX', 10);
INSERT INTO "Courses" VALUES (107, 'JavaFX', 10);
INSERT INTO "Courses" VALUES (2, 'JavaEE', 10);
INSERT INTO "Courses" VALUES (3, 'Java', 40);
INSERT INTO "Courses" VALUES (6, 'JavaEE', 10);
INSERT INTO "Courses" VALUES (7, 'JavaEE', 10);
INSERT INTO "Courses" VALUES (9, 'Java', 40);
INSERT INTO "Courses" VALUES (10, 'JavaEE', 10);
INSERT INTO "Courses" VALUES (12, 'JavaEE', 10);
INSERT INTO "Courses" VALUES (13, 'Java', 40);
INSERT INTO "Courses" VALUES (16, 'JavaEE', 10);
INSERT INTO "Courses" VALUES (17, 'JavaEE', 10);
INSERT INTO "Courses" VALUES (19, 'Java', 40);
INSERT INTO "Courses" VALUES (20, 'JavaEE', 10);
INSERT INTO "Courses" VALUES (21, 'JavaEE', 10);
INSERT INTO "Courses" VALUES (22, 'JavaEE', 10);
INSERT INTO "Courses" VALUES (23, 'JavaEE', 13);
INSERT INTO "Courses" VALUES (24, 'JavaEE', 10);
INSERT INTO "Courses" VALUES (25, 'JavaEE', 10);
INSERT INTO "Courses" VALUES (26, 'Java', 40);
INSERT INTO "Courses" VALUES (27, 'JavaEE', 10);
INSERT INTO "Courses" VALUES (28, 'JavaEE', 10);
INSERT INTO "Courses" VALUES (29, 'JavaEE', 10);
INSERT INTO "Courses" VALUES (30, 'JavaEE', 10);
INSERT INTO "Courses" VALUES (31, 'JavaEE', 10);
INSERT INTO "Courses" VALUES (32, 'Java', 40);
INSERT INTO "Courses" VALUES (34, 'JavaEE', 10);
INSERT INTO "Courses" VALUES (35, 'JavaEE', 10);
INSERT INTO "Courses" VALUES (36, 'JavaEE', 10);
INSERT INTO "Courses" VALUES (37, 'JavaEE', 10);
INSERT INTO "Courses" VALUES (38, 'JavaEE', 10);
INSERT INTO "Courses" VALUES (39, 'JavaEE', 10);
INSERT INTO "Courses" VALUES (40, 'JavaEE', 10);
INSERT INTO "Courses" VALUES (43, 'JavaEE', 10);
INSERT INTO "Courses" VALUES (44, 'Java', 40);
INSERT INTO "Courses" VALUES (47, 'JavaFX', 10);
INSERT INTO "Courses" VALUES (48, 'Java', 40);
INSERT INTO "Courses" VALUES (51, 'JavaFX', 10);
INSERT INTO "Courses" VALUES (52, 'Java', 40);
INSERT INTO "Courses" VALUES (55, 'JavaFX', 10);
INSERT INTO "Courses" VALUES (56, 'Java', 40);
INSERT INTO "Courses" VALUES (108, 'Java', 40);
INSERT INTO "Courses" VALUES (144, 'Java', 40);
INSERT INTO "Courses" VALUES (111, 'JavaFX', 10);
INSERT INTO "Courses" VALUES (112, 'Java', 40);
INSERT INTO "Courses" VALUES (115, 'JavaFX', 10);
INSERT INTO "Courses" VALUES (116, 'Java', 40);
INSERT INTO "Courses" VALUES (4, 'Math', 12);
INSERT INTO "Courses" VALUES (119, 'JavaFX', 10);
INSERT INTO "Courses" VALUES (120, 'Java', 40);
INSERT INTO "Courses" VALUES (123, 'JavaFX', 10);
INSERT INTO "Courses" VALUES (124, 'Java', 40);
INSERT INTO "Courses" VALUES (127, 'JavaFX', 10);
INSERT INTO "Courses" VALUES (128, 'Java', 40);
INSERT INTO "Courses" VALUES (131, 'JavaFX', 10);
INSERT INTO "Courses" VALUES (132, 'Java', 40);


--
-- TOC entry 2232 (class 0 OID 0)
-- Dependencies: 188
-- Name: GROUPS_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('"GROUPS_id_seq"', 116, true);


--
-- TOC entry 2212 (class 0 OID 16402)
-- Dependencies: 187
-- Data for Name: Groups; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO "Groups" VALUES (1, 'FIOT');
INSERT INTO "Groups" VALUES (2, 'QA');
INSERT INTO "Groups" VALUES (4, 'IPSA');
INSERT INTO "Groups" VALUES (5, 'IPSA');
INSERT INTO "Groups" VALUES (6, 'IPSA');
INSERT INTO "Groups" VALUES (7, 'IPSA');
INSERT INTO "Groups" VALUES (8, 'IPSA');
INSERT INTO "Groups" VALUES (15, 'IPSA');
INSERT INTO "Groups" VALUES (14, 'FL');
INSERT INTO "Groups" VALUES (18, 'FL');
INSERT INTO "Groups" VALUES (19, 'IPSA');
INSERT INTO "Groups" VALUES (22, 'FL');
INSERT INTO "Groups" VALUES (26, 'FL');
INSERT INTO "Groups" VALUES (27, 'IPSA');
INSERT INTO "Groups" VALUES (106, 'FL');
INSERT INTO "Groups" VALUES (30, 'FL');
INSERT INTO "Groups" VALUES (31, 'IPSA');
INSERT INTO "Groups" VALUES (107, 'IPSA');
INSERT INTO "Groups" VALUES (34, 'FL');
INSERT INTO "Groups" VALUES (35, 'IPSA');
INSERT INTO "Groups" VALUES (110, 'FL');
INSERT INTO "Groups" VALUES (111, 'IPSA');
INSERT INTO "Groups" VALUES (38, 'FL');
INSERT INTO "Groups" VALUES (39, 'IPSA');
INSERT INTO "Groups" VALUES (42, 'FL');
INSERT INTO "Groups" VALUES (43, 'IPSA');
INSERT INTO "Groups" VALUES (114, 'FL');
INSERT INTO "Groups" VALUES (115, 'IPSA');
INSERT INTO "Groups" VALUES (46, 'FL');
INSERT INTO "Groups" VALUES (47, 'IPSA');
INSERT INTO "Groups" VALUES (3, 'FTZI');
INSERT INTO "Groups" VALUES (50, 'FL');
INSERT INTO "Groups" VALUES (51, 'IPSA');
INSERT INTO "Groups" VALUES (54, 'FL');
INSERT INTO "Groups" VALUES (55, 'IPSA');
INSERT INTO "Groups" VALUES (58, 'FL');
INSERT INTO "Groups" VALUES (59, 'IPSA');
INSERT INTO "Groups" VALUES (62, 'FL');
INSERT INTO "Groups" VALUES (63, 'IPSA');
INSERT INTO "Groups" VALUES (66, 'FL');
INSERT INTO "Groups" VALUES (67, 'IPSA');
INSERT INTO "Groups" VALUES (70, 'FL');
INSERT INTO "Groups" VALUES (74, 'FL');
INSERT INTO "Groups" VALUES (75, 'IPSA');
INSERT INTO "Groups" VALUES (78, 'FL');
INSERT INTO "Groups" VALUES (79, 'IPSA');
INSERT INTO "Groups" VALUES (82, 'FL');
INSERT INTO "Groups" VALUES (83, 'IPSA');
INSERT INTO "Groups" VALUES (86, 'FL');
INSERT INTO "Groups" VALUES (87, 'IPSA');
INSERT INTO "Groups" VALUES (90, 'FL');
INSERT INTO "Groups" VALUES (91, 'IPSA');
INSERT INTO "Groups" VALUES (94, 'FL');
INSERT INTO "Groups" VALUES (95, 'IPSA');
INSERT INTO "Groups" VALUES (98, 'FL');
INSERT INTO "Groups" VALUES (99, 'IPSA');
INSERT INTO "Groups" VALUES (102, 'FL');
INSERT INTO "Groups" VALUES (103, 'IPSA');


--
-- TOC entry 2214 (class 0 OID 16410)
-- Dependencies: 189
-- Data for Name: Professors; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO "Professors" VALUES (2, 'Yarmolenko');
INSERT INTO "Professors" VALUES (3, 'Stepanova');
INSERT INTO "Professors" VALUES (18, 'Vitaly');
INSERT INTO "Professors" VALUES (4, 'Stetina');
INSERT INTO "Professors" VALUES (5, 'Stetina');
INSERT INTO "Professors" VALUES (6, 'Stetina');
INSERT INTO "Professors" VALUES (9, 'Stetina');
INSERT INTO "Professors" VALUES (11, 'Stetina');
INSERT INTO "Professors" VALUES (20, 'Vasiliev');
INSERT INTO "Professors" VALUES (23, 'Vasiliev');
INSERT INTO "Professors" VALUES (24, 'Stetina');
INSERT INTO "Professors" VALUES (25, 'Stetina');
INSERT INTO "Professors" VALUES (26, 'Vasiliev');
INSERT INTO "Professors" VALUES (29, 'Vasiliev');
INSERT INTO "Professors" VALUES (36, 'Vasiliev');
INSERT INTO "Professors" VALUES (1, 'Petrov');


--
-- TOC entry 2233 (class 0 OID 0)
-- Dependencies: 191
-- Name: ROOMS_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('"ROOMS_id_seq"', 76, true);


--
-- TOC entry 2215 (class 0 OID 16416)
-- Dependencies: 190
-- Data for Name: Rooms; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO "Rooms" VALUES (1, 5, 'Kiev');
INSERT INTO "Rooms" VALUES (2, 5, 'Kiev');
INSERT INTO "Rooms" VALUES (3, 40, 'Kiev');
INSERT INTO "Rooms" VALUES (8, 43, 'Lviv');
INSERT INTO "Rooms" VALUES (9, 40, 'Lviv');
INSERT INTO "Rooms" VALUES (11, 43, 'Lviv');
INSERT INTO "Rooms" VALUES (12, 40, 'Lviv');
INSERT INTO "Rooms" VALUES (5, 43, 'Lviv');
INSERT INTO "Rooms" VALUES (6, 40, 'Lviv');
INSERT INTO "Rooms" VALUES (14, 43, 'Lviv');
INSERT INTO "Rooms" VALUES (15, 40, 'Lviv');
INSERT INTO "Rooms" VALUES (17, 43, 'Lviv');
INSERT INTO "Rooms" VALUES (18, 40, 'Lviv');
INSERT INTO "Rooms" VALUES (20, 43, 'Lviv');
INSERT INTO "Rooms" VALUES (21, 40, 'Lviv');
INSERT INTO "Rooms" VALUES (23, 43, 'Lviv');
INSERT INTO "Rooms" VALUES (24, 40, 'Lviv');
INSERT INTO "Rooms" VALUES (26, 43, 'Lviv');
INSERT INTO "Rooms" VALUES (27, 40, 'Lviv');
INSERT INTO "Rooms" VALUES (29, 43, 'Lviv');
INSERT INTO "Rooms" VALUES (30, 40, 'Lviv');
INSERT INTO "Rooms" VALUES (32, 43, 'Lviv');
INSERT INTO "Rooms" VALUES (33, 40, 'Lviv');
INSERT INTO "Rooms" VALUES (35, 43, 'Lviv');
INSERT INTO "Rooms" VALUES (36, 40, 'Lviv');
INSERT INTO "Rooms" VALUES (38, 43, 'Lviv');
INSERT INTO "Rooms" VALUES (39, 40, 'Lviv');
INSERT INTO "Rooms" VALUES (41, 43, 'Lviv');
INSERT INTO "Rooms" VALUES (42, 40, 'Lviv');
INSERT INTO "Rooms" VALUES (44, 43, 'Lviv');
INSERT INTO "Rooms" VALUES (45, 40, 'Lviv');
INSERT INTO "Rooms" VALUES (47, 43, 'Lviv');
INSERT INTO "Rooms" VALUES (48, 40, 'Lviv');
INSERT INTO "Rooms" VALUES (50, 43, 'Lviv');
INSERT INTO "Rooms" VALUES (51, 40, 'Lviv');
INSERT INTO "Rooms" VALUES (53, 43, 'Lviv');
INSERT INTO "Rooms" VALUES (54, 40, 'Lviv');
INSERT INTO "Rooms" VALUES (56, 43, 'Lviv');
INSERT INTO "Rooms" VALUES (57, 40, 'Lviv');
INSERT INTO "Rooms" VALUES (59, 43, 'Lviv');
INSERT INTO "Rooms" VALUES (60, 40, 'Lviv');
INSERT INTO "Rooms" VALUES (62, 43, 'Lviv');
INSERT INTO "Rooms" VALUES (63, 40, 'Lviv');
INSERT INTO "Rooms" VALUES (65, 43, 'Lviv');
INSERT INTO "Rooms" VALUES (66, 40, 'Lviv');
INSERT INTO "Rooms" VALUES (68, 43, 'Lviv');
INSERT INTO "Rooms" VALUES (69, 40, 'Lviv');
INSERT INTO "Rooms" VALUES (71, 43, 'Lviv');
INSERT INTO "Rooms" VALUES (72, 40, 'Lviv');
INSERT INTO "Rooms" VALUES (74, 43, 'Lviv');
INSERT INTO "Rooms" VALUES (75, 40, 'Lviv');
INSERT INTO "Rooms" VALUES (4, 15, 'Chernivtsi');


--
-- TOC entry 2234 (class 0 OID 0)
-- Dependencies: 193
-- Name: STUDENTS_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('"STUDENTS_id_seq"', 45, true);


--
-- TOC entry 2226 (class 0 OID 16502)
-- Dependencies: 201
-- Data for Name: TimeUnit; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO "TimeUnit" VALUES (1, 10, 18, 10);
INSERT INTO "TimeUnit" VALUES (2, 10, 18, 9);
INSERT INTO "TimeUnit" VALUES (5, 10, 18, 9);
INSERT INTO "TimeUnit" VALUES (7, 10, 18, 10);
INSERT INTO "TimeUnit" VALUES (8, 10, 18, 9);
INSERT INTO "TimeUnit" VALUES (10, 10, 18, 10);
INSERT INTO "TimeUnit" VALUES (11, 10, 18, 9);
INSERT INTO "TimeUnit" VALUES (13, 10, 18, 10);
INSERT INTO "TimeUnit" VALUES (14, 10, 18, 9);
INSERT INTO "TimeUnit" VALUES (16, 10, 18, 10);
INSERT INTO "TimeUnit" VALUES (17, 10, 18, 9);
INSERT INTO "TimeUnit" VALUES (19, 10, 18, 10);
INSERT INTO "TimeUnit" VALUES (20, 10, 18, 9);
INSERT INTO "TimeUnit" VALUES (22, 10, 18, 10);
INSERT INTO "TimeUnit" VALUES (23, 10, 18, 9);
INSERT INTO "TimeUnit" VALUES (25, 10, 18, 10);
INSERT INTO "TimeUnit" VALUES (26, 10, 18, 9);
INSERT INTO "TimeUnit" VALUES (28, 10, 18, 10);
INSERT INTO "TimeUnit" VALUES (29, 10, 18, 9);
INSERT INTO "TimeUnit" VALUES (31, 10, 18, 10);
INSERT INTO "TimeUnit" VALUES (32, 10, 18, 9);
INSERT INTO "TimeUnit" VALUES (34, 10, 18, 10);
INSERT INTO "TimeUnit" VALUES (35, 10, 18, 9);
INSERT INTO "TimeUnit" VALUES (37, 10, 18, 10);
INSERT INTO "TimeUnit" VALUES (38, 10, 18, 9);
INSERT INTO "TimeUnit" VALUES (40, 10, 18, 10);
INSERT INTO "TimeUnit" VALUES (41, 10, 18, 9);
INSERT INTO "TimeUnit" VALUES (43, 10, 18, 10);
INSERT INTO "TimeUnit" VALUES (44, 10, 18, 9);
INSERT INTO "TimeUnit" VALUES (46, 10, 18, 10);
INSERT INTO "TimeUnit" VALUES (47, 10, 18, 9);
INSERT INTO "TimeUnit" VALUES (49, 10, 18, 10);
INSERT INTO "TimeUnit" VALUES (50, 10, 18, 9);
INSERT INTO "TimeUnit" VALUES (4, 10, 5, 12);


--
-- TOC entry 2224 (class 0 OID 16494)
-- Dependencies: 199
-- Data for Name: ScheduleSlots; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO "ScheduleSlots" VALUES (57, 4, 3, 3, 3, 7);


--
-- TOC entry 2235 (class 0 OID 0)
-- Dependencies: 198
-- Name: ScheduleSlots_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('"ScheduleSlots_id_seq"', 104, true);


--
-- TOC entry 2217 (class 0 OID 16424)
-- Dependencies: 192
-- Data for Name: Students; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO "Students" VALUES (1, 'Petrov Ivan', NULL);
INSERT INTO "Students" VALUES (2, 'Tatiana Sopova', NULL);
INSERT INTO "Students" VALUES (3, 'Kiril Kabanov', NULL);
INSERT INTO "Students" VALUES (4, 'Natalia Nazarenko', NULL);
INSERT INTO "Students" VALUES (11, 'Andrej', 3);
INSERT INTO "Students" VALUES (5, 'Igor', 4);


--
-- TOC entry 2236 (class 0 OID 0)
-- Dependencies: 200
-- Name: TimeUnit_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('"TimeUnit_id_seq"', 51, true);


--
-- TOC entry 2219 (class 0 OID 16432)
-- Dependencies: 194
-- Data for Name: groups_courses; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO groups_courses VALUES (1, 1);
INSERT INTO groups_courses VALUES (1, 4);
INSERT INTO groups_courses VALUES (2, 4);
INSERT INTO groups_courses VALUES (3, 1);
INSERT INTO groups_courses VALUES (15, 36);
INSERT INTO groups_courses VALUES (15, 38);
INSERT INTO groups_courses VALUES (15, 39);
INSERT INTO groups_courses VALUES (15, 40);
INSERT INTO groups_courses VALUES (15, 138);


--
-- TOC entry 2220 (class 0 OID 16435)
-- Dependencies: 195
-- Data for Name: groups_students; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO groups_students VALUES (2, 2);
INSERT INTO groups_students VALUES (3, 1);
INSERT INTO groups_students VALUES (4, 2);
INSERT INTO groups_students VALUES (1, 1);


--
-- TOC entry 2221 (class 0 OID 16438)
-- Dependencies: 196
-- Data for Name: professors_courses; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO professors_courses VALUES (1, 1);
INSERT INTO professors_courses VALUES (3, 1);
INSERT INTO professors_courses VALUES (1, 8);
INSERT INTO professors_courses VALUES (18, 40);


--
-- TOC entry 2237 (class 0 OID 0)
-- Dependencies: 197
-- Name: professors_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('professors_id_seq', 88, true);


-- Completed on 2017-10-25 18:57:52

--
-- PostgreSQL database dump complete
--

