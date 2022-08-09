import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static char[][] field; // 전면전
	static int N,M; // 입력값
	static int bPower, wPower, bCnt,wCnt; // 위력/연결된병사수
	static boolean[][] visited; // 방문 처리
	static int[] dy = {-1,1,0,0}; // 4방탐색
	static int[] dx = {0,0,-1,1};
	

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		field = new char[M][];
		visited = new boolean[M][N];
		
		for (int i = 0; i < M; i++) {
			field[i] = br.readLine().toCharArray();
		}
		
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				bCnt=0; // 새로운 좌표를 갈때마다 초기화
				wCnt=0;
				if(field[i][j]=='B'&&!visited[i][j]) { // 적군일 경우
					
					dfs_B(i,j);
					
					bPower+=bCnt*bCnt;
				}
				else if(field[i][j]=='W'&&!visited[i][j]){ // 아군일 경우
					dfs_W(i,j);
					
					wPower+=wCnt*wCnt;
				}
			}
		}
		System.out.println(wPower+" "+bPower);

	}
	static void dfs_B(int y, int x) { // 적군일 경우
		visited[y][x] = true;
		bCnt++;
		for (int i = 0; i < 4; i++) { // 4방 탐색
			int ny = y+dy[i];
			int nx = x+dx[i];
			
			if(ny<0||nx<0||ny>=M||nx>=N) continue; 
			if(field[ny][nx]!='B'||visited[ny][nx]) continue;
			
			dfs_B(ny,nx); // 조건 만족시 다시 dfs
		}
	}
	static void dfs_W(int y, int x) { // 아군일 경우
		visited[y][x] = true;
		wCnt++;
		for (int i = 0; i < 4; i++) { // 4방 탐색
			int ny = y+dy[i];
			int nx = x+dx[i];
			
			if(ny<0||nx<0||ny>=M||nx>=N) continue;
			if(field[ny][nx]!='W'||visited[ny][nx]) continue;
			
			dfs_W(ny,nx);
		}
	}
}