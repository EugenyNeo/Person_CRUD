package PersonAll;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.AbstractTableModel;
import ui.*;

public class PersonAD extends AbstractTableModel
{
	public static ArrayList<Person> data = new ArrayList<Person>();
	static PersonDAO pd;
	static ImportExport ie;

	public ActionComboBox aBox = new ActionComboBox();
	public ActionCreate aCreate = new ActionCreate();
	public ActionRead aRead = new ActionRead();
	public ActionUpDate aUpDate = new ActionUpDate();
	public ActionDelete aDelete = new ActionDelete();
	public ActionSave aSave = new ActionSave();
	public ActionOpen aOpen = new ActionOpen();

	
	static WindowDialog newWind;
	static String BD;
	static File file;
	
	class ActionSave implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0) 
		{
			
		}
	}
	
	class ActionOpen implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			file = null;
			JFileChooser openFile = new JFileChooser();
			openFile.setCurrentDirectory(new File("C:\\"));
			FileNameExtensionFilter filter = new FileNameExtensionFilter("csv, json, xml, yml", new String[] {"csv", "json", "xml", "yml"});
			openFile.setFileFilter(filter);
			openFile.setAcceptAllFileFilterUsed(false);
			
			int ret = openFile.showDialog(null, "Import");
			if ( ret == JFileChooser.APPROVE_OPTION )
			{
				file = openFile.getSelectedFile();
				ie = IESelect.getIE(file, ImpExp_JSON.pp);
				data = ie.load();
				System.out.println( data + " - data");
//				for (Person person : data)
//				{
//					System.out.println(person);
//				}
				fireTableDataChanged();
			}
			else 
				JOptionPane.showMessageDialog(null, "zx");
		}
	}

	class ActionComboBox implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			pButton.comBox = (JComboBox)e.getSource();
			String item = (String) pButton.comBox.getSelectedItem();
		
			switch ( item ) 
			{
			case "Person" : pd = new PersonDAO_Mock(); 
			BD = "Mock";
			reload();
			break;
			case "MySQL" : pd = new PersonDAO_SQL(); 
			BD = "MySQL";
			reload();
			break;
			case "H2" : pd = new PersonDAO_H2(); 
			BD = "H2";
			reload();
			break;
			case "JSON": pd = new PersonDAO_JSON();
			BD = "JSON";
			reload();
			break;
			case "XML": pd = new PersonDAO_XML();
			BD = "XML";
			reload();
			break;
			case "YAML": pd = new PersonDAO_YAML();
			BD = "YAML";
			reload();
			break;
			case "CSV": pd = new PersonDAO_CSV();
			BD = "CSV";
			reload();
			break;
			}
		}
	}

	@Override // колонки 
	public int getColumnCount() 
	{
		return 4;
	}

	@Override // строки
	public int getRowCount() 
	{
		return data.size();
	}

	@Override
	public String getColumnName(int column) 
	{
		String [] str = {"ID","First Name","Last Name", "Age"};
		return str[column];
	}

	@Override // запол таб
	public Object getValueAt ( int row, int col ) 
	{
		Person p = data.get( row );
		System.out.println( data.get( row ) + "XZZX");
		Object ret = null;

		switch ( col )
		{
		case 0: ret = p.id;         break;
		case 1: ret = p.fname;   break;
		case 2: ret = p.lname;   break;
		case 3: ret = p.age;      break;
		}
		reload();
		return ret;
	}

	class ActionCreate implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			newWind = new WindowDialog();
			if ( newWind.isOk == true )
			{
				int id = Integer.parseInt(WindowDialog.idtxt.getText());
				String fname = WindowDialog.fnametxt.getText();
				String lname = WindowDialog.lnametxt.getText();
				int age = Integer.parseInt(WindowDialog.agetxt.getText());
				Person p = new Person ( id, fname, lname, age );
					pd.create(p);
					reload();
			}
		}
	}

	class ActionRead implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
				data = pd.read();
				fireTableDataChanged();
				reload();
		}
	}

	class ActionUpDate implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			newWind = new WindowDialog();
			if ( newWind.isOk == true )
			{
				int id = Integer.parseInt( WindowDialog.idtxt.getText() );
				String fname = WindowDialog.fnametxt.getText();
				String lname = WindowDialog.lnametxt.getText();
				int age = Integer.parseInt( WindowDialog.agetxt.getText() );
				Person p = new Person(id, fname, lname, age);
//				int Selection = JOptionPane.showConfirmDialog(null, "Вы точно хотите изменить в базе данных - " +BD + ", персонну с id: " + p.id + " ?" );
//				if ( Selection == 0)
				{
					pd.update(p);
					reload();
				}
//				else if ( Selection == 1 || Selection == 2)
				{
//					return;
				}
			}
		}
	}

	class ActionDelete implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			newWind = new WindowDialog();
			if ( newWind.isOk == true )
			{
				int id = Integer.parseInt( WindowDialog.idtxt.getText() );
				String fname = WindowDialog.fnametxt.getText();
				String lname = WindowDialog.lnametxt.getText();
				int age = Integer.parseInt( WindowDialog.agetxt.getText() );
				Person p = new Person(id, fname, lname, age);
//				int Selection = JOptionPane.showConfirmDialog(null, "Вы хотите удалить с базы данных - " 
//						+BD+"," + "\n" + "персону с " +"id:"+ p.id + "\n" + 	"Все верно ?");
//				if ( Selection == 0)
				{
					pd.delete(p);		
					reload();
				}
//				else if ( Selection == 1 || Selection == 2)
				{
//					return;
				}
			}
		}
	}

	private void reload() 
	{
		data = pd.read();
		fireTableDataChanged();
	}

}
