package me.milk_and_cereal.verify.listener

import me.milk_and_cereal.verify.repository.UnverifiedPlayersRepository
import me.milk_and_cereal.verify.util.Colors
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.AsyncPlayerChatEvent

class ChatHandler(private val unverifiedPlayersRepository: UnverifiedPlayersRepository) : Listener {


    @EventHandler
    fun onChat(event: AsyncPlayerChatEvent){

        val player: Player = event.player
        if (!unverifiedPlayersRepository.isVerified(player)) {

            event.isCancelled = true
            val code = unverifiedPlayersRepository.getVerifyCode(player = player)

            if (event.message.equals(code, ignoreCase = true)) {
                unverifiedPlayersRepository.setVerified(player, true)
                player.sendMessage(Colors.translate("&e&lVerify &8&l» &fYou successfully got verified."))
                return
            }

            player.sendMessage(
                Colors.translate("&e&lVerify &8&l» &7Type &6$code&7 to get verified.")
            )
        }

    }


}