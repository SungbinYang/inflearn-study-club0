package me.sungbin.blog;

import java.util.function.*;

/**
 * @author : rovert
 * @packageName : me.sungbin.blog
 * @fileName : BlogExample
 * @date : 2/21/24
 * @description :
 * ===========================================================
 * DATE 			AUTHOR			 NOTE
 * -----------------------------------------------------------
 * 2/21/24       rovert         최초 생성
 */
public class BlogExample {
    public static void main(String[] args) {

        /**
         * 순수함수프로그래밍을 할려면 외부에 있는 값을 변경하거나 참조하면 안된다. 함수 내부 및 파라미터만 가지고 써야한다.
         */
//        int baseNumber = 10;
//        RunSomething runSomething = number -> number + baseNumber;
//        System.out.println(runSomething.doIt(2));
//
//        UnaryOperator<Integer> plus10 = (i) -> i + 10;
//        UnaryOperator<Integer> multiply2 = (i) -> i * 2;
//        Function<Integer, Integer> multiply2AndPlus10 = plus10.compose(multiply2);
//
//        Consumer<Integer> printT = System.out::println;
//        Supplier<Integer> get10 = () -> 10;
//
//        Predicate<String> startsWithSungbin = (str) -> str.startsWith("sungbin");
//
//        System.out.println(plus10.apply(1));
//        System.out.println(multiply2.apply(1));
//        System.out.println(multiply2AndPlus10.apply(2));
//        System.out.println(plus10.andThen(multiply2).apply(2));
//        printT.accept(10);
//        System.out.println(get10.get());
//        System.out.println(startsWithSungbin.test("sungbin"));

        UnaryOperator<Integer> plus10 = (i) -> i + 10;
        UnaryOperator<Integer> multiply2 = (i) -> i * 2;
        System.out.println(plus10.andThen(multiply2).apply(2));

        Supplier<Integer> get10 = () -> 10;
        BinaryOperator<Integer> sum = Integer::sum;

        BlogExample example = new BlogExample();
        example.run();
    }

    private void run() {

        int baseNumber = 10;

        // 내부 클래스 :: 쉐도잉 가능
        class LocalClass {
            void printBaseNumber() {
                int baseNumber = 11;
                System.out.println(baseNumber);
            }
        }

        // 익명 클래스 :: 쉐도잉 가능
        Consumer<Integer> integerConsumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer baseNumber) {
                System.out.println(baseNumber);
            }
        };

        // 람다
        IntConsumer printInt = (i) -> {
            System.out.println(i + baseNumber);
        };

        printInt.accept(10);

        LocalClass localClass = new LocalClass();
        localClass.printBaseNumber();

        integerConsumer.accept(11);
    }
}
