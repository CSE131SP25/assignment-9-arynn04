package assignment9;

import java.awt.event.KeyEvent;

import edu.princeton.cs.introcs.StdDraw;

public class Game {
	
	private Snake arynn;
	private Food food; 
	
	public Game() {
		StdDraw.enableDoubleBuffering();
		arynn = new Snake();
		food = new Food();
	}
	
	public void play() {
		while (arynn.isInbounds() == true) { 
			int dir = getKeypress();
			System.out.println("Keypress: " + dir);
			
			arynn.changeDirection(dir);
			arynn.move();
			if (arynn.eatFood(food) == true) {
				arynn.addSegment(food); 
				food = arynn.createNewFood(food);		
			}
		updateDrawing(); 
			}
		showGameOverScreen();
	}
	
	private int getKeypress() {
		if(StdDraw.isKeyPressed(KeyEvent.VK_W)) {
			return 1;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_S)) {
			return 2;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_A)) {
			return 3;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_D)) {
			return 4;
		} else {
			return -1;
		}
	}
	
	/**
	 * Clears the screen, draws the snake and food, pauses, and shows the content
	 */
	private void updateDrawing() {
		
		StdDraw.clear();
		arynn.draw();
		food.draw(); 
		StdDraw.pause(100);
		StdDraw.show(); 
		
	}
	
	public static void main(String[] args) {
		Game g = new Game();
		g.showIntroScreen();
		g.play();
	}
	
	// add intro/game over screens
	private void showIntroScreen() {
	    StdDraw.clear();
	    StdDraw.setPenColor(StdDraw.BLACK);
	    StdDraw.text(0.5, 0.6, "Welcome to Snake Game!");
	    StdDraw.text(0.5, 0.5, "Use W A S D to move");
	    StdDraw.text(0.5, 0.4, "Press any key to begin...");
	    StdDraw.show();

	    while (!StdDraw.hasNextKeyTyped()) {
	        // wait until any key is pressed
	    }
	    StdDraw.nextKeyTyped(); // consume the key press
	}
	
	private void showGameOverScreen() {
	    StdDraw.clear();
	    StdDraw.setPenColor(StdDraw.RED);
	    StdDraw.text(0.5, 0.6, "Game Over!");
	    StdDraw.text(0.5, 0.5, "Thanks for playing.");
	    StdDraw.text(0.5, 0.4, "Close the window to exit.");
	    StdDraw.show();
	    // freeze the screen for a while or wait for a key press
	    while (true) {
	        // Just keep displaying the game over screen
	    }
	}
	 
}

