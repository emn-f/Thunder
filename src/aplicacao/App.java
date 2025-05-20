package aplicacao;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import entidades.Aluguel;
import entidades.Imovel;
import servicos.ServicoGerarBoleto;
import servicos.ServicoTaxaMarAzul;
import servicos.ServicoTaxaParaiso;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner in = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        int codImovel, opcaoCondominio;
        String descricao;
        double valorDiaria;
        LocalDate dataEntrada;
        LocalDate dataSaida;
        
        Imovel imovel;
        Aluguel aluguel;
        ServicoGerarBoleto gerarBoleto;

        System.out.println("*** Informe os dados da locação ***");
        System.out.print("Código do imóvel: ");
        codImovel = in.nextInt();
        in.nextLine();
        System.out.print("Descrição: ");
        descricao = in.nextLine();
        System.out.print("Valor da diária: ");
        valorDiaria = in.nextDouble();
        in.nextLine();
        System.out.print("Data de entrada (dd/MM/yyyy): ");
        dataEntrada = LocalDate.parse(in.nextLine(), formatter);
        System.out.print("Data de saída (dd/MM/yyyy): ");
        dataSaida = LocalDate.parse(in.nextLine(), formatter);

        imovel = new Imovel(codImovel, descricao);
        aluguel = new Aluguel(dataEntrada, dataSaida, imovel, null);

        System.out.print("Condomínio (1 - Mar Azul, 2 - Paraíso): ");
        opcaoCondominio = in.nextInt();
        in.nextLine();
        in.close();
        if (opcaoCondominio == 1) {
            gerarBoleto = new ServicoGerarBoleto(valorDiaria, new ServicoTaxaMarAzul());
        } else {
            gerarBoleto = new ServicoGerarBoleto(valorDiaria, new ServicoTaxaParaiso());
        }

        gerarBoleto.processarBoleto(aluguel);

        if (opcaoCondominio == 1) {
            System.out.println("\n***Boleto Condomínio Mar Azul***");
        } else {
            System.out.println("\n***Boleto Condomínio Paraiso***");
        }
        System.out.println(imovel);
        System.out.println(aluguel);
        System.out.println(aluguel.getBoleto());
        
    }
}
