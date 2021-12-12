import java.util.Scanner;

public class MenuOperacoesInvestimento {
    static Scanner sc = new Scanner(System.in);

    public static void menuOperacoesCorrente(ContaInvestimento a) {
        int op;
        while (true) {
            System.out.println("""
                    Digite uma opcao:\s
                    1 - Realizar saque
                    2 - Realizar deposito
                    3 - Realizar transferencia
                    4 - Realizar extrato
                    5 - Alterar dados cadastrais
                    6 - Simular investimento
                    7 - Investir
                    8 - Mostrar valor investido
                    9 - Sair do menu de operacoes e ir para o menu inicial""");
            op = sc.nextInt();
            if (op == 9) {
                break;
            } else if (op == 1) {
                System.out.println("Insira o valor a ser sacado:");
                double decremento = sc.nextDouble();
                a.saque(decremento);
            } else if (op == 2) {
                System.out.println("Insira o valor a ser depositado:");
                double incremento = sc.nextDouble();
                a.deposito(incremento);
            } else if (op == 3) {
                System.out.println("Insira o numero da conta que vai receber a transferencia");
                int id = sc.nextInt();
                Conta b = Conta.procuraConta(id);
                if (b != null) {
                    System.out.println("Insira o valor a ser transferido");
                    double valorTransferencia = sc.nextDouble();
                    a.transferir(b, valorTransferencia);
                } else {
                    System.out.println("A conta inserida nao foi encontrada");
                }
            } else if (op == 4) {
                a.extratoCliente();
            } else if (op == 5) {
                System.out.println("Insira o novo nome");
                sc.nextLine();
                String novoNome = sc.nextLine();
                System.out.println("Insira a nova renda mensal");
                double novaRendaMensal = sc.nextDouble();
                System.out.println("Insira a nova agencia");
                sc.nextLine();
                String novaAgencia = sc.nextLine();
                a.alteraDados(novoNome,novaRendaMensal,novaAgencia);
            } else if (op == 6) {
                System.out.println("Digite o valor a ser investido na simulacao");
                double cap = sc.nextDouble();
                System.out.println("""
                        Selecione uma taxa:\s
                        1 - Taxa Selic 0.2461
                        2 - Taxa LCA 0.3120
                        3 - Taxa CBD 0.1987
                        4 - Taxa LCI 0.2780""");
                op = sc.nextInt();
                double taxa = 0;
                if (op == 1) {
                    taxa = 0.2461;
                } else if (op == 2) {
                    taxa = 0.3120;
                } else if (op == 3) {
                    taxa = 0.1987;
                } else if (op == 4) {
                    taxa = 0.2780;
                }

                if (taxa == 0) {
                    System.out.println("Opcao invalida");
                } else {
                    a.calcularInvestimento(cap, taxa);
                }
            } else if (op == 7) {
                System.out.println("Digite o valor a ser investido");
                double cap = sc.nextDouble();
                System.out.println("""
                        Selecione uma taxa:\s
                        1 - Taxa Selic 0.02461
                        2 - Taxa LCA 0.03120
                        3 - Taxa CBD 0.01987
                        4 - Taxa LCI 0.02780""");
                op = sc.nextInt();
                double taxa = 0;
                if (op == 1) {
                    taxa = 0.02461;
                } else if (op == 2) {
                    taxa = 0.03120;
                } else if (op == 3) {
                    taxa = 0.01987;
                } else if (op == 4) {
                    taxa = 0.02780;
                }

                if (taxa == 0) {
                    System.out.println("Opcao invalida");
                } else {
                    a.investir(cap, taxa);
                }
            }if (op ==8){
                    System.out.printf("O valor investido nessa conta foi R$ %.2f\n",a.getValorInvestidoTotal());
                }
            }
        }
    }

