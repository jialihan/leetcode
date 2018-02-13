package leeeeeeee.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 *
 Ⅱ. 我们换个思路考虑，遍历所有边，一边遍历一边将当前边加入到图中。如果我们发现，有一条边[u,v]还未曾加入到图中时，u和v就已经通过其他若干边相连，那么这就是我们要找的“多余”的边。
 Ⅲ. 如果我们还是用dfs去判断u和v的连通性，那么是O(n)的时间复杂度，总的时间复杂度仍是O(n^2)。这里我们就要用到一种数据结构叫做并查集，可以在常数时间内两个元素是否在同一集合（查询操作）和把两个元素合并到同一个集合（合并操作）。在并查集中，每个集合都有一个代表元素，我们称之为祖先。
 Ⅳ. 并查集的初始化：在最初的时候，根节点都是自己，我们用一个数组parent[i]=i来表示这个关系。
 Ⅴ. 并查集的查询操作：每次给边的时候判断两个点的祖先节点，我们不停地通过调用parent函数向上寻找直到parent[i]==i
 Ⅵ. 给出一条边，两个节点设置为l ,r 如果祖先节点father_l, father_r 不相同，说明此时l和r不向连，这条边信息有用（不是一条多余的边），我们就通过并查集的合并操作将他们连在一起。具体操作需要将祖先节点接在一起，令parent[father_r]=father_l。
 Ⅶ. 路径压缩优化：在做查询操作的时候我们将parent[now] = find_father(parent[now])，是为了压缩路径，因为一旦两棵树合并，其中一些节点不是直接指向根节点的，不合并每次搜索会浪费大量时间
 Ⅷ. 我们认为总的时间复杂度是O(n)，其中使用了路径压缩的并查集的常数非常小可以忽略
 Ⅸ. 虽然题目强调如果有多个答案输出最后一条，但用上述方法只会找到一条“多余”的边，所以代码中是从前往后遍历所有边

 作者：九章算法
 链接：https://juejin.im/post/5a4accb3518825089e504e4b
 来源：掘金
 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 */

public class FindRedundentConnectionEdge {

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int parent[] = new int[n+1]; // base on index 1;
        for(int i = 0 ; i<= n; i++)
        {
            parent[i] = i; // set to itself at the beginning
        }

        int parent_l, parent_r;
        for(int[] e : edges)
        {
            parent_l = findparent(parent,e[0]);
            parent_r = findparent(parent, e[1]);
            if(parent_l == parent_r)
            {
                // circle detected
                return e; // return current edge
            }
            parent[parent_l] = parent_r;
        }

        //if not found
        return new int[2];

    }

    public int findparent(int[] parent, int i)
    {
        if(i != parent[i])
        {
            // find the root parent
            parent[i] = findparent(parent, parent[i]);
        }

        return parent[i];
    }

    /**
     *  use dfs, detect a circle
     */

    public int[] findRedundantConnection_dfs(int[][] edges) {

        Map<Integer, HashSet<Integer>> map = new HashMap<>();

        for(int[] e: edges)
        {
            if(hasCircle(e[0],e[1],map, -1))
                return e;
            // process node e[0]
            if(map.containsKey(e[0]))
                map.get(e[0]).add(e[1]);
            else
            {
                HashSet<Integer> set = new HashSet<>();
                set.add(e[1]);
                map.put(e[0],set);
            }
            // process node e[1]
            if(map.containsKey(e[1]))
                map.get(e[1]).add(e[0]);
            else
            {
                HashSet<Integer> set = new HashSet<>();
                set.add(e[0]);
                map.put(e[1],set);
            }
        } // end for
        return new int[2];
    }

    public boolean hasCircle(int cur, int target, Map<Integer,HashSet<Integer>> map, int prev)
    {
        // prev is to detect the 1->2, 2->1 the undirected node number
        if(!map.containsKey(cur))
            return false;
        if(map.get(cur).contains(target))
            return true;
        for(int next : map.get(cur))
        {
            //traverse the adjacent set
            if(prev == next)
            {
                // if the next node has already been traversed ,then not go in
                continue;
            }
            // if another route also through cur to next to target, then circle detected
            if(hasCircle(next, target, map, cur))  // prev = cur
                return true;
        }  // end for adj set
        return false;
    }
}
