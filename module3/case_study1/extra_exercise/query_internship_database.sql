-- question1
-- task1
select instructor.instructor_id, instructor_name, faculty_name
from instructor
join faculty on faculty.faculty_id = instructor.faculty_id;

-- task2
select instructor.instructor_id, instructor_name, faculty_name
from instructor
join faculty on faculty.faculty_id = instructor.faculty_id
where faculty_name = 'dialy va qltn';

-- task3
select count(student.student_id) as amount_student
from student
join faculty on faculty.faculty_id = student.faculty_id
where faculty_name = 'cong nghe sinh hoc'
group by student_id;

-- task4
select student.student_id, student_name, (year(now()) - year(date_of_birth)) as student_age
from student
join faculty on faculty.faculty_id = student.faculty_id
where faculty_name = 'toan';

-- task5
select count(instructor.instructor_id) as amount_instructor
from instructor
join faculty on faculty.faculty_id = instructor.faculty_id
where faculty_name = 'cong nghe sinh hoc'
group by instructor_id;

-- task6
select student.* 
from student
where student_id not in (
select instructor.student_id
from instructor);

-- task7
select faculty.*, count(instructor.instructor_id) as amount_instructor
from faculty
join instructor on faculty.faculty_id = instructor.faculty_id
group by instructor_id;

-- task8
select faculty.phone
from faculty
join student on faculty.faculty_id = student.faculty.faculty_id
where student_name = 'le van son';

-- question2
-- task1
select project.project_id, project_name
from project
join instructor_student on project.project_id = instructor_student.project_id
join instructor on instructor_student.instructor_id = instructor.instructor_id
where instructor_name = 'tran son';

-- task2
select project.project_name
from project
where project_id not in (
select instructor_student.project_id
from instructor_student
join student on student.student_id = instructor_student.student_id );

-- task3
select instructor.instructor_id, instructor_name, faculty_name, count(instructor_student.student_id) as amount_student
from instructor
join faculty on faculty.faculty_id = instructor.faculty_id
join instructor_student on instructor_student.instructor_id = instructor.instructor_id
group by instructor.instructor_id
having amount_student >= 3;

-- task4
select project.project_id, project_name, max(project.expense)
from project;

-- task5
select project.project_id, project_name
from project
join instructor_student on project.project_id = instructor_student.project_id
join student on student.student_id = instructor_student.student_id
group by instructor_student.student_id
having count(instructor_student.student_id)  >=2;

-- task6

