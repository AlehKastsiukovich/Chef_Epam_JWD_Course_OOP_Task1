package by.javatraining.chef.entity;

import org.apache.log4j.Logger;

public abstract class Vegetable implements Comparable<Vegetable> {
    private static final Logger logger = Logger.getLogger(Vegetable.class);

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
        if (id < 1) {
            logger.error("Enter wrong id. id must be > 0!");
            throw new IllegalArgumentException();
        }
        this.id = id;
    }

    public void setWeight(double weight) {
        if (weight < 0) {
            logger.error("Enter wrong weight. weight must be > 0!");
            throw new IllegalArgumentException();
        }
        this.weight = weight;
    }

    public void setProteins(double proteins) {
        if (proteins < 0 || proteins > 100) {
            logger.error("Proteins must be >= 0 and < 100!");
            throw new IllegalArgumentException();
        }
        this.proteins = proteins;
    }

    public void setCarbohydrates(double carbohydrates) {
        if (carbohydrates < 0 || carbohydrates > 100) {
            logger.error("Carbohydrates must be >= 0 and < 100!");
            throw new IllegalArgumentException();
        }
        this.carbohydrates = carbohydrates;
    }

    public void setCalories(double calories) {
        if (calories < 0) {
            logger.error("Calories must be > 0!");
            throw new IllegalArgumentException();
        }
        this.calories = calories;
    }

    public String toString() {
        return getClass().getSimpleName() + "[" + weight + ", " + proteins + ", "
                + carbohydrates + ", " + calories + "]";
    }
}
