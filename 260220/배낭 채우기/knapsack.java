import java.io.*;
import java.util.*;


public class Main {

    public static int INF = (int) 1e9;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<int[]> vals = new ArrayList<>();

        for (int i = 0 ; i < N ; i ++){
            st = new StringTokenizer(br.readLine());
            vals.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())}); // w, v
        }

        int[] dp = new int[M + 1];

        for (int i = 0 ; i <= M ; i ++){
            dp[i] = - (int) 1e9;
        }
        dp[0] = 0;

        for (int i = 0 ; i < N ; i ++){
            for (int j = M ; j >= 0 ; j --){
                if(j >= vals.get(i)[0]){

                    if(dp[j - vals.get(i)[0]] == -INF) continue;

                    dp[j] = Math.max(dp[j], dp[j - vals.get(i)[0]] + vals.get(i)[1]);


                }
            }
        }

        int ans = 0 ;
        for (int v : dp){
            if(v != INF){
                ans = Math.max(ans, v);
            }
        }
        System.out.println(ans);
    


        
    }
}