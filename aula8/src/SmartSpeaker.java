public class SmartSpeaker extends SmartDevice {

    private int volume;
    private double canal;


    public SmartSpeaker() {
        super();
        this.volume = 0;
        this.canal = 0.0;
    }

    public SmartSpeaker(Modo modo,int volume, int canal){
        super(modo);
        this.volume = volume;
        this.canal = canal;
    }

    public SmartSpeaker(SmartSpeaker ss){
        super(ss);
        this.volume = getVolume();
        this.canal = getCanal();

    }

    public int getVolume() {
        return volume;
    }

    public double getCanal() {
        return canal;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public void setCanal(double canal) {
        this.canal = canal;
    }

    public boolean equals(Object o){
        if(this == o) return true;
        if((o == null) || (this.getClass() != o.getClass())) return false;
        SmartDevice ss = (SmartSpeaker) o;
        return (super.equals(ss) && this.volume == ((SmartSpeaker)o).getVolume() && this.canal == ((SmartSpeaker)o).getCanal());
    }

    public String toString() {
        final StringBuffer sb = new StringBuffer("SmartSpeaker {");
        sb.append("Volume: ").append(volume);
        sb.append("\nCanal: ").append(canal);
        sb.append("\n").append(super.toString());
        return sb.toString();
    }

    public SmartSpeaker clone(){
        return new SmartSpeaker(this);
    }
}
