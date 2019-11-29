package com.robbie;

import java.util.*;

public class So332 {
    public List<String> findItinerary(List<List<String>> tickets) {
        if (tickets.isEmpty())
            return Collections.emptyList();
        HashMap<String, PriorityQueue<String>> map = new HashMap<>();
        for (List<String> ticket : tickets) {
            String start = ticket.get(0);
            String end = ticket.get(1);
            PriorityQueue<String> ends = map.get(start);
            if (ends == null) {
                ends = new PriorityQueue<>();
            }
            ends.add(end);
            map.put(start, ends);
        }
        List<String> result = new ArrayList<>();
        search(map, "JFK", result);
        return result;
    }

    public List<String> search(HashMap<String, PriorityQueue<String>> map, String start, List<String> result) {
        System.out.println(start);
        Queue<String> c = map.get(start);
        while (c != null && !c.isEmpty()) {
            search(map, c.poll(), result);
        }
        result.add(0, start);
        return result;
    }

    public static void main(String[] args) {
        So332 so = new So332();
        List<List<String>> tickets = new ArrayList<>();
        tickets.add(Arrays.asList("MUC", "LHR"));
        tickets.add(Arrays.asList("JFK", "MUC"));
        tickets.add(Arrays.asList("SFO", "SJC"));
        tickets.add(Arrays.asList("LHR", "SFO"));
        System.out.println(so.findItinerary(tickets));
        tickets = new ArrayList<>();
        tickets.add(Arrays.asList("JFK", "SFO"));
        tickets.add(Arrays.asList("JFK", "ATL"));
        tickets.add(Arrays.asList("SFO", "ATL"));
        tickets.add(Arrays.asList("ATL", "JFK"));
        tickets.add(Arrays.asList("ATL", "SFO"));
        System.out.println(so.findItinerary(tickets));
        tickets = new ArrayList<>();
        tickets.add(Arrays.asList("JFK", "KUL"));
        tickets.add(Arrays.asList("JFK", "NRT"));
        tickets.add(Arrays.asList("NRT", "JFK"));
        System.out.println(so.findItinerary(tickets));
    }

}
