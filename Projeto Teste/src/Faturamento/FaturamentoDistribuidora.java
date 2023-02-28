import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class FaturamentoDistribuidora {

    public static void main(String[] args) {
        Gson gson = new Gson();
        List<FaturamentoDiario> faturamento = new ArrayList<>();
        try {
            faturamento = gson.fromJson(new FileReader("faturamento.json"), new TypeToken<List<FaturamentoDiario>>() {}.getType());
        } catch (IOException e) {
            e.printStackTrace();
        }

        double menorValor = Double.MAX_VALUE;
        double maiorValor = Double.MIN_VALUE;
        double totalFaturado = 0.0;
        int diasComFaturamentoAcimaDaMedia = 0;
        int diasComFaturamento = 0;

        for (FaturamentoDiario dia : faturamento) {
            if (dia.getValor() > maiorValor) {
                maiorValor = dia.getValor();
            }
            if (dia.getValor() < menorValor && dia.getValor() > 0.0) {
                menorValor = dia.getValor();
            }
            if (dia.getValor() > 0.0) {
                totalFaturado += dia.getValor();
                diasComFaturamento++;
            }
        }

        double mediaFaturamento = totalFaturado / diasComFaturamento;

        for (FaturamentoDiario dia : faturamento) {
            if (dia.getValor() > mediaFaturamento) {
                diasComFaturamentoAcimaDaMedia++;
            }
        }

        System.out.println("Menor valor de faturamento: R$" + menorValor);
        System.out.println("Maior valor de faturamento: R$" + maiorValor);
        System.out.println("Número de dias com faturamento acima da média mensal: " + diasComFaturamentoAcimaDaMedia);
    }

}

class FaturamentoDiario {
    private int dia;
    private double valor;

    public int getDia() {
        return dia;
    }

    public double getValor() {
        return valor;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}