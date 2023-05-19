import java.util.function.Function;

public class test1 {
    public static void main(String[] args) {
        /*
        KiteFunction<Integer, Character, String> kiteFunction = FunctionTest::fuckingFucked;
        String c = kiteFunction.run(100, 'a');
        System.out.println(c);
         */

        /*
        String c = new KiteFunction<Integer, Character, String>() {
            @Override
            public String run(Integer a, Character b) {
                return a.toString() + b.toString();
            }
        }.run(100, 'a');
        System.out.println(c);
        */

        KiteFunction<Integer, Character, String> kiteFunction = (Integer a, Character b) -> {
            return a.toString() + b.toString();
        };
        String c = kiteFunction.run(10000, 'a');
        System.out.println(c);

        Function<Integer,Integer> functionalInterface = (Integer a) -> {
            return a * 2;
        };
        System.out.println(functionalInterface.apply(10));
    }
}

class FunctionTest {
    public static String fuckingFucked(Integer a, Character b) {
        return a.toString() + b.toString();
    }
}
