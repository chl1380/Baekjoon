import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M, K, MAX, COUNT; // 입력값
	static int[][] trash; // 음식물의 위치
	static boolean[][] select; // 연결되는 음식물들 확인
	static int[] dy = {0,0,-1,1}; // 4방 탐색
	static int[] dx = {-1,1,0,0};
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		// 입력
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		trash = new int[N+1][M+1];
		select = new boolean[N+1][M+1];
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			trash[r][c] = 1; // 음식물 위치에 1로 위치 표시
		}
		
		for (int i = 1; i < N+1; i++) {
			for (int j = 1; j < M+1; j++) {
				if(!select[i][j]&&trash[i][j]==1) { // 처음부터 돌면서 음식물이고 보지않은 음식물인지 확인
					COUNT=0;
					dfs(i,j); // 깊이 우선 탐색
					MAX = Math.max(MAX, COUNT); // 나온 결과를 MAX값과 비교
				}
					
			}
		}
		System.out.println(MAX);
	}
	static void dfs(int y, int x) { // 4방 탐색을  하면서 조건을 만족시 다시 깊이 우선 탐색
		select[y][x] = true;
		COUNT++;
		for (int i = 0; i < 4; i++) {
			int ny = y+dy[i];
			int nx = x+dx[i];
			if(ny<1||nx<1||ny>=N+1||nx>=M+1||select[ny][nx]||trash[ny][nx]==0) continue;
			dfs(ny,nx);
		}
	}

}
