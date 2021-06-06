package service.controller;

import service.model.bean.Service;
import service.model.service.IService;
import service.model.service.impl.ServiceImple;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServiceServlet", urlPatterns = "/service")
public class ServiceServlet extends HttpServlet {
    IService iService = new ServiceImple();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "addRoom":
                addRoom(request, response);
                break;
            case "addVilla":
                addVilla(request, response);
                break;
            case "addHouse":
                addHouse(request, response);
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
            case "addRoom":
                showFormAddRoom(request, response);
                break;
            case "addVilla":
                showFormAddVilla(request, response);
                break;
            case "addHouse":
                showFormAddHouse(request, response);
                break;
            default:
                showList(request, response);
                break;
        }
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) {

    }

    private void showFormAddHouse(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher;
        request.setAttribute("idTypeService",2);
        request.setAttribute("nameTypeService","House");
        requestDispatcher = request.getRequestDispatcher("/view/service/add_house.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showFormAddVilla(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher;
        String name = "villa";
        request.setAttribute("idTypeService",1);
        request.setAttribute("nameTypeService",name);
        requestDispatcher = request.getRequestDispatcher("/view/service/add_villa.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showFormAddRoom(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher;
        request.setAttribute("idTypeService",3);
        request.setAttribute("nameTypeService","Room");
        requestDispatcher = request.getRequestDispatcher("/view/service/add_room.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addHouse(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        int area = Integer.parseInt(request.getParameter("area"));
        double cost = Double.parseDouble(request.getParameter("cost"));
        int maxPeople = Integer.parseInt(request.getParameter("maxPeople"));
        request.setAttribute("idTypeService",2);
        request.setAttribute("nameTypeService","House");
        int idTypeRent = Integer.parseInt(request.getParameter("idTypeRent"));
        String standardRoom = request.getParameter("standardRoom");
        String description = request.getParameter("description");
        double poolArea = Double.parseDouble(request.getParameter("poolArea"));
        int floor = Integer.parseInt(request.getParameter("floor"));
        Service service = new Service(1, name, area, cost, maxPeople, 2, "House", idTypeRent, "", standardRoom, description, poolArea, floor);
        if (iService.add(service)) {
            request.setAttribute("message","add completed");
            request.setAttribute("service",service);
        } else {
            request.setAttribute("message","add not completed");
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/service");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addVilla(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        int area = Integer.parseInt(request.getParameter("area"));
        double cost = Double.parseDouble(request.getParameter("cost"));
        int maxPeople = Integer.parseInt(request.getParameter("maxPeople"));
        request.setAttribute("idTypeService",1);
        request.setAttribute("nameTypeService","Villa");
        int idTypeRent = Integer.parseInt(request.getParameter("idTypeRent"));
        String standardRoom = request.getParameter("standardRoom");
        String description = request.getParameter("description");
        double poolArea = Double.parseDouble(request.getParameter("poolArea"));
        int floor = Integer.parseInt(request.getParameter("floor"));
        Service service = new Service(1, name, area, cost, maxPeople, 1, "Villa", idTypeRent, "", standardRoom, description, poolArea, floor);
        if (iService.add(service)) {
            request.setAttribute("message","add completed");
            request.setAttribute("service",service);
        } else {
            request.setAttribute("message","add not completed");
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/service");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addRoom(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        int area = Integer.parseInt(request.getParameter("area"));
        double cost = Double.parseDouble(request.getParameter("cost"));
        int maxPeople = Integer.parseInt(request.getParameter("maxPeople"));
        request.setAttribute("idTypeService",3);
        request.setAttribute("nameTypeService","Room");
        int idTypeRent = Integer.parseInt(request.getParameter("idTypeRent"));
        String standardRoom = request.getParameter("standardRoom");
        String description = request.getParameter("description");
        double poolArea = Double.parseDouble(request.getParameter("poolArea"));
        int floor = Integer.parseInt(request.getParameter("floor"));
        Service service = new Service(1, name, area, cost, maxPeople, 3, "Room", idTypeRent, "", standardRoom, description, poolArea, floor);
        if (iService.add(service)) {
            request.setAttribute("message","add completed");
            request.setAttribute("service",service);
        } else {
            request.setAttribute("message","add not completed");
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/service");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
