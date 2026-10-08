class MinStack {
    Deque<Integer> stack = new ArrayDeque<>();
    ArrayList<Integer> min = new ArrayList<>();
    // int mtop = 0;

    public MinStack() {
        min.add(Integer.MAX_VALUE); 
        // mtop++;
    }
    
    public void push(int val) {
        stack.push(val);
        if (val <= min.get(min.size() - 1)) {
            min.add(val);
        }
        else {
            min.add(min.get(min.size() - 1));
        }
    }
    
    public void pop() {
        stack.pop();
        min.remove(min.size() - 1);
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min.get(min.size() - 1);
    }
}