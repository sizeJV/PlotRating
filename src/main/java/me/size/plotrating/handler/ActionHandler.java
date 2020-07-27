package me.size.plotrating.handler;

import lombok.NoArgsConstructor;
import org.bukkit.Material;


@NoArgsConstructor
public class ActionHandler {

    public enum Action {APPLY, NONE, INACTIVE, CLOSE, ACTIVE}


    /**
     * @param clicked: Returns Confirmation of clicked Slot
     */
    public Action getConfirmation(Material clicked) {
        switch (clicked) {
            case GRAY_DYE:
                return Action.INACTIVE;
            case LIME_DYE:
                return Action.ACTIVE;
            case RED_CONCRETE:
                return Action.CLOSE;
            case GREEN_CONCRETE:
                return Action.APPLY;
            default:
                return Action.NONE;
        }
    }
}
