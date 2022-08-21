import lombok.Data;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class Graph {

    private List<Node> nodes;

    public Graph(Node... nodes) {
        this(Arrays.asList(nodes));
    }

    public void purge() {

        boolean notDone = true;
        while (notDone) {
            notDone = nodes.removeIf(node -> node.getLinkedBy().size() == 0 || node.getLinkTo().size() == 0 || node.getCount() == 0);
            if (notDone) {
                for (Node node : nodes) {
                    node.getLinkTo().removeIf(x -> !nodes.contains(x));
                    node.getLinkedBy().removeIf(x -> !nodes.contains(x));
                }
            }
        }
    }

    public Graph(List<Node> nodes) {
        this.nodes = nodes.stream().sorted((n1, n2) -> {
            String[] s1 = n1.getName().split("_");
            String[] s2 = n2.getName().split("_");

            if (s1[0].equals(s2[0])) {
                return Integer.parseInt(s1[1]) - Integer.parseInt(s2[1]);
            } else {
                return Integer.parseInt(s1[0]) - Integer.parseInt(s2[0]);
            }

        }).collect(Collectors.toList());
    }

    public void printGraph() {
        System.out.println("Graph:");
        for (Node n : nodes) {
            n.printLinked();
        }
    }

}
