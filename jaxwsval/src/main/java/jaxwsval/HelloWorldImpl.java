package jaxwsval;

import javax.jws.WebService;

@WebService(targetNamespace = "http://jaxwsval/", endpointInterface = "jaxwsval.HelloWorld", portName = "HelloWorldImplPort", serviceName = "HelloWorldImplService")
public class HelloWorldImpl implements HelloWorld {

	public String hello(String name)	{
		return "Hello "+name;
	}
	
}
