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
    protected String get_departamento() {
        return this.departamento;
    }
    protected double get_salario() {
        return this.salario;
    }
    protected void set_salario(Double salario) {
        this.salario = salario;
    }


    protected String get_permissoes() {
        return this.Permissoes;
    }
    protected void set_permissoes(String permissoes) {
        this.Permissoes = permissoes;
    }

    
    

}
