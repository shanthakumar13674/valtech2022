package valwsclient;

import org.apache.cxf.frontend.ClientProxyFactoryBean;

import valtech.ws.Point;
import valtech.ws.PointArithmetic;

public class PointArithmeticClient {

	public static void main(String[] args) {
		ClientProxyFactoryBean client = new ClientProxyFactoryBean();
		client.setAddress("http://localhost:7777/PointArithmetic");
		PointArithmetic pa =  client.create(PointArithmetic.class);
		Point a  = new Point();
		a.setX(10);
		a.setY(20);
		Point b = new Point();
		b.setX(30);
		b.setY(40);
		System.out.println(pa.add(a, b));
		System.out.println(pa.sub(a, b));
	}

}
