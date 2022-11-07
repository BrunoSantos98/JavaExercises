package entities;

public final class Individual extends TaxPayer{

    private Double healthExpenditures;

    public Individual() {
        super();
    }

    public Individual(String name, Double anualIncome, Double healthExpenditures) {
        super(name, anualIncome);
        this.healthExpenditures = healthExpenditures;
    }

    public Double getHealthExpenditures() {
        return healthExpenditures;
    }

    public void setHealthExpenditures(Double healthExpenditures) {
        this.healthExpenditures = healthExpenditures;
    }

    @Override
    public Double tax() {
        double resultado;
        if(getAnualIncome() < 20000){
            resultado =  (getAnualIncome() * .15) - (healthExpenditures * .5);
        }else{
            resultado = (getAnualIncome() * .25) - (healthExpenditures * .5);
        }
        return  resultado;
    }
}
