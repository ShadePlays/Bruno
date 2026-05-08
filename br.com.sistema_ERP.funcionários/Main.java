import java.util.Scanner;
import java.util.HashMap;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        
        HashMap<Integer, Usuario> banco_usuarios = new HashMap<>();
        int seta = 1;
        Scanner scanner = new Scanner(System.in);
        
         while(seta !=0){
            
        System.out.println("Sistema ERP");
        System.out.println("===========================");
        System.out.println("0.Sair");
        System.out.println("1. Cadastrar Usuário");
        System.out.println("2. Buscar Usuário");
        System.out.println("3. Promover Funcionário");

        seta = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner
        
        if(seta == 1){
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
           



        }
        else if(seta == 2){
            System.out.println("Digite o ID do usuário para buscar:");
            int id = scanner.nextInt();
            Funcoes_basicas.buscar_usuario(id,banco_usuarios);
        }
        else if(seta==3){
            System.out.println("Digite o ID do usuário para promover:");
            int id = scanner.nextInt();
            Gerente novo_gerente = Funcoes_basicas.promover_Funcionario(id,banco_usuarios.get(id));
            if(novo_gerente != null){
            banco_usuarios.put(id, novo_gerente);
            System.out.println("Usuário promovido a gerente com sucesso! ID: " + novo_gerente.get_id());
            }
        }
        else if(seta==0){
            System.out.println("Saindo do sistema...");
        }
        else{

            System.out.println("Opção inválida. Tente novamente.");
        }



        System.out.println("===========================");

    }


        
           scanner.close();
           System.out.println("Sistema encerrado.");
    }
}

        
        

