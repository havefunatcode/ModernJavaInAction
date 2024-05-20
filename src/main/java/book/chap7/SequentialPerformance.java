package book.chap7;

import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

public class SequentialPerformance {
    public static void main(String[] args) throws RunnerException {
        Options builder = new OptionsBuilder()
                .include(ParallelStreamBenchmark.class.getSimpleName())
                .build();

        new Runner(builder).run();
    }
}
