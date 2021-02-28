package com.example.soapwsclient;

import com.example.soapwsclient.stub.GetBankResponseType;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import javax.xml.bind.JAXBElement;

public class Client extends WebServiceGatewaySupport {

    public GetBankResponseType getBank(String url, Object request){
        JAXBElement res = (JAXBElement) getWebServiceTemplate().marshalSendAndReceive(url, request);
        return (GetBankResponseType) res.getValue();
    }
}
