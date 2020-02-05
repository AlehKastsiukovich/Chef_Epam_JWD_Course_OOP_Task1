package by.javatraining.chef.service;

import by.javatraining.chef.comparator.VegetableWeightComparator;
import by.javatraining.chef.entity.Salad;
import by.javatraining.chef.entity.Vegetable;
import by.javatraining.chef.exception.ServiceException;
import by.javatraining.chef.factory.VegetableCreator;
import org.junit.Assert;
import org.junit.Test;
import java.util.Set;
import java.util.TreeSet;

public class SaladServiceTest {

    @Test(expected = ServiceException.class)
    public void calculateSaladCaloriesNullParametrObjectShouldThrowServiceException() throws ServiceException {
        Salad salad = null;

        SaladService service = new SaladService();

        service.calculateSaladCalories(salad);
    }

    @Test
    public void calculateSaladCaloriesResultTest() throws ServiceException {
        Salad salad = new Salad();
        SaladService service = new SaladService();
        VegetableCreator creator = new ArugulaCreator();
        VegetableCreator creator1 = new CarrotCreator();
        VegetableCreator creator2 = new CeleryCreator();

        Vegetable vegetable1 = creator.createVegetable();
        Vegetable vegetable2 = creator1.createVegetable();
        Vegetable vegetable3 = creator2.createVegetable();

        Set<Vegetable> set = new TreeSet<>(new VegetableWeightComparator());
        set.add(vegetable1);
        set.add(vegetable2);
        set.add(vegetable3);

        salad.setListOfVegetables(set);

        double result = service.calculateSaladCalories(salad);

        Assert.assertEquals(69.0, result, 1e-9);
    }

    @Test(expected =  ServiceException.class)
    public void addVegetableNullVegetableInParametrShouldThrowServiceException() throws ServiceException {
        Vegetable vegetable = null;
        Salad salad = new Salad();

        SaladService service = new SaladService();

        service.addVegetable(vegetable, salad);
    }

    @Test(expected =  ServiceException.class)
    public void addVegetableNullSaladInParametrShouldThrowServiceException() throws ServiceException {
        Salad salad = null;
        VegetableCreator creator = new CarrotCreator();
        Vegetable vegetable = creator.createVegetable();

        SaladService service = new SaladService();

        service.addVegetable(vegetable, salad);
    }

    @Test
    public void addVegetableAllParametrsNotNullShouldReturnTrue() throws ServiceException {
        Salad salad = new Salad();
        VegetableCreator creator = new CarrotCreator();
        Vegetable vegetable = creator.createVegetable();

        SaladService service = new SaladService();

        Assert.assertEquals(true, service.addVegetable(vegetable, salad));
    }

    @Test
    public void removeVegetableAllParametrsNotNullShouldReturnTrue() throws ServiceException {
        Salad salad = new Salad();
        VegetableCreator creator = new CarrotCreator();
        Vegetable vegetable = creator.createVegetable();
        SaladService service = new SaladService();
        service.addVegetable(vegetable, salad);

        Assert.assertEquals(true, service.removeVegetable(vegetable, salad));
    }
}
