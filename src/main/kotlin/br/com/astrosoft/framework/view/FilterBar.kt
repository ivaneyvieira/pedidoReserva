package br.com.astrosoft.framework.view

import com.github.mvysny.karibudsl.v10.content
import com.vaadin.flow.component.orderedlayout.HorizontalLayout

class FilterBar(private val contentBlock: FilterBar.() -> Unit): HorizontalLayout() {
  init {
    isMargin = false
    isPadding = false
    isSpacing = true
    content {align(left, baseline)}
    width = "100%"
    addComponents()
  }
  
  private fun addComponents() {
    contentBlock()
  }
}


