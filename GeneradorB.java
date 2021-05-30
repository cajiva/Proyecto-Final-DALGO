import java.util.concurrent.ThreadLocalRandom;

public class GeneradorB {

    static int n, p;

    public void generar()
    {
        System.out.println(n+" "+p);
        for (int i = 0; i < n; i++) {
            if(i == n-1)
                System.out.print(ThreadLocalRandom.current().nextInt(0,51)+"\r\n");

            else
                System.out.print(ThreadLocalRandom.current().nextInt(0,51)+" ");
        }
        // System.out.println("0 0");
    }

    public static void main(String[] args) throws Exception {

        for (int i = 0; i < 41; i++) {
            n = ThreadLocalRandom.current().nextInt(1,51);
            p = ThreadLocalRandom.current().nextInt(1,51);
    
            GeneradorB generador = new GeneradorB();
            generador.generar();
        }
    }
}
