import com.mathsystem.api.graph.model.Graph;
import com.mathsystem.api.graph.model.Vertex;
import com.mathsystem.api.graph.model.Edge;
import com.mathsystem.domain.graph.repository.GraphType;
import com.mathsystem.domain.plugin.plugintype.GraphProperty;

import java.util.*;

public class VertexColoring3Periodic implements GraphCharacteristic {
    @Override
    public boolean is3Periodic(Graph graph) {
        // Проходим по всем вершинам графа
        for (Vertex vertex : graph.getVertices()) {
            // Создаем множество для хранения цветов соседей текущей вершины
            Set<String> colors = new HashSet<>();
            // Проходим по всем ребрам, связанным с текущей вершиной
            for (Edge edge : vertex.getEdges()) {
                // Получаем соседнюю вершину
                Vertex neighbor = edge.getOtherVertex(vertex);
                // Добавляем цвет соседней вершины в множество
                colors.add(neighbor.getColor());
                // Если в множестве более двух цветов, то раскраска не является 3-периодической
                if (colors.size() > 3) {
                    return false;
                }
            }
        }
        // Если все вершины прошли проверку, то раскраска является 3-периодической
        return true;
    }
}