import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution_SWEA_1223_계산기2_조관흠 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = 10;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t=1; t<=T; t++) {
			int n = Integer.parseInt(br.readLine());
			String x = br.readLine();
			Stack<Character> cs = new Stack<>();
			String change = "";
			for(int i=0; i<n; i++) { //후위 표기식으로 바꾸는 과정
				char tmp = x.charAt(i);
				if(tmp >= '0' && tmp<='9') { //피연산자
					change += tmp;
				}
				else { //연산자
					if(cs.empty()) cs.push(tmp);
					else {
						if(tmp =='+') {
							while(!cs.empty()) {
								change += cs.pop();
							}
						}
						cs.push(tmp);
					}
				}
			}//for
			//식이 끝난경우 스택에 남아있는 연산자 모두 출력
			while(!cs.empty()) {
				change += cs.pop();
			}
			
			//////////////////////
			//////////계산//////////
			//////////////////////
			Stack<Integer> is = new Stack<>();
			Queue<Character> q = new LinkedList<>();
			for(int i=0; i<change.length(); i++) {
				char tmp = change.charAt(i);
				if(tmp >= '0' && tmp<='9') {
					is.push(tmp-'0');
				}
				else {
					int a = is.pop();
					int b = is.pop();
					if(tmp == '+') {
						is.push(a+b);
					}
					else {//곱셈
						is.push(a*b);
					}
				}
			}
			System.out.println("#"+t+" "+is.peek());
		}//test case
	}
}
