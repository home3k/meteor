/*
 * 1010.am Studio.
 * Copyright (c) 2000-2014 All Rights Reserved.
 */

package am1010.studio.meteor.view;

/**
 * @author home3k (home3k@gmail.com)
 * @version 1.0
 * @desc TODO
 * @date 14-8-25
 */
public enum ShapeType {

    polygon(1), rectangle(2), circle(3);

    private int index;

    private ShapeType(int index) {
        this.index = index;
    }
}
