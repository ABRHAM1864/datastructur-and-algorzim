

package javaapplication67;


public class DynamicQueueImpl {

    private int capacity = 2;
    int queueArr[];
    int front = 0;
    int rear = -1;
    int currentSize = 0;

    public DynamicQueueImpl(){
        queueArr = new int[this.capacity];
    }

    public void enqueue(int item) {

        if (isQueueFull()) {
            System.out.println("Queue is full, increase capacity...");
            increaseCapacity();
        }
        rear++;
        if(rear >= queueArr.length && currentSize != queueArr.length){
            rear = 0;
        }
        queueArr[rear] = item;
        currentSize++;
        System.out.println("you are enqueue\n\t : " + item );
    }
    public void dequeue() {
        if (isQueueEmpty()) {
            System.out.println("Underflow ! Unable to remove element from Queue");
        } else {
            front++;
            if(front > queueArr.length-1){
                System.out.println("dnqueue the entity\n\t: "+queueArr[front-1]);
                front = 0;
            } else {
                System.out.println("dnqueue the entity\n\t: "+queueArr[front-1]);
            }
            currentSize--;
        }
    }

    public boolean isQueueFull(){
        boolean status = false;
        if (currentSize == queueArr.length){
            status = true;
        }
        return status;
    }

    public boolean isQueueEmpty(){
        boolean status = false;
        if (currentSize == 0){
            status = true;
        }
        return status;
    }

    private void increaseCapacity(){

        //create new array with double size as the current one.
        int newCapacity = this.queueArr.length*2;
        int[] newArr = new int[newCapacity];
        int tmpFront = front;
        int index = -1;
        while(true){
            newArr[++index] = this.queueArr[tmpFront];
            tmpFront++;
            if(tmpFront == this.queueArr.length){
                tmpFront = 0;
            }
            if(currentSize == index+1){
                break;
            }
        }
        //make new array as queue
        this.queueArr = newArr;
        System.out.println("New array capacity: "+this.queueArr.length);
        //reset front & rear values
        this.front = 0;
        this.rear = index;
    }

    public static void main(String a[]){

        DynamicQueueImpl queue = new DynamicQueueImpl();
      System.out.println("IMPLEMENTATION OF QUEUE USING DAYNAMIC ARRAY\n\tAND OPPERATION OF QUEUE i.e ENQUEUE &DEQUEUE\n\n");
        queue.enqueue(555);
        queue.enqueue(999);
        queue.enqueue(666);
        queue.dequeue();
        queue.enqueue(222);
        queue.enqueue(777);
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.enqueue(888);
        queue.dequeue();
        queue.dequeue();
    }
}