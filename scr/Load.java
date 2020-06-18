

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Load {
	 static int[][] loadArrayFromFile(String path) {
	        int[][] a = new int [15][23];
	        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
	            // � ������ 2-� ������� ����� ����� ������ ����������� �������
	           // int rows = Integer.parseInt(br.readLine());
	            //int cols = Integer.parseInt(br.readLine());
	           // a = new int[rows][cols]; // ������� ������ ������� ������ �� ������
	            // �����
	            for (int i = 0; i < 15; i++) {
	                for (int j = 0; j < 23; j++) {
	                    a[i][j] = Integer.parseInt(br.readLine());
	                }
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return a;
	    }
	}

