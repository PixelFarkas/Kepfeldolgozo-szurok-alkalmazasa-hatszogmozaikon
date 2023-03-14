package com.example.szakdolgozat;


import com.example.szakdolgozat.JFrame.HexFrame;
import com.example.szakdolgozat.Masks.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HexagonController implements Initializable {

    public static BufferedImage bimg;
    public static BufferedImage resizedImage;
    public String imagepath;
    public TextField path;
    public RadioButton mean;
    public RadioButton unsharp;
    public RadioButton gauss;
    public RadioButton sobel;
    public RadioButton freiChen;
    public TextField savePath;
    public ToggleGroup mask;
    public ComboBox<Integer> meanradius;
    public ComboBox<Integer> gaussradius;
    public ListView<String> masks;

    public static void infoBox(String infoMessage, String titleBar) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titleBar);
        alert.setContentText(infoMessage);
        alert.setHeaderText(null);
        alert.showAndWait();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        masks.getItems().addAll();
        meanradius.getItems().removeAll(meanradius.getItems());
        meanradius.getItems().addAll(1, 2, 3);
        gaussradius.getItems().removeAll(gaussradius.getItems());
        gaussradius.getItems().addAll(3, 5, 7);

    }

    public void onDeleteMask() {
        masks.getSelectionModel().getSelectedIndex();
        masks.getItems().remove(masks.getSelectionModel().getSelectedIndex());
    }

    public void onAddMask() {
        if (gauss.isSelected()) {
            if (gaussradius.getValue() == null) {
                infoBox("Adjon meg egy sugarat a művelethez", "Hiányzó gauss sugár");
            } else {
                masks.getItems().add("Gauss-szűrő " + gaussradius.getValue());
            }
        }
        if (mean.isSelected()) {
            if (meanradius.getValue() == null) {
                infoBox("Adjon meg egy sugarat a művelethez", "Hiányzó átlag sugár");
            } else {
                masks.getItems().add("Átlagoló szűrő " + meanradius.getValue());
            }
        }

        if (unsharp.isSelected()) {
            masks.getItems().add("Unsharp szűrő");

        }
        if (sobel.isSelected()) {
            masks.getItems().add("Sobel operátor");

        }
        if (freiChen.isSelected()) {
            masks.getItems().add("Frei-Chen filter");

        }

    }

    @FXML
    protected void onStart() {
        try {
            File file = new File(savePath.getText());
            File file2 = new File(path.getText());

            if (path.getText().equals("")) {
                infoBox("Adja meg a kép elérési útvonalát", "Hibás útvonal");
            } else if (savePath.getText().equals("")) {
                infoBox("Adja meg a kép mentési helyét", "Hibás útvonal");
            } else if (!file2.exists()) {
                infoBox("A megadott eléréi útvonal hibás, vagy a file nem létezik", "Hibás útvonal");
            } else if (!file.getParentFile().exists()) {
                infoBox("A megadott mentési útvonal hibás, vagy a mappa nem létezik", "Hibás útvonal");
            } else {
                Picture.savepath = savePath.getText();
                imagepath = path.getText();
                BufferedImage image;
                Picture picture;
                File input = new File(imagepath);
                Picture.path = path.getText();
                try {
                    bimg = ImageIO.read(new File(String.valueOf(input)));
                } catch (IOException e) {
                    e.printStackTrace();
                }

                resizedImage = new BufferedImage(bimg.getWidth() / 6, bimg.getHeight() / 8, BufferedImage.TYPE_INT_RGB);
                Graphics2D graphics2D = resizedImage.createGraphics();
                graphics2D.drawImage(bimg, 0, 0, bimg.getWidth() / 6, bimg.getHeight() / 8, null);
                graphics2D.dispose();
                image = resizedImage;
                picture = new Masks(image.getHeight(), image.getWidth());
                for (int row = 0; row < image.getWidth(); row++) {
                    for (int col = 0; col < image.getHeight(); col++) {
                        Picture.pixel[col][row] = image.getRGB(row, col);
                    }
                }

                for (String mask : masks.getItems()) {
                    if (mask.contains("Gauss")) {
                        if (mask.contains("3")) {
                            Picture.radius = 1;
                        }
                        if (mask.contains("5")) {
                            Picture.radius = 2;
                        }
                        if (mask.contains("7")) {
                            Picture.radius = 3;
                        }
                        GaussBlur.blur();
                    }
                    if (mask.contains("Átlag")) {
                        if (mask.contains("1")) {
                            Picture.radius = 1;
                        }
                        if (mask.contains("2")) {
                            Picture.radius = 2;
                        }
                        if (mask.contains("3")) {
                            Picture.radius = 3;
                        }
                        MeanFilter.meanFilter();
                    }
                    if (mask.contains("Unsharp")) {
                        Picture.radius = 1;
                        UnsharpFilter.unsharp();
                    }
                    if (mask.contains("Sobel")) {
                        Picture.radius = 1;
                        SobelOperator.sobelDetector();
                    }
                    if (mask.contains("Frei")) {
                        Picture.radius = 1;
                        FreiChen.freiChenFilter();
                    }
                }
                SwingUtilities.invokeLater(HexFrame::new);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showSaveDialog(MouseEvent mouseEvent) {
        JFileChooser file = new JFileChooser();
        file.setMultiSelectionEnabled(false);
        file.setCurrentDirectory(new File(System.getProperty("user.home")));
        //filtering files
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Images", "jpg", "png");
        file.addChoosableFileFilter(filter);
        int res = file.showSaveDialog(null);

        file.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        file.setFileHidingEnabled(false);
        if (res == JFileChooser.APPROVE_OPTION) {
            File selFile = file.getSelectedFile();
            if (selFile.getAbsolutePath().endsWith(".jpg") || selFile.getAbsolutePath().endsWith(".png")) {
                savePath.setText(selFile.getAbsolutePath());
            } else {
                savePath.setText(selFile.getAbsolutePath() + "Hexagon.jpg");
            }
        }
    }

    public void showOpenDialog(MouseEvent mouseEvent) {
        JFileChooser file = new JFileChooser();
        file.setMultiSelectionEnabled(false);
        file.setCurrentDirectory(new File(System.getProperty("user.home")));
        //filtering files
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Images", "jpg", "png");
        file.addChoosableFileFilter(filter);
        int res = file.showSaveDialog(null);

        file.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        file.setFileHidingEnabled(false);
        if (res == JFileChooser.APPROVE_OPTION) {
            File selFile = file.getSelectedFile();
            if (selFile.getAbsolutePath().endsWith(".jpg") || selFile.getAbsolutePath().endsWith(".png")) {
                path.setText(selFile.getAbsolutePath());
            } else {
                infoBox("Kérem jpg vagy png kiterjesztésű képet adjon meg", "Érvénytelen formátum");
            }
        }

    }
}