package BOJ;

import java.util.Scanner;

public class BOJ_1699_제곱수의합 {

	public static void main(String[] args) {
		/*
		 * dp[1]=1^1 ->1
		 * dp[2]=1^1+1^1 ->2
		 * dp[3]=1^1+1^1+1^1 ->3
		 * dp[4]=2^2    --- 1^1+1^1+1^1+1^1 vs 2^2 ->4 vs 1
		 * 
		 */
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int[] dp=new int[N+1];
		for(int i=1;i<=N;i++) { //1+1+1+1
			dp[i]=i;
		}
		
		for(int i=2;i<=N;i++) {
			for(int j=2;j*j<=i;j++) {
				dp[i]=Math.min(dp[i], dp[i-j*j]+1);
			}
		}
		System.out.println(dp[N]);
	}

}
