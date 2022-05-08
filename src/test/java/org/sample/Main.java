package org.sample;

public class Main {

    public static void main(String[] args) {

        int[] a = new int[]{1,3,7,2,3,34,246,2,56,6,3,54,5,6,7,3,6,8,9,8,7,7,5};

        QickSort qs = new QickSort(a.length, a);
        qs.qickSort(0, a.length - 1);
        System.out.println(qs.soutResult());

    }

}
