package leeeeeeee.graph;

import java.util.ArrayList;

public class DirectedGraphWithWeight {


        protected int num_V; // number of vertex
        protected int num_E; // number of edge
        protected ArrayList<DirectedEdge>[] adj;
        protected  boolean has_negative_circle = false;
        protected   ArrayList<DirectedEdge> edgeList = new ArrayList<>();

        public DirectedGraphWithWeight(int v)
        {
            this.num_V = v;
            this.num_E = 0;
            adj = (ArrayList<DirectedEdge>[]) new ArrayList[num_V];
            for(int i = 0; i< num_V;i++)
            {
                adj[i] = new ArrayList<>();
            }
        }

        public int getNum_V()
        {
            return this.num_V;
        }

        public int getNum_E()
        {
            return this.num_E;
        }

        public boolean getHas_negative_circle()
        {
            return this.has_negative_circle;
        }

        public void setHas_negative_circle(boolean flag)
        {
            this.has_negative_circle = flag;
        }

        public void addEdge(int from, int to, int w)
        {
            num_E++;
            DirectedEdge e = new DirectedEdge(from, to, w);
            adj[from].add(e);
            edgeList.add(e);
        }

        public Iterable<DirectedEdge> getAdjEdges(int v)
        {
            if(v< 0 || v>=this.num_V)
                throw new IndexOutOfBoundsException();
            return adj[v];
        }


        public Iterable<DirectedEdge> getAllEdges()
        {
            return edgeList;
        }


        public String toString() {
            StringBuilder s = new StringBuilder();
            String newline = System.getProperty("line.separator");
            s.append(num_V + " vertices, " + num_E + " edges " + newline);
            for (int i = 0; i < num_V; i++) {
                s.append(String.format("Vertex %d:  ", i));
                for (DirectedEdge e : adj[i]) {
                    s.append(e + ",  ");
                }
                s.delete(s.length() - 3, s.length());
                s.append(newline);
            }
            return s.toString();
        }
}