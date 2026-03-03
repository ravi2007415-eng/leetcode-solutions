import java.util.*;

class Solution {
    // Depth-first search function to find the itinerary
    private void dfs(Map<String, PriorityQueue<String>> adj, List<String> result, String s) {
        // Check if the airport exists in the adjacency list
        if (adj.containsKey(s)) {
            // While there are destinations connected to the current airport
            while (!adj.get(s).isEmpty()) {
                // Get the next destination
                String v = adj.get(s).poll();
                // Recursively explore this destination
                dfs(adj, result, v);
            }
        }
        // Add the current airport to the result
        result.add(s);
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        // Create an adjacency list to represent the flights
        Map<String, PriorityQueue<String>> adj = new HashMap<>();
        for (List<String> t : tickets) {
            adj.computeIfAbsent(t.get(0), k -> new PriorityQueue<>()).offer(t.get(1));
        }

        // Initialize the result list
        List<String> result = new ArrayList<>();
        // Start the depth-first search from JFK (John F. Kennedy International Airport)
        dfs(adj, result, "JFK");
        // Reverse the result to get the correct itinerary
        Collections.reverse(result);
        // Return the itinerary
        return result;
    }
}