

package javaapplication74;


public class MyDynamicStack {

    private int stackSize;
    private int[] stackArr;
    private int top;
    public MyDynamicStack(int size) {
        this.stackSize = size;
        this.stackArr = new int[stackSize];
        this.top = -1;
    }
    public void push(int entry){
        if(this.isStackFull()){
            System.out.println(("Stack is full. Increasing the capacity."));
            this.increaseStackCapacity();
        }
        System.out.println("PUSH AN ENTITIY\n\t: "+entry);
        this.stackArr[++top] = entry;
    }
    public int pop() throws Exception {
        if(this.isStackEmpty()){
            throw new Exception("Stack is empty. Can not remove element.");
        }
        int entry = this.stackArr[top--];
        System.out.println("POP AN ENTITY\n\t: "+entry);
        return entry;
    }
    public long peek() {
        return stackArr[top];
    }

    private void increaseStackCapacity(){

        int[] newStack = new int[this.stackSize*2];
        System.arraycopy(this.stackArr, 0, newStack, 0, stackSize);
        this.stackArr = newStack;
        this.stackSize = this.stackSize*2;
    }
    public boolean isStackEmpty() {
        return (top == -1);
    }
    public boolean isStackFull() {
        return (top == stackSize - 1);
    }

    public static void main(String[] args) {
        System.out.println("IMPLEMENTATION STACK USING DAYNAMIC ARRAY\n\tUSING OPEATION OF STACK i.e POP & PUSH\n\n");
        MyDynamicStack stack = new MyDynamicStack(2);
        for(int i=1;i<10;i++){
            stack.push(i);
        }
        for(int i=1;i<4;i++){
            try {
                stack.pop();
            } catch (Exception e) {
            }
        }
    }
}
