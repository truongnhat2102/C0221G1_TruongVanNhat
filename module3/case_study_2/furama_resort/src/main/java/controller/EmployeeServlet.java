package controller;

import model.bean.Division;
import model.bean.EducationDegree;
import model.bean.Employee;
import model.bean.Position;
import model.repository.EmployeeRepository;
import model.service.IEmployee;
import model.service.implEmployee.EmployeeImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "EmployeeServlet", urlPatterns = "/employee")
public class EmployeeServlet extends HttpServlet {
    IEmployee iEmployee = new EmployeeImpl();
    List<Position> positionList = new EmployeeRepository().findAllPosition();
    List<EducationDegree> educationDegreeList = new EmployeeRepository().findAllEducation();
    List<Division> divisionList = new EmployeeRepository().findAllDivision();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                add(request, response);
                break;
            case "edit":
                edit(request, response);
                break;
            case "delete":
                delete(request, response);
                break;
//            case "detail":
//                detail(request, response);
//                break;
//            case "find":
//                showFind(request, response);
//                break;
            default:
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                showFormAdd(request, response);
                break;
            case "edit":
                showFormEdit(request, response);
                break;
//            case "delete":
//                showFormDelete(request, response);
//                break;
            case "detail":
                show(request, response);
                break;
            default:
                showList(request, response);
                break;
        }
    }

    private void add(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        int idPosition = Integer.parseInt(request.getParameter("position"));
        Position position = new EmployeeRepository().findIdPosition(idPosition);
        int idEducation = Integer.parseInt(request.getParameter("education"));
        EducationDegree educationDegree = new EmployeeRepository().findIdEducation(idEducation);
        int idPart = Integer.parseInt(request.getParameter("division"));
        Division division = new EmployeeRepository().findIdDivision(idPart);
        String birthday = request.getParameter("birthday");
        String idCard = request.getParameter("idCard");
        String salary = request.getParameter("salary");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String username = request.getParameter("username");
        Employee employee = new Employee(1, name,  birthday, idCard, salary, phone, email, address, position, educationDegree, division, username);
        if(iEmployee.add(employee)){
            request.setAttribute("messages", "add completed");
            request.setAttribute("employee", employee);
        } else {
            request.setAttribute("messages", "cant add completed");
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/employee/add.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void edit(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int idPosition = Integer.parseInt(request.getParameter("position"));
        Position position = new EmployeeRepository().findIdPosition(idPosition);
        int idEducation = Integer.parseInt(request.getParameter("education"));
        EducationDegree educationDegree = new EmployeeRepository().findIdEducation(idEducation);
        int idPart = Integer.parseInt(request.getParameter("division"));
        Division division = new EmployeeRepository().findIdDivision(idPart);
        String birthday = request.getParameter("birthday");
        String idCard = request.getParameter("idCard");
        String salary = request.getParameter("salary");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String username = request.getParameter("username");
        Employee employee = new Employee(1, name,  birthday, idCard, salary, phone, email, address, position, educationDegree, division, username);
        if(iEmployee.edit(employee)){
            request.setAttribute("messages", "edit completed");
            request.setAttribute("employee", employee);
        } else {
            request.setAttribute("messages", "cant edit completed");
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/employee/edit.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        iEmployee.remove(id);
        try {
            response.sendRedirect("/employee");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void show(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Employee employee = iEmployee.findById(id);
        RequestDispatcher requestDispatcher;
        requestDispatcher = request.getRequestDispatcher("/view/employee/detail_employee.jsp");
        request.setAttribute("employee", employee);
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void showList(HttpServletRequest request, HttpServletResponse response) {
        List<Employee> employees = iEmployee.findByAll();
        RequestDispatcher requestDispatcher;
        requestDispatcher = request.getRequestDispatcher("/view/employee/list.jsp");
        request.setAttribute("employees", employees);
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showFormEdit(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Employee employee = iEmployee.findById(id);
        RequestDispatcher requestDispatcher;
        requestDispatcher = request.getRequestDispatcher("/view/employee/edit.jsp");
        request.setAttribute("employee", employee);
        request.setAttribute("positionList",positionList);
        request.setAttribute("divisionList",divisionList);
        request.setAttribute("educationList",educationDegreeList);
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showFormAdd(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher;
        requestDispatcher = request.getRequestDispatcher("/view/employee/add.jsp");
        request.setAttribute("positionList",positionList);
        request.setAttribute("divisionList",divisionList);
        request.setAttribute("educationList",educationDegreeList);
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
