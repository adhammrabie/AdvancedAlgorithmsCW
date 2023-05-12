package ADT;

public class doubleColorStack {
    private int[] arr;
    private int redColorTop;
    private int blueColorTop;

    public doubleColorStack(int capacity) {
        arr = new int[capacity];
        redColorTop = -1;
        blueColorTop = capacity;
    }

    public void redStackPush(int item) {
        if (redColorTop + 1 == blueColorTop) {
            throw new RuntimeException("Stack overflow");
        }
        arr[++redColorTop] = item;
    }

    public void blueStackPush(int item) {
        if (blueColorTop - 1 == redColorTop) {
            throw new RuntimeException("Stack overflow");
        }
        arr[--blueColorTop] = item;
    }

    public int redStackPop() {
        if (redColorTop == -1) {
            throw new RuntimeException("Red stack underflow");
        }
        return arr[redColorTop--];
    }

    public int blueStackPop() {
        if (blueColorTop == arr.length) {
            throw new RuntimeException("Blue stack underflow");
        }
        return arr[blueColorTop++];
    }

    public boolean isRedStackEmpty() {
        return redColorTop == -1;
    }

    public boolean isBlueStackEmpty() {
        return blueColorTop == arr.length;
    }

    public boolean isRedStackFull() {
        return redColorTop + 1 == blueColorTop;
    }

    public boolean isBlueStackFull() {
        return blueColorTop - 1 == redColorTop;
    }
    public static void main(String[] args) {
    	doubleColorStack stack = new doubleColorStack(10);
        stack.redStackPush(15);
        stack.blueStackPush(20);
        stack.redStackPush(25);
        stack.blueStackPush(30);
        System.out.println(stack.redStackPop()); 
        System.out.println(stack.blueStackPop()); 
    }
}