import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class Conta {
    private String nome;
    private String cpf;
    private double rendaMensal;
    private int numeroConta = 0;
    private String agencia;
    private double saldo;
    protected double limite = 0;
    private ArrayList<Transacao> listaTransacoesCliente = new ArrayList<>();
    private static ArrayList<Transacao> listaTransacoesBanco = new ArrayList<>();

    public Conta(String nome, String cpf, double rendaMensal, String agencia, double saldo) {
        numeroConta++;
        this.nome = nome;
        if (validarCPF(cpf)==true) {
            this.cpf = cpf;
        } else {
            solicitarCPF();
        }
        this.numeroConta = getNumeroConta();
        this.rendaMensal = rendaMensal;
        if(validarAgencia(agencia)==true){
            this.agencia = agencia;
        }else{
            solicitarAgencia();
        }
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return  "nome:" + nome +
                ", cpf:" + cpf +
                ", rendaMensal: " + rendaMensal +
                ", numeroConta: " + numeroConta +
                ", agencia: " + agencia  +
                ", saldo: " + saldo +
                ", limite: " + limite;
    }

    public boolean validarCPF(String CPF) {
        if (CPF.equals("00000000000") || CPF.equals("11111111111") || CPF.equals("22222222222")
                || CPF.equals("33333333333") || CPF.equals("44444444444") || CPF.equals("55555555555")
                || CPF.equals("66666666666") || CPF.equals("77777777777") || CPF.equals("88888888888")
                || CPF.equals("99999999999") || (CPF.length() != 11))
        {
            return (false);
        }else{

            char d10, d11;
            int soma, i, r, num, peso;

            try {
                soma = 0;
                peso = 10;
                for (i = 0; i < 9; i++) {
                    num = (int) (CPF.charAt(i) - 48);
                    soma = soma + (num * peso);
                    peso = peso - 1;
                }

                r = 11 - (soma % 11);
                if ((r == 10) || (r == 11)) {
                    d10 = '0';
                } else {
                    d10 = (char) (r + 48);
                }

                soma = 0;
                peso = 11;
                for (i = 0; i < 10; i++) {
                    num = (int) (CPF.charAt(i) - 48);
                    soma = soma + (num * peso);
                    peso = peso - 1;
                }

                r = 11 - (soma % 11);
                if ((r == 10) || (r == 11)){
                    d11 = '0';
                }else{
                    d11 = (char) (r + 48);
                }

                if ((d10 == CPF.charAt(9)) && (d11 == CPF.charAt(10))) {
                    return (true);
                }else {
                    return (false);
                }
            } catch (InputMismatchException ERRO) {
                return (false);
            }
        }
    }

    public void solicitarCPF(){
        Scanner sc = new Scanner(System.in);
        boolean cpfIncorreto = true;
        while(cpfIncorreto){
            System.out.println("Por favor, digite um CPF valido");
            String cpfTeste = sc.next();
            if(validarCPF(cpfTeste)==true){
                this.cpf = cpfTeste;
                cpfIncorreto = false;
            }else{
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

    public void saque(double decremento){
        if(decremento <= (this.saldo + getLimite())){
            this.saldo = this.saldo - decremento;
        }else{
            System.out.println("o saldo foi insuficiente");
        }
        Transacao s = new Transacao("saque",this.cpf, this.cpf, decremento);
        listaTransacoesCliente.add(s);
        listaTransacoesBanco.add(s);
    }

    public void deposito(double incremento){
        this.saldo = this.saldo + incremento;
        Transacao d = new Transacao("deposito",this.cpf, this.cpf, incremento);
        listaTransacoesCliente.add(d);
        listaTransacoesBanco.add(d);
    }

    public void transferir(Conta c2, double valorTransferencia) {
        if (valorTransferencia <= (this.saldo + this.getLimite())) {
            this.saldo = this.saldo - valorTransferencia;
            c2.saldo = c2.saldo + valorTransferencia;
            Transacao t = new Transacao("transferencia", this.cpf, c2.cpf, valorTransferencia);
            this.listaTransacoesCliente.add(t);
            c2.listaTransacoesCliente.add(t);
            listaTransacoesBanco.add(t);
        } else {
            System.out.println("Saldo insuficiente para a transferencia");
        }
    }
    public void alteraDados(String nome, String cpf, double rendaMensal, String agencia) {
        this.nome = nome;
        this.rendaMensal = rendaMensal;
        if(validarAgencia(agencia)){
            this.agencia = agencia;
        }else{
            solicitarAgencia();
        }
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

    public int getNumeroConta() {
        return numeroConta;
    }

    public static ArrayList<Transacao> getListaTransacoesBanco() {
        return listaTransacoesBanco;
    }

    public ArrayList<Transacao> getListaTransacoesCliente() {
        return listaTransacoesCliente;
    }

    public void extratoCliente(){
        for (Transacao a : this.getListaTransacoesCliente()) {
            System.out.println(a);
        }
        System.out.println("Saldo atual: " + this.getSaldo());
    }

    public static void extratoBanco(){
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

}