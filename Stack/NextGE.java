// code for Next Greater Element I

import java.util.HashMap;
import java.util.Stack;

public class NextGE {
    public int[] nextGreaterElement(int[] n1, int[] n2) {
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // Process the second array to find next greater elements
        for (int i = n2.length - 1; i >= 0; i--) {
            int num = n2[i];
            
            // Remove elements from the stack that are less than or equal to the current element
            while (!stack.isEmpty() && stack.peek() <= num) {
                stack.pop();
            }
            
            // Map the current number to the next greater element, or -1 if none exists
            map.put(num, stack.isEmpty() ? -1 : stack.peek());
            
            // Push the current number onto the stack
            stack.push(num);
        }
        
        // Replace elements in n1 with their next greater element from the map
        for (int i = 0; i < n1.length; i++) {
            n1[i] = map.getOrDefault(n1[i], -1);
        }
        
        return n1;
    }

    public static void main(String[] args) {
        // Example usage
        NextGE solution = new NextGE();
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        
        int[] result = solution.nextGreaterElement(nums1, nums2);
        System.out.print("Next Greater Elements: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
