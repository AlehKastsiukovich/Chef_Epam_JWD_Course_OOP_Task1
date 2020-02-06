package by.javatraining.chef.repository.specification;

import by.javatraining.chef.entity.Vegetable;
import by.javatraining.chef.repository.VegetableRepository;
import by.javatraining.chef.repository.VegetableRepositoryImpl;
import java.util.Set;
import java.util.TreeSet;

public class SaladSpecificationFindRangeVegetableByIdRange implements SaladSpecification {
    private int inRange;
    private int outRange;

    public SaladSpecificationFindRangeVegetableByIdRange(int inRange, int outRange) {
        this.inRange = inRange;
        this.outRange = outRange;
    }

    @Override
    public Set<Vegetable> query() {
        VegetableRepository repository = VegetableRepositoryImpl.getInstance();
        Set<Vegetable> vegetableSetInIdRange = new TreeSet<>();

        for (Vegetable vegetable : repository.getAll()) {
            if (checkRange(vegetable, inRange, outRange)) {
                vegetableSetInIdRange.add(vegetable);
            }
        }

        return vegetableSetInIdRange;
    }

    private boolean checkRange(Vegetable vegetable, int inRange, int outRange) {
        return vegetable.getId() >= inRange && vegetable.getId() <= outRange;
    }
}
