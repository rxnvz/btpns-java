public class TestDog {
   public static void main(String args[]) {
    Animal1 a = new Animal1();   // Animal reference and object
    Dog1 b = new Dog1();   // Animal reference but Dog object
    a.move();   // runs the method in Animal class
    b.move();   // runs the method in Dog class
    b.bark();
   }
}
