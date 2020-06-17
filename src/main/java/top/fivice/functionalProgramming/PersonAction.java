package top.fivice.functionalProgramming;

public class PersonAction implements HumanAction {
    @Override
    public String doSomething(String name, String action) {
        return name+":"+action;
    }
}
