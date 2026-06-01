public class Gerente extends Usuario {
        private String departamento;
        private String Permissoes;
        

   public Gerente(int id, String nome, String email, int senha, String departamento) {
       super(id, nome, email, senha);
       this.departamento = departamento;
        this.Permissoes = "Vizualizar Relatórios, Cadastrar Funcionários,Cadastrar Estoque, Gerenciar Vendas";
    }

    private void visualizarRelatorio() {
        System.out.println("Visualizando relatório de vendas...");
        
    }

    @Override
    protected String get_departamento() {
        return this.departamento;
    }

}
