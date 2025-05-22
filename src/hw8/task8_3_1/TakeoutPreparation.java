package hw8.task8_3_1;

class TakeoutPreparation implements PreparationStyle {
    @Override
    public void prepareBase(String baseIngredient) {
        System.out.println("Preparing for takeout: Put some " + baseIngredient + "...");
    }

    @Override
    public void addExtras(String extra, int amount) {
        if (amount > 0) {
            System.out.printf("Adding for takeout: %s: %d units...%n", extra, amount);
        }
    }

    @Override
    public void serve() {
        System.out.println("Packing in a takeout cup with a lid!");
    }
}