package Frontend;
import Backend.*;
import Frontend.Objects.*;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Orientation;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Panel extends Application {

    private BorderPane root = new BorderPane();
    private Pane testPlace = new Pane();
    private Dummy2D dummy2D = new Dummy2D(30, 40, Color.RED);
    private Client client = new Client(dummy2D.getDummy());
    private Client2D client2D = new Client2D(100, 300, 40, 40, Color.BLUE, client);
    private List<Weapon> weapons = new ArrayList<>();
    private List<Weapon2D> weapons2D = new ArrayList<>();
    private ListView<String> listView = new ListView<>();
    private Button addDummy = new Button("Add\nDummy");
    private Button reload = new Button("Reload");;


    private void makeLists() {
        weapons2D.add(new Handgun2D(new Handgun(20, 400, 20, 8)));
        weapons2D.add(new Shotgun2D(new Shotgun(7, 300, 7, 20, 1)));
        weapons2D.add(new Rifle2D(new Rifle(10, 400 , 10, 12, 3)));
        weapons2D.add(new Explosive2D(new Explosive(20, 200, 80)));
        weapons2D.add(new Incendiary2D(new Incendiary(100, 200, 5, 15)));
        weapons2D.add(new Poison2D(new Poison(100, 400, 5, 10)));
        weapons2D.add(new Blade2D(new Blade(50, 50, 50)));
        weapons2D.add(new Blunt2D(new Blunt(60)));
        weapons2D.add(new Neurobalistic2D(new Neurobalistic(70, 600)));
        weapons2D.add(new Pole2D(new Pole(80, 200, 60)));
        for (Weapon2D weapon2D : weapons2D) {
            weapons.add(weapon2D.getWeapon());
            client.addWeapon(weapon2D.getWeapon());
        }
    }

    private Parent createContent() {

        makeLists();
        ObservableList<String> items = FXCollections.observableArrayList();
        weapons2D.forEach(w -> items.add(w.getWeapon().getClass().getSimpleName()));
        listView.setItems(items);
        listView.setPrefWidth(400);
        listView.setPrefHeight(50);
        listView.setOrientation(Orientation.HORIZONTAL);

        listView.setOnMouseClicked(click -> {
            String currentItemSelected = listView.getSelectionModel().getSelectedItem();
            if (currentItemSelected != null && click.getClickCount() == 2) {
                weapons2D.forEach(weapon2D -> {
                    testPlace.getChildren().removeIf(oldWeapon -> oldWeapon.equals(weapon2D));
                    testPlace.getChildren().removeIf(oldWeapon -> oldWeapon.equals(weapon2D.updateStats));
                    if (weapon2D.getWeapon().getClass().getSimpleName().equals(currentItemSelected)) {
                        client2D.setWeapon(weapon2D);
                        testPlace.getChildren().add(client2D.getWeapon2D());
                        testPlace.getChildren().add(client2D.getWeapon2D().updateStats);
                    }
                });
            }
        });

        testPlace.getChildren().add(client2D);
        testPlace.getChildren().add(client2D.getClientStats());
        testPlace.getChildren().add(dummy2D);
        testPlace.getChildren().add(dummy2D.getDummyStats());
        root.setPrefSize(1200, 600);
        root.setCenter(testPlace);
        root.setBottom(listView);

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                update();
            }
        };
        timer.start();
        return root;
    }

    private void shoot(Client2D client2D) {
        List<Weapon> weapons = client2D.getClient().getWeapons();
        if (weapons != null && client2D.getWeapon2D() != null) {
            firearms(client2D.getClient()).forEach(f -> {
                if (f == client2D.getWeapon2D().getWeapon()) {
                    if (f.getAmmo() > 0) {
                        Bullet2D b = new Bullet2D((int) client2D.getTranslateX() + 20, (int) client2D.getTranslateY(),
                                5, 20, Color.BLACK, f.dealDamage(dummy2D.getDummy()),
                                f instanceof Rifle ? f.getRange() * ((Rifle) f).getScope() : f.getRange());
                        testPlace.getChildren().add(b);
                        if (f.getAmmo() <= 0) {
                            reload.setTranslateX(400);
                            reload.setTranslateY(60);
                            reload.setOnAction(event -> {
                                f.addAmmo(10);
                                testPlace.getChildren().remove(reload);
                            });
                            if (testPlace.getChildren().stream().noneMatch(n -> n.equals(reload))) {
                                testPlace.getChildren().add(reload);
                            }
                        }
                    }
                }
            });
            chemicals(client2D.getClient()).forEach(f -> {
                if (f == client2D.getWeapon2D().getWeapon()) {
                    ThrowBall2D b = new ThrowBall2D((int) client2D.getTranslateX() + 35, (int) client2D.getTranslateY() + 35,
                            5, Color.BLACK, f.dealDamage(dummy2D.getDummy()), f.getApplyRange());
                    testPlace.getChildren().add(b);
                }
            });
            coldWeapons(client2D.getClient()).forEach(f -> {
                if (f == client2D.getWeapon2D().getWeapon()) {
                    if (f instanceof Neurobalistic) {
                        Bullet2D b = new Bullet2D((int) client2D.getTranslateX() + 20, (int) client2D.getTranslateY(),
                                5, 20, Color.BLACK, f.dealDamage(dummy2D.getDummy()), ((Neurobalistic) f).getRange());
                        testPlace.getChildren().add(b);
                    } else if (f instanceof Pole) {
                        Bullet2D b = new Bullet2D((int) client2D.getTranslateX() + 20, (int) client2D.getTranslateY(),
                                5, 20, Color.BLACK, f.dealDamage(dummy2D.getDummy()), ((Pole) f).getRange());
                        testPlace.getChildren().add(b);
                    } else {
                        dummies2D().forEach(d -> {
                            if (client2D.getBoundsInParent().intersects(d.getBoundsInParent())) {
                                System.out.println(client2D.getBoundsInParent().getMaxX());
                                System.out.println(d.getBoundsInParent().getMinX());
                                d.getDummy().setHp(d.getDummy().getHp() - f.dealDamage(d.getDummy()));
                                dummyProcedure(d);
                            }
                        });
                    }
                }
            });
        }
    }

    private void dummyProcedure(Dummy2D d) {
        if (d.getDummy().getHp() <= 0) {
            testPlace.getChildren().removeIf(n -> n.equals(d));
            testPlace.getChildren().removeIf(n -> n.equals(d.getDummyStats()));
            addDummy.setTranslateX(1000);
            addDummy.setTranslateY(200);
            addDummy.setOnAction(event -> {
                dummy2D = new Dummy2D(30, 40, Color.RED);
                testPlace.getChildren().add(dummy2D);
                testPlace.getChildren().add(dummy2D.getDummyStats());
                testPlace.getChildren().remove(addDummy);
            });
            testPlace.getChildren().add(addDummy);
        }
    }

    private void update() {
        bullets2D().forEach(b -> {
            if (b.getRange() > 0) {
                b.moveRight();
                dummies2D().forEach(d -> {
                    if (b.getBoundsInParent().intersects(d.getBoundsInParent())) {
                        d.getDummy().setHp(d.getDummy().getHp() - b.getDealDamage());
                        testPlace.getChildren().removeIf(b::equals);
                        dummyProcedure(d);
                    }
                });
                if (b.getRange() <= 0) {
                    testPlace.getChildren().removeIf(n -> n.equals(b));
                }
            }
        });
        throwBall2D().forEach(b -> {
            if (b.getRange() > 0) {
                b.moveRight();
                dummies2D().forEach(d -> {
                    if (b.getRange() <= 0) {
                        d.getDummy().setHp(d.getDummy().getHp() - b.getDealDamage());
                        testPlace.getChildren().removeIf(b::equals);
                        dummyProcedure(d);
                    }
                });
                if (b.getRange() <= 0) {
                    testPlace.getChildren().removeIf(n -> n.equals(b));
                }
            }
        });
        if (!dummies2D().isEmpty()) {
            dummy2D.updateStats();
        }
        if (client2D != null) {
            client2D.updateStats();
            if (client2D.getWeapon2D() != null) {
                client2D.getWeapon2D().updateStats();
            }
        }
    }

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(createContent());
        scene.setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case A -> dummy2D.moveLeft();
                case D -> dummy2D.moveRight();
                case X -> shoot(client2D);
            }
        });
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private List<Bullet2D> bullets2D() {
        return testPlace.getChildren().stream().filter(sc -> sc instanceof Bullet2D)
                .map(n -> (Bullet2D) n).collect(Collectors.toList());
    }

    private List<ThrowBall2D> throwBall2D() {
        return testPlace.getChildren().stream().filter(sc -> sc instanceof ThrowBall2D)
                .map(n -> (ThrowBall2D) n).collect(Collectors.toList());
    }

    private List<Dummy2D> dummies2D() {
        return testPlace.getChildren().stream().filter(sc -> sc instanceof Dummy2D)
                .map(n -> (Dummy2D) n).collect(Collectors.toList());
    }

    private List<Firearm> firearms(Client client) {
        return client.getWeapons().stream().filter(sc -> sc instanceof Firearm)
                .map(n -> (Firearm) n).collect(Collectors.toList());
    }

    private List<Chemical> chemicals(Client client) {
        return client.getWeapons().stream().filter(sc -> sc instanceof Chemical)
                .map(n -> (Chemical) n).collect(Collectors.toList());
    }

    private List<ColdWeapon> coldWeapons(Client client) {
        return client.getWeapons().stream().filter(sc -> sc instanceof ColdWeapon)
                .map(n -> (ColdWeapon) n).collect(Collectors.toList());
    }
}