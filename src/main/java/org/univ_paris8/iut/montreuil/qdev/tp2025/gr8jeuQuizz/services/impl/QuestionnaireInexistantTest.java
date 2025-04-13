package org.univ_paris8.iut.montreuil.qdev.tp2025.gr8jeuQuizz.services.impl;

import org.univ_paris8.iut.montreuil.qdev.tp2025.gr08.jeuQuizz.entities.dto.QuestionnaireDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr8.jeuQuizz.entities.dto.JoueurDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr8jeuQuizz.services.interfaces.PartieServices;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr8jeuQuizz.utils.exceptions.QuestionnaireInexistantException;

public class QuestionnaireInexistantTest implements PartieServices {

    @Override
    public boolean determiner_elements_partie(QuestionnaireDTO questionnaire, JoueurDTO joueur) throws QuestionnaireInexistantException {
        throw new QuestionnaireInexistantException("Ce questionnaire n'existe pas dans notre liste");
    }
}
