package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import PersonAll.PersonAD;

public class WindowDialog extends JDialog
{

	PersonAD dm = new PersonAD();

	public boolean isOk = false;
	public boolean isCancel = false;
	public static JTextField idtxt;
	public static JTextField fnametxt;
	public static JTextField lnametxt;
	public static JTextField agetxt;
	public String strId;
	public String strFname;
	public String strflname;
	public String strAge;
	static String choice;

	public WindowDialog () 
	{
		setLayout(null);
		setModal(true);

//		if ( pPanel.tb.getSelectedRow()==-1)
//		{
//			strId = "";
//			strFname = "";
//			strflname = "";
//			strAge = "";
//		}
//		else {
//			strId = pPanel.tb.getModel().getValueAt(pPanel.tb.getSelectedRow(), 0).toString();
//			strFname =  pPanel.tb.getModel().getValueAt(pPanel.tb.getSelectedRow(), 1).toString();
//			strflname = pPanel.tb.getModel().getValueAt(pPanel.tb.getSelectedRow(), 2).toString();
//			strAge = pPanel.tb.getModel().getValueAt(pPanel.tb.getSelectedRow(), 3).toString();
//		}
		

		//////////////////////////////////////////////////
		//// добавление надписей 
		////////////////////////////////////////////////////

		JLabel idLb = new JLabel("ID:", JLabel.RIGHT);
		idLb.setBounds( 0, 10, 50, 30);
		add(idLb);

		idtxt = new JTextField();
		idtxt.setBounds( 90, 10, 190, 25 );
		add( idtxt );

		JLabel fnameLb = new JLabel("First Name:", JLabel.RIGHT);
		fnameLb.setBounds( 0, 60, 80, 30);
		add(fnameLb);

		fnametxt = new JTextField();
		fnametxt.setBounds( 90, 60, 190, 25 );
		add( fnametxt );

		JLabel lnameLb = new JLabel("Last Name:", JLabel.RIGHT);
		lnameLb.setBounds( 0, 110, 80, 30);
		add(lnameLb);

		lnametxt = new JTextField();
		lnametxt.setBounds( 90, 110, 190, 25 );
		add( lnametxt );

		JLabel ageLb = new JLabel("Age:", JLabel.RIGHT);
		ageLb.setBounds( -20, 160, 80, 30);
		add(ageLb);

		agetxt = new JTextField();
		agetxt.setBounds( 90, 160, 190, 25 );
		add( agetxt );

		JButton btnOk = new JButton("OK");
		btnOk.setBounds(10, 250, 120, 60);
//		btnOk.addActionListener( dm.aOk );
		btnOk.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				isOk = true;
				setVisible(false);
			}
		});
		add ( btnOk );
		

		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(150, 250, 120, 60);
//		btnCancel.addActionListener( dm.aCancel );
		btnCancel.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		add ( btnCancel );
		
//		setModal(true);

		setTitle(" Person Data Base ");
		setBounds(575, 160, 300, 380);
		setVisible(true);
	}
}
