package by.javatrainning.chef.entity;


public abstract class Vegetable {
    private double weight;
    private double proteins;
    private double carbohydrates;
    private double calories;
    private VegetableColor color;

    public Vegetable(double weight, double proteins, double carbohydrates,
                     double calories, VegetableColor color) {
        this.weight = weight;
        this.proteins = proteins;
        this.carbohydrates = carbohydrates;
        this.calories = calories;
        this.color = color;
    }

    public double getWeight() {
        return weight;
    }

    public double getProteins() {
        return proteins;
    }

    public double getCarbohydrates() {
        return carbohydrates;
    }

    public double getCalories() {
        return calories;
    }

    public VegetableColor getColor() {
        return color;
    }

    public String toString() {
        return getClass().getSimpleName() + "[" + weight + ", " + proteins + ", "
                + carbohydrates + ", " + calories + ", " + color + "]";
    }
}
