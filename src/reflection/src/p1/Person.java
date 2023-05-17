package p1;

import java.io.Serializable;

public class Person implements Serializable {
    // 属性
    private static final long serialVersionUID = -3975588695408316721L;
    private int age;
    private String name;

    public Person() {
    }

    // 方法
    public void sleep() {
        System.out.println("Peroson   sleep");
    }

    public static void eat() {
        System.out.println("person  eat");
    }
    //构造器

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
