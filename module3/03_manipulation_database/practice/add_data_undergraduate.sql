use undergraduate;
INSERT INTO Class (name_class, start_date, sta_tus)
VALUES ('A1', '2008-12-20', 1),
('A2', '2008-12-22', 1),
('B3', current_date, 0);
INSERT INTO Student (name_student, address, phone, sta_tus, id_class)
VALUES ('Hung', 'Ha Noi', '0912113113', 1, 1),
('Hoa', 'Hai phong', '0912113113', 1, 1),
('Manh', 'HCM', '0123123123', 0, 2);
INSERT INTO Subject
VALUES (1, 'CF', 5, 1),
       (2, 'C', 6, 1),
       (3, 'HDJ', 5, 1),
       (4, 'RDBMS', 10, 1);
INSERT INTO Mark (id_subject, id_student, mark, exam_time)
VALUES (1, 1, 8, 1),
       (1, 2, 10, 2),
       (2, 1, 12, 1);