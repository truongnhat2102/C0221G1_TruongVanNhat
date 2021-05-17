use undergraduate;
-- Hiển thị tất cả các thông tin môn học (bảng subject) có credit lớn nhất.
select *, max(credit)
from subject;

-- Hiển thị các thông tin môn học có điểm thi lớn nhất.
select subject.name_subject, max(mark)
from subject
join mark on mark.id_subject = subject.id_subject;

-- Hiển thị các thông tin sinh viên và điểm trung bình của mỗi sinh viên, xếp hạng theo thứ tự điểm giảm dần
select student.*, avg(mark)
from student
join mark on mark.id_student = mark.id_student
join class on class.id_class = student.id_class
join subject on subject.id_subject = mark.id_subject
group by id_student
order by avg(mark);
