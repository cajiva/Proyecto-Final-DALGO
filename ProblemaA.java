import java.io.BufferedReader;

// PROBLEMA A

/**
 * Programa para calcular la potencia de una matriz usando matemática modular.
 * @author Catalina Jiménez Varón
 */

 public class ProblemaA {

    static int n, r, m;

    public static void main(String[] args) throws Exception {
		ProblemaA instancia = new ProblemaA();
		try ( 
			InputStreamReader is= new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(is);
		) { 
			String line = br.readLine();
				
			while(line!=null && line.length()>0 && !"0 0 0".equals(line)) {
				final String [] dataStr = line.split(" ");
                n = Integer.parseInt(dataStr[0]);
                r = Integer.parseInt(dataStr[1]);
                m = Integer.parseInt(dataStr[2]);

                for (int i = 0; i < n; i++) {
                    int[][] matriz = new int[n][n];
                    line = br.readLine();
                    String [] sfila = line.split(" ");
                    matriz[i]= Arrays.stream(sfila).mapToInt(f->Integer.parseInt(f)).toArray();
                }
				int [] respuestas = instancia.procesarNumeros(numeros);
				System.out.println(respuestas[0]+" "+respuestas[1]);
				line = br.readLine();
			}
		}
	}


 }
