package Experiment2.V2;

class SubstractOperation extends BinaryOperation{
    //ExerciseSheet 调用SubstractOperation生成减法算式
    SubstractOperation(){
        generateBinaryOperation('-');
    }
    public boolean checkingCalculation(int anInteger){
        return anInteger>=LOWER;
    }
    int calculate(int left,int right){
        return left-right;
    }
}