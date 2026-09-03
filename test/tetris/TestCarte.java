package tetris;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class TestCarte {

    private Carte carte;

    @BeforeEach
    public void setUp() {
        carte = new Carte();
    }

    @Test
    public void testCarteNotNull() {
        assertNotNull(carte);
        assertNotNull(carte.getMap());
    }

    @Test
    public void testCarteDimensions() {
        Case[][] map = carte.getMap();
        assertEquals(24, map.length);
        assertEquals(10, map[0].length);
    }

    @Test
    public void testToutesLesCasesSontLibresAuDepart() {
        Case[][] map = carte.getMap();
        for (int y = 0; y < 24; y++) {
            for (int x = 0; x < 10; x++) {
                assertNotNull(map[y][x]);
                assertFalse(map[y][x].isOccupe());
            }
        }
    }

    @Test
    public void testLesQuatreCoins() {
        Case[][] map = carte.getMap();
        
        assertNotNull(map[0][0]);
        assertFalse(map[0][0].isOccupe());

        assertNotNull(map[0][9]);
        assertFalse(map[0][9].isOccupe());

        assertNotNull(map[23][0]);
        assertFalse(map[23][0].isOccupe());

        assertNotNull(map[23][9]);
        assertFalse(map[23][9].isOccupe());
    }

    @Test
    public void testCasesCentrales() {
        Case[][] map = carte.getMap();
        
        assertNotNull(map[12][4]);
        assertFalse(map[12][4].isOccupe());

        assertNotNull(map[12][5]);
        assertFalse(map[12][5].isOccupe());
    }

    @Test
    public void testSupprimerLigneSpecifique() {
        Case[][] map = carte.getMap();
        int ligneATester = 15;

        for (int x = 0; x < 10; x++) {
            map[ligneATester][x].setOccupe(true);
        }

        for (int x = 0; x < 10; x++) {
            assertTrue(map[ligneATester][x].isOccupe());
        }

        int ligneRetournee = carte.supprimerLigne(ligneATester);

        assertEquals(ligneATester, ligneRetournee);
        for (int x = 0; x < 10; x++) {
            assertFalse(map[ligneATester][x].isOccupe());
        }
    }

    @Test
    public void testSupprimerLigneImpactUniquementLaCible() {
        Carte carte = new Carte();
        Case[][] map = carte.getMap();
        int ligneCible = 10;

        for (int x = 0; x < 10; x++) {
            map[9][x].setOccupe(true);
            map[10][x].setOccupe(true);
            map[11][x].setOccupe(true);
        }

        carte.supprimerLigne(ligneCible);

        for (int x = 0; x < 10; x++) {
            assertFalse(map[10][x].isOccupe());
            assertTrue(map[9][x].isOccupe());
            assertTrue(map[11][x].isOccupe());
        }
    }

    @Test
    public void testSupprimerPremiereEtDerniereLigne() {
        Carte carte = new Carte();
        Case[][] map = carte.getMap();

        for (int x = 0; x < 10; x++) map[0][x].setOccupe(true);
        carte.supprimerLigne(0);
        for (int x = 0; x < 10; x++) assertFalse(map[0][x].isOccupe());

        for (int x = 0; x < 10; x++) map[23][x].setOccupe(true);
        carte.supprimerLigne(23);
        for (int x = 0; x < 10; x++) assertFalse(map[23][x].isOccupe());
    }

    @Test
    public void testLigneASupLigneComplete() {
        Carte carte = new Carte();
        Case[][] map = carte.getMap();

        for (int x = 0; x < 10; x++) {
            map[20][x].setOccupe(true);
        }

        carte.ligneASup();

        for (int x = 0; x < 10; x++) {
            assertFalse(map[20][x].isOccupe());
        }
    }

    @Test
    public void testLigneASupLigneIncomplete() {
        Carte carte = new Carte();
        Case[][] map = carte.getMap();

        for (int x = 0; x < 9; x++) {
            map[20][x].setOccupe(true);
        }
        map[20][9].setOccupe(false);

        carte.ligneASup();

        for (int x = 0; x < 9; x++) {
            assertTrue(map[20][x].isOccupe());
        }
    }

    @Test
    public void testLigneASupUneSeuleCaseOccupee() {
        Carte carte = new Carte();
        Case[][] map = carte.getMap();

        map[10][0].setOccupe(true);

        carte.ligneASup();

        assertTrue(map[10][0].isOccupe());
    }

    @Test
    public void testLigneASupPlusieursLignes() {
        Carte carte = new Carte();
        Case[][] map = carte.getMap();

        for (int x = 0; x < 10; x++) {
            map[5][x].setOccupe(true);
            map[12][x].setOccupe(true);
            map[23][x].setOccupe(true);
        }

        carte.ligneASup();

        for (int x = 0; x < 10; x++) {
            assertFalse(map[5][x].isOccupe());
            assertFalse(map[12][x].isOccupe());
            assertFalse(map[23][x].isOccupe());
        }
    }

    @Test
    public void testLigneASupSurCarteVide() {
        Carte carte = new Carte();
        Case[][] map = carte.getMap();

        carte.ligneASup();

        for (int y = 0; y < 24; y++) {
            for (int x = 0; x < 10; x++) {
                assertFalse(map[y][x].isOccupe());
            }
        }
    }

    @Test
    public void testLigneASupCartePleine() {
        Carte carte = new Carte();
        Case[][] map = carte.getMap();

        for (int y = 0; y < 24; y++) {
            for (int x = 0; x < 10; x++) {
                map[y][x].setOccupe(true);
            }
        }

        carte.ligneASup();

        for (int y = 0; y < 24; y++) {
            for (int x = 0; x < 10; x++) {
                assertFalse(map[y][x].isOccupe());
            }
        }
    }
}