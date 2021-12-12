import java.util.ArrayList;
import java.util.Collection;

public class ContaCorrente extends Conta {

    private final double limiteContaCorrente = (this.getRendaMensal()) / 5;
    private static ArrayList<ContaCorrente> contasCorrente = new ArrayList<>();
    private static ArrayList<Conta> contasNegativas = new ArrayList<>();

    @Override
    public String toString() {
        return "Conta Corrente "+"nome:" + this.getNome() +
                ", cpf:" + this.getCpf() +
                ", rendaMensal: " + this.getRendaMensal() +
                ", numeroConta: " + getNumeroDaConta()  +
                ", agencia: " + this.getAgencia() +
                ", saldo: " + this.getSaldo() +
                ", limite: " + this.getLimite();
    }


    public ContaCorrente(String nome1, String cpf1, double rendaMensal, String agencia, double saldo) {
        super(nome1, cpf1, rendaMensal, agencia, saldo);
        this.limite = limiteContaCorrente;
        contasCorrente.add(this);
    }

    public static ContaCorrente procuraContaCorrente(int id) {
        for (ContaCorrente a : contasCorrente) {
            if(getNumeroConta(a)==id)
                return a;
        }
        return null;
    }

    @Override
    public double getLimite() {
        return limiteContaCorrente;
    }

    public static void listaContasCorrente() {
        if (contasCorrente.isEmpty()) {
            System.out.println("Nao existem contas correntes registradas no sistema");
        } else {
            for (Conta a : contasCorrente) {
                System.out.println(a);
            }
        }
    }

    public static void listaContasNegativas() {
        if (contasNegativas.isEmpty()) {
            System.out.println("Nao foram encontradas contas com saldo negativo registradas no sistema");
        } else {
            for (Conta a : contasNegativas) {
                System.out.println(a);
            }
        }
    }

    public static void adicionaContasNegativas() {
        for (Conta a : contasCorrente) {
            if (a.getSaldo() < 0) {
                contasNegativas.add(a);
                System.out.println(a);

            }
        }
    }


}
