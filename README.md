# Backtracking

// else if(count == 3 && d == 1){
        //     System.out.println("soma: " + aux);
        //     FillRec(numbers, node+1, 0, d+1, false, 0, 0); 
        // }
        // else if(count == 2 && d == 2){
        //     System.out.println("soma: " + aux);
        //     FillRec(numbers, node+1, 0, d+1, false, 0, 0); 
        // }
        // else if(count == 1 && d == 3){
        //     System.out.println("soma: " + aux);
        //     FillRec(numbers, node+1, 0, d+1, false, 0, 0); 
        // }
        // else if(count == 0 && d == 4){
        //     System.out.println("soma: " + aux);
        //     FillRec(numbers, node+1, 0, d+1, false, 0, 0); 
        // }



// FillRec(numbers, node+1);

        // if(numbers.isEmpty()){ return; }
        // if(get >= numbers.size()){ return; }

        // Integer n = numbers.get(get);
        // System.out.print(" " + n + " ");

        // if(firstIn == true){
        // sum += n;
        // }
        // else { aux += n; }

        // if(!firstIn && aux > sum) {
        // FillRec(numbers, node, 0, d, firstIn, sum, aux-n, get+1);
        // }
        // numbers.remove(n);
        // if(count == 4 && d == 0){
        // System.out.println("soma: " + sum);
        // FillRec(numbers, node+1, 0, d+1, false, sum, 0, 0);
        // }
        // if((count == 3 && d == 1) || (count == 2 && d == 2) || (count == 1 && d == 3)
        // ||(count == 0 && d == 4)){
        // System.out.println("soma: " + aux);
        // FillRec(numbers, node+1, 0, d+1, firstIn, sum, 0, 0);
        // }
        // FillRec(numbers, node+1, count+1, d, firstIn, sum, aux, 0);