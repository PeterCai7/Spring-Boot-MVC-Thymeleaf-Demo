package com.pax.uptrillion.handler.controller;

import com.pax.uptrillion.handler.entity.PHICAccount;
import com.pax.uptrillion.handler.service.PhicAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@Controller
@RequestMapping("/phic-accounts")
public class PhicController {
    private List<PHICAccount> thePhicAccounts;
    //inject customer service
    @Autowired
    private PhicAccountService phicAccountService;

    //loadData after Construct method
    @PostConstruct
    private void loadData() {
        //do service work
        thePhicAccounts = phicAccountService.getPhicAccounts();
    }

    //list out all the PHIC in the data storage repo
    @GetMapping("/list")
    public String listPhicAccounts(Model theModel) {
        //add them to the model layver of MVC
        theModel.addAttribute("phicAccounts", thePhicAccounts);

        //then return to view template, Thymeleaf
        return "list-phic-accounts";
    }

    //show Form for users to add a new PHIC
    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {
        PHICAccount newPHICAccount = new PHICAccount();

        theModel.addAttribute("newPHICAccount", newPHICAccount);

        return "phic-form";
    }

    //save a new PHIC into pesistence layer
    @PostMapping("/save")
    public String savePHICAccount(@ModelAttribute("newPHICAccount") PHICAccount newPHICAccount) {

        //save the PHIC into our persistence layer
        phicAccountService.savePhicAccount(newPHICAccount);
        //use a redirect to prevent duplicate submissions
        return "redirect:/phic-accounts/list";
    }

    //delete a existing PHIC Todo Modify to use DeleteMapping
    @GetMapping("/delete")
    public String delete(@RequestParam("username") String username,
                         @RequestParam("password") String password,
                         @RequestParam("serialNum") String serialNum){
        //delete it
        phicAccountService.deletePhicAccount(username, password, serialNum);

        return "redirect:/phic-accounts/list";
    }
}
