import java.util.*;
import java.io.*;

public class Main {
    public static int N, M;
    public static int[] money;
    public static int[] dp;
    public static int INT_MIN = -Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dp = new int[M + 1];
        money = new int[N + 1];
        
        st = new StringTokenizer(br.readLine());

        for (int i = 1 ; i <= N ; i ++){
            money[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0 ; i <= M ; i ++){
            dp[i] = INT_MIN;
        }

        dp[0] = 0 ; 

        for (int i = 1 ; i <= M ; i ++){
            for (int j = 1 ; j <= N ; j ++){
                if(i >= money[j]){
                    if(dp[i - money[j]] == INT_MIN) continue;

                    dp[i] = Math.max(dp[i], dp[i - money[j]] + 1);
                }
            }
        }

        if (dp[M] == INT_MIN){
            System.out.println(-1);
        }else{
            System.out.println(dp[M]);
        }

    }
}