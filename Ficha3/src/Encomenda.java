import java.time.LocalDate;
import java.util.Arrays;

import static java.util.Arrays.copyOf;

public class Encomenda {
    private String nomeCliente;
    private int nif;
    private String morada;
    private int nrEncomenda;
    private LocalDate dataEncomenda;
    private LinhaEncomenda[] linhasEncomenda;

    public Encomenda(){
        this.nomeCliente = "";
        this.nif = 0;
        this.morada = "";
        this.nrEncomenda = 0;
        this.dataEncomenda = LocalDate.now();
        this.linhasEncomenda = new LinhaEncomenda[0];
    }

    public Encomenda(String nomeCliente, int nif, String morada, int nrEncomenda, LocalDate dataEncomenda, LinhaEncomenda[] linhasEncomenda){
        this.nomeCliente = nomeCliente;
        this.nif = nif;
        this.morada = morada;
        this.nrEncomenda = nrEncomenda;
        this.dataEncomenda = dataEncomenda;
        this.linhasEncomenda = linhasEncomenda;
    }

    public Encomenda(Encomenda e){
        this.nomeCliente = e.getNomeCliente();
        this.nif = e.getNif();
        this.morada = e.getMorada();
        this.nrEncomenda = e.getNrEncomenda();
        this.dataEncomenda = e.getDataEncomenda();
        this.linhasEncomenda = e.getLinhasEncomenda();
    }

    public String getNomeCliente(){
        return this.nomeCliente;
    }

    public int getNif(){
        return this.nif;
    }

    public String getMorada(){
        return this.morada;
    }

    public int getNrEncomenda(){
        return this.nrEncomenda;
    }

    public LocalDate getDataEncomenda(){
        return this.dataEncomenda;
    }

    public LinhaEncomenda[] getLinhasEncomenda(){
        return this.linhasEncomenda;
    }

    public void setNomeCliente(String nomeCliente){
        this.nomeCliente = nomeCliente;
    }

    public void setNif(int nif){
        this.nif = nif;
    }

    public void setMorada(String morada){
        this.morada = morada;
    }

    public void setNrEncomenda(int nrEncomenda){
        this.nrEncomenda = nrEncomenda;
    }

    public void setDataEncomenda(LocalDate dataEncomenda){
        this.dataEncomenda = dataEncomenda;
    }

    public void setLinhasEncomenda(LinhaEncomenda[] linhasEncomenda){
        this.linhasEncomenda = linhasEncomenda;
    }

    public Encomenda clone (){
        return new Encomenda(this);
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < this.linhasEncomenda.length; i++) {
            sb.append(this.linhasEncomenda[i]);
            if (i < this.linhasEncomenda.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return "Nome do cliente: " + this.nomeCliente +
                "\nNIF: " + this.nif +
                "\nMorada: " + this.morada +
                "\nNúmero da encomenda: " + this.nrEncomenda +
                "\nData da encomenda: " + this.dataEncomenda +
                "\nLinhas da encomenda: " + sb;
    }

    public boolean equals(Object o){
        if (this == o)
            return true;
        if ((o == null) || (this.getClass() != o.getClass()))
            return false;
        Encomenda l = (Encomenda) o;
        return (this.nomeCliente.equals(l.getNomeCliente()) &&
                this.nif == l.getNif() &&
                this.morada.equals(l.getMorada()) &&
                this.nrEncomenda == l.getNrEncomenda() &&
                this.dataEncomenda.equals(l.getDataEncomenda()) &&
                this.linhasEncomenda.equals(l.getLinhasEncomenda()));
    }

    public double calculaValorTotal(){
        double res = 0;
        for(int i = 0; i< this.linhasEncomenda.length;i++){
            res = res + this.linhasEncomenda[i].calculaValorLinhaEnc();
        }
        return res;
    }

    public double calculaValorDesconto(){
        double res = 0.0;
        for(int i = 0; i< this.linhasEncomenda.length;i++){
            res = res + this.linhasEncomenda[i].calculaValorDesconto();
        }
        return res;
    }

    public int numeroTotalProdutos(){
        int res = 0;
        for(int i = 0; i< this.linhasEncomenda.length;i++){
            res = res + this.linhasEncomenda[i].getQuantidade();
        }
        return res;
    }

    public boolean existeProdutoEncomenda(String refProduto){
        boolean res = false;
        for(int i = 0; i< this.linhasEncomenda.length && res != true;i++){
            if (this.linhasEncomenda[i].getReferencia().equals(refProduto)){
                res = true;
            }
        }
        return res;
    }

    public void adicionaLinha(LinhaEncomenda linha){
        LinhaEncomenda [] nova = copyOf(this.linhasEncomenda,this.linhasEncomenda.length+1);
        nova[this.linhasEncomenda.length] = linha;
        this.linhasEncomenda = nova;
    }

    public void removeProduto(String codProd){
        int pos = 0;
        int indice = -1;
        for(int i = 0; i< this.linhasEncomenda.length && indice==-1; i++){
            if(this.linhasEncomenda[i].getReferencia().equals(codProd)){
                indice = i;
            }
        }

        if(indice != -1){
            LinhaEncomenda [] nova = new LinhaEncomenda[this.linhasEncomenda.length-1];
            for(int j = 0; j< this.linhasEncomenda.length; j++){
                if(j!=indice){
                    nova[pos] = this.linhasEncomenda[j];
                    pos++;
                }
            }
            this.linhasEncomenda = nova;
        }
    }
}