import java.util.Scanner;
public class Ex02_03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a, b;
		int result;
		
		Scanner s = new Scanner(System.in);
		System.out.print("첫번째 값 => ");
		a = s.nextInt();
		System.out.print("두번째 값 => ");
		b = s.nextInt();
		System.out.print("계산할 연산을 선택하세요 => (덧셈:1 , 뺄셈:2 ");
		int c = s.nextInt();
		if(c == 1) {
			result = a + b;
			System.out.println(a + "+" + b + "=" + result);
		} else if(c==2) {
			result = a - b;
			System.out.println(a + "-" + b + "=" + result);
		}
		
	}

}
