package com.valtech.training.corejava.day1;

import java.io.Serializable;

public class Point implements Comparable<Point>, Serializable	{

	public static final Point ORIGIN = new Point(0, 0);

	protected int x;
	protected int y;

	public Point() {
		super();
	}

	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	/**
	 * return -1 if the object is smaller
	 * 0 if it is equal
	 * 1 if it is greater
	 */
	@Override
	public int compareTo(Point o) {
		if(distance() < o.distance())	{
			return -1;
		}
		if(distance() == o.distance()) {
			if(x < o.x)	{
				return -1;
			}
			if(x > o.x) return +1;
			return 0;
		}
		return +1;
	}

	public boolean equals(Object obj) {
		if (obj instanceof Point) {
			Point p = (Point) obj;
			return p.x == x && p.y == y;
		}
		return false;
	}

	public int hashCode() {
		return toString().hashCode();
	}

	public String toString() {
		return new StringBuffer("X = ").append(x)
				.append(" Y = ").append(y).toString();
	}

	public double distance() {
		System.out.println("Distance of Point 2D");
		return Math.sqrt(x * x + y * y);
	}

	public double distance(int x, int y) {
		int dx = this.x - x;
		int dy = this.y - y;
		return Math.sqrt(dx * dx + dy * dy);
	}

	public double distance(Point p) {
		return this.distance(p.x, p.y);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {

		this.y = y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public static void main(String[] args) {
		Point p = new Point(2, 3);
		System.out.println("X = " + p.getX() + " Y = " + p.getY());
		System.out.println(p.distance());
		System.out.println(p.distance(10, 20));
		System.out.println(p.distance(new Point(12, 13)));
	}

	

}
