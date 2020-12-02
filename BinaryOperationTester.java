package Experiment2.V2;

public class BinaryOperationTester {
    public static void main(String[] args){
        BinaryOperation bop;
        System.out.println("test1:constructor('+')");
        for (int i=0;i<10;i++)
        {
            bop = new AdditionOperation();
            System.out.println(bop);
        }
        System.out.println("test1:constructor('-')");
        for (int i=0; i<10; i++)
        {
            bop = new SubstractOperation();
            System.out.println(bop);
        }
    }
}