public class Main {
    public static void main(String[] args) {
        ContaCorrente c1 = new ContaCorrente("Joao", "96356223090", 1500, "001", 3000);
        ContaCorrente c2 = new ContaCorrente("Raul", "79514943058", 2000, "002", 4500);
        ContaPoupanca c3 = new ContaPoupanca("Raul", "79514943058", 2000, "002", 4500);
        c1.transferir(c2,5000);
        c1.extratoCliente();
    }
}