package com.octest.DAO;
import java.util.List;

import com.octest.beans.*;

public interface UtilisateurDao {
 void ajouter (Utilisateurs utilisateur);
 List<Utilisateurs> lister();
 void suprimer(Utilisateurs user);
}
