package by.javatraining.chef.service;

import by.javatraining.chef.entity.Vegetable;
import by.javatraining.chef.exception.ServiceException;
import by.javatraining.chef.exception.VegetableRepositoryException;
import by.javatraining.chef.factory.FruitVegetableCreator;
import by.javatraining.chef.factory.LeafyVegetableCreator;
import by.javatraining.chef.factory.RootVegetableCreator;
import by.javatraining.chef.factory.VegetableCreator;
import by.javatraining.chef.repository.VegetableRepository;
import by.javatraining.chef.repository.VegetableRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import java.util.Set;
import java.util.TreeSet;

public class SaladServiceTest {
    private VegetableRepository repository = VegetableRepositoryImpl.getInstance();
    private SaladService service;
    private VegetableCreator fruitVegetableCreator;
    private VegetableCreator rootVegetableCreator;
    private VegetableCreator leafyVegetableCreator;

    @Before
    public void creteSaladService() {
        service = SaladService.SaladServiceHolder.instance;
        fruitVegetableCreator = new FruitVegetableCreator();
        rootVegetableCreator = new RootVegetableCreator();
        leafyVegetableCreator = new LeafyVegetableCreator();
    }

    @Test
    public void TestFindSaladComponentsByIdRange() throws VegetableRepositoryException, ServiceException {
        Vegetable vegetable = fruitVegetableCreator.createVegetable();
        Vegetable vegetable2 = rootVegetableCreator.createVegetable();
        Vegetable vegetable3 = leafyVegetableCreator.createVegetable();
        Vegetable vegetable4 = fruitVegetableCreator.createVegetable();
        Vegetable vegetable5 = fruitVegetableCreator.createVegetable();

        vegetable.setId(1);
        vegetable2.setId(2);
        vegetable3.setId(3);
        vegetable4.setId(4);
        vegetable5.setId(5);

        Set<Vegetable> exceptedSet = new TreeSet<>();
        exceptedSet.add(vegetable3);
        exceptedSet.add(vegetable4);
        exceptedSet.add(vegetable5);

        repository.add(vegetable);
        repository.add(vegetable2);
        repository.add(vegetable3);
        repository.add(vegetable4);
        repository.add(vegetable5);

        Assert.assertEquals(exceptedSet, service.findSaladComponentsByIdRange(3,5));
    }

    @Test
    public void TestFindSaladComponentsInCaloriesRange() throws VegetableRepositoryException, ServiceException {
        Vegetable vegetable = fruitVegetableCreator.createVegetable();
        Vegetable vegetable2 = rootVegetableCreator.createVegetable();
        Vegetable vegetable3 = leafyVegetableCreator.createVegetable();
        Vegetable vegetable4 = fruitVegetableCreator.createVegetable();
        Vegetable vegetable5 = fruitVegetableCreator.createVegetable();

        vegetable.setCalories(10);
        vegetable.setId(1);
        vegetable2.setCalories(33);
        vegetable2.setId(2);
        vegetable3.setCalories(100);
        vegetable3.setId(3);
        vegetable4.setCalories(1000);
        vegetable4.setId(4);
        vegetable5.setCalories(22);
        vegetable5.setId(5);

        Set<Vegetable> exceptedSet = new TreeSet<>();
        exceptedSet.add(vegetable2);
        exceptedSet.add(vegetable5);

        repository.add(vegetable);
        repository.add(vegetable2);
        repository.add(vegetable3);
        repository.add(vegetable4);
        repository.add(vegetable5);

        Assert.assertEquals(exceptedSet, service.findSaladComponentsInCaloriesRange(20, 50));
    }

    @Test(expected =  ServiceException.class)
    public void addVegetableNullVegetableInParameterShouldThrowServiceException() throws ServiceException {
        Vegetable vegetable = null;
        service.addVegetable(vegetable);
    }

    @Test(expected = ServiceException.class)
    public void removeVegetableNullVegetableInParameterShouldThrowServiceException() throws ServiceException {
        Vegetable vegetable = null;
        service.removeVegetable(vegetable);
    }

    @Test
    public void TestAddVegetable() throws VegetableRepositoryException, ServiceException {
        Vegetable vegetable1 = fruitVegetableCreator.createVegetable();
        vegetable1.setId(1);
        repository.add(vegetable1);
        Set<Vegetable> testSet = new TreeSet<>();
        testSet.add(vegetable1);

        Assert.assertEquals(testSet, repository.getAll());
    }

    @Test
    public void TestCalculateSumOfCalories() throws VegetableRepositoryException {
        Vegetable vegetable = fruitVegetableCreator.createVegetable();
        Vegetable vegetable2 = rootVegetableCreator.createVegetable();
        Vegetable vegetable3 = leafyVegetableCreator.createVegetable();

        vegetable.setCalories(10);
        vegetable.setId(1);
        vegetable2.setCalories(20);
        vegetable2.setId(2);
        vegetable3.setCalories(30);
        vegetable3.setId(3);

        repository.add(vegetable);
        repository.add(vegetable2);
        repository.add(vegetable3);

        double result = service.calculateSaladCalories();
        double excepted = 60;

        Assert.assertEquals(excepted, result, 1e-9);
    }
}
