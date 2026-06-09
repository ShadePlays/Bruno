public class Despesa {

    private double valor;
    private String descricao;
    private String data;
    private String categoria;// despesa compra ou operacional
    private int codigo;

    public String getCategoria() {
        return categoria;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getData() {
        return data;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
