package datastructs.linkedList.datastructs.doublylinked;

/**
 * Created by ashsrivast on 30/07/16.
 */
public class DLLinkedList {

    DLListNode head;
    DLListNode tail;
    int length;
    public DLLinkedList() {
        head = null;
        tail = null;
        length = 0;
    }

    public DLListNode getHead() {
        return head;
    }

    public void insertAtBegin(int data) {
        // Insert node at the head, so its head to Head and its tail to head's tail
        DLListNode newNode = new DLListNode(data, null, null);
        if (head == null) {
            head = newNode;
            tail = head;

        } else {
            // modify the head's next node's pointer to newNode
            head.setPrev(newNode);
            // now this head's next is newNode
            newNode.setNext(head);
            head = newNode;
        }
        length++;
    }

    public void insertAtEnd(DLListNode node) {
        if (head == null) {
            head = node;
            tail = head;
        } else {
            DLListNode lastOne = head;
            while (lastOne.getNext() != null) {
                lastOne = lastOne.getNext();
            }
            lastOne.setNext(node);
            node.setPrev(lastOne);
        }
        length++;
    }

    public void insert(int data, int position) {
        position = Math.max(position, 0);
        position = Math.min(position, length);
        DLListNode node = new DLListNode(data);
        if (head == null) {
            head = new DLListNode(data);
            tail = head;
            length++;
        } else if (position == 0) {
            insertAtBegin(data);
        } else if (position == length) {
            insertAtEnd(node);
        } else {
            DLListNode positionNode = head;
            for (int i = 0; i < position && positionNode.getNext() != null; i++) {
                positionNode = positionNode.getNext();
            }
            node.setPrev(positionNode);
            node.setNext(positionNode.getNext());
            positionNode.setNext(node);
            length++;
        }
    }

    public DLListNode removeFromEnd() {
        DLListNode removedElement = null;
        if (head == null) {
            head = null;
            return head;
        } else {
            removedElement = tail;
            System.out.println(tail);
            tail.getPrev().setNext(null);
            tail = null;
            length--;
            return removedElement;
        }
    }

    @Override
    public String toString() {
        DLListNode node = head;
        while(node.getNext() != null) {
            System.out.println(node);
            node = node.getNext();
        }
        if (node != null) {
            System.out.println(node);
        }
        return "DLLinkedList{length=" + length +'}';
    }

    public static void main(String args[]) {
        System.out.println("Hello World");
    }
}
