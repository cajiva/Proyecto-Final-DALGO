import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

// PROBLEMA B

/**
 * Programa para calcular el tiempo de un grupo p de procesadores en completar 
 * unas tareas con tiempos pasados en un arreglo, con asignaciones contiguas
 * de las tareas.
 * @author Catalina Jiménez Varón
 * @author Daniel Beltran
 */

public class ProblemaB {

    static int n,p;

    public static void main(String[] args) throws Exception {
        ProblemaB instancia = new ProblemaB();
		try ( 
			InputStreamReader is= new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(is);
		) { 
			String line = br.readLine();
				
			while(line!=null && line.length()>0 && !"0 0".equals(line)) {
				final String [] dataStr = line.split(" ");
                n = Integer.parseInt(dataStr[0]);
                p = Integer.parseInt(dataStr[1]);
                line = br.readLine();
                String [] tareas = line.split(" ");
				int[] tiempos = Arrays.stream(tareas).mapToInt(f->Integer.parseInt(f)).toArray();
                
                if(tiempos.length != n)
                    throw new Exception("El tamaño del arreglo no es n.");
                
                else
                    System.out.println(instancia.buscaCota(tiempos,p));

				line = br.readLine();
			}
		}
	}

    public int buscaCota(int a[], int p){

        int sup = 0;
        for (int i = 0; i < a.length; i++) {
            sup += a[i];
        }

        if(p == 1)
            return sup;
        
        int inf = 0;
        for (int i = 0; i < a.length; i++) {
            if(a[i] > inf)
            inf = a[i];
        }

        if(p >= a.length)
            return inf;

        while(inf < sup){
            int mit = inf + (sup-inf)/2;

            if(cantProcesadores(a, mit) <= p)
            sup = mit;

            else
            inf = mit+1;

        }

        return inf;
    }

    //ret. cantidad de procesadores necesarios n para que el max
    //sea la cota pasada. Donde r es la cota.
    public int cantProcesadores(int a[], int r){
        int acum = 0;
        int n = 1;

        for (int i = 0; i < a.length; i++) {
            acum += a[i];

            if(acum > r){
                n++;
                acum = a[i];
            } 
        }
        return n;
    }  
}
