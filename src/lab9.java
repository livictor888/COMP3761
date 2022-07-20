public class lab9 {

    static int fibo(int[] cache, int input) {
        if (input == 0) return 0;
        if (input == 1) return 1;
        if (cache[input] != 0) {
            return cache[input];
        }
        cache[input] = fibo(cache, input - 1) + fibo(cache, input - 2);
        return cache[input];
    }

    public static void main(String[] args) {
        int max = 10_000;
        int[] cache = new int[max];

        System.out.println("Fibo value of 3 is:" + fibo(cache,3));
        System.out.println("Fibo value of 7 is:" + fibo(cache,7));
        System.out.println("Fibo value of 5 is:" + fibo(cache,5));
    }
}
