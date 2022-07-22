package com.geekbing.interview;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author bing
 */
public class Interview1707 {
    public String[] trulyMostPopular(String[] names, String[] synonyms) {
        Map<String, People> nameMap = new HashMap<>();
        Map<Integer, People> indexMap = new HashMap<>();
        for (int i = 0; i < names.length; i++) {
            int idxLeft = names[i].indexOf('(');
            int idxRight = names[i].indexOf(')');
            String name = names[i].substring(0, idxLeft);
            int num = Integer.parseInt(names[i].substring(idxLeft + 1, idxRight));
            People people = new People(i, name, num);
            nameMap.put(name, people);
            indexMap.put(i, people);
        }

        for (String synonym : synonyms) {
            // 逗号分隔符的下标
            int idx = synonym.indexOf(",");
            // 前面的名字
            String firstName = synonym.substring(1, idx);
            // 后面的名字
            String secondName = synonym.substring(idx + 1, synonym.length() - 1);

            People firstPeople = nameMap.get(firstName);
            if (firstPeople == null) {
                int index = nameMap.size();
                firstPeople = new People(index, firstName, 0);
                nameMap.put(firstName, firstPeople);
                indexMap.put(index, firstPeople);
            }
            People secondPeople = nameMap.get(secondName);
            if (secondPeople == null) {
                int index = nameMap.size();
                secondPeople = new People(index, secondName, 0);
                nameMap.put(secondName, secondPeople);
                indexMap.put(index, secondPeople);
            }
        }

        UnionFind unionFind = new UnionFind(nameMap.size());

        for (String synonym : synonyms) {
            // 逗号分隔符的下标
            int idx = synonym.indexOf(",");
            // 前面的名字
            String firstName = synonym.substring(1, idx);
            // 后面的名字
            String secondName = synonym.substring(idx + 1, synonym.length() - 1);
            // 合并两个名字
            unionFind.union(nameMap.get(firstName).index, nameMap.get(secondName).index);
        }

        // 按照root分组
        Map<Integer, List<Integer>> rootMap = new HashMap<>();
        for (int i = 0; i < names.length; i++) {
            int p = unionFind.find(i);
            List<Integer> list = rootMap.getOrDefault(p, new ArrayList<>());
            list.add(i);
            rootMap.put(p, list);
        }

        String[] ans = new String[rootMap.size()];
        // 循环分组
        int idx = 0;
        for (List<Integer> indexes : rootMap.values()) {
            // 获取分组的所有人
            List<People> peoples = indexes.stream().map(indexMap::get).collect(Collectors.toList());
            // 获取字典序最小的名字
            String name = peoples.stream().map(p -> p.name).min(String::compareTo).get();
            // 获取名字对应的数量
            int num = peoples.stream().map(p -> p.num).reduce(0, Integer::sum);
            ans[idx] = name + "(" + num + ")";
            idx++;
        }
        return ans;
    }

    private static class People {
        private final int index;
        private final String name;
        private final int num;

        public People(int index, String name, int num) {
            this.index = index;
            this.name = name;
            this.num = num;
        }
    }

    private static class UnionFind {
        private final int[] parent;
        private final int[] weight;

        public UnionFind(int n) {
            this.parent = new int[n];
            this.weight = new int[n];
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
            }
            Arrays.fill(weight, 1);
        }

        private int find(int i) {
            return i == parent[i] ? i : find(parent[i]);
        }

        private void union(int i, int j) {
            int rootI = find(i);
            int rootJ = find(j);
            if (rootI != rootJ) {
                if (weight[rootI] < weight[rootJ]) {
                    parent[rootI] = rootJ;
                    weight[rootJ] += weight[rootI];
                } else {
                    parent[rootJ] = rootI;
                    weight[rootI] += weight[rootJ];
                }
            }
        }
    }

    @Test
    public void testCase1() {
        Interview1707 interview1707 = new Interview1707();
        String[] names = new String[]{"John(15)", "Jon(12)", "Chris(13)", "Kris(4)", "Christopher(19)"};
        String[] synonyms = new String[]{"(Jon,John)", "(John,Johnny)", "(Chris,Kris)", "(Chris,Christopher)"};
        String[] ans = interview1707.trulyMostPopular(names, synonyms);
        String[] expert = new String[]{"John(27)", "Chris(36)"};

        Arrays.sort(ans);
        Arrays.sort(expert);
        assert Arrays.equals(expert, ans);
    }
}
