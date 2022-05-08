package org.sample;

import junit.framework.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class Tests {

    @Test
    public void test1() throws RuntimeException{

        int[] a = new int[]{1,3,7,2,3,34,246,2,56,6,3,54,5,6,7,3,6,8,9,8,7,7,5};

        QickSort qs = new QickSort(a.length, a);
        qs.qickSort(0, a.length - 1);

        Assert.assertEquals(qs.soutResult(), "1 2 2 3 3 3 3 5 5 6 6 6 7 7 7 7 8 8 9 34 54 56 246 ");

    }

    @Test
    public void test2() throws RuntimeException{

        int[] a = new int[]{0,0,0,0,0,0,0,0};

        QickSort qs = new QickSort(a.length, a);
        qs.qickSort(0, a.length - 1);

        Assert.assertEquals(qs.soutResult(), "0 0 0 0 0 0 0 0 ");

    }

    @Test
    public void test3() throws RuntimeException{

        int[] a = new int[]{0};

        QickSort qs = new QickSort(a.length, a);
        qs.qickSort(0, a.length - 1);

        Assert.assertEquals(qs.soutResult(), "0 ");

    }

    @Test
    public void test4() throws RuntimeException{

        int[] a = new int[]{};

        QickSort qs = new QickSort(a.length, a);
        qs.qickSort(0, a.length - 1);

        Assert.assertEquals(qs.soutResult(), "");

    }

}
