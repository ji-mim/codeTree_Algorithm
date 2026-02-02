import java.util.*;
import java.io.*;

public class Main {
    public static int N, M;
    public static int[] arr;
    public static int[] dp;
    public static int INT_MAX = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N + 1];
        dp = new int[M + 1];

        st = new StringTokenizer(br.readLine());

        for (int i = 1 ; i <= N ; i ++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0 ; i <= M ; i ++){
            dp[i] = INT_MAX;
        }

        dp[0] = 0 ;

        for (int i = 1 ; i <= N ; i ++){
            for (int j = M ; j >= 0 ; j --){
                if(j >= arr[i]){
                    if(dp[j - arr[i]] == INT_MAX) continue;
                    dp[j] = Math.min(dp[j], dp[j - arr[i]] + 1);
                }
            }
        }

        if(dp[M] != INT_MAX){
            System.out.println(dp[M]);
        }else{
            System.out.println("-1");
        }


    }
}