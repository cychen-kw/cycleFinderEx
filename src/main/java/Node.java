import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class Node {

    private String name;

    private List<Node> linkedNodes;

    public Node(String name) {
        this.name = name;
        this.linkedNodes = new ArrayList<>();
    }

    public void link(Node node) {
        linkedNodes.add(node);
    }

    public void printLinked() {
        String collect = linkedNodes.stream().map(Node::getName).collect(Collectors.joining(", "));
        System.out.printf("%s->%s%n", this.name, collect);
    }

    @Override
    public String toString(){
        return this.name;
    }
}
