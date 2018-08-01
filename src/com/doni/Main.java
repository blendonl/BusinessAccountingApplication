package com.doni;

import com.doni.Databases.Inventory_Database;
import com.doni.Databases.Purchase_Database;
import com.doni.Databases.Purchaser_Database;
import com.doni.Frames.LoginFrame;

public class Main {

    public static void main(String[] args) {

        Inventory_Database ind = new Inventory_Database(100, 100);
        Purchaser_Database pnd = new Purchaser_Database(100);
        Purchase_Database pd = new Purchase_Database(100, ind);

        LoginFrame lf = new LoginFrame(pnd, ind, pd);
        lf.setVisible(true);

    }
}
