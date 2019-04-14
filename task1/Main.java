import Card.Debit;
import Card.Paypal;
import Card.Qiwi;
import Product.CPU;
import Product.Laptop;
import Product.Product;
import Product.SSD;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

public class Main extends Application {

    private static ArrayList<User> users = new ArrayList<>();
    private static ArrayList<Product> products = new ArrayList<>();
    private static User loggedInUser;

    static {
        User user = new User("login", "pass");
        users.add(user);

        Laptop laptop1 = new Laptop("Pavilion 17ab21ur", "My laptop", 1100, "Core i7-7700hq", "GTX 1050Ti", 8, 17.3);
        products.add(laptop1);
        Laptop laptop2 = new Laptop("Some another Laptop", "Some anoter Laptop", 0, "No cpu", "GTX 1080Ti", 16, 15.4);
        products.add(laptop2);
        Laptop laptop3 = new Laptop("Yet another Laptop", "Yet anoter Laptop", -500, "Core i9-7980XE", "GTX 1080Ti", 254, 27.5);
        products.add(laptop3);
        Laptop laptop4 = new Laptop("And last one", "Last one", 10, "No CPU", "No GPU", 0, 0);
        products.add(laptop4);
        CPU cpu1 = new CPU("Core i9-7980XE", "Intel® Core™ i9-7980XE Extreme Edition Processor", 2000, "i9-7980XE", "14nm", "18", "2.60 Ghz");
        products.add(cpu1);
    }

    private static void writeUsers(){
        try {
            FileOutputStream fos = new FileOutputStream(".tmp");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(users);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readUsers(){
        try {
            FileInputStream fis = new FileInputStream(".tmp");
            ObjectInputStream ois = new ObjectInputStream(fis);
            users = (ArrayList<User>) ois.readObject();
            ois.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        readUsers();
        loginPage(primaryStage);
        primaryStage.setTitle("");
        primaryStage.setMaximized(true);
        primaryStage.show();
    }

    private void loginPage(Stage primaryStage) {
        int prefWidth = 150;
        TextField loginTF = new TextField();
        loginTF.setMaxWidth(prefWidth);
        PasswordField passTF = new PasswordField();
        passTF.setMaxWidth(prefWidth);

        Text messages = new Text();

        Button loginButton = new Button("Log in");
        loginButton.setOnAction(event -> {
            String login = loginTF.getText();
            String pass = passTF.getText();
            if (isUserExist(login)) {
                User user = getUser(login);
                assert user != null;
                if (user.getPass().equals(pass)) {
                    login(user, primaryStage);
                }
            }
        });

        Button signupButton = new Button("Sign up");
        signupButton.setOnAction(event -> {
            String login = loginTF.getText();
            String pass = passTF.getText();
            if (login.trim().length() > 0 && pass.trim().length() > 0) {
                if (isUserExist(login)) {
                    System.out.println("User is already exist");
                    messages.setFill(Color.RED);
                    messages.setText("User " + login + " is already exist");
                } else {
                    User user = new User(login, pass);
                    users.add(user);
                    writeUsers();
                    login(user, primaryStage);
                }
            } else {
                System.out.println("Login or pass is empty");
                messages.setFill(Color.RED);
                messages.setText("Login or pass is empty");
            }
        });

        HBox loginHBox = new HBox(new Label("Login:         "),loginTF);
        loginHBox.setAlignment(Pos.CENTER);

        HBox passHBox = new HBox(new Label("Password:  "), passTF);
        passHBox.setAlignment(Pos.CENTER);

        HBox logHBox = new HBox(loginButton, signupButton);
        logHBox.setSpacing(20);
        logHBox.setAlignment(Pos.CENTER);

        Button forgotPassButton = new Button("Forgot password?");
        forgotPassButton.setOnAction(event -> {
            String login = loginTF.getText();
            if (login.length() > 0 && isUserExist(login)){
                messages.setFill(Color.GREEN);
                messages.setText("Your pass: " + Objects.requireNonNull(getUser(login)).getPass());
            } else {
                messages.setFill(Color.RED);
                messages.setText("There is no user with that login");
            }
        });

        VBox vBox = new VBox(messages, loginHBox, passHBox, logHBox, forgotPassButton);
        vBox.setSpacing(10);
        vBox.setAlignment(Pos.CENTER);
        Scene scene = new Scene(vBox);
        scene.getStylesheets().add("style.css");
        primaryStage.setScene(scene);
    }

    private void login(User user, Stage primaryStage) {
        loggedInUser = user;
        mainPage(primaryStage);
    }

    private void mainPage(Stage primaryStage) {
        ArrayList<Laptop> laptops = new ArrayList<>();
        ArrayList<CPU> cpus = new ArrayList<>();
        ArrayList<SSD> ssds = new ArrayList<>();
        for (Product prod : products) {
            if (prod.getClass() == Laptop.class) {
                laptops.add((Laptop) prod);
            } else if (prod.getClass() == CPU.class) {
                cpus.add((CPU) prod);
            } else if (prod.getClass() == SSD.class) {
                ssds.add((SSD) prod);
            }
        }
        ImageView basket = new ImageView(new Image("https://www.materialui.co/materialIcons/action/shopping_cart_white_96x96.png"));
        basket.setFitWidth(100);
        basket.setFitHeight(100);
        basket.setOnMouseClicked(event -> basket(primaryStage));

        HBox topHBox = new HBox(basket);
        topHBox.setAlignment(Pos.TOP_RIGHT);
        topHBox.setPadding(new Insets(30));

        double prefWidth = 250;
        double fontSize = 35;

        Button laptopButtons = new Button("Laptop");
        laptopButtons.setPrefWidth(prefWidth);
        laptopButtons.setAlignment(Pos.CENTER);
        laptopButtons.setStyle("-fx-font-size: "+fontSize+"px;");

        Button cpuButtons = new Button("CPU");
        cpuButtons.setPrefWidth(prefWidth);
        cpuButtons.setAlignment(Pos.CENTER);
        cpuButtons.setStyle("-fx-font-size: "+fontSize+"px;");

        Button ssdButtons = new Button("SSD");
        ssdButtons.setPrefWidth(prefWidth);
        ssdButtons.setAlignment(Pos.CENTER);
        ssdButtons.setStyle("-fx-font-size: "+fontSize+"px;");

        VBox listVBox = new VBox(laptopButtons, cpuButtons, ssdButtons);
        listVBox.setSpacing(10);
        listVBox.setPadding(new Insets(20));
        listVBox.setAlignment(Pos.CENTER);


        GridPane gridPane = new GridPane();
        gridPane.setGridLinesVisible(false);

        laptopButtons.setOnAction(event -> {
            gridPane.getChildren().clear();
            gridPane.setHgap(10);
            gridPane.setPadding(new Insets(0,200,0,200));
            gridPane.setVgap(20);
            for (int i = 0; i < laptops.size(); i++) {
                gridPane.add(productCard(laptops.get(i)), i % 3, i / 3);
            }
        });

        cpuButtons.setOnAction(event -> {
            gridPane.getChildren().clear();
            for (int i = 0; i < cpus.size(); i++) {
                gridPane.add(productCard(cpus.get(i)), i % 3, i / 3);
            }
        });

        ssdButtons.setOnAction(event -> {
            gridPane.getChildren().clear();
            for (int i = 0; i < ssds.size(); i++) {
                gridPane.add(productCard(ssds.get(i)), i % 3, i / 3);
            }
        });

        double h = primaryStage.getHeight();
        double w = primaryStage.getWidth();

        HBox centerHBox = new HBox(listVBox, gridPane);
        VBox vBox = new VBox(topHBox, centerHBox);
        vBox.setAlignment(Pos.CENTER);
        Scene scene = new Scene(vBox);
        scene.getStylesheets().add("style.css");
        primaryStage.setScene(scene);
        primaryStage.setWidth(w);
        primaryStage.setHeight(h);
    }

    private void basket(Stage primaryStage) {
        ImageView main = new ImageView(new Image("https://www.materialui.co/materialIcons/hardware/keyboard_arrow_left_white_96x96.png"));
        main.setFitWidth(100);
        main.setFitHeight(100);
        main.setOnMouseClicked(event -> mainPage(primaryStage));

        VBox basketVBox = new VBox();
        basketVBox.setAlignment(Pos.CENTER);

        int sum = 0;
        for (Product prod: Basket.getBasket()){
            Text name = new Text(prod.getName());
            name.setStyle("-fx-font-size: 24; ");
            name.setFill(Color.WHITE);

            Text price = new Text("$" + String.valueOf(prod.getPrice()));
            price.setStyle("-fx-font-size: 24; ");
            price.setFill(Color.WHITE);

            Separator sep = new Separator();
            sep.setMaxWidth(350);

            HBox hBox = new HBox(name, new Label("                   "), price);
            hBox.setPrefWidth(500);
            hBox.setAlignment(Pos.CENTER);
            basketVBox.getChildren().addAll(hBox, sep);
            sum += prod.getPrice();
        }

        Text sumPrice = new Text("$" + String.valueOf(sum));
        sumPrice.setStyle("-fx-font-size: 30; ");
        sumPrice.setFill(Color.WHITE);

        Button buyButton = new Button("Buy");
        buyButton.setOnMouseClicked(event -> {
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);

            Button paypalButton = new Button("Paypal");
            paypalButton.setOnAction(event1 -> {
                paypalPage(primaryStage);
                dialogStage.close();
            });
            Button qiwiButton = new Button("Qiwi");
            qiwiButton.setOnAction(event1 -> {
                qiwiButton(primaryStage);
                dialogStage.close();
            });

            Button debitButton = new Button("Debit Card");
            debitButton.setOnAction(event1 -> {
                debitCardButton(primaryStage);
                dialogStage.close();
            });


            

            HBox hBox = new HBox(paypalButton, qiwiButton, debitButton);
            hBox.setAlignment(Pos.CENTER);
            hBox.setPadding(new Insets(15));
            hBox.setSpacing(10);

            Scene scene = new Scene(hBox);
            scene.getStylesheets().add("style.css");
            dialogStage.setScene(scene);
            dialogStage.show();
        });

        ScrollPane sideBarScroller = new ScrollPane(basketVBox);
        sideBarScroller.setBackground(Background.EMPTY);
        sideBarScroller.setFitToWidth(true);
        sideBarScroller.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        sideBarScroller.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);


        StringBuilder s = new StringBuilder(" ");
        for (int i = 0; i < 100; i++) {
            s.append(" ");
        }

        HBox sceneHBox = new HBox(main, new VBox(sideBarScroller, new HBox(sumPrice, new Label(s.toString()), buyButton)));
        sceneHBox.setPadding(new Insets(30));
        sceneHBox.setAlignment(Pos.TOP_CENTER);

        Scene scene = new Scene(sceneHBox);
        scene.getStylesheets().add("style.css");

        double h = primaryStage.getHeight();
        double w = primaryStage.getWidth();

        primaryStage.setScene(scene);
        primaryStage.setWidth(w);
        primaryStage.setHeight(h);
    }

    private void qiwiButton(Stage primaryStage) {
        Text messages = new Text();

        int prefWidth = 150;
        TextField loginTF = new TextField();
        loginTF.setMaxWidth(prefWidth);
        PasswordField passTF = new PasswordField();
        passTF.setMaxWidth(prefWidth);

        HBox loginHBox = new HBox(new Label("Qiwi Phone Number:         "),loginTF);
        loginHBox.setAlignment(Pos.CENTER);

        HBox passHBox = new HBox(new Label("Enter code from SMS:       "), passTF);
        passHBox.setAlignment(Pos.CENTER);


        Button buyButton = new Button("Buy");
        buyButton.setOnAction(event -> {
            String login = loginTF.getText();
            String pass = passTF.getText();
            Qiwi qiwi = new Qiwi(login, pass);
            if (qiwi.checkCard()){
                Basket.clear();
                messages.setFill(Color.GREEN);
                for (int i = 10; i > 0; i--) {
                    messages.setText("Sucsessfull!" + String.valueOf(i));
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                mainPage(primaryStage);
            } else {
                messages.setFill(Color.RED);
                messages.setText("Incorrect code from SMS!");
            }
        });

        VBox vBox = new VBox(messages, loginHBox, passHBox, buyButton);
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(10);

        Scene scene = new Scene(vBox);
        scene.getStylesheets().add("style.css");

        double h = primaryStage.getHeight();
        double w = primaryStage.getWidth();

        primaryStage.setScene(scene);
        primaryStage.setWidth(w);
        primaryStage.setHeight(h);
    }    
    
    private void debitCardButton(Stage primaryStage) {
        Text messages = new Text();

        int prefWidth = 150;
        
        TextField cardNoTF = new TextField();
        cardNoTF.setMaxWidth(prefWidth);
        HBox cardNoHBox = new HBox(new Label("CardNo:              "),cardNoTF);
        cardNoHBox.setAlignment(Pos.CENTER);

        TextField cvvTF = new TextField();
        cvvTF.setMaxWidth(prefWidth);
        HBox cvvTFHBox = new HBox(new Label("CVV/CVC:            "),cvvTF);
        cvvTFHBox.setAlignment(Pos.CENTER);

        TextField expTF = new TextField();
        expTF.setMaxWidth(prefWidth);
        HBox expTFHBox = new HBox(new Label("Expiration date:    "),expTF);
        expTFHBox.setAlignment(Pos.CENTER);

        

        Button buyButton = new Button("Buy");
        buyButton.setOnAction(event -> {
            String cardNo = cardNoTF.getText();
            String cvv = cvvTF.getText();
            String exp = expTF.getText();
            Debit debit = new Debit(cardNo,cvv, exp);
            if (debit.checkCard()){
                Basket.clear();
                messages.setFill(Color.GREEN);
                messages.setText("Sucsessfull!");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                mainPage(primaryStage);
            } else {
                messages.setFill(Color.RED);
                messages.setText("Something is incorrect!");
            }
        });

        VBox vBox = new VBox(messages, cardNoHBox, cvvTFHBox, expTFHBox, buyButton);
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(10);

        Scene scene = new Scene(vBox);
        scene.getStylesheets().add("style.css");

        double h = primaryStage.getHeight();
        double w = primaryStage.getWidth();

        primaryStage.setScene(scene);
        primaryStage.setWidth(w);
        primaryStage.setHeight(h);
    }

    private void paypalPage(Stage primaryStage) {
        Text messages = new Text();

        int prefWidth = 150;
        TextField loginTF = new TextField();
        loginTF.setMaxWidth(prefWidth);
        PasswordField passTF = new PasswordField();
        passTF.setMaxWidth(prefWidth);

        HBox loginHBox = new HBox(new Label("Paypal ID:         "),loginTF);
        loginHBox.setAlignment(Pos.CENTER);

        HBox passHBox = new HBox(new Label("Password:     "), passTF);
        passHBox.setAlignment(Pos.CENTER);


        Button buyButton = new Button("Buy");
        buyButton.setOnAction(event -> {
            String login = loginTF.getText();
            String pass = passTF.getText();
            Paypal paypal = new Paypal(login, pass);
            if (paypal.checkCard()){
                Basket.clear();
                messages.setFill(Color.GREEN);
                for (int i = 10; i > 0; i--) {
                    messages.setText("Sucsessfull!" + String.valueOf(i));
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                mainPage(primaryStage);
            } else {
                messages.setFill(Color.RED);
                messages.setText("Pair PaypalID/Password is incorrect!");
            }
        });

        VBox vBox = new VBox(messages, loginHBox, passHBox, buyButton);
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(10);

        Scene scene = new Scene(vBox);
        scene.getStylesheets().add("style.css");

        double h = primaryStage.getHeight();
        double w = primaryStage.getWidth();

        primaryStage.setScene(scene);
        primaryStage.setWidth(w);
        primaryStage.setHeight(h);
    }

    private Node productCard(Product product) {
        Text name = new Text(product.getName());
        name.setStyle("-fx-font: 24 arial;");

        Text desc = new Text(product.getDescription());
        Text price = new Text("$" + product.getPrice());
        price.setStyle("-fx-font-weight: bold;");

        TextField countTextField = new TextField();
        countTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                countTextField.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });

        Button addButton = new Button("Add");
        addButton.setOnAction(event -> Basket.addItems(product, Integer.parseInt(countTextField.getText())));
        HBox addHBox = new HBox(countTextField, new Label("   "), addButton);
        VBox vBox = new VBox(name, desc, price, addHBox);
        vBox.setOnMouseClicked(event -> {
            // TODO: 21.09.2018 popup window
        });
        vBox.setStyle("-fx-background-color: #efefef;   -fx-border-radius: 5 5 5 5; -fx-background-radius: 5 5 5 5;");
        vBox.setPadding(new Insets(20));
        return vBox;
    }


    private User getUser(String login) {
        for (User user : users) {
            if (user.getLogin().equals(login)) return user;
        }
        return null;
    }

    private boolean isUserExist(String login) {
        for (User user : users) {
            if (user.getLogin().equals(login)) return true;
        }
        return false;
    }

}
