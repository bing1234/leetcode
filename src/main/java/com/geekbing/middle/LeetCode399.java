package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author bing
 */
public class LeetCode399 {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        UnionFind unionFind = new UnionFind(equations);
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            unionFind.union(equation.get(0), equation.get(1), values[i]);
        }
        double[] ans = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            ans[i] = unionFind.getVal(query.get(0), query.get(1));
        }
        return ans;
    }

    private static class UnionFind {
        // 变量 - parent
        private final Map<String, String> parentMap;
        // 变量是根节点的倍数
        private final Map<String, Double> weightMap;

        public UnionFind(List<List<String>> equations) {
            parentMap = new HashMap<>();
            weightMap = new HashMap<>();
            for (List<String> equation : equations) {
                parentMap.put(equation.get(0), equation.get(0));
                parentMap.put(equation.get(1), equation.get(1));
                weightMap.put(equation.get(0), 1.0D);
                weightMap.put(equation.get(1), 1.0D);
            }
        }

        private String find(String str) {
            if (!parentMap.containsKey(str)) {
                return null;
            }

            String parent = parentMap.get(str);
            if (str.equals(parent)) {
                return str;
            }

            // 递归找到根节点
            String root = find(parent);
            // 进行路径压缩
            weightMap.put(str, weightMap.get(str) * weightMap.get(parent));
            parentMap.put(str, root);
            return root;
        }

        private boolean isConnected(String str1, String str2) {
            String root1 = find(str1);
            String root2 = find(str2);
            if (root1 == null || root2 == null) {
                return false;
            }
            return root1.equals(root2);
        }

        private double getVal(String str1, String str2) {
            if (!isConnected(str1, str2)) {
                return -1.0D;
            }
            return weightMap.get(str1) / weightMap.get(str2);
        }

        private void union(String str1, String str2, double val) {
            String root1 = find(str1);
            String root2 = find(str2);
            if (root1 == null || root2 == null) {
                return;
            }
            if (!root1.equals(root2)) {
                parentMap.put(root1, root2);
                weightMap.put(root1, val * weightMap.get(str2) / weightMap.get(str1));
            }
        }
    }

    @Test
    public void testCase1() {
        LeetCode399 leetCode399 = new LeetCode399();
        List<List<String>> equations = new ArrayList<>();
        equations.add(new ArrayList<>(Arrays.asList("a", "b")));
        equations.add(new ArrayList<>(Arrays.asList("b", "c")));

        double[] values = new double[]{2.0, 3.0};
        List<List<String>> queries = new ArrayList<>();
        queries.add(new ArrayList<>(Arrays.asList("a", "c")));
        queries.add(new ArrayList<>(Arrays.asList("b", "a")));
        queries.add(new ArrayList<>(Arrays.asList("a", "e")));
        queries.add(new ArrayList<>(Arrays.asList("a", "a")));
        queries.add(new ArrayList<>(Arrays.asList("x", "x")));

        double[] ans = leetCode399.calcEquation(equations, values, queries);
        double[] expert = new double[]{6.00000, 0.50000, -1.00000, 1.00000, -1.00000};
        assert doubleArrEqual(expert, ans);
    }

    @Test
    public void testCase2() {
        LeetCode399 leetCode399 = new LeetCode399();
        List<List<String>> equations = new ArrayList<>();
        equations.add(new ArrayList<>(Arrays.asList("a", "b")));
        equations.add(new ArrayList<>(Arrays.asList("b", "c")));
        equations.add(new ArrayList<>(Arrays.asList("bc", "cd")));

        double[] values = new double[]{1.5, 2.5, 5.0};

        List<List<String>> queries = new ArrayList<>();
        queries.add(new ArrayList<>(Arrays.asList("a", "c")));
        queries.add(new ArrayList<>(Arrays.asList("c", "b")));
        queries.add(new ArrayList<>(Arrays.asList("bc", "cd")));
        queries.add(new ArrayList<>(Arrays.asList("cd", "bc")));

        double[] ans = leetCode399.calcEquation(equations, values, queries);
        double[] expert = new double[]{3.75000, 0.40000, 5.00000, 0.20000};
        assert doubleArrEqual(expert, ans);
    }

    @Test
    public void testCase3() {
        LeetCode399 leetCode399 = new LeetCode399();
        List<List<String>> equations = new ArrayList<>();
        equations.add(new ArrayList<>(Arrays.asList("a", "b")));

        double[] values = new double[]{0.5};

        List<List<String>> queries = new ArrayList<>();
        queries.add(new ArrayList<>(Arrays.asList("a", "b")));
        queries.add(new ArrayList<>(Arrays.asList("b", "a")));
        queries.add(new ArrayList<>(Arrays.asList("a", "c")));
        queries.add(new ArrayList<>(Arrays.asList("x", "y")));

        double[] ans = leetCode399.calcEquation(equations, values, queries);
        double[] expert = new double[]{0.50000, 2.00000, -1.00000, -1.00000};
        assert doubleArrEqual(expert, ans);
    }

    @Test
    public void testCase4() {
        LeetCode399 leetCode399 = new LeetCode399();
        List<List<String>> equations = new ArrayList<>();
        equations.add(new ArrayList<>(Arrays.asList("a", "e")));
        equations.add(new ArrayList<>(Arrays.asList("b", "e")));

        double[] values = new double[]{4.0, 3.0};

        List<List<String>> queries = new ArrayList<>();
        queries.add(new ArrayList<>(Arrays.asList("a", "b")));
        queries.add(new ArrayList<>(Arrays.asList("e", "e")));
        queries.add(new ArrayList<>(Arrays.asList("x", "x")));

        double[] ans = leetCode399.calcEquation(equations, values, queries);
        double[] expert = new double[]{1.33333, 1.00000, -1.00000};
        assert doubleArrEqual(expert, ans);
    }

    private boolean doubleArrEqual(double[] arr1, double[] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            if (Math.abs(arr1[i] - arr2[i]) > 0.00001D) {
                return false;
            }
        }
        return true;
    }
}
