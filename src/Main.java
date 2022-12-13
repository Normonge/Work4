import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {

        Main ex = new Main();



        Repository repo = new Repository();
        int[][] graph2 = repo.scanFileIntoGraph();

        ex.runDFS(graph2);

    }


    /*
    DFS
     */


    public void runDFS(int[][] G) {
        boolean[] visited = new boolean[G.length];

        visited[0] = true;
        dfs(G, visited, 0);


        //Go to start vertex
        //step 1: while not done;
        //Explore neighbors (look at the available adjacent vertices)
        //push neighbors onto the stack
        //pop to find next vertex
        //Repeat from that vertex
    }



    public void runBFS(int[][] G) {
        boolean[] visited = new boolean[G.length];

        visited[0] = true;
        LinkedList<Integer> Q = new LinkedList<>();
        Q.addLast(0);
        bfs(G, visited, Q);
    }

    private void dfs(int[][] G, boolean[] visited, int curr) {
        System.out.println(curr);
        //while not done
        //Explore neighbors
        for (int adj = 0; adj < G.length; adj += 1) {
            //Explore adjacent
            if (G[curr][adj] > 0 && !visited[adj]) {
                visited[adj] = true; // mark next node as visited
                //if visited is number 8, then exit the loop
                if(visited[8]){
                    break;
                }
                dfs(G, visited, adj);
            }
        }
    }//end of dfs

    /*
    BFS
     */

    private void bfs(int[][] G, boolean[] visited, LinkedList<Integer> Q) {
        System.out.println("Start BFS");

        while (!Q.isEmpty()) {
            int curr = Q.removeFirst();
            System.out.println(curr);

            //Enqueue adjacent

            for (int adj = 0; adj < G.length; adj += 1) {
                if (G[curr][adj] > 0 && !visited[adj]) {
                    visited[adj] = true;
                    Q.addLast(adj);
                }
            }

        }
    }

}
