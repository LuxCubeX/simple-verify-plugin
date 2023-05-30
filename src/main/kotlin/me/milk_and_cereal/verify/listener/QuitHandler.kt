package me.milk_and_cereal.verify.listener

import me.milk_and_cereal.verify.repository.UnverifiedPlayersRepository
import org.bukkit.entity.Player
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerQuitEvent

class QuitHandler(private val unverifiedPlayersRepository: UnverifiedPlayersRepository) : Listener {

    @Override
    fun onQuit(event: PlayerQuitEvent){

        val player: Player = event.player
        if (!unverifiedPlayersRepository.isVerified(player)){

            unverifiedPlayersRepository.setVerified(
                player = player,
                verified = false
            )

        }

    }

}