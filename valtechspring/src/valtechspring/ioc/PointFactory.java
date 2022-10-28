package valtechspring.ioc;

public class PointFactory {
	
	public Point createPoint(int a)	{
		return new Point(a,a);
	}

}
