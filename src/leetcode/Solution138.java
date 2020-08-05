package leetcode;

/**
 * @author WuHao
 * @create 2020-04-01-10:08
 */
public class Solution138 {

        public Node copyRandomList(Node head) {
            if (head == null) return null; // 特解

            Node ptr = head;
            while(ptr != null){
                Node newNode = new Node(ptr.val);

                newNode.next = ptr.next;
                ptr.next = newNode;
                ptr = newNode.next;
            }

            ptr = head;
            while(ptr != null){ // 再次遍历填充随机节点
                ptr.next.random = (ptr.random != null) ? ptr.random.next : null;
                ptr = ptr.next.next;
            }

            Node oldPtr = head;
            Node newPtr = head.next;
            Node res = newPtr;

            while(oldPtr != null){ // 改写next指针
                oldPtr.next = newPtr.next;
                oldPtr = oldPtr.next;
                newPtr.next = (oldPtr != null) ? oldPtr.next : null;
                newPtr = newPtr.next;
            }

            return res;

        }
}



