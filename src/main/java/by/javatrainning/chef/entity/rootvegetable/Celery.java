package by.javatrainning.chef.entity.rootvegetable;

import by.javatrainning.chef.entity.VegetableColor;
import by.javatrainning.chef.entity.rootvegetable.rootenum.CeleryVariety;

public class Celery extends RootVegetable {
    private CeleryVariety celeryVariety;
    private static final int CELERY_MAX_WEIGHT = 400;
    private static final double SUGAR_PERCENT = 10;
    private static final double CALORIES = 12;
    private static final double PROTEINS = 0.9;
    private static final double CARBOHYDRATES = 2.1;

    public Celery() {
        super(Math.random() * CELERY_MAX_WEIGHT, PROTEINS, CARBOHYDRATES,
                CALORIES, VegetableColor.GREEN, SUGAR_PERCENT);
        this.celeryVariety = CeleryVariety.MENTOR;
    }

    public Celery(CeleryVariety celeryVariety) {
        super(Math.random() * CELERY_MAX_WEIGHT, PROTEINS, CARBOHYDRATES,
                CALORIES, VegetableColor.GREEN, SUGAR_PERCENT);
        this.celeryVariety = celeryVariety;
    }

    public CeleryVariety getCeleryVariety() {
        return celeryVariety;
    }

    public void setCeleryVariety(CeleryVariety celeryVariety) {
        this.celeryVariety = celeryVariety;
    }

    public boolean equals(Object object) {
        if (this == object)
            return true;
        if (object == null)
            return false;
        if (this.getClass() != object.getClass())
            return false;
        Celery celery = (Celery) object;
        if (Double.compare(this.getProteins(), celery.getProteins()) != 0
                || Double.compare(this.getCarbohydrates(), celery.getCarbohydrates()) != 0
                || Double.compare(this.getCalories(), celery.getCalories()) != 0
                || Double.compare(this.getWeight(), celery.getWeight()) != 0
                || Double.compare(this.getSugarPercent(), celery.getSugarPercent()) != 0
                || this.getCeleryVariety() != celery.getCeleryVariety())
            return false;
        return true;
    }

    public int hashCode() {
        int hash = 7;
        long lb1 = Double.doubleToLongBits(this.getWeight());
        hash = 31 * hash + (int) (lb1 - (lb1 >>> 32));
        long lb2 = Double.doubleToLongBits(this.getProteins());
        hash = 31 * hash + (int) (lb2 - (lb2 >>> 31));
        long lb3 = Double.doubleToLongBits(this.getCalories());
        hash = 31 * hash + (int) (lb3 - (lb3 >>> 31));
        long lb4 = Double.doubleToLongBits(this.getCarbohydrates());
        hash = 31 * hash + (int) (lb4 - (lb4 >>> 31));
        hash = 31 * hash + (celeryVariety == null ? 0 : celeryVariety.hashCode());

        return hash;
    }
}
