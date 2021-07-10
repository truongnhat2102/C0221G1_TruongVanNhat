package com.furama_resort.controller;

import com.furama_resort.model.entity.contract_detail.ContractDetail;
import com.furama_resort.model.service.IContract;
import com.furama_resort.model.service.IContractDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping({"/", "/contract-detail"})
@SessionAttributes("employee")
public class ContractDetailController {
    @Autowired
    IContractDetail iContractDetail;
    @Autowired
    IContract iContract;

    //add
    @GetMapping("/add-contract-detail")
    public String showFormAddContractDetail(Model model){
        model.addAttribute("contractDetail", new ContractDetail());
        model.addAttribute("contractList", iContract.findAllContract());
        model.addAttribute("attachServiceList", iContractDetail.findAllAttachService());
        return "/contract_detail/add_contract_detail";
    }

    @PostMapping("/add-contract-detail")
    public String addContractDetail(@ModelAttribute("contractDetail") ContractDetail contractDetail){
        iContractDetail.saveContractDetail(contractDetail);
        return "/contract_detail/add_contract_detail";
    }
}
