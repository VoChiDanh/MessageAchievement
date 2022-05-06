package net.danh.Commands;

import net.danh.MessageAchievement;
import net.danh.Utils.Chat;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.Objects;
import java.util.UUID;

public class CMDBase implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (label.equalsIgnoreCase("MA")) {
            if (args.length >= 4) {
                if (Bukkit.getPlayer(args[2]) == null || Material.getMaterial(args[1].toUpperCase()) == null) {
                    return true;
                }
                ItemStack itemStack = new ItemStack(Objects.requireNonNull(Material.getMaterial(args[1].toUpperCase())));
                UUID uuid = Objects.requireNonNull(Bukkit.getPlayer(args[2])).getUniqueId();
                String title = String.join(" ", Arrays.asList(args).subList(3, args.length));
                if (args[0].equalsIgnoreCase("c")) {
                    MessageAchievement.get().getAdvancementManager().sendChallengeToast(itemStack, uuid, Chat.colorize(title), "Custom");
                }
                if (args[0].equalsIgnoreCase("g")) {
                    MessageAchievement.get().getAdvancementManager().sendToast(itemStack, uuid, Chat.colorize(title), "Custom");
                }
                return true;
            }
            return true;
        }
        return false;
    }
}
