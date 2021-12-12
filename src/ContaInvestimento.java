
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class ContaInvestimento extends Conta {
    private static ArrayList<ContaInvestimento> contasInvestimento = new ArrayList<>();
    private double valorInvestidoTotal;

    @Override
    public String toString() {
        return "Conta Investimento " + "nome:" + this.getNome() +
                ", cpf:" + this.getCpf() +
                ", rendaMensal: " + this.getRendaMensal() +
                ", numeroConta: " + getNumeroDaConta() +
                ", agencia: " + this.getAgencia() +
                ", saldo: " + this.getSaldo() +
                ", limite: " + this.getLimite();
    }

    public ContaInvestimento(String nome, String cpf, double rendaMensal, String agencia, double saldo) {
        super(nome, cpf, rendaMensal, agencia, saldo);
        contasInvestimento.add(this);
    }

    public static void listaContaInvestimento() {
        if (contasInvestimento.isEmpty()) {
            System.out.println("Nao existem contas investimento registradas no sistema");
        } else {
            for (Conta a : contasInvestimento) {
                System.out.println(a);
            }
        }
    }

    public void calcularInvestimento(double valorInvestido, double taxa) {
        double rendimentoAnual = valorInvestido * (taxa * 12);
        System.out.printf("Daqui a um ano se dinheiro ira valer : %.2f\n", rendimentoAnual);
    }


    public void investir(double valorInvestido, double taxa) {
        //saqueInvestimento(valorInvestido);
        double rendimentoAnual = valorInvestido * (taxa * 12);
        if(saqueInvestimento(valorInvestido)==1) {
            valorInvestidoTotal = valorInvestidoTotal + valorInvestido;
        }
        TimerTask devolveInvestimento = new TimerTask() {
            @Override
                public void run() {
                    deposito(rendimentoAnual);
                }
        };
        Timer timer = new Timer();
        Long a = Long.parseLong("31536000000");
        timer.schedule(devolveInvestimento,a);
    }

    public double getValorInvestidoTotal() {
        return valorInvestidoTotal;
    }



    public static ContaInvestimento procuraContaInvestimento(int id) {
        for (ContaInvestimento a : contasInvestimento) {
            if(getNumeroConta(a)==id)
                return a;
        }
        return null;
    }
}