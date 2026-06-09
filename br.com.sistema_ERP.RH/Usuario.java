
public class Usuario extends RH {

    private int id;
    private String nome;
    private String email;
    private int senha;
    private boolean ativo;
    private String departamento;
    private double salario;
    private int numeroFaltas;

    protected Usuario(int id, String nome, String email, int senha, int numeroFaltas) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.ativo = true;
        this.numeroFaltas = numeroFaltas;
    }

    // get e sets
    public int getID() {
        return this.id;
    }

    public int getNumeroFaltas() {
        return this.numeroFaltas;
    }

    public String getNome() {
        return this.nome;
    }

    public String getEmail() {
        return this.email;
    }

    public int getSenha() {
        return this.senha;
    }

    public boolean getAtivo() {
        return this.ativo;
    }

    public String getDepartamento() {
        return this.departamento;
    }

    public double getSalario() {
        return this.salario;
    }

    public void setID(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(int senha) {
        this.senha = senha;
    }

    public void setNumeroFaltas(int numeroFaltas) {
        this.numeroFaltas = numeroFaltas;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    protected void login(String email, int senha) {
        if (this.email.equals(email) && this.senha == senha) {
            System.out.println("Login bem-sucedido!");
        } else {
            System.out.println("Email ou senha incorretos.");
        }
    }

}
