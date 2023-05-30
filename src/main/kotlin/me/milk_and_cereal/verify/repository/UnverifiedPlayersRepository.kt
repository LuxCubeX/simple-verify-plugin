package me.milk_and_cereal.verify.repository

import me.milk_and_cereal.verify.util.Generator
import org.bukkit.entity.Player
import java.util.UUID

class UnverifiedPlayersRepository : HashMap<UUID, String>() {

    fun isVerified(player: Player): Boolean {
        return !this.contains(player.uniqueId)
    }

    fun setVerified(player: Player, verified: Boolean) {
        (verified).takeIf { it }?.let { this.remove(player.uniqueId) } ?: this.put(player.uniqueId, Generator.generateRandomString(5))
    }

    fun getVerifyCode(player: Player) : String? {
        return this[player.uniqueId]
    }

}