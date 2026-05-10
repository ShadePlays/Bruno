import java.util.HashMap;
import java.util.Scanner;


public class Funcoes_basicas  {
    
    protected static HashMap<Integer, Usuario> buscar_usuario ( int id, HashMap<Integer, Usuario> banco_usuarios) {
        if(banco_usuarios.containsKey(id)){
            
            System.out.println("Usuário encontrado: " + banco_usuarios.get(id).get_nome());
            System.out.println("Email: " + banco_usuarios.get(id).get_email());
            System.out.println("Ativo: " + banco_usuarios.get(id).get_ativo());
            System.out.println("Cargo: " + banco_usuarios.get(id).getClass().getSimpleName());
          
           if(banco_usuarios.get(id) instanceof Funcionario){
                Funcionario funcionario =  (Funcionario) banco_usuarios.get(id);
                System.out.println("Departamento: " + funcionario.get_departamento());
            }
        } else {
            System.out.println("Usuário não encontrado.");
        }

        return banco_usuarios;
    }
    
    protected static void criar_usuario_padrao(HashMap<Integer, Usuario> banco_usuarios){
        Gerente usuario_padrao = new Gerente(0, "0","0", 0, "0");
        banco_usuarios.put(0, usuario_padrao);

    
    }

     protected static HashMap<Integer, Usuario> cadastrarUsuario(Scanner scanner, HashMap<Integer, Usuario> banco_usuarios) {
        System.out.println("Cadastro de Usuário:");
        // Lógica para cadastrar usuário 
        System.out.println("Digite o nome do usuário:");
        String nome= scanner.nextLine();
        System.out.println("Digite o email do usuário:");
        String email = scanner.nextLine();
        System.out.println("Digite a senha do usuário:");
        int senha = scanner.nextInt();
        int id= banco_usuarios.size();
      
        Usuario novoUsuario = new Usuario(id, nome, email, senha);
        banco_usuarios.put(novoUsuario.id, novoUsuario);
        System.out.println("Usuário cadastrado com sucesso!");
        System.out.println("ID do usuário:" + novoUsuario.id);
        
        return banco_usuarios;
    }

     protected static Funcionario cadastrarFuncionario(Usuario usuario, Scanner scanner){ {
        System.out.println("Cadastro de Funcionário:");
        // Lógica para cadastrar funcionário
         
        System.out.println("Digite o departamento do funcionário:");
        String departamento = scanner.nextLine();

      
        Funcionario novoFuncionario = new Funcionario(usuario.get_id(), usuario.get_nome(), usuario.get_email(), usuario.get_senha(), departamento);
        
        System.out.println("Funcionário cadastrado com sucesso!");
        System.out.println("ID do funcionário:" + novoFuncionario.id);
        
        return novoFuncionario;
    }

}

    protected static Gerente cadastrarGerente(Usuario usuario, Scanner scanner) {
        System.out.println("Cadastro de Gerente:");
       
       
        System.out.println("Digite o departamento do gerente:");
        String departamento = scanner.nextLine();


      
        Gerente novoGerente = new Gerente(usuario.get_id(), usuario.get_nome(), usuario.get_email(), usuario.get_senha(), departamento);
        
        System.out.println("Gerente cadastrado com sucesso!");
        System.out.println("ID do gerente:" + novoGerente.id);
        
        return novoGerente;
    }

    protected static Gerente promover_Funcionario (int id, Usuario usuario) {
        if(usuario instanceof Funcionario){
            Funcionario funcionario = (Funcionario) usuario;
            Gerente gerente_promovido = new Gerente(funcionario.get_id(), funcionario.get_nome(), funcionario.get_email(), funcionario.get_senha(), funcionario.get_departamento());
            System.out.println("Usuário promovido a gerente com sucesso! ID: " + gerente_promovido.id);
            return gerente_promovido;

        } else if(usuario instanceof Gerente){
            System.out.println("O usuário já é um gerente.");
        } else {
            System.out.println("O usuário não é um funcionário e não pode ser promovido a gerente.");
        }
        return null;
        }
}
