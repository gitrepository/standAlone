package com.ws.client;

import com.ws.service.SayHelloDocument;

public class HelloWorldServiceClient {
	private static final String TARGET_END_POINT = "http://localhost/axis2/services/HelloWorldService.HelloWorldServiceHttpEndpoint";
    public static void main(java.lang.String args[]){
        try{
        	HelloWorldServiceStub stub = new HelloWorldServiceStub(TARGET_END_POINT);
            SayHelloDocument req = SayHelloDocument.Factory.newInstance();
            SayHelloDocument.SayHello data = req.addNewSayHello();
            stub.sayHello(req);
        } catch(Exception e){
            e.printStackTrace();
            System.out.println("\n\n\n");
        }
    }
}
