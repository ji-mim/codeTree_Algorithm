import java.io.*;
import java.util.*;

public class Main {
    static class Edge{
        int x, y, z;

        public Edge(int x, int y, int z){
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    public static int N,M;
    public static int[] dist;
    public static boolean[] visited;
    public static int[][] graph;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dist = new int[N + 1];
        visited = new boolean[N + 1];
        graph = new int[N + 1][N + 1];
        Edge[] edges = new Edge[M + 1];

        for (int i = 1 ; i <= M ; i ++){
            st = new StringTokenizer(br.readLine());
            edges[i] = new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }

        for (int i = 1 ; i <= M ; i ++){
            int x = edges[i].x;
            int y = edges[i].y;
            int z = edges[i].z;

            graph[x][y] = z;
        }

        for (int i = 1 ; i <= N ; i ++){
            dist[i] = (int)1e9;
        }

        dist[1] = 0;

        for (int i = 1 ; i <= N ; i ++){
            int minIndex = -1 ;
            for (int j = 1 ; j <= N ; j ++){
                if(visited[j]) continue;

                if(minIndex == -1 || dist[j] < dist[minIndex]){
                    minIndex = j;
                }
            }

            visited[minIndex] = true;

            for (int j = 1 ; j <= N ; j ++){
                if(graph[minIndex][j] == 0) continue;

                dist[j] = Math.min(dist[j], dist[minIndex] + graph[minIndex][j]);
            }
        }

        for (int i = 2 ; i < N + 1 ; i ++){
            if (dist[i] == (int)1e9) System.out.println(-1);
            else System.out.println(dist[i]);
        }

    }
}