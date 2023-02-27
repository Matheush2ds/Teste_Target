public class Distribuidora {

    public static void main(String[] args) {
        // Valores de faturamento mensal por estado
        double sp = 67836.43;
        double rj = 36678.66;
        double mg = 29229.88;
        double es = 27165.48;
        double outros = 19849.53;

        // Valor total mensal da distribuidora
        double total = sp + rj + mg + es + outros;

        // Percentual de representação de cada estado
        double sp_perc = (sp / total) * 100;
        double rj_perc = (rj / total) * 100;
        double mg_perc = (mg / total) * 100;
        double es_perc = (es / total) * 100;
        double outros_perc = (outros / total) * 100;

        // Exibição dos percentuais de representação de cada estado
        System.out.println("Percentual de representação de cada estado:");
        System.out.println("SP: " + String.format("%.2f", sp_perc) + "%");
        System.out.println("RJ: " + String.format("%.2f", rj_perc) + "%");
        System.out.println("MG: " + String.format("%.2f", mg_perc) + "%");
        System.out.println("ES: " + String.format("%.2f", es_perc) + "%");
        System.out.println("Outros: " + String.format("%.2f", outros_perc) + "%");
    }
}