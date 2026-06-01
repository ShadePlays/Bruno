import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Cliente  {
    
private static HashMap<Integer, Pessoa> banco_clientes = new HashMap<>();

    public static void cadastrarCliente(Scanner scanner) {
        System.out.println("Registrar Cliente");
        System.out.println("Digite o nome do cliente:");
        String nome = scanner.nextLine();
        System.out.println("Digite o email do cliente:");
        String email = scanner.nextLine();
        System.out.println("Digite o CPF do cliente:");
        float cpf = scanner.nextFloat();
        scanner.nextLine(); // Limpar o buffer do scanner
        System.out.println("Digite o telefone do cliente:");
        String telefone = scanner.nextLine();
        System.out.println("Digite o endereço do cliente:");
        String endereco = scanner.nextLine();

        Pessoa cliente = new Pessoa();
        cliente.setNome(nome);
        cliente.setEmail(email);
        cliente.setCpf(cpf);
        cliente.setTelefone(telefone);
        cliente.setEndereco(endereco);
        int codigo = banco_clientes.size() + 1;
        banco_clientes.put(codigo, cliente);
        System.out.println("Cliente registrado: " + banco_clientes.get(codigo));



    }
}
