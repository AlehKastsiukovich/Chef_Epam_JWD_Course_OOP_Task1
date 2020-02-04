package by.javatrainning.chef.entity.fruitvegetable;

import by.javatrainning.chef.entity.VegetableColor;
import by.javatrainning.chef.entity.fruitvegetable.fruitenum.CucumberVariety;
import by.javatrainning.chef.entity.fruitvegetable.fruitenum.SoilType;
import java.util.Random;

public class Cucumber extends FruitVegetable {
    private CucumberVariety cucumberVariety;
    private static final int CUCUMBER_MAX_WEIGHT = 126;
    private static final double CALORIES = 14;
    private static final double PROTEINS = 0.8;
    private static final double CARBOHYDRATES = 2.5;

    public Cucumber() {
        super(Math.random() * CUCUMBER_MAX_WEIGHT, PROTEINS, CARBOHYDRATES,
                CALORIES, VegetableColor.GREEN, SoilType.OPEN);
        this.cucumberVariety = CucumberVariety.GHERKIN;
    }

    public Cucumber(CucumberVariety cucumberVariety) {
        super(Math.random() * CUCUMBER_MAX_WEIGHT, PROTEINS, CARBOHYDRATES,
                CALORIES, VegetableColor.GREEN, SoilType.OPEN);
        this.cucumberVariety = cucumberVariety;
    }

    public CucumberVariety getCucumberVariety() {
        return cucumberVariety;
    }

    public void setCucumberVariety(CucumberVariety cucumberVariety) {
        this.cucumberVariety = cucumberVariety;
    }

    public boolean equals(Object object) {
        if (this == object)
            return true;
        if (object == null)
            return false;
        if (this.getClass() != object.getClass())
            return false;
        Cucumber cucumber = (Cucumber) object;
        if (Double.compare(this.getProteins(), cucumber.getProteins()) != 0
                || Double.compare(this.getCarbohydrates(), cucumber.getCarbohydrates()) != 0
                || Double.compare(this.getCalories(), cucumber.getCalories()) != 0
                || Double.compare(this.getWeight(), cucumber.getWeight()) != 0
                || this.getSoilType() != cucumber.getSoilType()
                || this.getCucumberVariety() != cucumber.getCucumberVariety())
            return false;
        return true;
    }

    public int hashCode() {
        int hash = 7;
        long lb1 = Double.doubleToLongBits(this.getWeight());
        hash = 31 * hash + (int) (lb1 - (lb1 >>> 32));
        long lb2 = Double.doubleToLongBits(this.getProteins());
        hash = 31 * hash + (int) (lb2 - (lb2 >>> 31));
        long lb3 = Double.doubleToLongBits(this.getCalories());
        hash = 31 * hash + (int) (lb3 - (lb3 >>> 31));
        long lb4 = Double.doubleToLongBits(this.getCarbohydrates());
        hash = 31 * hash + (int) (lb4 - (lb4 >>> 31));
        hash = 31 * hash + (cucumberVariety == null ? 0 : cucumberVariety.hashCode());

        return hash;
    }
}
