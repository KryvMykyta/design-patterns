package hw22.task22_3_1;

public abstract class Character {

    public final void defendAgainstAttack() {
        pickUpWeapon();
        defenseAction();
        moveToSafety();
        System.out.println();
    }

    protected abstract void pickUpWeapon();

    protected abstract void defenseAction();

    protected abstract void moveToSafety();
}