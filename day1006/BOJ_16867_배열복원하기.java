package BOJ;

import java.util.Scanner;

public class BOJ_16867_배열복원하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int H = sc.nextInt();
		int W = sc.nextInt();
		int X = sc.nextInt();
		int Y = sc.nextInt();
		int[][] A = new int[H][W];
		int[][] B = new int[H + X][W + Y];
		for (int i = 0; i < H + X; i++) {
			for (int j = 0; j < W + Y; j++) {
				B[i][j] = sc.nextInt();
			}
		}
		for (int i = 0; i < H + X; i++) {
			for (int j = 0; j < W + Y; j++) {
				// 이동했어도 변하지 않은 부분 킵(행)
				if (i < X && j < W) {
					A[i][j] = B[i][j];
				}
				// 이동했어도 변하지 않은 부분 킵(열)
				if (i < H && j < Y) {
					A[i][j] = B[i][j];
				}
				// 변한 부분은 겹친 값을 빼서 복원
				if (i < H && j < W && i >= X && j >= Y) {
					A[i][j]=B[i][j]-A[i-X][j-Y];
				}

			}
		}
		for(int i=0;i<H;i++) {
			for(int j=0;j<W;j++)
			{
				System.out.print(A[i][j]+" ");
			}
			System.out.println();
		}
	}

}
