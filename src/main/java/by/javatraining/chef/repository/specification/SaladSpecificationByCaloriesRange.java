package by.javatraining.chef.repository.specification;

import by.javatraining.chef.entity.Vegetable;
import by.javatraining.chef.repository.VegetableRepository;
import by.javatraining.chef.repository.VegetableRepositoryImpl;
import java.util.Set;
import java.util.TreeSet;

public class SaladSpecificationByCaloriesRange implements SaladSpecification {
    private double inRange;
    private double outRange;

    public SaladSpecificationByCaloriesRange(double inRange, double outRange) {
        this.inRange = inRange;
        this.outRange = outRange;
    }

    @Override
    public Set<Vegetable> query() {
        VegetableRepository repository = VegetableRepositoryImpl.getInstance();
        Set<Vegetable> setOfCaloriesInRange = repository.getAll();
        Set<Vegetable> resultSet = new TreeSet<>();

        for (Vegetable vegetable : setOfCaloriesInRange) {
            if (isInRange(vegetable.getCalories(), inRange, outRange)) {
                resultSet.add(vegetable);
            }
        }

        return resultSet;
    }

    private boolean isInRange(double value, double in, double out) {
        return (in < out) && (value >= in && value <= out);
    }
}
