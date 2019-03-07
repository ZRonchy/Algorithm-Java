package interview;

/**
 * Find median element using "median of medians" approach in O(n). Partition
 * array around that element (another O(n)). Now alternatively print one element
 * from lower end and one from higher end of array.
 */
public class OutPutArraySmallerthenLarger {
//    Take O(n) time to find median in the array - https://rcoh.me/posts/linear-time-median-finding/
//    Swap median value to index 0
//    Take O(n) time to partition the array on median value so that lefthalf &lt;= median arr[0]:
//    j += 1
//            else:
//    arr[i], arr[j] = arr[j], arr[i]
//    arr[i - 1], arr[0] = arr[0], arr[i - 1]
//
//    Take O(n) to weave the greater half into smaller half
//    def weave(arr):
//    i = (len(arr) - 1) / 2
//    j = len(arr) / 2
//
//            while i &gt;= 0 and j &lt; len(arr):
//            if j % 2 == 1:
//    j += 1
//    elif i % 2 == 1:
//    i -= 1
//            else:
//    arr[i], arr[j] = arr[j], arr[i]
//    i -= 2
//    j += 2
//            return arr
}
