
public class Usuario extends RH {
  
    protected int id;
    protected String nome;
    protected String email;
    protected int senha;
    protected boolean ativo;
    protected String departamento;
    protected double salario;
   

   protected Usuario(int id, String nome, String email, int senha) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.ativo = true;
    }
    // get e sets
   protected int get_id(){
            return this.id;
    }

    protected String get_nome(){
            return this.nome;
    }

   protected String get_email(){
            return this.email;
    }
   protected int get_senha(){
        return this.senha;
    }
   protected boolean get_ativo(){
        return this.ativo;
    }
    protected String get_departamento(){
        return this.departamento;
    }
    protected double get_salario(){
        return this.salario;
    }
    protected void set_id(int id){
        this.id = id;
    }
    protected void set_nome(String nome){
        this.nome = nome;
    }
    protected void set_email(String email){
        this.email = email;
    }
    protected void set_senha(int senha){
        this.senha = senha;
    }
    protected void set_ativo(boolean ativo){
        this.ativo = ativo;
    }
    protected void set_departamento(String departamento){
        this.departamento = departamento;
    }
    protected void set_salario(double salario){
        this.salario = salario;
    }

  protected void login(String id, int senha) {
        if (this.email.equals(email) && this.senha == senha) {
            System.out.println("Login bem-sucedido!");
        } else {
            System.out.println("Email ou senha incorretos.");
        }
    }

    


  
}

