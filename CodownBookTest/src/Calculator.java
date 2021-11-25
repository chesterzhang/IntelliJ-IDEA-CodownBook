public class Calculator {

    //constructor
    public Calculator() {
    }

    //addition
    public int add(int a, int b){
        return a+b;
    }

    //multiplication
    public float mult(float a , float b){
        return a*b;
    }

    @Override
    public String toString() {
        return "This is a calculator, we can do addition and multiplication.";
    }

}
