package by.javatraining.chef.entity.rootvegetable;

import by.javatraining.chef.entity.VegetableColor;
import by.javatraining.chef.entity.rootvegetable.rootenum.CarrotVariety;

public class Carrot extends RootVegetable {
    private CarrotVariety carrotVariety;
    private static final double SUGAR_PERCENT = 10;
    private static final int CARROT_MAX_WEIGHT = 300;
    private static final double CALORIES = 32;
    private static final double PROTEINS = 1.3;
    private static final double CARBOHYDRATES = 6.9;

    public Carrot() {
        super(Math.random() * CARROT_MAX_WEIGHT, PROTEINS, CARBOHYDRATES,
                CALORIES, VegetableColor.ORANGE, SUGAR_PERCENT);
        this.carrotVariety = CarrotVariety.IMPERATOR;
    }

    public Carrot(CarrotVariety carrotVariety) {
        super(Math.random() * CARROT_MAX_WEIGHT, PROTEINS, CARBOHYDRATES,
                CALORIES, VegetableColor.ORANGE, SUGAR_PERCENT);

        if (carrotVariety == null) {
            throw new NullPointerException();
        }

        this.carrotVariety = carrotVariety;
    }

    public CarrotVariety getCarrotVariety() {
        return carrotVariety;
    }

    public void setCarrotVariety(CarrotVariety carrotVariety) {
        if (carrotVariety == null) {
            throw new NullPointerException();
        }

        this.carrotVariety = carrotVariety;
    }

    public boolean equals(Object object) {
        if (this == object)
            return true;
        if (object == null)
            return false;
        if (this.getClass() != object.getClass())
            return false;
        Carrot carrot = (Carrot) object;
        if (Double.compare(this.getProteins(), carrot.getProteins()) != 0
                || Double.compare(this.getCarbohydrates(), carrot.getCarbohydrates()) != 0
                || Double.compare(this.getCalories(), carrot.getCalories()) != 0
                || Double.compare(this.getWeight(), carrot.getWeight()) != 0
                || Double.compare(this.getSugarPercent(), carrot.getSugarPercent()) != 0
                || this.getCarrotVariety() != carrot.getCarrotVariety())
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
        hash = 31 * hash + (carrotVariety == null ? 0 : carrotVariety.hashCode());

        return hash;
    }
}
