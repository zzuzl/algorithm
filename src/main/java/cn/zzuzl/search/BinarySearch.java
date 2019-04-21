package cn.zzuzl.search;

// 有序数组的二分查找
public class BinarySearch {

    // 递归
    static int search(int[] a, int low, int high, int val) {
        if (low > high) {
            return -1;
        }
        int mid = low + (high - low) / 2;
        if (a[mid] == val) {
            return mid;
        } else if (a[mid] > val) {
            return search(a, low, mid - 1, val);
        } else {
            return search(a, mid + 1, high, val);
        }
    }

    // 非递归(查找第一个等于val的,查找最后一个的写法类似)
    static int search2(int[] a, int val) {
        int low = 0, high = a.length-1, mid = (low + high) / 2;
        while (low <= high) {
            if (a[mid] > val) {
                high = mid-1;
            } else if (a[mid] < val) {
                low = mid +1;
            } else {
                if (mid == 0 || a[mid - 1] != val) {
                    return mid;
                } else {
                    high = mid-1;
                }
            }
        }
        return -1;
    }

    // 查找第一个大于等于给定值的元素位置
    static int search3(int[] a, int val) {
        int low = 0, high = a.length-1, mid = (low + high) / 2;
        while (low <= high) {
            mid = (low + high) / 2;
            if (a[mid] >= val) {
                if (mid == 0 || a[mid - 1] < val) {
                    return mid;
                } else {
                    high = mid -1;
                }
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int a[] = new int[]{1,2,5,5,5,15};
        int res = search3(a, 0);
        System.out.println(res);
    }
}
