use undergraduate;

select * from Student where name_student like 'h%';
select * from Class where month(start_date)=12;
select * from Subject where credit>=3 and credit<=5;
SET SQL_SAFE_UPDATES = 0;
update Student
set  id_class=2
where name_student like '%hung%';
select name_student, name_subject, Mark
from Mark 
join Student 
on Mark.id_student=Student.id_student
join Subject
on Subject.id_subject=Mark.id_subject
order by Mark.Mark desc;