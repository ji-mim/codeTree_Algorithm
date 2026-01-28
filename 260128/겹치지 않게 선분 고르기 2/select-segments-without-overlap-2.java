import java.util.*;


class Line implements Comparable<Line>{
    int x;
    int y;
    public Line(int x, int y){
        this.x = x; 
        this.y = y;
    }
    @Override
    public int compareTo(Line l){
        return Integer.compare(this.x, l.x);
    }
}


public class Main {

    public static int N;
    public static int[] dp;
    public static List<Line> lines = new ArrayList<>();

    public static void main(String[] args) {
        // x좌표를 기준으로 정렬을 하고, 앞에서부터 가능한걸 선택해볼까
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        dp = new int[N];
        for (int i = 0 ; i < N ; i ++){
            lines.add(new Line(sc.nextInt(), sc.nextInt()));
        }

        Collections.sort(lines);

        int start = 0; 
        for (int i = 0 ; i < N; i ++){
            if (lines.get(i).x == lines.get(0).x){
                dp[i] = 1;
                start = i;
            }else{
                break;
            }
        }


        for (int i = start + 1 ; i < N ; i ++){
            for (int j = 0 ; j < i ; j ++){
                if (dp[j] == 0){
                    continue;
                }

                if(lines.get(j).y < lines.get(i).x){  // y가 x보다 작아야 함  
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int ans = 0 ;
        for (int i = 0 ; i < N ; i ++){
            ans = Math.max(ans, dp[i]);
        }

        System.out.println(ans);

    }
}