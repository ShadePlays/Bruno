

public class Funcionario extends Usuario {
    private  String departamento;
   private String cargo= "Funcionário";


    Funcionario(int id, String nome, String email, int senha, String departamento) {
        super(id, nome, email, senha);
        this.departamento = departamento;
    }

    public String get_cargo(){
        return this.cargo;
    }
    public String get_departamento(){
        return this.departamento;
    }
    

    /**
     * @param usuario
     * @param scanner
     */
    
    void registrarPonto() {
        System.out.println("Ponto registrado para " + this.nome);
    }
}