package hw20.task20_3_1;

public class PausedState implements State {
    private MediaPlayer mediaPlayer;

    public PausedState(MediaPlayer mediaPlayer) {
        this.mediaPlayer = mediaPlayer;
    }

    @Override
    public void play() {
        mediaPlayer.setState(new PlayingState(mediaPlayer));
        System.out.println("Video playing, icon set to pause button");
    }

    @Override
    public void pause() {
    }
}