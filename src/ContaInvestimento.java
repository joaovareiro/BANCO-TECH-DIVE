import java.util.ArrayList;

public class ContaInvestimento extends Conta{
    private static ArrayList<Conta> contasInvestimento = new ArrayList<>();

    public ContaInvestimento(String nome, String cpf, double rendaMensal, String agencia, double saldo) {
        super(nome, cpf, rendaMensal, agencia, saldo);
        contasInvestimento.add(this);
    }

    public static void listaContaInvestimento(){
        for( Conta a: contasInvestimento){
            System.out.println(a);
        }
    }
}