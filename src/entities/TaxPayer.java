package entities;

public class TaxPayer {

    private double salaryIncome;
    private double servicesIncome;
    private double capitalIncome;
    private double healthSpending;
    private double educationSpending;

    public TaxPayer() {
    }

    public double getSalaryIncome() {
        return salaryIncome;
    }

    public void setSalaryIncome(double salaryIncome) {
        this.salaryIncome = salaryIncome;
    }

    public double getServicesIncome() {
        return servicesIncome;
    }

    public void setServicesIncome(double servicesIncome) {
        this.servicesIncome = servicesIncome;
    }

    public double getCapitalIncome() {
        return capitalIncome;
    }

    public void setCapitalIncome(double capitalIncome) {
        this.capitalIncome = capitalIncome;
    }

    public double getHealthSpending() {
        return healthSpending;
    }

    public void setHealthSpending(double healthSpending) {
        this.healthSpending = healthSpending;
    }

    public double getEducationSpending() {
        return educationSpending;
    }

    public void setEducationSpending(double educationSpending) {
        this.educationSpending = educationSpending;
    }

    public double salaryTax(){
        if (getSalaryIncome() / 12 < 3000.00) {
            return 0;
        }
        else if ((getSalaryIncome() / 12 > 3000.00) && ( getSalaryIncome() / 12 < 5000.00)) {
            return getSalaryIncome() * 0.10;
        }
        else {
            return getSalaryIncome() * 0.20;
        }
   }

    public double servicesTax(){
        if (getServicesIncome() > 0.00) {
            return getServicesIncome() * 0.15;
        } else {
            return getServicesIncome() * 0;
        }
    }

    public double capitalTax(){
        if (getCapitalIncome() > 0.00) {
            return getCapitalIncome() * 0.20;
        }
        else {
            return 0;
        }
    }

    public double grossTax(){
        return salaryTax() + servicesTax() + capitalTax();
    }

    public double taxRebate() {
        return Math.min(grossTax() * 0.30, getHealthSpending() + getEducationSpending() );
    }

    public double netTax() {
        return grossTax()-taxRebate();
    }
}