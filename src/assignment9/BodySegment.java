package assignment9;

import java.awt.Color;

import edu.princeton.cs.introcs.StdDraw;

public class BodySegment {

	private double x, y, size;
	private Color color;
	
	public BodySegment(double x, double y, double size, Color color) {
		this.x = x;
		this.y = y;
		this.size = size;
		this.color = color; 
		}
	
	public void setBodyX(double n) {
		this.x = n;
	}
	
	public double getBodyX() {
		return x;
	}
	public void setBodyY(double n) {
		this.y = n;
	}
	
	public double getBodyY() {
		return y;
	}
	
	/**
	 * Draws the segment
	 */
	public void draw() {
		StdDraw.setPenColor(color);
		StdDraw.filledCircle(x, y, size);
	}
	
}
