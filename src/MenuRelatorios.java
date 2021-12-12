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
                    5 - Voltar para o menu inicial """);
        op = sc.nextInt();
        if(op == 1){
            System.out.println("""
                    Selecione uma opcao:\s
                    1 - Listar contas correntes
                    2 - Listar contas poupanca
                    3 - Listar contas investimento
                    4 - Lista todas as contas do sistema
                    5 - Voltar para o menu de relatorios""");
                    op = sc.nextInt();
                    if(op == 1){
                        ContaCorrente.listaContasCorrente();
                    }else if(op == 2){
                        ContaPoupanca.listaContasPoupanca();
                    }else if(op == 3){
                        ContaInvestimento.listaContaInvestimento();
                    }else if(op == 4){
                        Conta.listaTudo();
                    }else if(op == 5){
                        MenuRelatorios.menuRelatorios();
                        break;
                    }
            }else if(op == 2){
            ContaCorrente.listaContasNegativas();
            }else if(op == 3){
            System.out.println("Insira o numero da conta que vai ser acessada");
            int id = sc.nextInt();
            ContaInvestimento a = ContaInvestimento.procuraContaInvestimento(id);
            if(a!=null){
                System.out.printf("O valor investido nessa conta foi R$ %.2f\n",a.getValorInvestidoTotal());
            }else {
                System.out.println("Conta nao encontrada");
            }
            }else if(op == 4){
            System.out.println("Insira o numero da conta que vai ser acessada");
            int id = sc.nextInt();
            (Conta.procuraConta(id)).extratoSemSaldo();
            }else if(op == 5){
            MenuInicial.menuInicial();
            }
        }
    }
}
