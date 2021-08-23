package com.example;

import java.util.*;

public class Task {
    private final Map<String, List<String>> input = Map.of("a", List.of("b", "c"), "d", List.of("e", "f"), "k", List.of("l"), "x", List.of("y", "z"));

    private final List<Connection> connections = new ArrayList<>();

    public void apply(String connectFrom, List<String> connectTos) {
        List<String> nodes = new ArrayList<>();
        List<String> neighbors = new ArrayList<>();
        nodes.add(connectFrom);

        neighbors.addAll(input.get(connectFrom));
        neighbors.addAll(connectTos);

        for (String neighbor: neighbors) {
            List<String> nodesFromDFS = dfs(neighbor, input); //O(n)
            nodes.addAll(nodesFromDFS);
        }

        for (String from: nodes){ //O(n^2)
            for (String to: nodes){
                if (!from.equals(to))
                    connections.add(new Connection(from,to));
            }
        }

        //sorting
        connections.sort(new SortConnections()); //O(nlogn)
    }

    private List<String> dfs(String node, Map<String, List<String>> input) {
        List<String> result = new ArrayList<>();

        result.add(node);

        if (input.get(node) != null) {
            for (String edge : input.get(node))
                result.addAll(dfs(edge, input));
        }

        return result;
    }

    public List<Connection> getConnections() {
        return connections;
    }

    static class SortConnections implements Comparator<Connection>{
        @Override
        public int compare(Connection a, Connection b) {
            int comp = a.getConnectFrom().compareTo(b.getConnectFrom());
            if (comp == 0)
                comp = a.getConnectTo().compareTo(b.getConnectTo());
            return comp;
        }
    }
}
