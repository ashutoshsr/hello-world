package datastructs.linkedList.datastructs.doublylinked;

/**
 * Unit Tests for {@link DLLinkedList}.
 */
public class DLLinkedListTest {
    static DLLinkedList dllinkedList = new DLLinkedList();

    private static void setup() {
        int[] data = {2, 3, 4, 5, 7, 11, 15};
/*        for (int i = 0; i < data.length; i++) {
            dllinkedList.insertAtEnd(new DLListNode(data[i]));
        }
        System.out.println(dllinkedList.toString());*/
        System.out.println( " ------  --------  ------ " );
        for (int i=0; i < data.length; i++) {
            dllinkedList.insertAtBegin(data[i]);
        }
        System.out.println(dllinkedList.toString());
        System.out.println( " ------ 2 -------- 2 ------ " );
/*        for (int i=0; i < data.length; i++) {
            dllinkedList.insert(data[i], i);
        }
        System.out.println(dllinkedList.toString());
        System.out.println("removed " + dllinkedList.removeFromEnd());
        System.out.println(dllinkedList.toString());*/
    }

    public static void main (String args[]) {
        setup();
    }
}
