import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	static int[] tgt,src;
	static int cnt;

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		src = new int[N]; // 과일의 종류
		tgt = new int[M-N]; // 무조건 한개 이상은 가지고 있어야하므로 훔쳐야할 과일에서 모든 종류의 과일 하나씩 빼준다.

		for (int i = 0; i < N; i++) {
			src[i] = i;
		}
		
		comb(0,0); // 중복조합
		System.out.println(cnt);
	}
	
	static void comb(int srcIdx, int tgtIdx) {
		if(tgtIdx == tgt.length) { // 기저조건
			cnt++;
			return;
		}
		
		for (int i = srcIdx; i < src.length; i++) { // 시작을 srcIdx부터 시작하대 같은 과일을 또 훔칠수 있으므로 다시 comb해줄때 i를 넣어준다.
			tgt[tgtIdx] = src[i];
			comb(i,tgtIdx+1);
		}
	}

}