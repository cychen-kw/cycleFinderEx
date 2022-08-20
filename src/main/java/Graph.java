import com.google.common.collect.Lists;
import com.opencsv.CSVReader;
import lombok.Data;
import lombok.SneakyThrows;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Data
public class Graph {

    private List<Node> allNodes;

    private Set<Cycle> cycles;

    public Graph(Node... nodes) {
        this.allNodes = Arrays.stream(nodes).sorted(Comparator.comparing(Node::getName)).collect(Collectors.toList());
    }

    public Graph(List<Node> nodes) {
        this.allNodes = nodes.stream().sorted(Comparator.comparing(Node::getName)).collect(Collectors.toList());
    }

    public void printGraph() {
        System.out.println("Graph:");
        for (Node n : allNodes) {
            n.printLinked();
        }
    }

    public Set<Cycle> findAllCycles() {
        cycles = Collections.synchronizedSet(new HashSet<>());

        List<Node> collect = allNodes.parallelStream().peek(n -> {
            System.out.println("find target node:" + n);
            for (Node v : n.getLinkedNodes()) {
                findTarget(v, n, Collections.emptyList());
            }
        }).collect(Collectors.toList());
//        for (Node n : allNodes) {
//            for (Node v : n.getLinkedNodes()) {
//                findTarget(v, n, Collections.emptyList());
//            }
//        }

        return cycles;
    }

    private void findTarget(Node current, Node target, List<Node> visited) {

        //System.out.println("current: " + current);
        ArrayList<Node> newVisited = new ArrayList<>(visited);
        newVisited.add(current);

        if (current.equals(target)) {
            cycles.add(new Cycle(newVisited));
            //System.out.println(cycles);
            return;
        }

        for (Node next : current.getLinkedNodes()) {
            if (!visited.contains(next)) {
                findTarget(next, target, newVisited);
            }
        }

    }

    @SneakyThrows
    public static Graph readCsv(String filePath) {
        List<List<String>> lines = new ArrayList<>();
        try (CSVReader csvReader = new CSVReader(new FileReader(filePath));) {
            String[] values = null;
            while ((values = csvReader.readNext()) != null) {
                lines.add(Arrays.asList(values));
            }
        }

        Map<String, Node> nodeMap = new HashMap<>();
        for (List<String> line : lines) {
            String sourceName = line.get(0).trim();
            if (sourceName.isEmpty()) {
                break;
            }
            Node srcNode = new Node(sourceName);
            nodeMap.put(sourceName, srcNode);
        }

        for (List<String> line : lines) {
            String sourceName = line.get(0).trim();
            Node srcNode = nodeMap.get(sourceName);
            for (int i = 1; i < line.size(); i++) {
                String name = line.get(i);
                if (name.isEmpty()) {
                    break;
                }
                Node node = nodeMap.get(name);
                if(node != null){
                    srcNode.link(node);
                }
            }
        }

        return new Graph(Lists.newArrayList(nodeMap.values()));
    }

}
