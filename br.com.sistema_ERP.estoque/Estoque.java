import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Estoque {
    
    private static HashMap<Integer, Produto> banco_produtos = new HashMap<>();

    public static void registrarProduto(Scanner scanner) {
        System.out.println("Registrar Produto");
        System.out.println("Digite o tipo do produto (1 - Alimentício, 2 - Limpeza, 3 - Eletrônico):");
        int tipoProduto = TesteEntrada.nextInt(scanner);
        if (tipoProduto < 1 || tipoProduto > 3) {
            System.out.println("Tipo de produto inválido. Produto não registrado.");
            return;
        }
        scanner.nextLine(); // Limpar o buffer do scanner
        
        System.out.println("Digite o nome do produto:");
        String nome = scanner.nextLine();

        System.out.println("Digite o preço de custo do produto:");
        double custo = TesteEntrada.nextDouble(scanner);
        scanner.nextLine(); // Limpar o buffer do scanner
        while (custo < 0) {
            System.out.println("Coloque um valor válido para o custo (maior ou igual a 0): ");
            custo = TesteEntrada.nextDouble(scanner);
            scanner.nextLine(); // Limpar o buffer do scanner
        }

        System.out.println("Digite o preço de venda do produto:");
        double precoVenda = TesteEntrada.nextDouble(scanner);
        scanner.nextLine(); // Limpar o buffer do scanner
        while (precoVenda < 0) {
            System.out.println("Coloque um valor válido para o preço de venda (maior ou igual a 0): ");
            precoVenda = TesteEntrada.nextDouble(scanner);
            scanner.nextLine(); // Limpar o buffer do scanner
        }

        System.out.println("Digite a quantidade em estoque:");
        int quantidade = TesteEntrada.nextInt(scanner);
        scanner.nextLine(); // Limpar o buffer do scanner
        while (quantidade < 0) {
            System.out.println("Coloque um valor válido para a quantidade (maior ou igual a 0): ");
            quantidade = TesteEntrada.nextInt(scanner);
            scanner.nextLine(); // Limpar o buffer do scanner
        }

        Produto produto = null;
        if (tipoProduto == 1) {
            produto = new ProdutoAlimenticio();
            System.out.println("Digite a data de validade do produto (dd/mm/yyyy)");
            System.out.println("Comece pelo ano: ");
            int dataAno = TesteEntrada.nextInt(scanner);

            while (dataAno < 2026) {
                System.out.println("Coloque um ano válido (2026 ou superior): ");
                dataAno = TesteEntrada.nextInt(scanner);
                scanner.nextLine(); // Limpar o buffer do scanner
            }
            
            System.out.println("Digite o mês: ");
            int dataMes = TesteEntrada.nextInt(scanner);
            scanner.nextLine(); // Limpar o buffer do scanner
             while (dataMes < 1 || dataMes > 12) {
                System.out.println("Coloque um mês válido (1-12): ");
                dataMes = TesteEntrada.nextInt(scanner);
                scanner.nextLine(); // Limpar o buffer do scanner
            }

            System.out.println("Digite o dia: ");
            int dataDia = TesteEntrada.nextInt(scanner);
            scanner.nextLine(); // Limpar o buffer do scanner
            if (dataMes == 2) {
                     while (dataDia < 1 || dataDia > 29) {
                         System.out.println("Coloque um dia válido para fevereiro (1-29): ");
                          dataDia = TesteEntrada.nextInt(scanner);
                          scanner.nextLine(); // Limpar o buffer do scanner
                       }
           } else if (dataMes == 4 || dataMes == 6 || dataMes == 9 || dataMes == 11) {
                if (dataDia > 30 || dataDia < 1) {
                    System.out.println("Coloque um dia válido para o mês selecionado (1-30): ");
                    while (dataDia < 1 || dataDia > 30) {
                        System.out.println("Coloque um dia válido para o mês selecionado (1-30): ");
                        dataDia = TesteEntrada.nextInt(scanner);
                        scanner.nextLine(); // Limpar o buffer do scanner
                    }
                }
                } else {
                      while (dataDia < 1 || dataDia > 31) {
                            System.out.println("Coloque um dia válido para o mês selecionado (1-31): ");
                            dataDia = TesteEntrada.nextInt(scanner);
                            scanner.nextLine(); // Limpar o buffer do scanner
                        }
                }
            
            String dataValidade = String.format("%02d/%02d/%04d", dataDia, dataMes, dataAno);
            ((ProdutoAlimenticio) produto).setDataValidade(dataValidade);

        } else if (tipoProduto == 2) {
            produto = new ProdutoLimpeza();
            System.out.println("Digite a unidade de medida do produto: (L, ml, oz)");
            String unidadeMedida = scanner.nextLine();
            unidadeMedida = unidadeMedida.toUpperCase();
                while (!unidadeMedida.equals("L") && !unidadeMedida.equals("ML") && !unidadeMedida.equals("OZ")) {
                    System.out.println("Coloque uma unidade de medida válida (L, ml, oz): ");
                    unidadeMedida = scanner.nextLine();
                    unidadeMedida = unidadeMedida.toUpperCase();
                }
            
            ((ProdutoLimpeza) produto).setunidadeMedida(unidadeMedida);
            System.out.println("Digite os ingredientes ativos do produto:");
            String ingredientesAtivos = scanner.nextLine();
            ((ProdutoLimpeza) produto).setIngredientesAtivos(ingredientesAtivos);

            System.out.println("Digite o volume do produto:");
            double volume = TesteEntrada.nextDouble(scanner);
            scanner.nextLine(); // Limpar o buffer do scanner
            while (volume <= 0) {
                System.out.println("Coloque um volume válido (maior que 0): ");
                volume = TesteEntrada.nextDouble(scanner);
                scanner.nextLine(); // Limpar o buffer do scanner
            }
            ((ProdutoLimpeza) produto).setVolume(volume);

        } else if (tipoProduto == 3) {
            produto = new ProdutoEletronico();
            System.out.println("Digite a marca do produto:");
            String marca = scanner.nextLine();
            ((ProdutoEletronico) produto).setMarca(marca);

            System.out.println("Digite o modelo do produto:");
            String modelo = scanner.nextLine();
            ((ProdutoEletronico) produto).setModelo(modelo);

            System.out.println("Digite a voltagem do produto:");
            int voltagem = TesteEntrada.nextInt(scanner);
            scanner.nextLine(); // Limpar o buffer do scanner
            while (voltagem != 127 && voltagem != 220) {
                System.out.println("Coloque uma voltagem válida (127-220): ");
                voltagem = TesteEntrada.nextInt(scanner);
                scanner.nextLine(); // Limpar o buffer do scanner
            }
            ((ProdutoEletronico) produto).setVoltagem(voltagem);

            System.out.println("Digite a garantia em meses do produto:");
            int garantiaMeses = TesteEntrada.nextInt(scanner);
            scanner.nextLine(); // Limpar o buffer do scanner
                while (garantiaMeses < 0) {
                    System.out.println("Coloque um valor válido para a garantia (0 ou superior): ");
                    garantiaMeses = TesteEntrada.nextInt(scanner);
                    scanner.nextLine(); // Limpar o buffer do scanner
                }
            ((ProdutoEletronico) produto).setGarantiaMeses(garantiaMeses);
        }

        String descricao = "";

        produto.setNome(nome);
        produto.setCusto(custo);
        produto.setDescricao(descricao);
        produto.setPrecoVenda(precoVenda);
        produto.setQuantidade(quantidade);
        produto.tipoProduto();
        produto.setAtivo( true);
        int codigo = tipoProduto*1000 +banco_produtos.size() + 1; 
        banco_produtos.put(codigo, produto);
        System.out.println("Produto registrado: " + banco_produtos.get(codigo));

    }

    public static void ativarProduto(Scanner scanner) {
        System.out.println("Ativar Produto");
        System.out.println("Digite o código do produto:");
        int codigoProduto = TesteEntrada.nextInt(scanner);
        scanner.nextLine(); // Limpar o buffer do scanner
        if (banco_produtos.containsKey(codigoProduto)) {
            banco_produtos.get(codigoProduto).setAtivo(true);
            System.out.println("Produto ativado: " + banco_produtos.get(codigoProduto));
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    public static void desativarProduto(Scanner scanner) {
        System.out.println("Desativar Produto");
        System.out.println("Digite o código do produto:");
        int codigoProduto = TesteEntrada.nextInt(scanner);
        scanner.nextLine(); // Limpar o buffer do scanner
        if (banco_produtos.containsKey(codigoProduto)) {
            banco_produtos.get(codigoProduto).setAtivo(false);
            System.out.println("Produto desativado: " + banco_produtos.get(codigoProduto));
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    public static void exibirProdutosAtivos() {
        System.out.println("Produtos em Estoque:");
        for (Integer codigo : banco_produtos.keySet()) {
            if (banco_produtos.get(codigo).isAtivo()) {
                System.out.println("codigo: " + codigo + ", Nome: " + banco_produtos.get(codigo) + ", Preço de Venda: " + banco_produtos.get(codigo).getPrecoVenda() + ", Quantidade: " + banco_produtos.get(codigo).getQuantidade());
            }
        }
    }

    public static void exibirProdutosInativos() {
        System.out.println("Produtos em Estoque:");
        for (Integer codigo : banco_produtos.keySet()) {
            if (!banco_produtos.get(codigo).isAtivo()) {
                System.out.println("codigo: " + codigo + ", Nome: " + banco_produtos.get(codigo) + ", Preço de Venda: " + banco_produtos.get(codigo).getPrecoVenda() + ", Quantidade: " + banco_produtos.get(codigo).getQuantidade());
            }
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
        int codigoProduto = TesteEntrada.nextInt(scanner);
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
        valor_total = (float) (banco_produtos.get(codigoProduto).getPrecoVenda() * quantidadeVendida);
        
        return valor_total;
    }

    public static String NomeProduto(int codigoProduto) {
        if(banco_produtos.isEmpty()) {
            System.out.println("Nenhum produto registrado.");
            return "";
        }
        return banco_produtos.get(codigoProduto).getNome();
    }

    public static void registrar_em_arquivo_csv() {
          
        try(PrintWriter writer = new PrintWriter("estoque.csv")) {
           
            boolean cabeçalhoAlimenticio = false;
            boolean cabeçalhoLimpeza = false;
            boolean cabeçalhoEletronico = false;

            for(Map.Entry<Integer,Produto> entry: banco_produtos.entrySet()){
                
                Integer codigo = entry.getKey();
                Produto produto = entry.getValue();

                if( cabeçalhoAlimenticio ==false){
                    writer.println("codigo;tipoProduto;nome;custo;precoVenda;quantidade;descricao;dataValidade");
                    cabeçalhoAlimenticio = true;
                }
                if(produto.tipoProduto()==1){
                writer.println(
                    codigo + ";" +
                    produto.tipoProduto() + ";" +
                    produto.getNome() + ";" +
                    produto.getCusto() + ";" +
                    produto.getPrecoVenda() + ";" +
                    produto.getQuantidade() + ";" +
                    produto.getDescricao() + ";" +
                    (produto instanceof ProdutoAlimenticio ? ((ProdutoAlimenticio) produto).getDataValidade() : "")
                );
            }
            }

            for(Map.Entry<Integer,Produto> entry: banco_produtos.entrySet()){
                
                Integer codigo = entry.getKey();
                Produto produto = entry.getValue();

                if( cabeçalhoLimpeza ==false){
                    writer.println("codigo;tipoProduto;nome;custo;precoVenda;quantidade;descricao;unidadeMedida;ingredientesAtivos;volume");
                    cabeçalhoLimpeza = true;
                }
                if(produto.tipoProduto()== 2){
                writer.println(
                    codigo + ";" +
                    produto.tipoProduto() + ";" +
                    produto.getNome() + ";" +
                    produto.getCusto() + ";" +
                    produto.getPrecoVenda() + ";" +
                    produto.getQuantidade() + ";" +
                    produto.getDescricao() + ";" +
                    (produto instanceof ProdutoLimpeza ? ((ProdutoLimpeza) produto).getunidadeMedida() : "") + ";" +
                    (produto instanceof ProdutoLimpeza ? ((ProdutoLimpeza) produto).getIngredientesAtivos() : "") + ";" +
                    (produto instanceof ProdutoLimpeza ? ((ProdutoLimpeza) produto).getVolume() : "")
                );
            }
            }

            for(Map.Entry<Integer,Produto> entry: banco_produtos.entrySet()){
                
                Integer codigo = entry.getKey();
                Produto produto = entry.getValue();

                if( cabeçalhoEletronico ==false){
                    writer.println("codigo;tipoProduto;nome;custo;precoVenda;quantidade;descricao;marca;modelo;voltagem;garantiaMeses");
                    cabeçalhoEletronico = true;
                }
                if(produto.tipoProduto()== 3 ){
                writer.println(
                    codigo + ";" +
                    produto.tipoProduto() + ";" +
                    produto.getNome() + ";" +
                    produto.getCusto() + ";" +
                    produto.getPrecoVenda() + ";" +
                    produto.getQuantidade() + ";" +
                    produto.getDescricao() + ";" +
                    (produto instanceof ProdutoEletronico ? ((ProdutoEletronico) produto).getMarca() : "") + ";" +
                    (produto instanceof ProdutoEletronico ? ((ProdutoEletronico) produto).getModelo() : "") + ";" +
                    (produto instanceof ProdutoEletronico ? ((ProdutoEletronico) produto).getVoltagem() : "") + ";" +
                    (produto instanceof ProdutoEletronico ? ((ProdutoEletronico) produto).getGarantiaMeses() : "")
                );
            }
            }


        } catch (Exception e) {
            System.out.println("Erro ao registrar dados no arquivo: " + e.getMessage());
        }
    }
}
