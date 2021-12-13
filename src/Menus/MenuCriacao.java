package Menus;

import Contas.Conta;
import Contas.ContaCorrente;
import Contas.ContaInvestimento;
import Contas.ContaPoupanca;

import java.util.Scanner;

public class MenuCriacao {
    static Scanner sc= new Scanner(System.in);
    public static void menuCriacao(){
        int op;
        while(true) {
        System.out.println("""
                    Selecione o tipo de conta:\s
                    1 - Conta Corrente
                    2 - Conta Investimento
                    3 - Conta poupanca
                    4 - Voltar para o menu inicial """);
            op = sc.nextInt();
            if (op == 4) {
                break;
            }else{
                System.out.printf("Digite o nome da conta \n");
                sc.nextLine();
                String nomeNovo = sc.nextLine();

                System.out.printf("Digite o cpf da conta (apenas os numeros) \n");
                String cpfNovo = sc.nextLine();
                System.out.println("Digite a renda mensal da conta ");
                double rendaMensalNova = sc.nextDouble();

                System.out.println("Digite a agencia da conta ");
                sc.nextLine();
                String agenciaNova = sc.nextLine();

                System.out.println("Digite o saldo inicial da conta ");
                double saldoInicial = sc.nextDouble();
            if(op == 1){
                ContaCorrente a = new ContaCorrente(nomeNovo, cpfNovo, rendaMensalNova, agenciaNova, saldoInicial);
            }if(op == 2){
                ContaInvestimento a = new ContaInvestimento(nomeNovo, cpfNovo, rendaMensalNova, agenciaNova, saldoInicial);
            }if(op == 3){
                ContaPoupanca a = new ContaPoupanca(nomeNovo, cpfNovo, rendaMensalNova, agenciaNova, saldoInicial);
                }
            }
        }
    }
}

