
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;


public class Battle_Mob extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3771266155574343655L;
	public static int botX = 66 * 22;
	public static int botY = 66 * 5;
	public static int botHeatPoint = 100;
	public int speed = 10;
	boolean botStep = false;
	static int botAnimation = 0;
	static String botname = "";
	Image[] wolf = new Image[10];
	Image[] manticore = new Image[18];

	Battle_Mob() {
		if (botname == "wolf")
			speed = 10;
		else if (botname == "manticore")
			speed = 15;
		
		wolf[0] = null;
		for (int i = 1; i < 6; i++)
			try {
				wolf[i - 1] = ImageIO.read(new File("images/bot/Cerberus_1" + i + ".png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		for (int i = 1; i < 6; i++)
			try {
				wolf[i + 4] = ImageIO.read(new File("images/bot/Cerberus_0" + i + ".png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		manticore[0] = null;
		for (int i = 1; i < 10; i++)
			try {
				manticore[i - 1] = ImageIO.read(new File("images/bot/Manticore_1" + i + ".png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		for (int i = 1; i < 10; i++)
			try {
				manticore[i + 8] = ImageIO.read(new File("images/bot/Manticore_0" + i + ".png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
	}

	public void analys(int StartX, int StartY) {
		if (botStep) {
			if (StartX <= botX - Battleground.sizex / 2)
				moveLeft();
			else if (StartX >= botX + Battleground.sizex / 2)
				moveRight();
			else if (StartY <= botY - Battleground.sizey / 2)
				moveUp();
			else if (StartY >= botY + Battleground.sizey / 2)
				moveDown();
		} else {
			if (StartY <= botY - Battleground.sizey / 2)
				moveUp();
			else if (StartY >= botY + Battleground.sizey / 2)
				moveDown();
			else if (StartX <= botX - Battleground.sizex / 2)
				moveLeft();
			else if (StartX >= botX + Battleground.sizex / 2)
				moveRight();
		}
	}
	
	void animationLeft() {
		if (botAnimation >= 6 && botname == "manticore")
			botAnimation = 0;
		else if (botAnimation >= 4 && botname == "wolf")
			botAnimation = 0;
		botAnimation++;
	}
	
	void animationRight() {
		if (botAnimation >= 17 && botname == "manticore")
			botAnimation = 9;
		else if (botAnimation >= 9 && botname == "wolf")
			botAnimation = 5;
		botAnimation++;
	}

	void moveLeft() {
		botX -= speed;
		animationLeft();
	}	

	void moveRight() {
		botX += speed;
		animationRight();
	}

	void moveUp() {
		botY -= speed;
		animationLeft();
	}

	void moveDown() {
		botY += speed;
		animationLeft();
	}

	public void drawMob(Graphics g) {
		if (botname == "wolf")
			g.drawImage(wolf[botAnimation], botX - 55, botY - 44, null);
		else if (botname == "manticore")
			g.drawImage(manticore[botAnimation], botX, botY - 66, null);
		
		if (botHeatPoint > 70)
			g.setColor(Color.GREEN);
		else if (botHeatPoint > 40)
			g.setColor(Color.ORANGE);
		else
			g.setColor(Color.RED);
		
		g.fillRect(botX - 4 + 50, botY - 20 + 80, 55, 20);
		g.setColor(Color.YELLOW);
		g.drawRect(botX - 4 + 50, botY - 20 + 80, 55, 20);
		g.setColor(Color.black);
		g.drawString("HP: " + botHeatPoint, botX + 50, botY - 5 + 80);
	}
}
