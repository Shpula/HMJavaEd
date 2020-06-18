

import java.awt.Color;
import java.awt.Graphics;

public class Findway {

	public int[][] copy = new int[15][23];

	public Findway(int startX, int startY, int endX, int endY) {
		boolean add = true;

		int step = 0;

		for (int i = 0; i < 15; i++)
			for (int j = 0; j < 23; j++) {
				if (Field.a[i][j] == 1)
					copy[i][j] = -2;
				else
					copy[i][j] = -1;
			}
		if (Field.a[endY][endX] != 1)
			copy[endY][endX] = 0;

		while (add == true) {
			add = false;
			for (int i = 0; i < 15; i++) {
				for (int j = 0; j < 23; j++) {
					if (copy[i][j] == step) {
						if (j - 1 >= 0 && copy[i][j - 1] != -2 && copy[i][j - 1] == -1)
							copy[i][j - 1] = step + 1;
						if (i + 1 < 15 && copy[i + 1][j] != -2 && copy[i + 1][j] == -1)
							copy[i + 1][j] = step + 1;
						if (j + 1 < 23 && copy[i][j + 1] != -2 && copy[i][j + 1] == -1)
							copy[i][j + 1] = step + 1;
						if (i - 1 >= 0 && copy[i - 1][j] != -2 && copy[i - 1][j] == -1)
							copy[i - 1][j] = step + 1;
					}
				}
			}
			step++;
			add = true;
			if (copy[startY][startX] != -1)
				add = false;
			if (step > 23 * 15)
				add = false;// решение не найдено add = false;
		}

		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 23; j++) {
				if (i == startY && j == startX)
					copy[i][j] = 100;

			}

		}

	}
}