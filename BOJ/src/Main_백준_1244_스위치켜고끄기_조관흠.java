import java.util.Scanner;

public class Main_백준_1244_스위치켜고끄기_조관흠 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		s_number = sc.nextInt(); // <=100
		arr = new int[s_number+1];
		
		for(int i=1; i<= s_number; i++) { //1부터 시작
			arr[i] = sc.nextInt();
		}
		
		int student = sc.nextInt();
		
		for(int i=0; i<student; i++) {
			int gender = sc.nextInt();
			int number = sc.nextInt();
			if(gender == 1) {
				boy(number);
			}
			else {
				girl(number);
			}
		}
		
		for(int i=1; i<=s_number; i++) {
			System.out.print(arr[i]+" ");
			if(i%20 == 0) System.out.println();
		}
	}//main
	
	static int s_number; //switch_number;
	static int[] arr;
	
	static void boy(int x) {
		int factor = 2;
		int mul = x;
		while( mul <= s_number) {
			if(arr[mul] == 1) arr[mul] = 0;
			else arr[mul] = 1;
			mul = x * factor++ ;
		}
	} //boy
	
	static void girl(int x) {
		if(arr[x] == 1) arr[x] = 0;
		else arr[x] = 1;
		
		int cnt = 1;
		while(x - cnt >=1 && x + cnt <=s_number) {
				if(arr[x-cnt] == arr[x+cnt]) {
					if(arr[x-cnt] == 1) {
						arr[x-cnt] = 0;
						arr[x+cnt] = 0;
					}
					else {
						arr[x-cnt] = 1;
						arr[x+cnt] = 1;
					}
				}
				else break;
				cnt++;
		}//while
	} //girl
}
