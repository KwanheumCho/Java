import java.util.Scanner;
public class Ex03_02 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("�Է����� ���� <1> 10, <2> 16, <3> 8 \n");
		int a = s.nextInt();
		String number;
		System.out.print("�� �Է� : ");
		number = s.next();
		
		int after;
		if(a == 1) {
			//10����
			after = Integer.parseInt(number, 10);
		}
		else if(a==2) {
			after = Integer.parseInt(number, 16);
		}
		else {
			after = Integer.parseInt(number, 8);	
		}
		System.out.printf("10���� : %d \n", after);

		System.out.printf("16���� : %X \n", after);

		System.out.printf("8���� : %o \n", after);
	}

}
