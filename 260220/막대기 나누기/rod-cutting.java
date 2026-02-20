import java.io.*;
import java.util.*;

public class Main {

    static int NIN_INF = - (int) 1e9;

    public static void main(String[] args) throws IOException{
        //중복이 가능한 dp 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] line = new int[N + 1];
        int[] price = new int[N + 1];
        int[] dp = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1 ; i <= N ; i ++){
            price[i] = Integer.parseInt(st.nextToken());
            line[i] = i;
        }



        for (int i = 0 ; i <= N ; i ++){
            dp[i] = NIN_INF;
        }

        dp[0] = 0;

        for (int i = 1 ; i <= N ; i ++){
            for (int j = 1 ; j <= N ; j ++){
                if(i >= line[j]){
                    if(dp[i - j] == NIN_INF) continue;

                    dp[i] = Math.max(dp[i], dp[i - j] + price[j]);
                }
            }
        }
        int ans = 0;
        for (int i = 1 ; i <= N ; i ++){
            ans = Math.max(ans, dp[i]);
        }

        System.out.println(ans);

    }
}