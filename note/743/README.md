[743. Network Delay Time](https://leetcode.com/problems/network-delay-time/)

**题目**

给一个 N 个结点的网络，计算从某一个结点出发信号，到全部结点收到信号的总时长。

例子:

>Input: [[2,1,1],[2,3,1],[3,4,1]]
        4
        2
>Output: 2


**思路1**

使用回溯思想。数据结构为自定义的一个带权有向的图，使用回溯算法遍历所有情况。注意情况：有环、结点访问两次、有环的结点被访问两次、有独立结点的意外情况。


代码:

``` java

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

```



