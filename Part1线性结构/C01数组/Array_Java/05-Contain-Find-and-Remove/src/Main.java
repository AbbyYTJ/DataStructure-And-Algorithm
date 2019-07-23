public class Main {

    public static void main(String[] args) {
	// write your code here
        Array arr = new Array(20);
        for(int i = 0; i < 10;i++)
            arr.addLast(i);
        System.out.println(arr);

        arr.remove(2);
        System.out.println(arr);

        arr.ifRemoveElement(3);
        System.out.println(arr);

    }
}
