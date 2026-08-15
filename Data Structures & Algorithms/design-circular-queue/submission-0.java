class MyCircularQueue {
    public class Node {
        int val;
        Node next;
        public Node( int val ){ this.val = val; }
    }

    int size;
    int maxSize;
    Node front;
    Node rear;

    public MyCircularQueue(int k) {
        this.maxSize = k;
        this.size = 0;
        this.front = null;
        this.rear = null;
    }
    
    public boolean enQueue(int value) {
        if (size == maxSize) return false;

        Node node = new Node(value);
        if( size == 0 ) {
            front = rear = node;
            node.next = node;
        } else {
            node.next = front;
            rear.next = node;
            rear = node;
        }
        size++;
        return true;
    }
    
    public boolean deQueue() {
        if( size == 0 ) return false;
        
        if ( size == 1 ) {
            front = rear = null;
        } else {
            front = front.next;
            rear.next = front;
        }
        size--;
        return true;
    }
    
    public int Front() { return size == 0 ? -1 : front.val; }
    
    public int Rear() { return size == 0 ? -1 : rear.val; }
    
    public boolean isEmpty() { return size == 0; }
    
    public boolean isFull() { return size == maxSize; }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */