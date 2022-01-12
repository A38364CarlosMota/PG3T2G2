package T2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

/**
 * Interface gráfica para visualizar as equipas.
 */
public class TeamsFrame extends JFrame {
    private final JFileChooser fileChooser = new JFileChooser( );

    // Os elementos devem ser iterados pela ordem em que são adicionados
    private HashMap<String, TeamUtils.Team> teams; // todo - Instanciar o map

    private final JTextArea listArea = GuiUtils.newTextAreaWithTitle( "list", 15, 40 );

    public final GuiUtils.Item[] fileMenus = {
            new GuiUtils.Item("load", this::load),
            new GuiUtils.Item("save", this::save),
            new GuiUtils.Item("exit", this::exit)};

    public TeamsFrame(){
        super("Teams");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Container cp = getContentPane();

        // <<Adicionar à TextArea para a listagem, uma barra de scroll>>
        // todo - Adicionar a barra de scrool
        cp.add(listArea, BorderLayout.CENTER);

        // << Adicionar os butões >>
        JPanel buttons = new JPanel();
        ((FlowLayout) buttons.getLayout()).setAlignment(FlowLayout.RIGHT);
        // todo - substituir a adição deste botão pela adição dos três botões
        //        usando o método GuiUtils.create.
        JButton b = new JButton("clear");
        b.addActionListener(this::clear);
        buttons.add(b);
        //<< Adicionar os botões
        cp.add(buttons, BorderLayout.SOUTH);

        //<< Adicionar os menus >>
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(GuiUtils.create(new JMenu( "File"), JMenuItem::new, fileMenus));
        //todo - adicionar os restantes menus usando o método GuiUtils.create
        setJMenuBar( menuBar );
        pack();
    }

    /**
     * Método chamado quando é premido o botão "clear".
     * Limpa a area de texto.
     * @param actionEvent evento do action listener.
     */
    private void clear(ActionEvent actionEvent) {
        listArea.setText("");
    }

    /***************************************************
     *  Métodos associados aos itens do menu "File"
     *
     ***************************************************/
    /**
     * Coloca visivel a janela de dialogo para que seja selecionado
     * o ficheiro. Abre o ficheiro selecionado e escreve no ficheiro
     * o nome de cada equipa seguido da pontuação.
     * */
    private void save(ActionEvent actionEvent) {
        fileChooser.setCurrentDirectory(new File("."));
        if ( JFileChooser.APPROVE_OPTION == fileChooser.showSaveDialog(this) )
            try ( PrintWriter pw = new PrintWriter(fileChooser.getSelectedFile())) {
                //todo - usar o método da alinea 2.ii e 2.iii
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error file: " + e.getMessage());
            }
    }

    /**
     * Coloca visivel a janela de dialogo para que seja selecionado
     * o ficheiro. Abre o ficheiro selecionado e acrescenta os jogos
     * que constam no ficheiro no contentor associativo "teams".
     * @param actionEvent
     */
    private void load(ActionEvent actionEvent) {
        //todo - usar o método da alinea 2.i
    }

    /**
     * Antes de terminar pergunta ao utilizador se quer salvar em
     * ficheiro as equipas. Caso a resposta seja afirmativa evoca
     * o método save.
     * @param actionEvent
     */
    private void exit( ActionEvent actionEvent ) {
        //todo
    }

    /***************************************************
    *  Métodos associados aos itens do menu "Team"
    ***************************************************/

     /**
     * Método chamado quando é premido o item "add game".
     * Coloca visivel uma janela de dialogo para ser inserida a
     * descrição do jogo. Adiciona ao contentor associativo "teams"
     *  o jogo.
     * Lista todos as equipas após a adição.
     * @param actionEvent evento do action listener.
     */
    private void addGame(ActionEvent actionEvent) {
        String gameDescription = JOptionPane.showInputDialog(this, "Game?", "Add game", JOptionPane.QUESTION_MESSAGE);
        if ( gameDescription != null && !gameDescription.isBlank())
            try {
                //todo - usar o método da alinea 2.i
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
    }

    /**
     * Método chamado quando é premido o botão "information" ou o item "team information".
     * Coloca visivel uma janela de dialogo para a inserção do nome da equipa.
     * Mostra na area de texto a informação da equipa: nome, pontuação e número de jogos.
     * @param actionEvent evento do action listener.
     */
    private void teamInformation(ActionEvent actionEvent) {
        //todo
    }

    /***************************************************
     *  Métodos associados aos itens do menu "List"
     *
     ***************************************************/
    /**
     * Método chamado quando é selecionado o item ou o botão "all teams names".
     * Lista os nomes das equipas que constam no contentor associativo "teams".
     * @param actionEvent
     */
    private void listAllTeamsNames(ActionEvent actionEvent) {
        //todo -
    }


    /**
     * Método chamado quando é selecionado o item "information from all teams".
     * Lista a informação de todas as equipas (nome, pontos e jogos).
     * @param actionEvent
     */
    private void listAllTeams(ActionEvent actionEvent) {
        //todo -
    }

    /**
     * Método chamado quando é selecionado o item "teams and points in descending order".
     * Lista as equipas e a respectiva pontuação ordenadas.
     * A lista deve ser ordenada por ordem decrescente de pontos, para o mesmo número de
     * pontos por ordem crescente de jogos, para o esmo número de jogos por ordem
     * lexicografica dos nomes.
     * @param actionEvent
     */
    private void listTeamsAndPoints(ActionEvent actionEvent ) {
        //todo - Usar os métodos da alinea 2.ii e 2.iii
    }

    public static void main(String[] args) {
        new TeamsFrame().setVisible( true );
    }
}
