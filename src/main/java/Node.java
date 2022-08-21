import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
public class Node {

    private String name;

    private int count = 1;

    private List<Node> linkTo = new ArrayList<>();

    private List<Node> linkedBy = new ArrayList<>();


    public Node(String name) {
        this.name = name;
    }

    public void link(Node node) {
        linkTo.add(node);
        node.linkedBy.add(this);
    }

    public int getInDegree() {
        return this.linkedBy.size();
    }

    public int getOutDegree() {
        return this.linkTo.size();
    }

    public Optional<Node> next() {
        if(this.linkTo.isEmpty()){
            return Optional.empty();
        }
        return Optional.of(this.linkTo.get(0));
    }

    public void deCount() {
        this.count--;
    }

    public void printLinked() {
        String collect = linkTo.stream().map(Node::getName).collect(Collectors.joining(", "));
        if (count == 1) {
            System.out.printf("%s -> %s%n", this.name, collect);
        } else {
            System.out.printf("%s (%d) -> %s%n", this.name, this.count, collect);
        }
    }

    @Override
    public String toString() {
        return this.name;
    }
}
