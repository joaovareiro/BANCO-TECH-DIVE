public class Main {
    public static void main(String[] args) {
        Conta c1 = new Conta("joao","96356223090",1500,"CG",3000);
        Conta c2 = new Conta("Raul","79514943058",2000,"BH",4500);

        c1.transferir(c1,c2,500);
        c1.imprimeSaldo();
        c2.imprimeSaldo();
    }
}
