import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class Livro implements Comparable<Livro>, Serializable {
    public String codISBN; //código ISBN do livro
    private String nomeLivro;
    private String autor;
    private String editora;
    private List<Pagina> pagLidas; // páginas já lidas
    private List<Pagina> pagPorLer; //páginas ainda por ler.


    public Pagina devolvePag(int numPag) throws PagInexistenteException {
        Pagina res = null;
        int numLidas = this.pagLidas.size(); //número de páginas lidas
        int porLer = this.pagPorLer.size();
        if (numPag > numLidas+porLer)
            throw new PagInexistenteException(numLidas);
        if (numPag <= numLidas )
            res = this.pagLidas.get(numPag -1);
        else
            res = this.pagPorLer.get(numPag-numLidas -1);
        return res.clone();
    }
}

class Pagina implements Comparable<Pagina>, Serializable {
    private List<String> texto;
    public Pagina() {
        this.texto = new ArrayList<>();
    }

    public String reproduzPagina() {...}
}


class PaginaComAudio extends Pagina implements Comparable<PaginaComAudio>, Serializable {
    private String narrador;
    private List<Byte> som;

    public PaginaComAudio(List<String> texto, String narrador, List<Byte> audio) {
        super(texto);
        this.narrador = narrador;
        this.audio = new ArrayList<>(audio);
    }
    public String reproduzPagina() {...}
}


class Utilizador implements Serializable {
    private String numUser;
    private String nomeUser;
    private LocalDate dataAdesao;

    private List<Livro> livrosAdquiridos;


    public Utilizador(String numUser, String nomeUser, Iterator<Livro> livros) {
        this.numUser = numUser;
        this.nomeUser = nomeUser;
        this.dataAdesao = LocalDate.now();
        this.livrosAdquiridos = new ArrayList<>();
        while (livros.hasNext()) {
            Livro l = livros.next();
            this.livrosAdquiridos.add(l.clone());
        }
    }

    public void avancaPags(String codISBN, int n) throws LivroLidoException, LivroNaoAdquiridoException{
        int i = 0;
        for(Livro l : this.livrosAdquiridos){
            if(l.getcodISBN().equals(codISBN)){
                if(l.getPaginasPorLer() == null){
                    throw new LivroLidoException;
                }
                else{
                    for (; i<n;i++){
                        Pagina p = l.getPaginasPorLer().get(0);
                        l.getPaginasLidas.add(p.clone);
                        l.getPaginasPorLer.remove(p);
                    }
                }
            }
        }
        if(i==0){
            throw new LivroNaoAdquiridoException;
        }
    }

    public Livro livroMaisLido(){
        int max = 0;
        Livro l1 = null;
        for(Livros l : this.livrosAdquiridos){
            if(l.getPginasLidas().size() > max){
                max =  l.getPginasLidas().size();
                l1 = l.clone();
            } else if (l.getPginasLidas().size() == max) {
                if (l.getNomeLivro().compareTo(l1.getNomeLivro()) > 0)
                    l1 = l.clone();
            }
        }
        return l1;
    }

}




class LivrosDigitais {
    List<Utilizador> utilizadores;


    public Map<String,List<Livro» livrosPorEditora(){
        Map<String, List<Livro>> listMap;
        for(Utilizador u : this.utilizadores){
            for(Livro l : u.getLivrosAdquiridos()){
                String editora =l.getEditora());
                if(listMap.containsKey(editora){
                    if(!listMap.get(editora).contains(l)){
                        listMap.get(editora).add(l.clone);
                    }
                }
                else{
                    List <Livro> l2 = new ArrayList<>();
                    l2.add(l.clone);
                    listMap.put(editora,l2);
                }
            }
        }
        return listMap;
    }

}





