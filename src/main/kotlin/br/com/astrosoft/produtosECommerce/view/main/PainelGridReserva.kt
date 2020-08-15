package br.com.astrosoft.produtosECommerce.view.main

import br.com.astrosoft.framework.view.FilterBar
import br.com.astrosoft.produtosECommerce.viewmodel.IPedidoReservaView

class PainelGridReserva(view: IPedidoReservaView, blockUpdate: () -> Unit): PainelGridAbstract(view, blockUpdate),
                                                                            IPanelReserva {
  override fun filterBar() = FilterBarEditar()
  
  inner class FilterBarEditar: FilterBar() {
    override fun FilterBar.contentBlock() {
    }
  }
}



