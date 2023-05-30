package me.milk_and_cereal.verify.util

class Generator {

    companion object {

        fun generateRandomString(length: Int): String {
            val allowedChars = ('A'..'Z') + ('a'..'z') + ('0'..'9')
            return (1..length)
                .map { allowedChars.random() }
                .joinToString("")
        }

    }

}