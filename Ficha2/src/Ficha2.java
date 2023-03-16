import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;


public class Ficha2 {

    private int[] array;
    private LocalDate[] arrayDates;
    private int posicao;
    private String[] strings;

    public Ficha2(int i) {
        this.array = new int[i];
        this.posicao = 0;
        this.arrayDates = new LocalDate[i];
        this.strings = new String[i];
    }

    //EX1
    public void setArray(int[] a) {
        this.array = a;
    }

    public void dois_indices(int i1, int i2) {
        this.array = Arrays.copyOfRange(this.array, i1, i2);
    }

    public String toString() {
        String aux = "";
        for (int i = 0; i < this.array.length; i++) {
            aux = aux + this.array[i];
        }
        return aux;
    }

    //EX2
    public void insereData(LocalDate data) {
        if (this.arrayDates.length < posicao) {
            System.out.println("array cheio");
        } else {
            this.arrayDates[posicao] = data;
            posicao++;
        }
        System.out.println("A data " + data + " foi inserida no array");
    }

    public LocalDate dataMaisProxima(LocalDate data) {
        long dias = 0;
        long min_d = Long.MAX_VALUE;
        int min_i = -1;
        for (int i = 0; i < this.arrayDates.length; i++) {
            dias = this.arrayDates[i].until(data, ChronoUnit.DAYS);
            if (dias >= 0 && dias < min_d) {
                min_d = dias;
                min_i = i;
            }
        }
        return arrayDates[min_i];
    }

    public String toString_datas() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < this.arrayDates.length; i++) {
            sb.append(arrayDates[i].toString());
            if (i < arrayDates.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    //EX3
    public void ordena_array() {
        Arrays.sort(this.array);
    }

    public int proc_bin(int n) {
        if (this.array.length == 0) {
            System.out.println("array vazio");
            return -1;
        }
        Arrays.sort(this.array);

        int i = Arrays.binarySearch(this.array, n);

        if (i < 0) {
            // n was not found in the array
            System.out.println("Valor não encontrado");
            return i; // return the negative value returned by binarySearch
        } else {
            // n was found in the array
            return i;
        }
    }

    //EX4
    void setStrings(String[] s) {
        this.strings = s;
    }

    public String toString_string() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < this.strings.length; i++) {
            sb.append(this.strings[i]);
            if (i < this.strings.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public String toString_string(String[] s) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < s.length; i++) {
            sb.append(s[i]);
            if (i < s.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }


    public void sem_repetir() {
        Set<String> set = new HashSet<>(Arrays.asList(this.strings));
        this.strings = set.toArray(new String[0]);
    }

    public String maior_string() {
        int t = 0;
        int t_max = 0;
        int ind = -1;

        for (int i = 0; i < this.strings.length; i++) {
            t = this.strings[i].length();
            if (t > t_max) {
                t_max = t;
                ind = i;
            }
        }
        return this.strings[ind];
    }

    public String[] repetidos() {
        Map<String, Integer> counts = new HashMap<>();
        for (int i = 0; i < this.strings.length; i++) {
            counts.put(this.strings[i], counts.getOrDefault(this.strings[i], 0) + 1);
        }

        List<String> repetidos = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : counts.entrySet()) {
            if (entry.getValue() > 1) {
                repetidos.add(entry.getKey());
            }
        }

        return repetidos.toArray(new String[0]);
    }

    public int freq(String s){
        int r = 0;
        Map<String, Integer> counts = new HashMap<>();
        for (int i = 0; i < this.strings.length; i++) {
            counts.put(this.strings[i], counts.getOrDefault(this.strings[i], 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : counts.entrySet()) {
            if (entry.getKey().equals(s)) {
                r = entry.getValue();
                break;
            }
        }
        return r;
    }









}