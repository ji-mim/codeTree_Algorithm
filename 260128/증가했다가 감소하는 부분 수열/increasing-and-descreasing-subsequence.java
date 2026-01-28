import java.util.*;

public class Main {
    public static int N ;
    public static int[] upDp;
    public static int[] downDp;
    public static int[] num;

    public static void main(String[] args) {
        // 앞에서 부터 증가하는 dp랑 뒤에서부터 감소하는 dp를 두개 구해서, 합이 가장 큰값을 하면 어떨 까ㅏ나
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        num = new int[N];
        upDp = new int[N];
        downDp = new int[N];

        for (int i = 0 ; i < N ; i ++){
            num[i] = sc.nextInt();
        }

        for (int i = 0 ; i < N ; i ++){
            upDp[i] = 1;
            downDp[i] = 1;
        }

        for(int i = 1 ; i < N ; i ++){
            for (int j = 0 ; j < i ; j ++){
                if (num[i] <= num[j]) continue;

                upDp[i] = Math.max(upDp[i], upDp[j] + 1);
            }
        }

        // System.out.println(Arrays.toString(upDp));

        for(int i = N - 2 ; i >= 0 ; i --){
            for (int j = N - 1  ; j > i ; j --){
                if (num[i] <= num[j]) continue;

                downDp[i] = Math.max(downDp[i], downDp[j] + 1);
            }
        }
        // System.out.println(Arrays.toString(downDp));

        int ans = 0;
        for (int i = 0; i < N; i++) {
            ans = Math.max(ans, upDp[i] + downDp[i] - 1);
        }
        System.out.println(ans);
    }
}