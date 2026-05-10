
public class Usuario extends Funcoes_basicas {
  
    protected int id;
    protected String nome;
    protected String email;
    protected int senha;
    protected boolean ativo;
   

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

  protected void login(String id, int senha) {
        if (this.email.equals(email) && this.senha == senha) {
            System.out.println("Login bem-sucedido!");
        } else {
            System.out.println("Email ou senha incorretos.");
        }
    }

    


  
}

