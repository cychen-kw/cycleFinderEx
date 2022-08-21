import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        Graph graph = GraphReader.readCsv("src/main/resources/event.csv");

        System.out.println("Origin graph:");
        graph.printGraph();

        CycleFinder cycleFinder = new CycleFinder();
        List<Cycle> cycles = cycleFinder.findCycles(graph);
        cycles.forEach(System.out::println);

    }

}
