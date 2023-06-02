import java.util.List;

public class Test {
    public static void main(String[] args) {
        Grafo<String> grafo = new Grafo<>();

        // Agregar vertices
        grafo.addVertex("A");
        grafo.addVertex("B");
        grafo.addVertex("C");
        grafo.addVertex("D");
        grafo.addVertex("E");

        // Agregar arcos
        grafo.addEdge("A", "B");
        grafo.addEdge("A", "C");
        grafo.addEdge("B", "D");
        grafo.addEdge("C", "E");
        grafo.addEdge("D", "E");

        // Buscar camino
        List<String> path = grafo.onePath("A", "E");
        if (path != null) {
            System.out.println("Camino encontrado: " + path);
        } else {
            System.out.println("No hay camino entre A y E");
        }
    }
}
