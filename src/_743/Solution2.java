package _743;

import java.util.LinkedList;

/**
 * Author: reiserx
 * Date:2019/3/6
 * Des: Network Delay Time 回溯解法
 */
public class Solution2 {

    private static LinkedList<DirWGraph.Edge> adj[];
    private int[] timeCost;

    public class DirWGraph {
        DirWGraph(int v) {
            adj = new LinkedList[v];
            for (int i = 0; i < v; ++i) {
                adj[i] = new LinkedList<>();
            }
        }

        void addEdge(int s, int t, int w) {
            adj[s].add(new Edge(s, t, w));
        }

        class Edge {
            int sid;
            int tid;
            int w;

            Edge(int sid, int tid, int w) {
                this.sid = sid;
                this.tid = tid;
                this.w = w;
            }
        }
    }


    /**
     * @param i  结点下标
     * @param cw 当前时间延迟
     * @param n  结点总数
     */
    public void t(int i, int cw, int n) {

        if (adj[i].size() == 0) {
            return;
        }

        int size = adj[i].size();

        for (int j = 0; j < size; j++) {


            DirWGraph.Edge edge = adj[i].get(j);


            int tc = timeCost[edge.tid];
            //第一次访问结点，或用时更少
            if (tc == -1 || tc > cw + edge.w) {
                timeCost[edge.tid] = cw + edge.w;
            } else {
                continue;
            }
            int cost = cw + edge.w;
            System.out.println((edge.sid) + 1 + "----->" + (edge.tid + 1) + "===" + cost);

            t(edge.tid, cost, n);
        }

    }


    /**
     * @param times 延迟时间
     * @param N     结点个数
     * @param K     开始结点
     * @return
     */
    public int networkDelayTime(int[][] times, int N, int K) {
        DirWGraph graph = new DirWGraph(N);
        timeCost = new int[N];
        int max = -1;

        for (int i = 0; i < times.length; i++) {
            graph.addEdge(times[i][0] - 1, times[i][1] - 1, times[i][2]);
        }
        for (int i = 0; i < timeCost.length; i++) {
            timeCost[i] = -1;
        }
        timeCost[K - 1] = 0;
        t(K - 1, 0, N);
        for (int i = 0; i < timeCost.length; i++) {
            if (timeCost[i] == -1) {
                return -1;
            } else if (timeCost[i] > max) {
                max = timeCost[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {


        Solution2 solution = new Solution2();
        int[][] a = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        System.out.println(solution.networkDelayTime(a, 4, 2));

        //有环
        int[][] a1 = {{1, 2, 1}, {2, 1, 3}};
        System.out.println(solution.networkDelayTime(a1, 2, 2));

        //结点访问两次
        int[][] a2 = {{1, 2, 1}, {2, 3, 2}, {1, 3, 2}};
        System.out.println(solution.networkDelayTime(a2, 3, 1));

        //有环的结点被访问两次
        int[][] a3 = {{1, 2, 1}, {2, 3, 7}, {1, 3, 4}, {2, 1, 2}};
        System.out.println(solution.networkDelayTime(a3, 3, 1));

        //星状结构
        int[][] a4 = {{1, 5, 66}, {3, 5, 55}, {4, 3, 29}, {1, 2, 9}, {3, 4, 10}, {3, 1, 3}, {2, 3, 78}, {1, 4, 98}, {4, 5, 21}, {5, 2, 19}, {5, 1, 76}, {4, 1, 65}, {3, 2, 27}, {5, 3, 23}, {5, 4, 12}, {2, 1, 36}, {4, 2, 75}, {2, 4, 11}, {1, 3, 30}, {2, 5, 8}};
        System.out.println(solution.networkDelayTime(a4, 5, 1));

    }

}
