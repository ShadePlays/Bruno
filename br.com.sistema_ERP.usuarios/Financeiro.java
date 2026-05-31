import java.util.HashMap;
import java.util.Scanner;

public class Financeiro {
    
        private static HashMap<Integer, Despesa> banco_despesas = new HashMap<>();
    
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
        
        
}
