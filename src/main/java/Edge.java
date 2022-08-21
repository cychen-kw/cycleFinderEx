import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Edge {

    private Node src;

    private Node des;

    private int priority;

}
