package valwsclient;

import org.apache.cxf.frontend.ClientProxyFactoryBean;

import valtech.ws.HelloWorld;
//java -cp tcpmon-1.0.jar org.apache.ws.commons.tcpmon.TCPMon
public class HelloWorldClient {
	
	public static void main(String[] args) {
		ClientProxyFactoryBean client = new ClientProxyFactoryBean();
		client.setAddress("http://localhost:7777/HelloWorld");
		HelloWorld hw = client.create(HelloWorld.class);
		System.out.println(hw.hello("Web Service"));
	}

}
