package by.javatraining.chef.entity.rootvegetable;

import by.javatraining.chef.entity.VegetableColor;
import by.javatraining.chef.entity.rootvegetable.rootenum.RadishVariety;

public class Radish extends RootVegetable {
    private RadishVariety variety;
    private static final int RADISH_MAX_WEIGHT = 400;
    private static final double SUGAR_PERCENT = 10;
    private static final double CALORIES = 12;
    private static final double PROTEINS = 0.9;
    private static final double CARBOHYDRATES = 2.1;

    public Radish() {
        super(Math.random() * RADISH_MAX_WEIGHT, PROTEINS, CARBOHYDRATES,
                CALORIES, VegetableColor.PINK, SUGAR_PERCENT);
        this.variety = RadishVariety.APRIL_CROSS;
    }

    public Radish(RadishVariety variety) {
        super(Math.random() * RADISH_MAX_WEIGHT, PROTEINS, CARBOHYDRATES,
                CALORIES, VegetableColor.PINK, SUGAR_PERCENT);

        if (variety == null) {
            throw new NullPointerException();
        }

        this.variety = variety;
    }

    public RadishVariety getRadishVariety() {
        return variety;
    }

    public void setVariety(RadishVariety variety) {
        if (variety == null) {
            throw new NullPointerException();
        }

        this.variety = variety;
    }

    public boolean equals(Object object) {
        if (this == object)
            return true;
        if (object == null)
            return false;
        if (this.getClass() != object.getClass())
            return false;
        Radish radish = (Radish) object;
        if (Double.compare(this.getProteins(), radish.getProteins()) != 0
                || Double.compare(this.getCarbohydrates(), radish.getCarbohydrates()) != 0
                || Double.compare(this.getCalories(), radish.getCalories()) != 0
                || Double.compare(this.getWeight(), radish.getWeight()) != 0
                || Double.compare(this.getSugarPercent(), radish.getSugarPercent()) != 0
                || this.getRadishVariety() != radish.getRadishVariety())
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
        hash = 31 * hash + (variety == null ? 0 : variety.hashCode());

        return hash;
    }
}
