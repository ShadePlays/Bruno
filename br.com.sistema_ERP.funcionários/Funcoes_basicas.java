import java.util.HashMap;
import java.util.Scanner;


public class Funcoes_basicas {
    
    

     public static HashMap<Integer, Usuario> buscar_usuario ( int id, HashMap<Integer, Usuario> banco_usuarios) {
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

     public static HashMap<Integer, Usuario> cadastrarUsuario(Scanner scanner, HashMap<Integer, Usuario> banco_usuarios) {
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

     public static Funcionario cadastrarFuncionario(Usuario usuario, Scanner scanner){ {
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

    public static Gerente cadastrarGerente(Usuario usuario, Scanner scanner) {
        System.out.println("Cadastro de Gerente:");
       
         
        System.out.println("Digite o departamento do gerente:");
        String departamento = scanner.nextLine();


      
        Gerente novoGerente = new Gerente(usuario.get_id(), usuario.get_nome(), usuario.get_email(), usuario.get_senha(), departamento);
        
        System.out.println("Gerente cadastrado com sucesso!");
        System.out.println("ID do gerente:" + novoGerente.id);
        
        return novoGerente;
    }
}
