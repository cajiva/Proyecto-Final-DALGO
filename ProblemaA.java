import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

// PROBLEMA A

/**
 * Programa para calcular la potencia de una matriz usando matemática modular.
 * @author Catalina Jiménez Varón
 * @author Daniel Beltran
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

				int[][] matriz = new int[n][n];
                for (int i = 0; i < n; i++) {
                    line = br.readLine();
                    String [] sfila = line.split(" ");
                    matriz[i]= Arrays.stream(sfila).mapToInt(f->Integer.parseInt(f)).toArray();
                }

				int[][] potencias = instancia.potenciar(matriz, r, m);
				
				for (int i = 0; i < potencias.length; i++) {
					for (int j = 0; j < potencias.length; j++) {
						System.out.print(potencias[i][j] + " ");
					}
					System.out.println();
				}

				line = br.readLine();
			}
		}
	}


	public int[][] darPotencia(int[][] matriz, int r, int m )
	{
		int[][] potencia = new int[matriz.length][matriz.length];
		potencia = Arrays.copyOf(matriz, matriz.length);

		if(r == 0)
		{
			for (int i = 0; i < potencia.length; i++) {
				for (int j = 0; j < potencia.length; j++) {
					if (i == j)
						potencia[i][j] = 1;

					else
						potencia[i][j] = 0;
				}
			}
		}

		for (int i = 0; i < r - 1; i++) {
			potencia = Arrays.copyOf(multipMatrices(potencia, matriz, m), matriz.length);
		}
		
		return potencia;
	}

	public int[][] potenciar (int [][] matriz, int r, int m)
	{
		int[][] potencia = new int[matriz.length][matriz.length];

		for (int i = 0; i < potencia.length; i++) {
			for (int j = 0; j < potencia.length; j++) {
				if (i == j)
					potencia[i][j] = 1;

				else
					potencia[i][j] = 0;
			}
		}

		while (r > 0) {

			if(r % 2 == 1)
				potencia = Arrays.copyOf(multipMatrices(potencia, matriz, m), matriz.length);

			matriz = Arrays.copyOf(multipMatrices(matriz, matriz, m), matriz.length);

			r = r/2; 
		}

		return potencia;
	}

	public int[][] multipMatrices(int[][] a, int[][] b, int m)
	{
		int[][] rta = new int[a.length][a.length];
		for ( int i = 0; i < b.length; i++) {
			for (int j = 0; j < b.length; j++) {
				int temp = 0;
				for (int k = 0; k < b.length; k++) {
					temp += a[i][k] * b[k][j];
				}
				rta[i][j] = temp % m;
			}
		}
		return rta;
	}

 }
