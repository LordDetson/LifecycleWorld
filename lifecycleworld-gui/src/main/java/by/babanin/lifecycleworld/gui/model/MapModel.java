package by.babanin.lifecycleworld.gui.model;

import by.babanin.lifecycleworld.gui.shape.Hexagon;

import java.awt.*;
import java.util.ArrayList;

public class MapModel {
    private static final Point START_POSITION = new Point(0, 0);
    private static final Point INTERVAL = new Point(
            Hexagon.SIZE.width + Hexagon.SIZE.width / 2,
            Hexagon.SIZE.height / 2
    );
    private static final int OFFSET = (int) (Hexagon.SIZE.width * 0.75);

    private int rows;
    private int columnsR1;
    private int columnsR2;
    private boolean isFirst;
    private ArrayList<ArrayList<Hexagon>> map;

    public MapModel(int rows, int columns, boolean isFirst) {
        int buf = columns / 2;
        this.rows = rows + buf;
        this.isFirst = isFirst;
        if (!isFirst) START_POSITION.x += (int) (Hexagon.SIZE.width * 0.75);
        columns = buf;
        this.columnsR1 = isFirst ? columns : columns + 1;
        this.columnsR2 = isFirst ? columns + 1 : columns;
        createMap();
    }

    private void createMap() {
        map = new ArrayList<>(rows);
        for (int i = 0; i < rows; i++) {
            int capacity = (checkRow(i)) ? columnsR1 : columnsR2;
            ArrayList<Hexagon> row = new ArrayList<>(capacity);
            for (int j = 0; j < capacity; j++) {
                row.add(j, createHexagon(i, j));
            }
            map.add(i, row);
        }
    }

    private boolean checkRow(int row) {
        return row % 2 == 0;
    }

    private Hexagon createHexagon(int row, int column) {
        int buf = ((checkRow(row)) ? OFFSET : 0) * ((isFirst) ? 1 : -1);
        Point center = new Point(
                START_POSITION.x + INTERVAL.x * column + buf,
                START_POSITION.y + INTERVAL.y * row);
        return new Hexagon(center);
    }

    public Hexagon get(int indexRow, int indexColumn) {
        return map.get(indexRow).get(indexColumn);
    }

    public int getRows() {
        return rows;
    }

    public int getColumnsByRow(int row) {
        return checkRow(row) ? columnsR1 : columnsR2;
    }

    public int getMaxColumns() {
        return columnsR1 > columnsR2 ? columnsR1 : columnsR2;
    }
}
