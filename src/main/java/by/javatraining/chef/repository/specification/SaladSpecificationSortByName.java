package by.javatraining.chef.repository.specification;

import by.javatraining.chef.comparator.VegetableNameComparator;
import by.javatraining.chef.entity.Vegetable;
import by.javatraining.chef.repository.VegetableRepository;
import by.javatraining.chef.repository.VegetableRepositoryImpl;
import java.util.Set;
import java.util.TreeSet;

public class SaladSpecificationSortByName implements SaladSpecification {

    @Override
    public Set<Vegetable> query() {
        VegetableRepository repository = VegetableRepositoryImpl.getInstance();
        Set<Vegetable> sortedByNameSet = new TreeSet<>(new VegetableNameComparator());
        sortedByNameSet.addAll(repository.getAll());

        return sortedByNameSet;
    }
}
