import java.util.Scanner;

public class MenuRelatorios extends MenuOperacoes{
    static Scanner sc = new Scanner(System.in);
    public static void menuRelatorios(){
        int op;
        while (true) {
        System.out.println("""
                    Selecione uma opcao:\s
                    1 - Listar contas
                    2 - Listar contas com saldo negativo
                    3 - Listar valor investido
                    4 - Lista transacoes de uma conta
                    5 - Sair """);
        op = sc.nextInt();
        if(op == 1){
            System.out.println("""
                    Selecione uma opcao:\s
                    1 - Listar contas correntes
                    2 - Listar contas poupanca
                    3 - Listar contas investimento
                    4 - Sair """);
                    op = sc.nextInt();
                    if(op == 1){
                        ContaCorrente.listaContasCorrente();
                    }else if(op == 2){
                        ContaPoupanca.listaContasPoupanca();
                    }else if(op == 3){
                        ContaInvestimento.listaContaInvestimento();
                    }else if(op == 4){
                        MenuRelatorios.menuRelatorios();
                    }
            }else if(op == 2){
            ContaCorrente.listaContasNegativas();
            }else if(op == 3){
            //LISTAR VALOR INVESTIDO
            }else if(op == 4){
            System.out.println("Insira o numero da conta que vai ser acessada");
            int id = sc.nextInt();
            (Conta.procuraConta(id)).extratoCliente();
            }else if(op == 5){
            break;
            }
        }
    }
}