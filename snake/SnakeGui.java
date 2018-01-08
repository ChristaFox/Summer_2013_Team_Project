package snake;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Rectangle;
import java.awt.Point;

public class SnakeGui extends JFrame {

	private static final long serialVersionUID = -2876525438319381607L;
	private JPanel contentPane;
	private JPanel buttonPanel;
	private JPanel upperPanel;
	private JPanel lowerPanel;
	private JPanel leftBorder;
	private JPanel rightBorder;
	
	private JButton btnExitButton;
	private JButton btnStartButton;
	private JButton btnLeaderBoardButton;

	private JLabel lblSnake;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SnakeGui frame = new SnakeGui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public SnakeGui() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		setLocationRelativeTo(null);
		setTitle("Snake");
		
		createUpperPanel();
		createLowerPanel();
		createContentPane();
	}

	private void createContentPane() {
		
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		contentPane.add(upperPanel);
		contentPane.add(lowerPanel, BorderLayout.SOUTH);
	}

	private void createUpperPanel() {
		
		upperPanel = new JPanel();
		upperPanel.setLayout(new BorderLayout(0, 0));
		upperPanel.setBackground(Color.DARK_GRAY);
		
		lblSnake = new JLabel("Snake");
		lblSnake.setIcon(new ImageIcon(SnakeGui.class.getResource("crazyToungueSnake.png")));
		lblSnake.setBounds(0, 0, 100, 50);
		lblSnake.setFont(new Font("Marker Felt", Font.PLAIN, 40));
		lblSnake.setForeground(Color.RED);
		lblSnake.setHorizontalAlignment(SwingConstants.CENTER);
		
		upperPanel.add(lblSnake);
	}

	private void createLowerPanel() {
		
		lowerPanel = new JPanel();
		lowerPanel.setLocation(new Point(50, 400));
		lowerPanel.setBounds(new Rectangle(50, 400, 500, 100));
		lowerPanel.setLayout(new GridLayout(0, 3, 0, 0));
		
		leftBorder = new JPanel();
		leftBorder.setBackground(Color.DARK_GRAY);
		lowerPanel.add(leftBorder);

		createButtonPanel();		
		lowerPanel.add(buttonPanel);
		
		rightBorder = new JPanel();
		rightBorder.setBackground(Color.DARK_GRAY);
		lowerPanel.add(rightBorder);
	}

	private void createButtonPanel() {
		
		buttonPanel = new JPanel();
		buttonPanel.setBackground(Color.DARK_GRAY);
		buttonPanel.setLayout(new GridLayout(3, 0, 0, 0));	
		
		addStartButton();
		addLeaderBoardButton();
		addExitButton();
	}

	private void addStartButton() {
		
		btnStartButton = new JButton("Start");
		btnStartButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				upperPanel.removeAll();
				upperPanel.add(lblSnake);
				
				revalidate();
				repaint();
				
				runGame();
			}
		});
		
		btnStartButton.setBackground(Color.CYAN);
		btnStartButton.setForeground(Color.BLACK);
		buttonPanel.add(btnStartButton);
	}
	
	private void addLeaderBoardButton() {
		
		btnLeaderBoardButton = new JButton("Leader Board");
		btnLeaderBoardButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					upperPanel.removeAll();
					new HighScoresPanel( upperPanel );
					
					revalidate();
					repaint();
					
				} catch (Exception exc) {
					exc.printStackTrace();
				}
			}
		});
		buttonPanel.add(btnLeaderBoardButton);
	}
	
	private void addExitButton() {
		
		btnExitButton = new JButton("Exit");		
		btnExitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		buttonPanel.add(btnExitButton);
	}

	private void runGame()
	{
		try {
			String separator = System.getProperty("file.separator");
			String classpath = System.getProperty("java.class.path");
			String path = System.getProperty("java.home") + separator + "bin" + separator + "java";
			ProcessBuilder snakeGame = new ProcessBuilder(path, "-cp", classpath, SnakeGame.class.getName());
			snakeGame.start();
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
}
