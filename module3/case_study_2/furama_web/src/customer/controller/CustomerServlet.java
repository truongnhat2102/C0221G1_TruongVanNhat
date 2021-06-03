package customer.controller;

import customer.model.bean.Customer;
import customer.model.service.ICustomer;
import customer.model.service.impl.CustomerImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = {"/customer"})
public class CustomerServlet extends HttpServlet {
    ICustomer iCustomer = new CustomerImpl();
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
            case "delete":
                showFormDelete(request, response);
                break;
            case "detail":
                showDetail(request, response);
                break;
            case "find":
                showFindByName(request, response);
                break;
            default:
                showList(request, response);
                break;
        }
    }

//    private void detail(HttpServletRequest request, HttpServletResponse response) {
//        int id = Integer.parseInt(request.getParameter("id"));
//        String name = request.getParameter("name");
//        String type = request.getParameter("type");
//        String dateOfbirth = request.getParameter("dateOfBirth");
//        String gender = request.getParameter("gender");
//        String idCard = request.getParameter("idCard");
//        String phone = request.getParameter("phone");
//        String email = request.getParameter("email");
//        String address = request.getParameter("address");
//        Customer customer = new Customer(id, name, type, dateOfbirth, gender, idCard, phone, email, address);
//        request.setAttribute("messages", "edit completed");
//        request.setAttribute("customer", customer);
//        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/customer/detail_customer.jsp");
//        try {
//            requestDispatcher.forward(request, response);
//        } catch (ServletException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    private void add(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        int idType = Integer.parseInt(request.getParameter("idType"));
        String dateOfbirth = request.getParameter("dateOfBirth");
        String gender = request.getParameter("gender");
        String idCard = request.getParameter("idCard");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Customer customer = new Customer(name, idType, dateOfbirth, gender, phone, idCard, email, address);
        if (iCustomer.add(customer)){
            request.setAttribute("messages", "add completed");
            request.setAttribute("customer", customer);

        } else {
            request.setAttribute("messages", "cant add completed");
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/customer/add.jsp");
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
        int idType = Integer.parseInt(request.getParameter("idType"));
        String dateOfbirth = request.getParameter("dateOfBirth");
        String gender = request.getParameter("gender");
        String idCard = request.getParameter("idCard");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Customer customer = new Customer(id, name, idType, dateOfbirth, gender, phone, idCard, email, address);
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



    private void showFindByName(HttpServletRequest request, HttpServletResponse response) {
        String find = request.getParameter("search");
        List<Customer> findCustomer = iCustomer.findByName(find);
        RequestDispatcher requestDispatcher = null;
        if (findCustomer.size() == 0) {
            requestDispatcher = request.getRequestDispatcher("/error.jsp");
        } else {
            request.setAttribute("customers", findCustomer);
            requestDispatcher = request.getRequestDispatcher("/view/customer/find_customer.jsp");
        }
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
        RequestDispatcher requestDispatcher;
        requestDispatcher = request.getRequestDispatcher("/view/customer/detail_customer.jsp");
        request.setAttribute("customer", customer);
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showFormDelete(HttpServletRequest request, HttpServletResponse response) {

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
        RequestDispatcher requestDispatcher;
        requestDispatcher = request.getRequestDispatcher("/view/customer/edit.jsp");
        request.setAttribute("customer", customer);
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
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
