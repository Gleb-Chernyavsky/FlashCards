public class Main{
    public static void main(String[] args) {
        Person emoloyer = new Employee("Oleg", 29, "three years", "Director");
    }
}
class Person{
    String name;
    int age;
    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }
    public void sayYourName(){
        System.out.println("My name is: " + name);
    }
}
class Employee extends Person{
    String workExperiance;
    String position;

    public Employee(String name, int age, String workExperiance, String position) {
        super(name, age);
        this.workExperiance = workExperiance;
        this.position = position;
    }
    public void makeOrder(int countOfHours){
        System.out.println("Pleas wait, i making your order: " + countOfHours + " yet");
    }
}
class Client extends Person {
    String order;

    public Client(String name, int age, String order) {
        super(name, age);
        this.order = order;
    }
    public void waitToOrder(int countOfHours){
        System.out.println("I wait my order for: " + countOfHours + " hours yet!!");
    }
}