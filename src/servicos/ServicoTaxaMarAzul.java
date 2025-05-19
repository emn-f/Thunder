package servicos;

import interfaces.ServicoTaxa;

public class ServicoTaxaMarAzul implements ServicoTaxa {
    @Override
    public double calculaTaxa(Double valorDiaria) {
        return (valorDiaria * 0.02) + 15;
    }
}
