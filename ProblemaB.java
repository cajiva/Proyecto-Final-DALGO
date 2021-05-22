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
    private ArrayList<Queue<Integer>> carga;

    public ProblemaB(int n, int p, ArrayList<Integer> t) {
        numProcesos = n;
        numProcesadores = p;
        tiempos = t;
        promedio = 0;
        v_carga = new ArrayList<>();
        carga = new ArrayList<Queue<Integer>>();
    }

    private int min() {
        int min = 0;
        int minimo = 0;
        for (int j = 0; j < tiempos.size(); j++)
            minimo += tiempos.get(j);
        for (int i = 0; i < carga.size(); i++) {
            Queue<Integer> actual = carga.get(i);
            if (actual.size() < minimo) {
                min = i;
                minimo = actual.size();
            }
        }
        return min;
    }

    private void darCarga(int procesador) {
        Queue<Integer> actual = carga.get(procesador);
        int valorCarga = 0;

        for (Integer proceso : actual) {
            valorCarga += tiempos.get(proceso);
            v_carga.set(procesador, valorCarga);
        }
    }

    private void balanceoCarga(int procesador) {
        if (procesador >= 1) {
            Queue<Integer> actual = carga.get(procesador);
            Queue<Integer> anterior = carga.get(procesador - 1);
            Integer proceso = actual.poll();
            anterior.add(proceso);
            v_carga.set(procesador, v_carga.get(procesador) - proceso);
            v_carga.set(procesador - 1, v_carga.get(procesador - 1) + proceso);
            if (v_carga.get(procesador - 1) > promedio)
                balanceoCarga(procesador - 1);
        }
    }

    public static void main() throws IOException {
        boolean ejecutar = true;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (ejecutar) {
            String line = reader.readLine();
            if (line.equals("0 0") || line.isEmpty())
                ejecutar = false;
            else {
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
                // Llamado al método que hace como todo xd
            }

        }
    }
}
