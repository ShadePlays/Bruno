import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

public class Cliente {

    private static HashMap<Integer, Pessoa> banco_clientes = new HashMap<>();

    public static void dados_teste() {
        Pessoa cliente1 = new Pessoa("123.456.789-00", "João Silva", "joao.silva@example.com", "11 99999-9999",
                "Rua Exemplo, 123, São Paulo/SP");
        banco_clientes.put(1, cliente1);

    }

    public static void cadastrarCliente(Scanner scanner) {
        System.out.println("Registrar Cliente");
        System.out.println("Digite o nome do cliente:");
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
        System.out.println("Cliente registrado: " + banco_clientes.get(codigo));

    }

    public static void exibirClientes() {
        System.out.println("Clientes Cadastrados:");
        for (Integer codigo : banco_clientes.keySet()) {
            System.out.println("codigo: " + codigo + ", Nome: " + banco_clientes.get(codigo));
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
}
