import java.util.Scanner;

public class MenuCriacao {
    static Scanner sc= new Scanner(System.in);
    public static void menuCriacao(){
        int op;
        while(true) {
        System.out.println("""
                    Selecione o tipo de conta:\s
                    1 - Conta Corrente
                    2 - Conta Investimento
                    3 - Conta poupanca
                    4 - Voltar para o menu inicial """);
            op = sc.nextInt();
            if (op == 4) {
            MenuInicial.menuInicial();
            }else{
                System.out.printf("Digite o nome da conta \n");
                String nomeContaCorrente = sc.nextLine();
                sc.nextLine();
                System.out.printf("Digite o cpf da conta \n");
                String cpfContaCorrente = sc.nextLine();

                System.out.println("Digite a renda mensal da conta ");
                double rendaMensalContaCorrente = sc.nextDouble();
                sc.nextLine();
                System.out.println("Digite a agencia da conta ");
                String agencia = sc.nextLine();

                System.out.println("Digite o saldo inicial da conta ");
                double saldoInicial = sc.nextDouble();
            if(op == 1){
                ContaCorrente a = new ContaCorrente(nomeContaCorrente, cpfContaCorrente, rendaMensalContaCorrente, agencia, saldoInicial);
            }if(op == 2){
                ContaInvestimento a = new ContaInvestimento(nomeContaCorrente, cpfContaCorrente, rendaMensalContaCorrente, agencia, saldoInicial);
            }if(op == 3){
                ContaPoupanca a = new ContaPoupanca(nomeContaCorrente, cpfContaCorrente, rendaMensalContaCorrente, agencia, saldoInicial);
                }
            }
        }
    }
}

