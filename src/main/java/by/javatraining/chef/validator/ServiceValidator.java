package by.javatraining.chef.validator;

import by.javatraining.chef.entity.Salad;
import by.javatraining.chef.exception.ServiceException;

public class ServiceValidator {

    public static boolean checkSalad(Salad salad) throws ServiceException {
         return salad != null && salad.getListOfVegetables() != null;
    }

}
