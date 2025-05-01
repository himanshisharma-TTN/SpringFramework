package Ques2;

//Write a program to demonstrate Loosely Coupled code.

public class LooselyCoupledExp {
    public static void main(String[] args) {
        WholeClass whole = new WholeClass(new DependencyClass1());
        System.out.println(whole+" object is lossely coupled with "+ whole.getObj());
        whole = new WholeClass(new DependencyClass2());
        System.out.println(whole+" object is lossely coupled with "+ whole.getObj());
    }
}

class WholeClass{
    DependencyClasses obj;

    WholeClass(DependencyClasses obj){
        this.obj = obj;
    }

    public DependencyClasses getObj() {
        return obj;
    }
}

interface DependencyClasses{}

class DependencyClass1 implements DependencyClasses{
    int val=10;
}
class DependencyClass2 implements DependencyClasses{
    int val=15;
}
