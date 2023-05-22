package com.jbeans.loans.controller;

import com.jbeans.loans.model.Customer;
import com.jbeans.loans.model.Loans;
import com.jbeans.loans.repository.LoansRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoansController {

    @Autowired
    private LoansRepository loansRepository;

    @PostMapping("/myLoan")
    public List<Loans> getLoandetails(@RequestBody Customer customer){
        List<Loans> loanList=loansRepository.findByCustomerIdOrderByStartDtDesc(customer.getCustomerId());
        if(!loanList.isEmpty()){
            return loanList;
        }
        else{
            return  null;
        }
    }
}
