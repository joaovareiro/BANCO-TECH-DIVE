import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class Conta {
    private String nome;
    private String cpf;
    private double rendaMensal;
    private static int aux = 0;
    private int numeroConta = 0;
    private String agencia;
    private double saldo;
    protected double limite = 0;
    private static ArrayList<Conta> listaContas = new ArrayList<>();
    private ArrayList<Transacao> listaTransacoesCliente = new ArrayList<>();
    private static ArrayList<Transacao> listaTransacoesBanco = new ArrayList<>();
    private static ArrayList<Integer> listaNumerosConta = new ArrayList<Integer>();

    public Conta(String nome, String cpf1, double rendaMensal, String agencia, double saldo) {
        this.nome = nome;
        if (validarCPF(cpf1)) {
            this.cpf = cpf1;
        } else {
            solicitarCPF();
        }
        aux++;
        this.numeroConta = aux;
        this.rendaMensal = rendaMensal;
        if (validarAgencia(agencia)) {
            this.agencia = agencia;
        } else {
            solicitarAgencia();
        }
        this.saldo = saldo;
        listaContas.add(this);
        listaNumerosConta.add(this.numeroConta);
    }

    public boolean validarCPF(String cpf){
        int soma,d1,d2;
        try {
        if(cpf.length()!=11){
            return false;
        }
            ArrayList<Integer> cpfArrayList = new ArrayList<>();
            for(int i = 0;i<cpf.length();i++){
                cpfArrayList.add(Integer.parseInt(cpf.substring(i,i+1)));
            }
            soma = 0;
            for (int i = 0; i < 9; i++) {
                soma += cpfArrayList.get(i) * (10 - i);
            }
            d1 = 11 - (soma%11);
            if(d1>9){
                d1 = 0;
            }
            soma = 0;
            for (int i = 0; i < 10; i++) {
                soma += cpfArrayList.get(i) * (11 - i);
            }

            d2 = 11 - (soma%11);
            if(d2>9){
                d2 = 0;
            }

            if ((d1 == cpfArrayList.get(9)) && (d2 == cpfArrayList.get(10))) {
            return (true);
            } else {
            return (false);
            }
            } catch (InputMismatchException ERRO) {
                return (false);
            }
    }

    public void solicitarCPF() {
        Scanner sc = new Scanner(System.in);
        boolean cpfIncorreto = true;
        while (cpfIncorreto) {
            System.out.println("Por favor, digite um CPF valido");
            String cpfTeste = sc.next();
            if (validarCPF(cpfTeste) == true) {
                this.cpf = cpfTeste;
                cpfIncorreto = false;
            } else {
                cpfIncorreto = true;
            }
        }
    }

    public boolean validarAgencia(String agencia) {
        try {
            if ((agencia.equals("001")) || (agencia.equals("002"))) {
                return (true);
            } else {
                return (false);
            }
        } catch (InputMismatchException ERRO) {
            return (false);
        }
    }



    public void solicitarAgencia() {
        Scanner sc = new Scanner(System.in);
        boolean agenciaInvalida = true;
        while (agenciaInvalida) {
            System.out.println("Por favor, digite uma agencia valida");
            String agenciaTeste = sc.next();
            if (validarAgencia(agenciaTeste) == true) {
                this.agencia = agenciaTeste;
                agenciaInvalida = false;
            } else {
                agenciaInvalida = true;
            }
        }
    }

    public void saque(double decremento) {
        if (decremento <= (this.saldo + getLimite())) {
            this.saldo = this.saldo - decremento;
            Transacao s = new Transacao("saque", this.cpf, this.cpf, decremento);
            listaTransacoesCliente.add(s);
            listaTransacoesBanco.add(s);
            System.out.printf("Foi sacado o valor de : R$ %.2f\n",decremento);
        } else if (decremento < 0) {
            System.out.println("Valor invalido");
        } else {
            System.out.println("o saldo foi insuficiente");
        }
    }


    public int saqueInvestimento(double decremento) {
        if (this instanceof ContaInvestimento && (decremento > 0) && (decremento < this.saldo)) {
            this.saldo = this.saldo - decremento;
            System.out.printf("Foi investido o valor de : R$ %.2f\n", decremento);
            Transacao i = new Transacao("investimento", this.cpf, this.cpf, decremento);
            listaTransacoesCliente.add(i);
            listaTransacoesBanco.add(i);
            return 1;
        }else{
            System.out.println("saldo insuficiente");
            return 0;
        }
    }

    public void deposito(double incremento) {
        if (incremento > 0) {
            this.saldo = this.saldo + incremento;
            Transacao d = new Transacao("deposito", this.cpf, this.cpf, incremento);
            listaTransacoesCliente.add(d);
            listaTransacoesBanco.add(d);
            System.out.printf("Foi depositado o valor de : R$ %.2f\n",incremento);
        } else {
            System.out.println("Valor invalido");
        }
    }

    public void transferir(Conta c2, double valorTransferencia) {
        if (valorTransferencia <= (this.saldo + this.getLimite())) {
            this.saldo = this.saldo - valorTransferencia;
            c2.saldo = c2.saldo + valorTransferencia;
            Transacao t = new Transacao("transferencia", this.cpf, c2.cpf, valorTransferencia);
            System.out.printf("Foi transferido o valor de : R$ %.2f para a conta %d\n",valorTransferencia,c2.numeroConta);
            this.listaTransacoesCliente.add(t);
            c2.listaTransacoesCliente.add(t);
            listaTransacoesBanco.add(t);
        } else if (valorTransferencia < 0) {
            System.out.println("Valor invalido");
        } else {
            System.out.println("Saldo insuficiente para a transferencia");
        }
    }

    public void alteraDados(String nomeNovo, double rendaMensalNova, String agenciaNova) {
        this.nome = nomeNovo;
        this.rendaMensal = rendaMensalNova;
        if (validarAgencia(agenciaNova)) {
            this.agencia = agenciaNova;
        } else {
            solicitarAgencia();
        }
    }
    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getAgencia() {
        return agencia;
    }

    public double getRendaMensal() {
        return rendaMensal;
    }

    public double getLimite() {
        return limite;
    }

    public double getSaldo() {
        return saldo;
    }

    public static int getNumeroConta(Conta a) {
        return a.numeroConta;
    }

    public int getNumeroDaConta() {
        return numeroConta;
    }

    public static ArrayList<Transacao> getListaTransacoesBanco() {
        return listaTransacoesBanco;
    }

    public ArrayList<Transacao> getListaTransacoesCliente() {
        return listaTransacoesCliente;
    }

    public void extratoCliente() {
        for (Transacao a : this.getListaTransacoesCliente()) {
            System.out.println(a);
        }
        System.out.println("Saldo atual: " + this.getSaldo());
    }

    public void extratoSemSaldo() {
        int cont = 0;
        for (Transacao a : this.getListaTransacoesCliente()) {
            System.out.println(a);
            cont++;
        }
        if(cont == 0){
            System.out.println("Nao foram encontradas transacoes envolvendo essa conta");
        }
    }

    public static void extratoBanco() {
        for (Transacao a : Conta.getListaTransacoesBanco()) {
            System.out.println(a);
        }
    }

    public static void historicoTransacoesBanco() {
        Conta.extratoBanco();
    }

    public static void historicoTransacoesCliente(Conta c1) {
        c1.extratoCliente();
    }


    public static Conta procuraConta(int id) {
        for (Conta a : listaContas) {
            if(getNumeroConta(a)==id)
                return a;
            }
        return null;
    }

    public static void listaTudo() {
        for (Conta a : listaContas) {
            System.out.println(a);
        }
    }

    public static void listaTransacoesDoBanco(){
        if(listaTransacoesBanco.isEmpty()){
            System.out.println("Nao foram feitas transacoes ainda");
        }else{
        for (Transacao a : listaTransacoesBanco) {
            System.out.println(a);
            }
        }
    }
}

