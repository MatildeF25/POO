import java.util.*;

public class CasaInteligente {

    private Set<Lampada> lampadaset;

    public CasaInteligente(){
        this.lampadaset = new HashSet<Lampada>();
    }

    public CasaInteligente(Set<Lampada> lampadaSet){
        setLampadaset(lampadaSet);
    }

    public CasaInteligente(CasaInteligente c){
        this.lampadaset = c.getLampadaset();
    }

    public Set<Lampada> getLampadaset(){
        Set<Lampada> l = new HashSet<Lampada>();
        for(Lampada lamp: this.lampadaset){
            l.add(lamp.clone());
        }
        return l;
    }

    public void setLampadaset(Set<Lampada> lampadas){
        this.lampadaset = new HashSet<Lampada>();
        for(Lampada lamp : lampadas){
            this.lampadaset.add(lamp.clone());
        }
    }

    public CasaInteligente clone(){
        return new CasaInteligente(this);
    }

    public boolean equals(Object o){
        if (this == o)
            return true;
        if ((o == null) || (this.getClass() != o.getClass()))
            return false;
        CasaInteligente c = (CasaInteligente) o;
        return (this.lampadaset.equals(c.getLampadaset()));
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        int i = 0;
        sb.append("[");
        for (Lampada l : this.lampadaset) {
            sb.append(l);
            if (i < this.lampadaset.size() - 1) {
                sb.append(", ");
            }
            i++;
        }
        sb.append("]");
        return "casa:" + sb;
    }


    public void addLampada(Lampada l){
        this.lampadaset.add(l);
    }

    public void ligaLampadaNormal(Lampada lamp){
        Iterator<Lampada> it = this.lampadaset.iterator();
        boolean encontrado = false;
        Lampada l;

        while (it.hasNext() && !encontrado){
            l = it.next();
            if(l.equals(lamp)){
                encontrado = true;
                l.lampON();
            }
        }
        if(encontrado==false){
            System.out.println("a lampa não existe");
        }
    }

    public void ligaLampadaEco(Lampada lamp){
        Iterator<Lampada> it = this.lampadaset.iterator();
        boolean encontrado = false;
        Lampada l;

        while (it.hasNext() && !encontrado){
            l = it.next();
            if(l.equals(lamp)){
                encontrado = true;
                l.lampECO();
            }
        }
        if(encontrado==false){
            System.out.println("a lampa não existe");
        }
    }

    public int qtEmEco(){
        Iterator<Lampada> it = this.lampadaset.iterator();
        Lampada l;
        int cont = 0;

        while (it.hasNext()){
            l = it.next();
            if(l.getModo().equals(Lampada.Modo.ECO)){
                cont++;
            }
        }
        return cont;
    }

    public void removeLampada(Lampada lamp){
        Iterator<Lampada> it = this.lampadaset.iterator();
        boolean encontrado = false;
        Lampada l;

        while (it.hasNext() && !encontrado){
            l = it.next();
            if(l.equals(lamp)){
                this.lampadaset.remove(l);
            }
        }
        if(encontrado==false){
            System.out.println("a lampa não existe");
        }
    }

    public void ligaTodasEco(){
        for(Lampada l : this.lampadaset){
            l.lampECO();
        }
    }

    public void ligaTodasMax(){
        for(Lampada l : this.lampadaset){
            l.lampON();
        }
    }

    public double consumoTotal(){
        double consumo = 0;
        for(Lampada l : this.lampadaset){
            consumo += l.totalConsumo();
        }
        return consumo;
    }

    public Lampada maisGastadora(){
        double consumo = 0;
        Lampada lampada = null;
        for(Lampada l : this.lampadaset){
            if(l.totalConsumo()>consumo){
                lampada = l;
                consumo = l.totalConsumo();
            }
        }
        return lampada;
    }

    public Set<Lampada> lampadasEmModoEco(){
        Set<Lampada> lampEco = new HashSet<Lampada>();
        for(Lampada l : this.lampadaset){
            if(l.getModo().equals(Lampada.Modo.ECO)){
                lampEco.add(l.clone());
            }
        }
        return lampEco;
    }

    public void reset(){
        for(Lampada l : this.lampadaset){
            l.resetPeriodo();
        }
    }


}
