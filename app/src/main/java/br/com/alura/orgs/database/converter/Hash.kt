package br.com.alura.orgs.database.converter

import java.security.MessageDigest

fun String.toHash(algoritmo: String = "SHA-256"): String {
    return MessageDigest.getInstance(algoritmo).digest(this.toByteArray()).fold("") { str, byte ->
        str + "%02x".format(byte)
    }
}