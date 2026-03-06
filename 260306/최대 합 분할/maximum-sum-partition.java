import java.io.*;
import java.util.*;

public class Main {

    static final int OFFSET = 100_000;
    static int N, M;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N + 1];

        M = 0;

        for (int i = 1 ; i <= N ; i ++){
            arr[i] = Integer.parseInt(st.nextToken());
            M += arr[i];
        }

        dp = new int[N + 1][2 * M + 1 + OFFSET];

        for (int[] d : dp){
            Arrays.fill(d, -1);
        }

        dp[0][OFFSET] = 0;

        for (int i = 1 ; i <= N ; i ++){ // i번쨰까지 선택 
            for (int j = -M ; j <= M ; j ++){ // A 그룹과 B 그룹의 차가 j
                //A 그룹에 넣었을 때 
                update(i, j, i - 1, j - arr[i], arr[i]);
                //B 그룹에 넣었을 때 
                update(i, j, i - 1, j + arr[i], 0);
                //C 그룹에 넣었을 때 
                update(i, j, i - 1, j, 0);

            }
        }
        System.out.print(dp[N][0 + OFFSET]);
        
    }

    public static void update(int i , int j , int prevI, int prevJ, int val){
        if(prevJ < -M || prevJ > M || dp[prevI][prevJ + OFFSET] == -1) return;

        dp[i][j + OFFSET] = Math.max(dp[i][j + OFFSET], dp[prevI][prevJ + OFFSET] + val);
    }
}