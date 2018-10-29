package ui;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import PersonAll.PersonAD;

public class pButton extends JPanel
{
	public static JComboBox comBox;
	public static String items;
	PersonAD dm = null;

	public pButton ( PersonAD dm )
	{
		this.dm = dm;
		setLayout(null);

		
//		//////////////////////////////////////////////////
//		// добавление надписей 
//		//////////////////////////////////////////////////
//
//		JLabel idLb = new JLabel("ID:", JLabel.RIGHT);
//		idLb.setBounds( 0, 10, 50, 30);
//		add(idLb);
//
//		idtxt = new JTextField();
//		idtxt.setBounds( 90, 10, 190, 25 );
//		add( idtxt );
//
//		JLabel fnameLb = new JLabel("First Name:", JLabel.RIGHT);
//		fnameLb.setBounds( 0, 60, 80, 30);
//		add(fnameLb);
//
//		fnametxt = new JTextField();
//		fnametxt.setBounds( 90, 60, 190, 25 );
//		add( fnametxt );
//
//		JLabel lnameLb = new JLabel("Last Name:", JLabel.RIGHT);
//		lnameLb.setBounds( 0, 110, 80, 30);
//		add(lnameLb);
//
//		lnametxt = new JTextField();
//		lnametxt.setBounds( 90, 110, 190, 25 );
//		add( lnametxt );
//
//		JLabel ageLb = new JLabel("Age:", JLabel.RIGHT);
//		ageLb.setBounds( -20, 160, 80, 30);
//		add(ageLb);
//
//		agetxt = new JTextField();
//		agetxt.setBounds( 90, 160, 190, 25 );
//		add( agetxt );
		
		String [] items = {"--Выберете базу данных--", "Person", "MySQL", "H2", "JSON", "XML", "YAML", "CSV"};
		
		comBox = new JComboBox(items);
		comBox.setBounds(50,50,200,30);
		comBox.addActionListener(dm.aBox);
		add( comBox );

		//////////////////////////////////////////////////
		// добавление кнопок
		//////////////////////////////////////////////////

		JButton buttonCreate = new JButton("Create");
		buttonCreate.setBounds(20, 220, 120, 60);
		add( buttonCreate );
		buttonCreate.addActionListener(dm.aCreate);

		JButton buttonRead = new JButton("Read");
		add(buttonRead) ;
		buttonRead.setBounds( 160, 220, 120, 60 );
		buttonRead.addActionListener(dm.aRead);

		JButton buttonUpData = new JButton("UpData");
		add(buttonUpData) ;
		buttonUpData.setBounds(20, 300, 120, 60);
		buttonUpData.addActionListener(dm.aUpDate); 

		JButton buttonDelete = new JButton("Delete");
		add(buttonDelete) ;
		buttonDelete.setBounds(160, 300, 120, 60);
		buttonDelete.addActionListener(dm.aDelete); 
	}

}
