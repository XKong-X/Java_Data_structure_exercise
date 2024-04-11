/**
 * ClassName: Sort
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author 行空XKong
 * @Create 2024/4/8 23:28
 * @Version 1.0
 */
public class Sort {
    /**
     * 插入排序
     * 时间复杂度：最坏情况：O(n^2),最好情况：O(n)
     * 空间复杂度：O(1)
     * 稳定性：稳定
     *
     * @param arr
     */
    public static void insertSort(int[] arr) {
        //默认第一个元素有序
        for (int i = 1; i < arr.length; ++i) {
            int tmp = arr[i];
            int j = i - 1;
            for (; j >= 0; --j) {
                //升序
                if (tmp < arr[j]) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = tmp;
        }
    }

    /**
     * 希尔排序(缩小增量排序)
     * 时间复杂度：约O(n^1.3)
     * 空间复杂度：O(1)
     * 稳定性：不稳定
     *
     * @param arr
     */
    public static void shellSort(int[] arr) {
        int gap = arr.length;
        while (gap > 1) {
            gap /= 2;
            shell(arr, gap);
        }
    }

    /**
     * 对每组进行插入排序
     *
     * @param arr
     * @param gap
     */
    private static void shell(int[] arr, int gap) {
        //默认第一个元素有序
        for (int i = gap; i < arr.length; ++i) {
            int tmp = arr[i];
            int j = i - gap;
            for (; j >= 0; j -= gap) {
                //升序
                if (tmp < arr[j]) {
                    arr[j + gap] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + gap] = tmp;
        }
    }

    /**
     * 选择排序
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     * 稳定性：不稳定
     *
     * @param arr
     */
    public static void selectSort(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            int minIndex = i;
            for (int j = i + 1; j < len; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                swap(arr, i, minIndex);
            }
        }
    }

    //交换
    private static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    /**
     * 双向选择排序
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     * 稳定性：不稳定
     *
     * @param arr
     */
    public static void selectSort2(int[] arr) {
        int l = 0;
        int r = arr.length - 1;
        while (l < r) {
            int minIndex = l;
            int maxIndex = l;
            for (int i = l + 1; i <= r; ++i) {
                if (arr[i] < arr[minIndex]) {
                    minIndex = i;
                }
                if (arr[i] > arr[maxIndex]) {
                    maxIndex = i;
                }
            }
            swap(arr, minIndex, l);
            //防止第一个是最大值和最小的交换后跑了（最大值的位置变成了最小值）
            if (maxIndex == l) {
                maxIndex = minIndex;
            }
            swap(arr, maxIndex, r);
            ++l;
            --r;
        }
    }

    //建堆
    private static void createHeap(int[] arr) {
        int child = arr.length - 1;
        for (int parent = (child - 1) / 2; parent >= 0; --parent) {
            siftDown(arr, parent, arr.length);
        }
    }

    //向下调整
    private static void siftDown(int[] arr, int parent, int length) {
        int child = parent * 2 + 1;//假设左树最大
        //child < length说明有子树没遍历
        while (child < length) {
            //child+1 < length用来防止数组越界
            if (child + 1 < length && arr[child] < arr[child + 1]) {
                ++child;//把左树坐标变成右树坐标（因为右树更大）
            }
            //子节点数据大于父节点数据则交换
            if (arr[child] > arr[parent]) {
                swap(arr, child, parent);
                parent = child;//交换完成后把子节点坐标变成父节点坐标
                child = parent * 2 + 1;//新的子节点坐标
            } else {
                break;
            }
        }
    }

    /**
     * 堆排序
     * 时间复杂度：O(n*log₂n)
     * 空间复杂度：O(1)
     * 稳定性：不稳定
     *
     * @param arr
     */
    public static void heapSort(int[] arr) {
        createHeap(arr);
        int end = arr.length - 1;
        while (end > 0) {
            swap(arr, 0, end);
            siftDown(arr, 0, end);
            --end;
        }
    }

    /**
     * 冒泡排序
     * 时间复杂度（优化情况下）：最坏情况：O(n^2),最好情况：O(n)
     * 空间复杂度：O(1)
     * 稳定性：稳定
     * 优化：判断上一次比较是否有交换
     *
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; ++i) {
            boolean flag = false;//优化代码
            for (int j = 0; j < arr.length - 1 - i; ++j) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    flag = true;
                }
            }
            //优化代码
            if (!flag) {
                break;
            }
        }
    }

    /**
     * 快速排序
     * 时间复杂度：最好情况：O(n*log₂n)，最坏情况(逆序/有序)：O(n^2)
     * 空间复杂度：最好情况：O(log₂n)，最坏情况(逆序/有序)：O(n)
     * 稳定性：不稳定
     *
     * @param arr
     */
    public static void quickSort(int[] arr) {
        quick(arr, 0, arr.length - 1);
    }

    //递归执行partitionHoare方法
    private static void quick(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivot = partitionPointer(arr, start, end);
        quick(arr, start, pivot - 1);
        quick(arr, pivot + 1, end);
    }

    //Hoare法
    private static int partitionHoare(int[] arr, int l, int r) {
        int tmp = arr[l];
        int i = l;//记录左边界
        while (l < r) {
            //l < r防止数组越界和超出左边界，取等号是因为要跟自己比较一次
            while (l < r && arr[r] >= tmp) {
                --r;
            }
            //l < r防止数组越界和超出右边界，取等号是因为要跟自己比较一次
            while (l < r && arr[l] <= tmp) {
                ++l;
            }
            swap(arr, l, r);
        }
        //代码到这l==r
        swap(arr, i, l);//交换左边界和l，r相遇位置的值
        return l;//返回l，r相遇的位置
    }

    //挖坑法(Hoare法的优化版)
    private static int partitionHole(int[] arr, int l, int r) {
        int tmp = arr[l];
        while (l < r) {
            //l < r防止数组越界和超出左边界，取等号是因为要跟自己比较一次
            while (l < r && arr[r] >= tmp) {
                --r;
            }
            arr[l] = arr[r];
            //l < r防止数组越界和超出右边界，取等号是因为要跟自己比较一次
            while (l < r && arr[l] <= tmp) {
                ++l;
            }
            arr[r] = arr[l];
        }
        //代码到这l==r
        arr[l] = tmp;//把左边界的值填到l，r相遇位置
        return l;//返回l，r相遇的位置
    }

    //前后指针法
    private static int partitionPointer(int[] arr, int l, int r) {
        int prev = l;
        int cur = l + 1;
        while (cur <= r) {
            //arr[cur] < arr[l]是交换条件，arr[++prev] != arr[cur]防止跟自己交换
            if (arr[cur] < arr[l] && arr[++prev] != arr[cur]) {
                swap(arr, prev, cur);//prev记录上一个大于l的位置，cur去找小于l的位置
            }
            ++cur;
        }
        //代码到这数组遍历完成
        swap(arr, prev, l);//交换左边界和最后一个大于左边界位置的值
        return prev;
    }
}
