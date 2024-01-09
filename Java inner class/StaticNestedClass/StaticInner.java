public class StaticInner {

  static int data = 100;

  static class Inner {
    void message() {
      System.out.println(data);
    }

    static void msg(int val) {
      System.out.println(data + val);
    }
  }

  public static void main(String[] args) {
    StaticInner.Inner obj = new Inner();
    obj.message();

    StaticInner.Inner.msg(45);
  }
}
