package com.revature.TourDeFranceShop;

import com.revature.TourDeFranceShop.menus.IMenu;
import com.revature.TourDeFranceShop.menus.MenuFactory;


public class App{
    public static void main(String[] args){
    	MenuFactory menuFactory = new MenuFactory();
    	IMenu menu = menuFactory.getMenu();
    	menu.mainMenu();
    }
}
