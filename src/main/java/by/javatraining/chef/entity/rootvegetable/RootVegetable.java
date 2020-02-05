package by.javatraining.chef.entity.rootvegetable;

import by.javatraining.chef.entity.Vegetable;
import by.javatraining.chef.entity.VegetableColor;

public abstract class RootVegetable extends Vegetable {
    private double sugarPercent;

    public RootVegetable(double weight, double proteins, double carbohydrates,
                         double calories, VegetableColor color, double sugarPercent) {
        super(weight, proteins, carbohydrates, calories, color);

        if (!(sugarPercent > 0 && sugarPercent < 100)) {
            throw new IllegalArgumentException();
        }

        this.sugarPercent = sugarPercent;
    }

    public double getSugarPercent() {
        return sugarPercent;
    }

    public void setSugarPercent(double sugarPercent) {
        if (!(sugarPercent > 0 && sugarPercent < 100)) {
            throw new IllegalArgumentException();
        }

        this.sugarPercent = sugarPercent;
    }
}
