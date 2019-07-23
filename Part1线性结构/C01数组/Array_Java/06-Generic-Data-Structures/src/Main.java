public class Main {

    public static void main(String[] args) {
	// write your code here

        Array<Integer> arr = new Array<>(20);
        for(int i = 0; i <10; i++)
            arr.addLast(i);

        System.out.println(arr);

        Array<Student> student = new Array<>();
        student.addLast(new Student("Charlie", 95));
        student.addLast(new Student("Bob", 89));
        student.addLast(new Student("Alice", 92));
        System.out.println(student);
    }
}
