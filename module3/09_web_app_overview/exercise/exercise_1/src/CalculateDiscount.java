import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="CalculateDiscount", urlPatterns="/display-discount")
public class CalculateDiscount extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String productDes = req.getParameter("productDes");
        Double price = Double.parseDouble(req.getParameter("price"));
        Double percent = Double.parseDouble(req.getParameter("percent"));
        Double discountAmount = price*percent*0.01;
        Double discountPrice = price - discountAmount;

        req.setAttribute("productDes",productDes);
        req.setAttribute("discountAmount",discountAmount);
        req.setAttribute("discountPrice",discountPrice);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/display-discount.jsp");
        dispatcher.forward(req,resp);
    }
}
