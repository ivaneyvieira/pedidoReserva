package br.com.astrosoft.produtosECommerce.model

import br.com.astrosoft.framework.model.QueryDB
import br.com.astrosoft.framework.util.DB
import br.com.astrosoft.produtosECommerce.model.beans.PedidoReserva
import br.com.astrosoft.produtosECommerce.model.beans.ProdutoPedido
import br.com.astrosoft.produtosECommerce.model.beans.UserSaci

class QuerySaci: QueryDB("saci", driver, url, username, password) {
  fun findUser(login: String?): List<UserSaci> {
    login ?: return emptyList()
    val sql = "/sqlSaci/userSenha.sql"
    return query(sql, UserSaci::class) {
      addParameter("login", login)
    }
  }
  
  fun findAllUser(): List<UserSaci> {
    val sql = "/sqlSaci/userSenha.sql"
    return query(sql, UserSaci::class) {
      addParameter("login", "TODOS")
    }
  }
  
  fun updateUser(user: UserSaci) {
    val sql = "/sqlSaci/updateUser.sql"
    script(sql) {
      addOptionalParameter("no", user.no)
      addOptionalParameter("bitAcesso", user.bitAcesso)
      addOptionalParameter("storeno", user.storeno)
    }
  }
  
  private fun pedidoRetira(loja: Int, numPedido: Int, tipo: String): List<PedidoReserva> {
    val sql = "/sqlSaci/pedidoReserva.sql"
    return query(sql, PedidoReserva::class) {
      addParameter("loja", loja)
      addParameter("numPedido", numPedido)
      addParameter("tipo", tipo)
    }
  }
  
  fun pedidoRetira(loja: Int, numPedido: Int): List<PedidoReserva> {
    return pedidoRetira(loja, numPedido, "P")
  }
  
  fun pedidoRetira(loja : Int): List<PedidoReserva> {
    return pedidoRetira(loja, 0, "R")
  }
  
  fun produtoPedido(loja: Int, numPedido: Int): List<ProdutoPedido> {
    val sql = "/sqlSaci/produtoPedido.sql"
    return query(sql, ProdutoPedido::class) {
      addParameter("loja", loja)
      addParameter("numPedido", numPedido)
    }
  }
  
  companion object {
    private val db = DB("saci")
    internal val driver = db.driver
    internal val url = db.url
    internal val username = db.username
    internal val password = db.password
    internal val test = db.test
    val ipServer =
      url.split("/")
        .getOrNull(2)
  }
}

val saci = QuerySaci()