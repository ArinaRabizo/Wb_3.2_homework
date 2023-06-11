public class Main {
    public static void main(String[] args) {
    MyList<String> list = new MyList<>();
        MyList<String> test = new MyList<>();
        test.add("2");
        test.add(1, "3");
        test.add(0, "1");
        test.add("4");
        test.add("5");
        System.out.println(test.get(0));
        System.out.println(test.toString());
        test.remove("2");
        System.out.println(test.toString());
        test.remove(3);
        test.remove("4");
        System.out.println(test.toString());
        test.remove("1");
        test.remove(0);
        System.out.println(test.toString());











    }
}