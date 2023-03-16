import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Scanner;

public class Exercicio2 {

    public Exercicio2(){

    }

    public String conversor(){
        Scanner sc = new Scanner(System.in);
        System.out.println("escreve um inteiro: ");
        double leitura = sc.nextDouble();
        double grauF = leitura*1.8 + 32;
        String res = leitura+ " graus celcius, corresponde a " + grauF + " Farenheit";
        return res;
    }

    public String maximoNumeros(){
        Scanner sc = new Scanner(System.in);
        System.out.println("escreve um numero: ");
        int n1 = sc.nextInt();
        System.out.println("escreve outro numero: ");
        int n2 = sc.nextInt();

        if(n1>n2){
            String res = "o numero maior é " + n1;
            return res;
        }
        else {
            String res = "o numero maior é " + n2;
            return res;
        }
    }

    public String criaDescricaoConta(){
        Scanner sc = new Scanner(System.in);
        System.out.println("escreve um nome: ");
        String nome = sc.nextLine();
        System.out.println("escreve o saldo: ");
        double saldo = sc.nextDouble();

        String res = "nome: " + nome + " slado: " + saldo;
        return res;
    }


    public String eurosParaLibras(){
        Scanner sc = new Scanner(System.in);
        System.out.println("escreve um valor:");
        double euros = sc.nextDouble();
        System.out.println("escreve uma taxa:");
        double taxa = sc.nextDouble();

        String res = euros + " euros são " + taxa*euros + " libras";
        return res;

    }

    public String ex5(){
        Scanner sc = new Scanner(System.in);
        System.out.println("escreve um numero: ");
        int n1 = sc.nextInt();
        System.out.println("escreve outro numero: ");
        int n2 = sc.nextInt();
        double sum = n1 + n2;
        double media = sum/2;

        if(n1>n2){
            String res = "ordem decrescente:" + n1 + n2 + "media:" + media;
            return res;
        }
        else{
            String res = "ordem decrescente: " + n2 +", "+ n1 + "\nmedia:" + media;
            return res;
        }
    }

    public String fatorial(int n){
        int i;
        BigInteger fact = BigInteger.ONE;
        for(i=1;i<=n;i++){
            fact=fact.multiply(BigInteger.valueOf(i));
        }
        String res = "Factorial of "+ n+" is: "+fact;
        return res;
    }


    public String tempoGasto(){
        long startSeconds = System.nanoTime();
        String res = fatorial(80000);
        System.out.println(res);
        long endSeconds = System.nanoTime();
        long totalTime = (endSeconds - startSeconds)/1000000;
        String r = "Tempo de cálculo em milissegundos: " + totalTime;
        return r;
    }



}
