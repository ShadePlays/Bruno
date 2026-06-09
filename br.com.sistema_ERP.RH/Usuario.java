
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
   protected int getID(){
            return this.id;
    }

    protected String getNome(){
            return this.nome;
    }

   protected String getEmail(){
            return this.email;
    }
   protected int getSenha(){
        return this.senha;
    }
   protected boolean getAtivo(){
        return this.ativo;
    }
    protected String getDepartamento(){
        return this.departamento;
    }

    protected double getSalario(){
        return this.salario;
    }
    protected void setID(int id){
        this.id = id;
    }
    protected void setNome(String nome){
        this.nome = nome;
    }
    protected void setEmail(String email){
        this.email = email;
    }
    protected void setSenha(int senha){
        this.senha = senha;
    }
    protected void setAtivo(boolean ativo){
        this.ativo = ativo;
    }
    protected void setDepartamento(String departamento){
        this.departamento = departamento;
    }
    protected void setSalario(double salario){
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

