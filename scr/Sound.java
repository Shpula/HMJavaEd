import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class Sound {

	public static void main(String[] args) {

		try {
			FileInputStream a = new FileInputStream("sounds/logo.mp3");
			FileInputStream b = new FileInputStream("sounds/main.mp3");
			FileInputStream c = new FileInputStream("sounds/battle.mp3");

			try {
				Player player = new Player(a);
				player.play();
				
				Player player1 = new Player(b);
				player1.play();

				Player player2 = new Player(c);
				player1.play();

			} catch (JavaLayerException e) {
				e.printStackTrace();

			}
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

	}

}
