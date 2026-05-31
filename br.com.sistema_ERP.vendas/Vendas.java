import java.util.HashMap;
import java.util.Scanner;

public class Vendas {
    
    
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
       
        Financeiro.registrarFaturamento(Estoque.valor_total_produtos(codigoProduto, quantidadeVendida), Estoque.getNomeProduto(codigoProduto), dataVenda);


       }
        else {
        System.out.println("Estoque insuficiente para o produto código " + codigoProduto);
        
    }

}
}
