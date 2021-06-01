package controller;

import model.bean.User;
import model.service.IUser;
import model.service.impl.UserImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "UserServlet", urlPatterns = {"", "/user"} )
public class UserServlet extends HttpServlet {
    IUser iUser = new UserImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String action = request.getParameter("action");
//        if (action==null){
//            action="";
//        }
//        switch (action){
//            case "add":
//                add(request,response);
//                break;
//            case "edit":
//                edit(request,response);
//                break;
//            case "delete":
//                delete(request,response);
//                break;
//            default:
//                break;
//        }
    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action==null){
            action="";
        }
        switch (action){
//            case "add":
//                showFormAdd(request,response);
//                break;
//            case "edit":
//                showFormEdit(request,response);
//                break;
//            case "delete":
//                showFormDelete(request,response);
//                break;
//            case "searchByCountry":
//                searchByCountry(request,response);
//                break;
//            case "sortByName":
//                sortByName(request,response);
//                break;
            case "permision":
                addUserPermision(request, response);
                break;
            default:
                showList(request,response);
                break;
        }
    }

//    private void sortByName(HttpServletRequest request, HttpServletResponse response) {
//        RequestDispatcher requestDispatcher;
//        List<User> users = iUser.sortByName();
//        requestDispatcher = request.getRequestDispatcher("/view/user/sort_by_name.jsp");
//        request.setAttribute("users", users);
//        try {
//            requestDispatcher.forward(request, response);
//        } catch (ServletException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private void searchByCountry(HttpServletRequest request, HttpServletResponse response) {
//        String find = request.getParameter("searchByCountry");
//        RequestDispatcher requestDispatcher;
//        List<User> users = iUser.searchByCountry(find);
//        requestDispatcher = request.getRequestDispatcher("/view/user/search_by_country.jsp");
//        request.setAttribute("users", users);
//        try {
//            requestDispatcher.forward(request, response);
//        } catch (ServletException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
    private void showList(HttpServletRequest request, HttpServletResponse response) {
        List<User> users = iUser.findByAll();
        RequestDispatcher requestDispatcher;
        requestDispatcher = request.getRequestDispatcher("/view/user/list.jsp");
        request.setAttribute("users", users);
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//
//    private void showFormDelete(HttpServletRequest request, HttpServletResponse response) {
//        int id = Integer.parseInt(request.getParameter("id"));
//        User user = iUser.findById(id);
//        RequestDispatcher requestDispatcher;
//        requestDispatcher = request.getRequestDispatcher("/view/user/delete.jsp");
//        request.setAttribute("user", user);
//        try {
//            requestDispatcher.forward(request, response);
//        } catch (ServletException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private void showFormEdit(HttpServletRequest request, HttpServletResponse response) {
//        int id = Integer.parseInt(request.getParameter("id"));
////        User user = iUser.findById(id);
//        User existingUser = iUser.getUserById(id);
//        RequestDispatcher requestDispatcher;
//        requestDispatcher = request.getRequestDispatcher("/view/user/edit.jsp");
////        request.setAttribute("user", user);
//        request.setAttribute("user", existingUser);
//        try {
//            requestDispatcher.forward(request, response);
//        } catch (ServletException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private void showFormAdd(HttpServletRequest request, HttpServletResponse response) {
//
//        User user = new User();
//        RequestDispatcher requestDispatcher;
//        requestDispatcher = request.getRequestDispatcher("/view/user/add.jsp");
//        request.setAttribute("user", user);
//        try {
//            requestDispatcher.forward(request, response);
//        } catch (ServletException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

//    private void add(HttpServletRequest request, HttpServletResponse response) {
//
//        String name = request.getParameter("name");
//        String email = request.getParameter("email");
//        String country = request.getParameter("country");
//        User user = new User(name, email, country);
////        iUser.add(user);
//        try {
//            iUser.insertUserStore(user);
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        request.setAttribute("messages", "add completed");
//        request.setAttribute("user", user);
//        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/user/add.jsp");
//        try {
//            requestDispatcher.forward(request, response);
//        } catch (ServletException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private void edit(HttpServletRequest request, HttpServletResponse response) {
//        int id = Integer.parseInt(request.getParameter("id"));
//        String name = request.getParameter("name");
//        String email = request.getParameter("email");
//        String country = request.getParameter("country");
//        User user = new User(name, email, country);
//        iUser.edit(id, user);
//        request.setAttribute("messages", "edit completed");
//        request.setAttribute("user", user);
//        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/user/edit.jsp");
//        try {
//            requestDispatcher.forward(request, response);
//        } catch (ServletException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private void delete(HttpServletRequest request, HttpServletResponse response) {
//        int id = Integer.parseInt(request.getParameter("id"));
//        String name = request.getParameter("name");
//        String email = request.getParameter("email");
//        String country = request.getParameter("country");
//        User user = new User( name, email, country);
//        iUser.delete(id);
//        request.setAttribute("messages", "edit completed");
//        request.setAttribute("user", user);
//        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/user/delete.jsp");
//        try {
//            requestDispatcher.forward(request, response);
//        } catch (ServletException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    private void addUserPermision(HttpServletRequest request, HttpServletResponse response) {

        User user = new User("quan", "quan.nguyen@codegym.vn", "vn");

        int[] permision = {1, 2, 4};

        iUser.addUserTransaction(user, permision);

    }
}
