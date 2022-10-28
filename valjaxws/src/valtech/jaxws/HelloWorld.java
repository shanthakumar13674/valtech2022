package valtech.jaxws;

import javax.jws.WebService;

@WebService(name = "HelloWorld", targetNamespace = "http://jaxws.valtech/")
public interface HelloWorld {

	String hello(String name);

	String hi(String name);

}