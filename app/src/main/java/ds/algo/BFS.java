package ds.algo;

import java.util.*;

import static java.util.Collections.emptyList;

public class BFS {

    //ECE 2205
    protected static String[][] friendList = {{"You", "Alice"}, {"You", "Bob"}, {"You", "Claire"}, {"Claire", "Thom"}, {"Claire", "Johnny"}, {"Alice", "Peggy"}, {"Bob", "Anuj"}, {"Bob", "Peggy"}};

    protected static Map<String, List<String>> getGraph(String[][] friendList) {
        Map<String, List<String>> graph = new HashMap<>();

        for (int i = 0; i < friendList.length; i++) {
            String key = friendList[i][0];
            String value = friendList[i][1];

            if (!graph.containsKey(key)) {
                graph.put(key, new LinkedList<>());
            }

            graph.get(key).add(value);
        }
        return graph;
    }

    public static List<String> backTrack(String start, String end, Map<String, List<String>> graph) {
        List<String> nav = new ArrayList<>();
        nav.add(end);
        String temp = end;
        while (!temp.equalsIgnoreCase(start)) {
            for (Map.Entry<String, List<String>> entry :
                    graph.entrySet()) {
                if (entry.getValue().contains(temp)) {
                    nav.add(entry.getKey());
                    temp = entry.getKey();
                    break;
                }
            }
        }

        Collections.reverse(nav);
        return nav;
    }

    public static List<String> bfs(String personA, String personB) {
        Map<String, List<String>> graph = getGraph(friendList);
        List<String> navigatedPeople = new ArrayList<>();
        Queue<String> queue = new ArrayDeque<>();
        queue.addAll(graph.getOrDefault(personA, emptyList()));
        while (!queue.isEmpty()) {
            String friend = queue.poll();
            if (friend.equalsIgnoreCase(personB)) {
                return backTrack(personA, personB, graph);
            }
            if (!navigatedPeople.contains(friend)) {
                navigatedPeople.add(friend);
            }
            queue.addAll(graph.getOrDefault(friend, emptyList()));
        }
        return emptyList();
    }

    public static void main(String[] args) {
        System.out.println("graph = " + bfs("You", "Peggy"));
    }
}
