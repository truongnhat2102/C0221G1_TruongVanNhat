package servlet;

import model.Customer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "CustomerServlet", urlPatterns = {""})
public class CustomerServlet extends HttpServlet {

    ArrayList<Customer> customers = new ArrayList<>();

    public void init() throws ServletException{
        customers.add(new Customer("Mai Van Hoang", "1983-08-20", "Ha Noi","" ));
        customers.add(new Customer("Mai Van Hoang", "1983-08-20", "Ha Noi","" ));
        customers.add(new Customer("Mai Van Hoang", "1983-08-20", "Ha Noi","" ));
        customers.add(new Customer("Mai Van Hoang", "1983-08-20", "Ha Noi","" ));
        customers.add(new Customer("Mai Van Hoang", "1983-08-20", "Ha Noi","" ));
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("customers", customers);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/display-customer.jsp");
        requestDispatcher.forward(request,response);
    }
}
