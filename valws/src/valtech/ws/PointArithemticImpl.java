package valtech.ws;

public class PointArithemticImpl implements PointArithmetic {
	
	public Point add(Point a, Point b)	{
		Point res = new Point();
		res.setX(a.getX()+b.getX());
		res.setY(a.getY()+b.getY());
		return res;
	}
	
	public Point sub(Point a, Point b)	{
		Point res = new Point();
		res.setX(a.getX()-b.getX());
		res.setY(a.getY()-b.getY());
		return res;
	}

}
