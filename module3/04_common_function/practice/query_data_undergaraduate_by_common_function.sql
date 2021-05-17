use undergraduate;
-- Sử dụng hàm count để hiển thị số lượng sinh viên ở từng nơi
select address, count(student.address) as amount_student
from student
group by address;

-- Tính điểm trung bình các môn học của mỗi học viên bằng cách sử dụng hàm AVG
select student.id_student, student.name_student, avg(mark.mark)
from student
join Mark on student.id_student = Mark.id_student
group by student.name_student;

-- Hiển thị những bạn học viên co điểm trung bình các môn học lớn hơn 15
SELECT S.id_student,S.name_student, avg(mark) 
FROM student S 
join Mark M on S.id_student = M.id_student
GROUP BY S.id_student
HAVING AVG(Mark) > 15;

--  Hiển thị thông tin các học viên có điểm trung bình lớn nhất.
SELECT S.id_student, S.name_student, AVG(Mark)
FROM Student S join Mark M on S.id_student = M.id_student
GROUP BY S.id_student, S.name_student
HAVING AVG(Mark) >= ALL (
SELECT AVG(Mark) 
FROM Mark 
GROUP BY Mark.id_student);
