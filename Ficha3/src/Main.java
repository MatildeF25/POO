import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Telemovel t = new Telemovel("Samsung", "Galaxy S21", 1080, 2400, (byte) 50, (byte) 200, (byte) 100, 1024);
        boolean res = t.existeEspaco(2000);
        System.out.println(res);

        LinhaEncomenda l1 = new LinhaEncomenda("ref1", "desc1", 100, 1, 23, 50);
        LinhaEncomenda l2 = new LinhaEncomenda("ref2", "desc2", 100, 1, 23, 50);
        LinhaEncomenda l3 = new LinhaEncomenda("ref3", "desc3", 100, 1, 23, 50);
        Encomenda e = new Encomenda("Lara",123,"motel",3, LocalDate.now(), new LinhaEncomenda[]{l1,l2});
        System.out.println("valor da linha de encomenda 1: " + l1.calculaValorLinhaEnc() + "\nDesconto da linha de encomenda 1: " + l1.calculaValorDesconto());
        System.out.println("valor da linha de encomenda 2: " + l2.calculaValorLinhaEnc() + "\nDesconto da linha de encomenda 2: " + l2.calculaValorDesconto());
        System.out.println("Valor total da encomenda: " + e.calculaValorTotal());
        System.out.println("Valor total dos descontos: " + e.calculaValorDesconto());
        System.out.println("Escreve a referencia da linha de encomenda: ");
        String ref = scanner.next();
        System.out.println("A linha existe? \nr: " + e.existeProdutoEncomenda(ref) );
        e.adicionaLinha(l3);
        System.out.println("linha de encomenda com ref3 adicionada á encomenda");
        System.out.println(e.toString());
        e.removeProduto("ref3");
        System.out.println("linha de encomenda com ref3 foi removida da encomenda");
        System.out.println(e.toString());


    }

}