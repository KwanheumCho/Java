import java.util.Scanner;
public class Ex03_02 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("입력진수 결정 <1> 10, <2> 16, <3> 8 \n");
		int a = s.nextInt();
		String number;
		System.out.print("값 입력 : ");
		number = s.next();
		
		int after;
		if(a == 1) {
			//10진수
			after = Integer.parseInt(number, 10);
		}
		else if(a==2) {
			after = Integer.parseInt(number, 16);
		}
		else {
			after = Integer.parseInt(number, 8);	
		}
		System.out.printf("10진수 : %d \n", after);

		System.out.printf("16진수 : %X \n", after);

		System.out.printf("8진수 : %o \n", after);
	}

}
