package Filters

import Grids.GreyscaleGrid

/**
 * FilterController applies loaded filters from arguments to a greyscale grid
 * */
object FilterController{
  def apply(filters: Seq[Filter], greyColorGrid: GreyscaleGrid): GreyscaleGrid =  {
    var greyColorGridWithFilters = greyColorGrid

    for(filter <- filters)
      greyColorGridWithFilters = filter.applyFilter(greyColorGridWithFilters)

    greyColorGridWithFilters
  }
}
