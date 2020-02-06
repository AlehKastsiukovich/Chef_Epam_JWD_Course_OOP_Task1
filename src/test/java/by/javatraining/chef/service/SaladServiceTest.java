package by.javatraining.chef.service;

import by.javatraining.chef.exception.ServiceException;
import org.junit.Test;

public class SaladServiceTest {

    @Test(expected = ServiceException.class)
    public void calculateSaladCaloriesNullParametrObjectShouldThrowServiceException() throws ServiceException {
    }

    @Test
    public void calculateSaladCaloriesResultTest() throws ServiceException {

    }

    @Test(expected =  ServiceException.class)
    public void addVegetableNullVegetableInParametrShouldThrowServiceException() throws ServiceException {

    }

    @Test(expected =  ServiceException.class)
    public void addVegetableNullSaladInParametrShouldThrowServiceException() throws ServiceException {

    }

    @Test
    public void addVegetableAllParametrsNotNullShouldReturnTrue() throws ServiceException {

    }

    @Test
    public void removeVegetableAllParametrsNotNullShouldReturnTrue() throws ServiceException {

    }
}
