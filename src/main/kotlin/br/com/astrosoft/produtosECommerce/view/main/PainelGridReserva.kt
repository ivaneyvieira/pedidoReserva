package br.com.astrosoft.produtosECommerce.view.main

import br.com.astrosoft.framework.view.FilterBar
import br.com.astrosoft.framework.view.PainelGrid
import br.com.astrosoft.produtosECommerce.model.beans.PedidoReserva
import br.com.astrosoft.produtosECommerce.model.beans.ProdutoPedido
import br.com.astrosoft.produtosECommerce.viewmodel.IPainelReserva
import br.com.astrosoft.produtosECommerce.viewmodel.IPedidoReservaView
import br.com.astrosoft.produtosECommerce.viewmodel.PedidoReservaViewModel
import com.vaadin.flow.component.grid.Grid
import com.vaadin.flow.component.textfield.IntegerField
import com.vaadin.flow.data.value.ValueChangeMode.EAGER

class PainelGridReserva(val view: PedidoReservaViewModel): PainelGrid<PedidoReserva>(),
                                                           IPainelReserva {
  private lateinit var edtPedido: IntegerField
  override fun filterBar() = FilterBar{
    edtPedido = edtPedido {
      this.valueChangeMode = EAGER
      addValueChangeListener {
        updateGrid()
      }
    }
  }
  
  override fun createGrid()= Grid(PedidoReserva::class.java, false)
  
  override fun Grid<PedidoReserva>.gridConfig() {
    this.colLoja()
    this.colnumPedido()
    this.colDataPedido()
    this.colRota()
    this.colNotaFiscal()
    this.colNotaTransf()
    this.colNotaTransfData()
  }
  
  override val numPedido: Int
    get() = edtPedido.value ?: 0
  
  override fun updateGrid() {
    val pedidos = view.pedidoReserva(numPedido)
    updateGrid(pedidos)
  }
  
  override fun showDlgPedido(pedido: PedidoReserva) {
    TODO("Not yet implemented")
  }
}



