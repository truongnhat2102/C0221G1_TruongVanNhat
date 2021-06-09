package controller;

import model.bean.Contract;
import model.repository.ContractRepository;
import model.bean.ContractDetail;
import model.service.IContractDetail;
import model.service.implContractDetail.ContractDetailImpl;
import model.bean.ExtraService;
import model.repository.ExtraServiceRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ContractDetailServlet", urlPatterns = "/contract_detail")
public class ContractDetailServlet extends HttpServlet {
    IContractDetail iContractDetail = new ContractDetailImpl();
    List<Contract> contractList = new ContractRepository().findByAll();
    List<ExtraService> extraServices = new ExtraServiceRepository().findByAll();
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
        int idContract = Integer.parseInt(request.getParameter("idContract"));
        int idExtraService = Integer.parseInt(request.getParameter("idExtraService"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        Contract contract = null;
        ExtraService extraService = null;
        contract = new ContractRepository().findById(idContract);
        extraService = new ExtraServiceRepository().findById(idExtraService);
        ContractDetail contractDetail = new ContractDetail(1, contract, extraService, quantity);
        if (iContractDetail.add(contractDetail)){
            request.setAttribute("messages", "add completed");
            request.setAttribute("contract", contract);
        } else {
            request.setAttribute("messages", "cant add completed");
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/contract_detail/add.jsp");
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
        request.setAttribute("contractList",contractList);
        request.setAttribute("extraServices",extraServices);
        requestDispatcher = request.getRequestDispatcher("/view/contract_detail/add.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
