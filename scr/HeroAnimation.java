
import javax.swing.JPanel;


public class HeroAnimation extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7380741066251687985L;
	static int userAnimation = 0;
	static int countanimation = 0;
	static boolean fight_animation = false;
	static boolean spin = false;
	public static int userhit = 35;
	private static int speed = 5;
	private static int left = -1 * speed;
	private static int right = 1 * speed;
	private static int up = -1 * speed;
	private static int down = 1 * speed;
	
	public static void anim() {
		if (spin) {
			userAnimation = 19;
			spin = false;
		}
		if (userAnimation >= 10 && Battleground.mouseX > Battleground.cx)
			userAnimation = 0;
		else if (userAnimation >= 30 && Battleground.mouseX < Battleground.cx)
			userAnimation = 19;
		userAnimation++;
	}
	
	public static void animation() {
		if (Battleground.user_step) {
			if (Battleground.countUser >= 0) {
				if (Battleground.mouseX >= Battleground.cx + 5) {
					Battleground.cx += right;
					Battleground.countUser++;
					anim();
				} else if (Battleground.mouseX <= Battleground.cx - 5) {
					Battleground.cx += left;
					Battleground.countUser++;
					anim();
				} else if (Battleground.mouseY >= Battleground.cy + 5) {
					Battleground.cy += down;
					Battleground.countUser++;
					anim();
				} else if (Battleground.mouseY <= Battleground.cy - 5) {
					Battleground.cy += up;
					Battleground.countUser++;
					anim();
				} else {
					Battleground.run_timer = false;
				}
			}
		} else {
			if (Battleground.countUser >= 0) {
				if (Battleground.mouseY >= Battleground.cy + 5) {
					Battleground.cy += down;
					Battleground.countUser++;
					anim();
				} else if (Battleground.mouseY <= Battleground.cy - 5) {
					Battleground.cy += up;
					Battleground.countUser++;
					anim();
				} else if (Battleground.mouseX >= Battleground.cx + 5) {
					Battleground.cx += right;
					Battleground.countUser++;
					anim();
				} else if (Battleground.mouseX <= Battleground.cx - 5) {
					Battleground.cx += left;
					Battleground.countUser++;
					anim();
				} else {
					Battleground.run_timer = false;
				}
			}
		}
		
		if (fight_animation) {
			countanimation++;
			if (Battleground.cx < Battle_Mob.botX)
				userAnimation = 13 + countanimation;
			else
				userAnimation = 31 + countanimation;
			if (countanimation == 6)
				Battle_Mob.botHeatPoint -= userhit;
			if (countanimation == 8) {
				fight_animation = false;
				userAnimation = 0;
				countanimation = 0;
			}
		}
	}
}
