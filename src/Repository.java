import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class Repository {

    public int[][] scanFileIntoGraph(){
        int[][] graph = new int[13][13];
        try {
            //example_graph.txt
            File file = new File("example_graph.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            String st;
            int i = 0;
            //skip 2 lins
            br.readLine();
            br.readLine();
            while ((st = br.readLine()) != null) {
                String[] split = st.split(" ");
                for (int j = 0; j < split.length; j++) {
                    graph[i][j] = Integer.parseInt(split[j]);
                }
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return graph;
    }




}
