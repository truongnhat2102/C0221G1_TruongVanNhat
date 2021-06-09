package controller;

import model.bean.Contract;
import model.service.IContract;
import model.service.implContract.ContractImpl;
import model.bean.Customer;
import model.service.implCustomer.CustomerImpl;
import model.bean.Employee;
import model.service.implEmployee.EmployeeImpl;
import model.bean.Service;
import model.service.implService.ServiceImple;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ContractServlet", urlPatterns = "/contract")
public class ContractServlet extends HttpServlet {
    IContract iContract = new ContractImpl();
    List<Employee> employeeList = new EmployeeImpl().findByAll();
    List<Customer> customerList = new CustomerImpl().findByAll();
    List<Service> serviceList = new ServiceImple().findByAll();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action==null){
            action = "";
        }
        switch (action){
            case "add":
                add(request,response);
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action==null){
            action = "";
        }
        switch (action){
            case "add":
                showFormAdd(request,response);
                break;
        }
    }

    private void add(HttpServletRequest request, HttpServletResponse response) {
        int idEmployee = Integer.parseInt(request.getParameter("idEmployee"));
        int idCustomer = Integer.parseInt(request.getParameter("idCustomer"));
        int idService = Integer.parseInt(request.getParameter("idService"));
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        double deposit = Double.parseDouble(request.getParameter("deposit"));
        double total = Double.parseDouble(request.getParameter("total"));
        Employee employee = new EmployeeImpl().findById(idEmployee);
        Customer customer = new CustomerImpl().findById(idCustomer);
        Service service = new ServiceImple().findById(idService);
        Contract contract = new Contract(1, employee, customer, service, startDate, endDate, deposit, total);
        if (iContract.add(contract)){
            request.setAttribute("messages", "add completed");
            request.setAttribute("contract", contract);
        } else {
            request.setAttribute("messages", "cant add completed");
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/contract/add.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void showFormAdd(HttpServletRequest request, HttpServletResponse response){
        RequestDispatcher requestDispatcher;
        request.setAttribute("employeeList",employeeList);
        request.setAttribute("customerList",customerList);
        request.setAttribute("serviceList",serviceList);
        requestDispatcher = request.getRequestDispatcher("/view/contract/add.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
