import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        Graph graph = GraphReader.readCsv("src/main/resources/event.csv");

        System.out.println("Origin graph:");
        graph.printGraph();
        graph.purge();
        System.out.println("after purged:");
        graph.printGraph();

        CycleFinder cycleFinder = new CycleFinder();
        List<Cycle> cycles = cycleFinder.findCycles(graph);
        cycles.forEach(System.out::println);

//        Node a = new Node("A");
//        Node b = new Node("B");
//        Node c = new Node("C");
//        Node d = new Node("D");
//        Node e = new Node("E");
//        Node f = new Node("F");
//        Node g = new Node("G");
//
//        a.link(b, c, d);
//        b.link(f);
//        c.link(a);
//        d.link(e);
//        e.link(a, d, g);
//        f.link(b);
//        g.link(a);
//
//        Graph graph = new Graph(a, b, c, d, e, f, g);
//        graph.printGraph();
//
//        Set<Cycle> allCycles = graph.findAllCycles();
//
//        Streams.mapWithIndex(allCycles.stream(),
//                        (str, index) -> (index+1) + ": " + str)
//                .forEach(System.out::println);

    }

}
