public class ProdutoLimpeza extends Produto {
    private String unidadeMedida;
    private String ingredientesAtivos;
    private double volume;
    

    public String getunidadeMedida() {
        return unidadeMedida;
    }

    public void setunidadeMedida(String unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

    public String getIngredientesAtivos() {
        return ingredientesAtivos;
    }

    public void setIngredientesAtivos(String ingredientesAtivos) {
        this.ingredientesAtivos = ingredientesAtivos;
    }

    public double getVolume() {
        
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    @Override
    public void setDescricao(String descricao) {
        descricao = (this.getNome() + " com volume de " + this.getVolume() + " " + this.getunidadeMedida());
        super.setDescricao(descricao);
    }
    @Override
    public int tipoProduto() {
        return 2;
    }
}
