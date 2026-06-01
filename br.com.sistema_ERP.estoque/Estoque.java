import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Estoque {
    
    private static HashMap<Integer, Produto> banco_produtos = new HashMap<>();

    public static void registrarProduto(Scanner scanner) {
        System.out.println("Registrar Produto");
        System.out.println("Digite o nome do produto:");
        String nome = scanner.nextLine();
        System.out.println("Digite a descrição do produto:");
        String descricao = scanner.nextLine();
        System.out.println("Digite o preço de custo do produto:");
        double custo = scanner.nextDouble();
        scanner.nextLine(); // Limpar o buffer do scanner
        System.out.println("Digite o preço de venda do produto:");
        double preco_venda = scanner.nextDouble();
        scanner.nextLine(); // Limpar o buffer do scanner
        System.out.println("Digite a quantidade em estoque:");
        int quantidade = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner

        Produto produto = new Produto();
        produto.setNome(nome);
        produto.setDescricao(descricao);
        produto.setCusto(custo);
        produto.setPreco_venda(preco_venda);
        produto.setQuantidade(quantidade);
        int codigo = banco_produtos.size() + 1; 

        banco_produtos.put(codigo, produto);
        System.out.println("Produto registrado: " + banco_produtos.get(codigo));
    }

    public static void exibirProdutos() {
        System.out.println("Produtos em Estoque:");
        for (Integer codigo : banco_produtos.keySet()) {
            System.out.println("codigo: " + codigo + ", Nome: " + banco_produtos.get(codigo));
        }
    }

    public static void atualizarQuantidade(int codigoProduto, int quantidade) {
         if (banco_produtos.containsKey(codigoProduto)) {
            banco_produtos.get(codigoProduto).setQuantidade(banco_produtos.get(codigoProduto).getQuantidade() + quantidade);
            System.out.println("Quantidade atualizada: " + banco_produtos.get(codigoProduto));
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    public static void removerProduto(Scanner scanner) {
        System.out.println("Remover Produto");
        System.out.println("Digite o código do produto:");
        int codigoProduto = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner
        if (banco_produtos.containsKey(codigoProduto)) {
            banco_produtos.remove(codigoProduto);
            System.out.println("Produto removido.");
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    public static int verificarEstoque(int codigoProduto) {
        System.out.println("Verificar Estoque");
        if(banco_produtos.isEmpty()) {
            System.out.println("Nenhum produto registrado.");
            return 0;
        }
        int soma = 0;
        soma = banco_produtos.get(codigoProduto).getQuantidade();
        
        return soma;
    }

    public static float valor_total_produtos(int codigoProduto, int quantidadeVendida) {
        System.out.println("Valor Total dos Produtos");
        if(banco_produtos.isEmpty()) {
            System.out.println("Nenhum produto registrado.");
            return 0;
        }
        float valor_total = 0;
        valor_total = (float) (banco_produtos.get(codigoProduto).getPreco_venda() * quantidadeVendida);
        
        return valor_total;
    }

    public static String getNomeProduto(int codigoProduto) {
        if(banco_produtos.isEmpty()) {
            System.out.println("Nenhum produto registrado.");
            return "";
        }
        return banco_produtos.get(codigoProduto).getNome();
    }

    public static void registrar_em_arquivo_csv() {
         try{

        PrintWriter writer = new PrintWriter("estoque.csv");

        writer.println("codigo;nome;descricao;custo;quantidade;preco_venda");
        for (Map.Entry<Integer, Produto> entry : banco_produtos.entrySet()) {
    
            Integer codigo = entry.getKey();
            Produto produto = entry.getValue();
            writer.println(codigo + ";" + produto.getNome() + ";" + produto.getDescricao() + ";" + produto.getCusto() + ";" + produto.getQuantidade() + ";" + produto.getPreco_venda()+";");
        }
        
        writer.close();

        System.out.println("Arquivo estoque.csv criado com sucesso!");

         }catch (Exception e) {
            System.out.println("Ocorreu um erro ao criar o arquivo estoque.csv: " + e.getMessage());
         }
}
}
