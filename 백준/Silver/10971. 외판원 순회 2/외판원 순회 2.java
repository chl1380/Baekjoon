import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[] src,tgt; // 순열을 위해 사용한다.
	static int[][] path; // 경로별 비용을 가져온다
	static int min,sum,N; // 최소비용과 걸리는 비용, 도시의 수
	static boolean[] visit; // 순열에 사용할 방문처리

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		src = new int[N];
		tgt = new int[N];
		
		path = new int[N][N];
		visit = new boolean[N];
		min = Integer.MAX_VALUE;
		
		StringTokenizer st = null;
		
		for (int i = 0; i < N; i++) {
			src[i]=i;
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				path[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(perm(0)); // 순열을 돌려준다.
	}
	
	static int perm(int tgtIdx) {
		if(tgtIdx==tgt.length) { // 기저 조건
			return calcPath(tgt); // 조건 만족시 비용을 계산하는 메서드
		}
		for (int i = 0; i < src.length; i++) {
			if(visit[i]) continue;
			tgt[tgtIdx]=src[i];
			visit[i]=true;
			perm(tgtIdx+1);
			visit[i]=false;
		}
		return min;
	}
	
	static int calcPath(int[] data) {
		sum = 0;
		boolean flag = false; // 도시를 연결은 했지만 비용이 0일 경우 갈수 없다.
		for (int i = 0; i < data.length-1; i++) { // 구한 tgt에서 두개씩 가져와 그 값을 더해준다.
			if(path[data[i]][data[i+1]]==0) { // 연결은 되었지만 비용이 0인 경우
				flag = true;
				break;
			}
			sum+=path[data[i]][data[i+1]]; // 아닌경우 비용을 더해준다.
		}
		if(flag) return min; // 비용이 0인걸 만났으므로 바로 리턴한다.
		if(path[data[N-1]][data[0]]==0) { // 마지막 시작 도시를 갈때도 0인 경우를 생각해준다.
			return min;
		}else {
			sum+=path[data[N-1]][data[0]]; // 마지막으로 다시 원래 도시로 돌아갈때의 비용을 더해준다.
			min = Math.min(min, sum); // 최소를 비교한다.
			return min;
		}
	}
}