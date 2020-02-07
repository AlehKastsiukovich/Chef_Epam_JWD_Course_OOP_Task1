package by.javatraining.chef.entity;

import org.apache.log4j.Logger;

public class RootVegetable extends Vegetable {
    private static final Logger logger = Logger.getLogger(FruitVegetable.class);
    private RootVegetableSpecificType vegetable;

    public RootVegetable(double weight, double proteins, double carbohydrates,
                         double calories, RootVegetableSpecificType vegetable) {
        super(weight, proteins, carbohydrates, calories);
        this.vegetable = vegetable;
    }

    public RootVegetable(RootVegetableSpecificType vegetable) {
        if (vegetable == null) {
            logger.error("Enter null SpecificType object!");
            throw new NullPointerException();
        }
        this.vegetable = vegetable;
    }

    public RootVegetable() {

    }

    public RootVegetableSpecificType getVegetable() {
        return vegetable;
    }

    public void setVegetable(RootVegetableSpecificType vegetable) {
        if (vegetable == null) {
            logger.error("Enter null SpecificType object!");
            throw new NullPointerException();
        }
        this.vegetable = vegetable;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object)
            return true;
        if (object == null)
            return false;
        if (this.getClass() != object.getClass())
            return false;
        RootVegetable otherVegetable = (RootVegetable) object;
        if (Double.compare(this.proteins, otherVegetable.proteins) != 0
                || Double.compare(this.carbohydrates, otherVegetable.carbohydrates) != 0
                || Double.compare(this.calories, otherVegetable.calories) != 0
                || Double.compare(this.weight, otherVegetable.weight) != 0
                || this.vegetable != otherVegetable.vegetable)
            return false;
        return true;
    }

    @Override
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
        hash = 31 * hash + (vegetable == null ? 0 : vegetable.hashCode());

        return hash;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "["+ id + ", " + weight + ", " + proteins + ", "
                + carbohydrates + ", " + calories + ", " + vegetable + "]";
    }
}
