import java.util.Arrays;
import java.util.Scanner;

public class boj1300 {
	public static void main(String[] args) {
		// N^2<= 100000 00000
		//128 * 1000 * 1000 => N^2의 수를 일차원 배열에 다넣으려면 공간복잡도에 문제가생길수도..
		//1 2 3
		//2 4 6
		//3 6 9
		//1 2 3 4 5
		//2 4 6 8
		//3 6 9 12
		//4 8 12 16
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] arr = new int[N*N];
		int cnt = 0;
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				arr[cnt++] = i*j;
			}
		}
		Arrays.sort(arr);
		System.out.println(arr[K]);
		
		/* 수학적 index접근으로 시도.. 실패
		 * // 대각선은 i^2
		// 그외의 값들은 i*j or j*i
		int cnt = 1; // 대각선 i의 카운트
		int total = 1;
		boolean flag = false;
		for(int i=1; i<=N; i++) {
			for(int j=i; j<=N; j++) {
				int x = i*j;
				//System.out.println(i+" "+j);
				//System.out.println(x+" "+total+" "+cnt);
				if(i==j) {
					if(cnt==i) {
						if(flag) {
							System.out.println(x);
							return;
						}
						total++;
						cnt++;
					}
				}
				else {
					if( x <= cnt*cnt) {
						if(flag) {
							System.out.println(x);
							return;
						}
						if(total<K-2) {
							total+=2;
						}
						else if(total==K-2) {
							flag = !flag;
							//System.out.println(flag);
							total+=2;
						}
						else {
							System.out.println(x);
							return;
						}
					}
					else if(x>cnt*cnt) {
						while(x>cnt*cnt) {
							if(flag) {
								System.out.println(cnt*cnt);
								return;
							}
							//대각선 처리
							if(total==K-1) {
								flag = !flag;
							}
							else if(total<K-1) {
								total++;
							}
							cnt++;
						}
						if( x <= cnt*cnt) {//굳이 없어도 되는 조건문이지만 위와 맞춤
							if(flag) {
								System.out.println(x);
								return;
							}
							if(total<K-2) {
								total+=2;
							}
							else if(total==K-2) {
								flag = !flag;
								total+=2;
							}
							else {
								System.out.println(x);
								return;
							}
						}
					}
				}
			}//for j
		}//for i
*/		
	}//main
}
