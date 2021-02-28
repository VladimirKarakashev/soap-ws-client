package com.example.soapwsclient.controller;


import com.example.soapwsclient.Client;
import com.example.soapwsclient.stub.DetailsType;
import com.example.soapwsclient.stub.GetBankResponseType;
import com.example.soapwsclient.stub.GetBankType;
import com.example.soapwsclient.stub.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    private Client soapClient;

    @GetMapping
    public DetailsType sum(@RequestParam String code) {
        ObjectFactory objectFactory = new ObjectFactory();
        GetBankType type = new GetBankType();
        type.setBlz(code);

        GetBankResponseType response = soapClient.getBank("http://www.thomas-bayer.com/axis2/services/BLZService",
        objectFactory.createGetBank(type));
        return response.getDetails();
    }


}
