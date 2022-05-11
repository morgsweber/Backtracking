/*  PROJETO E OTIMIZAÇÃO DE ALGORITMOS
    Prof. João Batista
    Turma 010
    Morgana Weber
    Trabalho Prático 3
*/

public class Main {
    public static int[] used = new int[15];

    public static void main(String[] args) {
        int[] numbers = {2,3,4,5,6,7,9,10,11,12,13,14,15,16};
        used[0] = 8;
        FillRec(1, used.length, numbers, 0,0,0,0,0,0,0,0,0);
    }

    public static void FillRec(int node, int size, int[] numbers, int suml1, int suml2, int suml3, int sumd1, int sumd2, int sumd3, int sumd4, int sumd5, int sumd6) {
        if(node >= size){
            for(int i = 0; i<size; i++){
                System.out.print(used[i] + " ");
            }
            System.out.println();
            return;
        }   

        for(int i=0; i<size-1; i++){
            if(numbers[i] == 0){ continue; }
            int n = numbers[i];  

            if(node == 5){ 
                suml1 = used[3] + used[4] + n;
            }
            else if(node == 9){
                suml2 = used[6] + used[7] + used[8] + n;
                if(suml2 != suml1){ continue; }
            }
            else if(node == 10){
                sumd1 = used[0] + used[1] + used[3] + used[6] + n;
                if(sumd1 != suml1){ continue; }
            }
            else if(node == 11){
                sumd2 = used[2] + used[4] + used[7] + n;
                if(sumd2 != suml1){ continue; }
            }
            else if(node == 12){
                sumd3 = used[5] + used[8] + n;
                sumd6 = used[3] + used[7] + n;
                if(sumd3 != suml1 || sumd6 != suml1){ continue; }
            }
            else if(node == 13){
                sumd5 = used[1] + used[4] + used[8] + n;
                if(sumd5 != suml1){ continue; }
            }
            else if(node == 14){
                suml3 = used[10] + used[11] + used[12] + used[13] + n;
                sumd4 = used[0] + used[2] + used[5] + used[9] + n;   
                if(sumd4 != suml1 || suml3 != suml1){ continue; }
            }

            used[node] = n;
            numbers[i] = 0;
            FillRec(node+1, size, numbers, suml1, suml2, suml3, sumd1, sumd2, sumd3, sumd4, sumd5, sumd6);
            numbers[i] = used[node];
        }        
    }
}

