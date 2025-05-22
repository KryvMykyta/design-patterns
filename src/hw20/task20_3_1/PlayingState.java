package hw20.task20_3_1;

public class PlayingState implements State {
    private MediaPlayer mediaPlayer;

    public PlayingState(MediaPlayer mediaPlayer) {
        this.mediaPlayer = mediaPlayer;
    }

    @Override
    public void play() {
    }

    @Override
    public void pause() {
        mediaPlayer.setState(new PausedState(mediaPlayer));
        System.out.println("Video paused, icon set to play button");
    }
}