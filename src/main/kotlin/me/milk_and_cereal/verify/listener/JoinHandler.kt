package me.milk_and_cereal.verify.listener

import me.milk_and_cereal.verify.repository.UnverifiedPlayersRepository
import me.milk_and_cereal.verify.util.Colors
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent

class JoinHandler(private val unverifiedPlayersRepository: UnverifiedPlayersRepository) : Listener {


    @EventHandler
    fun onJoin(event: PlayerJoinEvent){

        val player: Player = event.player
        unverifiedPlayersRepository.setVerified(
            player = event.player,
            verified = false
        )

        val code = unverifiedPlayersRepository.getVerifyCode(player = player)
        player.sendMessage(
            Colors.translate("&e&lVerify &8&l» &7Type &6$code&7 to get verified.")
        )

    }

}