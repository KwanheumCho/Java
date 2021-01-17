import java.util.Scanner;
public class Q1291 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int start = 0 , end= 0;
		
		while(true) {
			start = sc.nextInt();
			end = sc.nextInt();
			
			if((start >=2 && start <=9) && (end >=2 && end <=9)) {
				//구구단 진행
				for(int i=1; i<=9; i++) {
					if(start > end) {
						for(int j=start; j>=end; j--) {
							if(j*i < 10) System.out.printf("%d * %d =  %d   ", j , i , j*i);
							else System.out.printf("%d * %d = %d   ", j , i , j*i);
						}
						System.out.println();
					}
					else {
						for(int j=start; j<=end; j++) {
							if(j*i < 10) System.out.printf("%d * %d =  %d   ", j , i , j*i);
							else System.out.printf("%d * %d = %d   ", j , i , j*i);
						}
						System.out.println();
						
					}
				}
				break;
			}
			else {
				System.out.println("INPUT ERROR!");
			}
			
			
			
		} // while	
	}

}
