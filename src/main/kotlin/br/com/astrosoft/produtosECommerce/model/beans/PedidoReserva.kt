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
  val rota: String,
  val notaTransf : String,
  val notaTransfData : LocalDate,
  val status: Int
                   ) {
  
  val notaFiscal: String
    get() = numeroNota(nfno, nfse)
  
  val statusPedido
    get() = StatusPedido.values()
      .toList()
      .firstOrNull {it.numero == status}
  
  private fun numeroNota(nfno: Int, nfse: String): String {
    return when {
      nfno == 0 -> ""
      nfse == "" -> nfno.toString()
      else       -> "$nfno/$nfse"
    }
  }
  companion object {
    private val userSaci: UserSaci
      get() = AppConfig.userSaci as UserSaci
    
    fun findPedido(numPedido : Int) = saci.pedidoRetira(userSaci.storeno, numPedido)
    
    fun findReserva() = saci.pedidoRetira(userSaci.storeno)
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

enum class StatusPedido(val numero: Int, val descricao: String) {
  INCLUIDO(0, "Incluído"),
  ORCADO(1, "Orçado"),
  RESERVADO(2, "Reservado"),
  VENDIDO(3, "Vendido"),
  EXPIRADO(4, "Expirado"),
  CANCELADO(5, "Cancelado"),
  RESERVADO_B(6, "Reserva B"),
  TRANSITO(7, "Trânsito"),
  FUTURA(8, "Futura");
  
  override fun toString() = descricao
}