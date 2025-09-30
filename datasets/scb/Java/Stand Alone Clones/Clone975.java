public class Clone975 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:7230819
*  Stack Overflow answer #:19809118
*  And Stack Overflow answer#:19809861
*/
private void transform (XSSFWorkbook workbookOld, HSSFWorkbook workbookNew, XSSFSheet sheetOld, HSSFSheet sheetNew) {
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
    sheetNew.setRightToLeft (sheetNew.isRightToLeft ());
    sheetNew.setRowSumsBelow (sheetNew.getRowSumsBelow ());
    sheetNew.setRowSumsRight (sheetNew.getRowSumsRight ());
    sheetNew.setVerticallyCenter (sheetOld.getVerticallyCenter ());
    HSSFRow rowNew;
    for (Row row : sheetOld) {
        rowNew = sheetNew.createRow (row.getRowNum ());
        if (rowNew != null) this.transform (workbookOld, workbookNew, (XSSFRow) row, rowNew);
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

private void transform (HSSFWorkbook workbookOld, XSSFWorkbook workbookNew, HSSFCell cellOld, XSSFCell cellNew) {
    cellNew.setCellComment (cellOld.getCellComment ());
    Integer hash = cellOld.getCellStyle ().hashCode ();
    if (this.styleMap != null && ! this.styleMap.containsKey (hash)) {
        this.transform (workbookOld, workbookNew, hash, cellOld.getCellStyle (), (XSSFCellStyle) workbookNew.createCellStyle ());
    }
    cellNew.setCellStyle (this.styleMap.get (hash));
    switch (cellOld.getCellType ()) {
        case Cell.CELL_TYPE_BLANK :
            break;
        case Cell.CELL_TYPE_BOOLEAN :
            cellNew.setCellValue (cellOld.getBooleanCellValue ());
            break;
        case Cell.CELL_TYPE_ERROR :
            cellNew.setCellValue (cellOld.getErrorCellValue ());
            break;
        case Cell.CELL_TYPE_FORMULA :
            cellNew.setCellValue (cellOld.getCellFormula ());
            break;
        case Cell.CELL_TYPE_NUMERIC :
            cellNew.setCellValue (cellOld.getNumericCellValue ());
            break;
        case Cell.CELL_TYPE_STRING :
            cellNew.setCellValue (cellOld.getStringCellValue ());
            break;
        default :
            System.out.println ("transform: Unbekannter Zellentyp " + cellOld.getCellType ());
    }
}

}
