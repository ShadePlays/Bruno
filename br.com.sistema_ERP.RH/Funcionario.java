
public class Funcionario extends Usuario {
    private String cargo = "Funcionário";
    private double salario;

    Funcionario(int id, String nome, String email, int senha, String departamento, double salario) {
        super(id, nome, email, senha, 0);
        this.salario = salario;
        setDepartamento(departamento);
    }

    public String getCargo() {
        return this.cargo;
    }

    public double getSalario() {
        return this.salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void registrarPonto() {
        System.out.println("Ponto registrado para " + getNome());
    }
}