package leeeeeeee.graph;

import cc150.chapter03_07.chapter04_tree.title4_01.DirectedGraph;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class BellmanFord {

    /**
     *
     * 该实现读入边和节点的列表，并向两个数组（distance和predecessor）中写入最短路径信息

     // 步骤1：初始化图
         for each vertex v in vertices:
             if v is source then distance[v] := 0
             else distance[v] := infinity
             predecessor[v] := null

     // 步骤2：重复对每一条边进行松弛操作
     for i from 1 to size(vertices)-1:
        for each edge (u, v) with weight w in edges:
             if distance[u] + w < distance[v]:
             distance[v] := distance[u] + w
             predecessor[v] := u

     // 步骤3：检查负权环
     for each edge (u, v) with weight w in edges:
        if distance[u] + w < distance[v]:
            error "图包含了负权环"
     */

    private static int[] distances;
    private static int[] predecessors; // prev vertix of each node


        public static String printSourcePath(int v)
        {
            StringBuilder s = new StringBuilder();
            String newline = System.getProperty("line.separator");
            s.append( "From vertex " + v + ": " + newline);
            for (int i = 0; i < distances.length; i++) {
                    s.append(v + "->" + i + " dist: " + distances[i] + newline);
            }
            return s.toString();
        }

        public  static void  BellmanFord(DirectedGraphWithWeight g, int src) {    /*total time O(|V|*|E| */

            // Step1：初始化图 init
            distances = new int[g.getNum_V()];
            predecessors = new int[g.getNum_V()];
            Arrays.fill(distances, Integer.MAX_VALUE);
            Arrays.fill(predecessors, -1); // no predecessor
            distances[src] = 0;

            // Step2: Upate V-1 times with all Edges : O( (|V|-1 )*|E|)
            for (int v = 1; v <= g.getNum_V() - 1; v++)
                for (DirectedEdge e : g.getAllEdges()) {
                    if (distances[e.getDest()] > distances[e.getSrc()] + e.getWeight()) {
                        // update
                        distances[e.getDest()] = distances[e.getSrc()] + e.getWeight();
                        predecessors[e.getDest()] = e.getSrc();
                    }
                }

            // Step 3:  scan all edges  or each v's adj edges
            //          to check negative circle : O(|E|)

            for (DirectedEdge e : g.getAllEdges()) {
                if (distances[e.getDest()] > distances[e.getSrc()] + e.getWeight()) {
                    // find negative circle
                    g.setHas_negative_circle(true);
                    return;
                }
            }
            return;
        }


    public static void main(String args[]){
        int n, m, v, w, weight;
//        Scanner sc = new Scanner(System.in);
//        n = sc.nextInt();
//        m = sc.nextInt();
//        dist = new long[n];
//        prev = new long[n];
        DirectedGraphWithWeight g = new DirectedGraphWithWeight(5);
        g.addEdge(0,4,8);
        g.addEdge(0,3,5);
        g.addEdge(0,1,2);
        g.addEdge(0,2,1);
        g.addEdge(1,2,1);
        g.addEdge(1,4,2);
        g.addEdge(1,3,1);
        g.addEdge(2,3,6);
        g.addEdge(3,4,2);

        for(DirectedEdge e: g.getAllEdges())
        {
            System.out.println("");
        }
        System.out.println(g.toString());
        BellmanFord(g,0);

        System.out.println(printSourcePath(0));
    }

}  // end B-F algorithm class
