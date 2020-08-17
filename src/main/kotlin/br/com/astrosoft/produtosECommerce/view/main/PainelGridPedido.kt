package br.com.astrosoft.produtosECommerce.view.main

import br.com.astrosoft.framework.view.FilterBar
import br.com.astrosoft.framework.view.PainelGrid
import br.com.astrosoft.produtosECommerce.model.beans.ProdutoPedido
import br.com.astrosoft.produtosECommerce.viewmodel.IPainelPedido
import br.com.astrosoft.produtosECommerce.viewmodel.PedidoReservaViewModel
import com.github.mvysny.karibudsl.v10.textField
import com.vaadin.flow.component.grid.Grid
import com.vaadin.flow.component.grid.Grid.SelectionMode.MULTI
import com.vaadin.flow.component.textfield.IntegerField
import com.vaadin.flow.component.textfield.TextField
import com.vaadin.flow.data.value.ValueChangeMode.EAGER

class PainelGridPedido(val view: PedidoReservaViewModel): PainelGrid<ProdutoPedido>(), IPainelPedido {
  private lateinit var lblNotaFiscal: TextField
  private lateinit var edtPedido: IntegerField
  
  override fun filterBar() = FilterBar {
    edtPedido = edtPedido {
      this.valueChangeMode = EAGER
      addValueChangeListener {
        updateGrid()
      }
    }
    lblNotaFiscal = textField("NF") {
      this.isReadOnly = true
    }
  }
  
  override fun createGrid() = Grid(ProdutoPedido::class.java, false)
  
  override fun Grid<ProdutoPedido>.gridConfig() {
    setSelectionMode(MULTI)
    this.colCodigo()
    this.colDescricao()
    this.colUnidade()
    this.colQtty()
    this.colValorUnit()
    this.colValorTotal()
  }
  
  override val numPedido: Int
    get() = edtPedido.value ?: 0
  
  override fun updateGrid() {
    val pedido = view.findPedido(numPedido)
    lblNotaFiscal.value = pedido?.notaFiscal ?: ""
    updateGrid(pedido?.produtos().orEmpty())
  }
}



