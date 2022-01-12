package T1;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Arrays;

public class Window extends JFrame{

  public static final int WIDTH = 400;
  public static final int HEIGTH = 300;
  JTextField dirName = new JTextField("");
  JTextArea centerStudents = new JTextArea();
  JTextField semester = new JTextField(8);
  JTextField studentShip = new JTextField(8);


    public Window(){

        setSize(WIDTH,HEIGTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("StudentsShip");

        Container contPanel = getContentPane(); //É aqui que vamos adicionar todos os paineis

        //Norte
        JPanel north = new JPanel(new BorderLayout());


        dirName.setBorder(new TitledBorder("Dir Name"));
        north.add(dirName, BorderLayout.CENTER);


        semester.setBorder(new TitledBorder("Semestre"));
        north.add(semester, BorderLayout.EAST);

        contPanel.add(north, BorderLayout.NORTH); //adiciona os componentes de norte ao content panel


        //Center

        centerStudents.setBorder(new TitledBorder("Students"));
        contPanel.add(centerStudents, BorderLayout.CENTER);


        //South
        JPanel southPanel = new JPanel();
        FlowLayout fl = (FlowLayout) southPanel.getLayout();
        fl.setAlignment(FlowLayout.RIGHT);

        JPanel southPanel_left = new JPanel();
        southPanel_left.setBorder( new LineBorder(Color.BLUE, 1));
        JLabel labelStudentShip = new JLabel("studentship");

        southPanel_left.add(labelStudentShip, BorderLayout.WEST);
        southPanel_left.add(studentShip, BorderLayout.CENTER);

            //Buttons
        JPanel southPanel_right = new JPanel();

        JButton execute = new JButton("Execute");
        //execute.addActionListener((actionEvent)->centerStudents.append(dirName.getText()+'\n'));
        //southPanel_right.add(execute);
        execute.addActionListener(this::execute);

        JButton clear = new JButton("Clear");
        clear.addActionListener(this::clear);
        //southPanel_right.add(clear);


        southPanel.add(southPanel_left);
        southPanel.add(execute);
        southPanel.add(clear);
       // southPanel.add(southPanel_right);
        contPanel.add(southPanel, BorderLayout.SOUTH);

    }

    public void clear (ActionEvent e){
        dirName.setText("");
        semester.setText("");
        studentShip.setText("");
        centerStudents.setText("");

    }

    public void execute (ActionEvent e){

        try {
            int ks = Integer.parseInt(studentShip.getText());
            int s = Integer.parseInt(semester.getText());

            String dir = dirName.getText();
            Student[] arr = Student.getKGreater(ks, s, dir);
            Arrays.toString(arr);
            int i;
            for(i=0; i< arr.length; i++) {
                centerStudents.append(arr[i]+"\n");

            }
        }catch(Exception ex){

            centerStudents.setText("Invalido: " + ex.getMessage());

        }
    }

    public static void main(String[] args) {

        Window window1 = new Window();
        window1.setVisible(true);

    }

}
