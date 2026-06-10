import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Cliente {

    private static HashMap<Integer, Pessoa> banco_clientes = new HashMap<>();
    static {
        carregarDeArquivoCSV();
    }

    public static void dados_teste() {
        Pessoa cliente1 = new Pessoa("123.456.789-00", "João Silva", "joao.silva@example.com", "11 99999-9999",
                "Rua Exemplo, 123, São Paulo/SP");
        banco_clientes.put(1, cliente1);

    }

    public static void cadastrarCliente(Scanner scanner) {
        System.out.println("Registrar Cliente");
        System.out.println("Digite o nome do cliente:");
        scanner.nextLine(); // Limpar buffer do scanner
        String nome = scanner.nextLine();
        System.out.println("Digite o email do cliente:");
        String email = scanner.nextLine();
        System.out.println("Digite o CPF do cliente:");
        String cpf = scanner.nextLine();
        System.out.println("Digite o telefone do cliente:");
        String telefone = scanner.nextLine();
        System.out.println("Digite o endereço do cliente:");
        String endereco = scanner.nextLine();

        Pessoa cliente = new Pessoa(cpf, nome, email, telefone, endereco);

        int codigo = banco_clientes.size() + 1;
        banco_clientes.put(codigo, cliente);
        System.out.println("Cliente registrado: " + banco_clientes.get(codigo).getNome());

    }

    public static void exibirClientes() {
        System.out.println("Clientes Cadastrados:");
        for (Integer codigo : banco_clientes.keySet()) {
            System.out.println("codigo: " + codigo + ", Nome: " + banco_clientes.get(codigo).getNome());
        }
    }

    public static void removerCliente(Scanner scanner) {
        System.out.println("Remover Cliente");
        System.out.println("Digite o código do cliente:");
        int codigoCliente = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner
        if (banco_clientes.containsKey(codigoCliente)) {
            banco_clientes.remove(codigoCliente);
            System.out.println("Cliente removido.");
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    public static void registrarEmArquivoCSV() {
        try (PrintWriter writer = new PrintWriter("clientes.csv")) {
            StringBuilder sb = new StringBuilder();
            sb.append("codigo,nome,email,cpf,telefone,endereco\n");
            for (Integer codigo : banco_clientes.keySet()) {
                Pessoa cliente = banco_clientes.get(codigo);
                sb.append(codigo).append(",")
                        .append(cliente.getNome()).append(",")
                        .append(cliente.getEmail()).append(",")
                        .append(cliente.getCpf()).append(",")
                        .append(cliente.getTelefone()).append(",")
                        .append(cliente.getEndereco()).append("\n");
            }
            writer.write(sb.toString());
            System.out.println("Clientes registrados em clientes.csv");
        } catch (Exception erro) {
            System.out.println("Erro ao registrar clientes em arquivo CSV: " + erro.getMessage());
        }
    }

    public static void carregarDeArquivoCSV() {
        try (BufferedReader reader = new BufferedReader(new FileReader("clientes.csv"))) {
            banco_clientes.clear();

            String linha = reader.readLine();

            while ((linha = reader.readLine()) != null) {
                if (linha.trim().isEmpty()) {
                    continue;
                }

                String[] dados = linha.split(",", 6);

                if (dados.length == 6) {
                    int codigo = Integer.parseInt(dados[0].trim());
                    String nome = dados[1].trim();
                    String email = dados[2].trim();
                    String cpf = dados[3].trim();
                    String telefone = dados[4].trim();
                    String endereco = dados[5].trim();

                    Pessoa cliente = new Pessoa(cpf, nome, email, telefone, endereco);
                    cliente.setNome(nome);
                    cliente.setEmail(email);
                    cliente.setCpf(cpf);
                    cliente.setTelefone(telefone);
                    cliente.setEndereco(endereco);
                    
                    banco_clientes.put(codigo, cliente);
                }
            }

            System.out.println("Clientes carregados de clientes.csv com sucesso!");

        } catch (Exception erro) {
            System.out.println("Erro ao carregar clientes do arquivo CSV: " + erro.getMessage());
        }
    }

    public static void listarCompras(Scanner scanner){
        System.out.println("Digite o CPF do cliente que você gostaria de listar as compras: ");
        scanner.nextLine(); // Limpar o buffer do scanner
        String CPF = scanner.nextLine();
        String formatoCPF = "";
        if (CPF.matches("\\d+")) {
            formatoCPF = CPF.substring(0, 3) + "." + CPF.substring(3, 6) + "." + CPF.substring(6, 9) + "-" + CPF.substring(9,11);
        }
        else{
            formatoCPF = CPF;
        }
        ArrayList<String> compras = new ArrayList<>();
        
        try (Scanner scanner2 = new Scanner(new File("vendas.csv"))) {
            scanner2.nextLine(); // Pular cabeçalho
            while (scanner2.hasNextLine()) {
                String linha = scanner2.nextLine();
                if (linha.trim().isEmpty()) {
                    continue;
                }
                String[] campos = linha.split(";");
                if (campos.length >= 5) {
                    String cpfCliente = campos[4].trim();
                    if (cpfCliente.equals(formatoCPF)) {
                        String nomeProduto = campos[3].trim();
                        String quantidadeVendida = campos[1].trim();
                        String compra = "Nome: " + nomeProduto + ", Quantidade: " + quantidadeVendida;
                        compras.add(compra);
                    }
                }
            }
        } catch (Exception erro) {
            System.out.println("Erro ao ler arquivo vendas.csv: " + erro.getMessage());
        }
        
        if (compras.isEmpty()) {
            System.out.println("Nenhuma compra encontrada para o CPF: " + formatoCPF);
        } else {
            System.out.println("Compras do cliente CPF " + formatoCPF + ":");
            for (String compra : compras) {
                System.out.println(compra);
            }
        }
    }
    public static void listarTodasAsCompras(){
        HashMap<String, ArrayList<String>> comprasPorCPF = new HashMap<>();
        
        try (Scanner scanner2 = new Scanner(new File("vendas.csv"))) {
            scanner2.nextLine(); // Pular cabeçalho
            while (scanner2.hasNextLine()) {
                String linha = scanner2.nextLine();
                if (linha.trim().isEmpty()) {
                    continue;
                }
                String[] campos = linha.split(";");
                if (campos.length >= 5) {
                    String cpfCliente = campos[4].trim();
                    String nomeProduto = campos[3].trim();
                    String quantidadeVendida = campos[1].trim();
                    String compra = "Nome: " + nomeProduto + ", Quantidade: " + quantidadeVendida;
                    
                    if (!comprasPorCPF.containsKey(cpfCliente)) {
                        comprasPorCPF.put(cpfCliente, new ArrayList<>());
                    }
                    comprasPorCPF.get(cpfCliente).add(compra);
                }
            }
        } catch (Exception erro) {
            System.out.println("Erro ao ler arquivo vendas.csv: " + erro.getMessage());
        }
        
        if (comprasPorCPF.isEmpty()) {
            System.out.println("Nenhuma compra encontrada.");
        } else {
            System.out.println("Todas as compras registradas:");
            for (String cpf : comprasPorCPF.keySet()) {
                System.out.println("CPF: " + cpf);
                for (String compra : comprasPorCPF.get(cpf)) {
                    System.out.println("  - " + compra);
                }
            }
        }
    }
}
