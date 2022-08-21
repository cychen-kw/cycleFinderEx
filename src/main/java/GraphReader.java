import com.google.common.collect.Lists;
import com.opencsv.CSVReader;
import lombok.SneakyThrows;
import org.apache.commons.io.input.BOMInputStream;
import org.apache.commons.lang3.StringUtils;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class GraphReader {

    @SneakyThrows
    public static Graph readCsv(String filePath) {
        List<List<String>> lines = new ArrayList<>();

        try (CSVReader csvReader = new CSVReader(new InputStreamReader(new BOMInputStream(new FileInputStream(filePath))))) {
            String[] values = null;
            while ((values = csvReader.readNext()) != null) {
                lines.add(Arrays.stream(values).map(String::trim).filter(StringUtils::isNotEmpty).collect(Collectors.toList()));
            }
        }

        Map<String, Node> nodeMap = new HashMap<>();

        for (List<String> line : lines) {
            String string = line.get(0);

            int count = 1;
            String[] split = string.split("\\*");
            String src = split[0];

            if(split.length == 2){
                count = Integer.parseInt(split[1]);
            }

            Node node = nodeMap.computeIfAbsent(src, Node::new);
            node.setCount(count);

            for (int i = 1; i < line.size(); i++) {
                Node neighbor = nodeMap.computeIfAbsent(line.get(i), Node::new);
                node.link(neighbor);
            }
        }

        return new Graph(Lists.newArrayList(nodeMap.values()));
    }

}
