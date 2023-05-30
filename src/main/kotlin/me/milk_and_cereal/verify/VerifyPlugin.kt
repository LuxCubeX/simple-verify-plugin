package me.milk_and_cereal.verify

import me.milk_and_cereal.verify.listener.ChatHandler
import me.milk_and_cereal.verify.listener.JoinHandler
import me.milk_and_cereal.verify.listener.QuitHandler
import me.milk_and_cereal.verify.repository.UnverifiedPlayersRepository
import org.bukkit.event.HandlerList
import org.bukkit.plugin.PluginManager
import org.bukkit.plugin.java.JavaPlugin

class VerifyPlugin : JavaPlugin() {

    private lateinit var unverifiedPlayersRepository: UnverifiedPlayersRepository


    override fun onLoad() {
        unverifiedPlayersRepository = UnverifiedPlayersRepository()
    }


    override fun onEnable() {

        val pluginManager: PluginManager = this.server.pluginManager
        arrayOf(
            ChatHandler(unverifiedPlayersRepository),
            JoinHandler(unverifiedPlayersRepository),
            QuitHandler(unverifiedPlayersRepository)
        ).forEach { listener -> pluginManager.registerEvents(listener, this) }

    }

    override fun onDisable() {
        HandlerList.unregisterAll(this)
        unverifiedPlayersRepository.clear()
    }

}