import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    /**
     * The parameter to decide whether heart is clicked or not.
     */
    static boolean isPressed = false;
    public static void main(String[] args){
        Main.frameOn();


    }
    /**
     * Method to resize the given img.
     * @param icon Icon to resize.
     * @return Returns scaled img.
     */
    public static ImageIcon iconSetter(ImageIcon icon){
        Image img = icon.getImage();
        Image newImg = img.getScaledInstance(300,300,Image.SCALE_SMOOTH);
        icon = new ImageIcon(newImg);
        return icon;
    }
    /**
     * It contains frames, panels, buttons, action listener which basically means everything.
     */
    public static void frameOn(){
        ImageIcon icon1 = new ImageIcon(Main.class.getClassLoader().getResource("1.png"));
        ImageIcon icon2 = new ImageIcon(Main.class.getClassLoader().getResource("2.png"));
        ImageIcon icon3 = new ImageIcon(Main.class.getClassLoader().getResource("3.png"));
        JFrame mainFrame = new JFrame();
        mainFrame.setSize(900,500);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBackground(Color.PINK);
        mainFrame.add(mainPanel);

        Timer timer;
        JLabel time = new JLabel("10");
        time.setBounds(432,0,300,100);
        time.setFont(new Font("Serif", Font.BOLD, 48));
        mainPanel.add(time);



        JButton heartButton = new JButton(Main.iconSetter(icon1));
        heartButton.setBackground(null);
        heartButton.setBorderPainted(false);
        heartButton.setContentAreaFilled(false);
        heartButton.setBounds(300,100,300,300);
        mainPanel.add(heartButton);

        JLabel mainPanelLabel = new JLabel("QUICK, CLICK THE HEART AND BREAK IT !!!!");
        mainPanelLabel.setBounds(320,50,300,100);
        mainPanel.add(mainPanelLabel);



        heartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isPressed = true;
            }
        });

        timer = new Timer(1250, new ActionListener() {
            int counter = 10;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (counter > 0) {
                    counter--;
                    time.setText(String.valueOf(counter));
                } else {
                    ((Timer) e.getSource()).stop();
                    if(isPressed){
                        time.setText("Time is up.");
                        time.setBounds(335,0,300,100);
                        mainPanelLabel.setText("You lost.");
                        mainPanelLabel.setBounds(375,50,300,100);
                        mainPanelLabel.setFont(new Font("Serif", Font.BOLD, 36));
                        heartButton.setIcon(Main.iconSetter(icon2));
                        heartButton.setDisabledIcon(iconSetter(icon2));
                        heartButton.setEnabled(false);

                        JButton retry = new JButton("Again?");
                        mainPanel.add(retry);
                        retry.setBounds(375,400,150,50);
                        retry.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                isPressed = false;
                                mainFrame.dispose();
                                Main.frameOn();
                            }
                        });
                    }else{
                        heartButton.setDisabledIcon(Main.iconSetter(icon1));
                        heartButton.setEnabled(false);
                        time.setText("YOU DID IT !");
                        time.setBounds(310,0,300,100);
                        mainPanelLabel.setVisible(false);
                        JButton seePrize = new JButton("See your prize.");
                        mainPanel.add(seePrize);
                        seePrize.setBounds(375,400,150,50);
                        seePrize.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                JFrame secondFrame = new JFrame();
                                secondFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                                secondFrame.setSize(500,250);
                                secondFrame.setBounds(250,125,400,300);

                                JPanel secondPanel = new JPanel(null);
                                secondPanel.setBackground(Color.GREEN);
                                secondFrame.add(secondPanel);

                                JLabel secondLabel = new JLabel("Prize: HAPPY FINAL");
                                secondLabel.setFont(new Font("Serif", Font.BOLD, 36));
                                secondPanel.add(secondLabel);
                                secondLabel.setBounds(20,-75,400,200);

                                JLabel messageLabel0 = new JLabel("");
                                messageLabel0.setFont(new Font("Serif", Font.BOLD, 30));
                                secondPanel.add(messageLabel0);
                                messageLabel0.setBounds(90,15,300,100);

                                JLabel messageLabel1 = new JLabel("You protected");
                                messageLabel1.setFont(new Font("Serif", Font.BOLD, 35));
                                secondPanel.add(messageLabel1);
                                messageLabel1.setBounds(80,75,300,100);

                                JLabel messageLabel2 = new JLabel("your love's heart.");
                                messageLabel2.setFont(new Font("Serif", Font.BOLD, 35));
                                secondPanel.add(messageLabel2);
                                messageLabel2.setBounds(65,125,300,100);

                                JLabel messageLabel3 = new JLabel("You are a true lover.");
                                messageLabel3.setFont(new Font("Serif", Font.BOLD, 15));
                                secondPanel.add(messageLabel3);
                                messageLabel3.setBounds(0,200,400,100);

                                JButton retry = new JButton("End");
                                secondPanel.add(retry);
                                retry.setBounds(275,215,100,50);
                                retry.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        secondFrame.dispose();
                                        mainFrame.dispose();
                                    }
                                });
                                secondFrame.setVisible(true);
                            }
                        });
                    }

                }
            }
        });
        timer.start();

        heartButton.addActionListener(new ActionListener() {
            int a = 0;
            @Override
            public void actionPerformed(ActionEvent e) {
                a++;
                if(a == 10){
                    timer.stop();
                    heartButton.setIcon(Main.iconSetter(icon3));
                    time.setText("YOU DID IT.");
                    time.setBounds(325,0,300,100);
                    mainPanelLabel.setVisible(false);
                    JButton seePrize = new JButton("See your prize.");
                    mainPanel.add(seePrize);
                    seePrize.setBounds(375,400,150,50);
                    seePrize.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            JFrame secondFrame = new JFrame();
                            secondFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                            secondFrame.setSize(500,250);
                            secondFrame.setBounds(250,125,400,300);

                            JPanel secondPanel = new JPanel(null);
                            secondPanel.setBackground(Color.GRAY);
                            secondFrame.add(secondPanel);

                            JLabel secondLabel = new JLabel("Prize: BAD ENDING");
                            secondLabel.setFont(new Font("Serif", Font.BOLD, 36));
                            secondPanel.add(secondLabel);
                            secondLabel.setBounds(25,-50,400,200);

                            JLabel messageLabel1 = new JLabel("You didn't protect");
                            messageLabel1.setFont(new Font("Serif", Font.BOLD, 30));
                            secondPanel.add(messageLabel1);
                            messageLabel1.setBounds(65,75,300,100);

                            JLabel messageLabel2 = new JLabel("your love's heart.");
                            messageLabel2.setFont(new Font("Serif", Font.BOLD, 30));
                            secondPanel.add(messageLabel2);
                            messageLabel2.setBounds(75,125,300,100);

                            JLabel messageLabel3 = new JLabel("Hint: Be careful to not break it.");
                            messageLabel3.setFont(new Font("Serif", Font.BOLD, 15));
                            secondPanel.add(messageLabel3);
                            messageLabel3.setBounds(0,200,400,100);

                            JButton retry = new JButton("Again?");
                            secondPanel.add(retry);
                            retry.setBounds(275,215,100,50);
                            retry.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    isPressed = false;
                                    secondFrame.dispose();
                                    mainFrame.dispose();
                                    Main.frameOn();
                                }
                            });
                            secondFrame.setVisible(true);
                        }
                    });

                }
            }
        });


        mainFrame.setVisible(true);
    }

}
