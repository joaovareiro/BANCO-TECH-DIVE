public class Main {
    public static void main(String[] args) {
        ContaPoupanca c1 = new ContaPoupanca("Joao", "96356223090", 1500, "001", 3000);
        ContaPoupanca c2 = new ContaPoupanca("Raul", "79514943058", 2000, "002", 4500);
        c1.saque(100);
        c1.deposito(500);
        c1.transferir(c1,c2,500);
        c1.extrato();
    }
}
