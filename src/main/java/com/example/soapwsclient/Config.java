package com.example.soapwsclient;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.web.bind.annotation.RequestMapping;

@Configuration
@RequestMapping("/*")
public class Config {

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.example.soapwsclient.stub");
        return marshaller;
    }

    @Bean
    public Client soapConnector(Jaxb2Marshaller marshaller) {
        Client soapClient = new Client();
        soapClient.setDefaultUri("http://www.thomas-bayer.com/axis2/services/BLZService");
        soapClient.setMarshaller(marshaller);
        return soapClient;
    }



}
