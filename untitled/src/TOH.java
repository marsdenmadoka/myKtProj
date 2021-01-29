import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;

/**
 *
 * @author Sada Kurapati <sadakurapati@gmail.com>
 */
public class TOH{

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        //towers initial config
        Node source = readPegsConfiguration(k, n, sc);
        //read target configuration
        Node target = readPegsConfiguration(k, n, sc);
        //To keep track what config we visited and avoid cycles
        Set visited = new HashSet();
        try {
            minMovesToTarget(source, target, visited);
        } catch (Exception ex) {
            System.out.println("Exception = " + ex);
        }
    }

    private static void minMovesToTarget(Node source, Node target, Set visited) throws CloneNotSupportedException {
        //Perform BFS
        //add source node to Queue
        Queue q = new LinkedList();
        q.add(source);
        Node current = source;
        while (!q.isEmpty()) {
            current = q.poll();
            if (current.equals(target)) { //found the target configuration
                break;
            }
            List neighbors = current.neighbors();
            if (neighbors.size() > 0) {
                for (Node n : neighbors) {
                    if (!visited.contains(n)) {//if not visited, put it in queue
                        q.offer(n);
                        visited.add(n);
                    }
                }
            }
        }
        //Printing path and moves if target config found
        if (current.equals(target)) {
            printOutput(current);
        }
    }

    private static Node readPegsConfiguration(int k, int n, Scanner sc) {
        Stack[] initialState = new Stack[k];
        for (int i = 0; i < k; i++) {
            initialState[i] = new Stack();
        }
        //reading and reversing the line as we need to put the elements in decresing size
        //disc is key and tower is value.
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            map.put(i, sc.nextInt());
        }
        //prepare towers
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            initialState[entry.getValue() - 1].push(entry.getKey());
        }
        return new Node(initialState);
    }

    static void printOutput(Node target) {
        Stack stack = new Stack<>(); //using stack as we need to print the trail from Source - target config
        while (target.parent != null) {
            stack.add(target.move);
            target = target.parent;
        }
        System.out.println(stack.size());
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    static class Node implements Cloneable {
        //towers
        Stack[] state = null;
        Node parent = null;  //for backtracking trail
        Move move = null; // The move we made to go to next neighbor config

        public Node(Stack[] st) {
            state = st;
        }

        @Override
        protected Node clone() throws CloneNotSupportedException {
            Stack[] cloneStacks = new Stack[state.length];
            for (int i = 0; i < state.length; i++) {
                cloneStacks[i] = (Stack) state[i].clone();
            }
            Node clone = new Node(cloneStacks);
            return clone;
        }

        //returns the neghboring configurations.
        //What all configurations we can get based on current config.
        public List neighbors() throws CloneNotSupportedException {
            List neighbors = new ArrayList<>();
            int k = state.length;
            for (int i = 0; i < k; i++) {
                for (int j = 0; j < k; j++) {
                    if (i != j && !state[i].isEmpty()) {
                        //Need to clone to avoid change the parent node.
                        //Hint - in java, objects are not mutable and they are references
                        Node child = this.clone();
                        //make a move
                        if (canWeMove(child.state[i], child.state[j])) {
                            child.state[j].push(child.state[i].pop());
                            //this is required to backtrack the trail once we find the target config
                            child.parent = this;
                            //the move we made to get to this neighbor
                            child.move = new Move(i, j);
                            neighbors.add(child);
                        }
                    }
                }
            }
            return neighbors;
        }

        public boolean canWeMove(Stack fromTower, Stack toTower) {
            boolean answer = false;
            if (toTower.isEmpty()) {// if destination tower is empty, then we can move any disc
                return true;
            }
            int toDisc = toTower.peek();
            int fromDisc = fromTower.peek();
            if (fromDisc < toDisc) { //we can only place small disc on top
                answer = true;
            }
            return answer;
        }

        @Override
        public int hashCode() {
            int hash = 7;
            return hash;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final Node other = (Node) obj;
            if (!Arrays.deepEquals(this.state, other.state)) {
                return false;
            }
            return true;
        }

        class Move {
            int towerFrom, towerTo;
            public Move(int f, int t) {
                towerFrom = f + 1;
                towerTo = t + 1;
            }
            @Override
            public String toString() {
                return towerFrom + " " + towerTo;
            }
        }
    }
}