package sample.currencycalculater.Models;

public class UpdateModel {
    private double euroToDollar, syrlToDollar, trlToDollar, madToDollar, chfToDollar;

    public UpdateModel(){
        euroToDollar = 1.08;
        syrlToDollar = 0.0003;
        trlToDollar = 0.05;;
        madToDollar = 0.099;
        chfToDollar = 1.11;
    }

    public void setEuroToDollar(double euroToDollar) {
        this.euroToDollar = euroToDollar;
    }
    public void setChfToDollar(double chfToDollar) {
        this.chfToDollar = chfToDollar;
    }
    public void setMadToDollar(double madToDollar) {
        this.madToDollar = madToDollar;
    }
    public void setSyrlToDollar(double syrlToDollar) {
        this.syrlToDollar = syrlToDollar;
    }
    public void setTrlToDollar(double trlToDollar) {
        this.trlToDollar = trlToDollar;
    }
    public double getChfToDollar() {
        return chfToDollar;
    }
    public double getEuroToDollar() {
        return euroToDollar;
    }
    public double getMadToDollar() {
        return madToDollar;
    }
    public double getSyrlToDollar() {
        return syrlToDollar;
    }
    public double getTrlToDollar() {
        return trlToDollar;
    }
}
