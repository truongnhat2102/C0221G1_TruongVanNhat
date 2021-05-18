use undergraduate;
-- Hiển thị tất cả các thông tin môn học (bảng subject) có credit lớn nhất.
select *, max(credit)
from subject
join student on subject.id_subject = student.id_student
join mark on mark.id_student = student.id_student
join class on class.id_class = student.id_class;

-- Hiển thị các thông tin môn học có điểm thi lớn nhất.
select *, max(mark)
from subject
join student on subject.id_subject = student.id_student
join mark on mark.id_student = student.id_student
join class on class.id_class = student.id_class;

-- Hiển thị các thông tin sinh viên và điểm trung bình của mỗi sinh viên, xếp hạng theo thứ tự điểm giảm dần
select student.*, avg(mark)
from student
join mark on mark.id_student = student.id_student
join class on class.id_class = student.id_class
join subject on subject.id_subject = mark.id_subject
group by id_student
order by avg(mark);
