import java.util.Scanner;

public class Solution_SWEA_1954_달팽이숫자_조관흠 {
	static int[][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			
			int n = sc.nextInt();
			arr = new int[n][n];
			//테두리위주로 생각해보자
			func(n, 0, 1);
			System.out.println("#"+t);
			for(int i=0;i<n; i++) {
				for(int j=0; j<n; j++) {
					System.out.print(arr[i][j]+" ");
				}
				System.out.println();
			}
		}
	}
	
	static void func(int n, int cnt, int start) {
		int row = cnt;
		int col = cnt;
		arr[row][col] = start++;
		for(int i=1; i<n; i++) {
			col += 1;
			arr[row][col] = start++;
		}
		for(int i=1; i<n; i++) {
			row += 1;
			arr[row][col] = start++;
		}
		for(int i=1; i<n; i++) {
			col -= 1;
			arr[row][col] = start++;
		}
		for(int i=1; i<n-1; i++) {
			row -= 1;
			arr[row][col] = start++;
		}
		if(n==1 || n==2) return;
		func(n-2, cnt+1, start);
	}
}
