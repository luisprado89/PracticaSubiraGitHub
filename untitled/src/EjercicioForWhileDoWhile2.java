public class EjercicioForWhileDoWhile2 {
    public static void main(String[] args){
        int i = 1, j = 99;
        System.out.println("Esta es una serie for: ");
        for(i=1 ; i<=5; i++){
            if(i<5){
                System.out.print(i+",");
                System.out.print(j+",");
            }else{
                System.out.print(i+",");
                System.out.print(j);
            }
            j--;
        }
        System.out.println("");
        //Aqui empieza while
        i=1;
        j=99;
        System.out.println("Esta es una serie while: ");
        while(i<=5){
            if(i<5){
                System.out.print(i+",");
                System.out.print(j+",");
            }else{
                System.out.print(i+",");
                System.out.print(j);
            }
            i++;
            j--;
            }
        System.out.println("");
        //Aqui empieza do-while
        i=1;
        j=99;
        System.out.println("Esta es una serie do-while: ");
        do{
            if( i<5){
                System.out.print(i+",");
                System.out.print(j+",");
            }else{
                System.out.print(i+",");
                System.out.print(j);
            }
            i++;
            j--;

        }while(i<=5);

    }
}
