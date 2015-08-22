package kai.leetcode.algorithm.implement_queues_in_stacks;

import java.util.Stack;

//
//Implement the following operations of a queue using stacks.
//
//push(x) -- Push element x to the back of queue.
//pop() -- Removes the element from in front of queue.
//peek() -- Get the front element.
//empty() -- Return whether the queue is empty.
//Notes:
//You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is empty operations are valid.
//Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or deque (double-ended queue), as long as you use only standard operations of a stack.
//You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).

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