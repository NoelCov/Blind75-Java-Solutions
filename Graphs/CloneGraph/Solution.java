import java.util.HashMap;
import java.util.Map;

// Question link: https://leetcode.com/problems/clone-graph/

class Solution {
    // Time Complexity O(V + E)
    // Space Complexity O(V + E)
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        Map<Node, Node> hash = new HashMap<>();
        return dfs(node, hash);
    }

    public Node dfs(Node node, Map<Node, Node> hash) {
        if (hash.containsKey(node)) {
            return hash.get(node);
        }

        // Create a deep copy of the current node and store in hashmap
        // for later use so that we do not clone duplicates.
        Node newNode = new Node(node.val);
        hash.put(node, newNode);

        for (Node neighbor : node.neighbors) {
            // Adding the new node to the list of neighbors is a must to make the graph a
            // CONNECTED graph.
            newNode.neighbors.add(dfs(neighbor, hash));
        }

        return newNode;
    }
}