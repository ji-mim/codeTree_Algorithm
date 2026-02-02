import java.util.*;
import java.io.*;

public class Main {
    public static int N, M;
    public static int[] dp;
    public static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nums = new int[N + 1];
        dp = new int[M + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1 ; i <= N ; i ++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = 1; 
        for (int i = 1 ; i <= N ; i ++){
            for (int j = M ; j >= 0 ; j --){
                if (j >= nums[i]){
                    dp[j] = Math.max(dp[j], dp[j - nums[i]]);
                }
            }
        }

        if(dp[M] == 1){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }



    }
}