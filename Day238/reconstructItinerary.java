package Day238;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;


public class reconstructItinerary {
    public static void dfs(String s, Map<String, PriorityQueue<String>> map, LinkedList<String> list) {
        PriorityQueue<String> temp = map.get(s);
        while (temp!= null && !temp.isEmpty()) {
            dfs(temp.poll(), map, list);
        }
        list.addFirst(s);
    }
    public static List<String> findItinerary(List<List<String>> tickets) {
        LinkedList<String> answer = new LinkedList<>();
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        for (int i=0; i<tickets.size(); i++) {
            if (!map.containsKey(tickets.get(i).get(0))) {
                map.put(tickets.get(i).get(0), new PriorityQueue<>());
            }
            map.get(tickets.get(i).get(0)).add(tickets.get(i).get(1));
        }
        System.out.println(map);
        dfs("JFK", map, answer);
        return answer;
    }
    public static void main(String[] args) {
        List<List<String>> tickets = new ArrayList<>();
        String arr[][] ={{"JFK","KUL"},{"JFK","NRT"},{"NRT","JFK"}};
        for (int i=0; i<arr.length; i++) {
            List<String> temp = new ArrayList<>();
            for (int j=0; j<arr[i].length; j++) {
                temp.add(arr[i][j]);
            }
            tickets.add(temp);
        }
        
        // System.out.println(tickets);
        System.out.println(findItinerary(tickets));
    }   
}