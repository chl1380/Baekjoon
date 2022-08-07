import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[][] chess = new char[8][];
		
		int horseCnt = 0;
		
		for (int i = 0; i < 8; i++) {
			chess[i] = br.readLine().toCharArray();
		}
		
		for (int i = 0; i < 8; i++) {
			if(i%2 == 0) {
				for (int j = 0; j < 8; j++) {
					if(j%2==0&&chess[i][j]=='F') {
						horseCnt++;
					}
				}
			}else {
				for (int j = 0; j < 8; j++) {
					if(j%2==1&&chess[i][j]=='F') {
						horseCnt++;
					}
				}
			}
		}
		System.out.println(horseCnt);

	}

}