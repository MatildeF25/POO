public class Telemovel {

    private String marca, modelo;
    private int dispX, dispY;
    private byte armzMsg, armzFoto, armzApp;
    private int armOcupado, armFotoAppTotal, armMax;
    private String[] msg, apps;
    private int numMsg, numFoto, numApps;

    public Telemovel(){
        this.marca = "N/A";
        this.modelo = "N/A";
        this.dispX = 0;
        this.dispY = 0;
        this.armzMsg = 0;
        this.armzFoto = 0;
        this.armzApp = 0;
        this.armOcupado = 0;
        this.armFotoAppTotal = 0;
        this.armMax = 0;
        this.msg = new String[10];
        this.apps = new String[10];
        this.numMsg = 0;
        this.numFoto = 0;
        this.numApps = 0;
    }

    public Telemovel (String marca, String modelo, int displayX, int displayY, byte armMsg, byte armFoto, byte armApp, int armMax)
    {
        this.marca = new String(marca);
        this.modelo = new String(modelo);
        this.dispX = displayX;
        this.dispY = displayY;
        this.armzMsg = armMsg;
        this.armzFoto = armFoto;
        this.armzApp = armApp;
        this.armFotoAppTotal = (int) (0.8*armMax);
        this.armMax = armMax;
        this.armOcupado = 0;
        this.msg = new String[10];
        this.apps = new String[10];
        this.numMsg = 0;
        this.numFoto = 0;
        this.numApps = 0;
    }

    public Telemovel (Telemovel t){
        this.marca = t.getMarca();
        this.modelo = t.getModelo();
        this.dispX = t.getDispX();
        this.dispY = t.getDispY();
        this.armzMsg = t.getArmzMsg();
        this.armzFoto = t.getArmzFoto();
        this.armzApp = t.getArmzApp();
        this.armOcupado = t.getArmOcupado();
        this.armFotoAppTotal = t.armFotoAppTotal;
        this.armMax = t.getArmMax();
        this.msg = t.getMsg();
        this.apps = t.getApps();
        this.numMsg = t.getNumMsg();
        this.numFoto = t.getNumFoto();
        this.numApps = t.getNumApps();
    }

    public String getMarca(){
        return this.marca;
    }

    public String getModelo(){
        return this.modelo;
    }

    public int getDispX(){
        return this.dispX;
    }

    public int getDispY(){
        return this.dispY;
    }

    public byte getArmzMsg(){
        return this.armzMsg;
    }

    public byte getArmzFoto(){
        return armzFoto;
    }

    public byte getArmzApp(){
        return armzApp;
    }

    public int getArmOcupado(){
        return armOcupado;
    }

    public int getArmFotoAppTotal(){
        return armFotoAppTotal;
    }

    public int getArmMax(){
        return armMax;
    }

    public String[] getMsg () {
        return this.msg.clone();
    }

    public String[] getApps () {
        return this.apps.clone();
    }

    public int getNumMsg(){
        return numMsg;
    }

    public int getNumFoto(){
        return numFoto;
    }

    public int getNumApps(){
        return numApps;
    }

    public Telemovel clone (){
        return new Telemovel(this);
    }

    public String toString() {
        return "Marca: " + this.marca + "\nModelo: " + this.modelo + "\nDimensao do Display: " + this.dispX + "x" + this.dispY +
                "\nArmazenamento total de Mensagens: " + this.armzMsg + "\n Armazenamento total de Fotos: " + this.armzFoto +
                "\nArmazenamento total de Apps: " + this.armzApp + "\nArmazenamento total ocupado: " + this.armOcupado +
                "\nNumero de Mensagens: " + this.numMsg + ", Numero de Fotos: " + this.numFoto + ", Numero de Apps: " + this.numApps;
    }


    public boolean equals ( Object o ) {
        if ( this == o )
            return true ;
        if (( o == null ) || ( this . getClass () != o . getClass () ) )
            return false ;
        Telemovel t = ( Telemovel ) o ;
        return (this.marca.equals(t.getMarca())) && (this.modelo.equals(t.getModelo()))
                && (this.dispX == t.getDispX()) && (this.dispY == t.getDispY())
                && (this.armzMsg == t.getArmzMsg()) && (this.armzFoto == t.getArmzFoto())
                && (this.armzApp == t.getArmzApp()) && (this.armFotoAppTotal == t.getArmFotoAppTotal())
                && (this.armOcupado == t.getArmOcupado()) && (this.armMax == t.getArmMax())
                && (this.numApps == t.getNumApps()) && (this.numFoto == t.getNumFoto())
                && (this.numMsg == t.getNumMsg()) && (this.apps.equals(t.getApps()))
                && (this.msg.equals(t.getMsg()));

    }

    public boolean existeEspaco(int numeroBytes){
        if(this.armMax > this.armOcupado + numeroBytes)
            return true;
        else return false;
    }

    public void instalaApp (String nome, int tamanho){
        if(existeEspaco(tamanho) && tamanho<=this.armzApp){

            if(this.apps.length <= this.numApps){
                String[] novo = new String[(int)(this.apps.length*0.3)];
                System.arraycopy(this.apps, 0, novo, 0, this.numApps);
                this.apps = novo;
            }
            this.apps[this.numApps++] = new String(nome);
            this.armOcupado += tamanho;
            this.armFotoAppTotal += tamanho;

        }
    }
    public void recebeMsg(String msg){
        if (existeEspaco(msg.length()) && (msg.length() < this.armzMsg))
        {
            if (this.msg.length <= this.numMsg)
            {
                String[] novo = new String[(int)(this.msg.length*0.3)];
                System.arraycopy(this.msg, 0, novo, 0, this.numMsg);
                this.msg = novo;
            }
            this.msg[this.numMsg++] = new String(msg);
            this.armOcupado += msg.length();
        }
    }

    public double tamMedioApps() {
        return (double) this.armFotoAppTotal / this.numApps;
    }

    public String maiorMsg(){
        int max = 0;
        int max_i = 0;
        int l = 0;
        for(int i = this.numMsg; i>0; i--){
            l = this.msg[this.numMsg].length();
            if(l>max){
                max = l;
                max_i = i;
            }
        }
        return this.msg[max_i];
    }

    public void removeApp(String nome, int tamanho){
        int f = 0;
        for(int i = this.numApps; i>0 && f==0; i--){
            if(this.apps[i].equals(nome)){
                for(int j = i; j<this.numApps-1;j++){
                    this.apps[j] = this.apps[j+1];
                }
                this.numApps--;
                this.armFotoAppTotal -= tamanho;
                this.armOcupado -= tamanho;
                f = 1;
            }
        }
    }


}






