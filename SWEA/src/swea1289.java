import java.util.Scanner;

public class swea1289 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		String input;
		for(int t=0; t<T; t++) {
			input = sc.next();
			int cnt = 0;
			char cond='0';
			for(int i=0; i<input.length(); i++) {
				if(input.charAt(i) != cond) {
					cnt++;
					if(cond == '1') cond = '0';
					else cond = '1';
				}
			}
			System.out.printf("#%d %d\n", t+1, cnt);
			
		}//for
	}
}
