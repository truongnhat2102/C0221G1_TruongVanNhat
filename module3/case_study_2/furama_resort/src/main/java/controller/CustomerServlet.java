package controller;

import model.bean.Customer;
import model.bean.TypeCustomer;
import model.repository.CustomerRepository;
import model.service.ICustomer;
import model.service.implCustomer.CustomerImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@javax.servlet.annotation.WebServlet(name = "CustomerServlet", urlPatterns = "/customer")
public class CustomerServlet extends javax.servlet.http.HttpServlet {
    ICustomer iCustomer = new CustomerImpl();
    List<TypeCustomer> typeCustomerList = new CustomerRepository().findAllTypeCustomer();
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
                showDetail(request, response);
                break;
//            case "find":
//                showFindByName(request, response);
//                break;
//            case "activeCustomers":
//                showListActive(request,response);
//                break;
            default:
                showList(request, response);
                break;
        }
    }

    private void add(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        request.setAttribute("typeCustomerList",typeCustomerList);
        int idType = Integer.parseInt(request.getParameter("idType"));
        TypeCustomer typeCustomer = new CustomerRepository().findByIdTypeCustomer(idType);
        String dateOfbirth = request.getParameter("dateOfBirth");
        String gender = request.getParameter("gender");
        String idCard = request.getParameter("idCard");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Customer customer = new Customer(1, name, typeCustomer , dateOfbirth, gender, phone, idCard, email, address);
        String[] msgArr = iCustomer.add(customer);
        if (msgArr.length == 0){
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/customer/add.jsp");
            try {
                requestDispatcher.forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            request.setAttribute("msgName", msgArr[0]);
            request.setAttribute("msgDateOfBirth", msgArr[1]);
            request.setAttribute("msgIdCard", msgArr[2]);
            request.setAttribute("msgEmail", msgArr[3]);
            request.setAttribute("msgPhone", msgArr[4]);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/customer/add.jsp");
            try {
                requestDispatcher.forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private void edit(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        request.setAttribute("typeCustomerList",typeCustomerList);
        int idType = Integer.parseInt(request.getParameter("idType"));
        TypeCustomer typeCustomer = new CustomerRepository().findByIdTypeCustomer(idType);
        String dateOfbirth = request.getParameter("dateOfBirth");
        String gender = request.getParameter("gender");
        String idCard = request.getParameter("idCard");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Customer customer = new Customer(1, name, typeCustomer , dateOfbirth, gender, phone, idCard, email, address);
        if (iCustomer.edit(customer)) {
            request.setAttribute("messages", "edit completed");
            request.setAttribute("customer", customer);

        } else {
            request.setAttribute("messages", "cant edit completed");
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/customer/edit.jsp");
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
        if(iCustomer.remove(id)){
            request.setAttribute("messages", "delete completed");
        } else {
            request.setAttribute("messages", "cant delete completed");
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/customer/list.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showDetail(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = iCustomer.findById(id);
        TypeCustomer typeCustomer = new CustomerRepository().findByIdTypeCustomer(id);
        RequestDispatcher requestDispatcher;
        requestDispatcher = request.getRequestDispatcher("/view/customer/detail_customer.jsp");
        request.setAttribute("customer", customer);
        request.setAttribute("typeCustomer", typeCustomer);
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) {
        List<Customer> customers = iCustomer.findByAll();
        RequestDispatcher requestDispatcher;
        requestDispatcher = request.getRequestDispatcher("/view/customer/list.jsp");
        request.setAttribute("customers", customers);
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
        Customer customer = iCustomer.findById(id);
        TypeCustomer typeCustomer = new CustomerRepository().findByIdTypeCustomer(id);
        RequestDispatcher requestDispatcher;
        requestDispatcher = request.getRequestDispatcher("/view/customer/edit.jsp");
        request.setAttribute("customer", customer);
        request.setAttribute("typeCustomerMain", typeCustomer);
        request.setAttribute("typeCustomerList",typeCustomerList);
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
        requestDispatcher = request.getRequestDispatcher("/view/customer/add.jsp");
        request.setAttribute("typeCustomerList",typeCustomerList);
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//    private void showListActive(HttpServletRequest request, HttpServletResponse response) {
//        List<Customer> customers = iAc.findCustomerActive();
//        RequestDispatcher requestDispatcher;
//        requestDispatcher = request.getRequestDispatcher("/view/customer/list_active.jsp");
//        request.setAttribute("customers", customers);
//        try {
//            requestDispatcher.forward(request, response);
//        } catch (ServletException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
