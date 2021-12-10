import java.util.ArrayList;

public class ContaPoupanca extends Conta{
    private static ArrayList<Conta> contasPoupanca = new ArrayList<>();

    public ContaPoupanca(String nome, String cpf, double rendaMensal, String agencia, double saldo) {
        super(nome, cpf, rendaMensal, agencia, saldo);
        contasPoupanca.add(this);
    }

    public static void listaContasPoupanca(){
        for( Conta a: contasPoupanca){
            System.out.println(a);
        }

    }
    public void simulacao(double capitalInicial, double taxaJuros, float tempoMeses){
        double montante = capitalInicial*Math.pow((1+taxaJuros),tempoMeses);
        System.out.printf("O montante será %.2f", montante);

    }
}
