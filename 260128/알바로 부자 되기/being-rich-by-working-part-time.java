import java.util.*;

class Work implements Comparable<Work>{
    int x, y, money;

    public Work(int x, int y, int money){
        this.x = x;
        this.y = y; 
        this.money = money;
    }

    @Override
    public int compareTo(Work w){
        return Integer.compare(this.x, w.x);
    }
}

public class Main {
    public static int N; 
    public static int[] dp; 
    public static List<Work> works = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        dp = new int[N];

        for (int i = 0 ; i < N ; i ++){
            works.add(new Work(sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }

        Collections.sort(works);

        for (int i = 0 ; i < N ; i ++){
            dp[i] = works.get(i).money;
        }

        for (int i = 0 ; i < N ; i ++){
            for (int j = 0 ; j < i ; j ++){
                if (works.get(j).y > works.get(j).x) continue;

                dp[i] = Math.max(dp[i], dp[j] + works.get(i).money);
            }
        }

        int ans = 0 ; 
        for (int i = 0 ; i < N ; i ++){
            ans = Math.max(ans, dp[i]);
        }

        System.out.println(ans);
        

    }
}