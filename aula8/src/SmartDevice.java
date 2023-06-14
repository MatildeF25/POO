import java.util.Objects;

public class SmartDevice {
    public enum Modo {
        ON,
        OFF
    }

    private Modo modo;
    private int ID = 0;

    public SmartDevice(){
        this.modo = Modo.OFF;
        this.ID++;
    }

    public SmartDevice(Modo modo){
        this.modo = modo;
        this.ID++;
    }

    public SmartDevice (SmartDevice s){
        this.modo = s.getModo();
        this.ID = s.getID();
    }

    public int getID() {
        return ID;
    }

    public Modo getModo() {
        return modo;
    }

    public void setModo(Modo modo) {
        this.modo = modo;
    }

    public void setID(int ID) {
        this.ID = ID;
    }


    public String toString() {
        final StringBuffer sb = new StringBuffer("SmartDevice{");
        sb.append("Modo=").append(modo);
        sb.append("\nID=").append(ID);
        return sb.toString();
    }

    public boolean equals(Object o){
        if(this == o) return true;
        if((o == null) || (this.getClass() != o.getClass())) return false;
        SmartDevice sd = (SmartDevice) o;
        return (this.ID == sd.getID() && this.modo == sd.getModo());
    }

    public SmartDevice clone(){
        return new SmartDevice(this);
    }


}
