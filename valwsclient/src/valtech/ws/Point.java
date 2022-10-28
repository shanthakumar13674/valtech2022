package valtech.ws;

import java.io.Serializable;

public class Point implements Serializable {
	
	private int x;
	private int y;
//	Parameterless Constructor and Getters / Setters 
	
	public int getX() {
		return x;
	}
	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}

}
