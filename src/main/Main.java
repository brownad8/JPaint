package main;

import controller.IJPaintController;
import controller.JPaintController;
import model.dialogs.DialogProvider;
import model.interfaces.IDialogProvider;
import model.persistence.ApplicationState;
import model.persistence.clickHandler;
import view.gui.Gui;
import view.gui.GuiWindow;
import view.gui.PaintCanvas;
import view.interfaces.IGuiWindow;
import view.interfaces.IUiModule;

import java.awt.*;

public class Main {
    public static void main(String[] args){
        PaintCanvas canvas = new PaintCanvas();
        IGuiWindow guiWindow = new GuiWindow(canvas);
        IUiModule uiModule = new Gui(guiWindow);
        ApplicationState appState = new ApplicationState(uiModule);
        IJPaintController controller = new JPaintController(uiModule, appState);
        controller.setup();
        canvas.addMouseListener(new clickHandler());

        Graphics2D graphics2D = canvas.getGraphics2D();
        graphics2D.setColor(Color.black);
        graphics2D.fillRect(12, 13, 200, 400);
        graphics2D.setStroke(new BasicStroke(5));
        graphics2D.setColor(Color.blue);
        graphics2D.drawRect(12,13, 200, 400);

    }
}
