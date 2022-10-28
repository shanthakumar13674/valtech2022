package simplejws;

public class HelloWorldClient {
	
	public static void main(String[] args)throws Exception {
		HelloWorld hw = new HelloWorldProxy();
		System.out.println(hw.hello("Web Service"));
		
	}

}
