import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;

public class Main {
    public static void main(String[] args) {
        // Assign Function
        IntBinaryOperator add = (a,b)->a+b;
        // Use function
        System.out.println(add.applyAsInt(5,7));

        // send function as an argument
        register("Elbialy",(mail)-> System.out.println("MAILING "+ mail));


        Function doubleNumber = multiplyBy(2);
        System.out.println(doubleNumber.apply(4));

        Function tripleNumber = multiplyBy(3);
        System.out.println(tripleNumber.apply(4));
        System.out.println(multiplyBy(5).apply(6));



    }
    // Receive function as an argument
    public static void register(String name, Consumer callback){
        // some logic here
        callback.accept(name + "@domain.com");
    }
    // Return function
    public static Function<Integer,Integer> multiplyBy(int x){
        return (y)-> x*y;
    }

}