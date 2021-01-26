import java.util.Scanner;
public class boj11047 {
	
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			int N = sc.nextInt();
			int K = sc.nextInt();
			int[] arr = new int[N];
			
			for(int i=0; i<N; i++) {
				arr[i] = sc.nextInt();
			}
			int cnt = 0;
			for(int i=N-1; i>=0; i--) {
				cnt += K/arr[i]; // 해당 동전으로 만들 수 있는 최대값 만큼 빼주는것
				K%=arr[i];
			}
			System.out.println(cnt);
			
		}

}
