public class ProdutoEletronico extends Produto {
    private String marca;
    private String modelo;
    private int voltagem;
    private int garantiaMeses;

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {

        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getVoltagem() {
        return voltagem;
    }

    public void setVoltagem(int voltagem) {
        this.voltagem = voltagem;
    }

    public int getGarantiaMeses() {
        return garantiaMeses;
    }

    public void setGarantiaMeses(int garantiaMeses) {
        this.garantiaMeses = garantiaMeses;
    }

    @Override
    public void setDescricao(String descricao) {
        descricao = (this.getNome() + " modelo " + this.getModelo() + " da marca " + this.getMarca());
        super.setDescricao(descricao);
    }

    @Override
    public int tipoProduto() {
        return 3;
    }
}
