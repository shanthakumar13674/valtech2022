package valtech.ws.server;

import org.apache.cxf.frontend.ServerFactoryBean;

import valtech.ws.PointArithemticImpl;
import valtech.ws.PointArithmetic;

public class PointArithmeticServer {

	public static void main(String[] args) {
		ServerFactoryBean server = new ServerFactoryBean();
		server.setAddress("http://localhost:7000/PointArithmetic");
		server.setServiceBean(new PointArithemticImpl());
		server.setServiceClass(PointArithmetic.class);
		server.create();
		System.out.println("Server runnning ...");
	}

}
