public class Main {
    public static void main(String[] args) {
        ContaCorrente cc1 = new ContaCorrente("Sophie Giovanna Caroline dos Santos", "96356223090", 1500.00, "001", 3445.79);
        ContaCorrente cc2 = new ContaCorrente("Bryan Kaique Duarte", "79514943058", 2000.49, "002", 4589.01);
        ContaCorrente cc3 = new ContaCorrente("Vitoria Maite Souza", "34038307808", 1500.55, "001",5480.12);
        ContaPoupanca cp1 = new ContaPoupanca("Benjamin Nelson Castro", "47047677011", 2023.20, "002", 4789.14);
        ContaPoupanca cp2 = new ContaPoupanca("Vitoria Maite Souza", "34038307808", 1500.10, "001",1397.45);
        ContaPoupanca cp3 = new ContaPoupanca("Yuri Rafael da Luz","79638395826",7812.45,"001",45000);
        ContaInvestimento ci1 = new ContaInvestimento("Marcela Bruna Nogueira","04277482830",12450.50,"001",78910.44);
        ContaInvestimento ci2 = new ContaInvestimento("Augusto Leandro Gustavo Gomes", "07376974822",2510,"002",6358.15);
        ContaInvestimento ci3 = new ContaInvestimento("Stefany Elza da Conceição","74010822767",2102.45,"001",3410.78);

        //MenuInicial.menuInicial();
        Conta.listaTudo();
    }
}