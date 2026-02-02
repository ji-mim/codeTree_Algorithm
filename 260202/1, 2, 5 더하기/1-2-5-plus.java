import java.util.*;
import java.io.*;

public class Main {
    public static int N;
    public static int[] dp;
    public static int[] nums = {1,2,5};


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        dp = new int[N + 1];

        dp[0] = 1;
        // dp[1] = 1 ; 

        for (int i = 1; i <= N ; i ++){
            for (int j = 0 ; j < 3 ; j ++){
                if(i >= nums[j]){
                    dp[i] += dp[i - nums[j]] % 10007;
                }
            }
        }

        System.out.println(dp[N] % 10007);




    }
}