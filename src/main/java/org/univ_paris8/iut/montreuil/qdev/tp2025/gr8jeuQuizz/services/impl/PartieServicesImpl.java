package org.univ_paris8.iut.montreuil.qdev.tp2025.gr8jeuQuizz.services.impl;

import org.univ_paris8.iut.montreuil.qdev.tp2025.gr08.jeuQuizz.entities.dto.QuestionnaireDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr08.jeuQuizz.services.interfaces.QuestionnaireServices;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr8.jeuQuizz.entities.dto.JoueurDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr8.jeuQuizz.services.impl.JoueurService;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr8jeuQuizz.services.interfaces.PartieServices;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr8jeuQuizz.utils.exceptions.JoueurInexistantException;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr8jeuQuizz.utils.exceptions.QuestionnaireInexistantException;

import java.util.List;

public class PartieServicesImpl implements PartieServices {

    public boolean determiner_elements_partie(QuestionnaireDTO questionnaire, JoueurDTO joueur) throws JoueurInexistantException, QuestionnaireInexistantException {

        List<JoueurDTO> joueursActuels = JoueurService.getInstance().listerJoueur();

        List<QuestionnaireDTO> questionnairesActuels;
        try {
            questionnairesActuels = QuestionnaireServices.fournirListeQuestionnaire(this.cheminFichierQuestionnaires);
        } catch (QuestInvalideException e) {
            System.err.println("Erreur lors du chargement des questionnaires: " + e.getMessage());
            throw new QuestionnaireInexistantException("Impossible de charger la liste des questionnaires depuis " + e.getMessage(), e);
        }

        boolean joueurTrouve = false;
        if (joueur == null) {
            throw new JoueurInexistantException("Joueur ou pseudo du joueur fourni est null.");
        }

        for (JoueurDTO jExistant : joueursActuels) {
            if (jExistant != null && jExistant.getPseudo() != null && joueur.getPseudo().equals(jExistant.getPseudo())) {
                joueurTrouve = true;
                break;
            }
        }

        if (!joueurTrouve) {
            throw new JoueurInexistantException("Le joueur avec le pseudo '" + joueur.getPseudo() + "' n'existe pas dans la liste actuelle.");
        }

        boolean questionnaireTrouve = false;
        if (questionnaire == null) {
            throw new QuestionnaireInexistantException("Questionnaire ou thème du questionnaire fourni est null.");
        }


        for (QuestionnaireDTO qExistant : questionnairesActuels) {
            if (qExistant != null) {
                questionnaireTrouve = true;
                break;
            }
        }

        if (!questionnaireTrouve) {
            throw new QuestionnaireInexistantException("Le questionnaire avec le thème '" + questionnaire.getTheme() + "' n'existe pas dans la liste actuelle.");
        }

        return true;
    }
}
