class MinStack {
    private Stack<Integer> st;
    private Stack<Integer> min;
    public MinStack() {
        st = new Stack<>();
        min = new Stack<>();
    }
    
    public void push(int val) {
        st.push(val);
        if(min.isEmpty() || val <= min.peek()){
            min.push(val);
        }
    }
    
    public void pop() {
        int tope = st.pop();
        if(tope == min.peek()){
            min.pop();
        }
    }
    
    public int top() {
        int t = st.peek();
        return t;
    }
    
    public int getMin() {
        int t = min.peek();
        return t;
    }
}
