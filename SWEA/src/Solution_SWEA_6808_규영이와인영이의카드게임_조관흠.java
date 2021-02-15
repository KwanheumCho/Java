import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_6808_규영이와인영이의카드게임_조관흠 {
	private static int T;
	private static int N;
	private static boolean[] totalCard;
	private static int[] GCard; // Gyuyoung card
	private static int[] ICard; // Inyoung Card
	private static int win;
	private static int lose;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		N = 18;
		StringBuilder sb = new StringBuilder();
		for(int t=1; t<=T; t++) {
			win = 0;
			lose = 0;
			totalCard = new boolean[N+1]; // 0 is dummy
			String x = br.readLine();
			StringTokenizer stk = new StringTokenizer(x);
			ICard = new int[N/2];
			GCard = new int[N/2];
			for(int i=0; i<9; i++) {
				int n = Integer.parseInt(stk.nextToken());
				totalCard[n] = true;
				GCard[i] = n;
			}
			//totalCard에서 true가 규영이의 카드, false가 인영이의 카드
			perm(0);
			sb.append("#").append(t).append(" ").append(win).append(" ").append(lose).append("\n");
		}
		System.out.println(sb);
	}
	static void perm(int cnt) {
		if(cnt == N/2) {
			int gscore = 0; //gyuyoung
			int iscore = 0; //inyoung
			for(int i=0; i<9; i++) {
				if(GCard[i] > ICard[i]) gscore+= GCard[i]+ICard[i];
				else iscore += GCard[i] + ICard[i];
			}
			if(gscore > iscore) win++;
			else if(gscore < iscore) lose++;
			//같으면 무승부
			return;
		}
		for(int i=1; i<=N; i++) {
			if(!totalCard[i]) {
				totalCard[i] = true;
				ICard[cnt] = i;
				perm(cnt+1);
				totalCard[i] = false;
			}
		}
	}
}
