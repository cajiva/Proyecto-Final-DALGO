import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Queue;

public class ProblemaB {
    private int numProcesos;
    private int numProcesadores;
    private ArrayList<Integer> tiempos;

    private double promedio;
    private ArrayList<Integer> v_carga;
    private ArrayList<Queue> carga;

    public ProblemaB(int n, int p, ArrayList<Integer> t){
        numProcesos = n;
        numProcesadores = p;
        tiempos = t;
        promedio = 0;
        v_carga = new ArrayList<>();
        carga = new ArrayList<>();
    }
    
    private int min(){
        int min = 0;
        int minimo = 0;
        for (int j = 0; j < tiempos.size() ; j++)
        minimo += tiempos.get (j);
        for (int i=0; i < carga.size(); i++) {
            Queue actual = carga.get(i);
            if (actual.size() < minimo) {
            min = i;
            minimo = actual.size();
            }
        }
        return min;
    }

    public static void main() throws IOException {
        boolean ejecutar = true;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (ejecutar) {
            String line = reader.readLine();
            if(line.equals("0 0")||line.isEmpty())
                ejecutar = false;
            else{
                String[] datos = line.split(" ");
                int n = Integer.parseInt(datos[0]);
                int p = Integer.parseInt(datos[1]);
                line = reader.readLine();
                datos = line.split(" ");
                ArrayList<Integer> t = new ArrayList<>();
                for (int i = 0; i < datos.length; i++) {
                    t.add(Integer.parseInt(datos[i]));
                }
                ProblemaB problema = new ProblemaB(n, p, t);
                //Llamado al método que hace como todo xd
            }

        }
    }
}
