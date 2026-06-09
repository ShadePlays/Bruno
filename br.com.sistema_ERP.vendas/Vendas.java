import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Vendas {
    
    private static HashMap<Integer, Sale> banco_vendas = new HashMap<>();
    
    public static void dados_teste() {
        Sale venda1 = new Sale(1, 2, "01/01/2024", "Produto A", "123.456.789-00"    );
        Sale venda2 = new Sale(2, 1, "02/01/2024", "Produto B", "987.654.321-00");
        banco_vendas.put(1, venda1);
        banco_vendas.put(2, venda2);
    }

    public static void registrarVenda(Scanner scanner) {
        System.out.println("Registrar Venda");
        System.out.println("Digite o código do produto:");
        int codigoProduto = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner
        System.out.println("Digite a quantidade vendida:");
        int quantidadeVendida = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner
        System.out.println("Digite a data da venda (dd/mm/yyyy):");
        String dataVenda = scanner.nextLine();

       if(Estoque.verificarEstoque(codigoProduto)>=quantidadeVendida){
       
        Estoque.atualizarQuantidade(codigoProduto, -quantidadeVendida);
       
        System.out.println("Venda registrada: Produto código " + codigoProduto + ", Quantidade vendida: " + quantidadeVendida);
       
        Financeiro.registrarFaturamento(Estoque.valorTotalProdutos(codigoProduto, quantidadeVendida), Estoque.NomeProduto(codigoProduto), dataVenda);

        Sale venda = new Sale(codigoProduto, quantidadeVendida, dataVenda, Estoque.NomeProduto(codigoProduto), "123.456.789-00");
        banco_vendas.put(codigoProduto, venda);
       }
        else {
        System.out.println("Estoque insuficiente para o produto código " + codigoProduto);
        
    }

}

    public static void exibirVendas() {
        System.out.println("Vendas Registradas:");
        for (Integer codigo : banco_vendas.keySet()) {
            System.out.println("codigo: " + codigo + ", Venda: " + banco_vendas.get(codigo));
        }
    }

    public static void exibirVendasPorData(String data) {
        System.out.println("Vendas na data: " + data);
        for (Integer codigo : banco_vendas.keySet()) {
            if (banco_vendas.get(codigo).getDataVenda().equalsIgnoreCase(data)) {
                System.out.println("codigo: " + codigo + ", Venda: " + banco_vendas.get(codigo));
            }
        }
    }

    public static void registrar_em_arquivo_csv() {
         try{

        PrintWriter writer = new PrintWriter("vendas.csv");

        writer.println("codigoProduto;quantidadeVendida;dataVenda;nomeProduto");
            for (Map.Entry<Integer, Sale> entry : banco_vendas.entrySet()) {
    
                Integer codigo = entry.getKey();
                Sale venda = entry.getValue();
    
                writer.println(
                    codigo + ";" +
                    venda.getCodigoProduto() + ";" +
                    venda.getQuantidadeVendida() + ";" +
                    venda.getDataVenda() + ";" +
                    venda.getNomeProduto()
                );
            }
       
        writer.close();

        System.out.println("Arquivo vendas.csv criado com sucesso!");

         }catch (Exception erro) {
            System.out.println("Ocorreu um erro ao criar o arquivo vendas.csv: " + erro.getMessage());
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

   
}


