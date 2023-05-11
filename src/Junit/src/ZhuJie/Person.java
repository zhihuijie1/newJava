package ZhuJie;

public class Person {

    /**
     * 下面是eat方法，实现了XXXX方法
     * @param num1 就餐人数
     * @param num2 点菜个数
     */
    public void eat(int num1 , int num2) {

    }

    /**
     * @param age 年龄
     * @return int 返回10
     * @exception RuntimeException 当年龄过大的时候
     * @exception IndexOutOfBoundsException 当年龄过小的时候
     * @see Student
     */


    public int sleep(int age){
        new Student();
        if(age > 1000) {
            throw new RuntimeException();
        }

        if(age < 0){
            throw new IndexOutOfBoundsException();
        }
        return 10;
    }

    @Deprecated
    public static int print() {
        return 100;
    }

}
