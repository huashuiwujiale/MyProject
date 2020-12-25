package Experiment3;

class AdditionOperation extends BinaryOperation {
    //ExerciseSheet 调用AdditionOperation生成加法算式
    AdditionOperation(){
        generateBinaryOperation('+');
    }
    public boolean checkingCalculation(int anInteger){
        return anInteger<=UPPER;
    }
    int calculate(int left,int right){
        return left+right;
    }
}
