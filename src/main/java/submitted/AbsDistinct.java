package submitted;

/**
 * "有序数组中绝对值不同的数的个数"指的是,一个已经排好序的整数数组中绝对值不相同的数字的个数; 例如: [-5,-3,-1,0,3,6]
 * 绝对值不同的数的个数为5,因为其中有5个不同的绝对值: 0, 1, 3, 5, 6 请返回给定有序数组中绝对值不同的数的个数.
 */
public class AbsDistinct {

    public static void main(String[] args) {
        int data[] = { -5, -3, -1, 0, 3, 6, 7 };
        System.out.println(absDistinct(data));
    }

    static public int absDistinct(int data[]) {
        int i = 0;
        int j = data.length - 1;
        int count = 0;
        while (j - i > 0) {
            // 去掉重复
            if (j > 1 && data[j] == data[j - 1]) {
                j--;
            }

            if (data[i] == data[i + 1]) {
                i++;
            }

            // 拿最后一个数+最前面一个数，如果大后索引-1，如果小，前索引+1,如果相等后索引-1，前索引+1
            if (data[j] + data[i] > 0) {
                j--;
                count++;
            } else if (data[j] + data[i] == 0) {
                j--;
                i++;
                count++;
            } else if (data[j] + data[i] < 0) {
                i++;
                count++;
            }
        }
        if (j == i) {
            count++;
        }
        return count;
    }
}