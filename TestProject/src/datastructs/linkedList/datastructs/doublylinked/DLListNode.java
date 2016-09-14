package datastructs.linkedList.datastructs.doublylinked;

import java.util.Objects;

/**
 * Created by ashsrivast on 30/07/16.
 */
public class DLListNode {

    public static final String STRING = "DLListNode{";
    public static final String DATA = "data=";
    public static final String HEAD = ", prev=";
    public static final String TAIL = ", next=";
    public static final String EMPTY = "";
    public static final char CHAR = '}';
    private int data;
    private DLListNode prev;
    private DLListNode next;


    public DLListNode(int data, DLListNode head, DLListNode next) {
        this.data = data;
        this.prev = head;
        this.next = next;
    }

    public DLListNode(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public DLListNode getPrev() {
        return prev;
    }
     public void setPrev(DLListNode prev) {
        this.prev = prev;
    }

    public DLListNode getNext() {
        return next;
    }

    public void setNext(DLListNode next) {
        this.next = next;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DLListNode that = (DLListNode) o;
        return data == that.data &&
                Objects.equals(prev, that.prev) &&
                Objects.equals(next, that.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, prev, next);
    }

    @Override
    public String toString() {
        return STRING +
                DATA + data +
                HEAD + ((prev != null) ? prev : EMPTY) +
                TAIL + ((next != null) ? prev : EMPTY) +
                CHAR;
    }
}
