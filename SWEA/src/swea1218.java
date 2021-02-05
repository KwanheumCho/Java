import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class swea1218 {
	static String left = "(<[{";
	static String right = ")>]}";
	
	public static void main(String[] args) {
		int T=10;
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
/*		String left = "(<[{";
		char x = sc.next().charAt(0);
		if(left.contains(Character.toString(x))) System.out.println(true);
		else System.out.println(false);*/
		for (int t = 1; t <= T; t++) {
			
			int answer = -1;
			Stack<String> s = new Stack<>();
			int len = sc.nextInt();
			String input = sc.next();

			for(int i=0; i<len; i++) {
				char x = input.charAt(i);
				String s_x = x+""; //효율적인 방법
				//String s_x = Character.toString(x);
				if(left.contains(s_x)) {
					s.push(s_x);
				}
				else {
					String pop_value;
					if(!s.empty()) {
						pop_value = s.pop();
						if(!equal_chk(pop_value , s_x)) { // 스택에서 뽑은값과 들어온 값이 짝이 안맞는 경우
							answer = 0;
							break;
						}
					}
					else { //스택에 값이 없는데 right 기호가 들어온경우(left < right)
						answer = 0;
						break;
					}
				}
			}//for
			// 인풋이 더이상 없는데 스택에 값이 남아있는 경우 ( left > right)
			if(!s.empty()) answer = 0;
			else answer = 1;
			
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}//testcase
		System.out.println(sb);
	}//main
	
	static boolean equal_chk(String x, String y) {
		/*if(x.equals("{") && y.equals("}")) {
			return true;
		}
		else if(x.equals("[") && y.equals("]")) {
			return true;
		}
		else if(x.equals("<") && y.equals(">")) {
			return true;
		}
		else if(x.equals("(") && y.equals(")")) {
			return true;
		}*/
		for(int i=0; i<left.length(); i++) {
			if(x.equals(Character.toString(left.charAt(i))) && y.equals(Character.toString(right.charAt(i))) ) {
				return true;
			}
		}
		return false;
	}//equal_chk
}
