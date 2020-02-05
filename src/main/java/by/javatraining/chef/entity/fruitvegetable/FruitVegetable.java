package by.javatraining.chef.entity.fruitvegetable;

import by.javatraining.chef.entity.Vegetable;
import by.javatraining.chef.entity.VegetableColor;
import by.javatraining.chef.entity.fruitvegetable.fruitenum.SoilType;

public abstract class FruitVegetable extends Vegetable {
    private SoilType soilType;

    public FruitVegetable(double weight, double proteins, double carbohydrates,
                          double calories, VegetableColor color, SoilType soilType) {
        super(weight, proteins, carbohydrates, calories, color);

        if (soilType == null) {
            throw new NullPointerException();
        }

        this.soilType = soilType;
    }

    public SoilType getSoilType() {
        return soilType;
    }

    public void setSoilType(SoilType soilType) {
        if (soilType == null) {
            throw new NullPointerException();
        }

        this.soilType = soilType;
    }
}
