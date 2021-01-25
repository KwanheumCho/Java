import java.util.Scanner;

public class boj1003 {
	public static void main(String[] args) {
		//fibo(N) 호출시 0과 1 횟수
		Scanner sc = new Scanner(System.in);
		int[] arr_zero = new int[41];
		int[] arr_one = new int[41];
		//N == 0
		arr_zero[0] = 1;
		arr_one[0] = 0;
		//N == 1
		arr_zero[1] = 0;
		arr_one[1] = 1;
		for(int i=2; i<=40; i++) {
			arr_zero[i] = arr_zero[i-1] + arr_zero[i-2];
			arr_one[i] = arr_one[i-1] + arr_one[i-2];
		}
		
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		for(int t=0; t<T; t++) {
			int input = sc.nextInt();
			sb.append(arr_zero[input]).append(" ").append(arr_one[input]).append("\n");
			//System.out.println(arr_zero[input]+" "+arr_one[input]);
		}
		System.out.println(sb);
	}
}
