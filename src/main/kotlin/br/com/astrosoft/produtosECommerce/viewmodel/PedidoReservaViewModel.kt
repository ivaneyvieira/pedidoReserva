package br.com.astrosoft.produtosECommerce.viewmodel

import br.com.astrosoft.framework.viewmodel.IView
import br.com.astrosoft.framework.viewmodel.ViewModel
import br.com.astrosoft.produtosECommerce.model.beans.PedidoReserva

class PedidoReservaViewModel(view: IPedidoReservaView): ViewModel<IPedidoReservaView>(view) {
  fun updateGrid() {
  }
  
  fun findPedido(numPedido: Int): PedidoReserva? {
    return PedidoReserva.findPedido(numPedido)
      .firstOrNull()
  }
  
  fun pedidoReserva(numPedido: Int): List<PedidoReserva> {
    return PedidoReserva.findReserva()
      .filter {it.numPedido == numPedido}
  }
}

interface IPainelPedido {
  val numPedido: Int
  fun updateGrid()
}

interface IPainelReserva {
  val numPedido: Int
  fun updateGrid()
  fun showDlgPedido(pedido: PedidoReserva)
}

interface IPedidoReservaView: IView {
  val painelPedido: IPainelPedido
  val painelReserva: IPainelReserva
}
