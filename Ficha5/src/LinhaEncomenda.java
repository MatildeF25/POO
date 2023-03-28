public class LinhaEncomenda {
    private String referencia;
    private String descricao;
    private  double preco;
    private int quantidade;
    private double imposto;
    private double desconto;

    public LinhaEncomenda(){
        this.referencia = "";
        this.descricao = "";
        this.preco = 0.0;
        this.quantidade = 0;
        this.imposto = 0.0;
        this.desconto = 0.0;
    }

    public LinhaEncomenda (String referencia, String descricao, double preco, int quantidade, double imposto, double desconto){
        this.referencia = referencia;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidade = quantidade;
        this.imposto = imposto;
        this.desconto = desconto;
    }

    public  LinhaEncomenda (LinhaEncomenda l){
        this.referencia = l.getReferencia();
        this.descricao = l.getDescricao();
        this.preco = l.getPreco();
        this.quantidade = l.getQuantidade();
        this.imposto = l.getImposto();
        this.desconto = l.getDesconto();
    }

    public String getReferencia(){
        return this.referencia;
    }

    public String getDescricao(){
        return this.descricao;
    }

    public double getPreco(){
        return this.preco;
    }

    public int getQuantidade() {
        return this.quantidade;
    }

    public double getImposto() {
        return this.imposto;
    }

    public double getDesconto() {
        return this.desconto;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setImposto(int imposto) {
        this.imposto = imposto;
    }

    public void setDesconto(int desconto) {
        this.desconto = desconto;
    }

    public LinhaEncomenda clone (){
        return new LinhaEncomenda(this);
    }

    public String toString() {
        return "Referencia: " + this.referencia + "\nDescrição: " + this.descricao + "\nPreço: " + this.preco + "\nQuantidade: " + this.quantidade
                + "\nImposto: " + this.imposto + "\nDesconto: " + this.desconto;
    }


    public boolean equals(Object o) {
        if ( this == o )
            return true ;
        if (( o == null ) || ( this . getClass () != o . getClass () ) )
            return false ;
        LinhaEncomenda l = (LinhaEncomenda) o ;
        return (this.referencia.equals(l.getReferencia()) && this.descricao.equals(l.getDescricao()) && this.preco == l.getPreco() && this.quantidade == l.getQuantidade()
                && this.imposto == l.getImposto() && this.desconto == l.getDesconto());
    }

    public double calculaValorLinhaEnc(){
        double valor = this.preco * this.quantidade;
        double desconto = (this.desconto * valor)/ 100;
        double imposto = valor * this.imposto/100;
        return valor - desconto + imposto;
    }

    public double calculaValorDesconto(){
        double preco = this.preco * this.quantidade;
        double desconto = (this.desconto * preco)/ 100;
        return desconto;
    }

}