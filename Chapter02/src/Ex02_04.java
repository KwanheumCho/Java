import java.io.IOException;
import java.util.Scanner;
public class Ex02_04 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		int a, b;
		int result;
		
		Scanner s = new Scanner(System.in);
		System.out.print("ù��° �� => ");
		a = s.nextInt();
		System.out.print("�ι�° �� => ");
		b = s.nextInt();
		System.out.print("����� ������ �����ϼ��� => (����: + , ����: -, ������: /) ");
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
			if(b==0) System.out.println("0���δ� ���� �� �����ϴ�.");
			else {
				result = a / b;
				System.out.println(a + "/" + b + "=" + result);
			}
		}
		
	}

}
