
public class Array<E> {
    // 成员变量
    private E[] data;
    private int size;

    /**
     * 构造函数，传入数组的容量capacity构造Array
     * @param capacity
     */
    public Array(int capacity) {
//        data = new E[capacity];//不支持new一个泛型数组
        data = (E[])new Object[capacity];
        size = 0;
    }

    /**
     * 无参数的构造函数，默认数组的容量capacity = 10
     */
    public Array(){
        this(10);
    }

    /**
     * 获取数组中的元素个数
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 获取数组的容量
     * @return
     */
    public int getCapacity(){
        return data.length;
    }

    /**
     * 返回数组是否为空
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 向数组末尾添加元素e
     * @param e
     */
    public void addLast (E e) {
        //先查看数组是否有剩余容量
//        if(size == data.length)
//            throw new IllegalArgumentException("AddLast failed. Array is full.");
//        data[size] = e;
//        size++;
        add(size,e);
    }

    /**
     * 向数组开头添加元素e
     * @param e
     */
    public void addFirst(E e) {
        add(0,e);
    }

    /**
     * 向数组索引为index的位置插入元素e
     * @param index
     * @param e
     */
    public void add(int index, E e) {

        // 判断index是否合法
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size");
        // 如果数组已满，进行resize操作
        if (size == data.length)
            resize(2 * data.length);
        for (int i = size - 1; i >= index; i--)
            data[i + 1] = data[i];
        data[index] = e;
        size ++;
    }





    /**
     * 获取index索引位置的元素
     * @param index
     * @return
     */
    public E get(int index) {
        // 判断index是否合法
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed. Require index >= 0 and index < size");

        return data[index];
    }

    /**
     * 修改index索引位置的元素为e
     * @param index
     */
    public void set(int index,E e) {
        // 判断index是否合法
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Set failed. Require index >= 0 and index < size");

        data[index] = e;
    }

    /**
     * 查找数组中是否有元素e
     * @param e
     * @return
     */
    public boolean contains(E e) {
        for(int i = 0; i < size; i++){
            if (data[i] == e)
                return true;
        }
        return false;
    }

    /**
     * 查找数组中元素e所在的索引，如果不存在元素e, 则返回-1
     * @param e
     * @return
     */
    public int find(E e) {
        for(int i = 0; i < size; i++) {
            if (data[i] == e)
                return i;
        }
        return -1;
    }

    /**
     * 从数组中删除index位置的元素，返回删除的元素
     * @param index
     * @return
     */
    public E remove(int index) {
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Remove failed. Index is illegal.");
        E ret =  data[index];

        for(int i = index +1; i<size; i++)
            data[i-1] = data[i];
        size--;
        data[size] = null;// 原来data[size]指向的元素（loitering objects)变为空，便于垃圾回收

        // 当删除元素后数组中元素数量减少到容积的一半时，进行缩容
        if(size == data.length/2)
            resize(data.length / 2);
        return ret;
    }

    /**
     * 从数组中删除最后一个元素，返回删除的元素
     * @return
     */
    public E removeLast() {
        return remove(size-1);
    }

    /**
     * 从数组中删除第一个元素，返回删除的元素
     * @return
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * 从数组中删除元素e
     * @param e
     */
    public void removeElement(E e) {
        int index = find(e);
        if(index != -1)
            remove(index);
    }

    public boolean ifRemoveElement(E e) {
        int index = find(e);
        if(index != -1) {
            remove(index);
            return true;
        }
        return false;
    }

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();
        result.append(String.format("Array : size = %d, capacity = %d\n",size, data.length));
        result.append('[');
        for(int i = 0; i < size; i++) {
            result.append(data[i]);
            if(i != size - 1)
                result.append(", ");
        }
        result.append(']');
        return result.toString();

    }

    private void resize(int newCapacity) {
        E[] newData = (E[])new Object[newCapacity];
        for(int i = 0; i < size; i++)
            newData[i] = data[i];
        data = newData;
    }
}