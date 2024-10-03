package valuePropagation;

/**
 * @Description
 * @Author qsj
 * @Date 2024/07/30
 */
public class test1 {
    public static void main(String[] args) {
        Person p = new Person("小李");
        Person p1 = new Person("小王");
        exchange(p, p1);
        System.out.println(p.getName()); // 这里将打印 p 的名字
        System.out.println(p1.getName()); // 这里将打印 p1 的名字
    }

    static class Person {
        private int age;
        private String name;

        public Person(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public static void exchange(Person p1, Person p2) {
        Person temp = p1;
        p1 = p2;
        p2 = temp;
        System.out.println(p1.getName()); // 这里将打印交换后 p1 的名字
        System.out.println(p2.getName()); // 这里将打印交换后 p2 的名字
    }
}
