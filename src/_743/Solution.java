package _743;

import java.util.LinkedList;

/**
 * Author: reiserx
 * Date:2019/3/6
 * Des: Network Delay Time-动态规划
 * TODO 未通过测试
 */
public class Solution {

    private LinkedList<Edge> adj[];

    private int v;


    public class Vertex {
        public int id;
        public int dist;

        public Vertex(int id, int dist) {
            this.id = id;
            this.dist = dist;
        }
    }

    public static class DirWGraph {
        public LinkedList<Edge> adj[];
        private int v;

        public DirWGraph(int v) {
            this.v = v;
            this.adj = new LinkedList[v];
            for (int i = 0; i < v; ++i) {
                this.adj[i] = new LinkedList<>();
            }
        }

        public void addEdge(int s, int t, int w) { // 添加一条边
            this.adj[s].add(new Edge(s, t, w));
        }
    }

    public static class Edge {
        public int sid;
        public int tid;
        public int w;

        public Edge(int sid, int tid, int w) {
            this.sid = sid;
            this.tid = tid;
            this.w = w;
        }
    }


    private class PriorityQueue {
        private Vertex[] nodes;
        private int count;

        public PriorityQueue(int v) {
            this.nodes = new Vertex[v + 1];
            this.count = v;
        }

        public Vertex poll() {
            int v = Integer.MIN_VALUE;
            int index = -1;
            for (int i = 0; i < count; i++) {
                if (nodes[i] != null && nodes[i].dist > v) {
                    index = i;
                    v = nodes[i].dist;
                }

            }
            Vertex vertex = nodes[index];
            nodes[index] = null;
            return vertex;
        }

        public void add(Vertex vertex) {
            nodes[vertex.id] = vertex;
        }


        public void update(Vertex vertex) {
            nodes[vertex.id].dist = vertex.dist;
        }

        public boolean isEmpty() {
            for (Vertex v : nodes) {
                if (v != null) {
                    return false;
                }
            }
            return true;
        }


    }

    /**
     * 从顶点 s 到顶点 t 的最短路径
     *
     * @param s
     */
    public int dijkstra(int s) {
        Vertex[] vertexes = new Vertex[this.v];
        for (int i = 0; i < this.v; ++i) {
            vertexes[i] = new Vertex(i, Integer.MIN_VALUE);
        }
        PriorityQueue queue = new PriorityQueue(this.v);
        boolean[] inqueue = new boolean[this.v];
        vertexes[s].dist = 0;
        queue.add(vertexes[s]);
        inqueue[s] = true;
        int max = -1;
        while (!queue.isEmpty()) {
            Vertex minVertex = queue.poll();
            for (int i = 0; i < adj[minVertex.id].size(); ++i) {
                Edge e = adj[minVertex.id].get(i);
                Vertex nextVertex = vertexes[e.tid];
                if (minVertex.dist + e.w > nextVertex.dist) {
                    nextVertex.dist = minVertex.dist + e.w;
                    if (nextVertex.dist > max) {
                        max = nextVertex.dist;
                    }
                    if (inqueue[nextVertex.id]) {
                        queue.update(nextVertex);
                    } else {
                        queue.add(nextVertex);
                        inqueue[nextVertex.id] = true;
                    }
                }
            }
        }

        return max;

    }


    public int networkDelayTime(int[][] times, int N, int K) {
        DirWGraph graph = new DirWGraph(N);
        for (int i = 0; i < times.length; i++) {
            graph.addEdge(times[i][0] - 1, times[i][1] - 1, times[i][2]);
        }
        Solution dijkstra = new Solution();

        dijkstra.adj = graph.adj;
        dijkstra.v = N;

        return dijkstra.dijkstra(K - 1);
    }

    public static void main(String[] args) {


        Solution solution = new Solution();
        int[][] a = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        System.out.println(solution.networkDelayTime(a, 4, 2));

//        int[][] a1 = {{1, 2, 1}, {2, 3, 7}, {1, 3, 4}, {2, 1, 2}};
//        System.out.println(solution.networkDelayTime(a1, 3, 1));

//                int[][] a1 = {{1, 2, 1}, {2, 3, 2}, {1, 3, 2}};
//        System.out.println(solution.networkDelayTime(a1, 3, 1));

    }

}
