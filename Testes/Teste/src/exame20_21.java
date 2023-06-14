

import java.io.FileWriter;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public interface Playable {
    public void play();
}


class Episodio implements Playable{
    private String nome;
    private double duracao;
    private int classificacao;
    private List<String> conteudo;
    private int numeroVezesTocada;
    private LocalDateTime ultimaVez;

    public Episodio(String nome, double duracao, int classificacao, List<String> conteudo, int numeroVezesTocada, LocalDateTime ultimaVez){
        this.nome = nome;
        this.duracao = duracao;
        this.classificacao = classificacao;
        this.conteudo = conteudo;
        this.numeroVezesTocada = numeroVezesTocada;
        this.ultimaVez = ultimaVez;
    }

    public void play() {
       for(String s : this.conteudo) {
           System.media.print(s);
       }
    }
    
}

class EpisodioVideo extends Episodio{
    private List<Byte> video;

    public EpisodioVideo (String nome, double duracao, int classificacao, List<String> conteudo, int numeroVezesTocada, LocalDateTime ultimaVez, List<Byte> video){
        super(nome,duracao,classificacao,conteudo,numeroVezesTocada,ultimaVez);
        this.video = video;
    }
    public void play(){
        super.play();
        for(Byte b : this.video){
            System.media.print(b);
        }
    }

}

class Utilizador {
    private String email;
    private String nome;
    private Set<Podcast> sub;


    public void playEpisodio(String idPodCast, String nomeEpisodio) throws AlreadyPlayingException{
       // throw new AlreadyPlayingException() se algum episódio já estiver a ser tocado
        for(Podcast p : this.sub){
            for(Episodio e : p.getEpesodios()){
                if(e.getUltimaVez().equals(LocalDateTime.now() || e.getUlimaVez().plusMinutes(e.getDuracao()).isAfter(LocalDateTime.now()))){
                    throw new AlreadyPlayingException();
                }
            }
        }
        for(Podcast p : this.sub){
            if(p.getNome().equals(idPodCast)){
                for(Episodio e : p.getEpesodios()){
                    if(e.getNome().equals(nomeEpisodio)){
                        if(e.getNumeroVezesTocada() == 0){
                            e.setUltimaVez(LocalDateTime.now());
                            e.play();
                        }
                        else {
                            e.setUltimaVez(LocalDateTime.now());
                            e.setNumeroVezesTocada(e.getNumeroVezesTocada() + 1);
                            e.play();
                        }
                    }
                }
            }
        }
    }
}



class UtilizadorPremium extends Utilizador{
    private List<Episodio> listaEspera;

    public void playEpisodio(String idPodCast, String nomeEpisodio) throws AlreadyPlayingException {
        try {
            super.playEpisodio(idPodCast, nomeEpisodio);
        } catch (AlreadyPlayingException e) {
            for (Podcast p : this.sub) {
                if (p.getNome().equals(idPodCast)) {
                    for (Episodio ep : p.getEpesodios()) {
                        if (ep.getNome().equals(nomeEpisodio)) {
                            this.listaEspera.add(ep);
                        }
                    }
                }
            }
        }
    }

    public void gravaInfoEpisodiosParaTocarMaisTarde(String fich) throws IOException{
        try (FileWriter fw = new FileWriter(fich)){
            fw.write(super.getNome() + "\n");
            for(Episodio e : this.listaEspera){
                fw.write(e.getNome() + " - " + e.geDuracao() + "\n");
            }
        } catch (IOException e){
            throw new IOException();
        }
    }
}


class Podcast {
    private String nome;
    private List <Episodio> epesodios;

    public List<Episodio> getEpisodios{
        return this.epesodios
                .stream()
                .map(Episodio :: clone)
                .collect(Collectors.toList());
    }
}



class SpotifyPOO {
    private Map<String,Podcast> podcastMap;
    private Map<String,Episodio> episodio;
    private Map<String,Utilizador> utilizadores;


    public void remove(String nomeP) throwsPodcastNotRegistered, PodcastHasSubscription{
        Podcast p = this.podcastMap.get(nomeP);
        if(p==null) {
            throw new PodcastNotRegistered("Podcast não registado");
        }
        for(Utilizador u : this.utilizadores.values()){
            for(Podcast p1 : u.getSub()){
                if(p1.equals(p)){
                    throw  new PodcastHasSubscription();
                }
            }
        }

        this.podcastMap.remove(nomeP);
    }

    public Episodio getEpisodioMaisLongo(String u){
        double max = 0;
        Utilizador user = this.utilizadores.get(u);
        Episodio ep = new Episodio();
        for(Podcast p : user.getSub()){
            for(Episodio e : p.getEpesodios()){
                if(e.getDuracao() > max){
                    max = e.getDuracao();
                    ep = e;
                }
            }
        }
        if(max == 0){
            return null;
        }
        return ep;
    }


    public Map<Integer,List<Episodio>> episodiosPorClassf(){
        Map<Integer, List<Episodio>> lista = new HashMap<>();
        for(Episodio e : this.episodio.values()){
            if(lista.containsKey(e.getClassificacao())){
                lista.get(e.getClassificacao()).add(e.clone());
            }
            else {
                List<Episodio> ep = new ArrayList<>();
                ep.add(e.clone());
                lista.put(e.getClassificacao(),ep);
            }
        }

        return lista;
    }



}













