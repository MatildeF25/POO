import java.io.ObjectOutputStream;
import java.time.LocalDateTime;
import java.util.*;
import java.util.function.Consumer;

class SmartDevice {
    private String id;
    private boolean on;
    private double consumoPorHora;
    private LocalDateTime inicio;


    public SmartDevice( String id, double consumoPorHora){
        this.id = id;
        this.on = false;
        this.consumoPorHora = consumoPorHora;
    }

    public double totalConsumo() {...}

    public void turnOn() {
        this.on = true;
        if (this.inicio == null)
            this.inicio = LocalDateTime.now();
    }
}


class SmartBulb extends SmartDevice {
    public static final int WARM = 2;
    public static final int NEUTRAL = 1;
    public static final int COLD = 0;
    private int tone;

    public SmartBulb(String id, int tone, double consumoPorHora) {
        super(id, consumoPorHora);
        this.tone = tone;
    }

    public void setTone(int t) {
        if (t>WARM) this.tone = WARM;
        else if (t<COLD) this.tone = COLD;
        else this.tone = t;
    }

    public int getTone() {
        return this.tone;
    }
}

class SmartSpeaker extends SmartDevice {
    public static final int MAX = 20;
    private int volume;
    private String channel;
    public SmartSpeaker(String id, String channel, double consumoPorHora) {
        super(id, consumoPorHora);
        this.channel = channel;
        this.volume = 10;
    }
}

class CasaInteligente {
    List<SmartDevice> devices;
    Map<String, List<SmartDevice>> divisoes;

    public CasaInteligente(Collection<SmartDevice> devices) {
        Iterator<SmartDevice> d = devices.iterator();
        while (d.hasNext()) {
            SmartDevice sd = d.next();
            this.devices.add(sd.clone());
        }
    }

    public void remove(String id) throws DeviceNaoExisteException {
        boolean encontrado = false;
        for (SmartDevice s : this.devices) {
            if (s.getId().equals(id)) {
                this.devices.remove(s);
                encontrado = true;
            }
        }
        if (!encontrado) {
            throw new DeviceNaoExisteException;
        }
        //loop de Map<String, List<SmartDevice>> divisoes;
        for (String div : divisoes.keySet()) {
            for (SmartDevice sd : divisoes.get(div)) {
                if (sd.getId(.equals(id))){
                    divisoes.get(div).remove(div);
                }
            }
        }
    }

    public Iterator<SmartDevice> devicesPorConsumoCrescente() {
        Comparator<SmartDevice> comp = (a, b) -> a.getConsumo.compareTo(b.getConsumo);
        return this.devices.stream().map(SmartDevice::clone).sorted(comp).iterator();
    }

    public String divisaoMaisEconomica() {
        double min = Double.MAX_VALUE;
        double soma = 0.0;
        String divisao = null;
        for (String div : divisoes.keySet()) {
            for (SmartDevice sd : divisoes.get(div)) {
                soma += sd.getConsumo;
            }
            if (min > soma) {
                min = soma;
                divisao = div;
            }
        }
        return divisao;
    }

    public static Consumer<SmartBulbDimmable> alteraLuminosidade() {
        return bd -> bd.setIntensidade(bd.getIntensidade() / 4);
    }

    public void alteraInfo(Consumer<SmartBulbDimmable> bd) {
        for (SmartDevice sd : this.devices) {
            if (sd instanceof SmartBulbDimmable) {
                bd.accept((SmartBulbDimmable) sd);
            }
        }
    }

    public boolean apenasNumaDivisao() {
        boolean res = true;
        for (SmartDevice sd : this.devices) {
            int count = 0;
            for (String div : divisoes.keySet()) {
                for (SmartDevice s : divisoes.get(div)) {
                    if (s.getId().equals(sd.getId())) {
                        count++;
                    }
                }
            }
            if (count > 1) {
                res = false;
            }
        }
        return res;
    }


    public boolean gravaEmFichObjectos(String fich) throws FileNotFoundException, IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fich))) {
            for (SmartDevice sd : this.devices) {
                if (sd instanceof SmartSpeaker) {
                    oos.writeObject(sd);
                }
            }
        }
        catch (FileNotFoundException e) {
            throw new FileNotFoundException();
        }
        catch (IOException e) {
            throw new IOException();
        }
        return true;
    }
}

class SmartBulbDimmable extends SmartBulb{
    private int intensidade;
    private int num_ligada;

    public SmartBulbDimmable (String id, int tone, double consumoPorHora, int intensidade, int num_ligada){
        super(id,tone,consumoPorHora);
        this.intensidade = intensidade;
        this.num_ligada = num_ligada;
    }

    public void turnOn() {
        if(this.num_ligada == 0){
            this.intensidade = this.intensidade/2;
            super.setConsumo(super.getConsumo/2);
        }
        super.turnOn();
        this.num_ligada++;
    }
}






















