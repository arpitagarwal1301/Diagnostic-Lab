import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class AddCategory extends JFrame implements  ActionListener
{
	JPanel pHeadAddCat,pCenterAddCat,pEast;
	JLabel lHeadAddCat,lDeptName,lCatName;
	JComboBox cDepName;
	JTextField tCatName;
	JButton ok,cancel;
	Container content;
	public AddCategory()
	{
		setSize((int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth()),(int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight())-40);
		setResizable(false);
		setTitle("Add Category");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		//Creating Panels.
    	pHeadAddCat=new JPanel(new FlowLayout(FlowLayout.CENTER,60,60));
    	pHeadAddCat.setBackground(new Color(134,134,234));
		pCenterAddCat=new JPanel(new GridBagLayout());
    	pCenterAddCat.setBackground(new Color(211,248,253));
		pEast=new JPanel(new GridBagLayout());
		pEast.setBackground(new Color(211,248,253));
		//Creatin LabelS.
		lHeadAddCat=new JLabel("ADD CATEGORY");
		lHeadAddCat.setForeground(Color.WHITE);
		Font f2=new Font("Papyrus",Font.BOLD,36);
		lHeadAddCat.setFont(f2);

		lDeptName=new JLabel("Department Name");
		Font f1=new Font("Goudy Old Style",Font.BOLD,16);
		lDeptName.setFont(f1);
		lCatName=new JLabel("Category Name");
		lCatName.setFont(f1);
		//Creating ComboBox.
		cDepName=new JComboBox();
		//Creating Text Field.
		tCatName=new JTextField(14);
		//Creating Buttons.
		ok=new JButton("OK");

		ok.setFont(f1);
		cancel=new JButton("BACK");
		cancel.setFont(f1);
		
			//Adding Icon on top-left.
		ImageIcon img = new ImageIcon("pics/logo.jpg");
		this.setIconImage(img.getImage());

		//Adding image in West panel
		Icon i=new ImageIcon("pics/url1.jpg");
		JLabel l1=new JLabel(i);
		GridBagConstraints gc=new GridBagConstraints();
		gc.fill = GridBagConstraints.NONE;
		gc.gridx = 2;
		gc.gridwidth = 1;
		gc.gridy = 1;
		gc.ipadx = 20;
		gc.ipady = 0;
		gc.weightx = 0;
		gc.weighty = 0;
		gc.anchor = GridBagConstraints.WEST;
		gc.insets=new Insets(0,0,20,0);
		pEast.add(l1,gc);

		content=getContentPane();
		//For Label Department Name.
		gc=new GridBagConstraints();
		gc.fill = GridBagConstraints.NONE;
		gc.gridx = 1;
		gc.gridwidth = 1;
		gc.gridy = 1;
		gc.ipadx = 0;
		gc.ipady = 0;
		gc.weightx = 0;
		gc.weighty = 0;
		gc.anchor = GridBagConstraints.CENTER;
		gc.insets=new Insets(0,0,20,20);
		pCenterAddCat.add(lDeptName,gc);

		//For Combo Box..
		gc=new GridBagConstraints();
		cDepName.addItem("select department");
		gc.fill = GridBagConstraints.NONE;
		gc.gridx = 2;
		gc.gridwidth = 2;
		gc.gridy = 1;
		gc.ipadx = 125;
		gc.ipady = 0;
		gc.weightx = 0;
		gc.weighty = 0;
		gc.anchor = GridBagConstraints.CENTER;
		gc.insets=new Insets(0,0,20,20);

		pCenterAddCat.add(cDepName,gc);
		cDepName.addActionListener(this);
		try
		{
			Connection con=JDBCConnection.getConnection();
			PreparedStatement pstmt=con.prepareStatement("select dept_name from department");
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				cDepName.addItem(rs.getString("dept_name"));
			}

		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}



		//For Label Category name.
		gc=new GridBagConstraints();
		gc.fill = GridBagConstraints.NONE;
		gc.gridx = 1;
		gc.gridwidth = 1;
		gc.gridy = 2;
		gc.ipadx = 0;
		gc.ipady = 0;
		gc.weightx = 0;
		gc.weighty = 0;
		gc.anchor = GridBagConstraints.CENTER;
		gc.insets=new Insets(0,0,20,20);
		pCenterAddCat.add(lCatName,gc);

		//For Text Field Category Name.
		gc=new GridBagConstraints();
		gc.fill = GridBagConstraints.NONE;
		gc.gridx = 2;
		gc.gridwidth = 2;
		gc.gridy = 2;
		gc.ipadx = 0;
		gc.ipady = 0;
		gc.weightx = 0;
		gc.weighty = 0;
		gc.anchor = GridBagConstraints.CENTER;
		gc.insets=new Insets(0,0,20,20);
		pCenterAddCat.add(tCatName,gc);

		//For button OK.
		gc=new GridBagConstraints();
		gc.fill = GridBagConstraints.NONE;
		gc.gridx = 2;
		gc.gridwidth = 1;
		gc.gridy = 3;
		gc.ipadx = 0;
		gc.ipady = 0;
		gc.weightx = 0;
		gc.weighty = 0;
		gc.anchor = GridBagConstraints.CENTER;
		gc.insets=new Insets(0,0,20,20);
		pCenterAddCat.add(ok,gc);
		ok.addActionListener(this);

		//For button cancel.
		gc=new GridBagConstraints();
		gc.fill = GridBagConstraints.NONE;
		gc.gridx = 3;
		gc.gridwidth = 1;
		gc.gridy = 3;
		gc.ipadx = 0;
		gc.ipady = 0;
		gc.weightx = 0;
		gc.weighty = 0;
		gc.anchor = GridBagConstraints.CENTER;
		gc.insets=new Insets(0,0,20,20);
		pCenterAddCat.add(cancel,gc);
		cancel.addActionListener(this);

		//For Header Label.
		pHeadAddCat.add(lHeadAddCat);

		content.add(pHeadAddCat,BorderLayout.NORTH);
		content.add(pCenterAddCat,BorderLayout.CENTER);
		content.add(pEast,BorderLayout.EAST);

		setVisible(true);

	}
	public void actionPerformed(ActionEvent ae)
	{
		String dept_name=null;
		int dept_id=0;
		try
		{
			dept_name=String.valueOf(cDepName.getSelectedItem());
			Connection con =JDBCConnection.getConnection();
			PreparedStatement pstmt1=con.prepareStatement("select dept_id from department where dept_name=?");
			pstmt1.setString(1,dept_name);
			ResultSet rs=pstmt1.executeQuery();
			if(rs.next())
			{
				dept_id=rs.getInt("dept_id");
			}
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		if(ae.getSource()==ok)
		{
			if(String.valueOf(cDepName.getSelectedItem()).equals("select department"))
			{
				JOptionPane.showMessageDialog(this,"Select a proper department","Warning",JOptionPane.WARNING_MESSAGE);
				tCatName.setText(null);
				return;
			}

			if(tCatName.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this,"Enetr a category . . !","Warning",JOptionPane.WARNING_MESSAGE);
				return;
			}

			try
			{
			  Connection con=JDBCConnection.getConnection();
				PreparedStatement pstmt=con.prepareStatement("select cat_name from category where dept_id=?");
				pstmt.setInt(1,dept_id);
				ResultSet rs=pstmt.executeQuery();
				while(rs.next())
				{
					if(tCatName.getText().equals(rs.getString("cat_name")))
					{
						JOptionPane.showMessageDialog(this,"Category already exists!!","warning",JOptionPane.WARNING_MESSAGE);
						tCatName.setText(null);
						return;
					}
				}
			}
			catch(SQLException p)
			{
				p.printStackTrace();
			}
			try
			{
			   Connection con=JDBCConnection.getConnection();
				PreparedStatement pstmt=con.prepareStatement("insert into category values(cat_id.nextval,?,?)");
				pstmt.setInt(1,dept_id);
				pstmt.setString(2,tCatName.getText());

				int a=pstmt.executeUpdate();
				if(a>0)
				{
					JOptionPane.showMessageDialog(this,"category successfully added");
					tCatName.setText(null);
					return;
				}
			}
			catch(SQLException b)
			{
				b.printStackTrace();
			}
		}

		if(ae.getSource()==cancel)
		{
			this.dispose();
			new HomePage();
		}
	}
	
}