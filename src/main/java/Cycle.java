import lombok.Data;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Data
public class Cycle {

    private List<Node> nodes;

    public Cycle(List<Node> nodes) {
        this.nodes = nodes;
    }

    @Override
    public String toString() {
        return "cycle: " + nodes.stream().map(Node::getName).collect(Collectors.joining(" -> "));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cycle cycle2 = (Cycle) o;

        String str1 = this.nodes.stream().map(Node::getName).sorted().collect(Collectors.joining());
        String str2 = cycle2.nodes.stream().map(Node::getName).sorted().collect(Collectors.joining());

        return Objects.equals(str1, str2);
    }

    @Override
    public int hashCode() {
        if (this.nodes == null) {
            return 0;
        }
        String nodeString = this.nodes.stream().map(Node::getName).sorted().collect(Collectors.joining());
        return Objects.hash(nodeString);
    }

}
