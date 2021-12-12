import java.util.Scanner;

public abstract class MenuInicial {
    static Scanner sc= new Scanner(System.in);
    public static void menuInicial(){
        int op;
        while(true) {
        System.out.println("-----BANCO TECH-DIVE-----");
        System.out.println("""
                    Selecione uma opcao:\s
                    1 - Cadastrar contas
                    2 - Efetuar operacoes
                    3 - Acessar relatorios
                    4 - Sair da aplicacao """);

        op = sc.nextInt();
        if (op == 1) {
            MenuCriacao.menuCriacao();
        }else if(op == 2) {
            MenuOperacoes.login();
        }else if (op ==3 ){
            MenuRelatorios.menuRelatorios();
        }else if (op == 4){
            break;
            }
        break;
        }
    }
}
