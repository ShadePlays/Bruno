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
        Interface.exibirMenu();
        System.out.print("Escolha uma opção: ");
        seta = scanner.nextInt();
        if(seta >0){
        scanner.nextLine(); // Limpar o buffer do scanner
        Interface.exibirSubmenu(seta, scanner);
        }
        
    }
    
           scanner.close();
           System.out.println("Sistema encerrado.");
    }
}

        
        

