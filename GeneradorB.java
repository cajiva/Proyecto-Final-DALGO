import java.util.concurrent.ThreadLocalRandom;

import javax.swing.plaf.synth.SynthStyleFactory;

public class GeneradorB {

    static int n, p;

    public void generar()
    {
        System.out.println(n+" "+p);
        for (int i = 0; i < n; i++) {
            if(i == n-1)
                System.out.print(ThreadLocalRandom.current().nextInt(1,1001)+"\r\n");

            else
                System.out.print(ThreadLocalRandom.current().nextInt(1,1001)+" ");
        }
        // System.out.println("0 0");
    }

    public static void main(String[] args) throws Exception {

        for (int i = 0; i < 100; i++) {
            n = ThreadLocalRandom.current().nextInt(1,100);
            p = ThreadLocalRandom.current().nextInt(1,100);
    
            GeneradorB generador = new GeneradorB();
            generador.generar();
        }
        System.out.println("0 0");
    }
}
