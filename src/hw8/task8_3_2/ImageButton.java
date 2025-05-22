package hw8.task8_3_2;

public class ImageButton extends Button {
    public ImageButton(Size size) {
        super(size);
    }

    @Override
    public void draw() {
        size.applySize();
        System.out.println("Drawing an image button.");
    }
}