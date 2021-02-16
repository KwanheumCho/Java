import java.util.Scanner;

public class boj2839 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int factor = N / 5 ;
		int answer = 0;
		for(int i=factor; i>=0; i--) {
			if( (N - i*5) % 3 == 0) {
				answer = (N - i*5) / 3 + i;
				break;
			}
		}
		if(answer == 0) System.out.println(-1);
		else System.out.println(answer);
	}
}
