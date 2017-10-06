/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework.epam.mod2.penwithenums;

/**
 *
 * @author FedulovOV
 */
enum inkColor {
    BLUE, BLACK, RED, GREEN;

    @Override
    public String toString() {
        return "This Pen is " + name();
    }
};
