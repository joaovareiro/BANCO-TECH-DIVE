public class ContaPoupanca extends Conta{

    ContaPoupanca(String nome, String cpf, double rendaMensal, String agencia, double saldo) {
        super(nome, cpf, rendaMensal, agencia, saldo);
    }

    public void simulacao(double capitalInicial, double taxaJuros, float tempoMeses){
        double montante = capitalInicial*Math.pow((1+taxaJuros),tempoMeses);
        System.out.printf("O montante será %.2f", montante);

    }
}
