package test.common.events;

import test.common.entity.PlayerEntity;
import test.event.Event;

public final class GameOverEvent implements Event {
    private final PlayerEntity winner;

    public GameOverEvent(PlayerEntity winner){
        this.winner = winner;
    }

    public PlayerEntity getWinner() {
        return winner;
    }
}
