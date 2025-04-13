package org.univ_paris8.iut.montreuil.qdev.tp2025.gr8jeuQuizz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr08.jeuQuizz.entities.dto.QuestionnaireDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr8.jeuQuizz.entities.dto.JoueurDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr8.jeuQuizz.services.impl.JoueurService;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr8.jeuQuizz.utils.exceptions.*;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr8jeuQuizz.services.impl.PartieServicesImpl;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr8jeuQuizz.utils.exceptions.JoueurInexistantException;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr8jeuQuizz.utils.exceptions.QuestionnaireInexistantException;

import java.util.ArrayList;
import java.util.Arrays;

public class DeterminerElementsPartieTest {

    private QuestionnaireDTO questionnaire;
    private ArrayList<QuestionnaireDTO> questionnaires;
    private JoueurDTO joueur;

    @BeforeEach
    public void setUp() throws InteretInvalideException, PseudoInvalideException, PseudoDejaPresentException, LangueInvalideException, PrenomInvalideException, AnneeInvalideException {
        questionnaire = new QuestionnaireDTO("horreur");
        joueur = JoueurService.getInstance().ajouterJoueur("Bibi", "B1B1", 2009, Arrays.asList("horreur", "gaming", "litterature"), 1);

        questionnaires = new ArrayList<>();
        questionnaires.add(questionnaire);

    }

    @Test
    public void joueurInexistantExceptionTest() {
        PartieServicesImpl partieServices = new PartieServicesImpl();
        Assertions.assertThrows(JoueurInexistantException.class, () -> partieServices.determiner_elements_partie(questionnaires.get(0), joueur));
    }

    @Test
    public void questionnaireInexistantExceptionTest() {
        PartieServicesImpl partieServices = new PartieServicesImpl();
        Assertions.assertThrows(QuestionnaireInexistantException.class, () -> partieServices.determiner_elements_partie(questionnaires.get(1), joueur));
    }

    @Test
    public void partieValideTest() throws JoueurInexistantException, QuestionnaireInexistantException {
        PartieServicesImpl partieServices = new PartieServicesImpl();
        Assertions.assertTrue(partieServices.determiner_elements_partie(questionnaires.get(0), joueur));
    }
}
