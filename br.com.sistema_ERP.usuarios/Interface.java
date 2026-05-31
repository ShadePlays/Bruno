
import java.util.Scanner;
public class Interface extends Funcoes_basicas {
    
    
    public static void tela_inicial(Scanner scanner){
       int id=Funcoes_basicas.login(scanner);
        if(id >-1){
            int cargo = Funcoes_basicas.departamento(id);
            if(cargo == 1){
                Interface.exibirMenu_gerencia();
                 int seta = scanner.nextInt();
                if(seta >0){
                scanner.nextLine(); // Limpar o buffer do scanner
                Interface.exibirSubmenu_gerencia(id,seta, scanner);
        }
            } else if(cargo == 2){
                Interface.exibirmenu_vendas();
                int seta = scanner.nextInt();
                if(seta >0){
                scanner.nextLine(); // Limpar o buffer do scanner
                Interface.ExibirSubmenu_vendas(id,seta, scanner);
        }
                
                
            } else {
                System.out.println("Cargo desconhecido. Acesso limitado.");
            }

        } else {
            System.out.println("Usuario não encontrado ou senha incorreta. Acesso negado.");
        }
    }
    public static void exibirMenu_gerencia() {
        System.out.println("Bem-vindo ao Sistema ERP!");
        System.out.println("===========================");
        System.out.println("0. Sair");
        System.out.println("exibirMenu(1) - Cadastrar");
        System.out.println("exibirMenu(2) - Buscar");
        System.out.println("exibirMenu(3) - Exibir Todos");
        System.out.println("===========================");
    }

    public static void exibirmenu_vendas() {
        System.out.println("Bem-vindo ao Sistema ERP!");
        System.out.println("===========================");
        System.out.println("0. Sair");
        System.out.println("exibirMenu(1) - Registrar Venda");
        System.out.println("exibirMenu(2) - Exibir Vendas");
        System.out.println("===========================");
    }

    public static void exibirSubmenu_gerencia(int id, int setar, Scanner scanner) {
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
            setar= scanner.nextInt();
            Interface.exibirSubmenuCadastrar(id,setar, scanner);
           
        }else if(setar==2){
            setar= scanner.nextInt();
            Interface.exibirSubmenuBuscar(id,setar, scanner);
           
        }
    }



     public static void exibirSubmenuCadastrar(int id, int seta, Scanner scanner){
       
        Funcoes_basicas.submenu_cadastrar(id, seta,scanner);

    }

    public static void exibirSubmenuBuscar(int id, int seta, Scanner scanner){

         Funcoes_basicas.submenu_buscar(id, seta, scanner);
        
        if(seta==0){
            System.out.println("voltando ao menu principal...");
    }

   
     

}
    

    public static void ExibirSubmenu_vendas(int id, int seta, Scanner scanner){
        switch (seta) {
            case 1:
                System.out.println("===========================");
                System.out.println("1. Registrar Venda");
                System.out.println("2. Exibir Vendas");
                System.out.println("0. Voltar ao Menu Principal");
                System.out.println("===========================");
                break;
            default:
                System.out.println("Opção inválida! Por favor, escolha uma opção válida.");
        }

        if(seta==0){
            System.out.println("Encerrando o sistema...");
        }
        else if(seta==1){
            Funcoes_basicas.registrarVenda();
        }else if(seta==2){
            Funcoes_basicas.exibirVendas();
        }
    }
     
}

     
    


    
   

// A ideia é diminuir os códigos na MAIN, e deixar a MAIN apenas para chamar as funções, e a Interface para exibir os menus e receber as entradas do usuário, e as Funcoes_basicas para realizar as operações de cadastro, busca, etc.
