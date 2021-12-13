package Menus;

import Contas.Conta;
import Contas.ContaCorrente;
import Contas.ContaInvestimento;
import Contas.ContaPoupanca;

import java.util.Scanner;

public abstract class MenuOperacoes {
    static Scanner sc = new Scanner(System.in);

    public static void login(int id) {
        while (true) {
            Conta b = Conta.procuraConta(id);
            if (b != null) {
                MenuOperacoes.menuOperacoes(b,id);
                break;
            } else {
                System.out.println("A conta inserida nao foi encontrada");
                break;
            }
        }
    }
    public static void menuOperacoes(Conta a, int id){
        if(a instanceof ContaCorrente){
            ContaCorrente cc = ContaCorrente.procuraContaCorrente(id);
            MenuOperacoesCorrente.menuOperacoesCorrente(cc);
        }else if(a instanceof ContaPoupanca){
            ContaPoupanca cp = ContaPoupanca.procuraContaPoupanca(id);
            MenuOperacoesPoupanca.menuOperacoesPoupanca(cp);
        }else if(a instanceof ContaInvestimento){
            ContaInvestimento ci = ContaInvestimento.procuraContaInvestimento(id);
            MenuOperacoesInvestimento.menuOperacoesCorrente(ci);
        }
    }


}
