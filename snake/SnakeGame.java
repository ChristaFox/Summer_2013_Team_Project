package snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;
import javax.swing.*;

public class SnakeGame extends JFrame {
	
	private static final long serialVersionUID = -589241850342665286L;
	private final int WIDTH = 305;
	private final int HEIGHT = 327;
	private final int SQR_SIZE = 10;
	private final int X_OFFSET = 2;
	private final int Y_OFFSET = 4;
	private final int X_MIN = 0;
	private final int X_MAX = 290;
	private final int Y_MIN = 20;
	private final int Y_MAX = 310;
	private final int ALL_SQRS = 900;
	
	/**
	 * Enumeration to define the directions the snake can go
	 */
	private enum Dir {
		UP,
		DOWN,
		LEFT,
		RIGHT
	}

	private Dir snakeDir = Dir.UP;
	
	private boolean inGame = false;
	
	private HighScoresList highScoresList = new HighScoresList();
	
	private int[] xArray = new int[ALL_SQRS];
	private int[] yArray = new int[ALL_SQRS];
	
	private int x, y;
	private int appleX, appleY;
	private int speed = SQR_SIZE;
	private int velX = 0;
	private int velY = 0;
	private int snakeLength;
	private int score = 0;
	private int applePoints;
	private int apples;
	
	private Random rand = new Random();
	
	private Image head;
	private Image tail;
	private Image apple;

	public SnakeGame() {
		
		setJFrameAttributes();
        setImageIcons();
        startGame();
 
	}

	/**
	 * Class & Method used to check what key is pressed and sets the snake head's direction 
	 */
	public class AL extends KeyAdapter {	
		
		public void keyPressed(KeyEvent e) {
			int keyCode = e.getKeyCode();
			
			if(keyCode == KeyEvent.VK_LEFT && snakeDir != Dir.RIGHT) {
				snakeDir = Dir.LEFT;
			}
			if(keyCode == KeyEvent.VK_RIGHT && snakeDir != Dir.LEFT) {
				snakeDir = Dir.RIGHT;
			}
			if(keyCode == KeyEvent.VK_UP && snakeDir != Dir.DOWN) {
				snakeDir = Dir.UP;
			}
			if(keyCode == KeyEvent.VK_DOWN && snakeDir != Dir.UP) {
				snakeDir = Dir.DOWN;
			}
			if(keyCode == KeyEvent.VK_ESCAPE) {
				inGame = false;
			}
		}
	}
	
	private void setJFrameAttributes() {
		
		addKeyListener(new AL());
		addWindowListener(new WindowAdapter(){
		public void windowClosing(WindowEvent we){
				inGame = false;
					System.exit(0);
			}
		});
		setTitle("Snake Game");
		setSize(WIDTH, HEIGHT);
		setResizable(false);
		setBackground(Color.black);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	/**
	 * Initializes the Images (Apple, Snake Head, Snake Tail Dot)
	 */
	private void setImageIcons() {
		ImageIcon appleIcon = new ImageIcon(SnakeGame.class.getResource("apple.png"));
		apple = appleIcon.getImage();
        
        ImageIcon headIcon = new ImageIcon(SnakeGame.class.getResource("head.png"));
        head = headIcon.getImage();
        
        ImageIcon tailIcon = new ImageIcon(SnakeGame.class.getResource("dot.png"));
	    tail = tailIcon.getImage();
	}
	
	/**
	 * Sets the snake's starting position (including tail dots), 
	 * resets the velocity, 
	 * sets the snake's tail length (including the head),
	 * generates the apple coordinates
	 * starts the game loop
	 */
	public void startGame() {
		score = 0;
		apples = 0;
		applePoints = 100;
		x = 140;
		y = 160;
		velX = 0;
		velY = 0;
		snakeLength = 3;
		
		for(int z = 0; z < snakeLength; z++) {
			xArray[z] = x;
            yArray[z] = y + z * SQR_SIZE;
		}
		
		generateAppleCoords();
		inGame = true;
		do {
			sleep(100);
			
			if( applePoints > 0 )
				applePoints--;
			checkAppleCollision();
			checkCollision();
			setVelocity();
			repaint();
//			System.out.printf("(%d,%d)%n", getXCoord(xArray[0]), getYCoord(yArray[0]));
		} while(inGame);
		gameOver();
	}
	
	/**
	 * Closes game window and if the score is eligible to make it into the leaderboards
	 * the user is prompted to enter their name
	 */
	private void gameOver() {

		dispose();
		
		if ( highScoresList.newHighScore( score ) )
			highScoresList.enterNewHighScore( apples, score );
		
		highScoresList.serialize();
	}
	
	/**
	 * Checks if the snake's head has the same coordinates as the apple coordinates.
	 * If so, a new apple is placed on the screen.
	 */
	private void checkAppleCollision() {
		
        if ((appleX == xArray[0] + X_OFFSET)  && (appleY == (yArray[0] + Y_OFFSET))) {
        	snakeLength++;
        	apples++;
            score += applePoints;
            applePoints = 100;
            generateAppleCoords();
        }
    }
	
	/**
	 * Generates the placement coordinates for the next apple.
	 * The coordinates generated are always within the box borders.
	 * Prints out game data to to console (Optional)
	 */
	private void generateAppleCoords() {
		
		int xMin = X_MIN / SQR_SIZE;
		int yMin = Y_MIN / SQR_SIZE;
		
		int xMax = X_MAX / SQR_SIZE ;
		int yMax = Y_MAX / SQR_SIZE;
		
		int xRange = xMax - xMin + 1;
		int yRange = yMax - yMin + 1;
		
		int randNum  = rand.nextInt(xRange) + xMin;
        appleX = randNum * SQR_SIZE + X_OFFSET;
        
        randNum  = rand.nextInt(yRange) + yMin;
		appleY = randNum * SQR_SIZE + Y_OFFSET;
		
		System.out.printf("Next Apple Location: (%d,%d)%n%n", getXCoord(appleX - X_OFFSET), getYCoord(appleY - Y_OFFSET));
    }
	
	/**
	 * Checks if the snake head's coordinates are equal to any of the tail coordinates,
	 * or if the snake hits the wall.
	 */
	private void checkCollision() {
		
		for (int z = snakeLength; z > 0; z--) {

            if ((z > 4) && (xArray[0] == xArray[z]) && (yArray[0] == yArray[z])) {
                inGame = false;
            }
        }
		
		if (xArray[0] > X_MAX) {
			inGame = false;
		}
		
		if (xArray[0] < X_MIN) {
			inGame = false;
		}
		
		if (yArray[0] > Y_MAX) {
			inGame = false;
		}
		
		if (yArray[0] < Y_MIN) {
			inGame = false;
		}
	}
	
	/**
	 * Depending on what key has been pressed and where the snake is currently going,
	 * this sets the velocity (speed & direction) 
	 */
	private void setVelocity() {
		
		switch(snakeDir)
		{
			case UP:
				if(velY == 0) {
					velX = 0;
					velY = speed;
				}
				break;
			case DOWN:
				if(velY == 0) {
					velX = 0;
					velY = -speed;
				}
				break;
			case LEFT:
				if(velX == 0) {
					velY = 0;
					velX = -speed;
				}
				break;
			case RIGHT:
				if(velX == 0) {
					velY = 0;
					velX = speed;
				}
				break;
		}
	}
	
	/**
	 * Clears the screen,
	 * draws grid (Optional),
	 * draws the apple,
	 * draws the snake,
	 * and draws score info at top of screen
	 */
	public void paint(Graphics g) {
		
		super.paint(g);
		
		if(inGame) {
			g.clearRect(0, 0, 600, 600 );
//			drawGrid(g);
			g.drawImage(apple, appleX, appleY, this);
			move();	
			for (int z = 0; z < snakeLength; z++) {
                if (z == 0)
                	g.drawImage(head, xArray[z] + X_OFFSET, yArray[z] + Y_OFFSET, this);
                else 
                	g.drawImage(tail, xArray[z] + X_OFFSET, yArray[z] + Y_OFFSET, this);
            }
			
			g.setColor( Color.WHITE );
			String myString = String.format( "Apples: %,d       Score: %,d       Apple Points: %d", apples, score, applePoints );
			g.drawString( myString, 20, 60 );
			
			Toolkit.getDefaultToolkit().sync();
		}
	}
	
	/**
	 * Draws grid lines across the game board (Optional)
	 */
	@SuppressWarnings("unused")
	private void drawGrid(Graphics g) {
		
		for(int x = 0; x < 600; x += SQR_SIZE)
		{
			g.setColor(Color.GRAY);
			g.drawLine(x + X_OFFSET, 0 + Y_OFFSET, x + X_OFFSET, 600 + Y_OFFSET);
			g.drawLine(0 + X_OFFSET, x + Y_OFFSET, 600 + X_OFFSET, x + Y_OFFSET);
		}
	}
	
	/**
	 * Moves the tail using the coordinates of the previous tail section and then moves the head
	 */
	private void move() {
		for (int z = snakeLength; z > 0; z--) {
            xArray[z] = xArray[(z - 1)];
            yArray[z] = yArray[(z - 1)];
        }
		xArray[0] += velX;
		yArray[0] -= velY;
	}
	
	/**
	 * Makes the application wait for the specified amount of time measured in milliseconds
	 * @param ms
	 */
	public void sleep(int ms) {
		
		try {
		    Thread.sleep(ms);
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
	}
	
	/**
	 * Returns normalized X coordinate, from the pixel coordinates to grid coordinates
	 * @param X-Axis Pixel Coordinate
	 * @return X-Axis Coordinate
	 */
	private int getXCoord(int xPixelCoord) {
		return xPixelCoord / 10 + 1;
	}
	
	/**
	 * Returns normalized Y coordinate, from the pixel coordinates to grid coordinates
	 * @param Y-Axis Pixel Coordinate
	 * @return Y-Axis Coordinate
	 */
	private int getYCoord(int yPixelCoord) {
		return yPixelCoord / 10 - 1;
	}
	
	public static void main(String[] args) {
		
		new SnakeGame();
	}
}
