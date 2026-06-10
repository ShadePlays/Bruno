import java.util.ArrayList;
import java.util.List;

public class Pessoa {
    private String cpf;
    private String nome;
    private String email;
    private String telefone;
    private String endereco;
     private List <Sale> compras;

    public Pessoa(String cpf2, String nome, String email, String telefone, String endereco) {
        this.cpf = cpf2;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;

        this.compras= new ArrayList<>();
    }
     public List<Sale> getCompras() {
        return compras;
    }

    public void adicionarCompra(Sale compra) {
        compras.add(compra);
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEndereco() {
        return endereco;
    }

}
