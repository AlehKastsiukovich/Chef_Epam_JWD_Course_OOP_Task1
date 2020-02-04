package by.javatrainning.chef.entity.fruitvegetable;

import by.javatrainning.chef.entity.VegetableColor;
import by.javatrainning.chef.entity.fruitvegetable.fruitenum.SoilType;
import by.javatrainning.chef.entity.fruitvegetable.fruitenum.TomatoVariety;

public class Tomato extends FruitVegetable {
    private TomatoVariety tomatoVariety;
    private static final int TOMATO_MAX_WEIGHT = 140;
    private static final double CALORIES = 24;
    private static final double PROTEINS = 1.1;
    private static final double CARBOHYDRATES = 3.8;

    public Tomato() {
        super(Math.random() * TOMATO_MAX_WEIGHT, PROTEINS, CARBOHYDRATES,
                CALORIES, VegetableColor.RED, SoilType.OPEN);
        this.tomatoVariety = TomatoVariety.CHERRY;
    }

    public Tomato(TomatoVariety tomatoVariety) {
        super(Math.random() * TOMATO_MAX_WEIGHT, PROTEINS, CARBOHYDRATES,
                CALORIES, VegetableColor.RED, SoilType.OPEN);
        this.tomatoVariety = tomatoVariety;
    }

    public TomatoVariety getTomatoVariety() {
        return tomatoVariety;
    }

    public void setTomatoVariety(TomatoVariety tomatoVariety) {
        this.tomatoVariety = tomatoVariety;
    }

    public boolean equals(Object object) {
        if (this == object)
            return true;
        if (object == null)
            return false;
        if (this.getClass() != object.getClass())
            return false;
        Tomato tomato = (Tomato) object;
        if (Double.compare(this.getProteins(), tomato.getProteins()) != 0
                || Double.compare(this.getCarbohydrates(), tomato.getCarbohydrates()) != 0
                || Double.compare(this.getCalories(), tomato.getCalories()) != 0
                || Double.compare(this.getWeight(), tomato.getWeight()) != 0
                || this.getSoilType() != tomato.getSoilType()
                || this.getTomatoVariety() != tomato.getTomatoVariety())
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
        hash = 31 * hash + (tomatoVariety == null ? 0 : tomatoVariety.hashCode());

        return hash;
    }
}
