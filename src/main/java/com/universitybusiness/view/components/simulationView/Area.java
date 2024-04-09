package com.universitybusiness.view.components.simulationView;

import com.universitybusiness.view.util.BuildingInstance;
import com.universitybusiness.view.WindowManager;
import com.universitybusiness.view.util.BuildingDraw;
import com.universitybusiness.view.viewModel.SimulationViewModel;

import javax.swing.*;
import java.awt.*;


public class Area extends JPanel {
    private final SimulationViewModel simulationViewModel;
    private final Integer woodenBuildingSide;
    private final Integer capitalBuildingSide;
    private final Image woodenBuildingImage;
    private final Image capitalBuildingImage;

    public Area(SimulationViewModel viewModel) {
        this.simulationViewModel = viewModel;

        this.woodenBuildingSide = BuildingDraw.getWoodenBuildingSide();
        this.capitalBuildingSide = BuildingDraw.getCapitalBuildingSide();

        this.woodenBuildingImage = WindowManager
                .getImageFactory()
                .getWoodenBuilding()
                .getScaledInstance(this.woodenBuildingSide, this.woodenBuildingSide, Image.SCALE_SMOOTH);

        this.capitalBuildingImage = WindowManager
                .getImageFactory()
                .getCapitalBuilding()
                .getScaledInstance(this.capitalBuildingSide, this.capitalBuildingSide, Image.SCALE_SMOOTH);
    }

    public void reset() {
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        g2d.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);


        for (BuildingInstance buildingInstance : simulationViewModel.getBuildingsDictionary().values()) {
            if (buildingInstance.isCapitalBuilding()) {
                g2d.drawImage(
                        this.capitalBuildingImage,
                        buildingInstance.getX() - (this.capitalBuildingSide / 2),
                        buildingInstance.getY() - (this.capitalBuildingSide / 2),
                        this);
            } else if (buildingInstance.isWoodenBuilding()) {
                g2d.drawImage(
                        this.woodenBuildingImage,
                        buildingInstance.getX() - (this.woodenBuildingSide / 2),
                        buildingInstance.getY() - (this.woodenBuildingSide / 2),
                        this);
            }
        }

        if (simulationViewModel.isShowTime()) {
            g2d.setColor(Color.BLACK);
            g2d.setFont(WindowManager.getFontFactory().getKadwaRegularFont().deriveFont(Font.PLAIN, 15));
            g2d.drawString("Time: " + simulationViewModel.getSimulationTime() / 1000 + "s", getWidth() - 100,30);
        }
    }
}
