public class Gerente extends Usuario {
        String departamento;
        String Permissoes;
        

    Gerente(int id, String nome, String email, int senha, String departamento) {
       super(id, nome, email, senha);
        this.departamento = departamento;
        this.Permissoes = "Vizualizar Relatórios, Gerenciar Funcionários";
    }

    void visualizarRelatorio() {
        System.out.println("Visualizando relatório de vendas...");
        
    }

}
