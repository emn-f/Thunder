package servicos;

import interfaces.ServicoTaxa;

public class ServicoTaxaParaiso implements ServicoTaxa {
    @Override
    public double calculaTaxa(Double valorDiaria) {
        return (valorDiaria * 0.05) + 10;
    }
}
