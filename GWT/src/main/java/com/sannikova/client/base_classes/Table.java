package com.sannikova.client.base_classes;


import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

import java.util.List;

public class Table extends FlexTable {
    private static final int title_id = 0;
    private int col_rows = 0;

    public Table(Object[] col_names) {
        this.insertRow(Table.title_id);
        this.col_rows = this.col_rows + 1;

        for(Object col : col_names) {
            this.addColumn(col);
        }
    }

    private Widget createCellWidget(Object cellObject) {
        Widget widget = null;

        if(cellObject instanceof Widget) {
            widget = (Widget) cellObject;
        } else {
            widget = new Label(cellObject.toString());
        }

        return widget;
    }

    private void addColumn(Object name) {
        Widget widget = createCellWidget(name);
        int cell = this.getCellCount(Table.title_id);

        widget.setWidth("100%");
        widget.addStyleName("gwtTitleTable");
        this.setWidget(Table.title_id, cell, widget);

    }

    public void addRow(List<Object> data) {
        for (int i = 0; i < data.size(); i++) {
            Widget widget = createCellWidget(data.get(i));
            this.setWidget(col_rows, i, widget);
            this.getCellFormatter().addStyleName(col_rows, i, "gwtRowTable");
        }

        col_rows = col_rows + 1;
    }

    public void clear() {
        while(col_rows - 1 != Table.title_id) {
            this.removeRow(col_rows - 1);
            this.col_rows = this.col_rows - 1;
        }
    }

    public void applyZebra() {
        RowFormatter rf = this.getRowFormatter();

        for (int row = 1; row < this.getRowCount(); ++row) {
            if ((row % 2) != 0) {
                rf.setStyleName(row, "gwtZebraOne");
            }
            else {
                rf.setStyleName(row, "gwtZebraTwo");
            }
        }
    }
}