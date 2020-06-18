

public class Moving {
	static int i = 0;
	static int j = 0;

	public static void dvizxpravo() {
		Field.count =0 ;
		Field.flag = 1;
		Field.cx += 7.5;
		if (Field.cx + 32 >= Field.StartX) {
			Field.flag = 2;
			Field.cx = Field.StartX - 32;
			Field.mouse_clicked = false;
		}

	}


	public static void dvizxvlevo() {
		Field.count =0 ;
		Field.flag = -1;
		Field.cx -= 7.5;
		if (Field.cx + 32 <= Field.StartX) {
			Field.flag = -2;
			Field.cx = Field.StartX - 32;
			Field.mouse_clicked = false;
		}
	}

	public static void dvizvverh() {
		Field.flag = 3;
		Field.cy -= 5.5;
		Field.count++;
		if (Field.cy + 48 <= Field.StartY  && Field.StartY - Field.cy + 48 < 8) {
			Field.flag = 4;
			Field.cy = Field.StartY - 48;
			Field.mouse_clicked = false;
		}
	}
	
	
	public static void dvizvniz() {
		Field.count =0 ;
		Field.flag = -3;
		Field.cy += 5.5;
		if (Field.cy + 48 >= Field.StartY &&  - Field.cy + 48 - 	Field.StartY < 8 ) {
			Field.flag = -4;
			Field.cy = Field.StartY - 48;
			Field.mouse_clicked = false;
		}

	}
}
