package org.sample;

import org.openjdk.jmh.annotations.*;

import java.util.Random;


@State(Scope.Benchmark)
@BenchmarkMode(Mode.All)
@Warmup(iterations = 1, time = 1)
@Measurement(iterations =1, time = 1)
public class BenchMark {

    Random generator = new Random();

    @Benchmark
    public void bench(){

        int[] a = new int[20];

        for (int i = 0; i < a.length; i++) {

            a[i] = generator.nextInt(100);

        }

        QickSort qs = new QickSort(a.length, a);

        qs.qickSort(0, a.length - 1);

    }


}
