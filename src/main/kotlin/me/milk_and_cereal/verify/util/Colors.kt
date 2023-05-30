package me.milk_and_cereal.verify.util

import org.bukkit.ChatColor

class Colors {

    companion object {

        fun translate(color: String) : String {
            return ChatColor.translateAlternateColorCodes('&', color)
        }

    }


}