package br.com.alura.orgs.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.alura.orgs.model.Usuario
import kotlinx.coroutines.flow.Flow

@Dao
interface UsuarioDao {

    @Insert
    suspend fun save(usuario: Usuario)

    @Query("SELECT * FROM usuario WHERE id = :usuarioId AND senha = :senha")
    suspend fun autentica(usuarioId: String, senha: String): Usuario?

    @Query("SELECT * FROM usuario WHERE id = :usuarioId")
    fun buscarUsuario(usuarioId: String): Flow<Usuario>
}