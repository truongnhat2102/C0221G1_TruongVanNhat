package controller;

import model.bean.Product;
import model.bean.ProductCategory;
import model.repository.ProductRepository;
import model.service.IProduct;
import model.service.product_impl.ProductImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.function.Predicate;

@WebServlet(name = "ProductServlet", urlPatterns = "/product")
public class ProductServlet extends HttpServlet {
    IProduct iProduct = new ProductImpl();
    List<ProductCategory> productCategoryList = new ProductRepository().findAllCategory();

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
            default:
                showList(request, response);
                break;
        }
    }

    private void add(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String color = request.getParameter("color");
        String description = request.getParameter("description");
        int idCategory = Integer.parseInt(request.getParameter("idCategory"));
        ProductCategory productCategory = new ProductRepository().findCategoryById(idCategory);
        Product product = new Product(1, name, price, quantity, color, description, productCategory);
        String[] msgArr = iProduct.add(product);
        if (msgArr.length == 0) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/product/add.jsp");
            try {
                requestDispatcher.forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            request.setAttribute("msgName", msgArr[0]);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/product/add.jsp");
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
        int id  = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String color = request.getParameter("color");
        String description = request.getParameter("description");
        int idCategory = Integer.parseInt(request.getParameter("idCategory"));
        ProductCategory productCategory = new ProductRepository().findCategoryById(idCategory);
        Product product = new Product(id, name, price, quantity, color, description, productCategory);
        String[] msgArr = iProduct.edit(product);
        if (msgArr.length == 0) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/product/edit.jsp");
            try {
                requestDispatcher.forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            request.setAttribute("msgName", msgArr[0]);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/product/edit.jsp");
            try {
                requestDispatcher.forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        if(iProduct.delete(id)){
            request.setAttribute("messages", "delete completed");
        } else {
            request.setAttribute("messages", "cant delete completed");
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/product/list.jsp");
        request.setAttribute("productList",iProduct.findByAll());
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) {
        List<Product> productList = iProduct.findByAll();
        RequestDispatcher requestDispatcher;
        requestDispatcher = request.getRequestDispatcher("/view/product/list.jsp");
        request.setAttribute("productList", productList);
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
        Product product = iProduct.findById(id);
//        ProductCategory productCategory = new ProductRepository().findCategoryById(product.getProductCategory().getIdProductCategory());
        RequestDispatcher requestDispatcher;
        requestDispatcher = request.getRequestDispatcher("/view/product/edit.jsp");
        request.setAttribute("product", product);
//        request.setAttribute("typeCustomerMain", productCategory);
        request.setAttribute("productCategoryList",productCategoryList);
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
        requestDispatcher = request.getRequestDispatcher("/view/product/add.jsp");
        request.setAttribute("productCategoryList",productCategoryList);
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
