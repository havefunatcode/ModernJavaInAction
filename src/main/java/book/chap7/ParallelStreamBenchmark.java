package book.chap7;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
// 4Gb의 힙 공간을 제공한 환경에서 두 번 벤치마크를 수행
@Fork(value = 2, jvmArgs = {"-Xms4G", "-Xmx4G"})
public class ParallelStreamBenchmark {
    private static final long N = 10_000_000L;

    @Benchmark
    public long sequentialSum() {
        return Stream.iterate(1L, i -> i + 1).limit(N)
                .reduce(0L, Long::sum);
    }

    // 매 번 벤치마크를 실행한 다음에 가비지 컬렉터 동작 시도
    @TearDown(Level.Trial)
    public void tearDown() {
        System.gc();
    }

}
