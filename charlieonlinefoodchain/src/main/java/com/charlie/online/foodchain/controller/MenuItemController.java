package com.charlie.online.foodchain.controller;

import com.charlie.online.foodchain.entities.MenuItem;
import com.charlie.online.foodchain.services.MenuItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("menu")
public class MenuItemController {

    public static final Logger logger = LoggerFactory.getLogger(MenuItemController.class);

    @Autowired
    private MenuItemService menuItemService;

    @CrossOrigin
    @RequestMapping(value = "/items", method = RequestMethod.GET)
    public List<MenuItem> getMenuItems() {
        return menuItemService.getMenuItems();
    }

    @CrossOrigin
    @RequestMapping(value = "/items-add", method = RequestMethod.POST)
    public MenuItem addMenuItem(@RequestBody MenuItem menuItem) {
        return menuItemService.addMenuItem(menuItem);
    }

    @CrossOrigin
    @RequestMapping(value = "/item-update", method = RequestMethod.POST)
    public MenuItem updateMenuItem(@RequestBody MenuItem menuItem) {
        return menuItemService.updateMenuItem(menuItem);
    }

}
