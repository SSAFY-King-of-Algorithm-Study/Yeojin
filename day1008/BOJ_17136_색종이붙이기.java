package BOJ;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_17136_색종이붙이기 {
	static class XY {
		int x;
		int y;

		public XY(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

	static int[][] Map = new int[10][10];
	static int[] paper = { 0, 5, 5, 5, 5, 5 };
	static ArrayList<XY> list = new ArrayList<>();
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				int n = sc.nextInt();
				if (n == 1) {
					list.add(new XY(i, j));
				}
				Map[i][j] = n;
			}
		}
		color(0, 0);

		if (min == Integer.MAX_VALUE) {
			System.out.println("-1");
		} else {
			System.out.println(min);
		}
	}

	private static void color(int dep, int cnt) {
		if (dep == list.size()) {
			if (min > cnt) {
				min = cnt;
			}
			return;
		}

		if (cnt > min) {
			return;
		}

		XY cur = list.get(dep);
		int cx = cur.x;
		int cy = cur.y;

		if (Map[cx][cy] == 0)
			color(dep + 1, cnt);
		for (int i = 5; i >= 1; i--) {
			if (paper[i] > 0 && isAvaliable(cx, cy, i)) {
				make(cx, cy, i, 0);
				paper[i]--;
				color(dep + 1, cnt + 1);
				paper[i]++;
				make(cx, cy, i, 1);
			}
		}
	}

	private static boolean isAvaliable(int x, int y, int leng) {
		for (int i = x; i < x + leng; i++) {
			for (int j = y; j < y + leng; j++) {
				if (i < 0 || j < 0 || i > 9 || j > 9 || Map[i][j] != 1) {
					return false;
				}
			}
		}
		return true;
	}

	private static void make(int x, int y, int leng, int value) {
		for (int i = x; i < x + leng; i++) {
			for (int j = x; j < y + leng; j++) {
				Map[i][j] = value;
			}
		}
	}

}
