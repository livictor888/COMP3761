import java.util.Arrays;

public class lab4 {

    static int findMax(int[] a, int left, int right) {

        if (left == right) {
            return right;
        } else {
            int middle = (left + right) / 2;
            int maxLeft = findMax(a, left, middle);
            int maxRight = findMax(a, middle + 1, right);
            if (a[maxLeft] >= a[maxRight]) {
                return maxLeft;
            } else {
                return maxRight;
            }
        }
    }

    static int[] mergeSort(int[] A) {
        if (A.length > 1) {

            int sizeOfArrayB = (A.length / 2);
            int sizeOfArrayC = A.length - sizeOfArrayB;

            int[] B = new int[sizeOfArrayB];
            int[] C = new int[sizeOfArrayC];

            for (int i = 0; i < sizeOfArrayB; i++) {
                B[i] = A[i];
            }
            for (int j = 0; j < sizeOfArrayC; j++) {
                C[j] = A[sizeOfArrayB + j];
            }

            mergeSort(B);
            mergeSort(C);
            merge(B, C, A);
        }
        return A;
    }

    static void merge(int[] B, int[] C, int[] A) {
        int iteratorB = 0;
        int iteratorC = 0;
        int iteratorA = 0;

        while (iteratorB < B.length && iteratorC < C.length) {
            if (B[iteratorB] <= C[iteratorC]) {
                A[iteratorA] = B[iteratorB];
                iteratorB++;
            } else {
                A[iteratorA] = C[iteratorC];
                iteratorC++;
            }
            iteratorA++;
        }

        int sizeOfRemainingArrayC = C.length - iteratorC;
        int sizeOfRemainingArrayB = B.length - iteratorB;

        if (iteratorB == B.length) {
            for (int index = iteratorC; index < sizeOfRemainingArrayC; index++) {
                A[B.length + index] = C[index];
            }
        } else {
            for (int index = iteratorB; index < sizeOfRemainingArrayB; index++) {
                A[C.length + index] = B[index];
            }
        }
    }

    public static void main(String[] args) {
        int a[] = {2, 5, 8, 3, 6, 9, 1, 6, 5};
        int b[] = {3, 2, 7, 6, 8};
        System.out.printf("Q1) findMax\nMaximum element: position %d\n", findMax(a, 0, a.length - 1) + 1);

        System.out.print("Q2) mergeSort\n");
        System.out.println("Before sort:");

        for (int i = 0; i < b.length; i++)
            System.out.print(b[i] + ", ");

        mergeSort(b);

        System.out.println("\nAfter sort:");

        for (int i = 0; i < b.length; i++)
            System.out.print(b[i] + ", ");
    }

}
