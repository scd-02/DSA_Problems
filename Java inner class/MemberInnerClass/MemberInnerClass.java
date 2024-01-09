public class MemberInnerClass {

  private int data = 100;

  class Inner {
    void message() {
      System.out.println(data);
    }
  }

  public static void main(String[] args) {
    MemberInnerClass obj = new MemberInnerClass();

    MemberInnerClass.Inner a = obj.new Inner();
    a.message();
    MemberInnerClass.Inner b = obj.new Inner();
    b.message();
  }
}