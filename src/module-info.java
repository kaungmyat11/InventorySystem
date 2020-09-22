module InventoryDemo {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.base;
    requires java.sql;

    opens inventorySystem;
    opens inventorySystem.view;
    opens inventorySystem.controller;
    opens inventorySystem.model;
}