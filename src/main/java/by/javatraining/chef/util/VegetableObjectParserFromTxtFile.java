package by.javatraining.chef.util;

import by.javatraining.chef.entity.FruitVegetable;
import by.javatraining.chef.entity.FruitVegetableSpecificType;
import by.javatraining.chef.entity.Vegetable;
import by.javatraining.chef.exception.UtilException;
import by.javatraining.chef.factory.FruitVegetableCreator;
import by.javatraining.chef.factory.LeafyVegetableCreator;
import by.javatraining.chef.factory.RootVegetableCreator;
import by.javatraining.chef.factory.VegetableCreator;
import org.apache.log4j.Logger;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class VegetableObjectParserFromTxtFile {
    private static final Logger logger = Logger.getLogger(VegetableObjectParserFromTxtFile.class);

    public Set<Vegetable> parseTxtFile(List<String> stringVegetableList) throws UtilException {
        if (stringVegetableList == null) {
            logger.debug("Get null list object to method parseTxtFile!");
            throw new UtilException();
        }

        Set<Vegetable> vegetableSet = new TreeSet<>();
        Vegetable vegetable = null;
        String[] tempArray = null;
        for (String string : stringVegetableList) {
            tempArray = string.split(" ");
            vegetable = initVegetableFieldsByString(tempArray);
            vegetableSet.add(vegetable);
        }

        return vegetableSet;
    }

    private Vegetable initVegetableFieldsByString(String[] fields) throws UtilException {
        if (fields == null) {
            logger.debug("Get null array of Vegetable object fields!");
            throw new UtilException();
        }

        if (fields.length != 6) {
            logger.debug("Less then 6 fields, its enough to init object!");
            throw new UtilException();
        }

        Vegetable vegetable = null;
        String vegetableType = fields[5];
        vegetable = createVegetableByVegetableTypeField(vegetableType);

        vegetable.setId(Integer.parseInt(fields[0]));
        vegetable.setWeight(Double.parseDouble(fields[1]));
        vegetable.setProteins(Double.parseDouble(fields[2]));
        vegetable.setCalories(Double.parseDouble(fields[3]));
        FruitVegetable fruitVegetable = (FruitVegetable) vegetable;
        fruitVegetable.setVegetable(FruitVegetableSpecificType.valueOf(vegetableType));

        return vegetable;
    }

    private Vegetable createVegetableByVegetableTypeField(String type) throws UtilException {
        Vegetable vegetable = null;
        VegetableCreator fruitVegetableCreator = new FruitVegetableCreator();
        VegetableCreator leafyVegetableCreator = new LeafyVegetableCreator();
        VegetableCreator rootVegetableCreator = new RootVegetableCreator();

        switch (type) {
            case "CUCUMBER":
            case "PEPPER":
            case "TOMATO":
                vegetable = fruitVegetableCreator.createVegetable();
                break;
            case "ARUGULA":
            case "LETTUCE":
            case "SPINACH":
                vegetable = leafyVegetableCreator.createVegetable();
                break;
            case "CARROT":
            case "CELERY":
            case "RADISH":
                vegetable = rootVegetableCreator.createVegetable();
                break;
            default:
                logger.debug("No such vegetable in list!");
                throw new UtilException();
        }

        return vegetable;
    }
}
