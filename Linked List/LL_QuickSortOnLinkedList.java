
public class LL_QuickSortOnLinkedList {

  static class Node {
    int data;
    Node next;

    Node(int data) {
      this.data = data;
      this.next = null;
    }

    static Node partition(Node head, Node end, Node[] newHead, Node[] newEnd) {
      Node pivot = end;
      Node prev = null, curr = head, tail = pivot;

      // Nodes less than pivot go into the 'newHead' and greater nodes after the pivot
      while (curr != pivot) {
        if (curr.data < pivot.data) {
          // If the current node should be the new head of the list
          if (newHead[0] == null)
            newHead[0] = curr;

          prev = curr;
          curr = curr.next;
        } else {
          // Move nodes greater than pivot to the end
          if (prev != null)
            prev.next = curr.next;
          Node temp = curr.next;
          curr.next = null;
          tail.next = curr;
          tail = curr;
          curr = temp;
        }
      }

      // Update newEnd to the current tail
      newEnd[0] = tail;

      // If pivot is the smallest element, it becomes the head
      if (newHead[0] == null)
        newHead[0] = pivot;

      return pivot;
    }

    static Node quickSortHelper(Node head, Node end) {
      // Base case: if head is null or head == end
      if (head == null || head == end)
        return head;

      Node[] newHead = { null }, newEnd = { null };

      // Partition the list, newHead and newEnd are updated
      Node pivot = partition(head, end, newHead, newEnd);

      // Sort the list before the pivot
      if (newHead[0] != pivot) {
        Node temp = newHead[0];
        while (temp.next != pivot)
          temp = temp.next;
        temp.next = null;

        // Recursively sort the list before the pivot
        newHead[0] = quickSortHelper(newHead[0], temp);

        // Re-attach the pivot to the sorted list
        temp = getTail(newHead[0]);
        temp.next = pivot;
      }

      // Recursively sort the list after the pivot
      pivot.next = quickSortHelper(pivot.next, newEnd[0]);

      return newHead[0];
    }

    // Main function for quick sort
    public static Node quickSort(Node head) {
      Node tail = getTail(head);
      return quickSortHelper(head, tail);
    }

    // Utility function to get the tail of the list
    static Node getTail(Node cur) {
      while (cur != null && cur.next != null)
        cur = cur.next;
      return cur;
    }
  }
}