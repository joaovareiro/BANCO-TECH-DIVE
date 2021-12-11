import java.util.ArrayList;

public class ContaCorrente extends Conta {

    private final double limiteContaCorrente = (this.getRendaMensal()) / 5;

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
        for (Conta a : contasCorrente) {
            System.out.println(a);
        }
    }

    public static void listaContasNegativas() {
        for (Conta a : contasCorrente) {
            if (a.getSaldo() < 0) {
                System.out.println(a);
            }
        }
    }


}
    //double parsedValue = Double.parseDouble(scanner.nextLine().replace(",",".");