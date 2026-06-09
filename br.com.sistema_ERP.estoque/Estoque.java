import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Estoque {
    
    private static HashMap<Integer, Produto> banco_produtos = new HashMap<>();
    static {
        LerCSV(banco_produtos);
    }
    
    public static void dados_teste(){
        ProdutoAlimenticio produto1 = new ProdutoAlimenticio();
        produto1.setNome("Arroz");
        produto1.setCusto(10.0);
        produto1.setPrecoVenda(15.0);
        produto1.setQuantidade(100);
        produto1.setDescricao("Arroz branco tipo 1");
        produto1.setDataValidade("31/12/2025");
        produto1.setAtivo(true);
        banco_produtos.put(1001, produto1);

        ProdutoLimpeza produto2 = new ProdutoLimpeza();
        produto2.setNome("Detergente");
        produto2.setCusto(5.0);
        produto2.setPrecoVenda(8.0);
        produto2.setQuantidade(50);
        produto2.setDescricao("Detergente líquido para limpeza geral");
        produto2.setunidadeMedida("L");
        produto2.setIngredientesAtivos("Tensoativos, fragrância, corante");
        produto2.setVolume(500);
        produto2.setAtivo(true);
        banco_produtos.put(2001, produto2);

        ProdutoEletronico produto3 = new ProdutoEletronico();
        produto3.setNome("Smartphone");
        produto3.setCusto(500.0);
        produto3.setPrecoVenda(800.0);
        produto3.setQuantidade(20);
        produto3.setDescricao("Smartphone com tela de 6 polegadas e 128GB de armazenamento");
        produto3.setMarca("MarcaX");
        produto3.setModelo("ModeloY");
        produto3.setVoltagem(220);
        produto3.setGarantiaMeses(12);
        produto3.setAtivo(true);
        banco_produtos.put(3001, produto3);
    }


   public static void comprarProduto(Scanner scanner) {
        System.out.println("Comprar Produto");
        System.out.println("Digite o código do produto:");
        int codigoProduto = TesteEntrada.nextInt(scanner);
        scanner.nextLine(); // Limpar o buffer do scanner
        System.out.println("Digite a quantidade a ser comprada:");
        int quantidadeComprada = TesteEntrada.nextInt(scanner);
        scanner.nextLine(); // Limpar o buffer do scanner
        if (banco_produtos.containsKey(codigoProduto)) {
            banco_produtos.get(codigoProduto).setQuantidade(banco_produtos.get(codigoProduto).getQuantidade() + quantidadeComprada);
            System.out.println("Compra registrada: " + banco_produtos.get(codigoProduto));
        } else {
            System.out.println("Produto não encontrado.");
        }

     
        double valorUnitario = banco_produtos.get(codigoProduto).getCusto();
        Financeiro.registrarCompras(quantidadeComprada, valorUnitario);

    }

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
                System.out.println("codigo: " + codigo + ", Nome: " + banco_produtos.get(codigo).getNome() + ", Preço de Venda: " + banco_produtos.get(codigo).getPrecoVenda() + ", Quantidade: " + banco_produtos.get(codigo).getQuantidade());
            }
        }
    }

    public static void exibirProdutosInativos() {
        System.out.println("Produtos em Estoque:");
        for (Integer codigo : banco_produtos.keySet()) {
            if (!banco_produtos.get(codigo).isAtivo()) {
                System.out.println("codigo: " + codigo + ", Nome: " + banco_produtos.get(codigo).getNome() + ", Preço de Venda: " + banco_produtos.get(codigo).getPrecoVenda() + ", Quantidade: " + banco_produtos.get(codigo).getQuantidade());
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

    public static float valorTotalProdutos(int codigoProduto, int quantidadeVendida) {
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

    public static void registrarCSV() {
          
        try(PrintWriter writer = new PrintWriter("estoque.csv")) {
           
            boolean cabeçalhoAlimenticio = false;
            boolean cabeçalhoLimpeza = false;
            boolean cabeçalhoEletronico = false;

            for(Map.Entry<Integer,Produto> entry: banco_produtos.entrySet()){
                
                Integer codigo = entry.getKey();
                Produto produto = entry.getValue();

                if( cabeçalhoAlimenticio ==false){
                    writer.println("codigo;tipoProduto;nome;custo;precoVenda;quantidade;descricao;dataValidade;ativo");
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
                    (produto instanceof ProdutoAlimenticio ? ((ProdutoAlimenticio) produto).getDataValidade() : "") + ";" +
                    produto.isAtivo()
                );
            }
            }

            for(Map.Entry<Integer,Produto> entry: banco_produtos.entrySet()){
                
                Integer codigo = entry.getKey();
                Produto produto = entry.getValue();

                if( cabeçalhoLimpeza ==false){
                    writer.println("codigo;tipoProduto;nome;custo;precoVenda;quantidade;descricao;unidadeMedida;ingredientesAtivos;volume;ativo");
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
                    (produto instanceof ProdutoLimpeza ? ((ProdutoLimpeza) produto).getVolume() : "") + ";" +
                    produto.isAtivo()
                );
            }
            }

            for(Map.Entry<Integer,Produto> entry: banco_produtos.entrySet()){
                
                Integer codigo = entry.getKey();
                Produto produto = entry.getValue();

                if( cabeçalhoEletronico ==false){
                    writer.println("codigo;tipoProduto;nome;custo;precoVenda;quantidade;descricao;marca;modelo;voltagem;garantiaMeses;ativo");
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
                    (produto instanceof ProdutoEletronico ? ((ProdutoEletronico) produto).getGarantiaMeses() : "") + ";" +
                    produto.isAtivo()
                );
            }
            }


        } catch (Exception e) {
            System.out.println("Erro ao registrar dados no arquivo: " + e.getMessage());
        }
    }

    public static void LerCSV(HashMap<Integer, Produto> banco_produtos) {
        try (Scanner scanner = new Scanner(new java.io.File("estoque.csv"))) {
            String linha = scanner.nextLine(); // Ler o cabeçalho
            while (scanner.hasNextLine()) {
                linha = scanner.nextLine();
                if (linha.trim().isEmpty()) {
                    continue; // Pular linhas vazias
                }
                if (linha.startsWith("codigo;tipoProduto;nome;custo;precoVenda;quantidade;descricao;dataValidade;ativo") ||
                    linha.startsWith("codigo;tipoProduto;nome;custo;precoVenda;quantidade;descricao;unidadeMedida;ingredientesAtivos;volume;ativo") ||
                    linha.startsWith("codigo;tipoProduto;nome;custo;precoVenda;quantidade;descricao;marca;modelo;voltagem;garantiaMeses;ativo")) {
                    continue; // Pular linhas de cabeçalho
                }
                String[] dados = linha.split(";");
                int codigo = Integer.parseInt(dados[0]);
                int tipoProduto = Integer.parseInt(dados[1]);
                String nome = dados[2];
                double custo = Double.parseDouble(dados[3]);
                double precoVenda = Double.parseDouble(dados[4]);
                int quantidade = Integer.parseInt(dados[5]);
                String descricao = dados[6];

                Produto produto;
                if (tipoProduto == 1) {
                    produto = new ProdutoAlimenticio();
                    ((ProdutoAlimenticio) produto).setDataValidade(dados[7]);
                    produto.setAtivo(Boolean.parseBoolean(dados[8]));
                } else if (tipoProduto == 2) {
                    produto = new ProdutoLimpeza();
                    ((ProdutoLimpeza) produto).setunidadeMedida(dados[7]);
                    ((ProdutoLimpeza) produto).setIngredientesAtivos(dados[8]);
                    ((ProdutoLimpeza) produto).setVolume(Double.parseDouble(dados[9]));
                    produto.setAtivo(Boolean.parseBoolean(dados[10]));
                } else {
                    produto = new ProdutoEletronico();
                    ((ProdutoEletronico) produto).setMarca(dados[7]);
                    ((ProdutoEletronico) produto).setModelo(dados[8]);
                    ((ProdutoEletronico) produto).setVoltagem(Integer.parseInt(dados[9]));
                    ((ProdutoEletronico) produto).setGarantiaMeses(Integer.parseInt(dados[10]));
                    produto.setAtivo(Boolean.parseBoolean(dados[11]));
                }

                produto.setNome(nome);
                produto.setCusto(custo);
                produto.setDescricao(descricao);
                produto.setPrecoVenda(precoVenda);
                produto.setQuantidade(quantidade);
                banco_produtos.put(codigo, produto);
            }
        } catch (Exception e) {
            System.out.println("Erro ao ler dados do arquivo: " + e.getMessage());
        }
    }
}

