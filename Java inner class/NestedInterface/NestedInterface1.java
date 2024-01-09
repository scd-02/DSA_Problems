interface Showable {
  void show();

  interface Message {
    void msg();
  }
}

// The nested interface must be public if it is declared inside the interface,
// but it can have any access modifier if declared within the class.

// Nested interfaces are declared static
public class NestedInterface1 implements Showable.Message {

  public void msg() {
    System.out.println("Nested interface");
  }

  public static void main(String[] args) {
    Showable.Message obj = new NestedInterface1();
    obj.msg();
  }
}
