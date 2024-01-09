class QNode {
  int info;
  QNode next;

  QNode(int v, QNode next) {
    this.info = v;
    this.next = next;
  }
}

class Queue {
  QNode q;
  QNode front = null, rear = null;
  int size = 0;

  void insert(int v) {
    QNode temp = new QNode(v, null);
    if (front == null && rear == null) {
      q = temp;
      front = rear = q;
      return;
    }

    rear.next = temp;
    rear = rear.next;
  }

  int delete() throws Exception{
    if (front == null) {
      throw new IllegalStateException("QueueEmptyException");
    }
    
    if(rear == front && front != null){
      rear = front = null;
    }

    int value = front.info;
    front = front.next;
    return value;
  }

  boolean isEmpty(){
    return (front == null && rear == null);
  }
  void display() {
    QNode temp = front;
    while (temp != null) {
      System.out.print(temp.info + " ");
      temp = temp.next;
    }
  }
}