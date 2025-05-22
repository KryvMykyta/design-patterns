package hw8.task8_3_1;

class DineInPreparation implements PreparationStyle {
    @Override
    public void prepareBase(String baseIngredient) {
        System.out.println("Preparing for dine-in: Put some " + baseIngredient + "...");
    }

    @Override
    public void addExtras(String extra, int amount) {
        if (amount > 0) {
            System.out.printf("Adding for dine-in: %s: %d units...%n", extra, amount);
        }
    }

    @Override
    public void serve() {
        System.out.println("Serving in a cup for dine-in!");
    }
}
