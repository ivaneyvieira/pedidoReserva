package br.com.astrosoft.produtosECommerce.view.main

import br.com.astrosoft.framework.view.PainelGrid
import br.com.astrosoft.produtosECommerce.model.beans.PedidoReserva
import br.com.astrosoft.produtosECommerce.viewmodel.IPedidoReservaView
import com.github.mvysny.karibudsl.v10.grid
import com.vaadin.flow.component.grid.Grid
import com.vaadin.flow.component.grid.Grid.SelectionMode.MULTI

abstract class PainelGridAbstract(val view: IPedidoReservaView, blockUpdate: () -> Unit):
  PainelGrid<PedidoReserva>(blockUpdate) {
  override fun createGrid() = Grid(PedidoReserva::class.java, false)
  
  override fun Grid<PedidoReserva>.gridConfig() {
    setSelectionMode(MULTI)
  }
}


