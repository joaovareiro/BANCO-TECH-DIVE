import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ContaCorrente extends Conta {

    private final double limiteContaCorrente = (this.getRendaMensal()) / 5;

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

    private static ArrayList<Conta> contasCorrente = new ArrayList<>();
    private static ArrayList<Conta> contasNegativas = new ArrayList<>();

    public ContaCorrente(String nome, String cpf, double rendaMensal, String agencia, double saldo) {
        super(nome, cpf, rendaMensal, agencia, saldo);
        this.limite = limiteContaCorrente;
        contasCorrente.add(this);
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
        for (Conta a : contasCorrente) {
            if (a.getSaldo() < 0) {
                System.out.println(a);
            }
        }
    }

    public void bloqueia() {

    }

}
