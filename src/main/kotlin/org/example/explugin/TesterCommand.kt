package org.example.explugin

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import net.kyori.adventure.text.format.TextDecoration
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender

class TesterCommand : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if(args.isNotEmpty()) {
            when(args[0]) {
                "cpu" -> {
                    sender.sendMessage(
                        Component.text("Core", NamedTextColor.WHITE, TextDecoration.BOLD)
                            .append(Component.text(": ${Runtime.getRuntime().availableProcessors()}", NamedTextColor.WHITE))
                    )
                }
                "memory" -> {
                    sender.sendMessage(
                        Component.text("Memory", NamedTextColor.WHITE, TextDecoration.BOLD)
                            .append(Component.text(": ${Runtime.getRuntime().maxMemory() - Runtime.getRuntime().freeMemory()}/${Runtime.getRuntime().maxMemory()}", NamedTextColor.WHITE))
                    )
                }
            }
        }
        return true
    }
}