package servicos;

import java.time.Duration;

import entidades.Aluguel;
import entidades.Boleto;
import interfaces.ServicoTaxa;

public class ServicoGerarBoleto {
    private double valorDiaria;
    private ServicoTaxa servicoTaxa;

    public ServicoGerarBoleto(double valorDiaria, ServicoTaxa servicoTaxa) {
        this.valorDiaria = valorDiaria;
        this.servicoTaxa = servicoTaxa;
    }

    public double getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(double valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    public ServicoTaxa getServicoTaxa() {
        return servicoTaxa;
    }

    public void setServicoTaxa(ServicoTaxa servicoTaxa) {
        this.servicoTaxa = servicoTaxa;
    }

    public void processarBoleto(Aluguel aluguel) {
        Duration tempo = Duration.between(aluguel.getEntrada().atStartOfDay(), aluguel.getSaida().atStartOfDay());
        Long dias = tempo.toDays();
        double taxaDiaria = servicoTaxa.calculaTaxa(valorDiaria);
        double taxaTotal = taxaDiaria * dias;
        double valorTotal = (valorDiaria * dias) + taxaTotal;
        aluguel.setBoleto(new Boleto(taxaTotal, valorTotal));
    }
}