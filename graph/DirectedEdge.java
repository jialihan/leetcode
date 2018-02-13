package leeeeeeee.graph;


public class DirectedEdge {
    protected int src;
    protected int dest;  // destination
    protected int weight;


    public DirectedEdge(int from, int to, int weight)
    {
        this.src = from;
        this.dest = to;
        this.weight = weight;
    }

    public int getSrc()
    {
        return this.src;
    }

    public int getDest(){
        return this.dest;
    }
    public int getWeight()
    {
        return this.weight;
    }

    @Override
    public String toString()
    {
        return  src + "->" + dest + " " + String.format("w: %d", weight);
    }
} // end class Ege