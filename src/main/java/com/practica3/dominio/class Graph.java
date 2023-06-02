package pr2;

import java.util.*;

public class Graph<V> {

    // Lista de adyacencia
    private Map<V, Set<V>> adjacencyList = new HashMap<>();

    /******************************************************************
     * Añade el vertice v al grafo.
     *
     * @param v vertice a añadir.
     * @return true si no estaba anteriormente y false en caso
     * contrario.
     ******************************************************************/
    public boolean addVertex(V v) {
        if (!containsVertex(v)) {
            adjacencyList.put(v, new HashSet<>());
            return false;
        }
        return true;
    }

    /******************************************************************
     * Anade un arco entre los vertices v1 y v2 al grafo. En
     * caso de que no exista alguno de los vertices, lo añade
     * tambien.
     *
     * @param v1 el origen del arco.
     * @param v2 el destino del arco.
     * @return true si no existía el arco y false en caso
     * contrario.
     ******************************************************************/
    public boolean addEdge(V v1, V v2) {
        addVertex(v1);
        addVertex(v2);
        if (!adjacencyList.get(v1).contains(v2)) {
            adjacencyList.get(v1).add(v2);
            return false;
        }
        return false;
    }

    /******************************************************************
     * Obtiene el conjunto de vrtices adyacentes a v.
     *
     * @param v vertice del que se obtienen los adyacentes.
     * @return conjunto de vertices adyacentes.
     ******************************************************************/
    public Set<V> obtainAdjacents(V v) throws Exception {
        if (!containsVertex(v)) {
            throw new Exception("El vértice  existe en el grafo.");
        }
        return adjacencyList.get(v);
    }

    /******************************************************************
     * Comprueba si el grafo contiene el vertice dado.
     *
     * @param v vertice para el que se realiza la comprobación.
     * @return true si v es un vertice del grafo.
     ******************************************************************/
    public boolean containsVertex(V v) {
        return adjacencyList.containsKey(v);
    }

    /******************************************************************
     * Método‘toString() reescrito para la clase Grafo.java.
     * @return una cadena de caracteres con la lista de
     * adyacencia.
     ******************************************************************/
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (V v : adjacencyList.keySet()) {
            sb.append(v.toString());
            sb.append(": ");
            sb.append(adjacencyList.get(v).toString());
            sb.append("\n");
        }
        return sb.toString();
    }

    /*********************************************************
     * Obtiene, en caso de que exista, un camino entre v1 y
     * v2. En caso contrario, devuelve null.
     *
     * @param v1 el vertice origen.
     * @param v2 el vertice destino.
     * @return lista con la secuencia de vertices desde v1 hasta
     * v2 pasando por arcos del grafo.
     *********************************************************/
    public List<V> onePath(V v1, V v2){
        if (v1.equals(v2)) {
            List<V> path = new ArrayList<>();
            path.add(v1);
            return path;
        }

        Map<V, V> parents = new HashMap<>();
        Queue<V> queue = new LinkedList<>();
        queue.add(v1);

        while (!queue.isEmpty()) {
            V current = queue.poll();
            for (V neighbor : adjVertices.get(current)) {
                if (!parents.containsKey(neighbor)) {
                    parents.put(neighbor, current);
                    queue.add(neighbor);
                    if (neighbor.equals(v2)) {
                        List<V> path = new ArrayList<>();
                        V node = v2;
                        while (node != null) {
                            path.add(0, node);
                            node = parents.get(node);
                        }
                        return path;
                    }
                }
            }
        }

        return null;
    }
}

