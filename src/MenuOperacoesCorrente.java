import java.util.Scanner;
public class MenuOperacoesCorrente {
    static Scanner sc = new Scanner(System.in);
    public static void menuOperacoesCorrente(ContaCorrente a) {
        int op;
        while (true) {
            System.out.println("""
                    Digite uma opcao:\s
                    1 - Realizar saque
                    2 - Realizar deposito
                    3 - Realizar transferencia
                    4 - Realizar extrato
                    5 - Alterar dados cadastrais
                    0 - Sair do menu de operacoes e ir para o menu inicial""");
            op = sc.nextInt();
            if(op == 0){
                MenuInicial.menuInicial();
                break;
            }else if (op == 1) {
                System.out.println("Insira o valor a ser sacado:");
                double decremento = sc.nextDouble();
                a.saque(decremento);
            }else if (op == 2) {
                System.out.println("Insira o valor a ser depositado:");
                double incremento = sc.nextDouble();
                a.deposito(incremento);
            }else if (op == 3) {
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
            }else if (op == 4) {
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
            }
        }
    }
}
