package sample.currencycalculater.Models;

public class Model {
    private double amount, result;
    private String first, second;
    private double euroToDollar, syrlToDollar,trlToDollar, madToDollar, chfToDollar;

    public Model(){
        amount=0.0;
        result=0.0;
        first="$";
        second="€";
    }
    public void setAmount(double x){
        amount=x;
    }
    public double getAmount(){
        return amount;
    }
    public void setFirst(String first) {
        this.first = first;
    }
    public void setSecond(String second) {
        this.second = second;
    }
    public double getResult() {
        return result;
    }
    public String getFirst() {
        return first;
    }
    public String getSecond() {
        return second;
    }
    public void reset(){
        amount=0.0;
        result=0.0;
        first="$";
        second="€";
    }

    public void setSyrlToDollar(double syrlToDollar) {
        this.syrlToDollar = syrlToDollar;
    }

    public void setMadToDollar(double madToDollar) {
        this.madToDollar = madToDollar;
    }

    public void setChfToDollar(double chfToDollar) {
        this.chfToDollar = chfToDollar;
    }

    public void setEuroToDollar(double euroToDollar) {
        this.euroToDollar = euroToDollar;
    }

    public void setTrlToDollar(double trlToDollar) {
        this.trlToDollar = trlToDollar;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public double getSyrlToDollar() {
        return syrlToDollar;
    }

    public double getMadToDollar() {
        return madToDollar;
    }

    public double getEuroToDollar() {
        return euroToDollar;
    }

    public double getChfToDollar() {
        return chfToDollar;
    }

    public double getTrlToDollar() {
        return trlToDollar;
    }
    public void calculate(){
        double x = amount*toDollar(first);
        result = x * fromDollar(second);
    }
    public double toDollar(String c){
        double temp= 1.0;
        switch (c){
            case "€": temp=euroToDollar; break;
            case "SYRL": temp=syrlToDollar; break;
            case "TRL": temp=trlToDollar; break;
            case "MAD": temp=madToDollar; break;
            case "CHF": temp=chfToDollar; break;
        }
        return temp;
    }

    public double fromDollar(String c){
        double temp= 1.0;
        switch (c){
            case "€": temp=1/euroToDollar; break;
            case "SYRL": temp=1/syrlToDollar; break;
            case "TRL": temp=1/trlToDollar; break;
            case "MAD": temp=1/madToDollar; break;
            case "CHF": temp=1/chfToDollar; break;
        }
        return temp;
    }

}
