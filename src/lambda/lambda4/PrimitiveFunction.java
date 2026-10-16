package lambda.lambda4;

import java.util.function.IntFunction;
import java.util.function.IntToLongFunction;
import java.util.function.IntUnaryOperator;
import java.util.function.ToIntFunction;

public class PrimitiveFunction {
    public static void main(String[] args) {

        //기본형 매개변수, IntFunction, LongFunction, DoubleFunction
        IntFunction<String> intFunction = x -> "숫자: " + x;      // int를 받아 String으로 반환
        System.out.println("intFunction.apply(100) = " + intFunction.apply(100));

        //기본형 반환, ToIntFunction, ToLongFunction, ToDoubleFunction
        ToIntFunction<String> toIntFunction = s -> s.length();
        System.out.println("toIntFunction = " + toIntFunction.applyAsInt("korea"));

        //기본형 매개변수, 기본형 반환
        IntToLongFunction intToLongFunction = x -> x * 100L;
        System.out.println("intToLongFunction = " + intToLongFunction.applyAsLong(30));

        //IntUnaryOperator: int -> int
        IntUnaryOperator intUnaryOperator = x -> x * 10;
        System.out.println("intUnaryOperator = " + intUnaryOperator.applyAsInt(10));

        //기타, IntConsumer, IntSupplier, IntPredicate
    }
}
