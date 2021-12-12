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

    public static void menuOperacoes(Conta a){
        if(a instanceof ContaCorrente){
            //MenuOperacoesCorrente.menuOperacoesCorrente(a);
        }else if(a instanceof ContaPoupanca){

        }
    }


}
