package applications;

import entities.TaxPayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        TaxPayer tp;
        List<TaxPayer> taxPayers = new ArrayList<>();

        int n;
        System.out.print("Quantos contribuintes você vai digitar? ");
        n = sc.nextInt();
        while (n <= 0){
            System.out.print("Ao menos 1 contribuinte deve ser informado: ");
            n = sc.nextInt();
        }

        System.out.println();
        sc.nextLine();
        for (int i = 0; i < n ; i++){
            tp = new TaxPayer();
            System.out.printf("Digite os dados do %do contribuinte:%n", i + 1);
            System.out.print("Renda anual com salário: ");
            tp.setSalaryIncome(sc.nextDouble());
            System.out.print("Renda anual com prestação de serviço: ");
            tp.setServicesIncome(sc.nextDouble());
            System.out.print("Renda anual com ganho de capital: ");
            tp.setCapitalIncome(sc.nextDouble());
            System.out.print("Gastos médicos: ");
            tp.setHealthSpending(sc.nextDouble());
            System.out.print("Gastos educacionais: ");
            tp.setEducationSpending(sc.nextDouble());
            sc.nextLine();

            taxPayers.add(tp);
            System.out.println();
        }

        for (int i = 0; i < taxPayers.size(); i++) {
            System.out.printf("Resumo do %do contribuinte:%n", i + 1);
            System.out.printf("Imposto bruto total: %.2f%n", taxPayers.get(i).grossTax());
            System.out.printf("Abatimento: %.2f%n", taxPayers.get(i).taxRebate());
            System.out.printf("Imposto devido: %.2f%n", taxPayers.get(i).netTax());
            System.out.println();
        }
    }
}
