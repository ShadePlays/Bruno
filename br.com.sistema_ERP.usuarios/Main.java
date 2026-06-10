import java.util.Scanner;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {

        RH.criarUsuarioPadrao();
        Scanner scanner = new Scanner(System.in);
        int id;

        // dados de teste
        Financeiro.dados_teste();
        Estoque.dados_teste();
        Vendas.dados_teste();
        Cliente.dados_teste();
        Vendas.dados_teste();

        try {
            id = RH.login(scanner);
            if (id == -1) {
                System.out.println("Encerrando o sistema devido a falha no login.");
                System.out.println("===========================");
                scanner.close();
                return;
            }
        } catch (Exception e) {
            System.out.println("Ocorreu um erro durante o login: " + e.getMessage());
            scanner.close();
            return;
        }

        int seta = -1;
        while (seta != 0) {
            Interface.telaInicial(scanner, id);
            System.out.print("Deseja continuar? (1 - Sim, 0 - Não): ");
            seta = TesteEntrada.nextInt(scanner);
            scanner.nextLine(); // Limpar o buffer do scanner
            while (seta != 0 && seta != 1) {
                System.out.print("Entrada inválida. Por favor, digite 1 para Sim ou 0 para Não: ");
                seta = TesteEntrada.nextInt(scanner);
                scanner.nextLine(); // Limpar o buffer do scanner
            }
        }

        Financeiro.registrarEmArquivoCSV();
        RH.registrarEmArquivoCSV();
        Vendas.registrarEmArquivoCSV();
        Estoque.registrarCSV();
        Cliente.registrarEmArquivoCSV();

        scanner.close();
        System.out.println("Sistema encerrado.");
    }
}
