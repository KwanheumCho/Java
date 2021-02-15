import java.util.Scanner;

public class Main_백준_3040_백설공주와일곱난쟁이_조관흠 {
	private static int[] number;
	private static boolean[] chk;
	private static int[] answer;
	private static boolean flag;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		number = new int[9];
		answer = new int[7];
		chk = new boolean[9];
		for(int i=0; i<9; i++) {
			number[i] = sc.nextInt();
		}
		comb(0, 0);
	}
	
	static void comb(int cnt, int sum) {
		if(flag) return;
		if(cnt == 7) {
			if(sum == 100) {
				for(int i=0; i<7; i++) {
					System.out.println(answer[i]);
				}
				flag = true;
			}
			
			return;
		}
		for(int i=0; i<9; i++) {
			if(!chk[i]) {
				chk[i] = true;
				answer[cnt] = number[i];
				comb(cnt+1, sum+number[i]);
				
				
				chk[i] = false;
				answer[cnt] = 0;
			}
		}
	}//comb
}
