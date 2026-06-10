import java.io.File;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Vendas {

    private static HashMap<Integer, Sale> banco_vendas = new HashMap<>();
    static {
        Vendas.LeituraCSV(banco_vendas);
    }

    public static void dados_teste() {

    Sale venda1 = new Sale(1001, 2, "01/01/2024", "Arroz", "123.456.789-00");
    banco_vendas.put(1, venda1);

    Sale venda2 = new Sale(1002, 3, "02/01/2024", "Feijão Carioca", "987.654.321-00");
    banco_vendas.put(2, venda2);

    Sale venda3 = new Sale(1003, 5, "03/01/2024", "Macarrão Espaguete", "456.123.789-10");
    banco_vendas.put(3, venda3);

    Sale venda4 = new Sale(2001, 4, "04/01/2024", "Detergente", "321.654.987-20");
    banco_vendas.put(4, venda4);

    Sale venda5 = new Sale(2002, 2, "05/01/2024", "Água Sanitária", "741.852.963-30");
    banco_vendas.put(5, venda5);

    Sale venda6 = new Sale(2003, 1, "06/01/2024", "Desinfetante", "159.357.486-40");
    banco_vendas.put(6, venda6);

    Sale venda7 = new Sale(3001, 1, "08/01/2024", "Smartphone", "258.369.147-50");
    banco_vendas.put(7, venda7);

    Sale venda8 = new Sale(3002, 1, "10/01/2024", "Notebook", "369.258.147-60");
    banco_vendas.put(8, venda8);

    Sale venda9 = new Sale(3003, 3, "12/01/2024", "Fone Bluetooth", "147.258.369-70");
    banco_vendas.put(9, venda9);

    Sale venda10 = new Sale(1001, 8, "15/01/2024", "Arroz", "963.852.741-80");
    banco_vendas.put(10, venda10);

    Sale venda11 = new Sale(1002, 6, "18/01/2024", "Feijão Carioca", "852.741.963-90");
    banco_vendas.put(11, venda11);

    Sale venda12 = new Sale(3001, 2, "20/01/2024", "Smartphone", "741.963.852-11");
    banco_vendas.put(12, venda12);
}

    public static void registrarVenda(Scanner scanner) {
        try {
            System.out.println("Registrar Venda");
            System.out.println("Digite o código do produto:");
            int codigoProduto = TesteEntrada.nextInt(scanner);
            scanner.nextLine(); // Limpar o buffer do scanner
            System.out.println("Digite a quantidade vendida:");
            int quantidadeVendida = TesteEntrada.nextInt(scanner);
            scanner.nextLine(); // Limpar o buffer do scanner
            System.out.println("Digite a data da venda (dd/mm/yyyy):");
            String dataVenda = scanner.nextLine();
            System.out.println("Digite o CPF do cliente:");
            String cpfCliente = scanner.nextLine();
            if (cpfCliente.length() == 11) {
                cpfCliente = cpfCliente.substring(0, 3) + "." + cpfCliente.substring(3, 6) + "." + cpfCliente.substring(6, 9) + "-" + cpfCliente.substring(9, 11);
            }

            if (Estoque.verificarEstoque(codigoProduto) >= quantidadeVendida) {

                Estoque.atualizarQuantidade(codigoProduto, -quantidadeVendida);

                System.out.println("Venda registrada: Produto código " + codigoProduto + ", Quantidade vendida: "
                        + quantidadeVendida);

                Financeiro.registrarFaturamento(Estoque.valorTotalProdutos(codigoProduto, quantidadeVendida),
                        Estoque.NomeProduto(codigoProduto), dataVenda);

                Sale venda = new Sale(codigoProduto, quantidadeVendida, dataVenda, Estoque.NomeProduto(codigoProduto),
                        cpfCliente);
                banco_vendas.put(codigoProduto, venda);
            } else {
                System.out.println("Estoque insuficiente para o produto código " + codigoProduto);

            }
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao registrar a venda: ");
        }

    }

    public static void exibirVendas() {
        System.out.println("Vendas Registradas:");
        for (Integer codigo : banco_vendas.keySet()) {
            System.out.println("codigo: " + codigo + ", Venda: " + banco_vendas.get(codigo).getNomeProduto());
        }
    }

    public static void exibirVendasPorData(String data) {
        System.out.println("Vendas na data: " + data);
        for (Integer codigo : banco_vendas.keySet()) {
            if (banco_vendas.get(codigo).getDataVenda().equalsIgnoreCase(data)) {
                System.out.println("codigo: " + codigo + ", Venda: " + banco_vendas.get(codigo).getNomeProduto());
            }
        }
    }

    public static void registrarEmArquivoCSV() {
        try {

            PrintWriter writer = new PrintWriter("vendas.csv");

            writer.println("codigoProduto;quantidadeVendida;dataVenda;nomeProduto;cpfCliente");
            for (Map.Entry<Integer, Sale> entry : banco_vendas.entrySet()) {

                Integer codigo = entry.getKey();
                Sale venda = entry.getValue();

                writer.println(
                        codigo + ";" +
                                venda.getQuantidadeVendida() + ";" +
                                venda.getDataVenda() + ";" +
                                venda.getNomeProduto() + ";" +
                                venda.getCpfCliente());
            }

            writer.close();
            System.out.println("==================================================");
            System.out.println("Arquivo vendas.csv criado com sucesso!");
            System.out.println("==================================================");
        } catch (Exception erro) {
            System.out.println("==================================================");
            System.out.println("Ocorreu um erro ao criar o arquivo vendas.csv: ");
            System.out.println("==================================================");
        }

    }

    public static void editarVenda(Scanner scanner) {
        System.out.println("Editar Venda");
        System.out.println("Digite o código do produto da venda que deseja editar:");
        int codigoProduto = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner

        if (banco_vendas.containsKey(codigoProduto)) {
            Sale venda = banco_vendas.get(codigoProduto);
            System.out.println("Venda encontrada: " + venda);
            System.out.println("Digite a nova quantidade vendida:");
            int novaQuantidadeVendida = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner
            System.out.println("Digite a nova data da venda (dd/mm/yyyy):");
            String novaDataVenda = scanner.nextLine();

            venda.setQuantidadeVendida(novaQuantidadeVendida);
            venda.setDataVenda(novaDataVenda);
            banco_vendas.put(codigoProduto, venda);

            System.out.println("Venda atualizada: " + venda);
        } else {
            System.out.println("Venda não encontrada para o código do produto: " + codigoProduto);
        }
    }

    public static void LeituraCSV(HashMap<Integer, Sale> banco_vendas) {
        try (Scanner scanner = new Scanner(new File("vendas.csv"))) {
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine();
                if (linha.trim().isEmpty()) {
                    continue;
                }
                String[] campos = linha.split(";");
                int codigoProduto = Integer.parseInt(campos[0]);
                int quantidadeVendida = Integer.parseInt(campos[1]);
                String dataVenda = campos[2];
                String nomeProduto = campos[3];
                String cpfCliente = campos[4];
                Sale venda = new Sale(codigoProduto, quantidadeVendida, dataVenda, nomeProduto, cpfCliente);
                banco_vendas.put(codigoProduto, venda);
            }
        } catch (Exception erro) {
            System.out.println("Ocorreu um erro ao ler o arquivo vendas.csv: " + erro.getMessage());
        }
    }

}
