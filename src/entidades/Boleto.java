package entidades;

public class Boleto {
    private double taxaTotal;
    private double valorTotal;

    public Boleto(double taxaTotal, double valorTotal) {
        this.taxaTotal = taxaTotal;
        this.valorTotal = valorTotal;
    }

    public double getTaxaTotal() {
        return taxaTotal;
    }

    public void setTaxaTotal(double taxaTotal) {
        this.taxaTotal = taxaTotal;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    @Override
    public String toString() {
        return "Boleto [" +
                "Taxa Total=" + taxaTotal +
                ", Valor Total=" + valorTotal +
                ']';
    }
}
