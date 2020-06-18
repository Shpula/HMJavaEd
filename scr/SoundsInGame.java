import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class SoundsInGame {

	public static void main(String[] args) {

		try {
			FileInputStream a = new FileInputStream("sounds/Классика1.mp3");
			FileInputStream b = new FileInputStream("sounds/Классика.mp3");

			try {
				Player player = new Player(a);
				player.play();

				Player player1 = new Player(b);
				player1.play();

			} catch (JavaLayerException e) {
				e.printStackTrace();

			}
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

	}

}
