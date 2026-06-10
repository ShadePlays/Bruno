import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public final class Financeiro {
    private static double caixa = 0.0;
    private static HashMap<Integer, Despesa> banco_despesas = new HashMap<>();
    private static HashMap<Integer, Faturamento> banco_faturamentos = new HashMap<>();

    public static void dados_teste() {

    Despesa despesa1 = new Despesa();
    despesa1.setValor(1000);
    despesa1.setDescricao("Aluguel");
    despesa1.setData("01/01/2024");
    despesa1.setCategoria("operacional");
    banco_despesas.put(1, despesa1);

    Despesa despesa2 = new Despesa();
    despesa2.setValor(500);
    despesa2.setDescricao("Compra de mercadorias");
    despesa2.setData("02/01/2024");
    despesa2.setCategoria("compras");
    banco_despesas.put(2, despesa2);

    Despesa despesa3 = new Despesa();
    despesa3.setValor(350);
    despesa3.setDescricao("Conta de energia");
    despesa3.setData("05/01/2024");
    despesa3.setCategoria("operacional");
    banco_despesas.put(3, despesa3);

    Despesa despesa4 = new Despesa();
    despesa4.setValor(180);
    despesa4.setDescricao("Conta de água");
    despesa4.setData("05/01/2024");
    despesa4.setCategoria("operacional");
    banco_despesas.put(4, despesa4);

    Despesa despesa5 = new Despesa();
    despesa5.setValor(750);
    despesa5.setDescricao("Reposição de estoque");
    despesa5.setData("10/01/2024");
    despesa5.setCategoria("compras");
    banco_despesas.put(5, despesa5);

    Despesa despesa6 = new Despesa();
    despesa6.setValor(420);
    despesa6.setDescricao("Internet e telefone");
    despesa6.setData("12/01/2024");
    despesa6.setCategoria("operacional");
    banco_despesas.put(6, despesa6);

    Despesa despesa7 = new Despesa();
    despesa7.setValor(900);
    despesa7.setDescricao("Compra de eletrônicos");
    despesa7.setData("15/01/2024");
    despesa7.setCategoria("compras");
    banco_despesas.put(7, despesa7);

    Faturamento faturamento1 = new Faturamento();
    faturamento1.setValor(2000);
    faturamento1.setDescricao("Venda de produtos alimentícios");
    banco_faturamentos.put(1, faturamento1);

    Faturamento faturamento2 = new Faturamento();
    faturamento2.setValor(3200);
    faturamento2.setDescricao("Venda de produtos eletrônicos");
    banco_faturamentos.put(2, faturamento2);

    Faturamento faturamento3 = new Faturamento();
    faturamento3.setValor(1500);
    faturamento3.setDescricao("Venda de produtos de limpeza");
    banco_faturamentos.put(3, faturamento3);

    Faturamento faturamento4 = new Faturamento();
    faturamento4.setValor(2800);
    faturamento4.setDescricao("Promoção de fim de semana");
    banco_faturamentos.put(4, faturamento4);

    Faturamento faturamento5 = new Faturamento();
    faturamento5.setValor(4100);
    faturamento5.setDescricao("Venda para cliente corporativo");
    banco_faturamentos.put(5, faturamento5);

    caixa = 13600.0;
}

    public static void registrarCompras(int quantidade, double valorUnitario) {
        double valorTotal = quantidade * valorUnitario;
        caixa -= valorTotal;
        System.out.println("Compra registrada: Quantidade: " + quantidade + ", Valor Unitário: " + valorUnitario
                + ", Valor Total: " + valorTotal);
    }

    public static void registrarCaixa(double valor) {

        caixa += valor;

    }

    public static void registrarDespesa(Scanner scanner) {

        System.out.println("Digite o valor da despesa:");
        double valor = scanner.nextDouble();
        scanner.nextLine(); // Limpar o buffer do scanner
        System.out.println("Digite a descrição da despesa:");
        String descricao = scanner.nextLine();
        System.out.println("Digite a data da despesa (dd/mm/yyyy):");
        String data = scanner.nextLine();
        System.out.println("Digite a categoria da despesa(compra ou operacional):");
        String categoria = scanner.nextLine();

        Despesa despesa = new Despesa();
        despesa.setValor(valor);
        despesa.setDescricao(descricao);
        despesa.setData(data);
        despesa.setCategoria(categoria);
        int codigo = banco_despesas.size() + 1;

        banco_despesas.put(codigo, despesa);
        System.out.println("Despesa registrada: " + banco_despesas.get(codigo));
    }

    public static void exibirDespesas() {
        System.out.println("Despesas Registradas:");
        for (Integer codigo : banco_despesas.keySet()) {
            System.out.println("codigo: " + codigo + ", Descrição: " + banco_despesas.get(codigo));
        }
    }

    public static void exibirDespesasPorCategoria(String categoria) {
        System.out.println("Despesas na categoria: " + categoria);
        for (Integer codigo : banco_despesas.keySet()) {
            if (banco_despesas.get(codigo).getCategoria().equalsIgnoreCase(categoria)) {
                System.out.println("codigo: " + codigo + ", Descrição: " + banco_despesas.get(codigo));
            }
        }
    }

    public static void registrarFaturamento(float valor, String nome_produto, String data) {
        Faturamento faturamento = new Faturamento();
        faturamento.setValor(valor);
        int codigo = banco_faturamentos.size() + 1;
        faturamento.setDescricao("Faturamento venda" + nome_produto + "data: " + data);
        banco_faturamentos.put(codigo, faturamento);
        System.out.println("Faturamento registrado: " + banco_faturamentos.get(codigo));
        {
            Financeiro.registrarCaixa(valor);

        }
    }

    public static void demonstracao_de_resultados() {
        float totalDespesasfixas = 0;
        float totalDespesasvariaveis = 0;
        float totalDespesas = 0;
        for (Despesa despesa : banco_despesas.values()) {
            if (despesa.getCategoria().equalsIgnoreCase("operacional")) {
                totalDespesasfixas += despesa.getValor();
            } else if (despesa.getCategoria().equalsIgnoreCase("compras")) {
                totalDespesasvariaveis += despesa.getValor();
            }
        }
        totalDespesas = totalDespesasfixas + totalDespesasvariaveis;
        float totalFaturamentos = 0;

        for (Faturamento faturamento : banco_faturamentos.values()) {
            totalFaturamentos += faturamento.getValor();
        }

        float resultado = totalFaturamentos - totalDespesas;

        System.out.println("Demonstração de Resultados:");
        System.out.println("Total de Faturamentos: " + totalFaturamentos);
        System.out.println("Total de Despesas: " + totalDespesas);
        System.out.println("Resultado: " + resultado);
    }

    public static float get_despesas_por_categoria(String categoria) {
        float total = 0;
        for (Despesa despesa : banco_despesas.values()) {
            if (despesa.getCategoria().equalsIgnoreCase(categoria)) {
                total += despesa.getValor();
            }
        }
        return total;
    }

    public static void registrar_em_arquivo_csv() {

        try {

            PrintWriter writer = new PrintWriter("despesas.csv");

            writer.println("Codigo;Valor;Descricao;Data;Categoria");

            for (Map.Entry<Integer, Despesa> entry : banco_despesas.entrySet()) {

                Integer codigo = entry.getKey();
                Despesa despesa = entry.getValue();

                writer.println(
                        codigo + ";" +
                                despesa.getValor() + ";" +
                                despesa.getDescricao() + ";" +
                                despesa.getData() + ";" +
                                despesa.getCategoria());
            }

            writer.close();
            System.out.println("==================================================");
            System.out.println("Arquivo despesas.csv criado com sucesso!");
            System.out.println("==================================================");

        } catch (Exception e) {
            System.out.println("==================================================");
            System.out.println("Erro ao criar arquivo: " + e.getMessage());
            System.out.println("==================================================");
        }

        try {
            PrintWriter writer = new PrintWriter("faturamentos.csv");

            writer.println("Codigo;Valor;Descricao");

            for (Map.Entry<Integer, Faturamento> entry : banco_faturamentos.entrySet()) {

                Integer codigo = entry.getKey();
                Faturamento faturamento = entry.getValue();

                writer.println(
                        codigo + ";" +
                                faturamento.getValor() + ";" +
                                faturamento.getDescricao());
            }

            writer.close();
            System.out.println("==================================================");
            System.out.println("Arquivo faturamentos.csv criado com sucesso!");
            System.out.println("==================================================");
        } catch (Exception e) {
            System.out.println("==================================================");
            System.out.println("Erro ao criar arquivo: " + e.getMessage());
            System.out.println("==================================================");
        }

        try {
            PrintWriter writer = new PrintWriter("Demonstração_de_resultados.csv");

            writer.println("=== DEMONSTRAÇÃO DE RESULTADOS ===");

            float totalDespesasfixas = 0;
            float totalDespesasvariaveis = 0;
            float totalDespesas = 0;
            for (Despesa despesa : banco_despesas.values()) {
                if (despesa.getCategoria().equalsIgnoreCase("operacional")) {
                    totalDespesasfixas += despesa.getValor();
                } else if (despesa.getCategoria().equalsIgnoreCase("compras")) {
                    totalDespesasvariaveis += despesa.getValor();
                }
            }
            totalDespesas = totalDespesasfixas + totalDespesasvariaveis;
            float totalFaturamentos = 0;

            for (Faturamento faturamento : banco_faturamentos.values()) {
                totalFaturamentos += faturamento.getValor();
            }

            float resultado = totalFaturamentos - totalDespesas;
            writer.println("==================================================");
            writer.println("Total de Faturamentos: " + totalFaturamentos);
            writer.println("Total de Despesas: " + totalDespesas);
            writer.println("==================================================");
            writer.println("Resultado: " + resultado);
         
            writer.close();

            System.out.println("Arquivo Demonstração_de_resultados.csv criado com sucesso!");

        } catch (Exception erro) {
            System.out.println("Erro ao criar arquivo: " + erro.getMessage());
        }

        try {
            PrintWriter writer = new PrintWriter("ponto_de_equilibrio.csv");
            writer.println(
                    " O ponto de equilíbrio é uma métrica importante para as empresas, pois ajuda a determinar o volume mínimo de vendas necessário para evitar prejuízos e começar a gerar lucro. Ele é usado para tomar decisões estratégicas, como definir preços, planejar campanhas de marketing e avaliar a viabilidade de novos produtos ou serviços.");
            writer.println(); // Linha em branco para separar o texto do cálculo
            writer.println("=== PONTO DE EQUILÍBRIO TOTAL ===");

            float totalDespesasfixas = 0;
            float totalDespesasvariaveis = 0;
            for (Despesa despesa : banco_despesas.values()) {
                if (despesa.getCategoria().equalsIgnoreCase("operacional")) {
                    totalDespesasfixas += despesa.getValor();
                } else if (despesa.getCategoria().equalsIgnoreCase("compras")) {
                    totalDespesasvariaveis += despesa.getValor();
                }
            }
            float totalDespesas = totalDespesasfixas + totalDespesasvariaveis;

            float totalFaturamentos = 0;
            for (Faturamento faturamento : banco_faturamentos.values()) {
                totalFaturamentos += faturamento.getValor();
            }

            if (totalFaturamentos == totalDespesas) {
                writer.println("Ponto de Equilíbrio Total: indefinido (faturamento igual às despesas)");
            } else {
                float pontoEquilibrio = totalDespesas / (totalFaturamentos - totalDespesas);
                writer.println("Ponto de Equilíbrio Total: " + pontoEquilibrio);
            }

            writer.close();

            System.out.println("Arquivo ponto_de_equilibrio.csv criado com sucesso!");

        } catch (Exception erro) {
            System.out.println("Erro ao criar arquivo: " + erro.getMessage());
        }
    }

    public static double getCaixa() {
        return caixa;
    }

}
