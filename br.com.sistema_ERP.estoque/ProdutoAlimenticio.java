public class ProdutoAlimenticio extends Produto {
        private String dataValidade;
        
        public String getDataValidade() {
            return dataValidade;
        }
    
        public void setDataValidade(String dataValidade) {
            this.dataValidade = dataValidade;
        }
        
        @Override
        public void setDescricao(String descricao) {
            descricao = (this.getNome() + " que vence em " + this.getDataValidade());
            super.setDescricao(descricao);
        }

        @Override
        public int tipoProduto() {
            return 1;
        }
}
