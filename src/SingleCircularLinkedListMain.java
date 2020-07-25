public class SingleCircularLinkedListMain {
    public static void main(String[] args) {
        SingleCircularLinkedList list = new SingleCircularLinkedList();
        list.CreateLinkedlist(5);
        list.insertInLinkedList(10, 1);
        list.insertInLinkedList(20, 2);
        list.insertInLinkedList(30, 3);
        list.insertInLinkedList(40, 4);

        System.out.println("Linked List now: ");
        list.traverseLinkedList();

        list.insertInLinkedList(35, 4);
        list.traverseLinkedList();

        list.insertInLinkedList(1, 0);
        list.traverseLinkedList();

        list.insertInLinkedList(100, 10);
        list.traverseLinkedList();

        list.printHeadUsingTail();
        list.search(4);
        System.out.println("hii");

        System.out.println("\n\nDeleting the node having location = 2: ");
        System.out.println("Before deletion...");
        list.traverseLinkedList();
        list.deletionOfNode(2);
        System.out.println("After deletion...");
        list.traverseLinkedList();


        System.out.println("\n\nDeleting the node having location = 0: ");
        System.out.println("Before deletion...");
        list.traverseLinkedList();
        list.deletionOfNode(0);
        System.out.println("After deletion...");
        list.traverseLinkedList();


        System.out.println("\n\nDeleting the node having location = 15: ");
        System.out.println("Before deletion...");
        list.traverseLinkedList();
        list.deletionOfNode(15);
        System.out.println("After deletion...");
        list.traverseLinkedList();


        System.out.println("\n\nDeleting the node having location = 15: ");
        System.out.println("Before deletion...");
        list.traverseLinkedList();
        list.deletionOfNode(15);
        System.out.println("After deletion...");
        list.traverseLinkedList();



    }
}
