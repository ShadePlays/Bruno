import java.util.Scanner;
import java.util.HashMap;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        
        HashMap<Integer, Usuario> banco_usuarios = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        int seta = -1;
         while(seta !=0){
        Interface.exibirMenu();
        System.out.print("Escolha uma opção: ");
        seta = scanner.nextInt();
        if(seta >0){
        scanner.nextLine(); // Limpar o buffer do scanner
        Interface.exibirSubmenu(seta, banco_usuarios, scanner);
        }
        
    }
    
           scanner.close();
           System.out.println("Sistema encerrado.");
    }
}

        
        

