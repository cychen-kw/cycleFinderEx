import com.rits.cloning.Cloner;
import lombok.Data;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class GraphTest {
    private Cloner cloner = new Cloner();
    private List<List<String>> circleResult = new LinkedList<>();

    // label, {wanted, count}
    private Map<String, CountDto> nodeMap;

    @Test
    public void test() {
        List<List<String>> nodeList = new LinkedList<>();
        nodeList.add(Stream.of("1_1", "16_1", "30_1", "37_1", "19_3", "19_1").collect(Collectors.toList()));
        nodeList.add(Stream.of("1_2", "8_6", "23_1", "18_1", "19_3", "19_1").collect(Collectors.toList()));
        nodeList.add(Stream.of("1_3", "36_1", "4_9", "11_1", "19_3", "19_1").collect(Collectors.toList()));
        nodeList.add(Stream.of("1_4", "18_2", "35_1", "28_1", "19_3", "19_1").collect(Collectors.toList()));
        nodeList.add(Stream.of("1_4", "18_2", "35_1", "28_1", "19_3", "19_1").collect(Collectors.toList()));
        nodeList.add(Stream.of("1_5", "8_6", "9_1", "19_2", "19_3", "19_1").collect(Collectors.toList()));
        nodeList.add(Stream.of("1_6", "4_7", "8_6", "20_7", "19_3", "19_1").collect(Collectors.toList()));
        nodeList.add(Stream.of("1_7", "4_7", "8_6", "24_2", "19_3", "19_1").collect(Collectors.toList()));
        nodeList.add(Stream.of("10_1", "18_1", "18_2", "19_3", "20_4", "19_1", "13_4").collect(Collectors.toList()));
        nodeList.add(Stream.of("10_10", "23_1", "19_3", "20_4", "19_1", "13_4", "1_5").collect(Collectors.toList()));
        nodeList.add(Stream.of("10_11", "23_1", "19_3", "20_4", "19_1", "13_4", "1_5").collect(Collectors.toList()));
        nodeList.add(Stream.of("10_2", "23_1", "19_3", "20_4", "19_1", "13_4", "1_5").collect(Collectors.toList()));
        nodeList.add(Stream.of("10_3", "23_1", "19_3", "20_4", "19_1", "13_4", "1_5").collect(Collectors.toList()));
        nodeList.add(Stream.of("10_4", "23_1", "19_3", "20_4", "19_1", "13_4", "1_5").collect(Collectors.toList()));
        nodeList.add(Stream.of("10_5", "23_1", "19_3", "20_4", "19_1", "13_4", "1_5").collect(Collectors.toList()));
        nodeList.add(Stream.of("10_6", "23_1", "19_3", "20_4", "19_1", "13_4", "1_5").collect(Collectors.toList()));
        nodeList.add(Stream.of("10_7", "23_1", "19_3", "20_4", "19_1", "13_4", "1_5").collect(Collectors.toList()));
        nodeList.add(Stream.of("10_8", "14_1", "23_1", "20_4", "19_1", "13_4", "1_5").collect(Collectors.toList()));
        nodeList.add(Stream.of("10_9", "23_1", "19_3", "20_4", "19_1", "13_4", "1_5").collect(Collectors.toList()));
        nodeList.add(Stream.of("11_1", "21_3", "21_3", "25_1", "21_2", "19_3").collect(Collectors.toList()));
        nodeList.add(Stream.of("12_1", "17_3", "36_1", "18_1", "3_1", "10_1").collect(Collectors.toList()));
        nodeList.add(Stream.of("12_10", "17_3", "6_4", "3_1", "18_1", "10_1").collect(Collectors.toList()));
        nodeList.add(Stream.of("12_11", "18_1", "36_1", "6_4", "26_1", "10_1").collect(Collectors.toList()));
        nodeList.add(Stream.of("12_12", "18_1", "36_1", "6_4", "26_1", "10_1").collect(Collectors.toList()));
        nodeList.add(Stream.of("12_13", "18_1", "36_1", "6_4", "26_1", "10_1").collect(Collectors.toList()));
        nodeList.add(Stream.of("12_14", "3_1", "36_1", "6_4", "26_1", "10_1").collect(Collectors.toList()));
        nodeList.add(Stream.of("12_15", "3_1", "36_1", "6_4", "26_1", "10_1").collect(Collectors.toList()));
        nodeList.add(Stream.of("12_16", "8_3", "36_1", "6_4", "26_1", "10_1").collect(Collectors.toList()));
        nodeList.add(Stream.of("12_2", "17_3", "36_1", "18_1", "3_1", "10_1").collect(Collectors.toList()));
        nodeList.add(Stream.of("12_3", "17_3", "36_1", "18_1", "3_1", "10_1").collect(Collectors.toList()));
        nodeList.add(Stream.of("12_4", "17_3", "36_1", "18_1", "3_1", "10_1").collect(Collectors.toList()));
        nodeList.add(Stream.of("12_5", "17_3", "36_1", "18_1", "3_1", "10_1").collect(Collectors.toList()));
        nodeList.add(Stream.of("12_6", "17_3", "6_4", "3_1", "18_1", "10_1").collect(Collectors.toList()));
        nodeList.add(Stream.of("12_7", "17_3", "6_4", "3_1", "18_1", "10_1").collect(Collectors.toList()));
        nodeList.add(Stream.of("12_8", "17_3", "6_4", "3_1", "18_1", "10_1").collect(Collectors.toList()));
        nodeList.add(Stream.of("12_9", "17_3", "6_4", "3_1", "18_1", "10_1").collect(Collectors.toList()));
        nodeList.add(Stream.of("13_1", "20_1", "25_1", "18_1", "9_1", "15_1").collect(Collectors.toList()));
        nodeList.add(Stream.of("13_2", "18_1", "23_1", "9_1", "20_7", "20_1").collect(Collectors.toList()));
        nodeList.add(Stream.of("13_3", "9_1", "25_1", "20_7", "20_1", "23_1").collect(Collectors.toList()));
        nodeList.add(Stream.of("13_4", "23_1", "15_1", "20_7", "9_1", "1_1").collect(Collectors.toList()));
        nodeList.add(Stream.of("14_1", "1_1", "1_2", "11_1", "20_3", "36_1", "20_2", "13_4", "10_8", "17_3", "19_3", "31_2").collect(Collectors.toList()));
        nodeList.add(Stream.of("15_1", "33_3", "23_1", "36_1", "20_5", "1_5", "35_2").collect(Collectors.toList()));
        nodeList.add(Stream.of("15_2", "33_3", "23_1", "36_1", "20_5", "1_5", "35_2").collect(Collectors.toList()));
        nodeList.add(Stream.of("16_1", "23_1", "20_2", "20_3", "9_1", "25_1").collect(Collectors.toList()));
        nodeList.add(Stream.of("17_1", "1_4", "4_9", "3_2", "9_1", "18_1").collect(Collectors.toList()));
        nodeList.add(Stream.of("17_2", "1_4", "4_9", "3_2", "18_1", "9_1").collect(Collectors.toList()));
        nodeList.add(Stream.of("17_3", "1_4", "4_9", "3_2", "9_1", "18_1").collect(Collectors.toList()));
        nodeList.add(Stream.of("17_4", "4_9", "3_2", "9_1", "18_1", "4_10").collect(Collectors.toList()));
        nodeList.add(Stream.of("18_1", "1_2", "10_1", "9_1", "7_1", "1_1").collect(Collectors.toList()));
        nodeList.add(Stream.of("18_2", "10_1", "1_2", "9_1", "7_1", "1_1").collect(Collectors.toList()));
        nodeList.add(Stream.of("18_3", "10_1", "1_2", "9_1", "7_1", "1_1").collect(Collectors.toList()));
        nodeList.add(Stream.of("19_1", "8_4", "10_1", "18_1", "3_1", "9_1").collect(Collectors.toList()));
        nodeList.add(Stream.of("19_2", "8_4", "10_1", "3_1", "9_1").collect(Collectors.toList()));
        nodeList.add(Stream.of("19_3", "1_2", "10_1", "8_4", "3_1", "9_1").collect(Collectors.toList()));
        nodeList.add(Stream.of("19_4", "1_2", "10_1", "8_4", "3_1", "9_1").collect(Collectors.toList()));
        nodeList.add(Stream.of("2_1", "24_2", "36_1", "3_1", "36_1", "36_1").collect(Collectors.toList()));
        nodeList.add(Stream.of("2_2", "17_2", "6_1", "30_1", "36_1", "24_1").collect(Collectors.toList()));
        nodeList.add(Stream.of("20_1", "18_1", "1_4", "21_1", "10_8", "31_2", "21_1", "21_2").collect(Collectors.toList()));
        nodeList.add(Stream.of("20_10", "18_1", "1_4", "21_1", "10_8", "31_2").collect(Collectors.toList()));
        nodeList.add(Stream.of("20_11", "18_1", "1_4", "21_1", "10_8", "31_2").collect(Collectors.toList()));
        nodeList.add(Stream.of("20_2", "18_1", "1_4", "21_1", "10_8", "31_2").collect(Collectors.toList()));
        nodeList.add(Stream.of("20_3", "18_1", "1_4", "21_1", "10_8", "31_2").collect(Collectors.toList()));
        nodeList.add(Stream.of("20_4", "18_1", "1_4", "21_1", "10_8", "31_2").collect(Collectors.toList()));
        nodeList.add(Stream.of("20_5", "18_1", "1_4", "21_1", "10_8", "31_2").collect(Collectors.toList()));
        nodeList.add(Stream.of("20_6", "18_1", "1_4", "21_1", "10_8", "31_2").collect(Collectors.toList()));
        nodeList.add(Stream.of("20_7", "18_1", "1_4", "21_1", "10_8", "31_2").collect(Collectors.toList()));
        nodeList.add(Stream.of("20_8", "18_1", "1_4", "21_1", "10_8", "31_2").collect(Collectors.toList()));
        nodeList.add(Stream.of("20_9", "18_1", "1_4", "21_1", "10_8", "31_2").collect(Collectors.toList()));
        nodeList.add(Stream.of("21_1", "29_1", "8_3", "30_1", "25_1", "4_1").collect(Collectors.toList()));
        nodeList.add(Stream.of("21_2", "1_1", "29_1", "36_1", "35_3", "4_10").collect(Collectors.toList()));
        nodeList.add(Stream.of("21_3", "29_1", "30_1", "18_2", "18_3", "1_1").collect(Collectors.toList()));
        nodeList.add(Stream.of("22_1", "5_1", "33_4", "8_4", "31_1", "4_7").collect(Collectors.toList()));
        nodeList.add(Stream.of("23_1", "1_2", "30_1", "1_1", "21_1", "19_3").collect(Collectors.toList()));
        nodeList.add(Stream.of("24_1", "4_1", "37_1", "29_1", "1_3", "2_2").collect(Collectors.toList()));
        nodeList.add(Stream.of("24_2", "4_1", "37_1", "29_1", "1_3", "2_2").collect(Collectors.toList()));
        nodeList.add(Stream.of("25_1", "21_1", "21_2", "21_3", "6_3", "11_1").collect(Collectors.toList()));
        nodeList.add(Stream.of("26_1", "6_1", "20_11", "37_1", "20_7", "10_1").collect(Collectors.toList()));
        nodeList.add(Stream.of("28_1", "1_4").collect(Collectors.toList()));
        nodeList.add(Stream.of("29_1", "1_2", "31_2", "10_7", "13_1", "27_2").collect(Collectors.toList()));
        nodeList.add(Stream.of("3_1", "21_1", "12_10", "21_2", "21_3").collect(Collectors.toList()));
        nodeList.add(Stream.of("3_2", "23_1", "21_2", "21_3", "30_1").collect(Collectors.toList()));
        nodeList.add(Stream.of("3_3", "21_1", "21_2", "21_3").collect(Collectors.toList()));
        nodeList.add(Stream.of("30_1", "3_2", "12_8", "35_3", "14_1", "1_1").collect(Collectors.toList()));
        nodeList.add(Stream.of("31_1", "25_1", "23_1", "1_5", "36_1", "2_1").collect(Collectors.toList()));
        nodeList.add(Stream.of("31_2", "11_1", "19_3", "17_3", "9_1", "10_8", "29_1").collect(Collectors.toList()));
        nodeList.add(Stream.of("31_3", "30_1", "33_2", "19_2", "15_1", "1_2").collect(Collectors.toList()));
        nodeList.add(Stream.of("32_1", "10_11", "36_1", "20_2", "8_5", "20_3").collect(Collectors.toList()));
        nodeList.add(Stream.of("33_1", "5_1", "23_1", "34_1", "9_1", "30_1").collect(Collectors.toList()));
        nodeList.add(Stream.of("33_2", "5_1", "23_1", "34_1", "9_1", "30_1").collect(Collectors.toList()));
        nodeList.add(Stream.of("33_3", "23_1", "5_1", "34_1", "9_1", "30_1").collect(Collectors.toList()));
        nodeList.add(Stream.of("33_4", "23_1", "5_1", "34_1", "9_1", "30_1").collect(Collectors.toList()));
        nodeList.add(Stream.of("34_1", "13_3", "6_4", "18_1").collect(Collectors.toList()));
        nodeList.add(Stream.of("34_2", "20_1", "12_1", "14_1").collect(Collectors.toList()));
        nodeList.add(Stream.of("34_3", "15_1", "13_1", "1_5").collect(Collectors.toList()));
        nodeList.add(Stream.of("35_1", "19_3", "1_5", "28_1", "20_3", "3_1").collect(Collectors.toList()));
        nodeList.add(Stream.of("35_2", "19_3", "1_5", "28_1", "20_3", "3_1").collect(Collectors.toList()));
        nodeList.add(Stream.of("35_3", "1_1", "1_2", "18_1", "37_1", "19_3").collect(Collectors.toList()));
        nodeList.add(Stream.of("35_4", "19_3", "1_5", "28_1", "20_3", "3_1").collect(Collectors.toList()));
        nodeList.add(Stream.of("35_5", "1_1", "1_2", "18_1", "37_1", "19_3").collect(Collectors.toList()));
        nodeList.add(Stream.of("36_1", "24_1", "1_4", "3_1", "1_5", "7_1").collect(Collectors.toList()));
        nodeList.add(Stream.of("37_1", "1_1", "30_1", "2_2").collect(Collectors.toList()));
        nodeList.add(Stream.of("4_1", "30_1", "25_1", "1_1", "36_1", "1_5").collect(Collectors.toList()));
        nodeList.add(Stream.of("4_10", "30_1", "25_1", "1_1", "36_1", "1_5").collect(Collectors.toList()));
        nodeList.add(Stream.of("4_2", "30_1", "25_1", "1_1", "36_1", "1_5").collect(Collectors.toList()));
        nodeList.add(Stream.of("4_3", "30_1", "25_1", "1_1", "36_1", "1_5").collect(Collectors.toList()));
        nodeList.add(Stream.of("4_4", "30_1", "25_1", "1_1", "36_1", "1_5").collect(Collectors.toList()));
        nodeList.add(Stream.of("4_5", "30_1", "25_1", "1_1", "36_1", "1_5").collect(Collectors.toList()));
        nodeList.add(Stream.of("4_6", "30_1", "25_1", "1_1", "36_1", "1_5").collect(Collectors.toList()));
        nodeList.add(Stream.of("4_7", "30_1", "25_1", "1_1", "36_1", "1_5").collect(Collectors.toList()));
        nodeList.add(Stream.of("4_8", "30_1", "25_1", "1_1", "36_1", "1_5").collect(Collectors.toList()));
        nodeList.add(Stream.of("4_9", "30_1", "25_1", "1_1", "36_1", "1_5").collect(Collectors.toList()));
        nodeList.add(Stream.of("5_1", "21_1", "18_1", "6_3", "19_3", "21_3").collect(Collectors.toList()));
        nodeList.add(Stream.of("6_1", "37_1", "21_1", "14_1", "35_2", "9_1").collect(Collectors.toList()));
        nodeList.add(Stream.of("6_2", "37_1", "1_1", "4_7", "26_1", "21_2").collect(Collectors.toList()));
        nodeList.add(Stream.of("6_3", "37_1", "21_2", "27_1", "27_2", "1_1").collect(Collectors.toList()));
        nodeList.add(Stream.of("6_4", "37_1", "1_1", "19_3", "21_2", "27_1").collect(Collectors.toList()));
        nodeList.add(Stream.of("7_1", "1_2", "34_1", "30_1", "36_1", "6_4").collect(Collectors.toList()));
        nodeList.add(Stream.of("8_1", "22_1", "23_1", "20_5", "29_1", "15_1").collect(Collectors.toList()));
        nodeList.add(Stream.of("8_2", "22_1", "23_1", "20_5", "29_1", "15_1").collect(Collectors.toList()));
        nodeList.add(Stream.of("8_3", "12_16", "23_1", "20_5", "29_1", "15_1").collect(Collectors.toList()));
        nodeList.add(Stream.of("8_4", "22_1", "23_1", "20_5", "29_1", "15_1").collect(Collectors.toList()));
        nodeList.add(Stream.of("8_5", "22_1", "23_1", "20_5", "29_1", "15_1").collect(Collectors.toList()));
        nodeList.add(Stream.of("8_6", "22_1", "23_1", "20_5", "29_1", "15_1").collect(Collectors.toList()));
        nodeList.add(Stream.of("9_1", "4_9", "4_9", "4_9", "4_9", "4_9").collect(Collectors.toList()));
        nodeList.add(Stream.of("27_1", "29_1", "6_3", "6_4").collect(Collectors.toList()));
        nodeList.add(Stream.of("27_2", "29_1", "6_3", "6_4").collect(Collectors.toList()));

        //Collections.shuffle(nodeList);

        // label, {wanted, count}
       nodeMap = nodeList.stream()
                .collect(Collectors.toMap(
                        nList -> nList.get(0),
                        CountDto::new,
                        (v1, v2) -> {
                            v1.plusCount();
                            return v1;
                        }
                ));

        while (!nodeMap.isEmpty()) {
            System.out.println("before removeUnnecessaryNode:" + nodeMap.keySet());
            removeUnnecessaryNode(nodeMap);
            System.out.println("after removeUnnecessaryNode:" + nodeMap.keySet());

            List<String> pathList = new LinkedList<>();

            nodeMap.keySet().stream()
                    .findAny()
                    .ifPresent(node -> findCircle(node, pathList));
        }

        System.out.println("======================================");
        circleResult.stream()
                .map(circle -> String.join("->", circle))
                .forEach(System.out::println);
        System.out.println("======================================");
    }

    private void findCircle(String item, List<String> pathList) {
        int lastIndex = pathList.lastIndexOf(item);
        pathList.add(item);
        if (lastIndex > -1) { // visited
            List<String> circleList = pathList.subList(lastIndex, pathList.size());
            System.out.println("is circle, circleList=" + circleList);
            circleResult.add(circleList);
            removeUnnecessaryNode(circleList);
        } else {
            System.out.println("no circle, pathList=" + pathList);
            String nextItem = nodeMap.get(item).getWanted().get(0);
            findCircle(nextItem, pathList);
        }
    }

    private void removeUnnecessaryNode(List<String> circleList) {
        Set<String> circleSet = circleList.stream()
                .distinct()
                .peek(item -> {
                    if (nodeMap.containsKey(item)) {
                        nodeMap.get(item).minusCount(); // 被配對走，數量減一
                        if (nodeMap.get(item).getCount() == 0) {
                            nodeMap.remove(item); // 完全沒量了，從map中去掉
                        }
                    }
                })
                .filter(item -> !nodeMap.containsKey(item)) // 被配對完 且無數量的
                .collect(Collectors.toSet());

        Map<String, CountDto> cloneNodeMap = cloner.deepClone(nodeMap);

        // 無法配對的東西
        List<String> removeKeyList = new LinkedList<>();

        cloneNodeMap.forEach((item, countDto) -> {

            // 把無法被配對的物品刪掉
            countDto.getWanted().removeAll(circleSet);

            if (countDto.getWanted().isEmpty()) {
                // 已經換不到東西了
                nodeMap.remove(item);
                removeKeyList.add(item);
            } else {
                nodeMap.put(item, countDto);
            }
        });

        if (!removeKeyList.isEmpty()) {
            removeUnnecessaryNode(removeKeyList);
        }
    }

    private void removeUnnecessaryNode(Map<String, CountDto> nodeMap) {
        Set<String> unnecessaryNodeSet = cloner.deepClone(nodeMap.keySet());
        Set<String> necessaryNodeSet = nodeMap.values().stream()
                .map(CountDto::getWanted)
                .flatMap(List::stream)
                .collect(Collectors.toSet());
        unnecessaryNodeSet.removeAll(necessaryNodeSet);
        unnecessaryNodeSet.forEach(nodeMap::remove);
    }

    @Data
    private class CountDto {
        private List<String> wanted;
        private Long count;

        public CountDto(List<String> nList) {
            this.wanted = IntStream.range(1, nList.size()).boxed()
                    .map(nList::get)
                    .collect(Collectors.toList());
            this.count = 1L;
        }

        public void plusCount() {
            this.count++;
        }

        public void minusCount() {
            this.count--;
        }
    }
}
