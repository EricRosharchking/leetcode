public class NumberofOperationstoMakeNetworkConnected {
    public static void main(String[] args) {
        int n = 5;
        int[][] connections = {{0,1},{0,2},{3,4},{1,2}};

        System.out.println(makeConnections(n, connections));
    }

    public static int makeConnections(int n, int[][] connections) {
        int[] nodes = new int[n];
        if (connections.length < n - 1) {
            return -1;
        }
        for  (int[] edge: connections) {
            nodes[edge[0]] = 1;
            nodes[edge[1]] = 1;
        }
        for (int i: nodes) {
            n -= i;
        }
        return n;
    }
}
