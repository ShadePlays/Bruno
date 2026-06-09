import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;




public class RH  {
    
       private static HashMap<Integer, Usuario> banco_usuarios = new HashMap<>();
    

    static {
        LerDoArquivoCSV();
    }
    

    protected static HashMap<Integer, Usuario> BuscarUsuario ( int id) {
        if(banco_usuarios.containsKey(id)){
            
            System.out.println("Usuário encontrado: " + banco_usuarios.get(id).getNome());
            System.out.println("Email: " + banco_usuarios.get(id).getEmail());
            System.out.println("Ativo: " + banco_usuarios.get(id).getAtivo());
            System.out.println("Cargo: " + banco_usuarios.get(id).getClass().getSimpleName());
          
           if(banco_usuarios.get(id) instanceof Funcionario){
                Funcionario funcionario =  (Funcionario) banco_usuarios.get(id);
                System.out.println("Departamento: " + funcionario.getDepartamento());
            }
        } else {
            System.out.println("Usuário não encontrado.");
        }

        return banco_usuarios;
    }
    

    public static void registrarEmArquivoCSV() {
             
            try {

        PrintWriter writer = new PrintWriter("Usuarios.csv");

        writer.println("ID;Nome;Email;Senha;Ativo;Cargo;Departamento");

        for (Map.Entry<Integer, Usuario> entry : banco_usuarios.entrySet()) {

            Integer id = entry.getKey();
            Usuario usuario = entry.getValue();

            String departamento = usuario.getDepartamento();
            if (departamento == null || departamento.isEmpty()) {
                departamento = "N/A";
            }

            writer.println(
                id + ";" +
                usuario.getNome() + ";" +
                usuario.getEmail() + ";" +
                usuario.getSenha() + ";" +
                usuario.getAtivo() + ";" +
                usuario.getClass().getSimpleName() + ";" +
                departamento
            );
        }
        

        writer.close();

        System.out.println("Arquivo Usuarios.csv criado com sucesso!");

    } catch (Exception e) {
        System.out.println("Erro ao criar arquivo: " + e.getMessage());
    }

        try {
        PrintWriter writer = new PrintWriter("FolhaPagamento.csv");
        writer.println("ID;Nome;Cargo;Departamento;Salário");
        for (Map.Entry<Integer, Usuario> entry : banco_usuarios.entrySet()) {
            Integer id = entry.getKey();
            Usuario usuario = entry.getValue();

            if(usuario instanceof Funcionario){
                Funcionario funcionario = (Funcionario) usuario;
                String departamento = funcionario.getDepartamento();
                if (departamento == null || departamento.isEmpty()) {
                    departamento = "N/A";
                }
                writer.println(
                    id + ";" +
                    funcionario.getNome() + ";" +
                    "Funcionario" + ";" +
                    departamento + ";" +
                    funcionario.getSalario()
                );
            } else if(usuario instanceof Gerente){
                Gerente gerente = (Gerente) usuario;
                String departamento = gerente.getDepartamento();
                if (departamento == null || departamento.isEmpty()) {
                    departamento = "N/A";
                }
                writer.println(
                    id + ";" +
                    gerente.getNome() + ";" +
                    "Gerente" + ";" +
                    departamento + ";" +
                    gerente.getSalario()
                );
            }
        }
        writer.close();
        }catch(Exception e){
            System.out.println("Erro ao criar arquivo: " + e.getMessage());
        }
        
    }


    protected static void criarUsuarioPadrao(){
        Gerente usuario_padrao = new Gerente(0, "0","0", 0, "0", 0.0);
        banco_usuarios.put(0, usuario_padrao);

       Gerente gerente1 = new Gerente(1, "João Silva", "joao@example.com", 123, "Vendas", 3000.0);
        banco_usuarios.put(1, gerente1);

        Funcionario funcionario1 = new Funcionario(2, "Maria Souza", "maria@example.com", 456, "RH", 2500.0);
        banco_usuarios.put(2, funcionario1);

        Funcionario funcionario2 = new Funcionario(3, "Carlos Oliveira", "carlos@example.com", 789, "Estoque", 2000.0);
        banco_usuarios.put(3, funcionario2);

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
        int senha = TesteEntrada.nextInt(scanner);
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
            int departamento_opcao = TesteEntrada.nextInt(scanner);
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
            double salario = TesteEntrada.nextDouble(scanner);
            scanner.nextLine(); // Limpar o buffer do scanner
            

      
        Funcionario novoFuncionario = new Funcionario(usuario.getID(), usuario.getNome(), usuario.getEmail(), usuario.getSenha(), departamento, salario);
        novoFuncionario.setDepartamento(departamento);

        System.out.println("Funcionário cadastrado com sucesso!");
        System.out.println("Departamento: " + departamento);
        System.out.println("ID do funcionário: " + novoFuncionario.id);
        
        return novoFuncionario;
    }

    protected static Gerente cadastrarGerente(Usuario usuario, Scanner scanner) {
        System.out.println("Cadastro de Gerente:");
       
       
        System.out.println("Digite o departamento do gerente:");
        System.out.println("1. Vendas");
        System.out.println("2. Estoque");
        System.out.println("3. RH");
        System.out.println("4. Financeiro");
            int departamento_opcao = TesteEntrada.nextInt(scanner);
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

            System.out.println("salario do gerente:");
            double salario = TesteEntrada.nextDouble(scanner);
            scanner.nextLine(); // Limpar o buffer do scanner

      
        Gerente novoGerente = new Gerente(usuario.getID(), usuario.getNome(), usuario.getEmail(), usuario.getSenha(), departamento, salario);
        
        System.out.println("Gerente cadastrado com sucesso!");
        System.out.println("ID do gerente:" + novoGerente.id);
        
        return novoGerente;
    }

    protected static Gerente promoverFuncionario (int id, Usuario usuario) {
        if(usuario instanceof Funcionario){
            Funcionario funcionario = (Funcionario) usuario;
            Gerente gerente_promovido = new Gerente(funcionario.getID(), funcionario.getNome(), funcionario.getEmail(), funcionario.getSenha(), funcionario.getDepartamento()   , funcionario.getSalario());
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
        
        int id = TesteEntrada.nextInt(scanner);
        System.out.println("Digite sua senha:");
        int senha = TesteEntrada.nextInt(scanner);
        scanner.nextLine(); // Limpar o buffer do scanner

        if(id < banco_usuarios.size() && id == banco_usuarios.get(id).getID() && senha == banco_usuarios.get(id).getSenha() && banco_usuarios.get(id).getAtivo()) {
            System.out.println("Login bem-sucedido! Bem-vindo, " + banco_usuarios.get(id).getNome() + "!");
        } else {
            System.out.println("===========================");
            System.out.println("Email ou senha incorretos ou usuário inativo. Acesso negado.");
                return -1;
        }
        System.out.println("===========================");
        return id;
        }

    protected static void submenuCadastrar(int id, int seta, Scanner scanner){
            
       if(id >=0 && banco_usuarios.get(id) instanceof Gerente){

            if(seta == 1){
                banco_usuarios = RH.cadastrarUsuario(scanner);
                int ultimo_id= banco_usuarios.size()-1;
                Usuario usuario_cadastrado = banco_usuarios.get(ultimo_id);
                System.out.println("Usuário cadastrado com sucesso! ID: " + usuario_cadastrado.getID());
                scanner.nextLine(); // Limpar o buffer do scanner


                System.out.println("Deseja cadastrar um funcionário para este usuário? (s/n)");
                String resposta = scanner.nextLine();
                    if(resposta.equalsIgnoreCase("S")){
                        Funcionario novoFuncionario = RH.cadastrarFuncionario(usuario_cadastrado, scanner);
                        banco_usuarios.put(usuario_cadastrado.getID(), novoFuncionario);
                        System.out.println("Funcionário cadastrado com sucesso! ID: " + novoFuncionario.getID());

                    }else if(resposta.equalsIgnoreCase("N")){
                        System.out.println("Deseja cadastrar um gerente para este usuário? (s/n)");
                        String resposta_gerente = scanner.nextLine();
                
                        if(resposta_gerente.equalsIgnoreCase("S")){
                            Gerente novoGerente = RH.cadastrarGerente(usuario_cadastrado, scanner);

                            banco_usuarios.put(usuario_cadastrado.getID(), novoGerente);
                            System.out.println("Gerente cadastrado com sucesso! ID: " + novoGerente.getID());
                        }
                        else{
                            System.out.println("Usuário cadastrado sem vínculo empregatício.");
                        } 
          
                    }
                
            }else if(seta==2){
            System.out.println("Digite o ID do usuário para promover:");
             id = TesteEntrada.nextInt(scanner);
            System.out.println("===========================");
            Gerente novo_gerente = RH.promoverFuncionario(id,banco_usuarios.get(id));
            if(novo_gerente != null){
            banco_usuarios.put(id, novo_gerente);
            System.out.println("Usuário promovido a gerente com sucesso! ID: " + novo_gerente.getID());
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

    protected static void submenuBuscar(int id, int seta, Scanner scanner){
           
        if(id >=0 && banco_usuarios.get(id) instanceof Gerente){
         if(seta == 1){
            System.out.println("Digite o ID do usuário para buscar:");
             id = TesteEntrada.nextInt(scanner);
            RH.BuscarUsuario(id);
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
        } else if(banco_usuarios.get(id).getDepartamento().equals("Vendas")){
            System.out.println("Acesso ao departamento de vendas concedido.");
            return 2;
        }  else if(banco_usuarios.get(id).getDepartamento().equals("Estoque")){
            System.out.println("Acesso ao departamento de estoque concedido.");
            return 3;
        }
        else if(banco_usuarios.get(id).getDepartamento().equals("RH")){
            System.out.println("Acesso ao departamento de RH concedido.");
            return 4;
        }
        else if(banco_usuarios.get(id).getDepartamento().equals("Financeiro")){
            System.out.println("Acesso ao departamento de financeiro concedido.");
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
            System.out.println("Calculando folha de pagamento para " + funcionario.getNome() + "...");
            System.out.println("Salário: " + funcionario.getSalario());

        } else {
            System.out.println("Apenas funcionários do RH podem calcular folha de pagamento.");
        }
    }
     protected static void FolhaPagamentoTotal(){
        double Somatorio_rh = 0;
        double Somatorio_vendas = 0;
        double Somatorio_estoque = 0;
        double Somatorio_financeiro = 0;
        double Somatorio_gerentes = 0;

        for (Map.Entry<Integer, Usuario> entry : banco_usuarios.entrySet()) {
            Usuario usuario = entry.getValue();

            if(usuario instanceof Funcionario){
                Funcionario funcionario = (Funcionario) usuario;
                switch (funcionario.getDepartamento()) {
                    case "RH":
                        Somatorio_rh += funcionario.getSalario();
                        break;
                    case "Vendas":
                        Somatorio_vendas += funcionario.getSalario();
                        break;
                    case "Estoque":
                        Somatorio_estoque += funcionario.getSalario();
                        break;
                    case "Financeiro":
                        Somatorio_financeiro += funcionario.getSalario();
                        break;
                }
            } else if(usuario instanceof Gerente){
                Gerente gerente = (Gerente) usuario;
                Somatorio_gerentes += gerente.getSalario();
            }
        }
    }

    private static void LerDoArquivoCSV() {
        try (Scanner scanner = new Scanner(new java.io.File("Usuarios.csv"))) {
            String linha = scanner.nextLine(); 
            while (scanner.hasNextLine()) {
                linha = scanner.nextLine();
                if (linha.trim().isEmpty()) {
                    continue; 
                }
                
                String[] dados = linha.split(";");
                int id = Integer.parseInt(dados[0]);
                String nome = dados[1];
                String email = dados[2];
                int senha = Integer.parseInt(dados[3]);
                boolean ativo = Boolean.parseBoolean(dados[4]);
                String cargo = dados[5];
                String departamento = dados[6];

                Usuario usuario;
                if ("Funcionario".equals(cargo)) {
                    usuario = new Funcionario(id, nome, email, senha, departamento, 0.0);
                } else if ("Gerente".equals(cargo)) {
                    usuario = new Gerente(id, nome, email, senha, departamento, 0.0);
                } else {
                    usuario = new Usuario(id, nome, email, senha);
                }

                usuario.setAtivo(ativo);
                banco_usuarios.put(id, usuario);
            }
        } catch (Exception e) {
            System.out.println("Arquivo Usuarios.csv não encontrado ou erro ao ler: " + e.getMessage());
        }
    }
    public static void exibirFuncionarios() {
        System.out.println("Funcionários Cadastrados:");
        for (Map.Entry<Integer, Usuario> entry : banco_usuarios.entrySet()) {
            Usuario usuario = entry.getValue();
            if (usuario instanceof Funcionario) {
                System.out.println("ID: " + usuario.getID() + ", Nome: " + usuario.getNome() + ", Departamento: " + usuario.getDepartamento());
            }
        }
    }
    public static void exibirGerentes() {
        System.out.println("Gerentes Cadastrados:");
        for (Map.Entry<Integer, Usuario> entry : banco_usuarios.entrySet()) {
            Usuario usuario = entry.getValue();
            if (usuario instanceof Gerente) {
                System.out.println("ID: " + usuario.getID() + ", Nome: " + usuario.getNome() + ", Departamento: " + usuario.getDepartamento());
            }
        }
     }
}

