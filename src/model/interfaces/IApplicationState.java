package model.interfaces;

import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;
import model.StartAndEndPointMode;
import model.persistence.ShapeList;

public interface IApplicationState {
    void setActiveShape();

    void setActivePrimaryColor();

    void setActiveSecondaryColor();

    void setActiveShadingType();

    void setActiveStartAndEndPointMode();

    ShapeType getActiveShapeType();

    ShapeColor getActivePrimaryColor();

    ShapeColor getActiveSecondaryColor();

    ShapeShadingType getActiveShapeShadingType();

    StartAndEndPointMode getActiveStartAndEndPointMode();

    ShapeList getShapeList();

    ShapeList getSelectedShapes();

    ShapeList getClipboard();

    void addToShapeList(IShape shape);

    void removeFromShapeList(IShape shape);

    void emptyShapeList();

    void addToClipboard(IShape shape);

    void emptyClipboard();

    void emptySelectedShapes();

}
