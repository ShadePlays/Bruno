public class Sale {
    private int codigoProduto;
    private int quantidadeVendida;
    private String dataVenda;
    private String nomeProduto;
    private String CpfCliente;

    public int getCodigoProduto() {
        return codigoProduto;
    }
    public String getDataVenda() {
        return dataVenda;
    }
    public String getNomeProduto() {
        return nomeProduto;
    }
    public int getQuantidadeVendida() {
        return quantidadeVendida;
    }
    public String getCpfCliente() {
        return CpfCliente;
    }
    public void setCpfCliente(String cpfCliente) {
        CpfCliente = cpfCliente;
    }
    public void setCodigoProduto(int codigoProduto) {
        this.codigoProduto = codigoProduto;
    }
    public void setDataVenda(String dataVenda) {
        this.dataVenda = dataVenda;
    }
    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }
    public void setQuantidadeVendida(int quantidadeVendida) {
        this.quantidadeVendida = quantidadeVendida;
    }


}
