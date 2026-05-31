
import java.util.Scanner;
public class Interface extends Funcoes_basicas {
    
    
    public static void exibirMenu() {
        System.out.println("Bem-vindo ao Sistema ERP!");
        System.out.println("===========================");
        System.out.println("0. Sair");
        System.out.println("exibirMenu(1) - Cadastrar");
        System.out.println("exibirMenu(2) - Buscar");
        System.out.println("exibirMenu(3) - Exibir Todos");
        System.out.println("===========================");
    }


    public static void exibirSubmenu(int setar, Scanner scanner) {
        switch (setar) {
            case 1:
                System.out.println("===========================");
                System.out.println("1. Cadastrar Usuario");
                System.out.println("2. Promover Funcionario a Gerente");
                System.out.println("0. Voltar ao Menu Principal");
                System.out.println("===========================");
                break;
            case 2:
                System.out.println("===========================");
                System.out.println("1. Buscar usuário por ID");
                System.out.println("0. Voltar ao Menu Principal");
                System.out.println("===========================");
                break;
            case 3:
                System.out.println("===========================");
                System.out.println("1. Exibir Todos os Funcionários");
                System.out.println("2. Exibir Todos os Gerentes");
                System.out.println("3. Exibir Todos os Vendedores");
                System.out.println("0. Voltar ao Menu Principal");
                System.out.println("===========================");
                break;
            default:
                System.out.println("Opção inválida! Por favor, escolha uma opção válida.");
        }

        if(setar==0){
            System.out.println("Encerrando o sistema...");
        }
        else if(setar==1){
            Interface.exibirSubmenuCadastrar(setar, scanner);
           
        }else if(setar==2){
            Interface.exibirSubmenuBuscar(setar, scanner);
           
        }
    }



     public static void exibirSubmenuCadastrar(int seta, Scanner scanner){
       
        int id=Funcoes_basicas.login(scanner);
        Funcoes_basicas.submenu_cadastrar(id, seta,scanner);

    }
        
       



    public static void exibirSubmenuBuscar(int seta, Scanner scanner){

        System.out.println("===========================");
        System.out.println("Escolha uma opção:");
        seta=scanner.nextInt();
         int id=Funcoes_basicas.login(scanner);
         Funcoes_basicas.submenu_buscar(id, seta, scanner);
        
        if(seta==0){
            System.out.println("voltando ao menu principal...");
    }

   
     

}
}

     
    


    
   

// A ideia é diminuir os códigos na MAIN, e deixar a MAIN apenas para chamar as funções, e a Interface para exibir os menus e receber as entradas do usuário, e as Funcoes_basicas para realizar as operações de cadastro, busca, etc.
