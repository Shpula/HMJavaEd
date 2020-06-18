
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class Field extends JPanel implements Runnable {
	Findway find = new Findway(0, 0, 0, 0);
	// Field
	private Thread thread = new Thread(this);

	static int[][] a = new int[15][23];

	/*
	 * { { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, {
	 * 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, { 1,
	 * 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 1,
	 * 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1,
	 * 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1,
	 * 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1,
	 * 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1,
	 * 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1, 1,
	 * 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 0, 0, 0, 0,
	 * 0, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1, 1, 1, 1,
	 * 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
	 * 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
	 * 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1 }, { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
	 * 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1 }, { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
	 * 1, 1, 1, 1, 1, 1, 1, 1,10, 1 }, };
	 */

	Image img = null;
	Image[] playerImg = new Image[63];
	Image[] kartaImg = new Image[8];
	Image[] karta2Img = new Image[14];
	Image[] cerber = new Image[14];
	/*
	 * vpravo (1 to 8) stoit vpravo (9 to 15)
	 */

	static int sizex = 66;
	static int sizey = 66;
	static int ind = 0;
	protected static int StartX;
	protected static int StartY;
	private boolean mouse_pressed = false;
	static boolean mouse_clicked = false;
	private boolean key_clicked = false;
	static int cx = 860;
	static int cy = 495;
	static int flag = 0;
	int time = 80;
	int korx = 0;
	int kory = 0;
	int ani = 0;
	int indexkart = 0;
	static int count = 0;
	static int k = 0;
	int karta = 0;

	@SuppressWarnings("unused")
	Field(int k) {
		karta = 1;
		a = Load.loadArrayFromFile("src/filename.txt");
		if (k == 1) {
			String textFile = "";
			try {
				textFile = "C:/Users/masha/workspace/gamekurs/" + "save.txt";
			} catch (NumberFormatException ex) {
				return;
			}
			BufferedReader br;
			String str = "";
			try {
				br = new BufferedReader(new FileReader(textFile));
				String s = "";
				s = br.readLine();
				cx = Integer.parseInt(s);
				StartY = cx;
				s = br.readLine();
				cy = Integer.parseInt(s);
				StartY = cy;
				s = br.readLine();
				ind = Integer.parseInt(s);
				br.close();
				repaint();
				// run_timer = false;
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		setFocusable(true);
		requestFocus();
		thread.start();

		addKeyListener(new KeyListener() {
			public void keyPressed(KeyEvent ext) {
				if (ext.getKeyCode() == KeyEvent.VK_ESCAPE)
					key_clicked = true;
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});

		addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				StartX = e.getX() - 10;
				StartY = e.getY() - 10;
				mouse_clicked = true;
			}

			public void mousePressed(MouseEvent e) {
				StartX = e.getX() - 10;
				StartY = e.getY() - 10;
				mouse_pressed = true;
				String str = "";
				str += cx + "";
				str += "\n";
				str += cy + "";
				str += "\n";
				str += ind + "";
				str += "\n";
				String save = "";
				try {
					save = "save.txt";

				} catch (NumberFormatException e1) {
					return;
				}
				PrintWriter writer = null;
				try {
					writer = new PrintWriter(save, "UTF-8");
					writer.write("" + str);
				} catch (FileNotFoundException e2) {
				} catch (UnsupportedEncodingException e3) {
				}
				writer.close();

			}
		});

		try {
			img = ImageIO.read(new File("images/ûדנא_1.png"));
		} catch (IOException e1) { // TODO Auto-generated catch block
			e1.printStackTrace();
		}
		;

		playerImg[0] = null;
		for (int i = 1; i < 63; i++) {
			try {
				playerImg[i] = ImageIO.read(new File("hodka/" + i + ".png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		kartaImg[0] = null;
		for (int i = 1; i < 8; i++) {
			try {
				kartaImg[i] = ImageIO.read(new File("images/" + "Sloy_" + i + ".png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		karta2Img[0] = null;
		for (int i = 1; i < 14; i++) {
			try {
				karta2Img[i] = ImageIO.read(new File("images/" + "karta" + i + ".png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		cerber[0] = null;
		for (int i = 1; i < 14; i++) {
			try {
				cerber[i] = ImageIO.read(new File("images/" + "cerber" + i + ".png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		Timer timer = new Timer(time, new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				repaint();
			}

		});
		timer.start();

	}

	public void paint(Graphics g) {
		super.paint(g);
		if (karta == 1) {
			g.drawImage(kartaImg[indexkart], 0, 0, null);
			g.drawImage(cerber[ani], 290, 575, null);
		}
		if (karta == 2) {
			g.drawImage(karta2Img[indexkart], 0, 0, null);
		}
		ani++;
		if (ani == 14)
			ani = 1;
		indexkart++;
		if (indexkart == 8)
			indexkart = 1;
		g.setColor(new Color(250, 0, 0));
		for (int n = 0; n < 24; n++)
			for (int m = 0; m < 16; m++)
				g.drawRect(10, 10, n * sizex, m * sizey);

		g.setColor(new Color(0, 0, 0));
		String str = String.valueOf(StartX) + ":" + String.valueOf(StartY);
		g.drawString(str, 832, 532);
		// System.out.println(ind);

		if (flag == 2) {
			ind++;
			if (ind > 7)
				ind = 1;
			g.drawImage(playerImg[8 + ind], cx, cy, null);
		} else if (flag == -2) {
			ind++;
			if (ind > 7)
				ind = 1;
			g.drawImage(playerImg[23 + ind], cx, cy, null);
		} else if (flag == 4) {
			ind++;
			if (ind > 8)
				ind = 1;
			g.drawImage(playerImg[46 + ind], cx, cy, null);
		} else if (flag == -4) {
			ind++;
			if (ind > 8)
				ind = 1;
			g.drawImage(playerImg[54 + ind], cx, cy, null);
		}

		else if (flag == 1) {
			if (ind > 8)
				ind = 1;
			g.drawImage(playerImg[ind], cx, cy, null);

		} else if (flag == -1) {
			if (ind > 8)
				ind = 1;
			g.drawImage(playerImg[15 + ind], cx, cy, null);

		} else if (flag == 3) {
			if (ind > 8)
				ind = 1;
			g.drawImage(playerImg[30 + ind], cx, cy, null);
		}

		else if (flag == -3) {
			if (ind > 8)
				ind = 1;
			g.drawImage(playerImg[38 + ind], cx, cy, null);

		}

		if (key_clicked == true) {
			MenuInGame.main(null);
			key_clicked = false;
		}

		if (mouse_clicked == true) {
			ind++;
			if (StartX / sizex != (cx + 32) / sizex || StartY / sizey != (cy + 48) / sizey) {
				find = new Findway((cx + 32) / sizex, (cy + 48) / sizey, StartX / sizex, StartY / sizey);
				if (find.copy[(cy + 48) / sizey][(cx + 32) / sizex] > find.copy[(cy + 48) / sizey][((cx + 32) / sizex)
						+ 1] && find.copy[(cy + 48) / sizey][((cx + 32) / sizex) + 1] > -1) {
					Moving.dvizxpravo();
				}

				else if (find.copy[(cy + 48) / sizey][(cx + 32)
						/ sizex] > find.copy[(cy + 48) / sizey][((cx + 32) / sizex) - 1]
						&& find.copy[(cy + 48) / sizey][((cx + 32) / sizex) - 1] > -1)
					Moving.dvizxvlevo();
				else if (find.copy[(cy + 48) / sizey][(cx + 32)
						/ sizex] > find.copy[((cy + 48) / sizey) + 1][((cx + 32) / sizex)]
						&& find.copy[((cy + 48) / sizey) + 1][((cx + 32) / sizex)] > -1) {
					if (((cy + 48) / sizey) + 1 == 9 && ((cx + 32) / sizex) == 16)
						cx += 3;
					if (((cy + 48) / sizey) + 1 == 12 && ((cx + 32) / sizex) == 17)
						cx += 3;
					if (((cy + 48) / sizey) + 1 == 13 && ((cx + 32) / sizex) == 20)
						cx += 3;
					Moving.dvizvniz();
				}

				else if (find.copy[(cy + 48) / sizey][(cx + 32)
						/ sizex] > find.copy[((cy + 48) / sizey) - 1][((cx + 32) / sizex)]
						&& find.copy[((cy + 48) / sizey) - 1][((cx + 32) / sizex)] > -1) {
					if (StartX / sizex == 10 && StartY / sizey >= 3 && StartY / sizey <= 8) {
						if (flag == -1)
							cx -= 35;
						if (flag == 1)
							cx += 15;
					}
					if (((cy + 48) / sizey) - 1 == 8 && ((cx + 32) / sizex == 10)) {
						cx += 9.5;
						cy -= 48;
						count = 1;
					}
					if (((cy + 48) / sizey) - 1 == 8 && ((cx + 32) / sizex == 16)) {
						cy -= 48;
					}
					Moving.dvizvverh();

				}
			} else {
				if (flag == 1 || flag == -1) {
					if (StartX > cx + 32)
						Moving.dvizxpravo();
					else if (StartX < cx + 32)
						Moving.dvizxvlevo();
				} else if (flag == 3) {
					if (StartY < cy + 48) {
						System.out.println("vverh");
						Moving.dvizvverh();
					} else {
						flag = 4;
						cy = StartY - 48;
					}
				} else if (flag == -3) {
					if (StartY > cy + 48) {
						System.out.println("vniz");
						Moving.dvizvniz();
					} else {
						flag = -4;
						cy = StartY - 48;
					}
				}
			}

		}

		if (mouse_pressed == true) {
			if (StartX / sizex == 4 && StartY / sizey == 9 && (cx + 32) / sizex == 5 && (cy + 50) / sizey == 9) {
				FightBoard.main(null);
				mouse_pressed = false;
			}

			if (StartY / sizey == 14 && StartX / sizex == 21 && (cx + 32) / sizex == 21 && (cy + 48) / sizey == 13) {
				karta = 2;
				cx = 400;
				cy = 400;

			}
		}

	}

	public void run() {
		ind = 1;
		flag = 1;
		// TODO Auto-generated method stub
	}
}
