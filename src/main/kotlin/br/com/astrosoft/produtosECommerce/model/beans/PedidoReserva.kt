package br.com.astrosoft.produtosECommerce.model.beans

import br.com.astrosoft.AppConfig
import br.com.astrosoft.produtosECommerce.model.saci
import java.time.LocalDate

class PedidoReserva(
  val loja: Int,
  val numPedido: Int,
  val dataPedido: LocalDate,
  val codigoCliente: Int,
  val cliente: String,
  val nfno: Int,
  val nfse: String,
  val status: Int
                   ) {
  
  
  companion object {
    private val userSaci: UserSaci
      get() = AppConfig.userSaci as UserSaci
    
    fun findPedido(numPedido : Int) = saci.pedidoRetira(userSaci.storeno, numPedido)
    
    fun findReserva() = saci.pedidoRetira()
  }
  
  override fun equals(other: Any?): Boolean {
    if(this === other) return true
    if(javaClass != other?.javaClass) return false
    
    other as PedidoReserva
    
    if(loja != other.loja) return false
    if(numPedido != other.numPedido) return false
    
    return true
  }
  
  override fun hashCode(): Int {
    var result = loja
    result = 31 * result + numPedido
    return result
  }
  
  fun produtos() : List<ProdutoPedido> = saci.produtoPedido(loja, numPedido)
}
