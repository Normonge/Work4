import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class Repository {

    public String NMSCan() throws IOException {
        File file = new File("example_graph.txt");

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;

                while((line = reader.readLine()) != null){
                        System.out.println(line);
                }
        }

        return null;
    }




}
