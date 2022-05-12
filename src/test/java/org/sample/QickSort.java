package org.sample;

//https://www.youtube.com/watch?v=4Da4HzcBuLo

public class QickSort {

    private int[] array;
    private final int len;

    public QickSort(int len, int[] array){

        this.len = len;
        this.array = array;

    }

    public void qickSort(int strart, int end){

        if (strart >= end){

            return;

        }

        //инициализируем значения начала и конца по умолчанию задаём индексы начала и конца массива

        int i = strart;
        int j = end;
        int cuurentpoz = i - (i - j)/2;

        while (i < j){

            while (array[cuurentpoz] >= array[i] && i < cuurentpoz){

                i++;

            }
            while (array[cuurentpoz] <= array[j] && j > cuurentpoz){

                j--;

            }

            // пройдясь по циклу обнаружим девиантные позиции которые нужно поменять местами, тогда:

            if (i < j){

                int t = array[i];
                array [i] = array[j];
                array[j] = t;

                // поменяли местами


                /** @param(ДляРебят)
                 для првильного результата на последних этапах сортировки необходимо отловить момент
                 когда центральный элемент будет равен элементу от левой границы или от правой границы,
                 тогда иы просто заменяем серединный элемент на текущий от нужной нам границыб тогда
                 на следующей итерации рекурсии обеспечен правильный выход из неёё с уже отсортированным массивом
                */

                if (i == cuurentpoz){

                    cuurentpoz = j;

                }else if (j == cuurentpoz){

                    cuurentpoz = i;

                }

            }

        }

        // здесь разбиваем массив на две части и параллельно сортируем

        qickSort(strart, cuurentpoz);
        qickSort(cuurentpoz + 1, end);

    }

    public String soutResult(){

        StringBuilder s = new StringBuilder();

        for (int i = 0; i < len; i++) {

            s.append(array[i]).append(" ");

        }

        return s.toString();

    }

}
