/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework.epam.mod2.task1penwithenums;

/**
 *
 * @author FedulovOV
 */
enum penTypes {
    GEL, INK, FEATHER;

    @Override
    public String toString() {
        return "pen type is " + name();
    }

};
