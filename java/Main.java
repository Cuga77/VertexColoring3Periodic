import com.mathsystem.api.graph.GraphFactory;
import com.mathsystem.api.graph.model.Graph;

import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        GraphFactory graphFactory = new GraphFactory();
        File file = new File("graph.txt");
        Graph graph = null;
        try {
            graph = graphFactory.loadGraph(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }

        VertexColoring3Periodic checker = new VertexColoring3Periodic();
        boolean is3Periodic = checker.is3Periodic(graph);
        System.out.println("Is the graph 3-periodic? " + is3Periodic);
    }
}