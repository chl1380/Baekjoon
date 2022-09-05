import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String str1 = br.readLine();
        String str2 = br.readLine();
        
        int[][] dp = new int[str2.length()+1][str1.length()+1]; // 맨 앞의 줄들을 0으로 준다.
        
        for (int i=1; i<=str2.length(); i++) {
            for (int j=1; j<=str1.length(); j++) {
                if (str2.charAt(i-1)==str1.charAt(j-1)&&dp[i-1][j]==dp[i][j-1]) { // 하나씩 비교하여 그 값이 같고 dp의 값도 같으면
                    dp[i][j] = dp[i-1][j-1]+1; // 이전 앞의 값의 +1한 값을 넣어준다.
                    
                } else { // 다르다면
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]); // 왼쪽값과 윗값중 더 큰 값을 넣어준다.
                }
            }
        }
        System.out.println(dp[str2.length()][str1.length()]);
    }
}