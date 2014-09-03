import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DefaultCaret;

import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JTextArea;

import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class ElInterface extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtMessage;
	private JTextArea chat;
	private DefaultCaret caret;
	private static String history="Elisoa : Bonjour ! Je m'appelle Elisoa."+'\n'+'\r';

	public static void main(String[] args){
		
	}
	
	public ElInterface() {
		setTitle("Elisoa");
		createWindow();
		
	}
	
	private void createWindow(){
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(880, 550);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{28, 815, 30, 7};
		gbl_contentPane.rowHeights = new int[]{25, 485, 40};
		contentPane.setLayout(gbl_contentPane);
		
		chat = new JTextArea();
		chat.setEditable(false);
		chat.setLineWrap(true);
		chat.setText("Elisoa : Bonjour ! Je m'appelle Elisoa."+'\n'+'\r');
		JScrollPane scroll = new JScrollPane(chat);
		caret = (DefaultCaret) chat.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		GridBagConstraints scrollConstraints = new GridBagConstraints();
		scrollConstraints.insets = new Insets(0, 0, 5, 5);
		scrollConstraints.fill = GridBagConstraints.BOTH;
		scrollConstraints.gridx = 0;
		scrollConstraints.gridy = 0;
		scrollConstraints.gridwidth = 3;
		scrollConstraints.gridheight = 2;
		scrollConstraints.weightx = 1;
		scrollConstraints.weighty = 1;
		scrollConstraints.insets = new Insets(0, 5, 0, 0);
		contentPane.add(scroll, scrollConstraints);

		txtMessage = new JTextField();
		txtMessage.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					send(txtMessage.getText(), true);
				}
			}
		});
		
		GridBagConstraints gbc_txtMessage = new GridBagConstraints();
		gbc_txtMessage.insets = new Insets(0, 0, 0, 5);
		gbc_txtMessage.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtMessage.gridx = 0;
		gbc_txtMessage.gridy = 2;
		gbc_txtMessage.gridwidth = 2;
		gbc_txtMessage.weightx = 1;
		gbc_txtMessage.weighty = 0;
		contentPane.add(txtMessage, gbc_txtMessage);
		txtMessage.setColumns(10);
		
		JButton btnEntrer = new JButton("Entrer");
		btnEntrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				send(txtMessage.getText(), true);
			}
		});
		GridBagConstraints gbc_btnEntrer = new GridBagConstraints();
		gbc_btnEntrer.insets = new Insets(0, 0, 0, 5);
		gbc_btnEntrer.gridx = 2;
		gbc_btnEntrer.gridy = 2;
		gbc_btnEntrer.weightx = 0;
		gbc_btnEntrer.weighty = 0;
		contentPane.add(btnEntrer, gbc_btnEntrer);
		
		setVisible(true);
		
		txtMessage.requestFocusInWindow();
	}

	private void send(String text, boolean b) {
		if (text.equals("")) return;
		if (b) {
			String reponse="Elisoa : "+repond(text)+'\n'+'\r';
			text = "Moi : " + text;
			history=history+text+'\n'+'\r';
			txtMessage.setText("");
			
			chat.setText(history);
			
			history=history+reponse;
			chat.setText(history);
		}
		
		
	}
	
	private String repond(String text){
		if(text!=null){
            return text.toLowerCase();
        }
        else{
            return"fail";
        }
	}

	


}
