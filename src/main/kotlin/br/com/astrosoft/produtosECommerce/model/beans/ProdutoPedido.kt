package br.com.astrosoft.produtosECommerce.model.beans

class ProdutoPedido(
  val loja: Int,
  val numPedido: Int,
  val codigo: String,
  val barcode: String,
  val grade : String,
  val refFab: String,
  val descricao: String,
  val unidade: String,
  val localizacao: String,
  val qtty: Int,
  val valorUnit: Double,
  val valorTotal: Double
                   ) {
  override fun equals(other: Any?): Boolean {
    if(this === other) return true
    if(javaClass != other?.javaClass) return false
    
    other as ProdutoPedido
    
    if(loja != other.loja) return false
    if(numPedido != other.numPedido) return false
    if(codigo != other.codigo) return false
    if(grade != other.grade) return false
    
    return true
  }
  
  override fun hashCode(): Int {
    var result = loja
    result = 31 * result + numPedido
    result = 31 * result + codigo.hashCode()
    result = 31 * result + grade.hashCode()
    return result
  }
}