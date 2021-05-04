package com.geekbing.easy;

import java.util.*;

/**
 * @author bing
 */
public class LeetCode690 {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }
        return getImportance(map, id);
    }

    private int getImportance(Map<Integer, Employee> map, int id) {
        Employee employee = map.get(id);
        int ans = employee.importance;
        for (int subId : employee.subordinates) {
            ans += getImportance(map, subId);
        }
        return ans;
    }

    private static final class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }

    public static void main(String[] args) {
        Employee employee2 = new Employee();
        employee2.id = 2;
        employee2.importance = 3;
        employee2.subordinates = new ArrayList<>();

        Employee employee3 = new Employee();
        employee3.id = 3;
        employee3.importance = 3;
        employee3.subordinates = new ArrayList<>();

        Employee employee1 = new Employee();
        employee1.id = 1;
        employee1.importance = 5;
        employee1.subordinates = new ArrayList<>(Arrays.asList(2, 3));

        List<Employee> employees = new ArrayList<>(Arrays.asList(employee1, employee2, employee3));
        LeetCode690 leetCode690 = new LeetCode690();
        System.out.println(leetCode690.getImportance(employees, 1));
    }
}
