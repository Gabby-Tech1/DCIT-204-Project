import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Main {
    private JPanel rootPanel;
    private JPanel headPanel;
    private JLabel heading;
    private JPanel bodyPanel;
    private JButton button;
    private JLabel locationLabel;
    private JLabel destinationLabel;
    private JLabel outputBox1;
    private JComboBox<String> LocationSelector;
    private JComboBox<String> DestinationSelector;
    private JLabel outputBox2;

    private static JFrame frame = new JFrame("GP-1: UG NAVIGATE");

    public static JFrame getFrame() {
        return frame;
    }

    public Main() {
        initializeComponents(); // Ensure components are initialized

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String location = (String) LocationSelector.getSelectedItem();
                String destination = (String) DestinationSelector.getSelectedItem();

                Node loc1;
                Node loc2;

                // Initialize graph and nodes
                Graph graph = new Graph(true);
                Node engineeringDept = new Node(0, "Engineering Dept");
                Node csDept = new Node(1, "CS Dept");
                Node Law = new Node(2, "Law");
                Node JQB = new Node(3, "JQB");
                Node MainGate = new Node(4, "Main Gate");
                Node PerformingArts = new Node(5, "Performing Arts");
                Node MAthsandStats = new Node(6, "Maths And Stats Department");
                Node Balme = new Node(7, "Balme");
                Node UGCS = new Node(8, "UGCS");
                Node BusinessSchool = new Node(9, "Business School");
                Node VoltaHall = new Node(10, "Volta Hall");
                Node Commonwealth = new Node(11, "Commonwealth Hostel");
                Node GreatHall = new Node(12, "Great Hall");
                Node AkuafoHall = new Node(13, "Akuafo Hall");
                Node LegonHall = new Node(14, "Legon Hall");
                Node BushCanteen = new Node(15, "Bush Canteen");
                Node SarbahPark = new Node(16, "Sarbah Park");
                Node FireService = new Node(17, "Fire Station");
                Node BankingSquare = new Node(18, "Banking Square");
                Node NightMarket = new Node(19, "Night Market");
                Node BasicSchool = new Node(20, "UG Basic School");
                Node Diaspora = new Node(21, "Diaspora");

                // Add edges to the graph
                graph.addEdge(engineeringDept, csDept, 60);
                graph.addEdge(csDept, engineeringDept, 60);
                graph.addEdge(csDept, MAthsandStats, 45);
                graph.addEdge(MAthsandStats, csDept, 45);
                graph.addEdge(MAthsandStats, UGCS, 200);
                graph.addEdge(UGCS, MAthsandStats, 200);
                graph.addEdge(MAthsandStats, AkuafoHall, 180);
                graph.addEdge(AkuafoHall, MAthsandStats, 180);
                graph.addEdge(AkuafoHall, SarbahPark, 198);
                graph.addEdge(SarbahPark, AkuafoHall, 198);
                graph.addEdge(UGCS, BusinessSchool, 20);
                graph.addEdge(BusinessSchool, UGCS, 20);
                graph.addEdge(UGCS, VoltaHall, 100);
                graph.addEdge(VoltaHall, UGCS, 100);
                graph.addEdge(UGCS, LegonHall, 150);
                graph.addEdge(LegonHall, UGCS, 150);
                graph.addEdge(BusinessSchool, Balme, 90);
                graph.addEdge(Balme, BusinessSchool, 90);
                graph.addEdge(UGCS, Balme, 50);
                graph.addEdge(Balme, UGCS, 50);
                graph.addEdge(csDept, Law, 55);
                graph.addEdge(Law, csDept, 55);
                graph.addEdge(engineeringDept, Law, 70);
                graph.addEdge(Law, engineeringDept, 70);
                graph.addEdge(Law, JQB, 120);
                graph.addEdge(JQB, Law, 120);
                graph.addEdge(JQB, MainGate, 110);
                graph.addEdge(MainGate, JQB, 110);

                graph.addEdge(MainGate, PerformingArts, 70);
                graph.addEdge(PerformingArts, MainGate, 70);
                graph.addEdge(PerformingArts, BushCanteen, 65);
                graph.addEdge(BushCanteen, PerformingArts, 65);
                graph.addEdge(PerformingArts, FireService, 10);
                graph.addEdge(FireService, PerformingArts, 10);
                graph.addEdge(FireService, BushCanteen, 50);
                graph.addEdge(BushCanteen, PerformingArts, 50);
                graph.addEdge(PerformingArts, SarbahPark, 150);
                graph.addEdge(SarbahPark, PerformingArts, 150);
                graph.addEdge(PerformingArts, AkuafoHall, 158);
                graph.addEdge(AkuafoHall, PerformingArts, 158);
                graph.addEdge(AkuafoHall, Balme, 70);
                graph.addEdge(Balme, AkuafoHall, 70);
                graph.addEdge(Balme, BusinessSchool, 58);
                graph.addEdge(BusinessSchool, Balme, 58);
                graph.addEdge(SarbahPark, BankingSquare, 300);
                graph.addEdge(BankingSquare, SarbahPark, 300);
                graph.addEdge(BankingSquare, NightMarket, 10);
                graph.addEdge(NightMarket, BankingSquare, 10);
                graph.addEdge(BankingSquare, Diaspora, 320);
                graph.addEdge(Diaspora, BankingSquare, 320);
                graph.addEdge(LegonHall, SarbahPark, 135);
                graph.addEdge(SarbahPark, LegonHall, 135);
                graph.addEdge(AkuafoHall, SarbahPark, 100);
                graph.addEdge(SarbahPark, AkuafoHall, 100);

                graph.addEdge(BasicSchool, GreatHall, 400);
                graph.addEdge(GreatHall, BasicSchool, 400);
                graph.addEdge(GreatHall, Commonwealth, 15);
                graph.addEdge(Commonwealth, GreatHall, 15);

                loc1 = getNodeByName(location, engineeringDept, csDept, Law, JQB, MainGate, PerformingArts, MAthsandStats, Balme, UGCS, BusinessSchool, VoltaHall, Commonwealth, GreatHall, AkuafoHall, LegonHall, BushCanteen, SarbahPark, FireService, BankingSquare, NightMarket, BasicSchool, Diaspora);
                loc2 = getNodeByName(destination, engineeringDept, csDept, Law, JQB, MainGate, PerformingArts, MAthsandStats, Balme, UGCS, BusinessSchool, VoltaHall, Commonwealth, GreatHall, AkuafoHall, LegonHall, BushCanteen, SarbahPark, FireService, BankingSquare, NightMarket, BasicSchool, Diaspora);

                String path = graph.shortestPath(loc1, loc2);
                outputBox1.setText("From: " + loc1.name);
                outputBox2.setText("To: " + loc2.name);

                JOptionPane optionPane = new JOptionPane(path, JOptionPane.INFORMATION_MESSAGE);
                JDialog dialog = optionPane.createDialog("UG NAVIGATE Result");
                dialog.setAlwaysOnTop(true);
                dialog.setVisible(true);
            }
        });
    }

    private Node getNodeByName(String name, Node... nodes) {
        for (Node node : nodes) {
            if (node.name.equals(name)) {
                return node;
            }
        }
        return null; // or handle the error case appropriately
    }

    public static void main(String[] args) {
        showMain();
    }

    public static void showMain() {
        Main mainInstance = new Main();
        getFrame().setContentPane(mainInstance.rootPanel);
        getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getFrame().pack();
        getFrame().setLocationRelativeTo(null);
        getFrame().setResizable(false);
        getFrame().setVisible(true);
    }

    private void initializeComponents() {
        rootPanel = new JPanel(new CardLayout());

        // Welcome Panel
        BackgroundPanel welcomePanel = new BackgroundPanel("/resources/ug.jpeg");
        welcomePanel.setLayout(new BoxLayout(welcomePanel, BoxLayout.Y_AXIS));
        welcomePanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel welcomeLabel = new JLabel("Welcome to UG NAVIGATE", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Poppins", Font.BOLD, 28));
        welcomeLabel.setForeground(Color.white);
        welcomeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton startButton = new JButton("Start");
        startButton.setFont(new Font("Arial", Font.PLAIN, 16));
        startButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        welcomePanel.add(Box.createVerticalGlue());
        welcomePanel.add(welcomeLabel);
        welcomePanel.add(Box.createRigidArea(new Dimension(0, 20)));
        welcomePanel.add(startButton);
        welcomePanel.add(Box.createVerticalGlue());

        // Main Navigation Panel
        JPanel mainPanel = new JPanel(new BorderLayout());
        headPanel = new JPanel();
        bodyPanel = new JPanel(new GridBagLayout());
        heading = new JLabel("GP-1: UG NAVIGATION", SwingConstants.CENTER);
        heading.setFont(new Font("Arial", Font.BOLD, 24));
        heading.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        
        button = new JButton("Find Path");
        button.setFont(new Font("Arial", Font.PLAIN, 16));
        locationLabel = new JLabel("Location:");
        locationLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        destinationLabel = new JLabel("Destination:");
        destinationLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        
        outputBox1 = new JLabel();
        outputBox1.setFont(new Font("Arial", Font.PLAIN, 14));
        outputBox2 = new JLabel();
        outputBox2.setFont(new Font("Arial", Font.PLAIN, 14));
        
        LocationSelector = new JComboBox<>(new String[]{
            "Engineering Dept", "CS Dept", "Law", "JQB", "Main Gate", "Performing Arts", 
            "Maths And Stats Department", "Balme", "UGCS", "Business School", "Volta Hall", 
            "Commonwealth Hostel", "Great Hall", "Akuafo Hall", "Legon Hall", "Bush Canteen", 
            "Sarbah Park", "Fire Station", "Banking Square", "Night Market", "UG Basic School", "Diaspora"
        });
        
        DestinationSelector = new JComboBox<>(new String[]{
            "Engineering Dept", "CS Dept", "Law", "JQB", "Main Gate", "Performing Arts", 
            "Maths And Stats Department", "Balme", "UGCS", "Business School", "Volta Hall", 
            "Commonwealth Hostel", "Great Hall", "Akuafo Hall", "Legon Hall", "Bush Canteen", 
            "Sarbah Park", "Fire Station", "Banking Square", "Night Market", "UG Basic School", "Diaspora"
        });

        // Add padding to panels
        headPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        bodyPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Set up the layout and add components to panels
        headPanel.add(heading);
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Increased padding between components
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        bodyPanel.add(locationLabel, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        bodyPanel.add(LocationSelector, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        bodyPanel.add(destinationLabel, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        bodyPanel.add(DestinationSelector, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        bodyPanel.add(button, gbc);

        gbc.gridy = 3;
        bodyPanel.add(outputBox1, gbc);

        gbc.gridy = 4;
        bodyPanel.add(outputBox2, gbc);

        mainPanel.add(headPanel, BorderLayout.NORTH);
        mainPanel.add(bodyPanel, BorderLayout.CENTER);

        rootPanel.add(welcomePanel, "Welcome");
        rootPanel.add(mainPanel, "Main");

        // Action to switch from welcome screen to main screen
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) (rootPanel.getLayout());
                cl.show(rootPanel, "Main");
            }
        });
    }

    // Inner class to handle the background image
    class BackgroundPanel extends JPanel {
        private BufferedImage backgroundImage;
    
        public BackgroundPanel(String imagePath) {
            try {
                // Use the class loader to get the resource from the classpath
                backgroundImage = ImageIO.read(getClass().getResource(imagePath));
                if (backgroundImage == null) {
                    throw new IOException("Image not found: " + imagePath);
                }
            } catch (IOException e) {
                e.printStackTrace();
                // Optionally handle the case where the image cannot be loaded
                JOptionPane.showMessageDialog(null, "Error loading image: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (backgroundImage != null) {
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        }
    }
}    


