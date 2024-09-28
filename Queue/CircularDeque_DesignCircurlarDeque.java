public class CircularDeque_DesignCircurlarDeque {

  private int[] deque;
  private int front, size;
  private final int CAPACITY;

  public MyCircularDeque(int k) {
        this.deque = new int[k];
        this.front = 0;
        this.size = 0;
        this.CAPACITY = k;
    }

  public boolean insertFront(int value) {
    if (isFull())
      return false;
    front = (front - 1 + CAPACITY) % CAPACITY;
    deque[front] = value;
    size++;
    return true;
  }

  public boolean insertLast(int value) {
    if (isFull())
      return false;
    int rear = (front + size) % CAPACITY;
    deque[rear] = value;
    size++;
    return true;
  }

  public boolean deleteFront() {
    if (isEmpty())
      return false;
    front = (front + 1) % CAPACITY;
    size--;
    return true;
  }

  public boolean deleteLast() {
    if (isEmpty())
      return false;
    size--;
    return true;
  }

  public int getFront() {
    if (isEmpty())
      return -1;
    return deque[front];
  }

  public int getRear() {
    if (isEmpty())
      return -1;
    return deque[(front + size - 1) % CAPACITY];
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public boolean isFull() {
    return size == CAPACITY;
  }
}