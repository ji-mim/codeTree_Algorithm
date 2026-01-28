import java.util.*;

public class Main {
    public static int N, M; 
    public static int [][] arr ; 
    public static int [][] dp ;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 맨 윗줄, 맨 왼쪽 줄은 0, 기억자 반대 형태로 쭉 돌면서 dp를 돌면 될 것 같은데 

        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[N][M];

        for (int i = 0 ; i < N ; i ++){
            for (int j = 0 ; j < M ; j ++){
                arr[i][j] = sc.nextInt();
            }
        }
        dp = new int[N][M];

        for (int i = 0 ; i < M ; i ++){
            dp[0][i] = 1;
        }
        for (int i = 0 ; i < N ; i ++){
            dp[i][0] = 1;
        }



        for (int i = 1; i < N ; i ++){
            for (int j = 1 ; j < M ; j ++){
                for (int k = 0 ; k < i ; k ++){
                    for (int l = 0 ; l < j ; l ++){
                        if(arr[k][l] >= arr[i][j]){
                            continue;
                        }

                        dp[i][j] = Math.max(dp[i][j], dp[k][l] + 1);
                    }
                }
            }
        }

        int ans = 0 ;

        for (int i = 0 ; i < N ; i ++){
            for (int j = 0 ; j < M ; j ++){
                ans = Math.max(ans, dp[i][j]);
            }
        }

        System.out.println(ans);

        
    }
}