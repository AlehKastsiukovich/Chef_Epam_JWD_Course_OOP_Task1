package by.javatraining.chef.entity.rootvegetable;

import by.javatraining.chef.entity.Vegetable;
import by.javatraining.chef.entity.VegetableColor;

public abstract class RootVegetable extends Vegetable {
    private double sugarPercent;

    public RootVegetable(double weight, double proteins, double carbohydrates,
                         double calories, VegetableColor color, double sugarPercent) {
        super(weight, proteins, carbohydrates, calories, color);
        this.sugarPercent = sugarPercent;
    }

    public double getSugarPercent() {
        return sugarPercent;
    }

    public void setSugarPercent(double sugarPercent) {
        this.sugarPercent = sugarPercent;
    }
}
