import java.io.*;
import java.util.*;

public class Main {
    public static int N, M;
    public static int[] moneyList;
    public static int[] dp ;
    public static int INT_MAX = Integer.MAX_VALUE;

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st; 


    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        moneyList = new int[N + 1];
        dp = new int[M + 1];

        for (int i = 0 ; i <= M ; i ++){
            dp[i] = INT_MAX;
        }

        dp[0] = 0 ;

        st = new StringTokenizer(br.readLine());
        for (int i = 1 ; i <= N ; i ++){
            moneyList[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1 ; i <= M ; i ++){
            for (int j = 1 ; j <= N ; j ++){

                if(i >= moneyList[j]){
                    if (dp[i - moneyList[j]] == INT_MAX) continue;

                    dp[i] = Math.min(dp[i], dp[i - moneyList[j]] + 1);

                }
            }
        }

        if (dp[M] != INT_MAX){
            System.out.println(dp[M]);
        } else{
            System.out.println("-1");
        }


    }
}