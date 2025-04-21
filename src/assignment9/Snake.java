package assignment9;

import java.awt.Color;
import java.util.LinkedList;

public class Snake {

	private static final double SEGMENT_SIZE = 0.02;
	private static final double MOVEMENT_SIZE = SEGMENT_SIZE * 1.5;
	private LinkedList<BodySegment> segments;
	private double deltaX;
	private double deltaY;
	private BodySegment head; 	
	
	public Snake() {
		segments = new LinkedList<>();
		deltaX = 0;
		deltaY = 0;
		head = new BodySegment (0.5, 0.5, SEGMENT_SIZE, Color.PINK); 
		segments.add(head); 
	}
	
	public void changeDirection(int direction) {
		if(direction == 1) { //up
			deltaY = MOVEMENT_SIZE;
			deltaX = 0;
		} else if (direction == 2) { //down
			deltaY = -MOVEMENT_SIZE;
			deltaX = 0;
		} else if (direction == 3) { //left
			deltaY = 0;
			deltaX = -MOVEMENT_SIZE;
		} else if (direction == 4) { //right
			deltaY = 0;
			deltaX = MOVEMENT_SIZE;
		}
	}
	
	/**
	 * Moves the snake by updating the position of each of the segments
	 * based on the current direction of travel
	 */
	public void move() {
		for (int i = segments.size()-1; i > 0; i--) {
			double previousX = segments.get(i-1).getBodyX();
			double previousY = segments.get(i-1).getBodyY();
			segments.get(i).setBodyX(previousX);
			segments.get(i).setBodyY(previousY);
		}
		segments.get(0).setBodyX(segments.get(0).getBodyX() + deltaX);
		segments.get(0).setBodyY(segments.get(0).getBodyY() + deltaY);
	}
	
	/**
	 * Draws the snake by drawing each segment
	 */
	public void draw() {
		for (int i = 0; i < segments.size(); i++) {
			segments.get(i).draw(); 
		}
	}
	
	/**
	 * The snake attempts to eat the given food, growing if it does so successfully
	 * @param f the food to be eaten
	 * @return true if the snake successfully ate the food
	 */
	public boolean eatFood(Food f) {
		double headX = head.getBodyX();
		double headY = head.getBodyY(); 
		double foodX = f.getFoodX(); 
		double foodY = f.getFoodY();
		double xDistance = headX - foodX;
		double yDistance = headY - foodY; 
		double distance = Math.sqrt(yDistance * yDistance + xDistance * xDistance);
		if (distance <= SEGMENT_SIZE + Food.FOOD_SIZE) {
			return true; 
		} else {
			return false; 
		}
	}
	
	public void addSegment (Food f) {
		if (eatFood(f) == true) {
			double newX = segments.get(segments.size()-1).getBodyX()-SEGMENT_SIZE; 
			double newY = segments.get(segments.size()-1).getBodyY()-SEGMENT_SIZE;
			segments.add(new BodySegment(newX, newY, SEGMENT_SIZE, Color.PINK)); 
		}	
	}
	
	
	public Food createNewFood (Food f) {
		return new Food(); 
	}
	
	
	/**
	 * Returns true if the head of the snake is in bounds
	 * @return whether or not the head is in the bounds of the window
	 */
	public boolean isInbounds() {
		if (head.getBodyX() < 1.0 && head.getBodyX() > 0 && head.getBodyY() < 1.0 && head.getBodyY() > 0) {
			return true;
		}
	return false; 
	}
}
