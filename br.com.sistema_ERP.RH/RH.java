import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;




public class RH  {
    
       private static HashMap<Integer, Usuario> banco_usuarios = new HashMap<>();
    

    protected static HashMap<Integer, Usuario> buscar_usuario ( int id) {
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
    

    public static void registrar_em_arquivo_csv() {
             
            try {

        PrintWriter writer = new PrintWriter("Usuarios.csv");

        writer.println("ID;Nome;Email;Senha;Ativo;Cargo;Departamento");

        for (Map.Entry<Integer, Usuario> entry : banco_usuarios.entrySet()) {

            Integer id = entry.getKey();
            Usuario usuario = entry.getValue();

            writer.println(
                id + ";" +
                usuario.get_nome() + ";" +
                usuario.get_email() + ";" +
                usuario.get_senha() + ";" +
                usuario.get_ativo() + ";" +
                usuario.getClass().getSimpleName() + ";" +
                (usuario instanceof Funcionario ? ((Funcionario) usuario).get_departamento() : "N/A")
            );
        }

        writer.close();

        System.out.println("Arquivo Usuarios.csv criado com sucesso!");

    } catch (Exception e) {
        System.out.println("Erro ao criar arquivo: " + e.getMessage());
    }
        }


    protected static void criar_usuario_padrao(){
        Gerente usuario_padrao = new Gerente(0, "0","0", 0, "0");
        banco_usuarios.put(0, usuario_padrao);

    
    }

     protected static HashMap<Integer, Usuario> cadastrarUsuario(Scanner scanner) {
        System.out.println("Cadastro de Usuário:");
        // Lógica para cadastrar usuário 
        System.out.println("Digite o nome do usuário:");
        scanner.nextLine(); // Limpar o buffer do scanner
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

    // atualizar banco de usuarios depois
     protected static Funcionario cadastrarFuncionario(Usuario usuario, Scanner scanner){ 

        System.out.println("Cadastro de Funcionário:");
        // Lógica para cadastrar funcionário
         
        System.out.println("Digite o departamento do funcionário:");
        System.out.println("1. Vendas");
        System.out.println("2. Estoque");
        System.out.println("3. RH");
        System.out.println("4. Financeiro");
            int departamento_opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner
            String departamento = "";
            switch (departamento_opcao) {
                case 1:
                    departamento = "Vendas";
                    break;
                case 2:
                    departamento = "Estoque";
                    break;
                case 3:
                    departamento = "RH";
                    break;
                case 4:
                    departamento = "Financeiro";
                    break;
                default:
                    System.out.println("Opção inválida. Definindo departamento como 'Geral'.");
                    departamento = "Geral";
            }

            System.out.println("salario do funcionário:");
            double salario = scanner.nextDouble();
            scanner.nextLine(); // Limpar o buffer do scanner
    

      
        Funcionario novoFuncionario = new Funcionario(usuario.get_id(), usuario.get_nome(), usuario.get_email(), usuario.get_senha(), departamento, salario);
    
        
        System.out.println("Funcionário cadastrado com sucesso!");
        System.out.println("ID do funcionário:" + novoFuncionario.id);
        
        return novoFuncionario;
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

     protected static int login( Scanner scanner) {

        System.out.println("===========================");
        System.out.println("Faça login para acessar as opções:");
        System.out.println("Digite seu id:");
        
        int id = scanner.nextInt();
        System.out.println("Digite sua senha:");
        int senha = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner

        if(id < banco_usuarios.size() && id == banco_usuarios.get(id).get_id() && senha == banco_usuarios.get(id).get_senha() && banco_usuarios.get(id).get_ativo()) {
            System.out.println("Login bem-sucedido! Bem-vindo, " + banco_usuarios.get(id).get_nome() + "!");
        } else {
            System.out.println("Email ou senha incorretos ou usuário inativo. Acesso negado.");
            System.out.println("===========================");
        }
        System.out.println("===========================");
        return id;
        }

    protected static void submenu_cadastrar(int id, int seta, Scanner scanner){
            
       if(id >=0 && banco_usuarios.get(id) instanceof Gerente){

             if(seta == 1){
            banco_usuarios = RH.cadastrarUsuario(scanner);
            int ultimo_id= banco_usuarios.size()-1;
            Usuario usuario_cadastrado = banco_usuarios.get(ultimo_id);
            System.out.println("Usuário cadastrado com sucesso! ID: " + usuario_cadastrado.get_id());
            scanner.nextLine(); // Limpar o buffer do scanner


            System.out.println("Deseja cadastrar um funcionário para este usuário? (s/n)");
            String resposta = scanner.nextLine();
            if(resposta.equalsIgnoreCase("S")){
                Funcionario novoFuncionario=RH.cadastrarFuncionario(usuario_cadastrado, scanner);
                banco_usuarios.put(usuario_cadastrado.get_id(), novoFuncionario);
                System.out.println("Funcionário cadastrado com sucesso! ID: " + novoFuncionario.get_id());

            }else if(resposta.equalsIgnoreCase("N")){
                System.out.println("Deseja cadastrar um gerente para este usuário? (s/n)");
                String resposta_gerente = scanner.nextLine();
                
                     if(resposta_gerente.equalsIgnoreCase("S")){
                    Gerente novoGerente = RH.cadastrarGerente(usuario_cadastrado, scanner);

                    banco_usuarios.put(usuario_cadastrado.get_id(), novoGerente);
                    System.out.println("Gerente cadastrado com sucesso! ID: " + novoGerente.get_id());
                }
                else{
                System.out.println("Usuário cadastrado sem vínculo empregatício.");
                } 
          
             }
                
            }else if(seta==2){
            System.out.println("Digite o ID do usuário para promover:");
             id = scanner.nextInt();
            System.out.println("===========================");
            Gerente novo_gerente = RH.promover_Funcionario(id,banco_usuarios.get(id));
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
        }

    protected static void submenu_buscar(int id, int seta, Scanner scanner){
           
        if(id >=0 && banco_usuarios.get(id) instanceof Gerente){
         if(seta == 1){
            System.out.println("Digite o ID do usuário para buscar:");
             id = scanner.nextInt();
            RH.buscar_usuario(id);
        }
        else if(seta==0){
            System.out.println("voltando ao menu principal...");
        }
        else{

            System.out.println("Opção inválida. Tente novamente.");
           



        }
    } 
        
        System.out.println("===========================");
    }

    protected static int departamento (int id){
        if(banco_usuarios.get(id).getClass().getSimpleName().equals("Gerente")){
            return 1;

        } else if(banco_usuarios.get(id).get_departamento().equals("Vendas")){
          return 2;
        }  else if(banco_usuarios.get(id).get_departamento().equals("Estoque")){
            return 3;
        }
        else if(banco_usuarios.get(id).get_departamento().equals("RH")){
            return 4;
        }
        else if(banco_usuarios.get(id).get_departamento().equals("Financeiro")){
            return 5;
        }
        else {
           return 0;
        }
    }

    protected static void registrarPonto(int id){
        if(banco_usuarios.get(id) instanceof Funcionario){
            Funcionario funcionario = (Funcionario) banco_usuarios.get(id);
            funcionario.registrarPonto();
        } else {
            System.out.println("Apenas funcionários do RH podem registrar ponto.");
        }
    }

    protected static void FolhaPagamento(int id){
        if(banco_usuarios.get(id) instanceof Funcionario){
            Funcionario funcionario = (Funcionario) banco_usuarios.get(id);
            System.out.println("Calculando folha de pagamento para " + funcionario.get_nome() + "...");
            System.out.println("Salário: " + funcionario.get_salario());

        } else {
            System.out.println("Apenas funcionários do RH podem calcular folha de pagamento.");
        }
    }
     protected static void FolhaPagamento_total(){
        double Somatorio_rh = 0;
        double Somatorio_vendas = 0;
        double Somatorio_estoque = 0;
        double Somatorio_financeiro = 0;
        double Somatorio_gerentes = 0;

        for (Map.Entry<Integer, Usuario> entry : banco_usuarios.entrySet()) {
            Integer id = entry.getKey();
            Usuario usuario = entry.getValue();

            if(usuario instanceof Funcionario){
                Funcionario funcionario = (Funcionario) usuario;
                switch (funcionario.get_departamento()) {
                    case "RH":
                        Somatorio_rh += funcionario.get_salario();
                        break;
                    case "Vendas":
                        Somatorio_vendas += funcionario.get_salario();
                        break;
                    case "Estoque":
                        Somatorio_estoque += funcionario.get_salario();
                        break;
                    case "Financeiro":
                        Somatorio_financeiro += funcionario.get_salario();
                        break;
                }
            } else if(usuario instanceof Gerente){
                Gerente gerente = (Gerente) usuario;
                Somatorio_gerentes += gerente.get_salario();
            }
        }
    }
}

