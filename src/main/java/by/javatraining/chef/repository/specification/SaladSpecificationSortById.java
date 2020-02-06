package by.javatraining.chef.repository.specification;

import by.javatraining.chef.comparator.VegetableIdComparator;
import by.javatraining.chef.entity.Vegetable;
import by.javatraining.chef.repository.VegetableRepository;
import by.javatraining.chef.repository.VegetableRepositoryImpl;

import java.util.Set;
import java.util.TreeSet;

public class SaladSpecificationSortById implements SaladSpecification{

    @Override
    public Set<Vegetable> query() {
        VegetableRepository repository = VegetableRepositoryImpl.getInstance();
        Set<Vegetable> sortedByIdSet = new TreeSet<Vegetable>(new VegetableIdComparator());
        sortedByIdSet.addAll(repository.getAll());

        return sortedByIdSet;
    }
}
