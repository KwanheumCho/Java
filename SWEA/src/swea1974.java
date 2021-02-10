import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class swea1974 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		int[][] puzzle = new int[10][10]; // 0 dummy
		boolean[] chk = new boolean[10]; // 0 dummy
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t=1; t<=T; t++) {
			sb.append("#").append(t);
			for(int i=1; i<=9; i++) {
				StringTokenizer stk = new StringTokenizer(br.readLine());
				for(int j=1; j<=9; j++) {
					puzzle[i][j] = Integer.parseInt(stk.nextToken());
				}
 		}
			//input end
	//Solution1		
			Arrays.fill(chk, false);
			//row check!
			boolean flag = false;
	a:		for(int i=1; i<=9; i++) {
				for(int j=1; j<=9; j++) {
					int n = puzzle[i][j];
					if(!chk[n]) chk[n] = !chk[n];
					else {
						flag = !flag;
						break a;
					}
				}
				Arrays.fill(chk, false);
			}
			if(flag) {
				sb.append(" ").append(0).append("\n");
				continue;//Testcase continue
			}
			
			//column check!
	b:		for(int j=1; j<=9; j++) {
				for(int i=1; i<=9; i++) {
					int n = puzzle[i][j];
					if(!chk[n]) chk[n] = !chk[n];
					else {
						flag = !flag;
						break b;
					}
				}
				Arrays.fill(chk, false);
			}
			if(flag) {
				sb.append(" ").append(0).append("\n");
				continue;//Testcase continue
			}
			//box check!
	c:		for(int r=1; r<=9; r+=3) {
				for(int c=1; c<=9; c+=3) {
					for(int i=0; i<=2; i++) {
						for(int j=0; j<=2; j++) {
							int n = puzzle[r+i][r+j];
							if(!chk[n]) chk[n] = !chk[n];
							else {
								flag = !flag;
								break c;
							}
						}
					}//i,j
					Arrays.fill(chk, false);
				}
			}
			if(flag) {
				sb.append(" ").append(0).append("\n");
				continue;//Testcase continue
			}
			
			//여기까지오면 오류가 없다는걸 의미함
			sb.append(" ").append(1).append("\n");
			
		}//test case
		System.out.println(sb);
		
	}
}
