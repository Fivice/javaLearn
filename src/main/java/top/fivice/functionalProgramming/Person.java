package top.fivice.functionalProgramming;

public class Person {

    private String name;
    private String action;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public void doSomething(Person person, HumanAction humanAction){
        System.out.println(humanAction.doSomething(person.getName(),person.getAction()));
    }

    public static String personAction(String name ,String action){
        return name+":"+action;
    }

    public static void main(String[] args) {
        Person person = new Person();
        person.setName("wubin");
        person.setAction("write");

        person.doSomething(person, Person::personAction);
    }

}
