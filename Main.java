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
            if(i != 8){
                numbers.add(i); //create the numbers list without the 8
            }    
        }
        System.out.println(8); //put the 8 on screen

        //add 8 to sums 
        SUMD1 += 8;
        SUMD4 += 8;
        FillRec(numbers, 2);
    }

    public static void FillRec(ArrayList<Integer> numbers, int node) {
        Integer n = numbers.get(0);
        numbers.remove(n);

        if(node == 1){
            FillRec(numbers, node+1);
            numbers.add(n);
        }

        if(numbers.size() == 0){
            FillRec(numbers, node-1);
            numbers.add(n);
        }
        System.out.print("node: " + node + " " + n + " ");

        //do the sums 
        if (node == 2) {
            SUMD1 += n;
            SUMD5 += n;
        } else if (node == 3) {
            System.out.println();
            SUMD4 += n;
            SUMD2 += n;
        } else if (node == 4) {
            SUMD1 += n;
            SUML1 += n;
            SUMD6 += n;
        } else if (node == 5) {
            SUMD5 += n;
            SUML1 += n;
            SUMD2 += n;
        } else if (node == 6) { // value to be found: SUML1
            System.out.println();
            SUMD3 += n;
            SUML1 += n;
            SUMD4 += n;
        } else if (node == 7) {
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
        } else if (node == 10) { //compare with SUML2
            System.out.println();
            SUML2 += n;
            SUMD4 += n;
            if(SUML2 != SUML1){
                SUML2 -= n;
                SUMD4 -= n;
            }
        } else if (node == 11) { //compare with SUMD1
            SUMD1 += n;
            if(SUMD1 != SUML1){
                SUMD1 -= n;
                FillRec(numbers, node);
                numbers.add(n);
            }
            
            SUML3 += n;
        } else if (node == 12) { //compare with SUMD2
            SUMD2 += n;
            if(SUMD2 != SUML1){
                SUMD2 -= n;
                FillRec(numbers, node);
                numbers.add(n);
            }
            SUML3 += n;
        } else if (node == 13) { //compare with SUMD6 and SUMD3
            SUMD6 += n;
            SUMD3 += n;
            if(SUMD6 != SUML1 || SUMD3 != SUML1){
                SUMD6 -= n;
                SUMD3 -= n;
                FillRec(numbers, node);
                numbers.add(n);
            }
            SUML3 += n;
        } else if (node == 14) { //compare with SUMD5
            SUMD5 += n;
            if(SUMD5 != SUML1){
                SUMD5 -= n;
                FillRec(numbers, node); 
                numbers.add(n);
            }
            SUML3 += n;
        } else if (node == 15) { //compare with SUML3 and SUMD4
            System.out.println();
            SUMD4 += n;
            SUML3 += n;
            if(SUMD4 != SUML1 || SUML3 != SUML1){
                SUMD4 -= n;
                SUML3 -= n;
                FillRec(numbers, node);
                numbers.add(n);
            }
        }
        FillRec(numbers, node+1);
        numbers.add(n);
    }
}

