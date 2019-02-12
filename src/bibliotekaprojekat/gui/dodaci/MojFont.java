package bibliotekaprojekat.gui.dodaci;

import java.awt.Font;

/**
 * Moji predefinisani fontovi
 */
public class MojFont extends Font {

    public static MojFont fontCambri = new MojFont("Cambria", 1, 14);
    public static MojFont fontManjiCambri = new MojFont("Cambria", 1, 12);
    public static MojFont fontBA = new MojFont("Book Antiqua", ITALIC, 18);

    public MojFont(String name, int style, int size) {
        super(name, style, size);
    }

}
