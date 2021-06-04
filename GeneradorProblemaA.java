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
    }

    public static void main(String[] args) throws Exception {

        GeneradorProblemaA generador = new GeneradorProblemaA();
        for (int i = 0; i < 15; i++) {
            n = ThreadLocalRandom.current().nextInt(1,50);
            r = ThreadLocalRandom.current().nextInt(0,1000);
            m = ThreadLocalRandom.current().nextInt(2,1000);
            generador.generar(); 
        } 
        System.out.println("0 0 0");
    }
}

