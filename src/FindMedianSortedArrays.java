
public class FindMedianSortedArrays {
    
    public double findMedianSortedArrays(int A[], int B[]) {
        int newArrayLen = A.length + B.length;
        int result[] = new int[newArrayLen];
        int i = 0;
        int j = 0;
        int k = 0;
        for (; i < A.length && j < B.length;) {
            if (A[i] < B[j]) {
                result[k++] = A[i++];
            } else {
                result[k++] = B[j++];
            }
        }
        if (i == A.length) {
            for (; j < B.length;) {
                result[k++] = B[j++];
            }
        } else {
            for (; i < A.length;) {
                result[k++] = A[i++];
            }
        }
        if (newArrayLen % 2 == 0) {
            return (result[(newArrayLen + 1) / 2] + result[(newArrayLen - 1) / 2]) / 2.0;
        } else {
            return result [newArrayLen / 2 ];
        }
    }
    
    public static void main(String[] args) {
        FindMedianSortedArrays s = new FindMedianSortedArrays();
        double result = s.findMedianSortedArrays(new int[] {}, new int[] {2, 3});
        System.out.println(result);
    }
}
