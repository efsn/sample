package cn.elmi.sample.structure;

/**
 * @version 1.0
 * @authur Arthur
 */
public class DFS {

    final private static int[][] cities = {{0, 2, -1, -1, 10}, {-1, 0, 3, -1, 7}, {4, -1, 0, 4, -1}, {-1, -1, -1, 0, 5}, {-1, -1, 3, -1, 0}};

    private int min = 100;

    private int[] record = {0, 0, 0, 0, 0};

    private int dest;

    public DFS(int dest) {
        this.dest = dest;
    }

    public void dfs(int current, int len) {

        // 当前路径比之前找到的最短大
        if (len > min) {
            return;
        }

        if (current == dest) {
            if (len < min) {
                min = len;
                return;
            }
        }

        for (int i = 0; i < dest; i++) {
            if (cities[current - 1][i] != -1 && record[i] == 0) {
                record[i] = 1;
                dfs(i + 1, len + cities[current - 1][i]);
                record[i] = 0;
            }
        }


    }

    public int getMin() {
        return min;
    }


    public static void main(String[] args) {
        DFS n = new DFS(3);
        n.dfs(1, 0);
        System.out.println(n.getMin());
    }

}
