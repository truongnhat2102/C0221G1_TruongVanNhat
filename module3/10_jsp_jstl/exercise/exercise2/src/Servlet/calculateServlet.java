package Servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "calculateServlet", urlPatterns = {"firstOperand","secondOperand","operator"})
public class calculateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double operand1 = Double.parseDouble(request.getParameter("firstOperand"));
        String operator = request.getParameter("operator");
        double operand2 = Double.parseDouble(request.getParameter("secondOperand"));
        double result = 0.0;
        switch (operator){
            case "additional":
                result = operand1 + operand2;
                break;
            case "sub":
                result = operand1 - operand2;
                break;
            case "multi":
                result = operand1 * operand2;
                break;
            case "dublicate":
                result = operand1 / operand2;
                break;
        }
        request.setAttribute("result",result);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/result.jsp");
        requestDispatcher.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
