package bibliotekaprojekat.gui.dodaci;

import java.awt.Color;
import java.awt.color.ColorSpace;

/**
 * Boje koriscene u programu. Predefinisane kako ne bi morala uvek da trazim
 * koji je RBG za koju boju.
 */
public class Boja extends Color {

    public final static Color roze = new Color(248, 189, 249);
    public final static Color ROZE = roze;

    public final static Color kajsija = new Color(247, 210, 175);
    public final static Color KAJSIJA = kajsija;

    public final static Color plavoljubicasta = new Color(128, 0, 255);
    public final static Color PLAVOLJUBICASTA = plavoljubicasta;

    public final static Color jorgovan = new Color(240, 217, 253);
    public final static Color JORGOVAN = jorgovan;

    public final static Color tamnijorgovan = new Color(216, 158, 250);
    public final static Color TAMNIJORGOVAN = tamnijorgovan;

    public final static Color tamnoljubicasta = new Color(64, 7, 95);
    public final static Color TAMNOLJUBICASTA = tamnoljubicasta;

    public Boja(int r, int g, int b) {
        super(r, g, b);
    }

    public Boja(int r, int g, int b, int a) {
        super(r, g, b, a);
    }

    public Boja(int rgb) {
        super(rgb);
    }

    public Boja(int rgba, boolean hasalpha) {
        super(rgba, hasalpha);
    }

    public Boja(float r, float g, float b) {
        super(r, g, b);
    }

    public Boja(float r, float g, float b, float a) {
        super(r, g, b, a);
    }

    public Boja(ColorSpace cspace, float[] components, float alpha) {
        super(cspace, components, alpha);
    }

}
