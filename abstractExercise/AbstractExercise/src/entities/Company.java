package entities;

public final class Company extends TaxPayer{

    private int numberOfEmployees;

    public Company() {
        super();
    }

    public Company(String name, Double anualIncome, int numberOfEmployees) {
        super(name, anualIncome);
        this.numberOfEmployees = numberOfEmployees;
    }

    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(int numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    @Override
    public Double tax() {
        double resultado;

        if(numberOfEmployees > 10){
            resultado = getAnualIncome() * .14;
        }else{
            resultado = getAnualIncome() * .16;
        }

        return resultado;
    }
}
