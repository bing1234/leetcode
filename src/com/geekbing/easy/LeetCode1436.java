package com.geekbing.easy;

import java.util.*;

/**
 * @author bing
 */
public class LeetCode1436 {
    public String destCity(List<List<String>> paths) {
        Set<String> visited = new HashSet<>();
        Set<String> notVisited = new HashSet<>();

        for (List<String> path : paths) {
            // 开始城市已经访问了
            visited.add(path.get(0));
            notVisited.remove(path.get(0));

            // 终点城市
            if (visited.contains(path.get(1))) {
                notVisited.remove(path.get(1));
            } else {
                notVisited.add(path.get(1));
            }
        }
        return (String) notVisited.toArray()[0];
    }

    public String destCityV2(List<List<String>> paths) {
        Set<String> visited = new HashSet<>();

        for (List<String> path : paths) {
            // 开始城市已经访问了
            visited.add(path.get(0));
        }

        for (List<String> path : paths) {
            if (!visited.contains(path.get(1))) {
                return path.get(1);
            }
        }
        return "";
    }

    public static void main(String[] args) {
        LeetCode1436 leetCode1436 = new LeetCode1436();

        List<List<String>> case1 = new ArrayList<>();
        case1.add(new ArrayList<>(Arrays.asList("London", "New York")));
        case1.add(new ArrayList<>(Arrays.asList("New York", "Lima")));
        case1.add(new ArrayList<>(Arrays.asList("Lima", "Sao Paulo")));

        List<List<String>> case2 = new ArrayList<>();
        case2.add(new ArrayList<>(Arrays.asList("B", "C")));
        case2.add(new ArrayList<>(Arrays.asList("D", "B")));
        case2.add(new ArrayList<>(Arrays.asList("C", "A")));

        List<List<String>> case3 = new ArrayList<>();
        case3.add(new ArrayList<>(Arrays.asList("A", "Z")));

        System.out.println(leetCode1436.destCityV2(case1));
        System.out.println(leetCode1436.destCityV2(case2));
        System.out.println(leetCode1436.destCityV2(case3));
    }
}
