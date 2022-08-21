import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public class CycleFinder {

    private List<Cycle> cycles = new ArrayList<>();

    public List<Cycle> findCycles(Graph g) {

        g.purge();
        while (!g.getNodes().isEmpty()) {
            findCycle(g.getNodes().get(0), new ArrayList<>());
            g.purge();
        }

        return cycles;
    }

    public boolean findCycle(Node visiting, List<Node> visitedPath) {

        int i = visitedPath.indexOf(visiting);
        if (i == -1) {
            visitedPath.add(visiting);
            Optional<Node> next = visiting.next();
            return next.filter(nextNode -> findCycle(nextNode, visitedPath)).isPresent();
        } else {
            List<Node> cycleNodes = visitedPath.stream().skip(i).collect(Collectors.toList());
            cycles.add(new Cycle(cycleNodes));
            return true;
        }
    }


}
