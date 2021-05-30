import java.util.concurrent.ThreadLocalRandom;

public class GeneradorProblemaA {

    static int n, r, m;

    public void generar()
    {
        System.out.println(n+" "+r+" "+m);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(j== n-1){
                    System.out.print(ThreadLocalRandom.current().nextInt(0,51)+"\r\n");
                }
                else
                    System.out.print(ThreadLocalRandom.current().nextInt(0,51)+" ");       
            }
        }
        System.out.println("0 0 0");
    }





    public static void main(String[] args) throws Exception {

        n = 4;
        r = 2;
        m = 3;

        GeneradorProblemaA generador = new GeneradorProblemaA();
        generador.generar();
    }
}

