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

    static class Node{
        int dist, index;

        public Node(int index, int dist){
            this.dist = dist;
            this.index = index;
        }
    }

    static class Element implements Comparable<Element>{
        int dist, index;

        public Element(int dist, int index){
            this.dist = dist;
            this.index = index;
        }

        @Override
        public int compareTo(Element e){
            return this.dist - e.dist;
        }
    }

    public static ArrayList<Node>[] graph;
    public static PriorityQueue<Element> pq = new PriorityQueue<>();
    public static int[] dist;
    public static int N,M;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        int k = sc.nextInt();

        graph = new ArrayList[N + 1];
        dist = new int[N + 1];
        Edge[] edges = new Edge[M + 1];

        for (int i = 1 ; i <= M ; i ++){
            edges[i] = new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt());
        }

        for (int i = 0 ; i < N + 1 ; i ++){
            graph[i] = new ArrayList<>();
        }

        for (int i = 1 ; i <= M ; i ++){
            int x = edges[i].x;
            int y = edges[i].y;
            int z = edges[i].z;

            graph[x].add(new Node(y,z));
            graph[y].add(new Node(x,z));
        }

        for (int i = 1 ; i <= N ; i ++){
            dist[i] = (int) 1e9;
        }

        dist[k] = 0;

        pq.add(new Element(0,k));

        while(!pq.isEmpty()){
            int minDist = pq.peek().dist;
            int minIndex = pq.peek().index;
            pq.poll();

            if(minDist != dist[minIndex]) continue;

            for (int j = 0 ; j < graph[minIndex].size() ; j ++){
                int targetIndex = graph[minIndex].get(j).index;
                int targetDist = graph[minIndex].get(j).dist;

                int newDist = dist[minIndex] + targetDist;

                if(dist[targetIndex] > newDist){
                    dist[targetIndex] = newDist;
                    pq.add(new Element(newDist, targetIndex));
                }
            }
        }

        for (int i = 1 ; i <= N ; i ++){
            if (dist[i] == (int) 1e9) System.out.println(-1);
            else System.out.println(dist[i]);
        }
    }
}