import java.time.LocalDate;
import java.util.*;

public class GestorEncomendas {
    private Map<Integer, Encomenda> encomendaMap;

    public GestorEncomendas(){
        this.encomendaMap = new HashMap<Integer,Encomenda>();
    }


    /*
    public void iteratorMap(){
        //par chave valor
        for(Map.Entry<String,Encomenda> entry : encomendaMap.entrySet()){
            if(entry.getKey() == "adbi"){


            }

        }

        //iterar nas chaves
        Set<String> encomendaSet = this.encomendaMap.keySet();
        for(String enc : encomendaSet){
            if(enc.equals("abdi")){

            }
        }

        // iterar nos values
        Collection<Encomenda> encomendasCollection = this.encomendaMap.values();
        for(Encomenda enc : encomendasCollection){
            if(enc.getMorada()){

            }
        }

        // iterar com streams
        Set<Encomenda> encomendasSet = encomendasCollection.stream().filter(encomenda -> (encomenda.getNrEncomenda() > 2));

    }
*/
    public Set<Integer> todosCodigosEnc(){
       Set<Integer> codigoSet = this.encomendaMap.keySet();
       return codigoSet;
    }

    public void addEncomenda (Encomenda enc){
        this.encomendaMap.put(enc.getNrEncomenda(),enc);
    }

    public Encomenda getEncomenda(Integer codEnc){
        for(Map.Entry<Integer,Encomenda> entry : encomendaMap.entrySet()){
            if(entry.getKey() == codEnc){
                return entry.getValue();
            }
        }
        return null;
    }

    public void removeEncomenda(Integer codEnc){
        this.encomendaMap.remove(codEnc);
    }

    public Integer encomendaComMaisProdutos(){
            int max = 0;
            int cod = 0;
            for(Map.Entry<Integer,Encomenda> entry : encomendaMap.entrySet()) {
                if (entry.getValue().numeroTotalProdutos() > max) {
                    max = entry.getValue().numeroTotalProdutos();
                    cod = entry.getKey();
                }
            }
            return cod;
    }

    public Set<Integer> encomendasComProduto(String codProd){
        Set <Integer> encomendaSet = new HashSet<>();
        for(Map.Entry<Integer,Encomenda> entry : encomendaMap.entrySet()){
            if(entry.getValue().existeProdutoEncomenda(codProd)){
                encomendaSet.add(entry.getKey());
            }
        }
        return  encomendaSet;
    }

    public Set<Integer> encomendasAposData(LocalDate d){
        Set<Integer> encomendaSet = new HashSet<>();
        for(Map.Entry<Integer,Encomenda> entry : encomendaMap.entrySet()){
            if(entry.getValue().getDataEncomenda().isAfter(d)){
                encomendaSet.add(entry.getKey());
            }
        }
        return encomendaSet;
    }


}
