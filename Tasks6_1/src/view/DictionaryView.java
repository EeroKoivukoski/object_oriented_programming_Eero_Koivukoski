package view;

import controller.DictionaryController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

public class DictionaryView extends Application {
    private DictionaryController controller;

    @Override
    public void init() {
        controller = new DictionaryController();
    }

    @Override
    public void start(Stage stage) {
        // Components
        TextField wordInput = new TextField();
        wordInput.setPromptText("Enter a word");
        Button searchButton = new Button("Search");
        TextArea resultArea = new TextArea();
        resultArea.setEditable(false);
        resultArea.setWrapText(true);

        // Layout
        FlowPane pane = new FlowPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(15));
        pane.setHgap(10);
        pane.setVgap(10);

        pane.getChildren().addAll(new Label("Word:"), wordInput, searchButton, resultArea);

        // Button Action
        searchButton.setOnAction(e -> {
            String word = wordInput.getText();
            String meaning = controller.search(word);
            resultArea.setText(meaning);
        });

        // Stage
        Scene scene = new Scene(pane, 400, 250);
        stage.setTitle("Virtual Dictionary");
        stage.setScene(scene);
        stage.show();
    }
}
