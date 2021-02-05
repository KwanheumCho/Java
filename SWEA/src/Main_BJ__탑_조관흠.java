import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_BJ__탑_조관흠 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String x = br.readLine();
		StringTokenizer stk = new StringTokenizer(x);
		Stack<pos> s = new Stack<>();
		int[] answer = new int[N];
		for(int i=0; i<N; i++) {
			int cur = Integer.parseInt(stk.nextToken());
			if(s.empty()) {
				answer[i] = 0;
				s.push(new pos(cur, i+1));
			}
			else {
				while(!s.empty()) {
					pos cmp = s.peek();
					if(cmp.height > cur) {
						answer[i] = cmp.index;
						s.push(new pos(cur, i+1));
						break;
					}
					else {
						s.pop();
					}
				}
				if(s.empty()) {
					answer[i] = 0;
					s.push(new pos(cur, i+1));
				}
			}
		}
		for(int i=0; i<answer.length; i++) {
			System.out.print(answer[i]+" ");
		}
	}//main
}//class
class pos{
	int height;
	int index;
	public pos(int a, int b) {
		height = a;
		index= b;	
	}
}
