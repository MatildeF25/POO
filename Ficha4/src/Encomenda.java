import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.copyOf;

public class Encomenda {
    private String nomeCliente;
    private int nif;
    private String morada;
    private static int nrEncomenda = 0;
    private LocalDate dataEncomenda;
    private List<LinhaEncomenda> linhasEncomenda;

    public Encomenda(){
        this.nomeCliente = "";
        this.nif = 0;
        this.morada = "";
        this.nrEncomenda++;
        this.dataEncomenda = LocalDate.now();
        this.linhasEncomenda = new ArrayList<>();
    }

    public Encomenda(String nomeCliente, int nif, String morada, LocalDate dataEncomenda, List<LinhaEncomenda> linhasEncomenda){
        this.nomeCliente = nomeCliente;
        this.nif = nif;
        this.morada = morada;
        this.nrEncomenda++;
        this.dataEncomenda = dataEncomenda;
        setLinhasEncomenda(linhasEncomenda);
    }

    public Encomenda(Encomenda e){
        this.nomeCliente = e.getNomeCliente();
        this.nif = e.getNif();
        this.morada = e.getMorada();
        this.nrEncomenda++;
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

    public List<LinhaEncomenda> getLinhasEncomenda(){
        ArrayList<LinhaEncomenda> res = new ArrayList<>();
        for(LinhaEncomenda l: this.linhasEncomenda){
            res.add(l.clone());
        }
        return res;
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

    public void setLinhasEncomenda(List<LinhaEncomenda> linhasEncomenda){
        this.linhasEncomenda = new ArrayList<>(linhasEncomenda.size());
        for(LinhaEncomenda l: linhasEncomenda){
            this.linhasEncomenda.add(l.clone());
        }
    }

    public Encomenda clone (){
        return new Encomenda(this);
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < this.linhasEncomenda.size(); i++) {
            sb.append(this.linhasEncomenda.get(i));
            if (i < this.linhasEncomenda.size() - 1) {
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
        for(LinhaEncomenda l : this.linhasEncomenda){
            res += l.calculaValorLinhaEnc();
        }
        return res;
    }

    public double calculaValorDesconto(){
        double res = 0.0;
        for(LinhaEncomenda l : this.linhasEncomenda){
            res += l.calculaValorDesconto();
        }
        return res;
    }

    public int numeroTotalProdutos(){
        int res = 0;
        for(LinhaEncomenda l : this.linhasEncomenda){
            res += l.getQuantidade();
        }
        return res;
    }

    public boolean existeProdutoEncomenda(String refProduto){
        boolean res = false;
        for(int i = 0; i< this.linhasEncomenda.size() && res != true;i++){
            if (this.linhasEncomenda.get(i).getReferencia().equals(refProduto)){
                res = true;
            }
        }
        return res;
    }

    public void adicionaLinha(LinhaEncomenda linha){
        this.linhasEncomenda.add(linha);
    }

    public void removeProduto(String codProd){
        boolean res = false;
        for(int i = 0; i< this.linhasEncomenda.size() && res != true;i++){
            if (this.linhasEncomenda.get(i).getReferencia().equals(codProd)){
                res = true;
                this.linhasEncomenda.remove(linhasEncomenda.get(i));
            }
        }
    }
}