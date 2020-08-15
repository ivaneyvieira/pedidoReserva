package br.com.astrosoft.produtosECommerce.viewmodel

import br.com.astrosoft.framework.viewmodel.IView
import br.com.astrosoft.framework.viewmodel.ViewModel
import br.com.astrosoft.produtosECommerce.model.beans.PedidoReserva

class PedidoReservaViewModel(view: IPedidoReservaView): ViewModel<IPedidoReservaView>(view) {
}

interface IPainelPedido {
  val numPedido : Int
  fun updateGrid(itens: List<PedidoReserva>)
}

interface IPainelReserva {
  val numPedido : Int
  fun updateGrid(itens: List<PedidoReserva>)
}

interface IPedidoReservaView: IView {
  val painelPedido: IPainelPedido
  val painelReserva: IPainelReserva
  
  fun openGridPedido()
  fun openGridReserva()
}
