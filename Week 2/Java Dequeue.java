import java.util.Scanner;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int n = in.nextInt();
        int m = in.nextInt();
        int maxUnique = 0;

        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            
            // Add current element to window and map
            deque.addLast(num);
            map.put(num, map.getOrDefault(num, 0) + 1);
            
            // Once window reaches size M, process it
            if (deque.size() == m) {
                // Update the maximum unique count found so far
                if (map.size() > maxUnique) {
                    maxUnique = map.size();
                }
                
                // If maximum unique elements equal M, we can't find a higher value
                if (maxUnique == m) {
                    System.out.println(maxUnique);
                    return;
                }
                
                // Slide the window: remove the oldest element from front
                int first = deque.removeFirst();
                int count = map.get(first);
                if (count == 1) {
                    map.remove(first);
                } else {
                    map.put(first, count - 1);
                }
            }
        }
        
        System.out.println(maxUnique);
    }
}
