import java.util.Scanner;

public abstract class MenuOperacoes {
    static Scanner sc = new Scanner(System.in);
    public static Conta login(){
        System.out.println("Insira o numero da conta que vai ser acessada");
        int id = sc.nextInt();
        Conta b = Conta.procuraConta(id);
        if (b != null) {
            MenuOperacoes.menuOperacoes(b);
        } else {
            System.out.println("A conta inserida nao foi encontrada");
        }
        return null;
    }

    public static void menuOperacoes(Conta a) {
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
            if (op == 1) {
                System.out.println("Insira o valor a ser sacado:");
                double decremento = sc.nextDouble();
                a.saque(decremento);
            }
            if (op == 2) {
                System.out.println("Insira o valor a ser depositado:");
                double incremento = sc.nextDouble();
                a.deposito(incremento);
            }
            if (op == 3) {
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
            }
            if (op == 4) {
                a.extratoCliente();
            }
            if (op == 5) {
                MenuInicial.menuInicial();
            }
        }
    }
}
