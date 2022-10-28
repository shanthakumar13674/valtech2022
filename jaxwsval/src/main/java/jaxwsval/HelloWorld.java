package jaxwsval;

import javax.jws.WebService;

@WebService(name = "HelloWorld", targetNamespace = "http://jaxwsval/")
public interface HelloWorld {

	String hello(String name);

}