public class Clone987 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:7230819
*  Stack Overflow answer #:19809118
*  And Stack Overflow answer#:19809861
*/
private void transform (XSSFWorkbook workbookOld, HSSFWorkbook workbookNew, XSSFRow rowOld, HSSFRow rowNew) {
    HSSFCell cellNew;
    rowNew.setHeight (rowOld.getHeight ());
    for (Cell cell : rowOld) {
        cellNew = rowNew.createCell (cell.getColumnIndex (), cell.getCellType ());
        if (cellNew != null) this.transform (workbookOld, workbookNew, (XSSFCell) cell, cellNew);
    }
    this.lastColumn = Math.max (this.lastColumn, rowOld.getLastCellNum ());
}

private void transform (HSSFWorkbook workbookOld, XSSFWorkbook workbookNew, HSSFSheet sheetOld, XSSFSheet sheetNew) {
    System.out.println ("transform Sheet");
    sheetNew.setDisplayFormulas (sheetOld.isDisplayFormulas ());
    sheetNew.setDisplayGridlines (sheetOld.isDisplayGridlines ());
    sheetNew.setDisplayGuts (sheetOld.getDisplayGuts ());
    sheetNew.setDisplayRowColHeadings (sheetOld.isDisplayRowColHeadings ());
    sheetNew.setDisplayZeros (sheetOld.isDisplayZeros ());
    sheetNew.setFitToPage (sheetOld.getFitToPage ());
    sheetNew.setHorizontallyCenter (sheetOld.getHorizontallyCenter ());
    sheetNew.setMargin (Sheet.BottomMargin, sheetOld.getMargin (Sheet.BottomMargin));
    sheetNew.setMargin (Sheet.FooterMargin, sheetOld.getMargin (Sheet.FooterMargin));
    sheetNew.setMargin (Sheet.HeaderMargin, sheetOld.getMargin (Sheet.HeaderMargin));
    sheetNew.setMargin (Sheet.LeftMargin, sheetOld.getMargin (Sheet.LeftMargin));
    sheetNew.setMargin (Sheet.RightMargin, sheetOld.getMargin (Sheet.RightMargin));
    sheetNew.setMargin (Sheet.TopMargin, sheetOld.getMargin (Sheet.TopMargin));
    sheetNew.setPrintGridlines (sheetNew.isPrintGridlines ());
    sheetNew.setRowSumsBelow (sheetNew.getRowSumsBelow ());
    sheetNew.setRowSumsRight (sheetNew.getRowSumsRight ());
    sheetNew.setVerticallyCenter (sheetOld.getVerticallyCenter ());
    XSSFRow rowNew;
    for (Row row : sheetOld) {
        rowNew = sheetNew.createRow (row.getRowNum ());
        if (rowNew != null) this.transform (workbookOld, workbookNew, (HSSFRow) row, rowNew);
    }
    for (int i = 0;
    i < this.lastColumn; i ++) {
        sheetNew.setColumnWidth (i, sheetOld.getColumnWidth (i));
        sheetNew.setColumnHidden (i, sheetOld.isColumnHidden (i));
    }
    for (int i = 0;
    i < sheetOld.getNumMergedRegions (); i ++) {
        CellRangeAddress merged = sheetOld.getMergedRegion (i);
        sheetNew.addMergedRegion (merged);
    }
}

}
