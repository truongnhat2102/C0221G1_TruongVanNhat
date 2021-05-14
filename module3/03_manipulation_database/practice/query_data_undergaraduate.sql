use undergraduate;
SELECT *
FROM Student;
SELECT *
FROM Student
WHERE sta_tus = true;
SELECT *
FROM Subject
WHERE credit < 10;
SELECT Student.id_student, Student.name_student, Class.name_class
FROM Student join Class on Student.id_class = Class.id_class;
SELECT Student.id_student, Student.name_stdent, name_class
FROM Student join Class on id_class =id_class
WHERE name_class = 'A1';
SELECT Student.id_student, Student.name_student, Subject.name_subject, Mark.Mark
FROM Student join Mark on Student.id_student = Mark.StudentId join Subject Sub on Mark.id_subject = Subject.id_subject;
SELECT Student.id_student, Student.name_student, Subject.name_subject, Mark.Mark
FROM Student join Mark on Student.id_student = Mark.StudentId join Subject Sub on Mark.id_subject = Subject.id_subject
WHERE Sub.name_subject = 'CF';