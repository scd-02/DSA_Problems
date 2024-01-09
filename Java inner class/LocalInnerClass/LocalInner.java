public class LocalInner {

  private int data = 100;

  void display() {

    int value = 50;

    class Local {
      void message() {
        System.out.println(data);
      }
    }

    class Local2 {
      void add() {
        System.out.println(data + value);
      }
    }

    Local obj1 = new Local();
    obj1.message();

    Local obj2 = new Local();
    obj2.message();

    Local2 ob = new Local2();
    ob.add();
  }

  public static void main(String[] args) {

    LocalInner ins = new LocalInner();
    ins.display();
  }
}
