package leeeeeeee.graph;

import cc150.chapter03_07.chapter04_tree.title4_01.DirectedGraph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * SPFA
 * SPFA 可以算作是 Bellman-Ford 的队列改进版
 * 将B-F算法的处理：直接遍历所有边edges，把该方法变成变 -> 遍历邻接表adj来实现，时间效率会更好一点，
 * procedure Shortest-Path-Faster-Algorithm(G, s)
 1    for each vertex v ≠ s in V(G)
 2        d(v) := ∞
 3    d(s) := 0
 4    offer s into Q
 5    while Q is not empty
 6        u := poll Q
 7        for each edge (u, v) in E(G)
 8            if d(u) + w(u, v) < d(v) then
 9                d(v) := d(u) + w(u, v)
 10                if v is not in Q then

 *  And check negative circle using count vertex #
 * SPFA有负权回路返回0,否则返回 1 并且最短路径保存在dis[]
 *
 * 由于最短路最长只含有∣V∣−1条边，因此如果任何一个顶点已经出队∣V∣+1次，算法停止运行。
 * */

/*  Shortest Path Faster Algorithm  */
public class SPFA {


    private static int[] distances;
    private static int[] predecessors; // prev vertix of each node
    private static int[] count_v;


//    public static String printSourcePath(int v)
//    {
//        StringBuilder s = new StringBuilder();
//        String newline = System.getProperty("line.separator");
//        s.append( "From vertex " + v + ": " + newline);
//        for (int i = 0; i < distances.length; i++) {
//            s.append(v + "->" + i + " dist: " + distances[i] + newline);
//        }
//        return s.toString();
//    }

     public  static int  SPFA(DirectedGraphWithWeight g, int src) {    /*total time O(k*|E|, usually k << 2 */

        // Step1：初始化图 init
        int V = g.getNum_V();
        distances = new int[V];
        predecessors = new int[V];
        count_v = new int[V];  // initial is 0  -> to terminate a negative circle
        Arrays.fill(distances, Integer.MAX_VALUE);
        Arrays.fill(predecessors, -1); // no predecessor
        distances[src] = 0;

        Queue<Integer> q  = new LinkedList<>();  // store the vertex # of nodes
        q.offer(src);

        // Step2: Upate existing vertex with its Adjacent Edges: adj[v]
        while(!q.isEmpty())
        {
            int cur = q.poll();
            for(DirectedEdge e: g.getAdjEdges(cur))
            {
                if(distances[e.getDest()] > distances[e.getSrc()] + e.getWeight()) {
                       distances[e.getDest()] = distances[e.getSrc()] + e.getWeight();
                       predecessors[e.getDest()] = e.getSrc();
                }
                // queue the next vertex in adj[v]
                if(!q.contains(e.getDest())) {
                    q.offer(e.getDest());
                   /* terminate negative circle when cnt_V >= V+1 */
                   if( ++count_v[e.getDest()] > V)
                   {
                       return 0; // exist negative circle, and terminate
                   }
                }
            }
        } // end while

        return 1;  //  success to find a shortest path
    }

}
