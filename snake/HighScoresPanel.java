package snake;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class HighScoresPanel extends JPanel
{
	private static final long serialVersionUID = 7860690786688484227L;

	private HighScoresList highScoresList = new HighScoresList();
	
	private JPanel highScoresPanel;
	private JLabel lblHighScores;
	private JPanel panelHighScoresFlowPanel;
	private JPanel panelGridBagPanel;
	private JLabel lblHighScore1Name;
	private JLabel lblHighScore1Apples;
	private JLabel lblHighScore1Points;
	private JLabel lblHighScore2Name;
	private JLabel lblHighScore2Apples;
	private JLabel lblHighScore2Points;
	private JLabel lblHighScore3Name;
	private JLabel lblHighScore3Apples;
	private JLabel lblHighScore3Points;
	private JLabel lblHighScore4Name;
	private JLabel lblHighScore4Apples;
	private JLabel lblHighScore4Points;
	private JLabel lblHighScore5Name;
	private JLabel lblHighScore5Apples;
	private JLabel lblHighScore5Points;
	private JLabel lblHighScore6Name;
	private JLabel lblHighScore6Apples;
	private JLabel lblHighScore6Points;
	private JLabel lblHighScore7Name;
	private JLabel lblHighScore7Apples;
	private JLabel lblHighScore7Points;
	private JLabel lblHighScore8Name;
	private JLabel lblHighScore8Apples;
	private JLabel lblHighScore8Points;
	private JLabel lblHighScore9Name;
	private JLabel lblHighScore9Apples;
	private JLabel lblHighScore9Points;
	private JLabel lblHighScore10Name;
	private JLabel lblHighScore10Apples;
	private JLabel lblHighScore10Points;
	private JLabel lblHighScore1Ordinal;
	private JLabel lblHighScore2Ordinal;
	private JLabel lblHighScore3Ordinal;
	private JLabel lblHighScore4Ordinal;
	private JLabel lblHighScore5Ordinal;
	private JLabel lblHighScore6Ordinal;
	private JLabel lblHighScore7Ordinal;
	private JLabel lblHighScore8Ordinal;
	private JLabel lblHighScore9Ordinal;
	private JLabel lblHighScore10Ordinal;
	private JLabel lblHighScoresName;
	private JLabel lblHighScoresApples;
	private JLabel lblHighScoresPoints;

	/**
	 * Adds a panel that displays the high scores in HighScoreList
	 * @param panel the panel that you would like this panel to be displayed in
	 */
	public HighScoresPanel( JPanel panel ) {
		
		highScoresPanel = new JPanel();
		panel.add( highScoresPanel, BorderLayout.CENTER );
		highScoresPanel.setBackground( Color.DARK_GRAY );
		highScoresPanel.setForeground(Color.WHITE);
		highScoresPanel.setLayout(new BorderLayout(0, 0));
		
		title();
		gridBagPanel();
		Headers();
		column1();
		column2();
		column3();
		column4();
		column5();
		column6();
		column7();
		column8();
		column9();
		column10();
	}

	private void column10() {
		lblHighScore10Ordinal = new JLabel("10.");
		lblHighScore10Ordinal.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblHighScore10Ordinal = new GridBagConstraints();
		gbc_lblHighScore10Ordinal.anchor = GridBagConstraints.EAST;
		gbc_lblHighScore10Ordinal.insets = new Insets(0, 0, 0, 5);
		gbc_lblHighScore10Ordinal.gridx = 0;
		gbc_lblHighScore10Ordinal.gridy = 10;
		panelGridBagPanel.add(lblHighScore10Ordinal, gbc_lblHighScore10Ordinal);
		
		lblHighScore10Name = new JLabel( highScoresList.get( 9 ).getName() );
		lblHighScore10Name.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblHighScore10Name = new GridBagConstraints();
		gbc_lblHighScore10Name.anchor = GridBagConstraints.WEST;
		gbc_lblHighScore10Name.insets = new Insets(0, 0, 0, 5);
		gbc_lblHighScore10Name.gridx = 2;
		gbc_lblHighScore10Name.gridy = 10;
		panelGridBagPanel.add(lblHighScore10Name, gbc_lblHighScore10Name);
		
		lblHighScore10Apples = new JLabel( String.format( "%,d", highScoresList.get( 9 ).getApples() ) );
		lblHighScore10Apples.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblHighScore10Apples = new GridBagConstraints();
		gbc_lblHighScore10Apples.anchor = GridBagConstraints.EAST;
		gbc_lblHighScore10Apples.insets = new Insets(0, 0, 0, 5);
		gbc_lblHighScore10Apples.gridx = 4;
		gbc_lblHighScore10Apples.gridy = 10;
		panelGridBagPanel.add(lblHighScore10Apples, gbc_lblHighScore10Apples);
		
		lblHighScore10Points = new JLabel( String.format( "%,d", highScoresList.get( 9 ).getPoints() ) );
		lblHighScore10Points.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblHighScore10Points = new GridBagConstraints();
		gbc_lblHighScore10Points.anchor = GridBagConstraints.EAST;
		gbc_lblHighScore10Points.gridx = 6;
		gbc_lblHighScore10Points.gridy = 10;
		panelGridBagPanel.add(lblHighScore10Points, gbc_lblHighScore10Points);
	}

	private void column9() {
		lblHighScore9Ordinal = new JLabel("9.");
		lblHighScore9Ordinal.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblHighScore9Ordinal = new GridBagConstraints();
		gbc_lblHighScore9Ordinal.anchor = GridBagConstraints.EAST;
		gbc_lblHighScore9Ordinal.insets = new Insets(0, 0, 5, 5);
		gbc_lblHighScore9Ordinal.gridx = 0;
		gbc_lblHighScore9Ordinal.gridy = 9;
		panelGridBagPanel.add(lblHighScore9Ordinal, gbc_lblHighScore9Ordinal);
		
		lblHighScore9Name = new JLabel( highScoresList.get( 8 ).getName() );
		lblHighScore9Name.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblHighScore9Name = new GridBagConstraints();
		gbc_lblHighScore9Name.anchor = GridBagConstraints.WEST;
		gbc_lblHighScore9Name.insets = new Insets(0, 0, 5, 5);
		gbc_lblHighScore9Name.gridx = 2;
		gbc_lblHighScore9Name.gridy = 9;
		panelGridBagPanel.add(lblHighScore9Name, gbc_lblHighScore9Name);
		
		lblHighScore9Apples = new JLabel( String.format( "%,d", highScoresList.get( 8 ).getApples() ) );
		lblHighScore9Apples.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblHighScore9Apples = new GridBagConstraints();
		gbc_lblHighScore9Apples.anchor = GridBagConstraints.EAST;
		gbc_lblHighScore9Apples.insets = new Insets(0, 0, 5, 5);
		gbc_lblHighScore9Apples.gridx = 4;
		gbc_lblHighScore9Apples.gridy = 9;
		panelGridBagPanel.add(lblHighScore9Apples, gbc_lblHighScore9Apples);
		
		lblHighScore9Points = new JLabel( String.format( "%,d", highScoresList.get( 8 ).getPoints() ) );
		lblHighScore9Points.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblHighScore9Points = new GridBagConstraints();
		gbc_lblHighScore9Points.anchor = GridBagConstraints.EAST;
		gbc_lblHighScore9Points.insets = new Insets(0, 0, 5, 0);
		gbc_lblHighScore9Points.gridx = 6;
		gbc_lblHighScore9Points.gridy = 9;
		panelGridBagPanel.add(lblHighScore9Points, gbc_lblHighScore9Points);
	}

	private void column8() {
		lblHighScore8Ordinal = new JLabel("8.");
		lblHighScore8Ordinal.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblHighScore8Ordinal = new GridBagConstraints();
		gbc_lblHighScore8Ordinal.anchor = GridBagConstraints.EAST;
		gbc_lblHighScore8Ordinal.insets = new Insets(0, 0, 5, 5);
		gbc_lblHighScore8Ordinal.gridx = 0;
		gbc_lblHighScore8Ordinal.gridy = 8;
		panelGridBagPanel.add(lblHighScore8Ordinal, gbc_lblHighScore8Ordinal);
		
		lblHighScore8Name = new JLabel( highScoresList.get( 7 ).getName() );
		lblHighScore8Name.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblHighScore8Name = new GridBagConstraints();
		gbc_lblHighScore8Name.anchor = GridBagConstraints.WEST;
		gbc_lblHighScore8Name.insets = new Insets(0, 0, 5, 5);
		gbc_lblHighScore8Name.gridx = 2;
		gbc_lblHighScore8Name.gridy = 8;
		panelGridBagPanel.add(lblHighScore8Name, gbc_lblHighScore8Name);
		
		lblHighScore8Apples = new JLabel( String.format( "%,d", highScoresList.get( 7 ).getApples() ) );
		lblHighScore8Apples.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblHighScore8Apples = new GridBagConstraints();
		gbc_lblHighScore8Apples.anchor = GridBagConstraints.EAST;
		gbc_lblHighScore8Apples.insets = new Insets(0, 0, 5, 5);
		gbc_lblHighScore8Apples.gridx = 4;
		gbc_lblHighScore8Apples.gridy = 8;
		panelGridBagPanel.add(lblHighScore8Apples, gbc_lblHighScore8Apples);
		
		lblHighScore8Points = new JLabel( String.format( "%,d", highScoresList.get( 7 ).getPoints() ) );
		lblHighScore8Points.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblHighScore8Points = new GridBagConstraints();
		gbc_lblHighScore8Points.anchor = GridBagConstraints.EAST;
		gbc_lblHighScore8Points.insets = new Insets(0, 0, 5, 0);
		gbc_lblHighScore8Points.gridx = 6;
		gbc_lblHighScore8Points.gridy = 8;
		panelGridBagPanel.add(lblHighScore8Points, gbc_lblHighScore8Points);
	}

	private void column7() {
		lblHighScore7Ordinal = new JLabel("7.");
		lblHighScore7Ordinal.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblHighScore7Ordinal = new GridBagConstraints();
		gbc_lblHighScore7Ordinal.anchor = GridBagConstraints.EAST;
		gbc_lblHighScore7Ordinal.insets = new Insets(0, 0, 5, 5);
		gbc_lblHighScore7Ordinal.gridx = 0;
		gbc_lblHighScore7Ordinal.gridy = 7;
		panelGridBagPanel.add(lblHighScore7Ordinal, gbc_lblHighScore7Ordinal);
		
		lblHighScore7Name = new JLabel( highScoresList.get( 6 ).getName() );
		lblHighScore7Name.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblHighScore7Name = new GridBagConstraints();
		gbc_lblHighScore7Name.anchor = GridBagConstraints.WEST;
		gbc_lblHighScore7Name.insets = new Insets(0, 0, 5, 5);
		gbc_lblHighScore7Name.gridx = 2;
		gbc_lblHighScore7Name.gridy = 7;
		panelGridBagPanel.add(lblHighScore7Name, gbc_lblHighScore7Name);
		
		lblHighScore7Apples = new JLabel( String.format( "%,d", highScoresList.get( 6 ).getApples() ) );
		lblHighScore7Apples.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblHighScore7Apples = new GridBagConstraints();
		gbc_lblHighScore7Apples.anchor = GridBagConstraints.EAST;
		gbc_lblHighScore7Apples.insets = new Insets(0, 0, 5, 5);
		gbc_lblHighScore7Apples.gridx = 4;
		gbc_lblHighScore7Apples.gridy = 7;
		panelGridBagPanel.add(lblHighScore7Apples, gbc_lblHighScore7Apples);
		
		lblHighScore7Points = new JLabel( String.format( "%,d", highScoresList.get( 6 ).getPoints() ) );
		lblHighScore7Points.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblHighScore7Points = new GridBagConstraints();
		gbc_lblHighScore7Points.anchor = GridBagConstraints.EAST;
		gbc_lblHighScore7Points.insets = new Insets(0, 0, 5, 0);
		gbc_lblHighScore7Points.gridx = 6;
		gbc_lblHighScore7Points.gridy = 7;
		panelGridBagPanel.add(lblHighScore7Points, gbc_lblHighScore7Points);
	}

	private void column6() {
		lblHighScore6Ordinal = new JLabel("6.");
		lblHighScore6Ordinal.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblHighScore6Ordinal = new GridBagConstraints();
		gbc_lblHighScore6Ordinal.anchor = GridBagConstraints.EAST;
		gbc_lblHighScore6Ordinal.insets = new Insets(0, 0, 5, 5);
		gbc_lblHighScore6Ordinal.gridx = 0;
		gbc_lblHighScore6Ordinal.gridy = 6;
		panelGridBagPanel.add(lblHighScore6Ordinal, gbc_lblHighScore6Ordinal);
		
		lblHighScore6Name = new JLabel( highScoresList.get( 5 ).getName() );
		lblHighScore6Name.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblHighScore6Name = new GridBagConstraints();
		gbc_lblHighScore6Name.anchor = GridBagConstraints.WEST;
		gbc_lblHighScore6Name.insets = new Insets(0, 0, 5, 5);
		gbc_lblHighScore6Name.gridx = 2;
		gbc_lblHighScore6Name.gridy = 6;
		panelGridBagPanel.add(lblHighScore6Name, gbc_lblHighScore6Name);
		
		lblHighScore6Apples = new JLabel( String.format( "%,d", highScoresList.get( 5 ).getApples() ) );
		lblHighScore6Apples.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblHighScore6Apples = new GridBagConstraints();
		gbc_lblHighScore6Apples.anchor = GridBagConstraints.EAST;
		gbc_lblHighScore6Apples.insets = new Insets(0, 0, 5, 5);
		gbc_lblHighScore6Apples.gridx = 4;
		gbc_lblHighScore6Apples.gridy = 6;
		panelGridBagPanel.add(lblHighScore6Apples, gbc_lblHighScore6Apples);
		
		lblHighScore6Points = new JLabel( String.format( "%,d", highScoresList.get( 5 ).getPoints() ) );
		lblHighScore6Points.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblHighScore6Points = new GridBagConstraints();
		gbc_lblHighScore6Points.anchor = GridBagConstraints.EAST;
		gbc_lblHighScore6Points.insets = new Insets(0, 0, 5, 0);
		gbc_lblHighScore6Points.gridx = 6;
		gbc_lblHighScore6Points.gridy = 6;
		panelGridBagPanel.add(lblHighScore6Points, gbc_lblHighScore6Points);
	}

	private void column5() {
		lblHighScore5Ordinal = new JLabel("5.");
		lblHighScore5Ordinal.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblHighScore5Ordinal = new GridBagConstraints();
		gbc_lblHighScore5Ordinal.anchor = GridBagConstraints.EAST;
		gbc_lblHighScore5Ordinal.insets = new Insets(0, 0, 5, 5);
		gbc_lblHighScore5Ordinal.gridx = 0;
		gbc_lblHighScore5Ordinal.gridy = 5;
		panelGridBagPanel.add(lblHighScore5Ordinal, gbc_lblHighScore5Ordinal);
		
		lblHighScore5Name = new JLabel( highScoresList.get( 4 ).getName() );
		lblHighScore5Name.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblHighScore5Name = new GridBagConstraints();
		gbc_lblHighScore5Name.anchor = GridBagConstraints.WEST;
		gbc_lblHighScore5Name.insets = new Insets(0, 0, 5, 5);
		gbc_lblHighScore5Name.gridx = 2;
		gbc_lblHighScore5Name.gridy = 5;
		panelGridBagPanel.add(lblHighScore5Name, gbc_lblHighScore5Name);
		
		lblHighScore5Apples = new JLabel( String.format( "%,d", highScoresList.get( 4 ).getApples() ) );
		lblHighScore5Apples.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblHighScore5Apples = new GridBagConstraints();
		gbc_lblHighScore5Apples.anchor = GridBagConstraints.EAST;
		gbc_lblHighScore5Apples.insets = new Insets(0, 0, 5, 5);
		gbc_lblHighScore5Apples.gridx = 4;
		gbc_lblHighScore5Apples.gridy = 5;
		panelGridBagPanel.add(lblHighScore5Apples, gbc_lblHighScore5Apples);
		
		lblHighScore5Points = new JLabel( String.format( "%,d", highScoresList.get( 4 ).getPoints() ) );
		lblHighScore5Points.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblHighScore5Points = new GridBagConstraints();
		gbc_lblHighScore5Points.anchor = GridBagConstraints.EAST;
		gbc_lblHighScore5Points.insets = new Insets(0, 0, 5, 0);
		gbc_lblHighScore5Points.gridx = 6;
		gbc_lblHighScore5Points.gridy = 5;
		panelGridBagPanel.add(lblHighScore5Points, gbc_lblHighScore5Points);
	}

	private void column4() {
		lblHighScore4Ordinal = new JLabel("4.");
		lblHighScore4Ordinal.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblHighScore4Ordinal = new GridBagConstraints();
		gbc_lblHighScore4Ordinal.anchor = GridBagConstraints.EAST;
		gbc_lblHighScore4Ordinal.insets = new Insets(0, 0, 5, 5);
		gbc_lblHighScore4Ordinal.gridx = 0;
		gbc_lblHighScore4Ordinal.gridy = 4;
		panelGridBagPanel.add(lblHighScore4Ordinal, gbc_lblHighScore4Ordinal);
		
		lblHighScore4Name = new JLabel( highScoresList.get( 3 ).getName() );
		lblHighScore4Name.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblHighScore4Name = new GridBagConstraints();
		gbc_lblHighScore4Name.anchor = GridBagConstraints.WEST;
		gbc_lblHighScore4Name.insets = new Insets(0, 0, 5, 5);
		gbc_lblHighScore4Name.gridx = 2;
		gbc_lblHighScore4Name.gridy = 4;
		panelGridBagPanel.add(lblHighScore4Name, gbc_lblHighScore4Name);
		
		lblHighScore4Apples = new JLabel( String.format( "%,d", highScoresList.get( 3 ).getApples() ) );
		lblHighScore4Apples.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblHighScore4Apples = new GridBagConstraints();
		gbc_lblHighScore4Apples.anchor = GridBagConstraints.EAST;
		gbc_lblHighScore4Apples.insets = new Insets(0, 0, 5, 5);
		gbc_lblHighScore4Apples.gridx = 4;
		gbc_lblHighScore4Apples.gridy = 4;
		panelGridBagPanel.add(lblHighScore4Apples, gbc_lblHighScore4Apples);
		
		lblHighScore4Points = new JLabel( String.format( "%,d", highScoresList.get( 3 ).getPoints() ) );
		lblHighScore4Points.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblHighScore4Points = new GridBagConstraints();
		gbc_lblHighScore4Points.anchor = GridBagConstraints.EAST;
		gbc_lblHighScore4Points.insets = new Insets(0, 0, 5, 0);
		gbc_lblHighScore4Points.gridx = 6;
		gbc_lblHighScore4Points.gridy = 4;
		panelGridBagPanel.add(lblHighScore4Points, gbc_lblHighScore4Points);
	}

	private void column3() {
		lblHighScore3Ordinal = new JLabel("3.");
		lblHighScore3Ordinal.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblHighScore3Ordinal = new GridBagConstraints();
		gbc_lblHighScore3Ordinal.anchor = GridBagConstraints.EAST;
		gbc_lblHighScore3Ordinal.insets = new Insets(0, 0, 5, 5);
		gbc_lblHighScore3Ordinal.gridx = 0;
		gbc_lblHighScore3Ordinal.gridy = 3;
		panelGridBagPanel.add(lblHighScore3Ordinal, gbc_lblHighScore3Ordinal);
		
		lblHighScore3Name = new JLabel( highScoresList.get( 2 ).getName() );
		lblHighScore3Name.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblHighScore3Name = new GridBagConstraints();
		gbc_lblHighScore3Name.anchor = GridBagConstraints.WEST;
		gbc_lblHighScore3Name.insets = new Insets(0, 0, 5, 5);
		gbc_lblHighScore3Name.gridx = 2;
		gbc_lblHighScore3Name.gridy = 3;
		panelGridBagPanel.add(lblHighScore3Name, gbc_lblHighScore3Name);
		
		lblHighScore3Apples = new JLabel( String.format( "%,d", highScoresList.get( 2 ).getApples() ) );
		lblHighScore3Apples.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblHighScore3Apples = new GridBagConstraints();
		gbc_lblHighScore3Apples.anchor = GridBagConstraints.EAST;
		gbc_lblHighScore3Apples.insets = new Insets(0, 0, 5, 5);
		gbc_lblHighScore3Apples.gridx = 4;
		gbc_lblHighScore3Apples.gridy = 3;
		panelGridBagPanel.add(lblHighScore3Apples, gbc_lblHighScore3Apples);
		
		lblHighScore3Points = new JLabel( String.format( "%,d", highScoresList.get( 2 ).getPoints() ) );
		lblHighScore3Points.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblHighScore3Points = new GridBagConstraints();
		gbc_lblHighScore3Points.anchor = GridBagConstraints.EAST;
		gbc_lblHighScore3Points.insets = new Insets(0, 0, 5, 0);
		gbc_lblHighScore3Points.gridx = 6;
		gbc_lblHighScore3Points.gridy = 3;
		panelGridBagPanel.add(lblHighScore3Points, gbc_lblHighScore3Points);
	}

	private void column2() {
		lblHighScore2Ordinal = new JLabel("2.");
		lblHighScore2Ordinal.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblHighScore2Ordinal = new GridBagConstraints();
		gbc_lblHighScore2Ordinal.anchor = GridBagConstraints.EAST;
		gbc_lblHighScore2Ordinal.insets = new Insets(0, 0, 5, 5);
		gbc_lblHighScore2Ordinal.gridx = 0;
		gbc_lblHighScore2Ordinal.gridy = 2;
		panelGridBagPanel.add(lblHighScore2Ordinal, gbc_lblHighScore2Ordinal);
		
		lblHighScore2Name = new JLabel( highScoresList.get( 1 ).getName() );
		lblHighScore2Name.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblHighScore2Name = new GridBagConstraints();
		gbc_lblHighScore2Name.anchor = GridBagConstraints.WEST;
		gbc_lblHighScore2Name.insets = new Insets(0, 0, 5, 5);
		gbc_lblHighScore2Name.gridx = 2;
		gbc_lblHighScore2Name.gridy = 2;
		panelGridBagPanel.add(lblHighScore2Name, gbc_lblHighScore2Name);
		
		lblHighScore2Apples = new JLabel( String.format( "%,d", highScoresList.get( 1 ).getApples() ) );
		lblHighScore2Apples.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblHighScore2Apples = new GridBagConstraints();
		gbc_lblHighScore2Apples.anchor = GridBagConstraints.EAST;
		gbc_lblHighScore2Apples.insets = new Insets(0, 0, 5, 5);
		gbc_lblHighScore2Apples.gridx = 4;
		gbc_lblHighScore2Apples.gridy = 2;
		panelGridBagPanel.add(lblHighScore2Apples, gbc_lblHighScore2Apples);
		
		lblHighScore2Points = new JLabel( String.format( "%,d", highScoresList.get( 1 ).getPoints() ) );
		lblHighScore2Points.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblHighScore2Points = new GridBagConstraints();
		gbc_lblHighScore2Points.anchor = GridBagConstraints.EAST;
		gbc_lblHighScore2Points.insets = new Insets(0, 0, 5, 0);
		gbc_lblHighScore2Points.gridx = 6;
		gbc_lblHighScore2Points.gridy = 2;
		panelGridBagPanel.add(lblHighScore2Points, gbc_lblHighScore2Points);
	}

	private void column1() {
		lblHighScore1Ordinal = new JLabel("1.");
		lblHighScore1Ordinal.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblHighScore1Ordinal = new GridBagConstraints();
		gbc_lblHighScore1Ordinal.anchor = GridBagConstraints.EAST;
		gbc_lblHighScore1Ordinal.insets = new Insets(0, 0, 5, 5);
		gbc_lblHighScore1Ordinal.gridx = 0;
		gbc_lblHighScore1Ordinal.gridy = 1;
		panelGridBagPanel.add(lblHighScore1Ordinal, gbc_lblHighScore1Ordinal);
		
		lblHighScore1Name = new JLabel( highScoresList.get( 0 ).getName() );
		lblHighScore1Name.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblHighScore1Name = new GridBagConstraints();
		gbc_lblHighScore1Name.anchor = GridBagConstraints.WEST;
		gbc_lblHighScore1Name.insets = new Insets(0, 0, 5, 5);
		gbc_lblHighScore1Name.gridx = 2;
		gbc_lblHighScore1Name.gridy = 1;
		panelGridBagPanel.add(lblHighScore1Name, gbc_lblHighScore1Name);
		
		lblHighScore1Apples = new JLabel( String.format( "%,d", highScoresList.get( 0 ).getApples() ) );
		lblHighScore1Apples.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblHighScore1Apples = new GridBagConstraints();
		gbc_lblHighScore1Apples.anchor = GridBagConstraints.EAST;
		gbc_lblHighScore1Apples.insets = new Insets(0, 0, 5, 5);
		gbc_lblHighScore1Apples.gridx = 4;
		gbc_lblHighScore1Apples.gridy = 1;
		panelGridBagPanel.add(lblHighScore1Apples, gbc_lblHighScore1Apples);
		
		lblHighScore1Points = new JLabel( String.format( "%,d", highScoresList.get( 0 ).getPoints() ) );
		lblHighScore1Points.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblHighScore1Points = new GridBagConstraints();
		gbc_lblHighScore1Points.anchor = GridBagConstraints.EAST;
		gbc_lblHighScore1Points.insets = new Insets(0, 0, 5, 0);
		gbc_lblHighScore1Points.gridx = 6;
		gbc_lblHighScore1Points.gridy = 1;
		panelGridBagPanel.add(lblHighScore1Points, gbc_lblHighScore1Points);
	}

	private void gridBagPanel() {
		panelHighScoresFlowPanel = new JPanel();
		highScoresPanel.add(panelHighScoresFlowPanel, BorderLayout.SOUTH);
		panelHighScoresFlowPanel.setBackground( Color.DARK_GRAY );
		panelHighScoresFlowPanel.setForeground(Color.WHITE);
		panelHighScoresFlowPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		panelGridBagPanel = new JPanel();
		panelHighScoresFlowPanel.add(panelGridBagPanel);
		GridBagLayout gbl_panelGridBagPanel = new GridBagLayout();
		gbl_panelGridBagPanel.columnWidths = new int[]{0, 5, 0, 5, 0, 5, 0, 0};
		gbl_panelGridBagPanel.rowHeights = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelGridBagPanel.columnWeights = new double[]{0.0, 5.0, 0.0, 5.0, 0.0, 5.0, 0.0, Double.MIN_VALUE};
		gbl_panelGridBagPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		panelGridBagPanel.setLayout(gbl_panelGridBagPanel);
		panelGridBagPanel.setBackground( Color.DARK_GRAY );
	}

	private void title() {
		lblHighScores = new JLabel("High Scores");
		lblHighScores.setVerticalAlignment(SwingConstants.TOP);
		lblHighScores.setHorizontalTextPosition(SwingConstants.CENTER);
		lblHighScores.setHorizontalAlignment(SwingConstants.CENTER);
		lblHighScores.setFont(new Font("Marker Felt", Font.BOLD, 40));
		lblHighScores.setForeground(Color.RED);
		highScoresPanel.add(lblHighScores, BorderLayout.NORTH);
	}

	private void Headers() {
		lblHighScoresName = new JLabel("Name");
		lblHighScoresName.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		lblHighScoresName.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblHighScoresName = new GridBagConstraints();
		gbc_lblHighScoresName.anchor = GridBagConstraints.WEST;
		gbc_lblHighScoresName.insets = new Insets(0, 0, 5, 5);
		gbc_lblHighScoresName.gridx = 2;
		gbc_lblHighScoresName.gridy = 0;
		panelGridBagPanel.add(lblHighScoresName, gbc_lblHighScoresName);
		
		lblHighScoresApples = new JLabel("Apples");
		lblHighScoresApples.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		lblHighScoresApples.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblHighScoresApples = new GridBagConstraints();
		gbc_lblHighScoresApples.anchor = GridBagConstraints.EAST;
		gbc_lblHighScoresApples.insets = new Insets(0, 0, 5, 5);
		gbc_lblHighScoresApples.gridx = 4;
		gbc_lblHighScoresApples.gridy = 0;
		panelGridBagPanel.add(lblHighScoresApples, gbc_lblHighScoresApples);
		
		lblHighScoresPoints = new JLabel("Points");
		lblHighScoresPoints.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		lblHighScoresPoints.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblHighScoresPoints = new GridBagConstraints();
		gbc_lblHighScoresPoints.anchor = GridBagConstraints.EAST;
		gbc_lblHighScoresPoints.insets = new Insets(0, 0, 5, 0);
		gbc_lblHighScoresPoints.gridx = 6;
		gbc_lblHighScoresPoints.gridy = 0;
		panelGridBagPanel.add(lblHighScoresPoints, gbc_lblHighScoresPoints);
	}
}
