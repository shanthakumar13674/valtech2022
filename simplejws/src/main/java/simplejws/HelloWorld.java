package simplejws;

import javax.jws.WebService;

@WebService(name = "HelloWorld", targetNamespace = "http://simplejws/")
public interface HelloWorld {

	String hello(String name);

}