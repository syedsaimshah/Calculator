
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


interface Storable {

    void add(Operation operation);
    Operation get(int index);
    void clear();
}
class Operation extends MyCalculator {

    void print(){
        
    }
}

class HistoryManager implements Storable {
    @Override
public void add(Operation operation) {

}
@Override
public Operation get(int index) {
    return null;
}

@Override
public void clear() {

}
}

public class MyCalculator  {

    private float num;
    private float result;
    private String lastCommand, command;
    private boolean start;
    private JFrame frame;
    private JTextField text;

    public void run() {
        start = true;
        lastCommand = "=";
        frame = new JFrame("MyCalculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JPanel panelText = new JPanel();
        JPanel panelClear = new JPanel();
        JPanel panelButton = new JPanel();
        panelText.setLayout(new GridLayout(1, 1));
        panelClear.setLayout(new GridLayout(1, 1));
        panelButton.setLayout(new GridLayout(4, 4));

        text = new JTextField( "0", 3 );
        text.setFont(new Font("Serif", Font.BOLD, 48));
        text.setHorizontalAlignment(SwingConstants.RIGHT);
        text.setEditable(false);

        JButton clear = new JButton("C");

        JButton num0 = new JButton("0");
        JButton num1 = new JButton("1");
        JButton num2 = new JButton("2");
        JButton num3 = new JButton("3");
        JButton num4 = new JButton("4");
        JButton num5 = new JButton("5");
        JButton num6 = new JButton("6");
        JButton num7 = new JButton("7");
        JButton num8 = new JButton("8");
        JButton num9 = new JButton("9");
        JButton sum = new JButton("+");
        JButton sub = new JButton("-");
        JButton mult = new JButton("*");
        JButton share = new JButton("/");
        JButton point = new JButton(".");
        JButton result = new JButton("=");

        clear.addActionListener(new InsertClearListener());

        num0.addActionListener(new InsertValueListener());
        num1.addActionListener(new InsertValueListener());
        num2.addActionListener(new InsertValueListener());
        num3.addActionListener(new InsertValueListener());
        num4.addActionListener(new InsertValueListener());
        num5.addActionListener(new InsertValueListener());
        num6.addActionListener(new InsertValueListener());
        num7.addActionListener(new InsertValueListener());
        num8.addActionListener(new InsertValueListener());
        num9.addActionListener(new InsertValueListener());
        point.addActionListener(new InsertPointListener());

        sum.addActionListener(new InsertCommandListener());
        sub.addActionListener(new InsertCommandListener());
        mult.addActionListener(new InsertCommandListener());
        share.addActionListener(new InsertCommandListener());
        result.addActionListener(new InsertCommandListener());



        panelText.add(text);

        panelClear.add(clear);

        panelButton.add(num7);
        panelButton.add(num8);
        panelButton.add(num9);
        panelButton.add(share);

        panelButton.add(num4);
        panelButton.add(num5);
        panelButton.add(num6);
        panelButton.add(mult);

        panelButton.add(num1);
        panelButton.add(num2);
        panelButton.add(num3);
        panelButton.add(sub);

        panelButton.add(num0);
        panelButton.add(point);
        panelButton.add(result);
        panelButton.add(sum);

        frame.add(panelText, BorderLayout.NORTH);
        frame.add(panelClear, BorderLayout.CENTER);
        frame.add(panelButton,BorderLayout.SOUTH);
        frame.setSize(250,250);
        frame.setVisible(true);
    }

    private class InsertClearListener implements ActionListener {
        public void actionPerformed(ActionEvent a) {
            start = true;
            text.setText("0");
            num = 0;
            result = 0;
        }
    }

    public class InsertPointListener implements ActionListener {
        public void actionPerformed(ActionEvent a) {
            if(text.getText().indexOf(".") != -1) {

            }else {
                text.setText(text.getText() + ".");
                start = false;
            }
        }
    }


    private class InsertValueListener implements ActionListener {
        public void actionPerformed(ActionEvent a) {
            String input = a.getActionCommand();
            if (start) {
                text.setText("");
                start = false;
            }
            text.setText(text.getText() + input);
        }
    }

    private class InsertCommandListener implements ActionListener {
        public void actionPerformed(ActionEvent a) {
            String command = a.getActionCommand();
            num = Float.parseFloat(text.getText());
            System.out.println(lastCommand);
            calculate(num);
            lastCommand = command;
            start = true;
            }
        }
    
    public void calculate(float num) {
        switch(lastCommand) {
            case "+": result += num;
                break;
            case "-": result -= num;
                break;
            case "*": result *= num;
                break;
            case "/": result /= num;
                break;
            case "=": result = num;
                break;
        }
        text.setText("" + result);
    }

    public static void main(String[] args) {
        MyCalculator myCalc = new MyCalculator();
        myCalc.run();
    }
}
