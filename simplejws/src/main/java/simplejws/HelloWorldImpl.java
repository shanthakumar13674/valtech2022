package simplejws;

import javax.jws.WebService;

@WebService(targetNamespace = "http://simplejws/", endpointInterface = "simplejws.HelloWorld", portName = "HelloWorldImplPort", serviceName = "HelloWorldImplService")
public class HelloWorldImpl implements HelloWorld  {

	@Override
	public String hello(String name)	{
		return "Hello "+name;
	}
	
}
