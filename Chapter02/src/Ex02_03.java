import java.util.Scanner;
public class Ex02_03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a, b;
		int result;
		
		Scanner s = new Scanner(System.in);
		System.out.print("ù��° �� => ");
		a = s.nextInt();
		System.out.print("�ι�° �� => ");
		b = s.nextInt();
		System.out.print("����� ������ �����ϼ��� => (����:1 , ����:2 ");
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
