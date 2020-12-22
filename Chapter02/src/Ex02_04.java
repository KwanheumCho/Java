import java.io.IOException;
import java.util.Scanner;
public class Ex02_04 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		int a, b;
		int result;
		
		Scanner s = new Scanner(System.in);
		System.out.print("첫번째 값 => ");
		a = s.nextInt();
		System.out.print("두번째 값 => ");
		b = s.nextInt();
		System.out.print("계산할 연산을 선택하세요 => (덧셈: + , 뺄셈: -, 나눗셈: /) ");
		char c = (char)System.in.read();
		/*
		try {
			c = (char)System.in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/	

		if(c == '+') {
			result = a + b;
			System.out.println(a + "+" + b + "=" + result);
		} else if(c== '-') {
			result = a - b;
			System.out.println(a + "-" + b + "=" + result);
		}
		else if(c== '/') {
			if(b==0) System.out.println("0으로는 나눌 수 없습니다.");
			else {
				result = a / b;
				System.out.println(a + "/" + b + "=" + result);
			}
		}
		
	}

}
