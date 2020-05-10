package by.babanin.lifecycleworld.gui.map.model;

import by.babanin.lifecycleworld.gui.map.hexagon.Hexagon;
import by.babanin.lifecycleworld.gui.map.hexagon.HexagonType;

import java.awt.*;
import java.util.ArrayList;

public class MapModel {
    private static final Point START_POSITION = new Point(0, 0);
    private static final Point INTERVAL = new Point(
            (int) (Hexagon.SIZE.width * 0.75),
            Hexagon.SIZE.height / 2
    );

    private int rows;
    private int columns;
    private ArrayList<ArrayList<Hexagon>> map;

    public MapModel(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        createMap();
    }

    private void createMap() {
        map = new ArrayList<>(rows);
        for (int i = 0; i < rows; i++) {
            ArrayList<Hexagon> row = new ArrayList<>(columns);
            for (int j = 0; j < columns; j++) {
                row.add(j, createHexagon(i, j));
            }
            map.add(i, row);
        }
    }

    private Hexagon createHexagon(int row, int column) {
        Point center = new Point(
                START_POSITION.x + INTERVAL.x * column,
                START_POSITION.y + (column % 2 == 0 ? 0 : INTERVAL.y) + Hexagon.SIZE.height * row
        );
        return new Hexagon(HexagonType.GRASS, center);
    }

    private void updateModel() {
        createMap();
    }

    public Hexagon get(int indexRow, int indexColumn) {
        return map.get(indexRow).get(indexColumn);
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setMapSize(MapSize mapSize) {
        rows = mapSize.getRows();
        columns = mapSize.getColumns();
        updateModel();
    }

}
