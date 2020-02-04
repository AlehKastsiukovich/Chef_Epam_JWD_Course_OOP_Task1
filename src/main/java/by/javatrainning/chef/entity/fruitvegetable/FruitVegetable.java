package by.javatrainning.chef.entity.fruitvegetable;

import by.javatrainning.chef.entity.Vegetable;
import by.javatrainning.chef.entity.VegetableColor;
import by.javatrainning.chef.entity.fruitvegetable.fruitenum.SoilType;

public abstract class FruitVegetable extends Vegetable {
    private SoilType soilType;

    public FruitVegetable(double weight, double proteins, double carbohydrates,
                          double calories, VegetableColor color, SoilType soilType) {
        super(weight, proteins, carbohydrates, calories, color);
        this.soilType = soilType;
    }

    public SoilType getSoilType() {
        return soilType;
    }

    public void setSoilType(SoilType soilType) {
        this.soilType = soilType;
    }
}
