class PersonConcrete {
  void eat() {
  }
}

abstract class PersonAbstract {
  abstract void eat();
}

public class AnonymousInner {

  public static void main(String[] args) {

    PersonConcrete pc = new PersonConcrete() {
      void eat() {
        System.out.println("Tasty");
      }
    };

    pc.eat();

    PersonAbstract pa = new PersonAbstract() {
      void eat() {
        System.out.println("Tasty in Abstract");
      }
    };

    pa.eat();

    PersonAbstract pa2 = new PersonAbstract() {
      void eat() {
        System.out.println("Tasty in Abstract class 2");
      }
    };

    pa2.eat();
  }
}