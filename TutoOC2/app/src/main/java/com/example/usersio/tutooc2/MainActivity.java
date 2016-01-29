package com.example.usersio.tutooc2;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import android.app.Dialog;
import android.app.AlertDialog;

public class MainActivity extends Activity {
    /*
    *MENU
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        //R.menu.menu est l'id de notre menu
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    /*
    *FORMULAIRE
     */

    /** Affichage de la liste des sexes **/
    private ListView mListSexe = null;
    /** Affichage de la liste des langages connus **/
    private ListView mListProg = null;
    /** Bouton pour envoyer le sondage **/
    private Button mSend = null;

    /** Contient les deux sexes **/
    private String[] mSexes = {"Masculin", "Feminin"};
    /** Contient différents langages de programmation **/
    private String[] mLangages = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);

        //On récupère les trois vues définies dans notre layout
        mListSexe = (ListView) findViewById(R.id.listSexe);
        mListProg = (ListView) findViewById(R.id.listProg);
        mSend = (Button) findViewById(R.id.send);

        //Une autre manière de créer un tableau de chaînes de caractères
        mLangages = new String[]{"C", "Java", "COBOL", "Perl"};

        //On ajoute un adaptateur qui affiche des boutons radio (c'est l'affichage à considérer quand on ne peut
        //sélectionner qu'un élément d'une liste)
        mListSexe.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, mSexes));
        //On déclare qu'on sélectionne de base le premier élément (Masculin)
        mListSexe.setItemChecked(0, true);

        //On ajoute un adaptateur qui affiche des cases à cocher (c'est l'affichage à considérer quand on peut sélectionner
        //autant d'éléments qu'on veut dans une liste)
        mListProg.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, mLangages));
        //On déclare qu'on sélectionne de base le second élément (Féminin)
        mListProg.setItemChecked(1, true);

        //Que se passe-t-il dès qu'on clique sur le bouton ?
        mSend.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //Toast.makeText(MainActivity.this, "Merci ! Les données ont été envoyées !", Toast.LENGTH_LONG).show();
                showDialog(IDENTIFIANT_BOITE_UN);
                //On déclare qu'on ne peut plus sélectionner d'élément
                //mListSexe.setChoiceMode(ListView.CHOICE_MODE_NONE);
                //On affiche un layout qui ne permet pas de sélection
                //mListSexe.setAdapter(new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1,
                //        mSexes));

                //On déclare qu'on ne peut plus sélectionner d'élément
               // mListProg.setChoiceMode(ListView.CHOICE_MODE_NONE);
                //On affiche un layout qui ne permet pas de sélection
               // mListProg.setAdapter(new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, mLangages));

                //On désactive le bouton
                //mSend.setEnabled(false);
            }
        });
    }
    /*
    *DIALOG
     */
    private final static int IDENTIFIANT_BOITE_UN  = 0;
    private final static int IDENTIFIANT_BOITE_DEUX  = 1;

    @Override
    public Dialog onCreateDialog(int identifiant) {
        Dialog box = null;
        //En fonction de l'identifiant de la boîte qu'on veut créer
        switch(identifiant) {
            case IDENTIFIANT_BOITE_UN :
                // On construit la première boîte de dialogue, que l'on insère dans « box »
                box= new Dialog(this);
                box.setContentView(R.layout.dialog);
                box.setTitle("DIALOGGGGGG");
                break;

            case IDENTIFIANT_BOITE_DEUX :
                // On construit la seconde boîte de dialogue, que l'on insère dans « box »
                break;
        }
        return box;
    }

}
