import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        LinhaEncomenda l1 = new LinhaEncomenda("ref1", "desc1", 100, 1, 23, 50);
        LinhaEncomenda l2 = new LinhaEncomenda("ref2", "desc2", 100, 1, 23, 50);
        LinhaEncomenda l3 = new LinhaEncomenda("ref3", "desc3", 100, 1, 23, 50);
        List<LinhaEncomenda> linhas = Arrays.asList(new LinhaEncomenda[]{l1, l2});
        Encomenda e = new Encomenda("Lara", 123, "motel", LocalDate.now(), linhas);
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