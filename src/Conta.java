import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public abstract class Conta {
    private String nome;
    private String cpf;
    private double rendaMensal;
    private int numeroConta=0;
    private String agencia;
    private double saldo;
    private ArrayList<Transacao>listaTransacoes = new ArrayList<>();
    private final double limite = 0.0;

    class Transacao{
        private String tipo;
        private String data;
        private String contaOrigem;
        private String contaDestino;
        private double valor;

        @Override
        public String toString() {
            return data +" " + tipo +
                    " conta de origem = " + contaOrigem +
                    " ,conta de destino = " + contaDestino +
                    " ,valor = " + valor;
        }

        public Transacao(String tipo, String origem, String destino, double valor) {
            this.tipo = tipo;
            this.contaOrigem = origem;
            this.contaDestino = destino;
            LocalDateTime a = LocalDateTime.now();
            DateTimeFormatter b = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            this.data = a.format(b);
            this.valor = valor;


        }
    }

    Conta(String nome,String cpf,double rendaMensal,String agencia,double saldo){
        numeroConta++;
        this.nome = nome;
        this.rendaMensal = rendaMensal;
        this.numeroConta = numeroConta;
        this.agencia = agencia;
        this.saldo = saldo;

        if(validarCPF(cpf)){
            this.cpf = cpf;
        }else{
            solicitarCPF();
        }

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

    public void saque(double decremento){
        if(decremento <= (this.saldo + getLimite())){
            this.saldo = this.saldo - decremento;
        }else{
            System.out.println("o saldo foi insuficiente");
        }
        Transacao s = new Transacao("saque",this.nome, this.nome, decremento);
        listaTransacoes.add(s);
    }



    public void deposito(double incremento){
        this.saldo = this.saldo + incremento;
        Transacao d = new Transacao("deposito",this.nome, this.nome, incremento);
        listaTransacoes.add(d);
    }

    public void transferir(Conta c1, Conta c2, double valor){
        c1.saldo = c1.saldo - valor;
        c2.saldo = c2.saldo + valor;
        Transacao t = new Transacao("transferencia",c1.nome, c2.nome, valor);
        listaTransacoes.add(t);
    }

    public void alteraDados(String nome, double rendaMensal,String agencia) {
        this.nome = nome;
        this.rendaMensal = rendaMensal;
        this.agencia = agencia;
    }

    public void imprimeSaldo(){
        System.out.println("Saldo atual: " + this.saldo);
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

    public ArrayList<Transacao> getListaTransacoes() {
        return listaTransacoes;
    }

    public void extrato(){
        for (Conta.Transacao a : this.getListaTransacoes()) {
            System.out.println(a);
        }
        System.out.println("Saldo atual: " + this.getSaldo());
    }

}
