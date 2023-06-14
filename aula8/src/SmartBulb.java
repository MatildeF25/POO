public class SmartBulb extends SmartDevice{

    public enum Tonalidade{
        WARM,
        NEUTRAL,
        COLD
    }

    private Tonalidade tonalidade;

    public SmartBulb (){
        super();
        this.tonalidade = Tonalidade.NEUTRAL;
    }

    public SmartBulb(Modo modo, Tonalidade tonalidade){
        super(modo);
        this.tonalidade = tonalidade;
    }

    public SmartBulb (SmartBulb sd){
        super(sd);
        this.tonalidade = sd.getTonalidade();
    }

    public Tonalidade getTonalidade() {
        return tonalidade;
    }

    public void setTonalidade(Tonalidade tonalidade) {
        this.tonalidade = tonalidade;
    }


    public String toString() {
        final StringBuffer sb = new StringBuffer("SmartBulb{");
        sb.append("tonalidade=").append(tonalidade);
        sb.append("\n").append(super.toString());
        return sb.toString();
    }


    public boolean equals(Object o){
        if(this == o) return true;
        if((o == null) || (this.getClass() != o.getClass())) return false;
        SmartDevice sb = (SmartBulb) o;
        return (super.equals(sb) && this.tonalidade == ((SmartBulb)o).getTonalidade());
    }

    public SmartBulb clone(){
        return new SmartBulb(this);
    }

}
