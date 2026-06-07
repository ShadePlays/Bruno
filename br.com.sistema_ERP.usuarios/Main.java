import java.util.Scanner;


public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        
        
        RH.criar_usuario_padrao();
        Scanner scanner = new Scanner(System.in);

        int seta = -1;
         while(seta !=0){
        Interface.tela_inicial(scanner);
        System.out.print("Deseja continuar? (1 - Sim, 0 - Não): ");
        seta = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner
    }

        // teste de cadastro de produtos
    int cont = 0;
    while(cont <=3){
        Estoque.registrarProduto(scanner);
        cont++;
    }
    // termina aqui o teste de cadastro de produtos
       
        Financeiro.registrar_em_arquivo_csv();
        RH.registrar_em_arquivo_csv();
        Vendas.registrar_em_arquivo_csv();
        Estoque.registrar_em_arquivo_csv();
           
        scanner.close();
        System.out.println("Sistema encerrado.");
    }
}

        
        

