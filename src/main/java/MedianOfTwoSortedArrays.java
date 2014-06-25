/**
 * <p>
 * There are two sorted arrays A and B of size m and n respectively. Find the
 * median of the two sorted arrays. The overall run time complexity should be
 * O(log (m+n)).
 * </p>
 * 
 * @see <a
 *      href="https://oj.leetcode.com/problems/median-of-two-sorted-arrays/">Leetcode
 *      Median of Two Sorted Arrays Problem</a>
 * @author Wei Gao
 */
public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int A[], int B[]) {
        if (A.length == 0 && B.length == 0) {
            return 0.0D;
        } else if (A.length == 0) {
            return findMedianSortedArray(B);
        } else if (B.length == 0) {
            return findMedianSortedArray(A);
        } else {
            if (A.length > B.length) {
                return findMedianUtil(B, 0, B.length, A, 0, A.length);
            } else {
                return findMedianUtil(A, 0, A.length, B, 0, B.length);
            }
        }
    }

    private double findMedianSortedArray(int A[]) {
        int idx = (A.length - (1 - (A.length % 2))) / 2;
        double value = A[idx];
        if ((A.length % 2) == 0) {
            value += A[idx + 1];
            value /= 2;
        }
        return value;
    }

    private double max(double a, double b) {
        return a > b ? a : b;
    }

    private double min(double a, double b) {
        return a < b ? a : b;
    }

    private double MO2(double a, double b) {
        return (a + b) / 2;
    }

    private double MO3(double a, double b, double c) {
        return a + b + c - max(a, max(b, c)) - min(a, min(b, c));
    }

    private double MO4(double a, double b, double c, double d) {
        double max = max(a, max(b, max(c, d)));
        double min = min(a, min(b, min(c, d)));
        return (a + b + c + d - max - min) / 2;
    }

    private double findMedianUtil(int A[], int offsetA, int lengthA, int B[],
            int offsetB, int lengthB) {
        if (lengthA == 1) {
            if (lengthB == 1) {
                return MO2(A[offsetA], B[offsetB]);
            }
            if ((lengthB & 1) == 1) {
                return MO2(
                        B[(lengthB / 2) + offsetB],
                        MO3(A[offsetA], B[(lengthB / 2) + offsetB - 1],
                                B[(lengthB / 2) + offsetB + 1]));
            }
            return MO3(B[(lengthB / 2) + offsetB], B[(lengthB / 2) + offsetB
                    - 1], A[offsetA]);
        } else if (lengthA == 2) {
            if (lengthB == 2) {
                return MO4(A[offsetA], A[offsetA + 1], B[offsetB],
                        B[offsetB + 1]);
            }
            if ((lengthB & 1) == 1) {
                return MO3(B[(lengthB / 2) + offsetB],
                        max(A[offsetA], B[(lengthB / 2) + offsetB - 1]),
                        min(A[offsetA + 1], B[(lengthB / 2) + offsetB + 1]));
            }
            return MO4(B[(lengthB / 2) + offsetB], B[(lengthB / 2) + offsetB
                    - 1], max(A[offsetA], B[(lengthB / 2) + offsetB - 2]),
                    min(A[offsetA + 1], B[(lengthB / 2) + offsetB + 1]));
        }
        int idxA = (lengthA - 1) / 2;
        int idxB = (lengthB - 1) / 2;
        if (A[idxA + offsetA] < B[idxB + offsetB]) {
            return findMedianUtil(A, offsetA + idxA, lengthA / 2 + 1, B,
                    offsetB, lengthB - idxA);
        } else {
            return findMedianUtil(A, offsetA, lengthA / 2 + 1, B, offsetB
                    + idxA, lengthB - idxA);
        }
    }
}
