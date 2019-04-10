package cn.zzuzl.structrue;

public class Stack<T> {
    private Object[] arr;
    private int pos;
    private int len;

    public Stack(int len) {
        this.len = len;
        arr = new Object[len];
        pos = -1;
    }

    public void push(T val) {
        if (pos >= len-1) {
            throw new RuntimeException();
        }
        arr[++pos] = val;
    }

    public T pop() {
        if (pos < 0) {
            return null;
        }
        return (T)arr[pos--];
    }
}
