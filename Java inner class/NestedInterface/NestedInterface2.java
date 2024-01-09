class A {
  interface Message {
    void msg();
  }
}

public class NestedInterface2 implements A.Message {
  public void msg() {
    System.out.println("Nested Interface in class");
  }

  public static void main(String[] args) {
    A.Message obj = new NestedInterface2();
    obj.msg();
  }
}
