public class Gerente extends Usuario {
        private String Permissoes;
        
        

   public Gerente(int id, String nome, String email, int senha, String departamento) {
       super(id, nome, email, senha);
       this.departamento = departamento;
        this.Permissoes = "Vizualizar Relatórios, Cadastrar Funcionários,Cadastrar Estoque, Gerenciar Vendas";
    }

    /*  private void visualizarRelatorio() {
        System.out.println("Visualizando relatório de vendas...");
        
    }*/

   @Override
    protected String getDepartamento() {
        return this.departamento;
    }
    protected double getSalario() {
        return this.salario;
    }
    protected void setSalario(Double salario) {
        this.salario = salario;
    }

    protected String getPermissoes() {
        return this.Permissoes;
    }
    protected void setPermissoes(String permissoes) {
        this.Permissoes = permissoes;
    }

    
    

}
