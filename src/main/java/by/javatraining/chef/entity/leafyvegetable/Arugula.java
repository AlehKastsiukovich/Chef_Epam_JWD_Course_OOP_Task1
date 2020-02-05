package by.javatraining.chef.entity.leafyvegetable;

import by.javatraining.chef.entity.VegetableColor;
import by.javatraining.chef.entity.leafyvegetable.leafyenum.ArugulaVariety;
import by.javatraining.chef.entity.leafyvegetable.leafyenum.LeafyVegetableType;

public class Arugula extends LeafyVegetable {
    private ArugulaVariety arugulaVariety;
    private static final int ARUGULA_MAX_WEIGHT = 25;
    private static final double CALORIES = 25;
    private static final double PROTEINS = 2.6;
    private static final double CARBOHYDRATES = 2.1;

    public Arugula() {
        super(Math.random() * ARUGULA_MAX_WEIGHT, PROTEINS, CARBOHYDRATES,
                CALORIES, VegetableColor.GREEN, LeafyVegetableType.LEAFY);
        this.arugulaVariety = ArugulaVariety.BELEZZIA;
    }

    public Arugula(ArugulaVariety arugulaVariety) {
        super(Math.random() * ARUGULA_MAX_WEIGHT, PROTEINS, CARBOHYDRATES,
                CALORIES, VegetableColor.GREEN, LeafyVegetableType.LEAFY);

        if (arugulaVariety == null) {
            throw  new NullPointerException();
        }

        this.arugulaVariety = arugulaVariety;
    }

    public ArugulaVariety getArugulaVariety() {
        return arugulaVariety;
    }

    public void setArugulaVariety(ArugulaVariety arugulaVariety) {
        if (arugulaVariety == null) {
            throw  new NullPointerException();
        }

        this.arugulaVariety = arugulaVariety;
    }

    public boolean equals(Object object) {
        if (this == object)
            return true;
        if (object == null)
            return false;
        if (this.getClass() != object.getClass())
            return false;
        Arugula arugula = (Arugula) object;
        if (Double.compare(this.getProteins(), arugula.getProteins()) != 0
                || Double.compare(this.getCarbohydrates(), arugula.getCarbohydrates()) != 0
                || Double.compare(this.getCalories(), arugula.getCalories()) != 0
                || Double.compare(this.getWeight(), arugula.getWeight()) != 0
                || this.getLeafyVegetableType() != arugula.getLeafyVegetableType()
                || this.getArugulaVariety() != arugula.getArugulaVariety())
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
        hash = 31 * hash + (arugulaVariety == null ? 0 : arugulaVariety.hashCode());

        return hash;
    }
}
