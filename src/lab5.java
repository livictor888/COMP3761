import java.util.Comparator;
import java.util.PriorityQueue;

public class lab5 {
    public static PriorityQueue<Integer> findSmallestElements(int[] elements, int numberOfSmallestElements)
    {
        // base case: empty array or there are fewer elements in the array than requested
        if (elements == null || elements.length < numberOfSmallestElements) {
            return null;
        }

        // create a max-heap by using a Priority Queue
        // add the number of the smallest elements wanted from the input array to the heap
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int index = 0;index< numberOfSmallestElements; index++) {
            pq.offer(elements[index]);
        }

        // for the rest of the remaining array elements
        for (int i = numberOfSmallestElements; i < elements.length; i++)
        {
            // if the current element is less than the root of the heap
            // take out the root and add in the current element
            if (elements[i] < pq.peek()) {
                pq.poll();
                pq.offer(elements[i]);
            }
        }
        // array should only contain the smallest elements
        return pq;
    }

    public static void main(String[] args)
    {
        int[] elements = {1, 10, 5, 3, 4, 7, 6, 9, 8};
        int numberOfSmallestElements = 4;

        System.out.println("The smallest "+ numberOfSmallestElements + " elements are " +
                findSmallestElements(elements, numberOfSmallestElements));
    }
}
