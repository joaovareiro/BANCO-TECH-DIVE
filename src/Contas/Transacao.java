package Contas;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transacao {
    private String tipo;
    private String data;
    private String contaOrigem;
    private String contaDestino;
    private double valor;

    @Override
    public String toString() {

        return "tipo = '" + tipo + '\'' +
                ", data = '" + data + '\'' +
                ", contaOrigem = '" + contaOrigem + '\'' +
                ", contaDestino = '" + contaDestino + '\'' +
                ", valor = " + valor;
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
