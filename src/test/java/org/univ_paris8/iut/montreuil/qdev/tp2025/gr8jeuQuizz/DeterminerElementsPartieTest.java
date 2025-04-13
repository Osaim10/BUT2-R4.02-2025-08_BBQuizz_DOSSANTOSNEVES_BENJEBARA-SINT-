package org.univ_paris8.iut.montreuil.qdev.tp2025.gr8jeuQuizz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr08.jeuQuizz.entities.dto.QuestionnaireDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr8.jeuQuizz.entities.dto.JoueurDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr8.jeuQuizz.utils.enums.Langue;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr8jeuQuizz.services.impl.JoueurInexistantTest;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr8jeuQuizz.services.impl.PartieValideTest;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr8jeuQuizz.services.impl.QuestionnaireInexistantTest;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr8jeuQuizz.utils.exceptions.JoueurInexistantException;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr8jeuQuizz.utils.exceptions.QuestionnaireInexistantException;

import java.util.ArrayList;
import java.util.Arrays;

public class DeterminerElementsPartieTest {

    private QuestionnaireDTO questionnaire;
    private JoueurDTO joueur;
    private ArrayList<JoueurDTO> joueurs;
    private ArrayList<QuestionnaireDTO> questionnaires;

    @BeforeEach
    public void setUp() {
        questionnaire = new QuestionnaireDTO("horreur");
        joueur = new JoueurDTO("Bibi", "B1B1", 2009, Arrays.asList("horreur", "gaming", "litterature"), Langue.FRANCAIS);

        joueurs = new ArrayList<>();
        joueurs.add(joueur);

        questionnaires.add(questionnaire);
        questionnaires = new ArrayList<>();
    }

    @Test
    public void joueurInexistantExceptionTest() {
        JoueurInexistantTest joueurInexistantTest = new JoueurInexistantTest();
        Assertions.assertThrows(JoueurInexistantException.class, () -> joueurInexistantTest.determiner_elements_partie(questionnaires.get(0), joueurs.get(1)));
    }

    @Test
    public void questionnaireInexistantExceptionTest() {
        QuestionnaireInexistantTest questionnaireInexistantTest = new QuestionnaireInexistantTest();
        Assertions.assertThrows(QuestionnaireInexistantException.class, () -> questionnaireInexistantTest.determiner_elements_partie(questionnaires.get(1), joueurs.get(0)));
    }

    @Test
    public void partieValideTest() {
        PartieValideTest partieValideTest = new PartieValideTest();
        Assertions.assertTrue(partieValideTest.determiner_elements_partie(questionnaires.get(0), joueurs.get(0)));
    }
}
