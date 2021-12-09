public class ContaCorrente extends Conta{

    private final double limite = (this.getRendaMensal())/5;
    ContaCorrente(String nome, String cpf, double rendaMensal, String agencia, double saldo) {
        super(nome, cpf, rendaMensal, agencia, saldo);
    }

    @Override
    public double getLimite() {
        return limite;
    }
}
