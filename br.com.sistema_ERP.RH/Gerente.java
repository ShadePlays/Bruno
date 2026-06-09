public class Gerente extends Usuario {
    private String Permissoes;

    public Gerente(int id, String nome, String email, int senha, String departamento, double salario) {
        super(id, nome, email, senha, 0);
        setDepartamento(departamento);
        setSalario(salario);
        this.Permissoes = "Vizualizar Relatórios, Cadastrar Funcionários,Cadastrar Estoque, Gerenciar Vendas";
    }

    public String getPermissoes() {
        return this.Permissoes;
    }

    public void setPermissoes(String permissoes) {
        this.Permissoes = permissoes;
    }
}
