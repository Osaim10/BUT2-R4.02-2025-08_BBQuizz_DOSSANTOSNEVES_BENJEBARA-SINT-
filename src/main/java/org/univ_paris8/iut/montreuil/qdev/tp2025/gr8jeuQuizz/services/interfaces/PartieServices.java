package org.univ_paris8.iut.montreuil.qdev.tp2025.gr8jeuQuizz.services.interfaces;

import org.univ_paris8.iut.montreuil.qdev.tp2025.gr08.jeuQuizz.entities.dto.QuestionnaireDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr8.jeuQuizz.entities.dto.JoueurDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr8jeuQuizz.utils.exceptions.JoueurInexistantException;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr8jeuQuizz.utils.exceptions.QuestionnaireInexistantException;

public interface PartieServices {

    public boolean determiner_elements_partie(QuestionnaireDTO questionnaire, JoueurDTO joueur) throws JoueurInexistantException, QuestionnaireInexistantException;
}
