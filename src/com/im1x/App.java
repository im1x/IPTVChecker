package com.im1x;

import java.awt.EventQueue;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * 
 * @author Vitaly Batrakov
 *
 */
public class App {

	private JFrame frmIptvCheckerV;
	private JTextField textOutputD;
	private JTextField textInputD;
	private JLabel lblAll;
	private JLabel lblGood;
	private JLabel lblDup;
	private JLabel lblPass;
	private JLabel lblBad;
	static App window;
	private JButton btnWork;
	private JCheckBox chckbxCanalNames;
	private JSpinner spinner;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new App();
					window.frmIptvCheckerV.setLocationRelativeTo(null);
					window.frmIptvCheckerV.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public App() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmIptvCheckerV = new JFrame();
		frmIptvCheckerV.setTitle("IPTV Checker v0.1");
		frmIptvCheckerV.setBounds(100, 100, 358, 313);
		frmIptvCheckerV.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{220, 220, 220, 220, 220, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 22, 0, 0, 44, 27, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frmIptvCheckerV.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Input directory");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 4;
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		gbc_lblNewLabel.insets = new Insets(10, 10, 5, 5);
		frmIptvCheckerV.getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_5 = new JLabel("<html><a href=\"\">Help</a></html");
		lblNewLabel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(frmIptvCheckerV, "<html> <font size='4'><center>IPTV Checker</center></font></a> <br> Program to check the relevance of the playlists for IPTV <br> Autor: Vitaly Batrakov (E-Mail: vetal_8888@mail.ru)	</html>");
			}
		});
		lblNewLabel_5.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 10);
		gbc_lblNewLabel_5.gridx = 4;
		gbc_lblNewLabel_5.gridy = 0;
		frmIptvCheckerV.getContentPane().add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		textInputD = new JTextField();
		GridBagConstraints gbc_textInputD = new GridBagConstraints();
		gbc_textInputD.gridwidth = 4;
		gbc_textInputD.insets = new Insets(0, 10, 5, 5);
		gbc_textInputD.fill = GridBagConstraints.HORIZONTAL;
		gbc_textInputD.gridx = 0;
		gbc_textInputD.gridy = 1;
		frmIptvCheckerV.getContentPane().add(textInputD, gbc_textInputD);
		textInputD.setColumns(10);
		//set dir
		textInputD.setText(System.getProperty("user.dir") + System.getProperty("file.separator") + "input");
		
		final JButton btnInputD = new JButton("...");
		btnInputD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final JFileChooser fc = new JFileChooser();
				fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				int result = fc.showOpenDialog(btnInputD);
	            if (result != JFileChooser.CANCEL_OPTION) {
	            	 File dir = fc.getSelectedFile();
	            	textInputD.setText(dir.getAbsolutePath());
	            }
			}
		});
		GridBagConstraints gbc_btnInputD = new GridBagConstraints();
		gbc_btnInputD.insets = new Insets(0, 0, 5, 10);
		gbc_btnInputD.gridx = 4;
		gbc_btnInputD.gridy = 1;
		frmIptvCheckerV.getContentPane().add(btnInputD, gbc_btnInputD);
		
		JLabel lblNewLabel_1 = new JLabel("Output directory");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.gridwidth = 4;
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.insets = new Insets(10, 10, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 3;
		frmIptvCheckerV.getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		textOutputD = new JTextField();
		GridBagConstraints gbc_textOutputD = new GridBagConstraints();
		gbc_textOutputD.gridwidth = 4;
		gbc_textOutputD.insets = new Insets(0, 10, 5, 5);
		gbc_textOutputD.fill = GridBagConstraints.HORIZONTAL;
		gbc_textOutputD.gridx = 0;
		gbc_textOutputD.gridy = 4;
		frmIptvCheckerV.getContentPane().add(textOutputD, gbc_textOutputD);
		textOutputD.setColumns(10);
		//set dir
		textOutputD.setText(System.getProperty("user.dir") + System.getProperty("file.separator") + "output" + System.getProperty("file.separator") + "playlist.m3u");
		
		JButton btnOutputD = new JButton("...");
		btnOutputD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final JFileChooser fc = new JFileChooser();
				//fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				fc.setSelectedFile(new File("playlist.m3u"));
				FileFilter filter = new FileNameExtensionFilter("PlayList (m3u)", "m3u");
				fc.setAcceptAllFileFilterUsed(false);
				fc.addChoosableFileFilter(filter);
				int result = fc.showOpenDialog(btnInputD);
	            if (result != JFileChooser.CANCEL_OPTION) {
	            	File dir = fc.getSelectedFile();
			    	textOutputD.setText(dir.getAbsolutePath());
			    }
			}
		});
		GridBagConstraints gbc_btnOutputD = new GridBagConstraints();
		gbc_btnOutputD.insets = new Insets(0, 0, 5, 10);
		gbc_btnOutputD.gridx = 4;
		gbc_btnOutputD.gridy = 4;
		frmIptvCheckerV.getContentPane().add(btnOutputD, gbc_btnOutputD);
		
		chckbxCanalNames = new JCheckBox("Check for duplicate channel names");
		chckbxCanalNames.setToolTipText("If not selected, the comparison is only URL");
		chckbxCanalNames.setFont(new Font("Tahoma", Font.PLAIN, 11));
		GridBagConstraints gbc_chckbxCanalNames = new GridBagConstraints();
		gbc_chckbxCanalNames.anchor = GridBagConstraints.WEST;
		gbc_chckbxCanalNames.gridwidth = 3;
		gbc_chckbxCanalNames.insets = new Insets(0, 5, 5, 5);
		gbc_chckbxCanalNames.gridx = 0;
		gbc_chckbxCanalNames.gridy = 6;
		frmIptvCheckerV.getContentPane().add(chckbxCanalNames, gbc_chckbxCanalNames);
		
		JLabel lblTimeoutms = new JLabel("Timeout (ms)");
		lblTimeoutms.setFont(new Font("Tahoma", Font.PLAIN, 11));
		GridBagConstraints gbc_lblTimeoutms = new GridBagConstraints();
		gbc_lblTimeoutms.anchor = GridBagConstraints.EAST;
		gbc_lblTimeoutms.insets = new Insets(0, 0, 5, 5);
		gbc_lblTimeoutms.gridx = 3;
		gbc_lblTimeoutms.gridy = 6;
		frmIptvCheckerV.getContentPane().add(lblTimeoutms, gbc_lblTimeoutms);
		
		spinner = new JSpinner();
		spinner.setFont(new Font("Tahoma", Font.PLAIN, 11));
		spinner.setModel(new SpinnerNumberModel(new Integer(750), new Integer(1), null, new Integer(10)));
		spinner.setToolTipText("");
		GridBagConstraints gbc_spinner = new GridBagConstraints();
		gbc_spinner.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinner.insets = new Insets(0, 0, 5, 10);
		gbc_spinner.gridx = 4;
		gbc_spinner.gridy = 6;
		frmIptvCheckerV.getContentPane().add(spinner, gbc_spinner);
		
		JLabel lblNewLabel_3 = new JLabel("");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.gridwidth = 3;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 7;
		frmIptvCheckerV.getContentPane().add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 5;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 8;
		frmIptvCheckerV.getContentPane().add(panel, gbc_panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnWork = new JButton("Work");
		btnWork.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setLblAll(0);
				setLblBad(0);
				setLblDup(0);
				setLblGood(0);
				setLblPass(0);
				btnWork.setEnabled(false);
				
				StreamChecker streamChecker = new StreamChecker();
				streamChecker.setInputDir(getTextInputD());
				streamChecker.setOutputDir(getTextOutputD());
				new Thread(streamChecker).start();
			}
		});
		btnWork.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnWork.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(btnWork);
		
		JLabel lblNewLabel_2 = new JLabel("All");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.SOUTH;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 9;
		frmIptvCheckerV.getContentPane().add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("Good");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.SOUTH;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 1;
		gbc_lblNewLabel_4.gridy = 9;
		frmIptvCheckerV.getContentPane().add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		JLabel lblNewLabel_6 = new JLabel("Duplicate");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.SOUTH;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 2;
		gbc_lblNewLabel_6.gridy = 9;
		frmIptvCheckerV.getContentPane().add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		JLabel lblNewLabel_8 = new JLabel("Password");
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.anchor = GridBagConstraints.SOUTH;
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_8.gridx = 3;
		gbc_lblNewLabel_8.gridy = 9;
		frmIptvCheckerV.getContentPane().add(lblNewLabel_8, gbc_lblNewLabel_8);
		
		JLabel lblNewLabel_10 = new JLabel("Bad");
		GridBagConstraints gbc_lblNewLabel_10 = new GridBagConstraints();
		gbc_lblNewLabel_10.anchor = GridBagConstraints.SOUTH;
		gbc_lblNewLabel_10.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_10.gridx = 4;
		gbc_lblNewLabel_10.gridy = 9;
		frmIptvCheckerV.getContentPane().add(lblNewLabel_10, gbc_lblNewLabel_10);
		
		lblAll = new JLabel("0");
		GridBagConstraints gbc_lblAll = new GridBagConstraints();
		gbc_lblAll.anchor = GridBagConstraints.NORTH;
		gbc_lblAll.insets = new Insets(0, 0, 0, 5);
		gbc_lblAll.gridx = 0;
		gbc_lblAll.gridy = 10;
		frmIptvCheckerV.getContentPane().add(lblAll, gbc_lblAll);
		
		lblGood = new JLabel("0");
		GridBagConstraints gbc_lblGood = new GridBagConstraints();
		gbc_lblGood.anchor = GridBagConstraints.NORTH;
		gbc_lblGood.insets = new Insets(0, 0, 0, 5);
		gbc_lblGood.gridx = 1;
		gbc_lblGood.gridy = 10;
		frmIptvCheckerV.getContentPane().add(lblGood, gbc_lblGood);
		
		lblDup = new JLabel("0");
		GridBagConstraints gbc_lblDup = new GridBagConstraints();
		gbc_lblDup.anchor = GridBagConstraints.NORTH;
		gbc_lblDup.insets = new Insets(0, 0, 0, 5);
		gbc_lblDup.gridx = 2;
		gbc_lblDup.gridy = 10;
		frmIptvCheckerV.getContentPane().add(lblDup, gbc_lblDup);
		
		lblPass = new JLabel("0");
		GridBagConstraints gbc_lblPass = new GridBagConstraints();
		gbc_lblPass.anchor = GridBagConstraints.NORTH;
		gbc_lblPass.insets = new Insets(0, 0, 0, 5);
		gbc_lblPass.gridx = 3;
		gbc_lblPass.gridy = 10;
		frmIptvCheckerV.getContentPane().add(lblPass, gbc_lblPass);
		
		lblBad = new JLabel("0");
		GridBagConstraints gbc_lblBad = new GridBagConstraints();
		gbc_lblBad.anchor = GridBagConstraints.NORTH;
		gbc_lblBad.gridx = 4;
		gbc_lblBad.gridy = 10;
		frmIptvCheckerV.getContentPane().add(lblBad, gbc_lblBad);
	}

	
	//setters and getters
	
	public int getLblAll() {
		return Integer.valueOf(lblAll.getText());
	}

	public void setLblAll(int lblAll) {
		this.lblAll.setText(String.valueOf(lblAll));
	}

	public int getLblGood() {
		return Integer.valueOf(lblGood.getText());
	}

	public void setLblGood(int lblGood) {
		this.lblGood.setText(String.valueOf(lblGood));
	}

	public int getLblDup() {
		return Integer.valueOf(lblDup.getText());
	}

	public void setLblDup(int lblDup) {
		this.lblDup.setText(String.valueOf(lblDup));
	}

	public int getLblPass() {
		return Integer.valueOf(lblPass.getText());
	}

	public void setLblPass(int lblPass) {
		this.lblPass.setText(String.valueOf(lblPass));
	}

	public int getLblBad() {
		return Integer.valueOf(lblBad.getText());
	}

	public void setLblBad(int lblBad) {
		this.lblBad.setText(String.valueOf(lblBad));
	}

	public String getTextOutputD() {
		return textOutputD.getText();
	}

	public String getTextInputD() {
		return textInputD.getText();
	}
	
	public void btnSetEnabled() {
		btnWork.setEnabled(true);
	}
	
	public boolean getCheckCanelNames() {
		return chckbxCanalNames.isSelected();
	}
	
	public int getTimeout() {
		return (Integer)spinner.getValue();
	}
	
}
