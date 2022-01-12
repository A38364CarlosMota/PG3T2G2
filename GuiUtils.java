package T2;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.util.function.Supplier;

public class GuiUtils {

    public static class Item extends Pair<String, ActionListener> {
        public Item(String name, ActionListener action) {
            super(name, action);
        }
    }

    /**
     * Adiciona a um Container os itens descritos no array de itens. Usa um Supplier
     * para obter o componente a adicionar
     * @param container Container
     * @param s fornecedor de um componente que extenda AbstractButton (JButton, JMenuItem, etc.).
     * @param itens array contendo a descrição dos itens (nome e ação a efetuar).
     * @return o contentor
     */
    public static <C extends Container> C create(C container, Supplier<? extends AbstractButton> s, Item... itens ){
        for ( Item item: itens)  {
            AbstractButton ab = s.get();
            ab.setText( item.getFirst() );
            ab.addActionListener( item.getSecond() );
            container.add( ab );
        }
        return container;
    }

    /**
     * Instancia uma caixa de texto com o número de colunas especificado e com
     * uma cercadura do tipo TitleBorder com o titulo especificado
     * @param  title titulo na cercadura
     * @param columns número de colunas.
     * @return a caixa de texto instanciada
     */
    public static JTextField newTextFieldWithTitle(String title, int columns ) {
        JTextField tf = new JTextField( columns );
        tf.setBorder( new TitledBorder( title ) );
        return tf;
    }

    /**
     * Instancia uma areae texto com o número de linhas e colunas
     * especificado e com uma cercadura do tipo TitleBorder com o
     * titulo especificado.
     * @param  title titulo na cercadura
     * @param rows número de linhas.
     * @param columns número de colunas.
     * @return a area de texto instanciada
     */
    public static JTextArea newTextAreaWithTitle(String title, int rows, int columns ) {
        JTextArea tf = new JTextArea( rows, columns );
        tf.setBorder( new TitledBorder( title ) );
        return tf;
    }
}
