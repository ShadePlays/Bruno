import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Financeiro {
    
        private static HashMap<Integer, Despesa> banco_despesas = new HashMap<>();
        private static HashMap<Integer, Faturamento> banco_faturamentos = new HashMap<>();
    
        public static void registrarDespesa(Scanner scanner) {
            
            System.out.println ("Digite o valor da despesa:");
            double valor = scanner.nextDouble();
            scanner.nextLine(); // Limpar o buffer do scanner
            System.out.println("Digite a descrição da despesa:");
            String descricao = scanner.nextLine();
            System.out.println("Digite a data da despesa (dd/mm/yyyy):");
            String data = scanner.nextLine();
            System.out.println("Digite a categoria da despesa(fixa ou variável):");
            String categoria = scanner.nextLine();

            Despesa despesa = new Despesa();
            despesa.valor = valor;
            despesa.descricao = descricao;
            despesa.data = data;
            despesa.categoria = categoria;
            int codigo = banco_despesas.size() + 1; 

            banco_despesas.put(codigo, despesa);
            System.out.println("Despesa registrada: " + banco_despesas.get(codigo));
        }
    
        public static void exibirDespesas() {
            System.out.println("Despesas Registradas:");
            for (Integer codigo : banco_despesas.keySet()) {
                System.out.println("codigo: " + codigo + ", Descrição: " + banco_despesas.get(codigo));
            }
        }
        
        public static void exibirDespesasPorCategoria(String categoria) {
            System.out.println("Despesas na categoria: " + categoria);
            for (Integer codigo : banco_despesas.keySet()) {
                if (banco_despesas.get(codigo).categoria.equalsIgnoreCase(categoria)) {
                    System.out.println("codigo: " + codigo + ", Descrição: " + banco_despesas.get(codigo));
                }
            }
        }

        public static void registrarFaturamento(float valor, String nome_produto, String data) {
            Faturamento faturamento = new Faturamento();
            faturamento.setValor(valor);
            int codigo = banco_faturamentos.size() + 1; 
            faturamento.setDescricao("Faturamento venda"+ nome_produto + "data: " + data);
            banco_faturamentos.put(codigo, faturamento);
            System.out.println("Faturamento registrado: " + banco_faturamentos.get(codigo));{
            
           
        }
    }




        public static void registrar_em_arquivo_csv() {
             
            try {

        PrintWriter writer = new PrintWriter("despesas.csv");

        writer.println("Codigo;Valor;Descricao;Data;Categoria");

        for (Map.Entry<Integer, Despesa> entry : banco_despesas.entrySet()) {

            Integer codigo = entry.getKey();
            Despesa despesa = entry.getValue();

            writer.println(
                codigo + ";" +
                despesa.valor + ";" +
                despesa.descricao + ";" +
                despesa.data + ";" +
                despesa.categoria
            );
        }

        writer.close();

        System.out.println("Arquivo despesas.csv criado com sucesso!");

    } catch (Exception e) {
        System.out.println("Erro ao criar arquivo: " + e.getMessage());
    }

    try {
        PrintWriter writer = new PrintWriter("faturamentos.csv");

        writer.println("Codigo;Valor;Descricao");

        for (Map.Entry<Integer, Faturamento> entry : banco_faturamentos.entrySet()) {

            Integer codigo = entry.getKey();
            Faturamento faturamento = entry.getValue();

            writer.println(
                codigo + ";" +
                faturamento.getValor() + ";" +
                faturamento.getDescricao()
            );
        }

        writer.close();

        System.out.println("Arquivo faturamentos.csv criado com sucesso!");

    } catch (Exception e) {
        System.out.println("Erro ao criar arquivo: " + e.getMessage());
    }
        }



    }
