package book.chap6;

public class CollectionHarness {
    public static void main(String[] args) {
        PrimeNonprime primeNonprime = new PrimeNonprime();
        long fastest = Long.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            long start = System.currentTimeMillis();
            primeNonprime.partitionPrimesWithCustomCollector(1_000_000);
            long duration = (System.currentTimeMillis() - start);
            if (duration < fastest) fastest = duration;
        }
        System.out.println("Fastest execution done in " + fastest + " msec");
    }
}
