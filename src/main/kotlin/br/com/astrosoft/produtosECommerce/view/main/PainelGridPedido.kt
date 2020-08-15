package br.com.astrosoft.produtosECommerce.view.main

import br.com.astrosoft.framework.view.FilterBar
import br.com.astrosoft.produtosECommerce.viewmodel.IFiltroPedido
import br.com.astrosoft.produtosECommerce.viewmodel.IPainelPedido
import br.com.astrosoft.produtosECommerce.viewmodel.IPedidoReservaView

class PainelGridPedido(view: IPedidoReservaView, blockUpdate: () -> Unit): PainelGridAbstract(view, blockUpdate),
                                                                           IPainelPedido {
  override fun filterBar() = FilterBarBase()
  
  inner class FilterBarBase: FilterBar() {
    override fun FilterBar.contentBlock() {
    }
  }
  
  override val numPedido: Int
    get() = TODO("Not yet implemented")
}



