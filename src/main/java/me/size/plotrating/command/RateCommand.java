package me.size.plotrating.command;

import com.plotsquared.core.command.Command;
import com.plotsquared.core.command.CommandCategory;
import com.plotsquared.core.command.CommandDeclaration;
import com.plotsquared.core.command.MainCommand;
import com.plotsquared.core.command.RequiredType;
import com.plotsquared.core.configuration.Captions;
import com.plotsquared.core.player.PlotPlayer;
import com.plotsquared.core.plot.Plot;
import com.plotsquared.core.util.Permissions;
import com.plotsquared.core.util.task.RunnableVal2;
import com.plotsquared.core.util.task.RunnableVal3;
import me.size.plotrating.gui.GuiInventory;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.concurrent.CompletableFuture;


@CommandDeclaration(
        command = "prate",
        description = "Rate a Plot",
        usage = "/plot prate",
        permission = "plots.prate",
        category = CommandCategory.CHAT,
        requiredType = RequiredType.NONE
)
public class RateCommand extends Command {

    public RateCommand() {
        super(MainCommand.getInstance(), true);
    }


    public CompletableFuture<Boolean> execute(PlotPlayer<?> player,
                                              String[] args,
                                              RunnableVal3<Command, Runnable, Runnable> confirm,
                                              RunnableVal2<Command, CommandResult> whenDone) throws CommandException {
        Plot currentPlot = player.getCurrentPlot();
        if (currentPlot == null) {
            throw new CommandException(Captions.NOT_IN_PLOT, new Object[0]);
        }
        else {
            this.checkTrue(currentPlot.hasOwner(), Captions.PLOT_UNOWNED, new Object[0]);
            this.checkTrue(
                    currentPlot.isOwner(player.getUUID()) || Permissions.hasPermission(player, Captions.PERMISSION_ADMIN_COMMAND_TRUST),
                    Captions.NO_PLOT_PERMS,
                    new Object[0]);
            this.checkTrue(args.length == 0, Captions.COMMAND_SYNTAX, new Object[]{this.getUsage()});

            Player bukkitPlayer = Bukkit.getPlayer(player.getUUID());

            GuiInventory guiInventory = new GuiInventory();
            guiInventory.openGUI(bukkitPlayer);

            return CompletableFuture.completedFuture(true);
        }
    }
}
