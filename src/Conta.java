import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Conta {
    private String nome;
    private String cpf;
    private double rendaMensal;
    private int numeroConta=0;
    private String agencia;
    private double saldo;


    ArrayList<Transacao>listaTransacoes = new ArrayList<Transacao>();

    class Transacao{
        private String data;
        private String contaOrigem;
        private String contaDestino;
        private double valor;

        public Transacao(String ContaOrigem,String contaDestino,double valor) {
            this.contaOrigem = contaOrigem;
            this.contaDestino = contaDestino;
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
        this.saldo = this.saldo - decremento;
        Transacao s = new Transacao(this.nome, this.nome, decremento);
        listaTransacoes.add(s);
    }

    public void deposito(double incremento){
        this.saldo = this.saldo + incremento;
        Transacao d = new Transacao(this.nome, this.nome, incremento);
        listaTransacoes.add(d);
    }

    public void transferir(Conta c1, Conta c2, double valor){
        c1.saldo = c1.saldo - valor;
        c2.saldo = c2.saldo + valor;
        Transacao t = new Transacao(c1.nome, c2.nome, valor);
        listaTransacoes.add(t);
    }



    public void imprimeSaldo(){
        System.out.println("Saldo atual: " + this.saldo);
    }

}
