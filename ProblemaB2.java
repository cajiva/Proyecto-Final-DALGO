import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ProblemaB2 {

    static int n,p;


    public static void main(String[] args) throws Exception {
		ProblemaB2 instancia = new ProblemaB2();
		try ( 
			InputStreamReader is= new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(is);
		) { 
			String line = br.readLine();
				
			while(line!=null && line.length()>0 && !"0".equals(line)) {
				final String [] dataStr = line.split(" ");
                n = Integer.parseInt(dataStr[0]);
                p = Integer.parseInt(dataStr[1]);
                line = br.readLine();
                String [] tareas = line.split(" ");
				int[] tiempos = Arrays.stream(tareas).mapToInt(f->Integer.parseInt(f)).toArray();
                
                System.out.println("Rta: "+instancia.asignar(p, n, tiempos));

				line = br.readLine();
			}
		}
	}

    public int asignar(int p, int n, int[] tiempos ) throws Exception{
        
        if(n != tiempos.length)
            throw new Exception("n no es igual a la cantidad de procesos");

        int max = 0;
        ArrayList <ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();

        int sum = 0;
        for (int i = 0; i < tiempos.length; i++) {
            sum += tiempos[i];
        }
        double avg = sum/p;

        for (int i = 0; i < p; i++) {
            ArrayList t = new ArrayList<Integer>();
            arr.add(t);
        }

        int acum = 0;
        int pos = 0;
        for (int i = 0; i < tiempos.length; i++) {
            int temp = tiempos[i];
            
            if(acum + temp <= avg)
            {
                acum += temp;
                arr.get(pos).add(temp);
            }
            else
            {
                if(Math.abs((acum+temp)-avg) <= Math.abs((acum)-avg)) //agregar es mejor
                {
                    arr.get(pos).add(temp);
                    acum += temp;
                }
                else
                {
                    if(pos < p-1) // todavia hay mas procesadores
                    {
                        pos++;
                        acum = temp;
                        arr.get(pos).add(temp);
                    }
                    else
                    {
                        arr.get(pos).add(temp); //no hay mas procesadores, toca meterlo
                        acum += temp;
                    }
                }
            }
        }

        for (int i = 0; i < arr.size(); i++) {
            int suma = 0;
            System.out.println("Arreglo "+ i);
            for (int j = 0; j < arr.get(i).size(); j++) {
                System.out.println(arr.get(i).get(j));
                suma += arr.get(i).get(j);
            }
            if(max < suma)
                max = suma;
        }

        return max;
    }
}