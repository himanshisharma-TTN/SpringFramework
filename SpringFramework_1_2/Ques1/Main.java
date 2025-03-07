package Ques1;

// Write a program to demonstrate Tightly Coupled code.

public class Main {
    public static void main(String[] args) {
        WholeClass whole = new WholeClass();
        System.out.println(whole+" object is tightly coupled with "+ whole.getObj());
    }
}

class WholeClass{
    DependencyClass obj;

    WholeClass(){
        this.obj = new DependencyClass();
    }

    public DependencyClass getObj() {
        return obj;
    }
}

class DependencyClass{
    int val=10;
}
