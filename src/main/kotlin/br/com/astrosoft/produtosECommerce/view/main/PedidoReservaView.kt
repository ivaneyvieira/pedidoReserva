package br.com.astrosoft.produtosECommerce.view.main

import br.com.astrosoft.AppConfig
import br.com.astrosoft.framework.view.ViewLayout
import br.com.astrosoft.framework.view.tabGrid
import br.com.astrosoft.produtosECommerce.model.beans.EEditor
import br.com.astrosoft.produtosECommerce.model.beans.EEditor.BASE
import br.com.astrosoft.produtosECommerce.model.beans.EEditor.EDITADO
import br.com.astrosoft.produtosECommerce.model.beans.EEditor.EDITAR
import br.com.astrosoft.produtosECommerce.model.beans.EEditor.IMPORTADO
import br.com.astrosoft.produtosECommerce.model.beans.PedidoReserva
import br.com.astrosoft.produtosECommerce.view.layout.PedidoReservaLayout
import br.com.astrosoft.produtosECommerce.viewmodel.IFiltroBase
import br.com.astrosoft.produtosECommerce.viewmodel.IFiltroEditado
import br.com.astrosoft.produtosECommerce.viewmodel.IFiltroEditar
import br.com.astrosoft.produtosECommerce.viewmodel.IFiltroImportado
import br.com.astrosoft.produtosECommerce.viewmodel.IPedidoReservaView
import br.com.astrosoft.produtosECommerce.viewmodel.ProcessaBean
import br.com.astrosoft.produtosECommerce.viewmodel.PedidoReservaViewModel
import com.github.mvysny.karibudsl.v10.TabSheet
import com.github.mvysny.karibudsl.v10.bind
import com.github.mvysny.karibudsl.v10.checkBox
import com.github.mvysny.karibudsl.v10.horizontalLayout
import com.github.mvysny.karibudsl.v10.integerField
import com.github.mvysny.karibudsl.v10.isExpand
import com.github.mvysny.karibudsl.v10.tabSheet
import com.github.mvysny.karibudsl.v10.textField
import com.vaadin.flow.component.dependency.HtmlImport
import com.vaadin.flow.component.orderedlayout.VerticalLayout
import com.vaadin.flow.component.textfield.TextFieldVariant.LUMO_SMALL
import com.vaadin.flow.data.binder.Binder
import com.vaadin.flow.router.PageTitle
import com.vaadin.flow.router.Route

@Route(layout = PedidoReservaLayout::class, value = "produto")
@PageTitle(AppConfig.title)
@HtmlImport("frontend://styles/shared-styles.html")
class PedidoReservaView: ViewLayout<PedidoReservaViewModel>(), IPedidoReservaView {
  private var tabMain: TabSheet
  private val gridPedido = PainelGridPedido(this) {viewModel.updateGridBase()}
  private val gridReserva = PainelGridReserva(this) {viewModel.updateGridEditar()}

  override val viewModel: PedidoReservaViewModel = PedidoReservaViewModel(this)
  
  override fun isAccept() = true
  
  init {
    tabMain = tabSheet {
      setSizeFull()
      tabGrid(TAB_BASE, gridPedido)
      tabGrid(TAB_EDITAR, gridReserva)
    }
    viewModel.updateGrid()
  }
  
  
  companion object {
    const val TAB_EDITAR: String = "Pedido"
    const val TAB_EDITADO: String = "Editado"
  }
}

