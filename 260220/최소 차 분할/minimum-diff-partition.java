import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int total = 0 ;
        for (int i = 1 ; i <= N ; i ++){
            nums[i] = Integer.parseInt(st.nextToken());
            total += nums[i];
        }

        int INF_MIN = Integer.MIN_VALUE;

        int[] dp = new int[total + 1];

        for (int i = 0 ; i <= total ; i ++){
            dp[i] = INF_MIN;
        }

        dp[0] = 0;

        for (int i = 1 ; i <= N ; i ++){
            for (int j = total ; j >= 0 ; j --){
                if(j >= nums[i]){
                    if(dp[j - nums[i]] == INF_MIN) continue;

                    dp[j] = Math.max(dp[j], dp[j - nums[i]] + 1);
                }
            }
        }
        int ans = Integer.MAX_VALUE; 
        for (int i = 1 ; i < total ; i ++){
            if(dp[i] == INF_MIN) continue;
            ans = Math.min(ans, Math.abs(i - (total - i)));
        }

        System.out.println(ans);




        // 전체 합까지의 dp를 구해두고 쭉 돌면서 전체 합과 값이 있는 곳의 차..???
    }
}