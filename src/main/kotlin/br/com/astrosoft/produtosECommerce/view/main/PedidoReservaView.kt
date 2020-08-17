package br.com.astrosoft.produtosECommerce.view.main

import br.com.astrosoft.AppConfig
import br.com.astrosoft.framework.view.ViewLayout
import br.com.astrosoft.framework.view.tabGrid
import br.com.astrosoft.produtosECommerce.view.layout.PedidoReservaLayout
import br.com.astrosoft.produtosECommerce.viewmodel.IPainelPedido
import br.com.astrosoft.produtosECommerce.viewmodel.IPainelReserva
import br.com.astrosoft.produtosECommerce.viewmodel.IPedidoReservaView
import br.com.astrosoft.produtosECommerce.viewmodel.PedidoReservaViewModel
import com.github.mvysny.karibudsl.v10.TabSheet
import com.github.mvysny.karibudsl.v10.tabSheet
import com.vaadin.flow.component.dependency.HtmlImport
import com.vaadin.flow.router.PageTitle
import com.vaadin.flow.router.Route

@Route(layout = PedidoReservaLayout::class, value = "produto")
@PageTitle(AppConfig.title)
@HtmlImport("frontend://styles/shared-styles.html")
class PedidoReservaView: ViewLayout<PedidoReservaViewModel>(), IPedidoReservaView {
  private var tabMain: TabSheet
  override val viewModel: PedidoReservaViewModel = PedidoReservaViewModel(this)
  private val gridPedido = PainelGridPedido(viewModel)
  private val gridReserva = PainelGridReserva(viewModel)
  
  override fun isAccept() = true
  
  init {
    tabMain = tabSheet {
      setSizeFull()
      tabGrid(TAB_PEDIDO, gridPedido)
      tabGrid(TAB_RESERVA, gridReserva)
    }
    viewModel.updateGrid()
  }
  
  override val painelPedido: IPainelPedido
    get() = gridPedido
  override val painelReserva: IPainelReserva
    get() = gridReserva
  

  
  companion object {
    const val TAB_PEDIDO: String = "Pedido"
    const val TAB_RESERVA: String = "Reserva"
  }
}

