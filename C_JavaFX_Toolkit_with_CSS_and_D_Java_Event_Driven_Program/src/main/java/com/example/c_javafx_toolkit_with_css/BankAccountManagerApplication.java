// Members:
// Dimaandal, Glenn Roy
// Laylo, John Vincent
// Perce, John Adrian

package com.example.c_javafx_toolkit_with_css;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.text.TextAlignment;

public class BankAccountManagerApplication extends Application {
    private double xOffset, yOffset;
    private BankAccount account = new BankAccount("123456789", "Mark Bunyi", 1500.0);

    @Override
    public void start(Stage primaryStage) {
        System.setProperty("prism.order", "sw"); // Use software rendering

        // Main container
        VBox mainContainer = new VBox(20);
        mainContainer.setStyle("-fx-background-color: #35374B;");

        // Top bar with close button
        HBox topBar = new HBox();
        topBar.setAlignment(Pos.CENTER_RIGHT);
        topBar.setPadding(new Insets(10, 10, 0, 10));
        topBar.setStyle("-fx-background-color: #35374B;");

        Button closeButton = new Button("×");
        closeButton.setStyle("-fx-background-color: transparent; -fx-text-fill: #78A083; " +
                "-fx-font-size: 20px; -fx-font-weight: bold; -fx-cursor: hand;");
        closeButton.setOnAction(e -> Platform.exit());
        topBar.getChildren().add(closeButton);

        // Content container 
        VBox contentContainer = new VBox(15);
        contentContainer.setStyle("-fx-padding: 20px;");
        contentContainer.setAlignment(Pos.TOP_CENTER);

        // Header section
        Label titleLabel = new Label("Bank Account Manager");
        titleLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: #78A083;" +
                "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.3), 10, 0.5, 0.0, 0.0);");

        // Account info card
        VBox accountCard = createCard();
        Label balanceLabel = new Label("Current Balance");
        balanceLabel.setStyle("-fx-font-size: 14px; -fx-text-fill: #50727B;");

        Label amountLabel = new Label("$" + String.format("%.2f", 1500.0));
        amountLabel.setStyle("-fx-font-size: 32px; -fx-font-weight: bold; -fx-text-fill: #78A083;");

        Label accountInfoLabel = new Label(account.displayAccountInfo());
        accountInfoLabel.setStyle("-fx-font-size: 14px; -fx-text-fill: #50727B; -fx-wrap-text: true;");
        accountInfoLabel.setTextAlignment(TextAlignment.CENTER);
        accountInfoLabel.setMaxWidth(350);

        accountCard.getChildren().addAll(balanceLabel, amountLabel, createStyledSeparator(), accountInfoLabel);

        // Transaction section
        VBox transactionCard = createCard();
        transactionCard.setSpacing(15);

        // Deposit section
        Label depositLabel = new Label("Make a Deposit");
        depositLabel.setStyle("-fx-font-size: 14px; -fx-font-weight: bold; -fx-text-fill: #50727B;");
        TextField depositField = createStyledTextField("Enter amount to deposit");
        Button depositButton = createStyledButton("Deposit", "#78A083");

        // Withdraw section
        Label withdrawLabel = new Label("Make a Withdrawal");
        withdrawLabel.setStyle("-fx-font-size: 14px; -fx-font-weight: bold; -fx-text-fill: #50727B;");
        TextField withdrawField = createStyledTextField("Enter amount to withdraw");
        Button withdrawButton = createStyledButton("Withdraw", "#344955");

        transactionCard.getChildren().addAll(
                depositLabel, depositField, depositButton,
                createStyledSeparator(),
                withdrawLabel, withdrawField, withdrawButton
        );

        // Add action handlers
        depositButton.setOnAction(e -> handleTransaction(depositField, accountInfoLabel, amountLabel, true));
        withdrawButton.setOnAction(e -> handleTransaction(withdrawField, accountInfoLabel, amountLabel, false));

        // Add all components to containers
        contentContainer.getChildren().addAll(titleLabel, accountCard, transactionCard);
        mainContainer.getChildren().addAll(topBar, contentContainer);

        // Create scene 
        Scene scene = new Scene(mainContainer, 400, 750);

        // Make window draggable
        mainContainer.setOnMousePressed(event -> {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        });
        mainContainer.setOnMouseDragged(event -> {
            primaryStage.setX(event.getScreenX() - xOffset);
            primaryStage.setY(event.getScreenY() - yOffset);
        });

        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private VBox createCard() {
        VBox card = new VBox(15);
        card.setStyle("-fx-background-color: #344955; " +
                "-fx-background-radius: 15px; " +
                "-fx-padding: 20px;");
        card.setEffect(new DropShadow(20, Color.rgb(0, 0, 0, 0.3)));
        card.setMaxWidth(350);
        card.setAlignment(Pos.CENTER);
        return card;
    }

    private Separator createStyledSeparator() {
        Separator separator = new Separator();
        separator.setStyle("-fx-background-color: #50727B;");
        return separator;
    }

    private TextField createStyledTextField(String prompt) {
        TextField field = new TextField();
        field.setPromptText(prompt);
        field.setStyle("-fx-background-color: #35374B; " +
                "-fx-text-fill: #78A083; " +
                "-fx-prompt-text-fill: #50727B; " +
                "-fx-border-color: #50727B; " +
                "-fx-border-radius: 8px; " +
                "-fx-background-radius: 8px; " +
                "-fx-padding: 10px; " +
                "-fx-font-size: 14px;");
        field.setPrefWidth(250);

        field.focusedProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal) {
                field.setStyle(field.getStyle() + "-fx-border-color: #78A083;");
            } else {
                field.setStyle(field.getStyle() + "-fx-border-color: #50727B;");
            }
        });

        return field;
    }

    private Button createStyledButton(String text, String color) {
        Button button = new Button(text);
        button.setStyle("-fx-background-color: " + color + "; " +
                "-fx-text-fill: white; " +
                "-fx-font-size: 14px; " +
                "-fx-padding: 10px; " +
                "-fx-background-radius: 8px; " +
                "-fx-font-weight: bold; " +
                "-fx-cursor: hand;");
        button.setPrefWidth(250);

        button.setOnMouseEntered(e -> {
            String darkerColor = color.equals("#78A083") ? "#6A8F75" : "#2D3E48";
            button.setStyle(button.getStyle().replace(color, darkerColor));
        });
        button.setOnMouseExited(e -> {
            button.setStyle(button.getStyle().replace(color.equals("#78A083") ? "#6A8F75" : "#2D3E48", color));
        });
        button.setOnMousePressed(e -> button.setOpacity(0.8));
        button.setOnMouseReleased(e -> button.setOpacity(1.0));

        return button;
    }

    private void handleTransaction(TextField field, Label infoLabel, Label amountLabel, boolean isDeposit) {
        try {
            double amount = Double.parseDouble(field.getText());
            if (isDeposit) {
                account.deposit(amount);
            } else {
                account.withdraw(amount);
            }
            infoLabel.setText(account.displayAccountInfo());
            amountLabel.setText("$" + String.format("%.2f", Double.parseDouble(account.displayAccountInfo()
                    .split("Balance: ")[1])));
            field.clear();
        } catch (NumberFormatException ex) {
            showError("Please enter a valid amount");
        }
    }

    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.setStyle("-fx-background-color: #344955; -fx-text-fill: white;");
        dialogPane.getStyleClass().add("custom-alert");
        alert.showAndWait();
    }

    public static void main(String[] args) {
        System.setProperty("javafx.platform", "pc");
        launch(args);
    }
}