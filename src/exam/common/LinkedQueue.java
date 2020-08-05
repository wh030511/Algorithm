package exam.common;

/**
 * @author WuHao
 * @create 2020-03-24-17:39
 */
public class LinkedQueue {
    private Node head;
    private Node tail;

    public LinkedQueue(){
        this.head = new Node();
        this.tail = head;
    }

    public boolean isEmpty(){
        return head == tail;
    }

    public synchronized void push(int val){
        tail.val = val;
        tail.next = new Node();
        tail = tail.next;
    }

    public synchronized int pop(){
        int res = head.val;
        head = head.next;
        return res;
    }
}

class Node{
    int val;
    Node next;

    public Node(){}

    public Node(int val){
        this.val = val;
    }
}
