package by.javatrainning.chef.entity.leafyvegetable;

import by.javatrainning.chef.entity.VegetableColor;
import by.javatrainning.chef.entity.leafyvegetable.leafyenum.LeafyVegetableType;
import by.javatrainning.chef.entity.leafyvegetable.leafyenum.SpinachVariety;

public class Spinach extends LeafyVegetable {
    private SpinachVariety spinachVariety;
    private static final int SPINACH_MAX_WEIGHT = 125;
    private static final double CALORIES = 23;
    private static final double PROTEINS = 2.9;
    private static final double CARBOHYDRATES = 2.0;

    public Spinach() {
        super(Math.random() * SPINACH_MAX_WEIGHT, PROTEINS, CARBOHYDRATES,
                CALORIES, VegetableColor.GREEN, LeafyVegetableType.LEAFY);
        this.spinachVariety = SpinachVariety.CATOLINA;
    }

    public Spinach(SpinachVariety variety) {
        super(Math.random() * SPINACH_MAX_WEIGHT, PROTEINS, CARBOHYDRATES,
                CALORIES, VegetableColor.GREEN, LeafyVegetableType.LEAFY);
        this.spinachVariety = variety;
    }

    public SpinachVariety getSpinachVariety() {
        return spinachVariety;
    }

    public void setSpinachVariety(SpinachVariety spinachVariety) {
        this.spinachVariety = spinachVariety;
    }

    public boolean equals(Object object) {
        if (this == object)
            return true;
        if (object == null)
            return false;
        if (this.getClass() != object.getClass())
            return false;
        Spinach spinach = (Spinach) object;
        if (Double.compare(this.getProteins(), spinach.getProteins()) != 0
                || Double.compare(this.getCarbohydrates(), spinach.getCarbohydrates()) != 0
                || Double.compare(this.getCalories(), spinach.getCalories()) != 0
                || Double.compare(this.getWeight(), spinach.getWeight()) != 0
                || this.getLeafyVegetableType() != spinach.getLeafyVegetableType()
                || this.getSpinachVariety() != spinach.getSpinachVariety())
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
        hash = 31 * hash + (spinachVariety == null ? 0 : spinachVariety.hashCode());

        return hash;
    }


}
