import java.util.HashMap;
import java.util.Scanner;
public class Interface {
    
    
    public static void exibirMenu() {
        System.out.println("Bem-vindo ao Sistema ERP!");
        System.out.println("===========================");
        System.out.println("0. Sair");
        System.out.println("exibirMenu(1) - Cadastrar");
        System.out.println("exibirMenu(2) - Buscar");
        System.out.println("exibirMenu(3) - Exibir Todos");
        System.out.println("===========================");
    }


    public static void exibirSubmenu(int setar, HashMap<Integer, Usuario> banco_usuarios, Scanner scanner) {
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
            Interface.exibirSubmenuCadastrar(setar, banco_usuarios, scanner);
           
        }else if(setar==2){
            Interface.exibirSubmenuBuscar(setar, banco_usuarios, scanner);
           
        }
    }



     public static void exibirSubmenuCadastrar(int seta,HashMap<Integer, Usuario> banco_usuarios, Scanner scanner){
       
       
            System.out.println("===========================");
            System.out.println("Escolha uma opção:");
            seta=scanner.nextInt();

             if(seta == 1){
            scanner.nextLine(); // Limpar o buffer do scanner
            banco_usuarios = Funcoes_basicas.cadastrarUsuario(scanner, banco_usuarios);
            int ultimo_id= banco_usuarios.size()-1;
            Usuario usuario_cadastrado = banco_usuarios.get(ultimo_id);
            System.out.println("Usuário cadastrado com sucesso! ID: " + usuario_cadastrado.get_id());
            scanner.nextLine(); // Limpar o buffer do scanner


            System.out.println("Deseja cadastrar um funcionário para este usuário? (s/n)");
            String resposta = scanner.nextLine();
            if(resposta.equalsIgnoreCase("S")){
                Funcionario novoFuncionario=Funcoes_basicas.cadastrarFuncionario(usuario_cadastrado, scanner);
                banco_usuarios.put(usuario_cadastrado.get_id(), novoFuncionario);
                System.out.println("Funcionário cadastrado com sucesso! ID: " + novoFuncionario.get_id());

            }else if(resposta.equalsIgnoreCase("N")){
                System.out.println("Deseja cadastrar um gerente para este usuário? (s/n)");
                String resposta_gerente = scanner.nextLine();
                if(resposta_gerente.equalsIgnoreCase("N")){
                     if(resposta_gerente.equalsIgnoreCase("S")){
                    System.out.println("Digite o departamento do gerente:");
                    Gerente novoGerente = Funcoes_basicas.cadastrarGerente(usuario_cadastrado, scanner);

                    banco_usuarios.put(usuario_cadastrado.get_id(), novoGerente);
                    System.out.println("Gerente cadastrado com sucesso! ID: " + novoGerente.get_id());
                }
                else{
                System.out.println("Usuário cadastrado sem vínculo empregatício.");
                } 
            }
             }
                
            }else if(seta==2){
            System.out.println("Digite o ID do usuário para promover:");
            int id = scanner.nextInt();
            System.out.println("===========================");
            Gerente novo_gerente = Funcoes_basicas.promover_Funcionario(id,banco_usuarios.get(id));
            if(novo_gerente != null){
            banco_usuarios.put(id, novo_gerente);
            System.out.println("Usuário promovido a gerente com sucesso! ID: " + novo_gerente.get_id());
            }
            System.out.println("===========================");
        } else if(seta==0){
            System.out.println("voltando ao menu principal...");
        }
        else{

            System.out.println("Opção inválida. Tente novamente.");
           



        }

        System.out.println("===========================");
        
    
    }
        
       



    public static void exibirSubmenuBuscar(int seta, HashMap<Integer, Usuario> banco_usuarios, Scanner scanner){
        System.out.println("===========================");
        System.out.println("Escolha uma opção:");
        seta=scanner.nextInt();
         if(seta == 1){
            System.out.println("Digite o ID do usuário para buscar:");
            int id = scanner.nextInt();
            Funcoes_basicas.buscar_usuario(id,banco_usuarios);
        }
        else if(seta==0){
            System.out.println("voltando ao menu principal...");
        }
        else{

            System.out.println("Opção inválida. Tente novamente.");
           



        }
        
        System.out.println("===========================");
    }

}

     
    


    
   

// A ideia é diminuir os códigos na MAIN, e deixar a MAIN apenas para chamar as funções, e a Interface para exibir os menus e receber as entradas do usuário, e as Funcoes_basicas para realizar as operações de cadastro, busca, etc.
