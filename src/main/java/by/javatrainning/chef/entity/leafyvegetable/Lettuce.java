package by.javatrainning.chef.entity.leafyvegetable;

import by.javatrainning.chef.entity.VegetableColor;
import by.javatrainning.chef.entity.leafyvegetable.leafyenum.LeafyVegetableType;
import by.javatrainning.chef.entity.leafyvegetable.leafyenum.LettuceVariety;

public class Lettuce extends LeafyVegetable {
    private LettuceVariety lettuceVariety;
    private static final int LETTUCE_MAX_WEIGHT = 200;
    private static final double CALORIES = 15;
    private static final double PROTEINS = 1.4;
    private static final double CARBOHYDRATES = 2.9;

    public Lettuce() {
        super(Math.random() * LETTUCE_MAX_WEIGHT, PROTEINS, CARBOHYDRATES,
                CALORIES, VegetableColor.GREEN, LeafyVegetableType.LEAFY);
        this.lettuceVariety = LettuceVariety.ROMEN;
    }

    public Lettuce(LettuceVariety lettuceVariety) {
        super(Math.random() * LETTUCE_MAX_WEIGHT, PROTEINS, CARBOHYDRATES,
                CALORIES, VegetableColor.GREEN, LeafyVegetableType.LEAFY);
        this.lettuceVariety = lettuceVariety;
    }

    public LettuceVariety getLettuceVariety() {
        return lettuceVariety;
    }

    public void setLettuceVariety(LettuceVariety lettuceVariety) {
        this.lettuceVariety = lettuceVariety;
    }

    public boolean equals(Object object) {
        if (this == object)
            return true;
        if (object == null)
            return false;
        if (this.getClass() != object.getClass())
            return false;
        Lettuce lettuce = (Lettuce) object;
        if (Double.compare(this.getProteins(), lettuce.getProteins()) != 0
                || Double.compare(this.getCarbohydrates(), lettuce.getCarbohydrates()) != 0
                || Double.compare(this.getCalories(), lettuce.getCalories()) != 0
                || Double.compare(this.getWeight(), lettuce.getWeight()) != 0
                || this.getLeafyVegetableType() != lettuce.getLeafyVegetableType()
                || this.getLettuceVariety() != lettuce.getLettuceVariety())
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
        hash = 31 * hash + (lettuceVariety == null ? 0 : lettuceVariety.hashCode());

        return hash;
    }
}
