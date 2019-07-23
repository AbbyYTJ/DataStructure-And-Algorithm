public class Main {
    public static void main(String[] args) {

        // Java中新建数组只需在类型后加[]，只能存储同一种类型的元素
        // 创建数组开辟空间时必须声明可以存储多少元素，这是使用数组的局限性，后面会进行改进
        int[] arr = new int[10];

        // 可以使用for循环对数组进行赋值
        for(int i = 1; i < arr.length; i++)
            arr[i] = i;

        // 也可以在声明数组同时对数组进行赋值
        int[] scores = new int[]{100,99,78};

        // 打印输出用for循环或for-each，这是数组的可遍历/迭代特性。
        for(int i =0;i< scores.length;i++)
            System.out.println(scores[i]);

        for(int score:scores)
            System.out.println(score);

        // 使用索引，修改数组元素
        scores[0] = 96;
        for(int i = 0; i < scores.length; i++)
            System.out.println(scores[i]);
    }
}
