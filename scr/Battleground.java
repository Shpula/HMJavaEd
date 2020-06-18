
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Battleground extends JPanel implements Runnable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1447597081002383792L;

	public static int WIDTH = 1920;
	public static int HEIGHT = 1080;

	private Thread thread = new Thread(this);

	Image img = null;
	Image[] playerImg = new Image[40];
	Image[] playerSkill = new Image[4];
	Image[] fillGroundbtn = new Image[2];
	Image battle = null;

	public static int sizex = 66;
	public static int sizey = 66;
	public static int mouseX = 5 * sizex + 33;
	public static int mouseY = 3 * sizey + 33;
	public static int cx = mouseX;
	public static int cy = mouseY;

	private int difficulty = 1;
	private static double userHeatPoint = 100;
	private int countBot = 0;
	private int steps = 50;
	private double bothit = 1;
	public static int countUser = 0;
	private boolean showfield = false;
	public static boolean user_step = false;
	public static boolean run_timer = false;
	Battle_Mob bot = new Battle_Mob();


	Battleground(String bot) {
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setFocusable(true);
		requestFocus();
		thread.start();
		Battle_Mob.botname = bot;

		addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getX() / sizex >= 4 && e.getX() / sizex <= 18 && e.getY() / sizey >= 2
						&& e.getY() / sizey <= 10) {
					mouseX = e.getX();
					mouseY = e.getY();
					run_timer = true;
					user_step = !user_step;
				}

				if (mouseX < cx)
					HeroAnimation.spin = true;
				
				if (Battle_Mob.botX < cx) {
					if (Battle_Mob.botAnimation <= 7 && Battle_Mob.botname == "manticore")
						Battle_Mob.botAnimation = 9;
					else if (Battle_Mob.botAnimation <= 5 && Battle_Mob.botname == "wolf")
						Battle_Mob.botAnimation = 5;
				} else
					if (Battle_Mob.botAnimation >= 8 && Battle_Mob.botname == "manticore")
						Battle_Mob.botAnimation = 0;
					else if (Battle_Mob.botAnimation >= 6 && Battle_Mob.botname == "wolf")
						Battle_Mob.botAnimation = 0;
					

				if (e.getX() > 20 && e.getX() < 134 && e.getY() > 140 && e.getY() < 171) {
					showfield = !showfield;
					repaint();
				}

				if (e.getX() > 20 && e.getX() < 134 && e.getY() > 200 && e.getY() < 231) {
					HeroAnimation.userhit = 35;
					if (Battle_Mob.botname == "wolf") {
						bothit = 1;
					} else if (Battle_Mob.botname == "manticore") {
						bothit = 1.2;
					}
					difficulty = 1;
					repaint();
				}

				if (e.getX() > 20 && e.getX() < 134 && e.getY() > 240 && e.getY() < 271) {
					HeroAnimation.userhit = 30;
					if (Battle_Mob.botname == "wolf") {
						bothit = 1.2;
					} else if (Battle_Mob.botname == "manticore") {
						bothit = 1.3;
					}
					difficulty = 2;
					repaint();
				}

				if (e.getX() > 1590 && e.getX() < 1670 && e.getY() > 1015 && e.getY() < 1075) {
					if (countUser >= 0) {
						run_timer = true;
						userHeatPoint += (steps - countUser) / (bothit * 2);
						mouseX = cx;
						mouseY = cy;
						countUser = -1;
						if (HeroAnimation.userAnimation <= 10)
							HeroAnimation.userAnimation = 0;
						else
							HeroAnimation.userAnimation = 19;
						repaint();
					}
				}

			}
		});

		playerImg[0] = null;

		for (int i = 0; i < 10; i++)
			try {
				playerImg[i] = ImageIO.read(new File("images/user/Champion_00" + i + ".png"));
			} catch (IOException e) {
				e.printStackTrace();
			}

		for (int i = 10; i < 20; i++)
			try {
				playerImg[i] = ImageIO.read(new File("images/user/Champion_0" + i + ".png"));
			} catch (IOException e) {
				e.printStackTrace();
			}

		for (int i = 0; i < 10; i++)
			try {
				playerImg[i + 19] = ImageIO.read(new File("images/user/Champion_10" + i + ".png"));
			} catch (IOException e) {
				e.printStackTrace();
			}

		for (int i = 10; i < 20; i++)
			try {
				playerImg[i + 19] = ImageIO.read(new File("images/user/Champion_1" + i + ".png"));
			} catch (IOException e) {
				e.printStackTrace();
			}

		playerSkill[0] = null;

		for (int i = 0; i < 4; i++)
			try {
				playerSkill[i] = ImageIO.read(new File("images/skill" + (i + 1) + ".jpg"));
			} catch (IOException e) {
				e.printStackTrace();
			}

		fillGroundbtn[0] = null;

		for (int i = 0; i < 2; i++)
			try {
				fillGroundbtn[i] = ImageIO.read(new File("images/fillgr" + i + ".jpg"));
			} catch (IOException e) {
				e.printStackTrace();
			}

		try {
			battle = ImageIO.read(new File("battle.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		Timer timer = new Timer(100, new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (run_timer)
					repaint();
			}

		});
		timer.start();
	}

	public void checkFight() {
		if (countUser >= 0)
			if (cx + sizex / 2 > Battle_Mob.botX && cx - sizex * 3 / 2 < Battle_Mob.botX
					&& cy + sizey / 2 > Battle_Mob.botY && cy - sizey * 3 / 2 < Battle_Mob.botY)
				if (mouseX > Battle_Mob.botX && mouseX < Battle_Mob.botX + sizex && mouseY > Battle_Mob.botY
						&& mouseY < Battle_Mob.botY + sizey) {
					HeroAnimation.fight_animation = true;
					mouseX = cx;
					mouseY = cy;
					countUser = steps;
				}
	}

	public void checkUserStep() {
		if (countUser == steps) {
			mouseX = cx;
			mouseY = cy;
			countUser = -1;
			if (HeroAnimation.userAnimation <= 10)
				HeroAnimation.userAnimation = 0;
			else
				HeroAnimation.userAnimation = 19;
		}
	}

	public void botFight() {
		if (countUser == -1 && HeroAnimation.fight_animation == false) {
			if (Battle_Mob.botX + sizex > cx && Battle_Mob.botX - sizex < cx && Battle_Mob.botY + sizey / 2 > cy
					&& Battle_Mob.botY - sizey / 2 < cy) {
				userHeatPoint -= bothit * (bot.speed / 5);
				if (Battle_Mob.botX > cx && Battle_Mob.botAnimation >= 3)
					Battle_Mob.botAnimation = 0;
				else if (Battle_Mob.botX < cx && Battle_Mob.botAnimation >= 8)
					Battle_Mob.botAnimation = 5;
				Battle_Mob.botAnimation++;
			}
			bot.analys(cx, cy);
			countBot++;

			if (countBot == steps / (bot.speed / 5)) {
				countBot = 0;
				countUser = 0;
				if (Battle_Mob.botAnimation < 5)
					Battle_Mob.botAnimation = 0;
				else
					Battle_Mob.botAnimation = 5;
				bot.botStep = !bot.botStep;
				run_timer = false;
				repaint();
			}
		}
	}

	
	public void fillGround(Graphics g) {
		if (showfield)
			g.drawImage(fillGroundbtn[0], 20, 140, null);
		else
			g.drawImage(fillGroundbtn[1], 20, 140, null);
		g.setColor(new Color(0, 250, 0));
		for (int i = 5; i < 24; i++)
			for (int j = 3; j < 16 - 3; j++) {
				if (showfield)
					g.drawRect(i * sizex, j * sizey, sizex, sizey);
			}
	}

	public void drawObjects(Graphics g) {
		if (Battle_Mob.botY + 50 < cy) {
			bot.drawMob(g);
			g.drawImage(playerImg[HeroAnimation.userAnimation], cx - 40, cy - 90, null);
		} else {
			g.drawImage(playerImg[HeroAnimation.userAnimation], cx - 40, cy - 90, null);
			bot.drawMob(g);
		}
	}

	public void drawPlaySkill(Graphics g) {
		if (difficulty == 2) {
			g.drawImage(playerSkill[0], 20, 200, null);
			g.drawImage(playerSkill[1], 20, 240, null);
		} else if (difficulty == 1) {
			g.drawImage(playerSkill[3], 20, 200, null);
			g.drawImage(playerSkill[2], 20, 240, null);
		}

		g.setColor(Color.white);
		g.drawString("урон героя" + String.valueOf(HeroAnimation.userhit), 10, 480);
		g.drawString(
				"урон противника " + String.format("%.2g%n", bothit * (bot.speed / 5)) + "-" + String.format("%.3g%n", bothit * steps),
				10, 500);
	}

	public void drawHeatPoint(Graphics g) {
		if (userHeatPoint > 70)
			g.setColor(Color.GREEN);
		else if (userHeatPoint > 40)
			g.setColor(Color.ORANGE);
		else
			g.setColor(Color.RED);
		g.fillRect(cx - 4 + 40, cy - 20 + 30, 55, 20);
		g.setColor(Color.YELLOW);
		g.drawRect(cx - 4 + 40, cy - 20 + 30, 55, 20);
		g.setColor(Color.black);
		g.drawString("HP: " + (int) userHeatPoint, cx + 40, cy - 5 + 30);
	}
	
	public void getStatusGame() {
		if (userHeatPoint <= 0) {
			
		} else if (Battle_Mob.botHeatPoint <= 0) {
			JFrame fr = new JFrame("hero");
			fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			fr.setUndecorated(true);
			fr.setExtendedState(JFrame.MAXIMIZED_BOTH);
			fr.setContentPane(new Field(1));
			fr.pack();
			fr.setLocationRelativeTo(null);
			fr.setVisible(true);
			
			
		}
	}

	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(img, 0, 0, null);
		g.drawImage(battle, 0, 0, null);

		fillGround(g);

		g.setColor(new Color(0, 0, 0));
		
		drawPlaySkill(g);

		drawObjects(g);

		drawHeatPoint(g);

		HeroAnimation.animation();

		checkFight();

		checkUserStep();

		botFight();

		getStatusGame();

	}

	@Override
	public void run() {
		if (Battle_Mob.botname == "wolf") {
			bothit = 1;
		} else if (Battle_Mob.botname == "manticore") {
			bothit = 1.2;
		}
	}
}