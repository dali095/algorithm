package kai.leetcode.algorithm.implement_queues_in_stacks;

import java.util.Stack;

public class MyQueue {
    // Push element x to the back of queue.
    private Stack<Integer> s  = new Stack<Integer>();
    
    public void push(int x) {
        this.s.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        Stack<Integer> temp = new Stack<Integer>();
        while (!this.s.empty()){
            temp.push(this.s.pop());
        }
        
        if (!temp.empty())
            temp.pop();
        
        while(!temp.empty()) {
            this.s.push(temp.pop());
        }
    }

    // Get the front element.
    public int peek() {
        Stack<Integer> temp = new Stack<Integer>();
        while (!this.s.empty()){
            temp.push(this.s.pop());
        }
        
        int result = 0;
        if (!temp.empty())
            result = temp.peek();
        
        while(!temp.empty()) {
            this.s.push(temp.pop());
        }
        return result;
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return this.s.empty();
    }
}