

public class Funcionario extends Usuario {
    private  String departamento;
   private String cargo= "Funcionário";
   private double salario;



    Funcionario(int id, String nome, String email, int senha, String departamento, double salario) {
        super(id, nome, email, senha);
        this.departamento = departamento;
        this.salario = salario;
    }

    public String get_cargo(){
        return this.cargo;
    }
    public double get_salario(){
        return this.salario;
    }

    public void set_salario(double salario){
        this.salario = salario;
    }
    public void set_cargo(String cargo){
        this.cargo = cargo;
    }
    public void set_departamento(String departamento){
        this.departamento = departamento;
    }

   @Override
    protected String get_departamento() {
        return this.departamento;
    }
    

    /**
     * @param usuario
     * @param scanner
     */
    
    public void registrarPonto() {
        System.out.println("Ponto registrado para " + this.nome);
    }
}