package by.javatraining.chef.entity.fruitvegetable;

import by.javatraining.chef.entity.VegetableColor;
import by.javatraining.chef.entity.fruitvegetable.fruitenum.PepperVariety;
import by.javatraining.chef.entity.fruitvegetable.fruitenum.SoilType;
import static java.lang.Math.*;

public class Pepper extends FruitVegetable {
    private PepperVariety pepperVariety;
    private static final int PEPPER_MAX_WEIGHT = 120;
    private static final double CALORIES = 27;
    private static final double PROTEINS = 1.3;
    private static final double CARBOHYDRATES = 5.3;

    public Pepper() {
        super(random() * PEPPER_MAX_WEIGHT, PROTEINS, CARBOHYDRATES,
                    CALORIES, VegetableColor.RED, SoilType.OPEN);
        this.pepperVariety = PepperVariety.CAYENNE;
    }

    public Pepper(PepperVariety pepperVariety) {
        super(random() * PEPPER_MAX_WEIGHT, PROTEINS, CARBOHYDRATES,
                CALORIES, VegetableColor.RED, SoilType.OPEN);
        this.pepperVariety = pepperVariety;
    }

    public PepperVariety getPepperVariety() {
        return pepperVariety;
    }

    public void setPepperVariety(PepperVariety pepperVariety) {
        this.pepperVariety = pepperVariety;
    }

    public boolean equals(Object object) {
        if (this == object)
            return true;
        if (object == null)
            return false;
        if (this.getClass() != object.getClass())
            return false;
        Pepper pepper = (Pepper) object;
        if (Double.compare(this.getProteins(), pepper.getProteins()) != 0
                || Double.compare(this.getCarbohydrates(), pepper.getCarbohydrates()) != 0
                || Double.compare(this.getCalories(), pepper.getCalories()) != 0
                || Double.compare(this.getWeight(), pepper.getWeight()) != 0
                || this.getSoilType() != pepper.getSoilType()
                || this.getPepperVariety() != pepper.getPepperVariety())
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
        hash = 31 * hash + (pepperVariety == null ? 0 : pepperVariety.hashCode());

        return hash;
    }
}
