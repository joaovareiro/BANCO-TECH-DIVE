package Contas;

import java.util.ArrayList;

public class ContaPoupanca extends Conta {
    private static ArrayList<ContaPoupanca> contasPoupanca = new ArrayList<>();



    public ContaPoupanca(String nome, String cpf, double rendaMensal, String agencia, double saldo) {
        super(nome, cpf, rendaMensal, agencia, saldo);
        contasPoupanca.add(this);
    }

    @Override
    public String toString() {
        return "Conta Poupanca "+"nome:" + this.getNome() +
                ", cpf:" + this.getCpf() +
                ", rendaMensal: " + this.getRendaMensal() +
                ", numeroConta: " + getNumeroDaConta()  +
                ", agencia: " + this.getAgencia() +
                ", saldo: " + this.getSaldo() +
                ", limite: " + this.getLimite();
    }

    public void simulacao(double capitalInicial, double taxaJuros, float tempoMeses){
        double montante = capitalInicial*Math.pow((1+taxaJuros),tempoMeses);
        System.out.printf("O montante será %.2f\n", montante);
    }

    public static ContaPoupanca procuraContaPoupanca(int id) {
        for (ContaPoupanca a : contasPoupanca) {
            if(Conta.getNumeroConta(a)==id)
                return a;
        }
        return null;
    }

    public static void listaContasPoupanca(){
        if (contasPoupanca.isEmpty()) {
            System.out.println("Nao existem contas correntes poupanca no sistema");
        } else {
            for (Conta a : contasPoupanca) {
                System.out.println(a);
            }
        }
    }
}
