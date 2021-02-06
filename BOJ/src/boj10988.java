import java.util.Scanner;
import java.util.Stack;

public class boj10988 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String x = sc.next();
		int len = x.length();
		//Solution 1. index로 비교
		//level 같은 홀수
		//abba 같은 짝수
		/*if(len%2 !=0) {
			int gap = len/2;
			for(int i=1; i<=gap; i++) {
				if(x.charAt(len/2 - i) != x.charAt(len/2+i)) {
					System.out.println(0);
					return;
				}
			}
		}//홀수
		else {
			int gap = len/2;
			for(int i=0; i<gap; i++) {
				if(x.charAt(len/2-1 - i) != x.charAt(len/2+i)) {
					System.out.println(0);
					return;
				}
			}
		}
		System.out.println(1);*/
		
		//Solution2.  자료구조 활용
		Stack<Character> s = new Stack<>();
		for(int i=0; i<len; i++) {
			s.push(x.charAt(i));
		}
		
		for(int i=0; i<len; i++) {
			if(x.charAt(i) != s.pop()) {
				System.out.println(0);
				return;
			}
		}
		System.out.println(1);
	}
}
