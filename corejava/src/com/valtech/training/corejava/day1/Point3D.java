package com.valtech.training.corejava.day1;

public class Point3D extends Point {
	
	
	public static final Point3D ORIGIN = new Point3D();
	
	private int z;
	
	public Point3D() {}
	
	public Point3D(int x,int y,int z) {
		super(x,y);
		this.z=z;
	}
	
	@Override
	public double distance() {
		System.out.println("Distance of Point 3d");
		return Math.sqrt(x*x+y*y+z*z);
	}
	
	public double distance(int x,int y,int z)	{
		int dx= this.x-x;
		int dy = this.y-y;
		int dz = this.z-z;
		return Math.sqrt(dx*dx+dy*dy+dz*dz);
	}
	
	public double distance(Point3D p)	{
		return distance(p.x,p.y,p.z);
	}
	
	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}

	public static void main(String[] args) {
		System.out.println(new Point3D());
		final Point p = new Point3D(10,20,30);
		System.out.println(p.distance());
		Point3D p1 = (Point3D) p;
		System.out.println(p1.getZ());
		
		
		
	}

}












