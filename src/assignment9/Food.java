package assignment9;

import java.awt.Color;


import edu.princeton.cs.introcs.StdDraw;

public class Food {

	public static final double FOOD_SIZE = 0.02;
	private double x, y;
	
	/**
	 * Creates a new Food at a random location
	 */
	
	public Food() {
		x = Math.random();
		y = Math.random();
	}
	
	public double getFoodX() {
		return x;
	}
	
	public double getFoodY() {
		return y;
	}
	/**
	 * Draws the Food
	 */
	public void draw() {
		StdDraw.setPenColor(Color.GREEN);
		StdDraw.filledSquare(this.x, this.y, FOOD_SIZE); 
	}
	
}
