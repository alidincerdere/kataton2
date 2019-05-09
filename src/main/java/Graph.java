import java.util.*;

public class Graph {
    List<List<Integer>> adjLst = new ArrayList<List<Integer>>();
    int size;
    public Graph(int size) {
        this.size = size;
        while(size-- > 0)//Initialize the adjancency list.
            adjLst.add(new ArrayList<Integer>());
    }

    public void addEdge(int first, int second) {
        adjLst.get(first).add(second);
        adjLst.get(second).add(first);
// For undirected graph, you gotta add edges from both sides.
    }

    public int[] shortestReach(int startId) { // 0 indexed
        int[] distances = new int[size];
        Arrays.fill(distances, -1); // O(n) space.
        Queue<Integer> que = new LinkedList<Integer>();

        que.add(startId); // Initialize queue.
        distances[startId] = 0;
        HashSet<Integer> seen = new HashSet<Integer>(); //O(n) space. Could be further optimized. I leave it to you to optimize it.

        seen.add(startId);
        while(!que.isEmpty()) { // Standard BFS loop.
            Integer curr = que.poll();
            for(int node : adjLst.get(curr)) {
                if(!seen.contains(node)) {
                    que.offer(node);
                    // Right place to add the visited set.
                    seen.add(node);
                    // keep on increasing distance level by level.
                    distances[node] = distances[curr] + 1;
                }
            }
        }
        return distances;
    }
}