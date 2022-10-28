package valtechspring.aop;

public interface Arithmetic {

	int add(int a, int b);
	
	int add(int ... a);
	
	int mul(int ... a);

	int sub(int a, int b);

	int mul(int a, int b);

	int div(int a, int b);

}