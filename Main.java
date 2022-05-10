/*  PROJETO E OTIMIZAÇÃO DE ALGORITMOS
    Prof. João Batista
    Turma 010
    Morgana Weber
    Trabalho Prático 3
*/

import java.util.ArrayList;

public class Main {
    public static int SUML1;
    public static int SUML2;
    public static int SUML3;

    public static int SUMD1;
    public static int SUMD2;
    public static int SUMD3;

    public static int SUMD4;
    public static int SUMD5;
    public static int SUMD6;

    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        for (int i = 2; i <= 16; i++) {
            numbers.add(i);
        }
        FillRec(numbers, 1, 0, 0, 0, false);
    }

    public static void FillRec(ArrayList<Integer> numbers, int node, int find, int get, int last, boolean ready) {
        if(node < 1){
            FillRec(numbers, 1, 0, get+1, last, false);
        }
        if (numbers.size() == 0) {
            return;
        }

        if (get >= numbers.size()) {
            return;
        }

        if (node == 1) {
            if (numbers.get(6) != 8) {
                SUML1 = 0;
                SUML2 = 0;
                SUML3 = 0;
                SUMD1 = 0;
                SUMD2 = 0;
                SUMD3 = 0;
                SUMD4 = 0;
                SUMD5 = 0;
                SUMD6 = 0;
                numbers.add(6, 8);
                get++;
                find = 0;
            }
            Integer n = numbers.get(6);
            numbers.remove(6);
            System.out.println(n);
            SUMD1 += n;
            SUMD4 += n;
            FillRec(numbers, node + 1, find, get, n, ready);
        } else if (node != 1) {
            Integer n = numbers.get(get);
            numbers.remove(n);
            System.out.print(n + " ");
            if (node == 2) {
                SUMD1 += n;
                SUMD5 += n;
            } else if (node == 3) {
                System.out.println();
                SUMD4 += n;
                SUMD2 += n;
            } else if (node == 4) {
                if(ready){
                    ready = false;
                    SUML1 -= last;
                    SUMD1 -= last;
                    SUMD6 -= last;
                }
                SUMD1 += n;
                SUML1 += n;
                SUMD6 += n;
            } else if (node == 5) {
                if(ready){
                    ready = false;
                    SUML1 -= last;
                    SUMD5 -= last;
                    SUMD2 -= last;
                }
                SUMD5 += n;
                SUML1 += n;
                SUMD2 += n;
            } else if (node == 6) { // first sum
                if(ready){
                    SUML1 -= last;
                    SUMD3 -= last;
                    SUMD4 -= last;
                }
                ready = true;
                System.out.println();
                SUMD3 += n;
                SUML1 += n;
                SUMD4 += n;
                find = SUML1;
            }
            else if (node == 7) {
                SUMD1 += n;
                SUML2 += n;
            } else if (node == 8) {
                SUMD2 += n;
                SUML2 += n;
                SUMD6 += n;
            } else if (node == 9) {
                SUMD3 += n;
                SUML2 += n;
                SUMD5 += n;
            } else if (node == 10) { // encontrou a segunda soma - TODO: comparar find com SUML2
                System.out.println();
                SUML2 += n;
                if (SUML2 != find) {
                    SUML2 -= n;
                    numbers.add(n);
                    FillRec(numbers, node, find, get, last, ready);
                }
                SUMD4 += n;
            } else if (node == 11) { // encontrou - TODO: comparar SUMDL1 com find
                SUMD1 += n;
                if (SUMD1 != find) {
                    SUMD1 -= n;
                    numbers.add(n);
                    FillRec(numbers, node, find, get, last, ready);
                }
                SUML3 += n;
            } else if (node == 12) {// SUMD2 com find
                SUMD2 += n;
                if (SUMD2 != find) {
                    SUMD2 -= n;
                    numbers.add(n);
                    FillRec(numbers, node, find, get, last, ready);
                }
                SUML3 += n;
            } else if (node == 13) { // TODO: comparar SUMD6, SUMD3 com find
                
                SUMD6 += n;
                SUMD3 += n;
                if (SUMD6 != find) {
                    SUMD6 -= n;
                    numbers.add(n);
                    FillRec(numbers, node, find, get, last, ready);
                }
                if (SUMD3 != find) {
                    SUMD3 -= n;
                    numbers.add(n);
                    FillRec(numbers, node, find, get, last, ready);
                }
                SUML3 += n;
            } else if (node == 14) { // SUMD5 com find
                SUMD5 += n;
                if (SUMD5 != find) {
                    SUMD5 -= n;
                    numbers.add(n);
                    FillRec(numbers, node, find, get, last, ready);
                }
                SUML3 += n;
            } else if (node == 15) { // SUMD4 E SUML3 com find
                SUMD4 += n;
                if (SUMD4 != find) {
                    SUMD4 -= n;
                    numbers.add(n);
                    FillRec(numbers, node, find, get, last, ready);
                }
                SUML3 += n;
                if (SUML3 != find) {
                    SUML3 -= n;
                    numbers.add(n);
                    FillRec(numbers, node, find, get, last, ready);
                }
            }

            if (ready) {
                if (SUML1 > find || SUML2 > find || SUML3 > find || SUMD1 > find || SUMD2 > find || SUMD3 > find
                        || SUMD4 > find || SUMD5 > find || SUMD6 > find) {
                    FillRec(numbers, node-1, find, get, last, ready);
                }
            }
            FillRec(numbers, node+1, find, get, n, ready);
        }
    }
}
