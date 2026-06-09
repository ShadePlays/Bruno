public abstract class Produto {
    private int id;
    private String nome;
    private String descricao;
    private double precoVenda;
    private double custo;
    private int estoque;
    private boolean ativo;

    public int tipoProduto() {
        return 0;
    }

    public int getid() {
        return id;
    }

    public void setid(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(double precoVenda) {
        this.precoVenda = precoVenda;
    }

    public double getCusto() {
        return custo;
    }

    public void setCusto(double custo) {
        this.custo = custo;
    }

    public int getQuantidade() {
        return estoque;
    }

    public void setQuantidade(int estoque) {
        this.estoque = estoque;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public void getLucro() {
        double lucro = this.precoVenda - this.custo;
        if (lucro < 0) {
            System.out.println("Você está perdendo " + (lucro * -1) + " reais");
        } else if (lucro > 0) {
            System.out.println("Você está lucrando " + lucro + " reais");
        } else {
            System.out.println("Você não está tendo lucro algum.");
        }
    }
}
