import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N, M; // 집합S의 개수와 비교할 문자열의 개수
		int cnt = 0; // 포함되는 문자열의 개수
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		HashSet<String> set = new HashSet<>(); // set을 이용한다.
		
		for (int i = 0; i < N; i++) { // 집합 S의 문자열들을 set에 담아준다.
			set.add(br.readLine());
		}
		for (int i = 0; i < M; i++) { // 비교할 문자열을 하나씩 set에 비교한다.
			if(set.contains(br.readLine())) {
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}

}