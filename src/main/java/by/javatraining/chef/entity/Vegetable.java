package by.javatraining.chef.entity;


public abstract class Vegetable implements Comparable<Vegetable> {
    protected Integer id;
    protected double weight;
    protected double proteins;
    protected double carbohydrates;
    protected double calories;

    public Vegetable(double weight, double proteins, double carbohydrates, double calories) {
        this.weight = weight;
        this.proteins = proteins;
        this.carbohydrates = carbohydrates;
        this.calories = calories;
    }

    public Vegetable() {
    }

    public Integer getId() {
        return id;
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

    public int compareTo(Vegetable vegetable) {
        return this.id.compareTo(vegetable.id);
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setProteins(double proteins) {
        this.proteins = proteins;
    }

    public void setCarbohydrates(double carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public String toString() {
        return getClass().getSimpleName() + "[" + weight + ", " + proteins + ", "
                + carbohydrates + ", " + calories + "]";
    }
}
