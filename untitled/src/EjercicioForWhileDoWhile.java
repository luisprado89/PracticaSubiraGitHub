public class EjercicioForWhileDoWhile {
    public static void main(String[] args){
        int i = 0;
        System.out.println("Esta es una serie for: ");
        for(i=0; i <= 10; i++){
            if (i<10){
                System.out.print(i+",");
                }else{
                System.out.print(i);
            }
        }
        //Aqui empieza el while
        i=1;
        System.out.println("");
        System.out.println("Esta es una serie while: ");
        while(i<=10){
            if(i < 10){
                System.out.print(i+",");
                }else{
                System.out.print(i);
            }
            i++;
        }
        //Aqui empieza el do-while
        i = 1;
        System.out.println("");
        System.out.println("Esta es una serie do-while: ");
        do{
            if(i < 10){
                System.out.print(i+ ",");
                }else{
                System.out.print(i);
            }
            i++;
        }while(i<=10);
    }
}
