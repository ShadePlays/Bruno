import java.util.Scanner;


public class Main extends Funcoes_basicas {

    /**
     * @param args
     */
    public static void main(String[] args) {
        
        
        Funcoes_basicas.criar_usuario_padrao();
        Scanner scanner = new Scanner(System.in);

        int seta = -1;
         while(seta !=0){
        Interface.tela_inicial(scanner);
        System.out.print("Deseja continuar? (1 - Sim, 0 - Não): ");
        seta = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner
    }

        Financeiro.registrar_em_arquivo_csv();
        Funcoes_basicas.registrar_em_arquivo_csv();
        Financeiro.registrar_em_arquivo_csv();
           scanner.close();
           System.out.println("Sistema encerrado.");
    }
}

        
        

