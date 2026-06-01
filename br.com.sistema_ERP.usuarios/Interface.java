
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
            } else if(cargo == 3){
                Interface.exibirmenu_rh();
                int seta = scanner.nextInt();
                if(seta >0){
                scanner.nextLine(); // Limpar o buffer do scanner
                Interface.ExibirSubmenu_rh(id,seta, scanner);
                }
            }else if(cargo == 4){
                Interface.exibirmenu_estoque();
                int seta = scanner.nextInt();
                if(seta >0){
                scanner.nextLine(); // Limpar o buffer do scanner
                Interface.ExibirSubmenu_estoque(id,seta, scanner);
                }   
            }else if(cargo == 5){
                Interface.exibirmenu_financeiro();
                int seta = scanner.nextInt();
                if(seta >0){
                scanner.nextLine(); // Limpar o buffer do scanner
                Interface.ExibirSubmenu_financeiro(id,seta, scanner);
                }
            }
            
            else {
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
        System.out.println("exibirMenu(4) - Gerenciar Vendas");
        System.out.println("exibirMenu(5) - Gerenciar RH");
        System.out.println("exibirMenu(6) - Gerenciar Estoque");
        System.out.println("exibirMenu(7) - Gerenciar financeiro");
        System.out.println("===========================");
    }

    public static void exibirmenu_vendas() {
        System.out.println("Bem-vindo ao Sistema ERP!");
        System.out.println("===========================");
        System.out.println("0. Sair");
        System.out.println("exibirMenu(1) - Registrar Venda");
        System.out.println("exibirMenu(2) - Exibir Vendas");
        System.out.println("exibirMenu(3) - Exibir Vendas por Data");
        System.out.println("exibirMenu(4) - Cadastrar Cliente");
        System.out.println("===========================");
    }

    public static void exibirmenu_rh() {
        System.out.println("Bem-vindo ao Sistema ERP!");
        System.out.println("===========================");
        System.out.println("0. Sair");
        System.out.println("exibirMenu(1) - Cadastrar Ponto");
        System.out.println("===========================");
    }
    public static void exibirmenu_estoque() {
        System.out.println("Bem-vindo ao Sistema ERP!");
        System.out.println("===========================");
        System.out.println("0. Sair");
        System.out.println("exibirMenu(1) - Gerenciar Estoque");
        System.out.println("===========================");
    }
    public static void exibirmenu_financeiro() {
        System.out.println("Bem-vindo ao Sistema ERP!");
        System.out.println("===========================");
        System.out.println("0. Sair");
        System.out.println("exibirMenu(1) - Gerenciar Financeiro");
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
                case 4:
                System.out.println("===========================");
                System.out.println("1. Gerenciar Vendas");
                System.out.println("0. Voltar ao Menu Principal");
                System.out.println("===========================");
                break;
                case 5:
                System.out.println("===========================");
                System.out.println("1. Gerenciar RH");
                System.out.println("0. Voltar ao Menu Principal");
                System.out.println("===========================");
                break;
                case 6:
                System.out.println("===========================");
                System.out.println("1. Gerenciar Estoque");
                System.out.println("0. Voltar ao Menu Principal");
                System.out.println("===========================");
                break;
                case 7:
                System.out.println("===========================");
                System.out.println("1. Gerenciar Financeiro");
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
           
        }else if(setar==4){
            setar= scanner.nextInt();
            Interface.ExibirSubmenu_vendas(id,setar, scanner);
        }else if(setar==5){
            setar= scanner.nextInt();
            Interface.ExibirSubmenu_rh(id,setar, scanner);
        }else if(setar==6){
            setar= scanner.nextInt();
            //Interface.ExibirSubmenu_estoque(id,setar, scanner);
        }else if(setar==7){
            setar= scanner.nextInt();
            Interface.ExibirSubmenu_financeiro(id,setar, scanner);
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
                System.out.println("0. Voltar ao Menu Principal");
                System.out.println("===========================");
                break;
                case 2:
                System.out.println("===========================");
                System.out.println("1. Exibir Vendas");
                System.out.println("2. Exibir Vendas por Data");
                System.out.println("0. Voltar ao Menu Principal");
                System.out.println("===========================");
                case 3:
                    System.out.println("===========================");
                    System.out.println("1. cadastrar Cliente");
                    System.out.println("0. Voltar ao Menu Principal");
                    System.out.println("===========================");
            default:
                System.out.println("Opção inválida! Por favor, escolha uma opção válida.");
        }

        if(seta==0){
            System.out.println("Encerrando o sistema...");
        }
        else if(seta==1){
             seta= scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner
            if(seta==1){
            Vendas.registrarVenda(scanner);
            }
        }else if(seta==2){
             seta= scanner.nextInt();
            if(seta==1){
            Vendas.exibirVendas();
            }else if(seta==2){
                System.out.println("Digite a data para filtrar as vendas (dd/mm/yyyy):");
                String data = scanner.nextLine();
                Vendas.exibirVendasPorData(data);
            }
        }else if(seta==3){
             seta= scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner
            if(seta==1){
                Cliente.cadastrarCliente(scanner);
            }
        }
    }
     
    public static void ExibirSubmenu_rh(int id, int seta, Scanner scanner){
        switch (seta) {
            case 1:
                System.out.println("===========================");
                System.out.println("1. Registrar Ponto");
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
            seta= scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner
            if(seta==1){
            System.out.println("Registrando ponto para qual funcionário? (Digite o ID do funcionário)");
            int funcionarioId = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner
            Funcoes_basicas.registrarPonto(funcionarioId);
            }
        }
    }
    public static void ExibirSubmenu_financeiro(int id, int seta, Scanner scanner){
        switch (seta) {
            case 1:
                System.out.println("===========================");
                System.out.println("1. cadastrar despesa");
                System.out.println("2. exibir despesas");
                System.out.println("0. Voltar ao Menu Principal");
                System.out.println("===========================");
                break;
            default:
                System.out.println("Opção inválida! Por favor, escolha uma opção válida.");
        }
        seta = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner
        if(seta==0){
            System.out.println("Encerrando o sistema...");
        }
        else if(seta==1){
          
            Financeiro.registrarDespesa(scanner);
            
        }else if(seta==2){
            Financeiro.exibirDespesas();
        }
    }
    public static void ExibirSubmenu_estoque(int id, int seta, Scanner scanner){
        switch (seta) {
            case 1:
                System.out.println("===========================");
                System.out.println("1. Gerenciar Estoque");
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
            //Funcoes_basicas.gerenciarEstoque();
        }
    }

}


     
    


    
   

// A ideia é diminuir os códigos na MAIN, e deixar a MAIN apenas para chamar as funções, e a Interface para exibir os menus e receber as entradas do usuário, e as Funcoes_basicas para realizar as operações de cadastro, busca, etc.
