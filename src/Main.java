import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {

        Main ex = new Main();
        int [][] graph = ex.getExampleGraph();


Repository repo = new Repository();

System.out.println(repo.NMSCan());

System.out.println();


        ex.runDFS(graph);

    }

        private int[][] getExampleGraph(){
            int[][] G = new int[5][5];

            G[0][1] = 1;

            //just renaming to match the board
            //normally, you wouldn't do this step, but it is easier to read.
            int A = 0;
            int B = 1;
            int C = 2;
            int D = 3;
            int E = 4;

            // 12 of these


            //graph from board
            G[A][B] = 1;
            G[A][E] = 1;
            G[A][D] = 1;
            G[C][A] = 1;
            G[D][A] = 1;
            G[D][C] = 1;
            G[E][C] = 1;
            G[E][D] = 1;

            return G;
        }

        public void printGraph(int[][] graph){
            for(int i = 0; i < graph.length; i++){
                for (int j = 0; j < graph.length; j++){
                    System.out.printf("%2d", graph[i][j]);
                }
                System.out.println();
            }
            System.out.println();
        }

        /*
        DFS
         */
        public void runDFS(int[][] G) {
            boolean[] visited = new boolean[G.length];

            printGraph(G);
            visited[0] = true;
            dfs(G, visited, 0);


            //Go to start vertex
            //step 1: while not done;
            //Explore neighbors (look at the available adjacent vertices)
            //push neighbors onto the stack
            //pop to find next vertex
            //Repeat from that vertex
        }

        public void runBFS(int[][] G){
            boolean[] visited = new boolean[G.length];

            printGraph(G);
            visited[0] = true;
            LinkedList<Integer> Q = new LinkedList<>();
            Q.addLast(0);
            bfs(G, visited, Q);
        }

        private void dfs(int[][] G, boolean[] visited, int curr){
            System.out.println(curr);
            //while not done
            //Explore neighbors
            for(int adj = 0; adj < G.length; adj+=1){
                //Explore adjacent
                if(G[curr][adj] > 0 && !visited[adj]){
                    visited[adj] = true; // mark next node as visited
                    dfs(G, visited, adj);
                }
            }
        }//end of dfs

    /*
    BFS
     */

        private void bfs(int[][] G, boolean[] visited, LinkedList<Integer> Q){
            System.out.println("Start BFS");

            while(!Q.isEmpty()){
                int curr = Q.removeFirst();
                System.out.println(curr);

                //Enqueue adjacent

                for(int adj = 0; adj<G.length; adj+=1){
                    if(G[curr][adj] > 0 &&!visited[adj]){
                        visited[adj] = true;
                        Q.addLast(adj);
                    }
                }

            }
        }

    }
