package com.gestionplus.app.Entidades

class PersonaEc {
    fun validateId(id: String): Boolean {
        if (id.length != 10) return false
        val numberOfProvince = id.substring(0, 2).toIntOrNull() ?: return false
        if (numberOfProvince !in 1..24) return false
        val digitos = id.map { it.toString().toIntOrNull() ?: return false }
        val coefficients = listOf(1, 2, 1, 2, 1, 2, 1, 2)
        val suma = id.take(9).mapIndexed { index, digit ->
            val mult = digit.digitToInt() * coefficients[index]
            if (mult > 9) mult - 9 else mult
        }.sum()
        val digitoVerificador = if (suma % 10 == 0) 0 else 10 - (suma % 10)
        return digitoVerificador == digitos[9]
    }
}