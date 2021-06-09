package controller;

import model.bean.*;
import model.repository.ActiveCustomerRepository;
import model.repository.ContractRepository;
import model.repository.ExtraServiceRepository;
import model.repository.ServiceRepository;
import model.service.IActiveCustomer;
import model.service.IContract;
import model.service.ICustomer;
import model.service.implActiceCustomer.ActiveCustomerImpl;
import model.service.implContract.ContractImpl;
import model.service.implCustomer.CustomerImpl;
import model.service.implEmployee.EmployeeImpl;
import model.service.implService.ServiceImple;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerActiveServlet", urlPatterns = "/list_active")
public class CustomerActiveServlet extends HttpServlet {
    ICustomer iCustomer = new CustomerImpl();
    IActiveCustomer iActiveCustomer = new ActiveCustomerImpl();
    IContract iContract = new ContractImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "editService":
                editService(request, response);
                break;
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
            case "editService":
                showFormEditService(request,response);
                break;
            default:
                showListActive(request,response);
                break;
        }
    }

    public void showListActive(HttpServletRequest request, HttpServletResponse response) {
        List<Customer> customers = iActiveCustomer.findCustomerActive();
//        int id = request.getParameter("")
//        List<ExtraService> extraServices = new ExtraServiceRepository().findByIdCustomer(id);
        RequestDispatcher requestDispatcher;
        requestDispatcher = request.getRequestDispatcher("/view/customer_active/list_active.jsp");
        request.setAttribute("customers", customers);
//        request.setAttribute("extraServices", extraServices);
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showFormEditService(HttpServletRequest request, HttpServletResponse response){
        List<Service> serviceList = new ServiceRepository().findByAll();
        int id = Integer.parseInt(request.getParameter("id"));
        Contract contract = new ContractRepository().findById(id);
        RequestDispatcher requestDispatcher;
        requestDispatcher = request.getRequestDispatcher("/view/customer_active/edit_service_in_contract.jsp");
        request.setAttribute("serviceList",serviceList);
        request.setAttribute("contract",contract);
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void editService(HttpServletRequest request, HttpServletResponse response) {
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
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/customer_active/edit_service_in_contract.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
