import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main (String [] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("inesere o tamanho do array");
        int t = scanner.nextInt();


        int[] aux = new int[t];
        for (int i = 0; i < t; i++) {
            System.out.println("insira um inteiro");
            aux[i] = scanner.nextInt();
        }

        for (int i = 0; i < t; i++) {
            System.out.println(aux[i]);
        }

        Ficha2 ficha = new Ficha2(t);
        ficha.setArray(aux);
        ficha.ordena_array();
        System.out.println("Array ordenado: " + ficha.toString());
        System.out.println("O numero 4 enconra-se no indice " + ficha.proc_bin(4));
        ficha.dois_indices(0, 3);
        String aux2 = ficha.toString();
        System.out.println("O 3 primeiros numeros do array : " + aux2);

        for (int i = 0; i < t; i++) {
            System.out.println("insere o ano");
            int ano = scanner.nextInt();
            System.out.println("insere o mes");
            int mes = scanner.nextInt();
            System.out.println("insere o dia");
            int dia = scanner.nextInt();
            ficha.insereData(LocalDate.of(ano, mes, dia));
        }

        LocalDate l = ficha.dataMaisProxima(LocalDate.of(2023,3,4));
        System.out.println("A data mais próxima é: " + l);
        String datas  = ficha.toString_datas();
        System.out.println("O array contém as seguintes datas: " + datas);

        String [] st = new String[t];
        for (int i = 0; i < t; i++) {
            System.out.println("insere uma string");
            st[i] = scanner.next();
        }

        Ficha2 ficha2 = new Ficha2(t);
        ficha2.setStrings(st);
        System.out.println("Array de strings: " + ficha2.toString_string());
        System.out.println("A palavra ola aparece " + ficha2.freq("ola") + " vezes");
        System.out.println("As palavras repetidas são: " + ficha2.toString_string(ficha2.repetidos()));
        ficha2.sem_repetir();
        System.out.println("Array sem repetições: " + ficha2.toString_string());
        System.out.println("A maior string é: " + ficha2.maior_string());

    }
}