import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int MIN_INF = Integer.MIN_VALUE;

        int[]dp = new int[M + 1];
        int[]weights = new int[N + 1];
        int[]values = new int[N + 1];

        for (int i = 1 ; i <= N ; i ++){
            st = new StringTokenizer(br.readLine());
            weights[i] = Integer.parseInt(st.nextToken());
            values[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0 ; i <= M ; i ++){
            dp[i] = MIN_INF;
        }

        dp[0] = 0;

        for (int i = 1 ; i <= M ; i ++){
            for (int j = 1 ; j <= N ; j ++){
                if(i >= weights[j]){
                    if(dp[i - weights[j]] == MIN_INF) continue;

                    dp[i] = Math.max(dp[i], dp[i - weights[j]] + values[j]);
                }
            }
        }

        int ans = 0 ;
        for (int i = 1 ; i <= M ; i ++){
            ans = Math.max(ans, dp[i]);
        }

        System.out.println(ans);
    }
}