public class Circulo {

    private double x;
    private double y;
    private double raio;

    public Circulo(){
        this.x = 0.0;
        this.y = 0.0;
        this.raio = 0.0;
    }

    public Circulo (double x, double y, double raio){
        this.x = x;
        this.y = y;
        this.raio = raio;
    }

    public Circulo (Circulo circulo){
        this.x = circulo.getX();
        this.y = circulo.getY();
        this.raio = circulo.getRaio();
    }

    public double getX(){
        return this.x;
    }

    public double getY(){
        return this.y;
    }

    public double getRaio() {
        return raio;
    }

    public void setX(double x){
        this.x = x;
    }

    public void setY(double y){
        this.y = y;
    }

    public void setRaio(double raio){
        this.raio = raio;
    }

    public void altera_centro (double x, double y){
        this.setX(x);
        this.setY(y);
    }

    public double calcula_area(){
        double pi = Math.PI;
        return pi*Math.pow(this.raio,2);
    }

    public double calculaPerimetro(){
        double pi = Math.PI;
        return 2*pi*this.raio;
    }

}