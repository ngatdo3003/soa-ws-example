package com.ngatdo.soapws.controller;

import com.ngatdo.soapws.model.Operator;
import com.ngatdo.soapws.utils.GetSumRequest;
import com.ngatdo.soapws.utils.GetSumResponse;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ws.client.core.WebServiceTemplate;

@Controller
public class CaculatorController {
    @RequestMapping(value = { "/sum" }, method = RequestMethod.GET)
    public String sum(Model model) {
        // init object to store input from user
        Operator operator = new Operator();
        model.addAttribute("operator", operator);
        return "index";
    }

    @RequestMapping(value = { "/sum" }, method = RequestMethod.POST)
    public String getSum(Model model, @ModelAttribute("operator") Operator operator) {
        //get parameters from model
        int num1 = operator.getNumber1();
        int num2 = operator.getNumber2();
        int num3 = operator.getNumber3();

        // prepare for soap request
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setPackagesToScan(ClassUtils.getPackageName(GetSumRequest.class));
        WebServiceTemplate ws = new WebServiceTemplate(marshaller);
        GetSumRequest request = new GetSumRequest();

        // call soap ws to get sum of num1 and num2
        request.setFirstNumber(num1);
        request.setSecondNumber(num2);
        GetSumResponse response = (GetSumResponse) ws.marshalSendAndReceive("http://localhost:8080/ws", request);
        int sum = response.getResult();

        //call soap ws to get sum of (num1+num2) and num3
        request.setFirstNumber(sum);
        request.setSecondNumber(num3);
        response = (GetSumResponse) ws.marshalSendAndReceive("http://localhost:8080/ws", request);

        //get sum and send to model
        sum = response.getResult();
        operator.setResult(sum);
        model.addAttribute(operator);
        return "index";
    }
}
