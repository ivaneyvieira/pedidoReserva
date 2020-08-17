package br.com.astrosoft.produtosECommerce.view.main

import br.com.astrosoft.framework.view.addColumnDouble
import br.com.astrosoft.framework.view.addColumnInt
import br.com.astrosoft.framework.view.addColumnLocalDate
import br.com.astrosoft.framework.view.addColumnString
import br.com.astrosoft.produtosECommerce.model.beans.PedidoReserva
import br.com.astrosoft.produtosECommerce.model.beans.ProdutoPedido
import com.github.mvysny.karibudsl.v10.VaadinDsl
import com.github.mvysny.karibudsl.v10.integerField
import com.vaadin.flow.component.HasComponents
import com.vaadin.flow.component.grid.Grid
import com.vaadin.flow.component.textfield.IntegerField
import com.vaadin.flow.component.textfield.TextFieldVariant
import com.vaadin.flow.data.value.ValueChangeMode

// Colunas da classe PedidoReserva
fun Grid<PedidoReserva>.colLoja() = addColumnInt(PedidoReserva::loja) {
  setHeader("Lj")
  width = "4em"
}
fun Grid<PedidoReserva>.colnumPedido() = addColumnInt(PedidoReserva::numPedido) {
  setHeader("Pedido")
  width = "7em"
}
fun Grid<PedidoReserva>.colDataPedido() = addColumnLocalDate(PedidoReserva::dataPedido) {
  setHeader("Data")
}
fun Grid<PedidoReserva>.colCliente() = addColumnString(PedidoReserva::cliente) {
  setHeader("Cliente")
}
fun Grid<PedidoReserva>.colNotaFiscal() = addColumnString(PedidoReserva::notaFiscal) {
  setHeader("NF")
}
fun Grid<PedidoReserva>.colRota() = addColumnString(PedidoReserva::rota) {
  setHeader("Rota")
}
fun Grid<PedidoReserva>.colNotaTransf() = addColumnString(PedidoReserva::notaTransf) {
  setHeader("NF Transf")
}
fun Grid<PedidoReserva>.colNotaTransfData() = addColumnLocalDate(PedidoReserva::notaTransfData) {
  setHeader("Data")
}
// Colunas da classe ProdutoPedido
fun Grid<ProdutoPedido>.colCodigo() = addColumnString(ProdutoPedido::codigo) {
  setHeader("Código")
}
fun Grid<ProdutoPedido>.colGrade() = addColumnString(ProdutoPedido::grade) {
  setHeader("Grade")
}

fun Grid<ProdutoPedido>.colBarcode() = addColumnString(ProdutoPedido::barcode) {
  setHeader("Código de barras")
}
fun Grid<ProdutoPedido>.colDescricao() = addColumnString(ProdutoPedido::descricao) {
  setHeader("Descrição")
}

fun Grid<ProdutoPedido>.colUnidade() = addColumnString(ProdutoPedido::unidade) {
  setHeader("Un")
}

fun Grid<ProdutoPedido>.colLocalizacao() = addColumnString(ProdutoPedido::localizacao) {
  setHeader("Localização")
}

fun Grid<ProdutoPedido>.colQtty() = addColumnInt(ProdutoPedido::qtty) {
  setHeader("Qt")
}
fun Grid<ProdutoPedido>.colValorUnit() = addColumnDouble(ProdutoPedido::valorUnit) {
  setHeader("Valor Unit")
}
fun Grid<ProdutoPedido>.colValorTotal() = addColumnDouble(ProdutoPedido::valorTotal) {
  setHeader("Valor Total")
}
//Campos de filtro
fun (@VaadinDsl HasComponents).edtPedido(block: (@VaadinDsl IntegerField).() -> Unit = {}) = integerField("Pedido") {
  this.valueChangeMode = ValueChangeMode.TIMEOUT
  this.isAutofocus = true
  addThemeVariants(TextFieldVariant.LUMO_SMALL)
  block()
}


