
import java.util.Scanner;

public class Interface extends RH {

    public static void telaInicial(Scanner scanner, int id) {
        if (id > -1) {
            int cargo = RH.departamento(id);
            if (cargo == 1) {
                Interface.ExibirMenuGerencia();
                int seta = TesteEntrada.nextInt(scanner);
                if (seta > 0) {
                    scanner.nextLine(); // Limpar o buffer do scanner
                    Interface.ExibirSubmenuGerencia(id, seta, scanner);
                }
            } else if (cargo == 2) {
                Interface.ExibirMenuVendas();
                int seta = TesteEntrada.nextInt(scanner);
                if (seta > 0) {
                    scanner.nextLine(); // Limpar o buffer do scanner
                    Interface.ExibirSubmenuVendas(id, seta, scanner);
                }
            } else if (cargo == 3) {
                Interface.ExibirMenuEstoque();
                int seta = TesteEntrada.nextInt(scanner);
                if (seta == 1) {
                    scanner.nextLine(); // Limpar o buffer do scanner
                    Interface.ExibirSubmenuEstoque(id, seta, scanner);
                }

            } else if (cargo == 4) {
                Interface.ExibirMenuRH();
                int seta = TesteEntrada.nextInt(scanner);
                if (seta == 1) {
                    scanner.nextLine(); // Limpar o buffer do scanner
                    Interface.ExibirSubmenuRH(id, seta, scanner);
                }
            } else if (cargo == 5) {
                Interface.ExibirMenuFinanceiro();
                int seta = TesteEntrada.nextInt(scanner);
                if (seta == 1) {
                    scanner.nextLine(); // Limpar o buffer do scanner
                    Interface.ExibirSubmenuFinanceiro(id, seta, scanner);
                }
            }

            else {
                System.out.println("Cargo desconhecido. Acesso limitado.");
            }

        } else {
            System.out.println("Usuario não encontrado ou senha incorreta. Acesso negado.");
        }
    }

    public static void ExibirMenuGerencia() {
        System.out.println("Bem-vindo ao Sistema ERP!");
        System.out.println("===========================");
        System.out.println("1. Cadastrar");
        System.out.println("2. Buscar");
        System.out.println("3. Exibir Todos");
        System.out.println("4. Gerenciar Vendas");
        System.out.println("5. Gerenciar RH");
        System.out.println("6. Gerenciar Estoque");
        System.out.println("7. Gerenciar financeiro");
        System.out.println("0. Sair");
        System.out.println("===========================");
    }

    public static void ExibirMenuVendas() {
        System.out.println("Bem-vindo ao Sistema ERP!");
        System.out.println("===========================");
        System.out.println("1. Registrar Venda");
        System.out.println("2. Exibir Vendas");
        System.out.println("3. Exibir Vendas por Data");
        System.out.println("4. Cadastrar Cliente");
        System.out.println("0. Sair");
        System.out.println("===========================");
    }

    public static void ExibirMenuRH() {
        System.out.println("Bem-vindo ao Sistema ERP!");
        System.out.println("===========================");
        System.out.println("1. Gerenciar RH");
        System.out.println("0. Sair");
        System.out.println("===========================");
    }

    public static void ExibirMenuEstoque() {
        System.out.println("Bem-vindo ao Sistema ERP!");
        System.out.println("===========================");
        System.out.println("1. Gerenciar Estoque");
        System.out.println("0. Sair");
        System.out.println("===========================");
    }

    public static void ExibirMenuFinanceiro() {
        System.out.println("Bem-vindo ao Sistema ERP!");
        System.out.println("===========================");
        System.out.println("1. Gerenciar Financeiro");
        System.out.println("0. Sair");
        System.out.println("===========================");
    }

    public static void ExibirSubmenuGerencia(int id, int setar, Scanner scanner) {
        switch (setar) {
            case 1:
                System.out.println("===========================");
                System.out.println("1. Cadastrar Usuario");
                System.out.println("2. Promover Funcionario a Gerente");
                System.out.println("0. Voltar ao Menu Principal");
                System.out.println("===========================");
                break;
            case 2:
                System.out.println("===========================");
                System.out.println("1. Buscar usuário por ID");
                System.out.println("0. Voltar ao Menu Principal");
                System.out.println("===========================");
                break;
            case 3:
                System.out.println("===========================");
                System.out.println("1. Exibir Todos os Funcionários");
                System.out.println("2. Exibir Todos os Gerentes");
                System.out.println("0. Voltar ao Menu Principal");
                System.out.println("===========================");
                break;
            case 4:
                Interface.ExibirMenuVendas();
                break;
            case 5:
                System.out.println("===========================");
                System.out.println("1. Gerenciar RH");
                System.out.println("0. Voltar ao Menu Principal");
                System.out.println("===========================");
                break;
            case 6:
                System.out.println("===========================");
                System.out.println("1. Gerenciar Estoque");
                System.out.println("0. Voltar ao Menu Principal");
                System.out.println("===========================");
                break;
            case 7:
                System.out.println("===========================");
                System.out.println("1. Gerenciar Financeiro");
                System.out.println("0. Voltar ao Menu Principal");
                System.out.println("===========================");
                break;
            default:
                System.out.println("Opção inválida! Por favor, escolha uma opção válida.");
        }

        if (setar == 0) {
            System.out.println("Encerrando o sistema...");
        } else if (setar == 1) {
            setar = TesteEntrada.nextInt(scanner);
            Interface.exibirSubmenuCadastrar(id, setar, scanner);

        } else if (setar == 2) {
            setar = TesteEntrada.nextInt(scanner);
            Interface.exibirSubmenuBuscar(id, setar, scanner);
        } else if (setar == 3) {
            setar = TesteEntrada.nextInt(scanner);
            Interface.ExibirSubmenuExibir(id, setar, scanner);

        } else if (setar == 4) {
            setar = TesteEntrada.nextInt(scanner);
            Interface.ExibirSubmenuVendas(id, setar, scanner);
        } else if (setar == 5) {
            setar = TesteEntrada.nextInt(scanner);
            Interface.ExibirSubmenuRH(id, setar, scanner);
        } else if (setar == 6) {
            Interface.ExibirSubmenuEstoque(id, setar, scanner);
        } else if (setar == 7) {
            Interface.ExibirSubmenuFinanceiro(id, setar, scanner);
        }
    }

    public static void exibirSubmenuCadastrar(int id, int seta, Scanner scanner) {

        RH.submenuCadastrar(id, seta, scanner);

    }

    public static void exibirSubmenuBuscar(int id, int seta, Scanner scanner) {

        RH.submenuBuscar(id, seta, scanner);

        if (seta == 0) {
            System.out.println("voltando ao menu principal...");
        }

    }

    public static void ExibirSubmenuVendas(int id, int seta, Scanner scanner) {
        switch (seta) {
            case 1:
                Vendas.registrarVenda(scanner);
                break;
            case 2:
                Vendas.exibirVendas();
                break;
            case 3:
                System.out.println("Digite a data para filtrar as vendas (dd/mm/yyyy):");
                scanner.nextLine(); // Limpar o buffer do scanner
                String data = scanner.nextLine();
                Vendas.exibirVendasPorData(data);
                break;
            case 4:
                Cliente.cadastrarCliente(scanner);
                break;
            case 0:
                break;
            default:
                System.out.println("Opção inválida! Por favor, escolha uma opção válida.");
        }

        if (seta == 0) {
            System.out.println("Encerrando o sistema...");
        }
    }

    public static void ExibirSubmenuRH(int id, int seta, Scanner scanner) {
        switch (seta) {
            case 1:
                System.out.println("===========================");
                System.out.println("1. Registrar Ponto");
                System.out.println("2. Exibir Funcionários");
                System.out.println("3. Exibir Gerentes");
                System.out.println("4. Cadastrar Usuario");
                System.out.println("5. Registrar falta ");
                System.out.println("6. Folha de pagamento");
                System.out.println("0. Voltar ao Menu Principal");
                System.out.println("===========================");
                break;
            case 0:
                break;
            default:
                System.out.println("Opção inválida! Por favor, escolha uma opção válida.");
        }

        seta = TesteEntrada.nextInt(scanner);
        scanner.nextLine(); // Limpar o buffer do scanner
        if (seta == 0) {
            System.out.println("Encerrando o sistema...");
        } else if (seta == 1) {
            seta = TesteEntrada.nextInt(scanner);
            scanner.nextLine(); // Limpar o buffer do scanner
            if (seta == 1) {
                System.out.println("Registrando ponto para qual funcionário? (Digite o ID do funcionário)");
                int funcionarioId = TesteEntrada.nextInt(scanner);
                scanner.nextLine(); // Limpar o buffer do scanner
                RH.registrarPonto(funcionarioId);
            }
        } else if (seta == 2) {
            RH.exibirFuncionarios();
        } else if (seta == 3) {
            RH.exibirGerentes();
        } else if (seta == 4) {
            RH.cadastrarUsuario(scanner);
        } else if (seta == 5) {
            RH.registrarFalta(scanner);
        } else if (seta == 6) {
            RH.FolhaPagamento(scanner);
        }
    }

    public static void ExibirSubmenuFinanceiro(int id, int seta, Scanner scanner) {
        seta = TesteEntrada.nextInt(scanner);
        switch (seta) {
            case 1:
                System.out.println("===========================");
                System.out.println("1. cadastrar despesa");
                System.out.println("2. exibir despesas");
                System.out.println("3. exibir custos por departamento");
                System.out.println("0. Voltar ao Menu Principal");
                System.out.println("===========================");
                break;
            case 0:
                break;
            default:
                System.out.println("Opção inválida! Por favor, escolha uma opção válida.");
        }
        if (seta != 0) {
            seta = TesteEntrada.nextInt(scanner);
        }

        if (seta == 0) {
            System.out.println("Encerrando o sistema...");
        } else if (seta == 1) {

            Financeiro.registrarDespesa(scanner);

        } else if (seta == 2) {
            Financeiro.exibirDespesas();
        } else if (seta == 3) {
            RH.FolhaPagamentoTotal();
        }
    }

    public static void ExibirSubmenuEstoque(int id, int seta, Scanner scanner) {
        System.out.println("===========================");
        System.out.println("1. Visualizar Estoque Ativo");
        System.out.println("2. Visualizar Estoque Inativo");
        System.out.println("3. Adicionar Produto");
        System.out.println("4. Ativar Produto");
        System.out.println("5. Desativar Produto");
        System.out.println("6. Remover Produto");
        System.out.println("7. Comprar Produto");
        System.out.println("0. Voltar ao Menu Principal");
        System.out.println("===========================");
        seta = TesteEntrada.nextInt(scanner);
        scanner.nextLine(); // Limpar o buffer do scanner
        switch (seta) {
            case 0:
                System.out.println("Encerrando o sistema...");
                break;
            case 1:
                Estoque.exibirProdutosAtivos();
                break;
            case 2:
                Estoque.exibirProdutosInativos();
                break;
            case 3:
                Estoque.registrarProduto(scanner);
                break;
            case 4:
                Estoque.ativarProduto(scanner);
                break;
            case 5:
                Estoque.desativarProduto(scanner);
                break;
            case 6:
                Estoque.removerProduto(scanner);
                break;
            case 7:
                Estoque.comprarProduto(scanner);
                break;
            default:
                System.out.println("Opção inválida! Por favor, escolha uma opção válida.");
        }
    }

    public static void ExibirSubmenuExibir(int id, int seta, Scanner scanner) {
        if (seta == 0) {
            System.out.println("Encerrando o sistema...");
        } else if (seta == 1) {
            RH.exibirFuncionarios();
        } else if (seta == 2) {
            RH.exibirGerentes();
        }
    }

}

// A ideia é diminuir os códigos na MAIN, e deixar a MAIN apenas para chamar as
// funções, e a Interface para exibir os menus e receber as entradas do usuário,
// e as Funcoes_basicas para realizar as operações de cadastro, busca, etc.
